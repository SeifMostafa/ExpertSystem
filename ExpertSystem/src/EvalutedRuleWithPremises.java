/*
 * own to rules with conditions
 */
public class EvalutedRuleWithPremises {
	Product product;

	public EvalutedRuleWithPremises(Product p) {
		super();
		product = p;
	}
	/*
	 * check by RulesChecked on conditions status ( exist and its values is true)
	 * you  will see  what RulesChecked returned in its class
	 */
	public void CheckedDone()
	{
		
		for (int i = 0; i < this.product.SizeOfruleWITH_PREMISE; i++) {
			RulesChecked checked = new RulesChecked(this.product.rulewithpremise[i].conditions, product);
			checked.calculateResult();
		}
	}
	/*
	 * check if conclusions can be added or not by check the rules status and
	 *  check them from declared facts
	 * add them to the product.knowledge
	 * 	 */
	public void Evalute() {
		for (int i = 0; i < this.product.SizeOfruleWITH_PREMISE; i++) {
			if (product.rulewithpremise[i].F) {
				for (int j = 0; j < this.product.SizeofFacts; j++) {
					if (product.factbase[j].Name
							.contains(product.rulewithpremise[i].conclusion.Conclusion.Name)) {
						if (product.Key[j] == ConcreteBuilder.INTEGER_FACT) {

							TerminalExpression expression = new TerminalExpression(
									product.rulewithpremise[i].conclusion.Value,
									product);
							if (expression.result == false)
								System.err.println(expression.message);
							else
								((Integer_Fact) product.rulewithpremise[i].conclusion.Conclusion)
										.setValue(expression.value);

							product.addfact(((Integer_Fact) product.rulewithpremise[i].conclusion.Conclusion));
							break;
						} else if (product.Key[j] == ConcreteBuilder.SYMBOLIC_FACT) {
							((Symbolic_Fact) product.rulewithpremise[i].conclusion.Conclusion)
									.setValue(product.rulewithpremise[i].conclusion.Value);
							product.addfact((Symbolic_Fact) product.rulewithpremise[i].conclusion.Conclusion);
							break;
						}
						if (product.factbase[j].Name
								.contains(product.rulewithpremise[i].conclusion.Conclusion.Name)) {
							if (product.rulewithpremise[i].conclusion.Value
									.contains("true")) {
								((Boolean_Fact) product.rulewithpremise[i].conclusion.Conclusion)
										.setValue(true);
							} else
								((Boolean_Fact) product.rulewithpremise[i].conclusion.Conclusion)
										.setValue(false);
							product.addfact((Boolean_Fact) product.rulewithpremise[i].conclusion.Conclusion);

						}
					}
				}
			}

		}
	}
}
