
package com.netapp.wfa.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.netapp.wfa.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAllWorkflows_QNAME = new QName("http://ws.wfa.netapp.com/", "getAllWorkflows");
    private final static QName _GetReturnParametersResponse_QNAME = new QName("http://ws.wfa.netapp.com/", "getReturnParametersResponse");
    private final static QName _GetAllWorkflowsResponse_QNAME = new QName("http://ws.wfa.netapp.com/", "getAllWorkflowsResponse");
    private final static QName _GetReturnParameters_QNAME = new QName("http://ws.wfa.netapp.com/", "getReturnParameters");
    private final static QName _ExecuteWorkflow_QNAME = new QName("http://ws.wfa.netapp.com/", "executeWorkflow");
    private final static QName _GetJobStatusResponse_QNAME = new QName("http://ws.wfa.netapp.com/", "getJobStatusResponse");
    private final static QName _GetCommandArgumentsResponse_QNAME = new QName("http://ws.wfa.netapp.com/", "getCommandArgumentsResponse");
    private final static QName _GetCommandArguments_QNAME = new QName("http://ws.wfa.netapp.com/", "getCommandArguments");
    private final static QName _GetJobStatus_QNAME = new QName("http://ws.wfa.netapp.com/", "getJobStatus");
    private final static QName _ExecuteWorkflowResponse_QNAME = new QName("http://ws.wfa.netapp.com/", "executeWorkflowResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.netapp.wfa.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetReturnParameters }
     * 
     */
    public GetReturnParameters createGetReturnParameters() {
        return new GetReturnParameters();
    }

    /**
     * Create an instance of {@link GetReturnParametersResponse }
     * 
     */
    public GetReturnParametersResponse createGetReturnParametersResponse() {
        return new GetReturnParametersResponse();
    }

    /**
     * Create an instance of {@link GetAllWorkflows }
     * 
     */
    public GetAllWorkflows createGetAllWorkflows() {
        return new GetAllWorkflows();
    }

    /**
     * Create an instance of {@link GetAllWorkflowsResponse }
     * 
     */
    public GetAllWorkflowsResponse createGetAllWorkflowsResponse() {
        return new GetAllWorkflowsResponse();
    }

    /**
     * Create an instance of {@link ExecuteWorkflowResponse }
     * 
     */
    public ExecuteWorkflowResponse createExecuteWorkflowResponse() {
        return new ExecuteWorkflowResponse();
    }

    /**
     * Create an instance of {@link GetCommandArguments }
     * 
     */
    public GetCommandArguments createGetCommandArguments() {
        return new GetCommandArguments();
    }

    /**
     * Create an instance of {@link GetJobStatus }
     * 
     */
    public GetJobStatus createGetJobStatus() {
        return new GetJobStatus();
    }

    /**
     * Create an instance of {@link GetCommandArgumentsResponse }
     * 
     */
    public GetCommandArgumentsResponse createGetCommandArgumentsResponse() {
        return new GetCommandArgumentsResponse();
    }

    /**
     * Create an instance of {@link ExecuteWorkflow }
     * 
     */
    public ExecuteWorkflow createExecuteWorkflow() {
        return new ExecuteWorkflow();
    }

    /**
     * Create an instance of {@link GetJobStatusResponse }
     * 
     */
    public GetJobStatusResponse createGetJobStatusResponse() {
        return new GetJobStatusResponse();
    }

    /**
     * Create an instance of {@link JobStatus }
     * 
     */
    public JobStatus createJobStatus() {
        return new JobStatus();
    }

    /**
     * Create an instance of {@link Workflow }
     * 
     */
    public Workflow createWorkflow() {
        return new Workflow();
    }

    /**
     * Create an instance of {@link UserInput }
     * 
     */
    public UserInput createUserInput() {
        return new UserInput();
    }

    /**
     * Create an instance of {@link ReturnParameter }
     * 
     */
    public ReturnParameter createReturnParameter() {
        return new ReturnParameter();
    }

    /**
     * Create an instance of {@link CommandArgument }
     * 
     */
    public CommandArgument createCommandArgument() {
        return new CommandArgument();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllWorkflows }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.wfa.netapp.com/", name = "getAllWorkflows")
    public JAXBElement<GetAllWorkflows> createGetAllWorkflows(GetAllWorkflows value) {
        return new JAXBElement<GetAllWorkflows>(_GetAllWorkflows_QNAME, GetAllWorkflows.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReturnParametersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.wfa.netapp.com/", name = "getReturnParametersResponse")
    public JAXBElement<GetReturnParametersResponse> createGetReturnParametersResponse(GetReturnParametersResponse value) {
        return new JAXBElement<GetReturnParametersResponse>(_GetReturnParametersResponse_QNAME, GetReturnParametersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllWorkflowsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.wfa.netapp.com/", name = "getAllWorkflowsResponse")
    public JAXBElement<GetAllWorkflowsResponse> createGetAllWorkflowsResponse(GetAllWorkflowsResponse value) {
        return new JAXBElement<GetAllWorkflowsResponse>(_GetAllWorkflowsResponse_QNAME, GetAllWorkflowsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReturnParameters }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.wfa.netapp.com/", name = "getReturnParameters")
    public JAXBElement<GetReturnParameters> createGetReturnParameters(GetReturnParameters value) {
        return new JAXBElement<GetReturnParameters>(_GetReturnParameters_QNAME, GetReturnParameters.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExecuteWorkflow }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.wfa.netapp.com/", name = "executeWorkflow")
    public JAXBElement<ExecuteWorkflow> createExecuteWorkflow(ExecuteWorkflow value) {
        return new JAXBElement<ExecuteWorkflow>(_ExecuteWorkflow_QNAME, ExecuteWorkflow.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetJobStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.wfa.netapp.com/", name = "getJobStatusResponse")
    public JAXBElement<GetJobStatusResponse> createGetJobStatusResponse(GetJobStatusResponse value) {
        return new JAXBElement<GetJobStatusResponse>(_GetJobStatusResponse_QNAME, GetJobStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCommandArgumentsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.wfa.netapp.com/", name = "getCommandArgumentsResponse")
    public JAXBElement<GetCommandArgumentsResponse> createGetCommandArgumentsResponse(GetCommandArgumentsResponse value) {
        return new JAXBElement<GetCommandArgumentsResponse>(_GetCommandArgumentsResponse_QNAME, GetCommandArgumentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCommandArguments }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.wfa.netapp.com/", name = "getCommandArguments")
    public JAXBElement<GetCommandArguments> createGetCommandArguments(GetCommandArguments value) {
        return new JAXBElement<GetCommandArguments>(_GetCommandArguments_QNAME, GetCommandArguments.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetJobStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.wfa.netapp.com/", name = "getJobStatus")
    public JAXBElement<GetJobStatus> createGetJobStatus(GetJobStatus value) {
        return new JAXBElement<GetJobStatus>(_GetJobStatus_QNAME, GetJobStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExecuteWorkflowResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.wfa.netapp.com/", name = "executeWorkflowResponse")
    public JAXBElement<ExecuteWorkflowResponse> createExecuteWorkflowResponse(ExecuteWorkflowResponse value) {
        return new JAXBElement<ExecuteWorkflowResponse>(_ExecuteWorkflowResponse_QNAME, ExecuteWorkflowResponse.class, null, value);
    }

}
