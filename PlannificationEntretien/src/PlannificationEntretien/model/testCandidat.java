package PlannificationEntretien.model;

public class testCandidat implements ICandidat{
	private String commentaire;
	@Override
	public String getName()
	{
		return "jean";
	}
	@Override
	public int getAge()
	{
		return 22;
	}
	@Override
	public String getTechnologie()
	{
		return "java";
	}
	@Override
	public String getEtapeEntretien() {
		return "1ere etape a planifier";
	}
	@Override
	public String getTypeProfil() {
		return "0 a 3 ans";
	}
	@Override
	public String getCommentairesConsultants() {
		return null;
	}
	@Override
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
}
