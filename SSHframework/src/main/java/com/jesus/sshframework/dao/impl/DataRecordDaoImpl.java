package com.jesus.sshframework.dao.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSON;
import com.jesus.sshframework.dao.IDataRecordDao;
import com.jesus.sshframework.model.DataRecord;
import com.jesus.sshframework.vo.ChannelListQueryVo;
import com.jesus.sshframework.vo.Pager;
@Repository
public class DataRecordDaoImpl extends BaseDaoImpl<DataRecord, String> implements IDataRecordDao{
    private static final Logger LOG = LoggerFactory.getLogger(DataRecordDaoImpl.class);
    @Override
    public Pager findByConditons(ChannelListQueryVo vo) {
        Map<String,Object> params = new HashMap<String, Object>();
        Pager pager = new Pager();
        StringBuilder sb = new StringBuilder();
        sb.append("from DataRecord dr where 1=1 ");
        if(StringUtils.isNotEmpty(vo.getChannel())){
            sb.append(" and dr.channel = :channel ");
            params.put("channel", vo.getChannel());
        }
        if(StringUtils.isNotEmpty(vo.getStartDate())){
            sb.append(" and dr.createDate >= :startDate ");
            Date stime;
            try {
                stime = DateUtils.parseDate(vo.getStartDate(), "yyy-MM-dd");
                params.put("startDate", stime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if(StringUtils.isNotEmpty(vo.getEndDate())){
            sb.append(" and dr.createDate < :endDate ");
            Date etime;
            try {
                etime = DateUtils.addDays(DateUtils.parseDate(vo.getEndDate(), "yyy-MM-dd"), 1);
                params.put("endDate", etime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        sb.append(" order by dr.createDate desc ");
        
        String hql = sb.toString();
        Query query =getSession().createQuery(hql);
        LOG.info(JSON.toJSONString(params));
        query.setProperties(params);
        
        int count=query.list().size();
        pager.setRowsTotal(count);//总数
        
        int nowPage=Integer.parseInt(StringUtils.defaultIfEmpty(vo.getPageNum(), "0"));
        pager.setPage(nowPage);
        pager.setRows(2);
        
        int pageTotal = 1;
        pageTotal =count/pager.getRows() +(count % (pager.getRows()) > 0 ? 1:0);
        pager.setPageTotal(pageTotal);
        //指定从那个对象开始查询，参数的索引位置是从0开始的，
        query.setFirstResult((nowPage - 1)*pager.getRows());
        //分页时，一次最多产寻的对象数
        query.setMaxResults(pager.getRows());
        List<?> list1=query.list();        
        pager.setList(list1);
        return pager;
    }



}
