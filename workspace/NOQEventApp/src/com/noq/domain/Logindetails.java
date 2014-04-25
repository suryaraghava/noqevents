package com.noq.domain;

// Generated Apr 25, 2014 12:19:53 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Logindetails generated by hbm2java
 */
@Entity
@Table(name = "logindetails", catalog = "noqshows_test")
public class Logindetails implements java.io.Serializable {

	private Integer id;
	private User user;
	private String userid;
	private String status;
	private String sessionvalue;

	public Logindetails() {
	}

	public Logindetails(User user, String userid, String status,
			String sessionvalue) {
		this.user = user;
		this.userid = userid;
		this.status = status;
		this.sessionvalue = sessionvalue;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "user"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "userid", nullable = false, length = 45)
	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Column(name = "status", nullable = false, length = 45)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "sessionvalue", nullable = false, length = 45)
	public String getSessionvalue() {
		return this.sessionvalue;
	}

	public void setSessionvalue(String sessionvalue) {
		this.sessionvalue = sessionvalue;
	}

}
