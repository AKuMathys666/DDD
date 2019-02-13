package PlannificationEntretien.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import PlannificationEntretien.model.ICandidat;
import PlannificationEntretien.model.testCandidat;

class CandidatTest {

	@Test
	void test_name_candidat() {
		ICandidat myCandidat = new testCandidat();
		assertTrue(myCandidat.getName().equals("jean"));
	}
	
	@Test
	void test_age_candidat() {
		ICandidat myCandidat = new testCandidat();
		assertTrue(myCandidat.getAge()==22);
	}
	
	@Test
	void test_etape_entretien_candidat() {
		ICandidat myCandidat = new testCandidat();
		assertTrue(myCandidat.getEtapeEntretien().equals("1ere etape a planifier"));
	}
	
	@Test
	void test_type_profil_candidat() {
		ICandidat myCandidat = new testCandidat();
		assertTrue(myCandidat.getTypeProfil().equals("0 a 3 ans"));
	}
	
	@Test
	void test_commentaire_consultant_candidat() {
		ICandidat myCandidat = new testCandidat();
		assertTrue(myCandidat.getCommentairesConsultants()==null);
	}

}
