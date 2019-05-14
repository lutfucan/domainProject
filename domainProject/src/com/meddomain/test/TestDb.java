package com.meddomain.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.meddomain.entity.Domain;
import com.meddomain.entity.DomainCategory;
import com.meddomain.entity.DomainStatus;
import com.meddomain.entity.Registrar;
import com.meddomain.entity.User;
import com.meddomain.util.HibernateUtil;

public class TestDb {	
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();
		
//		@SuppressWarnings("unchecked")
//		Query<DomainCategory> query = session.createQuery("from DomainCategory");
//		List<DomainCategory> catList = query.getResultList();
//		
//		List<List<Domain>> doms = new ArrayList<>();
//		
//		for(DomainCategory cats : catList) {
//			doms.add(cats.getDomainsInCategory());
//		}
//		System.out.println(doms);
		
		Domain domain = new Domain("www.meddomain.com");
		List<DomainCategory> categories = new ArrayList<>();
		DomainStatus status = new DomainStatus("Kayýtlý");
		Registrar registrar = new Registrar("Godaddy");		
		User user = new User("Admin");
		
		DomainCategory category = new DomainCategory("jenerik");
		DomainCategory category2 = new DomainCategory("proje");
		
//		DomainCategory category = session.get(DomainCategory.class, 1);
		categories.add(category);
		categories.add(category2);
		
		domain.setCategories(categories);
		category.addDomain(domain);
		category2.addDomain(domain);

//		DomainStatus status = session.get(DomainStatus.class, 1);
		domain.setStatus(status);
		status.addDomain(domain);

//		Registrar registrar = session.get(Registrar.class, 1);
		domain.setRegistrar(registrar);
		registrar.addDomain(domain);

//		User user = session.get(User.class, 1);
		domain.setUser(user);		
		user.addDomain(domain);
		

		session.save(domain);
		session.save(category);	
		session.save(category2);
		session.save(status);	
		session.save(registrar);
		session.save(user);
		

		session.getTransaction().commit();
		session.close();
		System.out.println("Bitti");
		
	}

}