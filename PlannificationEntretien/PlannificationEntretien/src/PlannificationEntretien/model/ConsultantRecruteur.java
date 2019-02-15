package PlannificationEntretien.model;

import PlannificationEntretien.exception.AgeMineurException;
import PlannificationEntretien.exception.NomVideException;

public class ConsultantRecruteur{
	private String nom;
	private int anneeExp;
	private Tech tech;

	
	public ConsultantRecruteur( String nom, int age, Tech tech) throws NomVideException{
		if(!nom.equals(""))
			throw new NomVideException("Le candidat n'a pas de nom.");		
		this.nom = nom;
		this.tech = tech;
	}
	
}
