class Boolean_Fact extends Fact {
	public Boolean_Fact(String name) {
		super(name);
		this.Name = name;
		this.type = "Boolean";
	}

	boolean value;

	/*
	 * setters and getters
	 */
	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (value ? 1231 : 1237);
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
		Boolean_Fact other = (Boolean_Fact) obj;
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public String toString() {
		if (value == true)
			return this.Name;
		else
			return "non " + this.Name;

	}

}