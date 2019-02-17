package PlanificationEntretien.test;

import static org.hamcrest.CoreMatchers.is; 
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;

import PlanificationEntretien.exception.EntretienRequestNonCompleteException;
import PlanificationEntretien.model.Candidat;
import PlanificationEntretien.model.testEntretienRequest;

public class EntretienRequestTest {

	@Test
	public void test_name() {
		testEntretienRequest myEntretienRequest= new testEntretienRequest();
		myEntretienRequest.setNom("Juan");
		assertTrue(myEntretienRequest.getNom().equals("Juan"));
	}
	@Test
	public void test_date() {
		testEntretienRequest myEntretienRequest= new testEntretienRequest();
		myEntretienRequest.setDate(new Date());
		assertTrue(myEntretienRequest.getDate() instanceof Date);
	}

	@Test
	public void test_entretien_request_non_complete() {
		try {
			testEntretienRequest entretienRequest = new testEntretienRequest();
			entretienRequest.setNom("Juan");
			entretienRequest.estComplete();
			fail("Devrait renvoyer une exception car EntretienRequest imcomplet");
		}catch(EntretienRequestNonCompleteException e) {
			assertThat(e.getMessage(), is("date n'est pas défini"));
		}
	}
	
	@Test
	public void test_entretien_request_complete() {
			testEntretienRequest entretienRequest = new testEntretienRequest();
			entretienRequest.setNom("Juan");
			entretienRequest.setDate(new Date());
			try {
				assertTrue(entretienRequest.estComplete());
			}catch(EntretienRequestNonCompleteException e) {
				fail("Devrait renvoyer true");
			}
	}
}
