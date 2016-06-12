import java.io.IOException;

/*
 * construct the product.
 */
public class Director {
	ConcreteBuilder builder;

	public Director(ConcreteBuilder builder) throws IOException {
		this.builder = builder;
	}

	 public void construct(Fact fact) throws IOException {
		builder.product.addfact(fact);
	}
}
