package PlanificationEntretien.model;

public class Salle {
	
	private int taille;
	private boolean aProjecteur;
	
	public Salle(int taille, boolean aProjecteur) {
		super();
		this.taille = taille;
		this.aProjecteur = aProjecteur;
	}

	public int getTaille() {
		return taille;
	}

	public boolean isaProjecteur() {
		return aProjecteur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (aProjecteur ? 1231 : 1237);
		result = prime * result + taille;
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
		Salle other = (Salle) obj;
		if (aProjecteur != other.aProjecteur)
			return false;
		if (taille != other.taille)
			return false;
		return true;
	}



}
