package com.jesus.sshframework.vo;

/**
 * 列表查询vo
 * @author sUN
 *
 */
public class ChannelListQueryVo implements java.io.Serializable{
    private String pageNum ;
    
    private String channel;
    
    private String startDate;
    
    private String endDate;

    public String getPageNum() {
        return pageNum==null ? "1":pageNum;
    }

    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    
    
}
