/*
 * help facts and rules and conditions and conclusions and 
 * all classes contain facts in determine the kind of the fact they work with
 */
public class KindOfFact {
	String Conatianer;
	String Value;
	Fact fact;

	public String getConatianer() {
		return Conatianer;
	}
	/*
	 * setters and getters
	 */
	public void setConatianer(String conatianer) {
		Conatianer = conatianer;
	}

	public KindOfFact(Product p, String conatianer) {
		super();
		Conatianer = conatianer;

	}
	/*
	 * return fact by specific type (Boolean // Symbolic // Integer )
	 */
	public Fact Return() {
		String fName = new String();
		Value = new String();
		if (Conatianer.contains("=") && !Conatianer.matches(".*\\d+.*")) {
			// symbolic fact

			fName = this.Conatianer.substring(0, (Conatianer.indexOf("=")));
			fName=fName.replaceAll("\\s+", "");
			this.Value = this.Conatianer.substring(Conatianer.indexOf("=") + 1,
					this.Conatianer.length()-1);

			Symbolic_Fact fact = new Symbolic_Fact(fName);

			this.fact = fact;
		} else if (Conatianer.matches(".*\\d+.*")) {
			// integer fact
			fName=fName.replaceAll("\\s+", "");
			if (Conatianer.contains(">")) {
				this.Value = this.Conatianer.substring(
						Conatianer.indexOf(">"),
						this.Conatianer.length() );
				fName = this.Conatianer.substring(0, Conatianer.indexOf(">"));

			}
			else if (Conatianer.contains("<")) {
				this.Value = this.Conatianer.substring(
						Conatianer.indexOf("<"),
						this.Conatianer.length() );
				fName = this.Conatianer.substring(0, Conatianer.indexOf("<"));

			}
			else if (Conatianer.contains("=")) {
				this.Value = this.Conatianer.substring(
						Conatianer.indexOf("=")+1,
						this.Conatianer.length() );
				fName = this.Conatianer.substring(0, Conatianer.indexOf("="));

			}
			fName=fName.replaceAll("\\s+", "");
			Integer_Fact fact = new Integer_Fact(fName);
			this.fact = fact;
		} else {
			// boolean fact
			fName = this.Conatianer.substring(0, this.Conatianer.length()-1 );
			if(this.Conatianer.contains("non"))
			{
				this.Value = "false";
			}
			else this.Value ="true";
			fName=fName.replaceAll("non", "");
			fName=fName.replaceAll("\\s+", "");

			Boolean_Fact fact = new Boolean_Fact(fName);
			this.fact = fact;
		}
		return this.fact;
	}
}
