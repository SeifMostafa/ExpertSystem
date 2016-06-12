/*
 * contain the conditions and its values
 */
public class Conditions {
	Product p;
	String Container;
	String Condtions[];
	Fact Premises[];
	String Value[];
	int NumberOfConditions=0; 
	public String getContainer() {
		return Container;
	}
	/*
	 * setters and getters
	 */
	public void setContainer(String container) {
		Container = container;
	}
	public Conditions(Product p,String container) {
		super();
		Container = container;
		this.p=p;
		Return();
	}
	/*
	 * return the conditions 
	 */
	public Fact[] Return()
	{
		if (Container.contains(" et ")) {
			Condtions = Container.split(" et ");
		} else {
			String[] array = new String[1];
			array[0] = Container;
			Condtions = array;
		}
		 NumberOfConditions=Condtions.length;

		this.Premises = new Fact[NumberOfConditions];
		this.Value = new String[Condtions.length];
		for (int i = 0; i < Condtions.length; i++) {
			KindOfFact kindOfFact = new KindOfFact(this.p,Condtions[i]);
			this.Premises[i]=kindOfFact.Return();
			this.Value[i] = kindOfFact.Value;
		}
		return this.Premises;
	}
	
}
