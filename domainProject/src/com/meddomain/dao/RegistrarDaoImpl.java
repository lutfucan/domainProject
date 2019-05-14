package com.meddomain.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.meddomain.entity.DomainStatus;
import com.meddomain.entity.Registrar;

@Repository
public class RegistrarDaoImpl implements RegistrarDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void merge(Registrar registrar) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(registrar);
	}

	@Override
	public List<Registrar> getRegistrarList() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Query<Registrar> query = session.createQuery("from Registrar");
		return query.getResultList();
	}

	@Override
	public Registrar getRegistrar(Class<Registrar> class1, Integer registrarId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(class1, registrarId);
	}

	@Override
	public void delete(int registrarId) {
		Session session = sessionFactory.getCurrentSession();

		@SuppressWarnings("unchecked")
		Query<DomainStatus> query = session.createQuery("delete from DomainStatus where regId=:registrarId");
		query.setParameter("registrarId", registrarId);
		query.executeUpdate();	
		
	}


}
