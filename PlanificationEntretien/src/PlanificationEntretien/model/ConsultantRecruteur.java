package PlanificationEntretien.model;

import PlanificationEntretien.exception.AgeMineurException;
import PlanificationEntretien.exception.NomVideException;

public class ConsultantRecruteur{
	private String nom;
	private int anneeExp;
	private TechEnumeration tech;

	public ConsultantRecruteur( String nom, int anneeExp, TechEnumeration tech) throws NomVideException{
		if(nom.equals(""))
			throw new NomVideException("Le consultant n'a pas de nom.");
		this.anneeExp=anneeExp;
		this.nom = nom;
		this.tech = tech;
	}

	public String getNom() {
		return nom;
	}



	public int getAnneeExp() {
		return anneeExp;
	}



	public TechEnumeration getTech() {
		return tech;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anneeExp;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((tech == null) ? 0 : tech.hashCode());
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
		ConsultantRecruteur other = (ConsultantRecruteur) obj;
		if (anneeExp != other.anneeExp)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (tech != other.tech)
			return false;
		return true;
	}
	
	
	
}
