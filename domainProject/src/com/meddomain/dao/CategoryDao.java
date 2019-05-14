package com.meddomain.dao;

import java.util.List;
import java.util.Map;

import com.meddomain.entity.DomainCategory;

public interface CategoryDao {

	List<DomainCategory> getCategoryList();

	void merge(DomainCategory category);
	
	void clear();

	DomainCategory getCategory(Class<DomainCategory> class1, Integer categoryId);

	Map<Integer, String> getCategoryMap();

	void delete(int categoryId);

}
