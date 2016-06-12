/*
 * child from Fact
 * represent Symbolic fact
 */
class Symbolic_Fact extends Fact {


	public Symbolic_Fact(String name) {
		super(name);
		this.Name=name;
		this.type="Symbolic";
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Symbolic_Fact other = (Symbolic_Fact) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return  this.Name+ ": "+value ;
	}


	String value;
}