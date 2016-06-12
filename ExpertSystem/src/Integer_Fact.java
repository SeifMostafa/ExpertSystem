/*
 * child from Fact
 * represent integer fact
 */
class Integer_Fact extends Fact {
	String Name;
	String type;
	int value;
	public Integer_Fact(String name) {
		super(name);
		this.Name=name;
		this.type="Integer";
	}
	/*
	 * setters and getters
	 */
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Integer_Fact other = (Integer_Fact) obj;
		if (value != other.value)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return this.Name+ ": "+value ;
	}


}