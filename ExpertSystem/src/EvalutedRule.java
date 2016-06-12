import java.io.IOException;
/*
 * own to rules without conditions 
 */
public class EvalutedRule {
	Product product;

	public EvalutedRule(Product p) {
		super();
		product = p;
	}
	/*
	 * check if conclusions can be added or not by check them from declared facts
	 * add them to the product.knowledge
	 * 	 */
	 public void EvaluteRuleWithoutPremises() throws IOException {
		 // evaluate all rules without premises
		for (int i = 0; i < this.product.SizeOfruleWITHOUT_PREMISE; i++) {
			for (int j = 0; j < this.product.SizeofFacts; j++) {
				if (product.factbase[j].Name
						.contains(product.rulewithoutpremise[i].conclusion.Conclusion.Name)) {
					if (product.Key[j] == ConcreteBuilder.INTEGER_FACT) {

						TerminalExpression expression = new TerminalExpression(
								product.rulewithoutpremise[i].conclusion.Value,
								product);
						if (expression.result == false)
							System.err.println(expression.message);
						else
							((Integer_Fact) product.rulewithoutpremise[i].conclusion.Conclusion)
									.setValue(expression.value);

						product.addfact(((Integer_Fact) product.rulewithoutpremise[i].conclusion.Conclusion));
						break;
					} else if (product.Key[j] == ConcreteBuilder.SYMBOLIC_FACT) {
						((Symbolic_Fact) product.rulewithoutpremise[i].conclusion.Conclusion)
								.setValue(product.rulewithoutpremise[i].conclusion.Value);
						product.addfact((Symbolic_Fact) product.rulewithoutpremise[i].conclusion.Conclusion);
						break;
					}
					if (product.factbase[j].Name
							.contains(product.rulewithoutpremise[i].conclusion.Conclusion.Name)) {
						if (product.rulewithoutpremise[i].conclusion.Value
								.contains("true")) {
							((Boolean_Fact) product.rulewithoutpremise[i].conclusion.Conclusion)
									.setValue(true);
						} else
							((Boolean_Fact) product.rulewithoutpremise[i].conclusion.Conclusion)
									.setValue(false);
						product.addfact((Boolean_Fact) product.rulewithoutpremise[i].conclusion.Conclusion);

					}
				}
			}
		}
	}
}
