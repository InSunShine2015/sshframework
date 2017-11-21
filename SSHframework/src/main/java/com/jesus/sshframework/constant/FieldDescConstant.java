package com.jesus.sshframework.constant;

import java.util.HashMap;
import java.util.Map;

import com.jesus.sshframework.model.EntityFieldDes;

public class FieldDescConstant {
	public static final Map<String,EntityFieldDes> ENTITY_FIELDS_DESC = new HashMap<String, EntityFieldDes>();
	static{
		//ENTITY_FIELDS_DESC.put("responsiblePerson", new EntityFieldDes(0, 1));
		ENTITY_FIELDS_DESC.put("channel", new EntityFieldDes(1,1 ));
		ENTITY_FIELDS_DESC.put("channelName", new EntityFieldDes(2, 1));
		ENTITY_FIELDS_DESC.put("loadAmount", new EntityFieldDes(3,3 ));
		ENTITY_FIELDS_DESC.put("nameUploadAmount", new EntityFieldDes(4, 3));
		ENTITY_FIELDS_DESC.put("frontExtractAmount", new EntityFieldDes(5, 3));
		ENTITY_FIELDS_DESC.put("frontFiltedItems", new EntityFieldDes(6, 3));
		ENTITY_FIELDS_DESC.put("frontDealProccess", new EntityFieldDes(7, 4));
		ENTITY_FIELDS_DESC.put("frontFiltedSuccess", new EntityFieldDes(8, 4));
		ENTITY_FIELDS_DESC.put("backFirstGave", new EntityFieldDes(9, 3));
		ENTITY_FIELDS_DESC.put("backItems", new EntityFieldDes(10, 3));
		ENTITY_FIELDS_DESC.put("creditQuery", new EntityFieldDes(11, 3));
		ENTITY_FIELDS_DESC.put("creditPassed", new EntityFieldDes(12,3 ));
		ENTITY_FIELDS_DESC.put("applicationAmount", new EntityFieldDes(13,3 ));
		ENTITY_FIELDS_DESC.put("auditSuccess", new EntityFieldDes(14, 3));
		ENTITY_FIELDS_DESC.put("loadItems", new EntityFieldDes(15, 3));
	}
}
