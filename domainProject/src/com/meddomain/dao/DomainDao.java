package com.meddomain.dao;

import java.util.List;

import com.meddomain.entity.Domain;

public interface DomainDao {

	List<Domain> getDomainsList();

	void merge(Domain domain);
	
	Domain getDomain(Class<Domain> class1, Integer domainId);

	void delete(int domainId);

}
