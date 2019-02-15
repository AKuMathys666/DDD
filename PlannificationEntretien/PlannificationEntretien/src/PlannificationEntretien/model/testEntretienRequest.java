package PlannificationEntretien.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import PlannificationEntretien.exception.EntretienRequestNonCompleteException;

public class testEntretienRequest {

	private String nom;
	private Date date;
	
	public String getNom()
	{
		return nom;
	}

	public Date getDate() {
	    return date;
	}
	
	public void setNom(String nom)
	{
		this.nom = nom;
	}
	
	public void setDate(Date date) {
	    this.date = date;
	}

	public boolean estComplete() throws EntretienRequestNonCompleteException{
		if(getNom() == null)
			throw new EntretienRequestNonCompleteException("nom n'est pas défini");
		if(getDate() == null)
			throw new EntretienRequestNonCompleteException("date n'est pas défini");
		return true;
	}
}
