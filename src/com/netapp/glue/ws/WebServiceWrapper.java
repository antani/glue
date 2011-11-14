/**
 * This class wraps the internals of calling WFA workflows
 * via their SOAP endpoint.
 * We use Authorization Policy to secure the credentials.
 * @author antani 
 */
package com.netapp.glue.ws;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//import org.apache.cxf.jaxrs.client.Client;
//import org.apache.cxf.jaxrs.client.Client;
import org.apache.cxf.configuration.security.AuthorizationPolicy;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;

public class WebServiceWrapper {
	 
    private static final String TIMEOUT_MS = "120000";
 
    private JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
 
    private String hostIp;
    private String userName;
    private String password;
 
    private Map<String, CachedClient> clientCache = new HashMap<String, CachedClient>();
 
    public WebServiceWrapper(String hostIp, String userName, String password) {
        this.hostIp = hostIp;
        this.userName = userName;
        this.password = password;
    }
 
    public Object[] invokeWebService(String serviceName, String operationName, Object... params) throws Exception {
        ClassLoader prevClassLoader = Thread.currentThread().getContextClassLoader();
 
        CachedClient cachedClient = getClient("http://" + hostIp + "/wfa-ws/" + serviceName + "?wsdl");
 
        try {
            return cachedClient.client.invoke(operationName, params);
 
        } catch (Exception e) {
            throw e;
 
        } finally {
 
            // Restore the original class loader
            Thread.currentThread().setContextClassLoader(prevClassLoader);
        }
       // return null;
    }
 
    @Override
    public String toString() {
        return "WebServiceWrapper{" +
                "hostIp='" + hostIp + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
 
    public String getHostIp() {
        return hostIp;
    }
 
    Map<String, CachedClient> getClientCache() {
        return Collections.unmodifiableMap(clientCache);
    }
 
    private CachedClient getClient(String wsdlUrl) {
        CachedClient cachedClient = clientCache.get(wsdlUrl);
 
        if (cachedClient == null) {
 
            cachedClient = new CachedClient(dcf.createClient(wsdlUrl));
            cachedClient.classLoader = Thread.currentThread().getContextClassLoader();
 
            AuthorizationPolicy authorization = ((HTTPConduit) cachedClient.client.getConduit()).getAuthorization();
            authorization.setUserName(userName);
            authorization.setPassword(password);
 
            cachedClient.client.getRequestContext().put("javax.xml.ws.client.receiveTimeout", TIMEOUT_MS);// 120 seconds
            cachedClient.client.getRequestContext().put("javax.xml.ws.client.connectionTimeout", TIMEOUT_MS);// 120 seconds
 
            clientCache.put(wsdlUrl, cachedClient);
        }
 
        else {
            // for existing client, restore's the client's class loader
            Thread.currentThread().setContextClassLoader(cachedClient.classLoader);
        }
 
        return cachedClient;
    }
 
    public class CachedClient {
 
        Client client;
 
        ClassLoader classLoader;
 
        public CachedClient(Client client) {
            this.client = client;
        }
 
        public Client getClient() {
            return client;
        }
 
    }
 
}
