package mx.edu.uacm.hibernatejpaonetoonebi.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;



@Entity
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String number;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "phone")
	private PhoneDetails details;
	
	

	public Phone() {
	}

	public Phone(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public PhoneDetails getDetails() {
		return details;
	}

	public void setDetails(PhoneDetails details) {
		this.details = details;
	}

	public Long getId() {
		return id;
	}
	
	//HELPER 
	public void addDetails(PhoneDetails details) {
		details.setPhone(this);
		this.details = details;
	}

	//HELPER
	public void removeDetails() {
		if (details != null) {
			details.setPhone(null);
			this.details = null;
		}
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", number=" + number + "]";
	}
	
	

}