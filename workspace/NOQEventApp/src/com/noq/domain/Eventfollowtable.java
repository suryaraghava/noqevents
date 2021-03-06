package com.noq.domain;

// Generated May 3, 2014 8:01:12 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Eventfollowtable generated by hbm2java
 */
@Entity
@Table(name = "eventfollowtable", catalog = "noqshows_test")
public class Eventfollowtable implements java.io.Serializable {

	private int id;
	private String eventid;
	private String followUserid;
	private String followTopic;
	private String createdby;
	private String createdtime;
	private String modifiedby;
	private String modifiedtime;

	public Eventfollowtable() {
	}

	public Eventfollowtable(int id, String eventid, String followUserid) {
		this.id = id;
		this.eventid = eventid;
		this.followUserid = followUserid;
	}

	public Eventfollowtable(int id, String eventid, String followUserid,
			String followTopic, String createdby, String createdtime,
			String modifiedby, String modifiedtime) {
		this.id = id;
		this.eventid = eventid;
		this.followUserid = followUserid;
		this.followTopic = followTopic;
		this.createdby = createdby;
		this.createdtime = createdtime;
		this.modifiedby = modifiedby;
		this.modifiedtime = modifiedtime;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "eventid", nullable = false, length = 45)
	public String getEventid() {
		return this.eventid;
	}

	public void setEventid(String eventid) {
		this.eventid = eventid;
	}

	@Column(name = "follow_userid", nullable = false, length = 45)
	public String getFollowUserid() {
		return this.followUserid;
	}

	public void setFollowUserid(String followUserid) {
		this.followUserid = followUserid;
	}

	@Column(name = "follow_topic", length = 45)
	public String getFollowTopic() {
		return this.followTopic;
	}

	public void setFollowTopic(String followTopic) {
		this.followTopic = followTopic;
	}

	@Column(name = "createdby", length = 45)
	public String getCreatedby() {
		return this.createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	@Column(name = "createdtime", length = 45)
	public String getCreatedtime() {
		return this.createdtime;
	}

	public void setCreatedtime(String createdtime) {
		this.createdtime = createdtime;
	}

	@Column(name = "modifiedby", length = 45)
	public String getModifiedby() {
		return this.modifiedby;
	}

	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}

	@Column(name = "modifiedtime", length = 45)
	public String getModifiedtime() {
		return this.modifiedtime;
	}

	public void setModifiedtime(String modifiedtime) {
		this.modifiedtime = modifiedtime;
	}

}
