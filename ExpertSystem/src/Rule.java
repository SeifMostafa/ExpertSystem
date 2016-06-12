/*
 * not the mother class of all rules 
 * it is rule without conditions 
 * just has conclusions to be check and added directly
 */
public class Rule {
	Fact conclusion;

	public Fact getConclusion() {
		return conclusion;
	}

	public void setConclusion(Fact conclusion) {
		this.conclusion = conclusion;
	}
	
}
