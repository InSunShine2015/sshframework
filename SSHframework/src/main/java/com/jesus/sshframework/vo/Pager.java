package com.jesus.sshframework.vo;

import java.util.List;
/**
 * 分页工具
 * @author sUN
 *
 */
public class Pager {
    private int page;//当前页
    private int pageTotal;//总页数
    private int rowsTotal;//总条数
    private int rows;//每页条数
    private List<?> list;//查询结果
    
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getPageTotal() {
        return pageTotal;
    }
    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }
    public List<?> getList() {
        return list;
    }
    public void setList(List<?> list) {
        this.list = list;
    }
    public int getRowsTotal() {
        return rowsTotal;
    }
    public void setRowsTotal(int rowsTotal) {
        this.rowsTotal = rowsTotal;
    }
    public int getRows() {
        return rows;
    }
    public void setRows(int rows) {
        this.rows = rows;
    }
    
    
}
