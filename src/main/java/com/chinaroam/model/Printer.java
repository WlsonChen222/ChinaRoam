package com.chinaroam.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="printer")
public class Printer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="ip_address")
	private String ipaddress;
	
	@Column(name="reseller_id")
	private Integer resellerId;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIpaddress() {
		return ipaddress;
	}
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	public Integer getResellerId() {
		return resellerId;
	}
	public void setResellerId(Integer resellerId) {
		this.resellerId = resellerId;
	}
	@Override
	public String toString() {
		return "Printer [id=" + id + ", name=" + name + ", email=" + email + ", ipaddress=" + ipaddress
				+ ", resellerId=" + resellerId + "]";
	}
	
	
}
