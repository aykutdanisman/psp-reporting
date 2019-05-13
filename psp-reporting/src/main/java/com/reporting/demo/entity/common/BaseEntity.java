package com.reporting.demo.entity.common;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable{
	
	@Column(name="CREATED_DATE")
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@Column(name = "CREATED_BY", length = 100)
	@CreatedBy
	private String createdBy;
	
	@Column(name = "UPDATED_DATE")
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;
	
	@Column(name = "UPDATED_BY", length = 100)
	@LastModifiedBy
	private String updatedBy;
	

}
