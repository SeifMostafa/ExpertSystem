/*
 * declare Symbolic facts 
 * and return the facts to be added to product.factbase 
 */
public class DeclareSymbolic extends DeclareFacts{
	String names[];
	Symbolic_Fact[] facts;
	String Container;
	int counter = 0 ;
	public DeclareSymbolic(String container) {
		super(container);
		Container = container;
		this.names = new String[30];
		this.facts = new Symbolic_Fact[30];
	}
	/*
	 * return the symbolic facts to be added 
	 */
	public Symbolic_Fact[] Return() {
		
		Container = Container.substring((Container.indexOf('=') + 1),
				(Container.length() - 1));
		this.names = Container.split(",");
		for (int i = 0; i < this.names.length; i++) {
			this.names[i]=this.names[i].replaceAll("\\s+", "");
			Symbolic_Fact fact = new Symbolic_Fact(this.names[i]);
			this.facts[i]=(Symbolic_Fact) fact;
			this.counter++;
		}
		return this.facts;
	}

	public String getContainer() {
		return Container;
	}

	public void setContainer(String container) {
		Container = container;
	}

}
