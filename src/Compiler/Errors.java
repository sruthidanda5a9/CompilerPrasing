package Compiler;

public class Errors {
	private Compiler compilerObj;
	int maxErrors = 0;
	public Errors(Compiler C)
	{
		this.compilerObj = C;
	}
	public void errors()
	{
		for(int k=0;k<compilerObj.scannerObj.count;k++)
		{
			//System.out.println(compilerObj.tokens[k].lexeme);
			if(compilerObj.tokens[k].getLexeme().equals("("))
				maxErrors++;
			if(compilerObj.tokens[k].getLexeme().equals(")"))
				maxErrors--;
			if(compilerObj.tokens[k].getLexeme().equals("["))
				maxErrors++;
			if(compilerObj.tokens[k].getLexeme().equals("]"))
				maxErrors--;
			//System.out.println(maxErrors);
		}
		if(maxErrors != 0 )
		{
			System.out.println("Paranthasis Missing");
		}
		if(!compilerObj.tokens[compilerObj.scannerObj.count-1].getLexeme().equals("end"))
		{
			System.out.println("end of the statement is missing");
		}
		if(!compilerObj.tokens[0].getLexeme().equals("main"))
		{
			System.out.println("Expected Main");
		}
		
	}

}
