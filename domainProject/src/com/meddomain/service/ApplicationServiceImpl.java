package com.meddomain.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meddomain.dao.CategoryDao;
import com.meddomain.dao.DomainDao;
import com.meddomain.dao.RegistrarDao;
import com.meddomain.dao.StatusDao;
import com.meddomain.dao.UserDao;
import com.meddomain.entity.Domain;
import com.meddomain.entity.DomainCategory;
import com.meddomain.entity.DomainStatus;
import com.meddomain.entity.Registrar;
import com.meddomain.entity.User;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	DomainDao domainDao;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	StatusDao statusDao;
	@Autowired
	RegistrarDao registrarDao;
	@Autowired
	UserDao userDao;

	@Override
	@Transactional
	public void merge(Domain domain) {
		domainDao.merge(domain);		
	}

	@Override
	@Transactional
	public void merge(Registrar registrar) {
		registrarDao.merge(registrar);
	}

	@Override
	@Transactional
	public void merge(DomainStatus status) {
		statusDao.merge(status);
	}

	@Override
	@Transactional
	public void merge(DomainCategory category) {
		categoryDao.merge(category);
	}

	@Override
	@Transactional
	public void merge(User user) {
		userDao.merge(user);
	}
	
	@Override
	@Transactional
	public List<Domain> getDomainsList() {		
		return domainDao.getDomainsList();
	}

	@Override
	@Transactional
	public List<Registrar> getRegistrarList() {
		return registrarDao.getRegistrarList();
	}

	@Override
	@Transactional
	public List<DomainStatus> getStatusList() {
		return statusDao.getStatusList();
	}

	@Override
	@Transactional
	public List<DomainCategory> getCategoryList() {
		return categoryDao.getCategoryList();
	}

	@Override
	@Transactional
	public List<User> getUserList() {
		return userDao.getUserList();
	}

	@Override
	@Transactional
	public Domain getDomain(Class<Domain> class1, Integer domainId) {
		return domainDao.getDomain(class1,domainId);
	}

	@Override
	@Transactional
	public Registrar getRegistrar(Class<Registrar> class1, Integer registrarId) {
		return registrarDao.getRegistrar(class1,registrarId);
	}

	@Override
	@Transactional
	public DomainStatus getStatus(Class<DomainStatus> class1, Integer stId) {
		return statusDao.getStatus(class1, stId);
	}

	@Override
	@Transactional
	public DomainCategory getCategory(Class<DomainCategory> class1, Integer categoryId) {
		return categoryDao.getCategory(class1, categoryId);
	}

	@Override
	@Transactional
	public User getUser(Class<User> class1, Integer userId) {
		return userDao.getUser(class1, userId);
	}

	@Override
	@Transactional
	public void deleteDomain(int domainId) {
		domainDao.delete(domainId);		
	}

	@Override
	@Transactional
	public void deleteRegistrar(int registrarId) {
		registrarDao.delete(registrarId);
	}

	@Override
	@Transactional
	public void deleteUser(int userId) {
		userDao.delete(userId);
	}

	@Override
	@Transactional
	public void deleteStatus(int statusId) {
		statusDao.delete(statusId);
	}

	@Override
	@Transactional
	public void deleteCategory(int categoryId) {
		categoryDao.delete(categoryId);
	}

}
