/*
 * conation conclusion fact and its value .
 */
public class Conclusions {
	String Container="";
	Product p;
	Fact Conclusion;
	String Value;
	/*
	 * setters and getters
	 */
	public String getContainer() {
		return Container;
	}
	public void setContainer(String container) {
		Container = container;
	}
	public Conclusions(String container,Product p) {
		super();
		this.p=p;
		Container = container;
		ReturnConclusions();
	}
	/*
	 * return the conclusion
	 */
	public Fact ReturnConclusions()
	{
		Value = new String();
		KindOfFact kindOfFact = new KindOfFact(this.p,Container);
		this.Conclusion = kindOfFact.Return();
		this.Value = kindOfFact.Value;
		return this.Conclusion;
	}
}
