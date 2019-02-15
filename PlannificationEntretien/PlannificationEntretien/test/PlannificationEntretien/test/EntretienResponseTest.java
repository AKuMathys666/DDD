package PlannificationEntretien.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import PlannificationEntretien.exception.EntretienReponseNonCompleteException;
import PlannificationEntretien.exception.EntretienRequestNonCompleteException;
import PlannificationEntretien.model.Candidat;
import PlannificationEntretien.model.IConsultantRecruteur;
import PlannificationEntretien.model.Tech;
import PlannificationEntretien.model.Candidat;
import PlannificationEntretien.model.ConsultantRecruteur;
import PlannificationEntretien.model.testEntretienRequest;
import PlannificationEntretien.model.testEntretienResponse;

class EntretienResponseTest {

	@Test
	void test_date() {
		testEntretienResponse myEntretienResponse= new testEntretienResponse();
		myEntretienResponse.setDate(new Date());
		assertTrue(myEntretienResponse.getDate() instanceof Date);
	}
	
	@Test
	void test_consultant_recruteur() {
		testEntretienResponse myEntretienResponse= new testEntretienResponse();
		myEntretienResponse.setConsultantRecruteur(new ConsultantRecruteur());
		assertTrue(myEntretienResponse.getConsultantRecruteur() instanceof IConsultantRecruteur);
	}
	
	@Test
	void test_candidat() {
		testEntretienResponse myEntretienResponse= new testEntretienResponse();
		myEntretienResponse.setCandidat(new Candidat("Jean",22,Tech.Android));
		assertTrue(myEntretienResponse.getCandidat() instanceof Candidat);
	}
	
	@Test
	void test_numero_salle() {
		testEntretienResponse myEntretienResponse= new testEntretienResponse();
		myEntretienResponse.setSalleNumero("1");
		assertTrue(myEntretienResponse.getSalleNumero().equals("1"));
	}
	
	@Test
	void test_entretien_response_complet() {
		try {
			testEntretienResponse myEntretienResponse = new testEntretienResponse();
			myEntretienResponse.setDate(new Date());
			myEntretienResponse.setSalleNumero("1");
			myEntretienResponse.setCandidat(new Candidat("Jean",22,Tech.Android));
			myEntretienResponse.setConsultantRecruteur(new ConsultantRecruteur());
			assertTrue(myEntretienResponse.estComplete());
		}catch(EntretienReponseNonCompleteException e) {
			fail("Devrait renvoyer true");
		}
	}
	
	@Test
	void test_entretien_response_imcomplete_date() {
		try {
			testEntretienResponse myEntretienResponse = new testEntretienResponse();
			myEntretienResponse.setSalleNumero("1");
			myEntretienResponse.setCandidat(new Candidat("Jean",22,Tech.Android));
			myEntretienResponse.setConsultantRecruteur(new ConsultantRecruteur());
			myEntretienResponse.estComplete();
			fail("Devrait renvoyer une exception car EntretienResponse imcomplet");
		}catch(EntretienReponseNonCompleteException e) {
			assertThat(e.getMessage(), is("la date n'est pas défini"));
		}
	}
	
	@Test
	void test_entretien_response_imcomplete_sallenumero() {
		try {
			testEntretienResponse myEntretienResponse= new testEntretienResponse();
			myEntretienResponse.setDate(new Date());
			myEntretienResponse.setCandidat(new Candidat("Jean",22,Tech.Android));
			myEntretienResponse.setConsultantRecruteur(new ConsultantRecruteur());
			myEntretienResponse.estComplete();
			fail("Devrait renvoyer une exception car EntretienResponse imcomplet");
		}catch(EntretienReponseNonCompleteException e) {
			assertThat(e.getMessage(), is("la salle n'est pas défini"));
		}
	}
	
	@Test
	void test_entretien_response_imcomplete_candidat() {
		try {
			testEntretienResponse myEntretienResponse= new testEntretienResponse();
			myEntretienResponse.setDate(new Date());
			myEntretienResponse.setSalleNumero("1");
			myEntretienResponse.setConsultantRecruteur(new ConsultantRecruteur());
			myEntretienResponse.estComplete();
			fail("Devrait renvoyer une exception car EntretienResponse imcomplet");
		}catch(EntretienReponseNonCompleteException e) {
			assertThat(e.getMessage(), is("le candidat n'est pas défini"));
		}
	}
	
	@Test
	void test_entretien_response_imcomplete_consultant_recruteur() {
		try {
			testEntretienResponse myEntretienResponse= new testEntretienResponse();
			myEntretienResponse.setDate(new Date());
			myEntretienResponse.setSalleNumero("1");
			myEntretienResponse.setCandidat(new Candidat("Jean",22,Tech.Android));
			myEntretienResponse.estComplete();
			fail("Devrait renvoyer une exception car EntretienResponse imcomplet");
		}catch(EntretienReponseNonCompleteException e) {
			assertThat(e.getMessage(), is("le consultant recruteur n'est pas défini"));
		}
	}

}
