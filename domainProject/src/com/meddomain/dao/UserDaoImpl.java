package com.meddomain.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.meddomain.entity.DomainStatus;
import com.meddomain.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void merge(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(user);
	}

	@Override
	public List<User> getUserList() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Query<User> query = session.createQuery("from User");
		return query.getResultList();	}

	@Override
	public User getUser(Class<User> class1, Integer userId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(User.class, userId);
	}

	@Override
	public void delete(int userId) {
		Session session = sessionFactory.getCurrentSession();

		@SuppressWarnings("unchecked")
		Query<DomainStatus> query = session.createQuery("delete from DomainStatus where userId=:userId");
		query.setParameter("userId", userId);
		query.executeUpdate();			
	}

}
