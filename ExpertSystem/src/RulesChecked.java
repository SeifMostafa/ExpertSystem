/*
 * own to rules with premises 
 * to check the exist of conditions and its values from product.knowledge
 */
public class RulesChecked {
	Conditions conditions;
	Product product;
	boolean result;

	public RulesChecked(Conditions conditions, Product product) {
		super();
		this.result = true;
		this.conditions = conditions;
		this.product = product;
	}
/*
 * calculate the status of conditions of this rule
 */
	public void calculateResult() {

		for (int i = 0; i < conditions.NumberOfConditions; i++) {
			for (int j = 0; j < product.Size; j++) {
				if (conditions.Premises[i].Name
						.equals(product.knowledge[j].Name)) {
					if (conditions.Value[i].contains("<")
							|| conditions.Value[i].contains(">")) {
						char op;
						int ExistValue = ((Integer_Fact) this.product.knowledge[j])
								.getValue();

						if (conditions.Value[i].contains(String.valueOf('>')))
							op = '>';
						else
							op = '<';
						
						int checked_value = 0;
						String toCalculate = conditions.Value[i].replaceAll(
								String.valueOf(op), "");
						TerminalExpression expression = new TerminalExpression(
								toCalculate, product);
						if (!expression.result) {
							result = false;
							return;
						} else {
							checked_value = expression.value;
							if (op == '>') {
								if (ExistValue < checked_value) {
									this.result = false;
									return;
								}
							} else {
								if(ExistValue > checked_value) {
									this.result = false;
									return;
								}
								else this.result=true;
								return;
							}

						}

					} else if (conditions.Premises[i].type == "Symbolic") {

						String one = ((Symbolic_Fact) product.knowledge[j])
								.getValue();
						one = one.replaceAll("\\s+", "");
						String two = conditions.Value[i];
						two = two.replaceAll("\\s+", "");
						if (!one.equals(two)) {
							result = false;
							return;
						}
						break;
					} else if (conditions.Premises[i].type == "Boolean") {
						boolean ExistValue, checkvalue;
						if (((Boolean_Fact) product.knowledge[j]).isValue())
							ExistValue = true;
						else
							ExistValue = false;

						if (conditions.Value[i].contains("true"))
							checkvalue = true;
						else
							checkvalue = false;
						if (ExistValue != checkvalue) {
							result = false;
							return;
						}
					}

				} else if (j == product.Size - 1) {
					result = false;
					return;
				}

			}
		}

	}
}
