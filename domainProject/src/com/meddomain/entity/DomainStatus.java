package com.meddomain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="domain_status")
public class DomainStatus implements Serializable{

	private static final long serialVersionUID = -5741438022004030788L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int stId;

	private String status;

	@OneToMany(mappedBy = "status")
	@Cascade(value = { CascadeType.SAVE_UPDATE })
	private List<Domain> domainWithStatus;	

	public DomainStatus(String status) {
		this.status = status;
	}

	public DomainStatus() {
	}

	public int getStId() {
		return stId;
	}

	public void setStId(int stId) {
		this.stId = stId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public List<Domain> getDomainWithStatus() {
		return domainWithStatus;
	}

	public void setDomainWithStatus(List<Domain> domainWithStatus) {
		this.domainWithStatus = domainWithStatus;
	}

	public void addDomain(Domain domain) {
		if (domainWithStatus == null) {
			domainWithStatus = new ArrayList<>();
			if (domain != null) {
				domainWithStatus.add(domain);
				domain.setStatus(this);
			}
		} else {
			domainWithStatus.add(domain);
		}
	}

	@Override
	public String toString() {
		return "DomainStatus [id=" + stId + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + stId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DomainStatus other = (DomainStatus) obj;
		if (stId != other.stId)
			return false;
		return true;
	}
	
}
