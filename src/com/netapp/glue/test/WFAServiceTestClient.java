/**
 * Test client for invoking WFA workflows
 * @author antani
 */
package com.netapp.glue.test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kwalify.SyntaxException;

import com.netapp.glue.conf.*;
import com.netapp.wfa.ws.*;
import com.netapp.glue.ws.*;

public class WFAServiceTestClient {
//	private static final QName SERVICE_NAME = new QName("http://ws.wfa.netapp.com/","WorkflowService");
//	wsdlURL = new URL( "http://10.72.64.247/wfa-ws/WorkflowService_doc?wsdl");
	public static void main(String[] args) {
		
		ConfParser confParser = new ConfParser();
		ServerConf serverConf= confParser.parseServerConf();
		//MappingConf mappingConf= confParser.parseMappingConf();
		try {
			confParser.genericParser();
		} catch (SyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		WebServiceWrapper wrapper = new WebServiceWrapper(serverConf.getWfaserver(), serverConf.getWfausername(), serverConf.getWfapassword());
		Object[] response=null;
		try {
			response = wrapper.invokeWebService("WorkflowService_doc","getAllWorkflows");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printResponse(response);
	}
	private static void printResponse(Object[] arr){
		for (int i=0; i< arr.length;i++){
			ArrayList<Workflow> wf = (ArrayList)arr[i];
			System.out.println("Workflow Details ");
			System.out.println("~~~~~~~~~~~~~~~~");
			for (Workflow t : wf){
				
				System.out.println(" Name: " + t.getName());
				System.out.println(" Description: " + t.getDescription());
				List<UserInput> userInput = t.getUserInput();
				for (UserInput ui:userInput){
					System.out.println("          User Input : " + ui.getName());
					System.out.println("          User Input : " + ui.getDescription());
				}
			}	
			
		}
			
	}
	
}
