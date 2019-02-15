package PlannificationEntretien.model;

public class ConsultantRecruteur implements IConsultantRecruteur{

	@Override
	public void setCommentaire(ICandidat myCandidat, String commentaire) {
		myCandidat.setCommentaire(commentaire);
	}
	
	
}
