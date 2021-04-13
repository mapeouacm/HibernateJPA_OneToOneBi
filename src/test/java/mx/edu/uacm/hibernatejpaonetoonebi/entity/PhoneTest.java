package mx.edu.uacm.hibernatejpaonetoonebi.entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;



@SpringBootTest
public class PhoneTest {
	
	private static final Logger log = LogManager.getLogger(PhoneTest.class);
	
	@PersistenceContext
	private EntityManager em;
	
	
	@Test
	@Transactional
	@Rollback(false)
	public void debeGuardarPhoneConDetails() {
		log.debug("> Entrando al metodo debeGuardarPhoneConDetails <");
		Phone phone = new Phone("954000003");
		
		PhoneDetails details = new PhoneDetails("Movistar", "Fijo");
		
		//Uso de helper
		//phone.addDetails(details);
		
		
		
		//De detalles hacia telefono
		details.setPhone(phone);
		
		//De telefono hacia detalles
		phone.setDetails(details);
		
		em.persist(phone);
		
		Phone phoneRecuperado = em.find(Phone.class, 1L);
		
		log.debug(phoneRecuperado.getDetails().toString()); 
		
		PhoneDetails detailsRecuperado = em.find(PhoneDetails.class, 1L);
		
		log.debug(detailsRecuperado.getPhone().toString());

		
	}

}
