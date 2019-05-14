package com.meddomain.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.meddomain.entity.DomainStatus;

@Repository
public class StatusDaoImpl implements StatusDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void merge(DomainStatus status) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(status);
	}

	@Override
	public List<DomainStatus> getStatusList() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Query<DomainStatus> query = session.createQuery("from DomainStatus");
		return query.getResultList();
	}

	@Override
	public DomainStatus getStatus(Class<DomainStatus> class1, Integer stId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(DomainStatus.class, stId);
	}

	@Override
	public void delete(int statusId) {
		Session session = sessionFactory.getCurrentSession();

		@SuppressWarnings("unchecked")
		Query<DomainStatus> query = session.createQuery("delete from DomainStatus where stId=:statusId");
		query.setParameter("statusId", statusId);
		query.executeUpdate();			
	}
	


}
