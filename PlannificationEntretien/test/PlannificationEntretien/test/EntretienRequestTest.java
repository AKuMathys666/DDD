package PlannificationEntretien.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue; 
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import PlannificationEntretien.model.EntretienRequestNonCompleteException;
import PlannificationEntretien.model.ICandidat;
import PlannificationEntretien.model.testCandidat;
import PlannificationEntretien.model.testEntretienRequest;

class EntretienRequestTest {

	@Test
	void test_name() {
		testEntretienRequest myEntretienRequest= new testEntretienRequest();
		myEntretienRequest.setNom("Juan");
		assertTrue(myEntretienRequest.getNom().equals("Juan"));
	}
	@Test
	void test_date() {
		testEntretienRequest myEntretienRequest= new testEntretienRequest();
		myEntretienRequest.setDate(new Date());
		assertTrue(myEntretienRequest.getDate() instanceof Date);
	}

	@Test
	void test_entretien_request_non_complete() {
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
	void test_entretien_request_complete() {
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
