package com.example.analysisshop.dto;

import java.util.Date;

import com.example.analysisshop.common.exception.ServiceException;
import org.springframework.beans.BeanUtils;

public class BaseDto {


    protected int pageNum = 1;

    protected int pageSize = 30;

    private Date createDate;
    private Date updateDate;

    private String createUid;
    private String updateUid;


    private String orderBy = "create_date desc";


    /**
     * DTO 转实体
     */
    public <T> T toEntity(Class<T> clazz) {

        try {
            T t = clazz.newInstance();
            BeanUtils.copyProperties(this, t);
            return t;

        } catch (Exception e) {
            throw new ServiceException("400012", "dto to entity fail");
        }
    }

    /**
     * 实例转DTO
     * @param t
     */
    public <T> void fromEntity(T t) {
        BeanUtils.copyProperties(t, this);
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getCreateUid() {
        return createUid;
    }

    public void setCreateUid(String createUid) {
        this.createUid = createUid;
    }

    public String getUpdateUid() {
        return updateUid;
    }

    public void setUpdateUid(String updateUid) {
        this.updateUid = updateUid;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

}
