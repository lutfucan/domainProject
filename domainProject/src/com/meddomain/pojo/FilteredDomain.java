package com.meddomain.pojo;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.meddomain.entity.Registrar;

@Component
public class FilteredDomain {

	private String fullDomainName;
	private Registrar registrar;
	private Date registerDate;

	public FilteredDomain() {
	}

	public FilteredDomain(String fullDomainName) {
		this.fullDomainName = fullDomainName;
	}

	public String getFullDomainName() {
		return fullDomainName;
	}

	public void setFullDomainName(String fullDomainName) {
		this.fullDomainName = fullDomainName;
	}

	public Registrar getRegistrar() {
		return registrar;
	}

	public void setRegistrar(Registrar registrar) {
		this.registrar = registrar;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	@Override
	public String toString() {
		return fullDomainName;
	}
	
	
}
