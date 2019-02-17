package PlanificationEntretien.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import PlanificationEntretien.exception.AgeMineurException;
import PlanificationEntretien.exception.DureeEntretienTropLongueException;
import PlanificationEntretien.exception.HeureEntretienException;
import PlanificationEntretien.exception.HeureEntretienTropTardException;
import PlanificationEntretien.exception.NomVideException;
import PlanificationEntretien.exception.PasDeConsultantRecuteurCompatibleException;
import PlanificationEntretien.model.EtatEnumeration;
import PlanificationEntretien.use_cases.Entretien.PlanifierEntretien;

public class PlanifierEntretienTest {

	@Test
	public void test_entretien_planifie() {
		String nomCandidat = "Jean";
		Date date = new Date(2017,5,5,10,00);
		try {
			PlanifierEntretien planifieur = new PlanifierEntretien(nomCandidat,date);
			assertTrue(planifieur.getMonEntretien().getEtat() == EtatEnumeration.Planifie);
		} catch (NomVideException | AgeMineurException | HeureEntretienException | DureeEntretienTropLongueException
				| HeureEntretienTropTardException | PasDeConsultantRecuteurCompatibleException e) {
			e.printStackTrace();
			fail("L'entretien n'a pas pu etre planifie");
		}
		
	}
	
	@Test
	public void test_entretien_trop_tot() {
		String nomCandidat = "Jean";
		Date date = new Date(2017,5,5,8,00);
		try {
			PlanifierEntretien planifieur = new PlanifierEntretien(nomCandidat,date);
			fail("L'entretien de ne devrait pas etre planifie car l'heure de debut est trop tot");
		} catch (NomVideException | AgeMineurException | HeureEntretienException | DureeEntretienTropLongueException
				| HeureEntretienTropTardException | PasDeConsultantRecuteurCompatibleException e) {
			e.printStackTrace();
			assertTrue(e.getMessage().equals("Heure debut d'entretien trop tot"));
		}
		
	}
	
	@Test 
	public void test_entretien_trop_tard() {
		String nomCandidat = "Jean";
		Date date = new Date(2017,5,5,20,00);
		try {
			PlanifierEntretien planifieur = new PlanifierEntretien(nomCandidat,date);
			fail("L'entretien de ne devrait pas etre planifie car l'heure de fin est trop tard");
		} catch (NomVideException | AgeMineurException | HeureEntretienException | DureeEntretienTropLongueException
				| HeureEntretienTropTardException | PasDeConsultantRecuteurCompatibleException e) {
			e.printStackTrace();
			assertTrue(e.getMessage().equals("Heure debut d'entretien trop tard"));
		}
		
	}

}
