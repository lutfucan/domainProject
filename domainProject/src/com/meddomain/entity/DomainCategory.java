package com.meddomain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "domain_category")
public class DomainCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int catId;

	private String categoryName;

	@ManyToMany(targetEntity = Domain.class, fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.SAVE_UPDATE })
	@JoinTable(name = "CAT_DOM", 
		joinColumns = @JoinColumn(name = "CATEGORY_ID"), 
		inverseJoinColumns = @JoinColumn(name = "DOMAIN_ID"))
	private List<Domain> domainsInCategory;

	public DomainCategory(String categoryName) {
		this.categoryName = categoryName;
	}

	public DomainCategory() {
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Domain> getDomainsInCategory() {
		return domainsInCategory;
	}

	public void setDomainsInCategory(List<Domain> domainsInCategory) {
		this.domainsInCategory = domainsInCategory;
	}

	public void addDomain(Domain domain) {
		if (domainsInCategory == null) {
			domainsInCategory = new ArrayList<>();
		}
		domainsInCategory.add(domain);
		domain.addCategory(this);
	}

	@Override
	public String toString() {
		return "DomainCategory [catId=" + catId + ", categoryName=" + categoryName + "]";
	}

}
