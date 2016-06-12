import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class ConcreteBuilder implements Builder {

	public static final int BOOLEAN_FACT = 1;
	public static final int INTEGER_FACT = 2;
	public static final int SYMBOLIC_FACT = 3;
	File bases_of_rules;
	Product product;

	public ConcreteBuilder(File bases_of_rules) {
		super();
		/*
		 * input
		 */
		this.bases_of_rules = bases_of_rules;
	}
	/*
	 * 
	 * @see Builder#buildPart()
	 * declare facts , add them to product.factbase
	 * check rules without conditions and add the true of them before going to
	 * rules with conditions which we will check its conditions and conclusion then
	 * add the true of them to knowledge as done conclusions of  rules without conditions  
	 */
	public void buildPart() throws IOException   {
		product = new Product();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(bases_of_rules);
		int firstTime=0;

		while (input.hasNextLine()) {
			String line = input.nextLine();
			if (line.contains("faits_booleens")) {
				while (!line.contains(";")) {
					line += input.nextLine();
				}
				DeclareBooleans declareBooleans = new DeclareBooleans(line);
				Boolean_Fact[] facts = declareBooleans.Return();
				for (int i = 0; i < declareBooleans.counter; i++) {
					product.factbase[product.SizeofFacts] = facts[i];
					product.Key[product.SizeofFacts] = 1;
					product.SizeofFacts++;
				}
				line = "";
			} else if (line.contains("faits_symboliques")) {
				while (!line.contains(";")) {
					line += input.nextLine();
				}
				DeclareSymbolic declareSymbolic = new DeclareSymbolic(line);
				Symbolic_Fact[] facts = declareSymbolic.Return();
				for (int i = 0; i < declareSymbolic.counter; i++) {
					product.factbase[product.SizeofFacts] = facts[i];
					product.Key[product.SizeofFacts] = 3;
					product.SizeofFacts++;
				}
				line = "";
			} else if (line.contains("faits_entiers")) {
				while (!line.contains(";")) {
					line += input.nextLine();
				}
				DeclareIntegers declareIntegers = new DeclareIntegers(line);
				Integer_Fact[] facts = declareIntegers.Return();
				for (int i = 0; i < declareIntegers.counter; i++) {
					product.factbase[product.SizeofFacts] = facts[i];
					product.Key[product.SizeofFacts] = 2;
					product.SizeofFacts++;
				}
				line = "";
			} else if (line.contains("si ")) {
				// as long as he entered here so he read the rules without premises ,so we will add the  ruleswithoutpremises to product.knowledge at first time
				if(firstTime==0)
				{
					EvalutedRule evalutedRule = new EvalutedRule(product);
					evalutedRule.EvaluteRuleWithoutPremises();
					firstTime++;
				}
				// rule with premise
				RuleWithPremise ruleWithPremise ;
				while (!line.contains(";")) {
					line += input.nextLine();
				}
				
				// condition
				String condition = line.substring(3, (line.indexOf("alors")));
				Conditions conditions = new Conditions(this.product,condition);

				// conclusion
				String Conclusion = line.substring((line.indexOf("alors") + 5),(line.length() - 1));
				Conclusions conclusions = new Conclusions(Conclusion,this.product);
				
				ruleWithPremise = new RuleWithPremise(conditions,conclusions,this.product);
				
				this.product.rulewithpremise[this.product.SizeOfruleWITH_PREMISE]=ruleWithPremise;
				this.product.SizeOfruleWITH_PREMISE++;
				line = "";
			}

			else if (!line.contains("faits_booleens")
					&& !line.contains("faits_symboliques")
					&& !line.contains("faits_entiers") && !line.contains("si ")
					&& !line.contains(",") && line.contains(";"))
			{
				// rule without premise.
				
				Conclusions conclusions = new Conclusions(line,this.product);
				RuleWithoutPremise ruleWithoutPremise = new RuleWithoutPremise(conclusions);
				this.product.rulewithoutpremise[this.product.SizeOfruleWITHOUT_PREMISE]=ruleWithoutPremise;
				this.product.SizeOfruleWITHOUT_PREMISE++;
				line = "";
			}
		}
	}
	/*
	 * to retrive the product and output its knowledge
	 */
	public Product getResult() {
		return this.product;
	}

}
