package com.example.analysisshop.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public abstract class BaseVo {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	private Date createDate;
	private Date updateDate;


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

	/**
	 * 关注性能的需要重载
	 * @param t
	 */
	public <T> void initFromDo(T t) {
		BeanUtils.copyProperties(t, this);
	}

}
