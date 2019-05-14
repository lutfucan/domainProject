package com.meddomain.dao;

import java.util.List;

import com.meddomain.entity.DomainStatus;

public interface StatusDao {

	void merge(DomainStatus status);

	List<DomainStatus> getStatusList();

	DomainStatus getStatus(Class<DomainStatus> class1, Integer stId);

	void delete(int statusId);
	

}
