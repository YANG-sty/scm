package com.sys.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author y_zzu 2019-11-22-15:08
 */
public class Page<T> implements Serializable {

    private static final long serialVersionUID = -8615619542623187716L;

    //当前页
    private Integer page;
    //页大小
    private Integer rows;
    //总记录数
    private Integer totalRecord;
    //页面数据列表
    private List<T> list;
    //查询关键字
    private String keyword;
    //多条件查询
    private T paramEntity;
    //起始行
    private Integer start;
    //map 集合存储，
    private Map<String, Object> pageMap = new HashMap<String, Object>();

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        pageMap.put("total", totalRecord);
        this.totalRecord = totalRecord;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        pageMap.put("rows", list);
        this.list = list;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public T getParamEntity() {
        return paramEntity;
    }

    public void setParamEntity(T paramEntity) {
        this.paramEntity = paramEntity;
    }

    public Integer getStart() {
        this.start = (page -1)*rows;
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Map<String, Object> getPageMap() {
        return pageMap;
    }

    public void setPageMap(Map<String, Object> pageMap) {
        this.pageMap = pageMap;
    }

    public Page(Integer page, Integer rows, Integer totalRecord, List<T> list, String keyword, T paramEntity, Integer start, Map<String, Object> pageMap) {
        this.page = page;
        this.rows = rows;
        this.totalRecord = totalRecord;
        this.list = list;
        this.keyword = keyword;
        this.paramEntity = paramEntity;
        this.start = start;
        this.pageMap = pageMap;
    }

    public Page() {
    }
}
