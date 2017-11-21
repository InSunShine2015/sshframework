package com.jesus.sshframework.dao;

import com.jesus.sshframework.model.DataRecord;
import com.jesus.sshframework.vo.ChannelListQueryVo;
import com.jesus.sshframework.vo.Pager;

public interface IDataRecordDao extends IBaseDao<DataRecord, String>{

    Pager findByConditons(ChannelListQueryVo vo);

}
