/*
 * container of the project
 * has the bases of knowledge & bases of rules 
 * has functions can be operate on Fact like sweep , add or delete
 * and to string which call dublicated class and its job to remove dublicates before
 * reurn the finial output to write on user file
 */
public class Product {

	Fact [] knowledge= new Fact[100];
	int Size=0;
	
	int [] Key= new int[100];		// 1 Boolean// 2 Integer //3 symbolic
	Fact []factbase=new Fact[100];
	int SizeofFacts=0;
	
	RuleWithPremise [] rulewithpremise=new RuleWithPremise[100];
	int SizeOfruleWITH_PREMISE=0;
	
	RuleWithoutPremise [] rulewithoutpremise=new RuleWithoutPremise[100];
	int SizeOfruleWITHOUT_PREMISE=0;
	

	public void addfact( Fact fact) {
		knowledge[Size]=fact;
		Size++;
	}
	
	public void sweep(Fact fact) {
			for(int i=0;i<Size;i++)
			{
				if(knowledge[i].equals(fact))
				{
					for(int j=i;j<(Size-1);j++)
					{
						knowledge[j]=knowledge[j+1];
					}
				}
		}
			Size--;
	}

	public boolean search(Fact fact) {
		for(int i=0;i<Size;i++)
		{
			if(knowledge[i].equals(fact))
			{
				return true;
			}
	}
		return false;
	}

	@Override
	public String toString() {
		//remove dublicated
		String[] k=new String[this.Size];
		for(int i=0;i<Size;i++)
		{
			k[i]=this.knowledge[i].toString();
		}
		Dublicated  dublicated = new Dublicated(k,this.Size);
		String KNOWLEDGE[]=	dublicated.removeDUBLICATED();
		int newsize=dublicated.end;
		// add to string to write on file
		String knowledge="";
		for(int i=0;i<newsize;i++)
		{
		knowledge+=KNOWLEDGE[i];
		knowledge+="\n";
		}
		return knowledge;
		
		
	}
	
}
