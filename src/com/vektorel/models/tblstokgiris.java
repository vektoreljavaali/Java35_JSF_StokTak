package com.vektorel.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class tblstokgiris {
	@Id
	@SequenceGenerator(name="sq_tblstokgiris_id",
					 sequenceName="sq_tblstokgiris_id",
					 initialValue=1,allocationSize=1)
	@GeneratedValue(generator="sq_tblstokgiris_id")
	private Long id;
	private Long urunid;
	private Long ilceid;
	private String urunadi;
	private String iladi;
	private String ilceadi;
	private String url;
	private int siid;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUrunid() {
		return urunid;
	}
	public void setUrunid(Long urunid) {
		this.urunid = urunid;
	}
	public Long getIlceid() {
		return ilceid;
	}
	public void setIlceid(Long ilceid) {
		this.ilceid = ilceid;
	}
	public String getUrunadi() {
		return urunadi;
	}
	public void setUrunadi(String urunadi) {
		this.urunadi = urunadi;
	}
	public String getIladi() {
		return iladi;
	}
	public void setIladi(String iladi) {
		this.iladi = iladi;
	}
	public String getIlceadi() {
		return ilceadi;
	}
	public void setIlceadi(String ilceadi) {
		this.ilceadi = ilceadi;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getSiid() {
		return siid;
	}
	public void setSiid(int siid) {
		this.siid = siid;
	}
	
	
	
	
}
