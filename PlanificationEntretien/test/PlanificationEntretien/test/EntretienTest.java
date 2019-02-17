package PlanificationEntretien.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import PlanificationEntretien.exception.AgeMineurException;
import PlanificationEntretien.exception.DureeEntretienTropLongueException;
import PlanificationEntretien.exception.HeureEntretienException;
import PlanificationEntretien.exception.HeureEntretienTropTardException;
import PlanificationEntretien.exception.NomVideException;
import PlanificationEntretien.exception.PasDeConsultantRecuteurCompatibleException;
import PlanificationEntretien.model.Candidat;
import PlanificationEntretien.model.ConsultantRecruteur;
import PlanificationEntretien.model.Entretien;
import PlanificationEntretien.model.TechEnumeration;

public class EntretienTest {
	
	@Test 
	public void test_meme_entretien() {
		Date date = new Date(2019,02,17,10,00);
		List<ConsultantRecruteur> listConsultantRecruteur = new ArrayList<ConsultantRecruteur>();
		try {
			listConsultantRecruteur.add(new ConsultantRecruteur("Jean", 2, TechEnumeration.Agile));
			listConsultantRecruteur.add(new ConsultantRecruteur("Paul", 4, TechEnumeration.DotNEt));
			listConsultantRecruteur.add(new ConsultantRecruteur("Bel", 6, TechEnumeration.Front));
			listConsultantRecruteur.add(new ConsultantRecruteur("Mondo", 8, TechEnumeration.Agile));
			Candidat candidat = new Candidat("George", 35, TechEnumeration.Java);
			Entretien entretien = new Entretien();
			entretien.planifier(candidat, listConsultantRecruteur, date);
			Entretien entretien2 = entretien;
			assertTrue(entretien.equals(entretien2));
		} catch (NomVideException | AgeMineurException e) {
			e.printStackTrace();
			fail("Devrait lever une excetion PasDeConsultantRecuteurCompatibleException");
		} catch (HeureEntretienException e) {
			e.printStackTrace();
			fail("Devrait lever une excetion PasDeConsultantRecuteurCompatibleException");
		} catch (DureeEntretienTropLongueException e) {
			e.printStackTrace();
			fail("Devrait lever une excetion PasDeConsultantRecuteurCompatibleException");
		} catch (HeureEntretienTropTardException e) {
			e.printStackTrace();
			fail("Devrait lever une excetion PasDeConsultantRecuteurCompatibleException");
		} catch (PasDeConsultantRecuteurCompatibleException e) {
			
		}
	}

	@Test
	public void test_pas_de_recruteur_compatible() {
		Date date = new Date(2019,02,17,10,00);
		List<ConsultantRecruteur> listConsultantRecruteur = new ArrayList<ConsultantRecruteur>();
		try {
			listConsultantRecruteur.add(new ConsultantRecruteur("Jean", 2, TechEnumeration.Agile));
			listConsultantRecruteur.add(new ConsultantRecruteur("Paul", 4, TechEnumeration.DotNEt));
			listConsultantRecruteur.add(new ConsultantRecruteur("Bel", 6, TechEnumeration.Front));
			listConsultantRecruteur.add(new ConsultantRecruteur("Mondo", 8, TechEnumeration.Agile));
			Candidat candidat = new Candidat("George", 35, TechEnumeration.Java);
			Entretien entretien = new Entretien();
			entretien.planifier(candidat, listConsultantRecruteur, date);
			fail("Devrait lever une excetion PasDeConsultantRecuteurCompatibleException");
		} catch (NomVideException | AgeMineurException e) {
			e.printStackTrace();
			fail("Devrait lever une excetion PasDeConsultantRecuteurCompatibleException");
		} catch (HeureEntretienException e) {
			e.printStackTrace();
			fail("Devrait lever une excetion PasDeConsultantRecuteurCompatibleException");
		} catch (DureeEntretienTropLongueException e) {
			e.printStackTrace();
			fail("Devrait lever une excetion PasDeConsultantRecuteurCompatibleException");
		} catch (HeureEntretienTropTardException e) {
			e.printStackTrace();
			fail("Devrait lever une excetion PasDeConsultantRecuteurCompatibleException");
		} catch (PasDeConsultantRecuteurCompatibleException e) {
			
		}

	}

}
