package com.reporting.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.reporting.demo.entity.common.BaseEntity;
import com.reporting.demo.entity.enumr.Currency;
import com.reporting.demo.entity.enumr.TransactionStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "USERS")
public class User extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USERS_ID")
    @SequenceGenerator(name = "SEQ_USERS_ID", sequenceName = "SEQ_USERS_ID", allocationSize = 1, initialValue = 1)
	@Column(name = "ID", nullable = false)
	private Long id;
	
	@Column(name = "NAME", length = 100)
	private String name;
	
	@Column(name = "SURNAME", length = 100)
	private String surname;
	
	@Column(name = "EMAIL", length = 100)
	private String email;
	
	private String getUsername() {
		return email;
	}

	

	//@JsonIgnore  this anotation prevents this field to be transmited in the json object. But sometimes you may
	//want to transfer, sometimes you may not want to transfer the field. For such cases, instead of using this anotation,
	//we generate specia DTO classes for clients..
	@Column(name = "PASSWORD", length = 100)
	private String password;
	
	@Column(name = "ROLE_NAME", length = 100)
	private String roleName;
	
	
}
