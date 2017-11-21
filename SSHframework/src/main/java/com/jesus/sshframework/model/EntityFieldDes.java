package com.jesus.sshframework.model;


/**
 * 实体字段描述
 * @author sUN
 *
 */
public class EntityFieldDes {
	
	private Integer index;//索引
	private Integer defaultValueType;//默认值类型
	
	public EntityFieldDes(Integer index, Integer defaultValueType) {
		super();
		this.index = index;
		this.defaultValueType = defaultValueType;
	}
	
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public Integer getDefaultValueType() {
		return defaultValueType;
	}
	public void setDefaultValueType(Integer defaultValueType) {
		this.defaultValueType = defaultValueType;
	}
	
	
	
	
}
