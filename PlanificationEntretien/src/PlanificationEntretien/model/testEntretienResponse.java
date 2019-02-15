package PlanificationEntretien.model;

import java.util.Date;

import PlanificationEntretien.exception.EntretienReponseNonCompleteException;

public class testEntretienResponse {

	private Date date;
	private ConsultantRecruteur consultantRecruteur;
	private String salleNumero;
	private Candidat candidat;
	
	public Date getDate() {
		return date;
	}

	public ConsultantRecruteur getConsultantRecruteur() {
		return consultantRecruteur;
	}

	public Candidat getCandidat() {
		return candidat;
	}

	public String getSalleNumero() {
		return salleNumero;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setConsultantRecruteur(ConsultantRecruteur consultantRecruteur) {
		this.consultantRecruteur = consultantRecruteur;
	}

	public void setSalleNumero(String salleNumero) {
		this.salleNumero = salleNumero;
	}

	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}

	public boolean estComplete()  throws EntretienReponseNonCompleteException{
			if(getDate() == null)
				throw new EntretienReponseNonCompleteException("la date n'est pas d�fini");
			if(getSalleNumero() == null)
				throw new EntretienReponseNonCompleteException("la salle n'est pas d�fini");
			if(getCandidat() == null)
				throw new EntretienReponseNonCompleteException("le candidat n'est pas d�fini");
			if(getConsultantRecruteur() == null)
				throw new EntretienReponseNonCompleteException("le consultant recruteur n'est pas d�fini");
			return true;
		
	}

}
