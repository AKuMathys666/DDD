package PlannificationEntretien.model;

import java.util.Date;

public class testEntretienResponse {

	private Date date;
	private IConsultantRecruteur consultantRecruteur;
	private String salleNumero;
	private ICandidat candidat;
	
	public Date getDate() {
		return date;
	}

	public IConsultantRecruteur getConsultantRecruteur() {
		return consultantRecruteur;
	}

	public ICandidat getCandidat() {
		return candidat;
	}

	public String getSalleNumero() {
		return salleNumero;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setConsultantRecruteur(IConsultantRecruteur consultantRecruteur) {
		this.consultantRecruteur = consultantRecruteur;
	}

	public void setSalleNumero(String salleNumero) {
		this.salleNumero = salleNumero;
	}

	public void setCandidat(ICandidat candidat) {
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
