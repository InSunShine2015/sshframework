package com.jesus.sshframework.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="DATA_RECORD")
public class DataRecord  extends BaseEntity{
				 			
//	private static final long serialVersionUID = -6349091592789924633L;
	//String 1 Integer 2 Long 3 Double 4 Date 5 
	
//	private String responsiblePerson;//负责人
	
	private String channel;//渠道
	
	private String channelName;//渠道名称
	
	private Double loadAmount;//放款金额
	
	private Long nameUploadAmount;//名单上载总量

	private Long frontExtractAmount;//前端抽取量
	
	private Long frontFiltedItems;//前端筛选通过件
	
	private Double frontDealProccess;//前端拨打进度

	private Double frontFiltedSuccess;//前端筛选符合率
	
	private Long backFirstGave;//后端首拨
	
	private Long backItems;//回件量
	
	private Long creditQuery;//征信查询量	

	private Long creditPassed;//征信通过量	

	private Long applicationAmount;//申请量

	private Long auditSuccess;//审批通过量

	private Long loadItems;//放款量
	
//	@Column(name="responsible_person",nullable = true)
//	public String getResponsiblePerson() {
//		return responsiblePerson;
//	}
//
//	public void setResponsiblePerson(String responsiblePerson) {
//		this.responsiblePerson = responsiblePerson;
//	}
	@Column(name="CHANNEL",length=100,nullable = true)
	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}
	@Column(name="CHANNEL_NAME",length=200,nullable = true)
	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	@Column(name="LOAD_AMOUNT",nullable = true)
	public Double getLoadAmount() {
		return loadAmount;
	}
	
	public void setLoadAmount(Double loadAmount) {
		this.loadAmount = loadAmount;
	}
	@Column(name="NAME_UPLOAD_AMOUNT",nullable = true)
	public Long getNameUploadAmount() {
		return nameUploadAmount;
	}

	public void setNameUploadAmount(Long nameUploadAmount) {
		this.nameUploadAmount = nameUploadAmount;
	}
	@Column(name="FRONT_EXTRACT_AMOUNT",nullable = true)
	public Long getFrontExtractAmount() {
		return frontExtractAmount;
	}

	public void setFrontExtractAmount(Long frontExtractAmount) {
		this.frontExtractAmount = frontExtractAmount;
	}
	@Column(name="FRONT_FILTED_ITEMS",nullable = true)
	public Long getFrontFiltedItems() {
		return frontFiltedItems;
	}

	public void setFrontFiltedItems(Long frontFiltedItems) {
		this.frontFiltedItems = frontFiltedItems;
	}
	@Column(name="FRONT_DEAL_PROCCESS",nullable = true)
	public Double getFrontDealProccess() {
		return frontDealProccess;
	}

	public void setFrontDealProccess(Double frontDealProccess) {
		this.frontDealProccess = frontDealProccess;
	}
	@Column(name="FRONT_FILTED_SUCCESS",nullable = true)
	public Double getFrontFiltedSuccess() {
		return frontFiltedSuccess;
	}

	public void setFrontFiltedSuccess(Double frontFiltedSuccess) {
		this.frontFiltedSuccess = frontFiltedSuccess;
	}
	@Column(name="BACK_FIRST_GAVE",nullable = true)
	public Long getBackFirstGave() {
		return backFirstGave;
	}
	
	public void setBackFirstGave(Long backFirstGave) {
		this.backFirstGave = backFirstGave;
	}
	@Column(name="BACK_ITEMS",nullable = true)
	public Long getBackItems() {
		return backItems;
	}

	public void setBackItems(Long backItems) {
		this.backItems = backItems;
	}
	@Column(name="CREDIT_QUERY",nullable = true)
	public Long getCreditQuery() {
		return creditQuery;
	}

	public void setCreditQuery(Long creditQuery) {
		this.creditQuery = creditQuery;
	}
	@Column(name="CREDIT_PASSED",nullable = true)
	public Long getCreditPassed() {
		return creditPassed;
	}

	public void setCreditPassed(Long creditPassed) {
		this.creditPassed = creditPassed;
	}
	@Column(name="APPLICATION_AMOUNT",nullable = true)
	public Long getApplicationAmount() {
		return applicationAmount;
	}

	public void setApplicationAmount(Long applicationAmount) {
		this.applicationAmount = applicationAmount;
	}
	@Column(name="AUDIT_SUCCESS",nullable = true)
	public Long getAuditSuccess() {
		return auditSuccess;
	}

	public void setAuditSuccess(Long auditSuccess) {
		this.auditSuccess = auditSuccess;
	}
	@Column(name="LOAD_ITEMS",nullable = true)
	public Long getLoadItems() {
		return loadItems;
	}

	public void setLoadItems(Long loadItems) {
		this.loadItems = loadItems;
	}
	
	
							

}
