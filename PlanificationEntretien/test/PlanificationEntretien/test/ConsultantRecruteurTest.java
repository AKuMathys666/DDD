package PlanificationEntretien.test;

import static org.junit.Assert.*;

import org.junit.Test;

import PlanificationEntretien.exception.NomVideException;
import PlanificationEntretien.model.ConsultantRecruteur;
import PlanificationEntretien.model.TechEnumeration;

public class ConsultantRecruteurTest {

	@Test
	public void test_consultant_sans_nom() {
		try {
			ConsultantRecruteur myConsultantRecruteur = new ConsultantRecruteur("",48,TechEnumeration.Agile);
			fail("Devrait lever une exception car le le consultant recruteur n'a pas de nom");
		} catch (NomVideException e) {
			e.printStackTrace();
			assert(e.getMessage().equals("Le consultant n'a pas de nom."));
		}
	}


}
