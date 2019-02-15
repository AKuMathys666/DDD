package PlanificationEntretien.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import PlanificationEntretien.exception.AgeMineurException;
import PlanificationEntretien.exception.EntretienRequestNonCompleteException;
import PlanificationEntretien.exception.NomVideException;
import PlanificationEntretien.model.Candidat;
import PlanificationEntretien.model.TechEnumeration;
import PlanificationEntretien.model.testEntretienRequest;

class CandidatTest {

	@Test
	void test_name_candidat() throws NomVideException, AgeMineurException {
		Candidat myCandidat = new Candidat("Jean",34,TechEnumeration.Agile);
		assertTrue(myCandidat.getName().equals("jean"));

	}
	
	@Test
	void test_age_candidat() throws NomVideException, AgeMineurException {
		Candidat myCandidat = new Candidat("Jean",22,TechEnumeration.Agile);
		assertTrue(myCandidat.getAge()==22);
	}
	
	@Test
	void test_tech_candidat() throws NomVideException, AgeMineurException {
		Candidat myCandidat = new Candidat("Jean",34,TechEnumeration.Agile);
		assertTrue(myCandidat.getTech() == TechEnumeration.Agile);
	}
	
	@Test
	void test_meme_candidat() throws NomVideException, AgeMineurException {
		Candidat myCandidat = new Candidat("Jean",34,TechEnumeration.Agile);
		Candidat myCandidat2 = new Candidat("Jean",34,TechEnumeration.Agile);
		assertTrue(myCandidat.equals(myCandidat2));
	}

}
