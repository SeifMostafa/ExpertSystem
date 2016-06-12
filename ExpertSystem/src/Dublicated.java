import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * if more than one condition lead to the same conclusion which added before .. 
 * we will get dublicated values in the output so here we return our knowledge without
 * dublicate
 */
public class Dublicated {
	String[]hasdublicated;
	int end;

	public Dublicated(String[] hasdublicated,int end) {
		super();
		this.hasdublicated = hasdublicated;
		this.end = end;
	}
	/*
	 * remove dublicates from the knowledge
	 */
	public String[] removeDUBLICATED()
	{
		
		Set<String> set = new HashSet<String>();

		for(int i = 0; i < end; i++){
		  set.add(hasdublicated[i]);
		}
		Arrays.fill(hasdublicated, null);
		end=0;
		for(String s:set)
		{
			hasdublicated[end] = s;
			end++;
		}
		return this.hasdublicated;
	}
}
