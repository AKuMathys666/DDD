package PlanificationEntretien.test;

import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;

import PlanificationEntretien.exception.DureeEntretienTropLongueException;
import PlanificationEntretien.exception.HeureEntretienException;
import PlanificationEntretien.exception.HeureEntretienTropTardException;
import PlanificationEntretien.model.Creneau;

public class CreneauTest {

	@Test
	public void test_debut_creneau_trop_tot() throws DureeEntretienTropLongueException, HeureEntretienTropTardException {
		try {
			Date d = new Date(2019,2,15,8,59);
			Creneau c = new Creneau(d,120);
			fail("Devrait renvoyer une exception car Heure entretien trop tot");
		}catch(HeureEntretienException e) {
			e.printStackTrace();
			assert(e.getMessage().equals("Heure debut d'entretien trop tot"));
		}
	}
	
	@Test
	public void test_debut_creneau_trop_tard() throws DureeEntretienTropLongueException, HeureEntretienTropTardException {
		try {
			Date d = new Date(2019,2,15,19,00);
			Creneau c = new Creneau(d,120);
			fail("Devrait renvoyer une exception car Heure entretien trop tard");
		}catch(HeureEntretienException e) {
			e.printStackTrace();
			assert(e.getMessage().equals("Heure debut d'entretien trop tard"));
		}
	}
	
	@Test
	public void test_duree_creneau_trop_longue() throws DureeEntretienTropLongueException, HeureEntretienTropTardException, HeureEntretienException {
		
		try {
			Creneau c = new Creneau(new Date(2019,2,15,9,00),181);
			fail("Devrait renvoyer une exception car Heure entretien trop longue");
		}catch(DureeEntretienTropLongueException e) {
			e.printStackTrace();
			assert(e.getMessage().equals("Duree entretien trop longue"));
		}
	}
	
	@Test
	public void test_fin_creneau_trop_tard()  throws DureeEntretienTropLongueException, HeureEntretienTropTardException, HeureEntretienException {
		
		try {
			Creneau c = new Creneau(new Date(2019,2,15,18,00),180);
			fail("Devrait renvoyer une exception car fin de creneau trop tard");
		}catch(HeureEntretienTropTardException e) {
			e.printStackTrace();
			assert(e.getMessage().equals("Heure de fin d'entretien trop tard"));
		}
	}
	

}
