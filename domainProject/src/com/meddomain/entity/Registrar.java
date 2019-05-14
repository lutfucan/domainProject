package com.meddomain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "registrar")
public class Registrar implements Serializable {

	private static final long serialVersionUID = -1809952611729222502L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int regId;

	private String registrarName;

	private String registrarUrl;

	@OneToMany(mappedBy = "registrar", fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.SAVE_UPDATE })
	private List<Domain> domainsWithRegistrar;

	public Registrar(String registrarName) {
		this.registrarName = registrarName;
	}

	public Registrar() {
	}

	public int getRegId() {
		return regId;
	}

	public void setRegId(int id) {
		this.regId = id;
	}

	public String getRegistrarName() {
		return registrarName;
	}

	public void setRegistrarName(String registrarName) {
		this.registrarName = registrarName;
	}

	public String getRegistrarUrl() {
		return registrarUrl;
	}

	public void setRegistrarUrl(String registrarUrl) {
		this.registrarUrl = registrarUrl;
	}

	public List<Domain> getDomainsWithRegistrar() {
		return domainsWithRegistrar;
	}

	public void setDomainsWithRegistrar(List<Domain> domainsWithRegistrar) {
		this.domainsWithRegistrar = domainsWithRegistrar;
	}

	public void addDomain(Domain domain) {
		if (domainsWithRegistrar == null) {
			domainsWithRegistrar = new ArrayList<>();
			if (domain != null) {
				domainsWithRegistrar.add(domain);
			}
		} else {
			domainsWithRegistrar.add(domain);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + regId;
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
		Registrar other = (Registrar) obj;
		if (regId != other.regId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Registrar [id=" + regId + ", registrarName=" + registrarName + ", registrarUrl=" + registrarUrl + "]";
	}

}
