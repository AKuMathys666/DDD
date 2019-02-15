package PlannificationEntretien.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import PlannificationEntretien.model.Candidat;
import PlannificationEntretien.model.Tech;
import PlannificationEntretien.model.Candidat;

class CandidatTest {

	@Test
	void test_name_candidat() {
		Candidat myCandidat = new Candidat("Jean",34,Tech.Agile);
		assertTrue(myCandidat.getName().equals("jean"));
	}
	
	@Test
	void test_age_candidat() {
		Candidat myCandidat = new Candidat("Jean",22,Tech.Agile);
		assertTrue(myCandidat.getAge()==22);
	}
	
	@Test
	void test_tech_candidat() {
		Candidat myCandidat = new Candidat("Jean",34,Tech.Agile);
		assertTrue(myCandidat.getTech() == Tech.Agile);
	}
	
	@Test
	void test_meme_candidat() {
		Candidat myCandidat = new Candidat("Jean",34,Tech.Agile);
		Candidat myCandidat2 = new Candidat("Jean",34,Tech.Agile);
		assertTrue(myCandidat.equals(myCandidat2));
	}

}
