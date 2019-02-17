package PlanificationEntretien.model;

import PlanificationEntretien.exception.AgeMineurException;
import PlanificationEntretien.exception.NomVideException;

public class Candidat{
	
	private String name;
	private int age;
	private TechEnumeration tech;
	
	public Candidat( String name, int age, TechEnumeration tech) throws NomVideException, AgeMineurException{
		if(name.equals(""))
			throw new NomVideException("Le candidat n'a pas de nom.");
		if(age < 18 )
			throw new AgeMineurException("Le candidat n'a pas 18 ans");
		this.name = name;
		this.age = age;
		this.tech = tech;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public TechEnumeration getTech() {
		return tech;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Candidat other = (Candidat) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (tech != other.tech)
			return false;
		return true;
	}
	
	
	
	
}
