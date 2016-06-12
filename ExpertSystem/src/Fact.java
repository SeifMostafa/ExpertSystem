/*
 * mother class of all facts
 */
class Fact {
	String Name;
	String type;
	public Fact(String name) {
		super();
		Name = name;
		type="Fact";
	}
/*
 * setters and getters
 */
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fact other = (Fact) obj;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Fact [Name=" + Name + ", getClass()=" + getClass() + "]";
	}
	

}