package com.meddomain.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.meddomain.entity.Domain;

@Repository
public class DomainDaoImpl implements DomainDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Domain> getDomainsList() {
		Session session = sessionFactory.getCurrentSession();		
		@SuppressWarnings("unchecked")
		Query<Domain> query = session.createQuery("from Domain");
		return query.getResultList();
	}

	@Override
	public void merge(Domain domain) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(domain);
	}

	@Override
	public Domain getDomain(Class<Domain> class1, Integer domainId) {
		Session session = sessionFactory.getCurrentSession();		
		return session.get(Domain.class, domainId);
	}

	@Override
	public void delete(int domainId) {
		Session session = sessionFactory.getCurrentSession();

		@SuppressWarnings("unchecked")
		Query<Domain> query = session.createQuery("delete from Domain where domId=:domainId");
		query.setParameter("domainId", domainId);
		query.executeUpdate();		
	}

}
