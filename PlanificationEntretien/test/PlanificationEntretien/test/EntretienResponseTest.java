package PlanificationEntretien.test;

import static org.hamcrest.CoreMatchers.is; 
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import PlanificationEntretien.exception.AgeMineurException;
import PlanificationEntretien.exception.EntretienReponseNonCompleteException;
import PlanificationEntretien.exception.EntretienRequestNonCompleteException;
import PlanificationEntretien.exception.NomVideException;
import PlanificationEntretien.model.Candidat;
import PlanificationEntretien.model.ConsultantRecruteur;
import PlanificationEntretien.model.TechEnumeration;
import PlanificationEntretien.model.testEntretienRequest;
import PlanificationEntretien.model.testEntretienResponse;

class EntretienResponseTest {

	@Test
	void test_date() {
		testEntretienResponse myEntretienResponse= new testEntretienResponse();
		myEntretienResponse.setDate(new Date());
		assertTrue(myEntretienResponse.getDate() instanceof Date);
	}
	
	@Test
	void test_consultant_recruteur() throws NomVideException {
		testEntretienResponse myEntretienResponse= new testEntretienResponse();
		myEntretienResponse.setConsultantRecruteur(new ConsultantRecruteur(null, 0, null));
		assertTrue(myEntretienResponse.getConsultantRecruteur() instanceof ConsultantRecruteur);
	}
	
	@Test
	void test_candidat() throws NomVideException, AgeMineurException {
		testEntretienResponse myEntretienResponse= new testEntretienResponse();
		myEntretienResponse.setCandidat(new Candidat("Jean",22,TechEnumeration.Android));
		assertTrue(myEntretienResponse.getCandidat() instanceof Candidat);
	}
	
	@Test
	void test_numero_salle() {
		testEntretienResponse myEntretienResponse= new testEntretienResponse();
		myEntretienResponse.setSalleNumero("1");
		assertTrue(myEntretienResponse.getSalleNumero().equals("1"));
	}
	
	@Test
	void test_entretien_response_complet() throws NomVideException, AgeMineurException {
		try {
			testEntretienResponse myEntretienResponse = new testEntretienResponse();
			myEntretienResponse.setDate(new Date());
			myEntretienResponse.setSalleNumero("1");
			myEntretienResponse.setCandidat(new Candidat("Jean",22,TechEnumeration.Android));
			myEntretienResponse.setConsultantRecruteur(new ConsultantRecruteur("test", 33, TechEnumeration.Android));
			assertTrue(myEntretienResponse.estComplete());
		}catch(EntretienReponseNonCompleteException e) {
			fail("Devrait renvoyer true");
		}
	}
	
	@Test
	void test_entretien_response_imcomplete_date() throws NomVideException, AgeMineurException {
		try {
			testEntretienResponse myEntretienResponse = new testEntretienResponse();
			myEntretienResponse.setSalleNumero("1");
			myEntretienResponse.setCandidat(new Candidat("Jean",22,TechEnumeration.Android));
			myEntretienResponse.setConsultantRecruteur(new ConsultantRecruteur("test", 33, TechEnumeration.Android));
			myEntretienResponse.estComplete();
			fail("Devrait renvoyer une exception car EntretienResponse imcomplet");
		}catch(EntretienReponseNonCompleteException e) {
			assertThat(e.getMessage(), is("la date n'est pas défini"));
		}
	}
	
	@Test
	void test_entretien_response_imcomplete_sallenumero() throws NomVideException, AgeMineurException {
		try {
			testEntretienResponse myEntretienResponse= new testEntretienResponse();
			myEntretienResponse.setDate(new Date());
			myEntretienResponse.setCandidat(new Candidat("Jean",22,TechEnumeration.Android));
			myEntretienResponse.setConsultantRecruteur(new ConsultantRecruteur("test", 33, TechEnumeration.Android));
			myEntretienResponse.estComplete();
			fail("Devrait renvoyer une exception car EntretienResponse imcomplet");
		}catch(EntretienReponseNonCompleteException e) {
			assertThat(e.getMessage(), is("la salle n'est pas défini"));
		}
	}
	
	@Test
	void test_entretien_response_imcomplete_candidat() throws NomVideException {
		try {
			testEntretienResponse myEntretienResponse= new testEntretienResponse();
			myEntretienResponse.setDate(new Date());
			myEntretienResponse.setSalleNumero("1");
			myEntretienResponse.setConsultantRecruteur(new ConsultantRecruteur("test", 33, TechEnumeration.Android));
			myEntretienResponse.estComplete();
			fail("Devrait renvoyer une exception car EntretienResponse imcomplet");
		}catch(EntretienReponseNonCompleteException e) {
			assertThat(e.getMessage(), is("le candidat n'est pas défini"));
		}
	}
	
	@Test
	void test_entretien_response_imcomplete_consultant_recruteur() throws NomVideException, AgeMineurException {
		try {
			testEntretienResponse myEntretienResponse= new testEntretienResponse();
			myEntretienResponse.setDate(new Date());
			myEntretienResponse.setSalleNumero("1");
			myEntretienResponse.setCandidat(new Candidat("Jean",22,TechEnumeration.Android));
			myEntretienResponse.estComplete();
			fail("Devrait renvoyer une exception car EntretienResponse imcomplet");
		}catch(EntretienReponseNonCompleteException e) {
			assertThat(e.getMessage(), is("le consultant recruteur n'est pas défini"));
		}
	}

}
