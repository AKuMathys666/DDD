package PlanificationEntretien.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import PlanificationEntretien.exception.AgeMineurException;
import PlanificationEntretien.exception.EntretienRequestNonCompleteException;
import PlanificationEntretien.exception.NomVideException;
import PlanificationEntretien.model.Candidat;
import PlanificationEntretien.model.TechEnumeration;
import PlanificationEntretien.model.testEntretienRequest;

public class CandidatTest {

	@Test
	public void test_name_candidat() throws NomVideException, AgeMineurException {
		Candidat myCandidat = new Candidat("Jean",34,TechEnumeration.Agile);
		assertTrue(myCandidat.getName().equals("Jean"));
	}
	
	@Test
	public void test_age_candidat() throws NomVideException, AgeMineurException {
		Candidat myCandidat = new Candidat("Jean",22,TechEnumeration.Agile);
		assertTrue(myCandidat.getAge()==22);
	}
	
	@Test
	public void test_tech_candidat() throws NomVideException, AgeMineurException {
		Candidat myCandidat = new Candidat("Jean",34,TechEnumeration.Agile);
		assertTrue(myCandidat.getTech() == TechEnumeration.Agile);
	}
	
	@Test
	public void test_meme_candidat() throws NomVideException, AgeMineurException {
		Candidat myCandidat = new Candidat("Jean",34,TechEnumeration.Agile);
		Candidat myCandidat2 = new Candidat("Jean",34,TechEnumeration.Agile);
		assertTrue(myCandidat.equals(myCandidat2));
	}

}
