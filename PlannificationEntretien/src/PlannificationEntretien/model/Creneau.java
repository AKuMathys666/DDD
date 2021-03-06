package PlannificationEntretien.model;

import java.util.Calendar;
import java.util.Date;

import PlannificationEntretien.exception.DureeEntretienTropLongueException;
import PlannificationEntretien.exception.HeureEntretienException;
import PlannificationEntretien.exception.HeureEntretienTropTardException;

public class Creneau {
	
	private Date date;
	private int dureeMinute;
	private Date dateFin;
	
	public Creneau(Date date, int dureeMinute) throws HeureEntretienException, DureeEntretienTropLongueException, HeureEntretienTropTardException{
		this.date = date;
		this.dureeMinute = dureeMinute;
		//verifier date de debut
		Calendar calendrier = Calendar.getInstance();
		calendrier.setTime(date);
		if (Integer.valueOf(calendrier.get(Calendar.HOUR)) < 9  ) {
			throw new HeureEntretienException("Heure d�but d'entretien trop tot");
		}
		if (Integer.valueOf(calendrier.get(Calendar.HOUR)) > 17 ) {
			throw new HeureEntretienException("Heure d�but d'entretien trop tard");
		}
		//verifier duree entretien
		if(dureeMinute > 180)
			throw new DureeEntretienTropLongueException();
		calendrier.add(Calendar.MINUTE, dureeMinute);
		dateFin = calendrier.getTime();
		//verifier date de fin
		if (Integer.valueOf(calendrier.get(Calendar.HOUR)) > 20 ) {
			throw new HeureEntretienTropTardException();
		}
	}
	
	public Date getDate() {
		return date;
	}
	public int getDureeMinute() {
		return dureeMinute;
	}
	public Date getDateFin() {
		return dateFin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
		result = prime * result + dureeMinute;
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
		Creneau other = (Creneau) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (dateFin == null) {
			if (other.dateFin != null)
				return false;
		} else if (!dateFin.equals(other.dateFin))
			return false;
		if (dureeMinute != other.dureeMinute)
			return false;
		return true;
	}

	
}
