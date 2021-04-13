package mx.edu.uacm.hibernatejpaonetoonebi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class PhoneDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String provider;

	private String technology;
	
	@OneToOne
	@JoinColumn(name="phone_id")
	private Phone phone;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public PhoneDetails() {
	}

	public PhoneDetails(String provider, String technology) {
		this.provider = provider;
		this.technology = technology;
	}

	public String getProvider() {
		return provider;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	@Override
	public String toString() {
		return "PhoneDetails [id=" + id + ", provider=" + provider + ", technology=" + technology + ", phone=" + phone
				+ "]";
	}
	
	

}
