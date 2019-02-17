package PlanificationEntretien.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import PlanificationEntretien.exception.DureeEntretienTropLongueException;
import PlanificationEntretien.exception.HeureEntretienException;
import PlanificationEntretien.exception.HeureEntretienTropTardException;
import PlanificationEntretien.exception.PasDeConsultantRecuteurCompatibleException;

public class Entretien {
	
	private static int entretienCompteur = 0;
	private int entretienId;
	private Candidat candidat;
	private ConsultantRecruteur cRecruteur;
	private Salle salle;
	private Creneau creneau;
	private Date date;
	private EtatEnumeration etat;
	
	public Entretien() {
		entretienId = entretienCompteur++;
	}
	
	public void planifier(Candidat c, List<ConsultantRecruteur> cr, Date date) throws PasDeConsultantRecuteurCompatibleException, HeureEntretienException, DureeEntretienTropLongueException, HeureEntretienTropTardException{
		this.candidat = c;
		List<ConsultantRecruteur> listeConsultantRecruteurCompatible = peutTester(c,cr);
		//Test de disponibilité
		cRecruteur = prendrePremier(listeConsultantRecruteurCompatible);
		creneau = new Creneau(date,180);
		etat = EtatEnumeration.Planifie;
	}
	
	public List<ConsultantRecruteur> peutTester(Candidat candidat, List<ConsultantRecruteur> listeConsultantRecruteur) throws PasDeConsultantRecuteurCompatibleException{
		List<ConsultantRecruteur> listeConsultantRecruteurCompatible = new ArrayList<ConsultantRecruteur>();
		for(ConsultantRecruteur recruteur : listeConsultantRecruteur) {
			if(recruteur.getTech() == candidat.getTech()) {
				listeConsultantRecruteurCompatible.add(recruteur);
			}
		}
		if(listeConsultantRecruteurCompatible.size() == 0 )
			throw new PasDeConsultantRecuteurCompatibleException();
		return listeConsultantRecruteurCompatible;
	}
	
	public ConsultantRecruteur prendrePremier(List<ConsultantRecruteur> listeConsultantRecruteurCompatible) {
		return listeConsultantRecruteurCompatible.get(0);
	}

	public Candidat getCandidat() {
		return candidat;
	}

	public ConsultantRecruteur getcRecruteur() {
		return cRecruteur;
	}

	public Salle getSalle() {
		return salle;
	}

	public Creneau getCreneau() {
		return creneau;
	}

	public Date getDate() {
		return date;
	}

	public EtatEnumeration getEtat() {
		return etat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cRecruteur == null) ? 0 : cRecruteur.hashCode());
		result = prime * result + ((candidat == null) ? 0 : candidat.hashCode());
		result = prime * result + ((creneau == null) ? 0 : creneau.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((etat == null) ? 0 : etat.hashCode());
		result = prime * result + ((salle == null) ? 0 : salle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entretien other = (Entretien) obj;
		if (cRecruteur == null) {
			if (other.cRecruteur != null)
				return false;
		} else if (!cRecruteur.equals(other.cRecruteur))
			return false;
		if (candidat == null) {
			if (other.candidat != null)
				return false;
		} else if (!candidat.equals(other.candidat))
			return false;
		if (creneau == null) {
			if (other.creneau != null)
				return false;
		} else if (!creneau.equals(other.creneau))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (etat != other.etat)
			return false;
		if (salle == null) {
			if (other.salle != null)
				return false;
		} else if (!salle.equals(other.salle))
			return false;
		return true;
	}
	
	
}
