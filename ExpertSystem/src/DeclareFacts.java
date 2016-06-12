/*
 * abstract and mother class of DeclareFacts
 * contain the facts which will be returned
 */
public abstract class DeclareFacts {
	Fact facts[];
	String Container = new String();
	public Fact[] getFact() {
		return facts;
	}
	public void setFact(Fact[] facts) {
		this.facts = facts;
	}
	public String getContainer() {
		return Container;
	}
	public void setContainer(String container) {
		Container = container;
	}
	public DeclareFacts(String container) {
		super();
		Container = container;
	}
}
