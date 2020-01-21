package com.example.analysisshop.dto;

import com.example.analysisshop.common.exception.ServiceException;
import org.springframework.beans.BeanUtils;

public class BaseDto {

    protected int pageNum = 1;

    protected int pageSize = 30;


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

    /**
     * DTO 转实体
     */
    public <T> T toEntity(Class<T> clazz) {

        try {
            T t = clazz.newInstance();
            BeanUtils.copyProperties(this, t);
            return t;

        } catch (Exception e) {
            throw new ServiceException("10000","转化错误");
        }
    }

    /**
     * 实例转DTO
     * @param t
     */
    public <T> void fromEntity(T t) {
        BeanUtils.copyProperties(t, this);
    }
}
