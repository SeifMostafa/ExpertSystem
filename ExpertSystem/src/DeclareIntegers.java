/*
 * declare Integer facts 
 * and return the facts to be added to product.factbase 
 */
public class DeclareIntegers extends DeclareFacts{
	String names[];
	Integer_Fact[] facts;
	String Container;
	int counter = 0 ;
	public String getContainer() {
		return Container;
	}

	public void setContainer(String container) {
		Container = container;
	}

	public DeclareIntegers(String container) {
		super(container);
		Container = container;
		this.names = new String[30];
		this.facts = new Integer_Fact[30];
	}

/*
 * return integer facts to be added
 */
	public Integer_Fact[] Return() {
		Container = Container.substring((Container.indexOf('=') + 1),
				(Container.length() - 1));
		this.names = Container.split(",");
		for (int i = 0; i < this.names.length; i++) {
			this.names[i]=this.names[i].replaceAll("\\s+", "");
			Integer_Fact fact = new Integer_Fact(this.names[i]);
			this.facts[i]=(Integer_Fact) fact;
			this.counter++;
		}
		return this.facts;
	}

}
