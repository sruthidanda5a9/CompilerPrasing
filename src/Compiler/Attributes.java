package Compiler;
import java.util.StringTokenizer;
public class Attributes {
	private Compiler compilerObject;
	//public Identifier identifier[] =  new Identifier[50];
	public Attributes(Compiler c)
	{
		this.compilerObject = c;
	}
	public void attributes()
	{
		for(int i=0;i<compilerObject.scannerObj.count;i++)
		{
			compilerObject.identifierObject[i] = new Identifier("name", "address");
		}
		for(int k=0;k<compilerObject.scannerObj.count;k++)
		{
			//compilerObject.tokens[k].attributes = "error";
			variables(k);
			number(k);
			arithmetic("+|-|","arithmeticOp",k);
			assign(":=","assignOP",k);
			semicolen(";","semicolen",k);
			special(")|(|,|","SpecialChar",k);
			reservWords("main|end|var","reservWords",k);
			identifier();
			
		}
	}
	public void variables(int k)
	{
		if(compilerObject.tokens[k].lexeme.equals("var"))
		{
			while(!compilerObject.tokens[k].lexeme.equals(";"))
			{
				k++;
				if(compilerObject.tokens[k].lexeme.equals(";"))
					return;
				if(!compilerObject.tokens[k].lexeme.equals(","))
				{
					for(int n=0;n<compilerObject.tokens[k].lexeme.length()-1;n++)
					{
						if(Character.isLowerCase(
								compilerObject.tokens[k].lexeme.charAt(n)))
						{
							return;
						}
					}
					String address =  Integer.toString(compilerObject.DA);
					compilerObject.tokens[k].attributes = "identifier";
					compilerObject.tokens[k].address = address;
					compilerObject.identifierObject[compilerObject.id].setName(compilerObject.tokens[k].lexeme); 
					compilerObject.identifierObject[compilerObject.id].setAddress(address);		
					compilerObject.DA ++;
					compilerObject.id++;
				}
			}
		}
	}
	public void identifier()
	{ 
		for (int i=0;i<compilerObject.id;i++)
		{
			for(int n=0;n<compilerObject.scannerObj.count-1;n++)
			{
				if(compilerObject.identifierObject[i].name.equals(
						compilerObject.tokens[n].lexeme))
				{
					compilerObject.tokens[n].attributes = "identifier";
					compilerObject.tokens[n].address = 
							compilerObject.identifierObject[i].getAddress();
				}
			}
		}
	}
	public void number(int k)
	{
		try{
			if(Integer.valueOf(compilerObject.tokens[k].lexeme) <=127
					&&
					Integer.valueOf(compilerObject.tokens[k].lexeme) >= -128
					)
			{
				compilerObject.tokens[k].attributes = "number";
			}
		}
		catch(NumberFormatException e)
		{

		}
	}
	public void arithmetic(String s, String attr,int k)
	{
		compilerObject.scannerObj.stroke = new StringTokenizer(s,"|");
		while(compilerObject.scannerObj.stroke.hasMoreTokens())
		{
			if(compilerObject.tokens[k].lexeme.equals
					(compilerObject.scannerObj.stroke.nextToken()))
			{
				compilerObject.tokens[k].attributes = attr;
			}
		}
	}
	void assign(String s,String assign,int k)
	{
		compilerObject.scannerObj.stroke = new StringTokenizer(s,"|");
		while(compilerObject.scannerObj.stroke.hasMoreTokens())
		{
			if(compilerObject.tokens[k].lexeme.equals
					(compilerObject.scannerObj.stroke.nextToken()))
			{
				compilerObject.tokens[k].attributes = assign;
			}
		}
	}
	void semicolen(String s,String semi,int k)
	{
		compilerObject.scannerObj.stroke = new StringTokenizer(s,"|");
		while(compilerObject.scannerObj.stroke.hasMoreTokens())
		{
			if(compilerObject.tokens[k].lexeme.equals
					(compilerObject.scannerObj.stroke.nextToken()))
			{
				compilerObject.tokens[k].attributes = semi;
			}
		}
	}
	void special(String s,String spe,int k)
	{
		compilerObject.scannerObj.stroke = new StringTokenizer(s,"|");
		while(compilerObject.scannerObj.stroke.hasMoreTokens())
		{
			if(compilerObject.tokens[k].lexeme.equals
					(compilerObject.scannerObj.stroke.nextToken()))
			{
				compilerObject.tokens[k].attributes = spe;
			}
		}
	}
	
	void reservWords(String s,String spe,int k)
	{
		compilerObject.scannerObj.stroke = new StringTokenizer(s,"|");
		while(compilerObject.scannerObj.stroke.hasMoreTokens())
		{
			if(compilerObject.tokens[k].lexeme.equals
					(compilerObject.scannerObj.stroke.nextToken()))
			{
				compilerObject.tokens[k].attributes = spe;
			}
		}
	}
}
