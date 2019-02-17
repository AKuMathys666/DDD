package PlanificationEntretien.use_cases.Entretien;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import PlanificationEntretien.exception.AgeMineurException;
import PlanificationEntretien.exception.DureeEntretienTropLongueException;
import PlanificationEntretien.exception.HeureEntretienException;
import PlanificationEntretien.exception.HeureEntretienTropTardException;
import PlanificationEntretien.exception.NomVideException;
import PlanificationEntretien.exception.PasDeConsultantRecuteurCompatibleException;
import PlanificationEntretien.model.Candidat;
import PlanificationEntretien.model.ConsultantRecruteur;
import PlanificationEntretien.model.Creneau;
import PlanificationEntretien.model.Entretien;
import PlanificationEntretien.model.TechEnumeration;
import PlanificationEntretien.model.testEntretienRequest;

public class PlanifierEntretien {
	private Entretien monEntretien;
	private List<ConsultantRecruteur> maListeDeConsultantRecruteurs;
	
	public PlanifierEntretien(String nomCandidat, Date dateEntretien) throws NomVideException, AgeMineurException, HeureEntretienException, DureeEntretienTropLongueException, HeureEntretienTropTardException, PasDeConsultantRecuteurCompatibleException{
	
		Candidat monCandidat = getCandidatByName(nomCandidat);
		maListeDeConsultantRecruteurs = new ArrayList<ConsultantRecruteur>();
		chercherConsultantRecruteur();
		monEntretien = new Entretien();
		monEntretien.planifier(monCandidat, maListeDeConsultantRecruteurs, dateEntretien);
		sauvegarder(monEntretien);
	}
	
	//moc api get candidat by name
	private Candidat getCandidatByName(String nom) 
	{
		Candidat candidat = null;
		try {
			candidat = new Candidat("Vincent", 22, TechEnumeration.Java);
		} catch (NomVideException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AgeMineurException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return candidat;
	}
	
	//moc api consultant list
	private void chercherConsultantRecruteur() throws NomVideException
	{
		maListeDeConsultantRecruteurs.add(new ConsultantRecruteur("consultant 1", 10,TechEnumeration.Java));
		maListeDeConsultantRecruteurs.add(new ConsultantRecruteur("consultant 2", 10,TechEnumeration.DotNEt));
		maListeDeConsultantRecruteurs.add(new ConsultantRecruteur("consultant 3", 10,TechEnumeration.AngularJS));
		maListeDeConsultantRecruteurs.add(new ConsultantRecruteur("consultant 4", 10,TechEnumeration.Agile));
		maListeDeConsultantRecruteurs.add(new ConsultantRecruteur("consultant 5", 10,TechEnumeration.BigData));
		maListeDeConsultantRecruteurs.add(new ConsultantRecruteur("consultant 6", 10,TechEnumeration.Java));
		maListeDeConsultantRecruteurs.add(new ConsultantRecruteur("consultant 7", 10,TechEnumeration.DevOps));
		maListeDeConsultantRecruteurs.add(new ConsultantRecruteur("consultant 8", 10,TechEnumeration.Php));
		maListeDeConsultantRecruteurs.add(new ConsultantRecruteur("consultant 9", 10,TechEnumeration.Front));
		maListeDeConsultantRecruteurs.add(new ConsultantRecruteur("consultant 10", 10,TechEnumeration.BigData));
	}
	
	
	public void sauvegarder(Entretien entretien) {
		
	}

	public Entretien getMonEntretien() {
		return monEntretien;
	}
	
	
}
