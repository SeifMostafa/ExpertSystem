import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
/*
 * child class from Expression ... special for terminal expression 
 * and nonTerminal expressions are handled in RulesChecked.calculateResult as 
 * we see nonTerminal in rules with conditions only 
  */
public class TerminalExpression extends Expression {
	// integer expression handler
	String exp;
	String message;
	boolean result;
	Product product;
	int value;

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public TerminalExpression(String exp, Product product) {
		super(exp);
		this.product = product;
		this.message = "";
		this.exp = exp;
		result = true;
		value=0;
		interpret();
	}

	@Override
	public boolean interpret() {
		boolean another_variable = false;
		char[] EXP = exp.toCharArray();
		for (int i = 0; i < exp.length(); i++) {
			if (((int) EXP[i] >= 65 && (int) EXP[i] <= 90)
					|| ((int) EXP[i] >= 97 && (int) EXP[i] <= 127)) {
				another_variable = true;
			}
		}
		if(another_variable)
		{
			for (int j = 0; j < product.Size; j++) {
				if (exp.contains(this.product.knowledge[j].Name)) {
					Fact f = product.knowledge[j];
					String name = ((Integer_Fact) f).getName();
					int v = ((Integer_Fact) f).getValue();
					String Value = String.valueOf(v);
					exp=exp.replaceAll(name, Value);
					ScriptEngineManager mgr = new ScriptEngineManager();
					ScriptEngine engine = mgr.getEngineByName("JavaScript");
					double VALUE = 0 ;
					try {
						
						VALUE = (double) engine.eval(exp);
						
					} catch (ScriptException e) {
						e.printStackTrace();
					}
					value=(int) VALUE;
					break;
				}
			}
			if(value==0)
			{
				this.message="unknown variable";
				return false;
			}
			else if(value==2147483647)	// ascii of infinity
			{
				this.message="division by zero";
				return false;
			}
		}
		else 
		{
			ScriptEngineManager mgr = new ScriptEngineManager();
			ScriptEngine engine = mgr.getEngineByName("JavaScript");
			try {
				double  v =  (double) engine.eval(exp);
				this.value = (int) v;
			} catch (ScriptException e) {
				e.printStackTrace();
			}
		}
		if(value == 0)
		{
			this.message="invalid expression";
			return false;
		}
		else if(value==2147483647)	// ascii of infinity
		{
			this.message="division by zero";
			return false;
		}
		return this.result;
	}
}
