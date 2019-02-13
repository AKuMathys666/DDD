package PlannificationEntretien.model;

public class testConsultantRecruteur implements IConsultantRecruteur{

	@Override
	public void setCommentaire(ICandidat myCandidat, String commentaire) {
		myCandidat.setCommentaire(commentaire);
	}
}
