package PlanificationEntretien.model;

import PlanificationEntretien.exception.AgeMineurException;
import PlanificationEntretien.exception.NomVideException;

public class ConsultantRecruteur{
	private String nom;
	private int anneeExp;
	private TechEnumeration tech;

	
	public ConsultantRecruteur( String nom, int anneeExp, TechEnumeration tech) throws NomVideException{
		if(!nom.equals(""))
			throw new NomVideException("Le consultant n'a pas de nom.");
		this.anneeExp=anneeExp;
		this.nom = nom;
		this.tech = tech;
	}
	
}
