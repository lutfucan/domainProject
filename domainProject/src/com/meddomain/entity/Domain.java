package com.meddomain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "domain")
public class Domain implements Serializable {

	private static final long serialVersionUID = -5618155266470092377L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int domId;

	private String fullDomainName;

	private String extension;

	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.SAVE_UPDATE })
	@JoinColumn(name = "registrar_fk")
	private Registrar registrar;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date registerDate = new Date();

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date expirationDate = new Date();

	@ManyToMany(targetEntity = DomainCategory.class, fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.SAVE_UPDATE })
	@JoinTable(name = "CAT_DOM", 
		joinColumns = @JoinColumn(name = "DOMAIN_ID"), 
		inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID"))
	private List<DomainCategory> categories;

	@ElementCollection
	@CollectionTable(name = "offers", joinColumns = @JoinColumn(name = "domain_id"))
	@Column(name = "offers")
	private List<Double> offers;

	private double cost;

	private double minimumPrice;

	private double askingPrice;

	private double maxPrice;

	@ManyToOne
	@Cascade(value = { CascadeType.SAVE_UPDATE })
	@JoinColumn(name = "status_fk")
	private DomainStatus status;

	@ManyToOne
	@Cascade(value = { CascadeType.SAVE_UPDATE })
	@JoinColumn(name = "user_fk")
	private User user;

	public Domain(String fullDomainName) {
		this.fullDomainName = fullDomainName;
	}

	public Domain() {
	}

	public int getDomId() {
		return domId;
	}

	public void setDomId(int id) {
		this.domId = id;
	}

	public String getFullDomainName() {
		return fullDomainName;
	}

	public void setFullDomainName(String fullDomainName) {
		this.fullDomainName = fullDomainName;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public Registrar getRegistrar() {
		return registrar;
	}

	public void setRegistrar(Registrar registrar) {
		this.registrar = registrar;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public List<DomainCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<DomainCategory> categories) {
		this.categories = categories;
	}

	public List<Double> getOffers() {
		return offers;
	}

	public void setOffers(List<Double> offers) {
		this.offers = offers;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getMinimumPrice() {
		return minimumPrice;
	}

	public void setMinimumPrice(double minimumPrice) {
		this.minimumPrice = minimumPrice;
	}

	public double getAskingPrice() {
		return askingPrice;
	}

	public void setAskingPrice(double askingPrice) {
		this.askingPrice = askingPrice;
	}

	public double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public DomainStatus getStatus() {
		return status;
	}

	public void setStatus(DomainStatus status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void addCategory(DomainCategory category) {
		if (categories == null) {
			System.out.println("null idi");
			categories = new ArrayList<>();
		}
		System.out.println("null deðil idi");
		categories.add(category);
	}

	@Override
	public String toString() {
		return "Domain [id=" + domId + ", fullDomainName=" + fullDomainName + ", registrar=" + registrar
				+ ", registerDate=" + registerDate + ", expirationDate=" + expirationDate + ", categories=" + categories
				+ ", offers=" + offers + ", cost=" + cost + ", minimumPrice=" + minimumPrice + ", askingPrice="
				+ askingPrice + ", maxPrice=" + maxPrice + ", status=" + status + ", user=" + user + "]";
	}

}
