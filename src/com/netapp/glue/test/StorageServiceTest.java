/**
 * This class tests the storage service APIs using new NaElement
 * and NaServer overridden by Glue.
 */
package com.netapp.glue.test;
import netapp.manage.*;

import java.io.*;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Iterator;
/**
 * @author antani
 *
 */
public class StorageServiceTest {
	private static NaServer server;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Connect to server
		try {
			server = new NaServer("10.72.64.247",1,0);
			server.setStyle(NaServer.STYLE_LOGIN_PASSWORD);
			server.setServerType(NaServer.SERVER_TYPE_DFM);
			server.setAdminUser("administrator", "netapp1!");

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list();

	}
	private static void list(){
		
		try {
			NaElement input = new NaElement("storage-service-list-info-iter-start");
			// invoke the api && capturing the records && tag values
            NaElement output = server.invokeElem(input);
		    // Extracting the record && tag values && printing them
            String records = output.getChildContent("records");
            if (records.equals("0"))
                System.out.println("\nNo policies to display");

            String tag = output.getChildContent("tag");
            // Extracting records one at a time
            input = new NaElement("storage-service-list-info-iter-next");
            input.addNewChild("maximum", records);
            input.addNewChild("tag", tag);
            NaElement record = server.invokeElem(input);

            NaElement stat = record.getChildByName("storage-services");
            List infoList = null;
            if (stat != null)
                infoList = stat.getChildren();
            if (infoList == null)
                return;
            Iterator infoIter = infoList.iterator();

            while (infoIter.hasNext()) {
                String value;
                NaElement info = (NaElement) infoIter.next();
                System.out.println("-------------------------------------");
                
                System.out.println("Service Name : " + info.getChildContent("storage-service-name"));
                System.out.println("      id : " + info.getChildContent("storage-service-id"));
                System.out.println("      Description : " + info.getChildContent("storage-service-description"));
                System.out.println("      Is DR capable : " + info.getChildContent("is-dr-capable"));
                System.out.println("      Service contact : " + info.getChildContent("storage-service-contact"));
                System.out.println("      Protection Policy : " + info.getChildContent("protection-policy-name"));
                System.out.println("      Prot Policy id : " + info.getChildContent("protection-policy-name"));
                System.out.println("      Storage Service Nodes : ");
                NaElement nodes = info.getChildByName("storage-service-nodes");
                List nodeInfoList = null;
                if (nodes != null)
                	nodeInfoList = nodes.getChildren();
                if (nodeInfoList == null)
                    return;
                
                Iterator nodeInfoIter = nodeInfoList.iterator();
                while(nodeInfoIter.hasNext()){
                	  NaElement nodeInfo = (NaElement) nodeInfoIter.next();
                	  System.out.println("                        DP Node id : " + nodeInfo.getChildContent("dp-node-id"));
                	  System.out.println("                        DP Node Name : " + nodeInfo.getChildContent("dp-node-name"));
                	  System.out.println("                        vFiler Template id : " + nodeInfo.getChildContent("vfiler-template-id"));
                	  System.out.println("                        vFiler Template name : " + nodeInfo.getChildContent("vfiler-template-name"));
                	  System.out.println("                        Resource Pools");
                	  
                	  NaElement rp = nodeInfo.getChildByName("resourcepools");
                      List rpList = null;
                      if (rp != null)
                          rpList = rp.getChildren();
                      if (rpList == null)
                          return;
                      Iterator rpIter = rpList.iterator();
                      while(rpIter.hasNext()){
                    	  
                    	  NaElement rpInfo = (NaElement) rpIter.next();
                    	  String rpId = rpInfo.getChildContent("resourcepool-id");
                    	  
                    	  if(rpId != null) {
	                    	  
	                    	  System.out.println("                              Resource Pool Id : " + rpId);
	                    	  System.out.println("                              Resource Pool Name : " + rpInfo.getChildContent("resourcepool-name"));
	                    	  
	                    	  NaElement inputRP = new NaElement("resourcepool-member-list-info-iter-start");
		                      inputRP.addNewChild("resourcepool-name-or-id",rpId );
		                      NaElement outputRP= server.invokeElem(inputRP);
		          		    // Extracting the record && tag values && printing them
		                      String recordsRP = outputRP.getChildContent("records");
		                      if (recordsRP.equals("0"))
		                          System.out.println("\nNo Resourcepools to display");
		
		                      String tagRP= outputRP.getChildContent("tag");
		                      // Extracting records one at a time
		                      inputRP = new NaElement("resourcepool-member-list-info-iter-next");
		                      inputRP.addNewChild("maximum", recordsRP);
		                      inputRP.addNewChild("tag", tagRP);
		                      NaElement rps = server.invokeElem(inputRP);
		                      NaElement resourcePoolMemberInfo = rps.getChildByName("resourcepool-members");
		                      List rpInfoList = null;
		                      if (resourcePoolMemberInfo != null)
		                    	  rpInfoList = resourcePoolMemberInfo.getChildren();
		                      if (rpInfoList == null)
		                          return;
		                      Iterator rpInfoIter = rpInfoList.iterator();
		                      while(rpInfoIter.hasNext()){
		                    	  NaElement rpInfoElement = (NaElement) rpInfoIter.next();
		                    	  System.out.println("                                                MemberId : " + rpInfoElement.getChildContent("member-id"));
		                    	  System.out.println("                                                MemberName : " + rpInfoElement.getChildContent("member-name"));
		                    	  System.out.println("                                                MemberSize : " + rpInfoElement.getChildContent("member-size"));
		                    	  System.out.println("                                                MemberStatus : " + rpInfoElement.getChildContent("member-status"));
		                    	  System.out.println("                                                MemberType : " + rpInfoElement.getChildContent("member-type"));
		                    	  
		                      }
		                      // 	invoking the iter-end zapi
		                      inputRP = new NaElement("resourcepool-member-list-info-iter-end");
		                      inputRP.addNewChild("tag", tagRP);
		                      server.invokeElem(inputRP);
                    	  }
                    	  
                    	  
                      }
                   
                      String provPolicyId= nodeInfo.getChildContent("provisioning-policy-id");
                      if(provPolicyId != null){
                    	  System.out.println("                        Provisioning Policy");
	                      System.out.println("                        ProvisioningPolicyId : " + provPolicyId);
	                      
	                      NaElement inputPolicy = new NaElement("provisioning-policy-list-iter-start");
	                      inputPolicy.addNewChild("provisioning-policy-name-or-id",nodeInfo.getChildContent("provisioning-policy-id")+"" );
	                      NaElement outputPolicy = server.invokeElem(inputPolicy);
	          		    // Extracting the record && tag values && printing them
	                      String recordsPolicy = outputPolicy.getChildContent("records");
	                      if (recordsPolicy.equals("0"))
	                          System.out.println("\nNo policies to display");
	
	                      String tagPolicy = outputPolicy.getChildContent("tag");
	                      // Extracting records one at a time
	                      inputPolicy = new NaElement("provisioning-policy-list-iter-next");
	                      inputPolicy.addNewChild("maximum", recordsPolicy);
	                      inputPolicy.addNewChild("tag", tagPolicy);
	                      NaElement recordPolicy = server.invokeElem(inputPolicy);
	                      
	                      NaElement policy = recordPolicy.getChildByName("provisioning-policies");
	                      List policyList = null;
	                      if (policy != null)
	                    	  policyList = policy.getChildren();
	                      if (policyList == null)
	                          return;
	                      Iterator policyIter = policyList.iterator();
	                      while(policyIter.hasNext()){
	                    	  NaElement policyInfo = (NaElement) policyIter.next();
	                    	  System.out.println("                              Policy Id : " + policyInfo.getChildContent("provisioning-policy-id"));
	                    	  System.out.println("                              Policy Name : " + policyInfo.getChildContent("provisioning-policy-name"));
	                    	  System.out.println("                              Policy type : " + policyInfo.getChildContent("provisioning-policy-type"));
	                    	  System.out.println("                              Resource Tag : " + policyInfo.getChildContent("resource-tag"));
	                    	  System.out.println("                              dataset-member-used-space-thresholds : " + policyInfo.getChildContent("dataset-member-used-space-thresholds"));
	                    	  System.out.println("                              dedupe-enabled : " + policyInfo.getChildContent("dedupe-enabled"));
	                    	  System.out.println("                              dedupe-schedule : " + policyInfo.getChildContent("dedupe-schedule"));
	                      }	  
	                      // 	invoking the iter-end zapi
	                      inputPolicy = new NaElement("provisioning-policy-list-iter-end");
	                      inputPolicy.addNewChild("tag", tagPolicy);
	                      server.invokeElem(inputPolicy);
                      }
                }
                
                
            }    
            
            // invoking the iter-end zapi
            input = new NaElement("storage-service-list-info-iter-end");
            input.addNewChild("tag", tag);
            server.invokeElem(input);
            
			
		} catch (NaAuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NaAPIFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NaProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
