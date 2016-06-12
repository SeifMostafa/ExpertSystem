/*
 * contain conclusion
 */
public class RuleWithoutPremise extends Rule{
	String container;
	Conclusions conclusion;

	public  RuleWithoutPremise(Conclusions conclusion) {
		super();
		container = conclusion.Container;
		this.conclusion = conclusion;
		
	}

	
}
