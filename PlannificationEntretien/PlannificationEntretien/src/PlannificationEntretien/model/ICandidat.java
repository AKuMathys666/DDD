package PlannificationEntretien.model;

public interface ICandidat {
	String getName();
	int getAge();
	String getTechnologie();
	String getCommentairesConsultants();
	void setCommentaire(String commentaire);
}
