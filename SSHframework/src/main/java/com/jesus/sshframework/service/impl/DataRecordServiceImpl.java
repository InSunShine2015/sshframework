package com.jesus.sshframework.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.jesus.sshframework.constant.FieldDescConstant;
import com.jesus.sshframework.dao.IDataRecordDao;
import com.jesus.sshframework.dao.IUserDao;
import com.jesus.sshframework.model.DataRecord;
import com.jesus.sshframework.model.EntityFieldDes;
import com.jesus.sshframework.service.IDataRecordService;
import com.jesus.sshframework.vo.ChannelListQueryVo;
import com.jesus.sshframework.vo.Pager;
@Service("dataRecordService")
public class DataRecordServiceImpl extends BaseServiceImpl<DataRecord, String>
        implements IDataRecordService {
    private static final Logger LOG = LoggerFactory.getLogger(DataRecordServiceImpl.class);
    
    @Resource
    private IDataRecordDao dataRecordDao;
    @Resource
    public void setBaseDao(IDataRecordDao dataRecordDao) {
        super.setBaseDao(dataRecordDao);
    }
    @Override
    public String saveUploadFileResult(List<List<String>> result) {
        String ret = "success";
        DataRecord record = null;
        if (!CollectionUtils.isEmpty(result)) {
            for (List<String> list : result) {
                record = toEntity(list, record);
                if (!"小计".equals(StringUtils.replacePattern(
                        record.getChannel(), " |\t", ""))) {
                    LOG.debug(JSON.toJSONString(record));
                    dataRecordDao.save(record);
                }
            }
        }
        return ret;
    }

    /**
     * 给实体类赋值
     * 
     * @param list
     * @param record
     * @return
     */
    private DataRecord toEntity(List<String> list, DataRecord record) {

        EntityFieldDes des = null;
        record = new DataRecord();
        for (String fieldName : FieldDescConstant.ENTITY_FIELDS_DESC.keySet()) {
            des = FieldDescConstant.ENTITY_FIELDS_DESC.get(fieldName);
            setFieldValue(list, des, record, fieldName);
        }
        return record;
    }

    /**
     * 设置字段值
     * 
     * @param list
     * @param des
     * @param record
     * @param fieldName
     */
    private void setFieldValue(List<String> list, EntityFieldDes des,
            DataRecord record, String fieldName) {
        int index = des.getIndex();
        int defaultValueType = des.getDefaultValueType();
        String valueStr = list.get(index);
        Object value = null;
        if (defaultValueType == 1) {// String 1 Date 5
            if (valueStr == null) {
                value = "";
            } else {
                value = valueStr;
            }
        } else if (defaultValueType == 2) {// Integer 2
            if (StringUtils.isBlank(valueStr)
                    || !StringUtils.isNumeric(valueStr)) {
                value = 0;
            } else {
                value = Integer.parseInt(valueStr);
            }
        } else if (defaultValueType == 3) {// Long 3
            if (StringUtils.isBlank(valueStr)
                    || !StringUtils.isNumeric(valueStr)) {
                value = 0L;
            } else {
                value = Long.parseLong(valueStr);
            }
        } else if (defaultValueType == 4) {// Double 4
            if (StringUtils.isBlank(valueStr)
                    || !StringUtils.isNumeric(valueStr)) {
                value = 0.0d;
            } else {
                value = Double.parseDouble(valueStr);
            }
        }
        try {
            BeanUtils.setProperty(record, fieldName, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public Pager findChannel(ChannelListQueryVo vo) {
        return dataRecordDao.findByConditons(vo);
    }
}
