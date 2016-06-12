import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;


public class Visitor {

	/**
	 * class of every thing
	 * @throws IOException for files operation
	 */
	public static void main(String[] args) throws IOException {
		/*
		 * GET INPUT
		 */
		File file = new File("/home/seif/Desktop/java/expsys/src/modele/Bases of rules");
		
		/*
		 * DECLARE ALL FACTS AND ..
		 * 		CHECK RULES WITHOUT PREMISES THEN EVALUTE ITS CONCLUSION
		 * 			ADD THEM TO KNOWLDEGE BASE BEFORE GOING TO RULES WITH PREMISES
		 */
		ConcreteBuilder concreteBuilder = new ConcreteBuilder(file);
		concreteBuilder.buildPart();
		/*
		 * CHECK RULES WITH PREMISES AND ADD THE CONCLUSION OF THEM IF ITS CONDITIONS ARE TRUE.
		 */
		EvalutedRuleWithPremises evalutedRuleWithPremises = new EvalutedRuleWithPremises(
				concreteBuilder.product);
		evalutedRuleWithPremises.CheckedDone();
		evalutedRuleWithPremises.Evalute();

		/*
		 * OUTPUT.
		 */
		Product p = concreteBuilder.getResult();
		String product = p.toString();

		try (Writer writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream("//home/seif/Desktop/output.txt"), "utf-8"))) {
			writer.write(product);
		}
		catch(IOException exception)
		{
			System.err.println(exception.toString());
		}

	}

}
