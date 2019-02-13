package PlannificationEntretien.model;

public interface ICandidat {
	String getName();
	int getAge();
	String getTechnologie();
	String getEtapeEntretien();
	String getTypeProfil();
	String getCommentairesConsultants();
	void setCommentaire(String commentaire);
}
