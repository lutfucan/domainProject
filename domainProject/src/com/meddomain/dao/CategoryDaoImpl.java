package com.meddomain.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.meddomain.entity.DomainCategory;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<DomainCategory> getCategoryList() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Query<DomainCategory> query = session.createQuery("from DomainCategory");
		System.out.println(query.getResultList());
		return query.getResultList();
	}

	@Override
	public void merge(DomainCategory category) {
		Session session = sessionFactory.getCurrentSession();
		if (category != null) {
			session.merge(category);
		}
	}

	@Override
	public void clear() {
		Session session = sessionFactory.getCurrentSession();
		session.clear();
	}

	@Override
	public DomainCategory getCategory(Class<DomainCategory> class1, Integer categoryId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(class1, categoryId);
	}

	@Override
	public Map<Integer, String> getCategoryMap() {
		List<DomainCategory> categoryList = getCategoryList();
		Map<Integer, String> categoryMap = new HashMap<>();
		for (DomainCategory category : categoryList) {
			categoryMap.put(category.getCatId(), category.getCategoryName());
		}
		return categoryMap;
	}

	@Override
	public void delete(int categoryId) {
		Session session = sessionFactory.getCurrentSession();

		@SuppressWarnings("unchecked")
		Query<DomainCategory> query = session.createQuery("delete from DomainCategory where catId=:categoryId");
		query.setParameter("categoryId", categoryId);
		query.executeUpdate();
	}

}
