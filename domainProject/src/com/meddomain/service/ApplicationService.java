package com.meddomain.service;

import java.util.List;
import com.meddomain.entity.Domain;
import com.meddomain.entity.DomainCategory;
import com.meddomain.entity.DomainStatus;
import com.meddomain.entity.Registrar;
import com.meddomain.entity.User;

public interface ApplicationService {
	

	public void merge(Domain domain);

	public void merge(Registrar registrar);

	public void merge(DomainStatus status);

	public void merge(User user);
	
	public void merge(DomainCategory category);
	
	public List<Domain> getDomainsList();

	public List<Registrar> getRegistrarList();

	public List<DomainStatus> getStatusList();
	
	public List<DomainCategory> getCategoryList();
	
	public List<User> getUserList();

	public Registrar getRegistrar(Class<Registrar> class1, Integer registrarId);

	public DomainStatus getStatus(Class<DomainStatus> class1, Integer stId);
	
	public DomainCategory getCategory(Class<DomainCategory> class1, Integer categoryId);

	public Domain getDomain(Class<Domain> class1, Integer domainId);

	public User getUser(Class<User> class1, Integer userId);
	
	public void deleteDomain(int domainId);
	
	public void deleteRegistrar(int registrarId);
	
	public void deleteUser(int userId);
	
	public void deleteStatus(int statusId);
	
	public void deleteCategory(int categoryId);
	
	
}
