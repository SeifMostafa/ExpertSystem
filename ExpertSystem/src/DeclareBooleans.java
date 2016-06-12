/*
 * declare boolean facts 
 * and return the facts to be added to product.factbase 
 */
public class DeclareBooleans extends DeclareFacts{
	String names[];
	Boolean_Fact[] facts;
	String Container = new String();
	int counter = 0 ;
	public String getContainer() {
		return Container;
	}

	public void setContainer(String container) {
		Container = container;
	}

	public DeclareBooleans(String container) {
		super(container);
		Container = container;
		this.names = new String[30];
		this.facts = new Boolean_Fact[30];
	}

/*
 * return the boolean facts to be added
 */
	public Boolean_Fact[] Return() {
		
		Container = Container.substring((Container.indexOf('=') + 1),
				(Container.length() - 1));
		this.names = Container.split(",");
		for (int i = 0; i < this.names.length; i++) {
			this.names[i]=this.names[i].replaceAll("\\s+", "");
			Boolean_Fact fact = new Boolean_Fact(this.names[i]);
			this.facts[i]=(Boolean_Fact) fact;
			this.counter++;
		}
		return this.facts;
	}

}
