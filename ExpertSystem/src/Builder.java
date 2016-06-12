import java.io.FileNotFoundException;
import java.io.IOException;


public interface Builder {

	public static final int BOOLEAN_FACT = 1;
	public static final int INTEGER_FACT = 2;
	public static final int SYMBOLIC_FACT = 3;
	/*
	 * impemented in concretebuilder
	 */
	public void buildPart() throws FileNotFoundException, IOException;
}
