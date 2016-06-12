/*
 * abstract and mother class of expression integers
 * which in its derived classes will handle those expressions.
 */
public abstract class Expression {
		String exp;
		String message;
		boolean result;
		public String getExp() {
			return exp;
		}
		public void setExp(String exp) {
			this.exp = exp;
		}
		public Expression(String exp) {
			super();
			this.message="";
			this.exp = exp;
			result = true;
		}
		/*
		 * here this class do its work
		 */
		public abstract boolean interpret();

}
