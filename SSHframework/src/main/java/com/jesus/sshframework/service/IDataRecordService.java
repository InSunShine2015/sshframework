package com.jesus.sshframework.service;

import java.util.List;

import com.jesus.sshframework.model.DataRecord;
import com.jesus.sshframework.vo.ChannelListQueryVo;
import com.jesus.sshframework.vo.Pager;

public interface IDataRecordService extends IBaseService<DataRecord, String>{
    public String saveUploadFileResult(List<List<String>> result);

    public Pager findChannel(ChannelListQueryVo vo);
}
