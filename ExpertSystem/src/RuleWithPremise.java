/*
 * contain conditions and conclusions and the conditions value 
 */
public class RuleWithPremise extends Rule{
	Conditions conditions;
	Conclusions conclusion;
	Product product;
	boolean F;

	public RuleWithPremise() {
		super();
	}
	public RuleWithPremise(Conditions cond, Conclusions conclusions,Product product) {
		super();
		this.product= product;
		this.conditions = cond;
		this.conclusion = conclusions;
		calculateF();
		
	}
	/* 
	 * to calculate conditions value
	 */
	public void calculateF()
	{
		RulesChecked  checked= new RulesChecked(this.conditions,this.product);
		checked.calculateResult();
		this.F = checked.result;
	}
}
