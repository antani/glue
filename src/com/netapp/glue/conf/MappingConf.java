package com.netapp.glue.conf;

import java.util.ArrayList;
import java.util.List;

public class MappingConf {

private String WFAWorkflow;
private String StorageServiceName;
private int StorageServiceId;
private String Description;
private boolean IsDRCapable;
private String ServiceContact; 
private String ProtectionPolicy;
private int ProtectionPolicyId;
List StorageServiceNodes = new ArrayList(); 
                        private int DPNodeId;
                        private String DPNodeName;
                        private int vFilerTemplateId;
                        private String vFilerTemplateName;
                        List ResourcePools = new ArrayList();
                              private int ResourcePoolId;
                              private String ResourcePoolName;
                              
                        List ProvisioningPolicy = new ArrayList();
                        	private int PolicyId;
                        	private String PolicyName;
                        	private String PolicyType;
                        	private String ResourceTag;
                        	private String DatasetMemberUsedSpaceThresholds;
                        	private boolean DedupeEnabled;
                        	private String DedupeSchedule;
                        	
                        	
							public String getWFAWorkflow() {
								return WFAWorkflow;
							}
							public void setWFAWorkflow(String wFAWorkflow) {
								WFAWorkflow = wFAWorkflow;
							}
							public String getStorageServiceName() {
								return StorageServiceName;
							}
							public void setStorageServiceName(String storageService) {
								StorageServiceName = storageService;
							}
							public int getStorageServiceId() {
								return StorageServiceId;
							}
							public void setStorageServiceId(int storageServiceId) {
								StorageServiceId = storageServiceId;
							}
							public String getDescription() {
								return Description;
							}
							public void setDescription(String description) {
								Description = description;
							}
							public boolean isIsDRCapable() {
								return IsDRCapable;
							}
							public void setIsDRCapable(boolean isDRCapable) {
								IsDRCapable = isDRCapable;
							}
							public String getServiceContact() {
								return ServiceContact;
							}
							public void setServiceContact(String serviceContact) {
								ServiceContact = serviceContact;
							}
							public String getProtectionPolicy() {
								return ProtectionPolicy;
							}
							public void setProtectionPolicy(String protectionPolicy) {
								ProtectionPolicy = protectionPolicy;
							}
							public int getProtectionPolicyId() {
								return ProtectionPolicyId;
							}
							public void setProtectionPolicyId(int protectionPolicyId) {
								ProtectionPolicyId = protectionPolicyId;
							}
							public List getStorageServiceNodes() {
								return StorageServiceNodes;
							}
							public void setStorageServiceNodes(List storageServiceNodes) {
								StorageServiceNodes = storageServiceNodes;
							}
							public int getDPNodeId() {
								return DPNodeId;
							}
							public void setDPNodeId(int dPNodeId) {
								DPNodeId = dPNodeId;
							}
							public String getDPNodeName() {
								return DPNodeName;
							}
							public void setDPNodeName(String dPNodeName) {
								DPNodeName = dPNodeName;
							}
							public int getvFilerTemplateId() {
								return vFilerTemplateId;
							}
							public void setvFilerTemplateId(int vFilerTemplateId) {
								this.vFilerTemplateId = vFilerTemplateId;
							}
							public String getvFilerTemplateName() {
								return vFilerTemplateName;
							}
							public void setvFilerTemplateName(String vFilerTemplateName) {
								this.vFilerTemplateName = vFilerTemplateName;
							}
							public List getResourcePools() {
								return ResourcePools;
							}
							public void setResourcePools(List resourcePools) {
								ResourcePools = resourcePools;
							}
							public int getResourcePoolId() {
								return ResourcePoolId;
							}
							public void setResourcePoolId(int resourcePoolId) {
								ResourcePoolId = resourcePoolId;
							}
							public String getResourcePoolName() {
								return ResourcePoolName;
							}
							public void setResourcePoolName(String resourcePoolName) {
								ResourcePoolName = resourcePoolName;
							}
							public List getProvisioningPolicy() {
								return ProvisioningPolicy;
							}
							public void setProvisioningPolicy(List provisioningPolicy) {
								ProvisioningPolicy = provisioningPolicy;
							}
							public int getPolicyId() {
								return PolicyId;
							}
							public void setPolicyId(int policyId) {
								PolicyId = policyId;
							}
							public String getPolicyName() {
								return PolicyName;
							}
							public void setPolicyName(String policyName) {
								PolicyName = policyName;
							}
							public String getPolicyType() {
								return PolicyType;
							}
							public void setPolicyType(String policyType) {
								PolicyType = policyType;
							}
							public String getResourceTag() {
								return ResourceTag;
							}
							public void setResourceTag(String resourceTag) {
								ResourceTag = resourceTag;
							}
							public String getDatasetMemberUsedSpaceThresholds() {
								return DatasetMemberUsedSpaceThresholds;
							}
							public void setDatasetMemberUsedSpaceThresholds(
									String datasetMemberUsedSpaceThresholds) {
								DatasetMemberUsedSpaceThresholds = datasetMemberUsedSpaceThresholds;
							}
							public boolean isDedupeEnabled() {
								return DedupeEnabled;
							}
							public void setDedupeEnabled(boolean dedupeEnabled) {
								DedupeEnabled = dedupeEnabled;
							}
							public String getDedupeSchedule() {
								return DedupeSchedule;
							}
							public void setDedupeSchedule(String dedupeSchedule) {
								DedupeSchedule = dedupeSchedule;
							}
                        	
                        	
                        	
                        	
}                        	
