package Compiler;

public class Parser {
	private String buffer ;
	private String bufferTemp = "";
	private Compiler compilerObj;
	private int lenght = 0;
	int index;
	String flag;
	Parser(Compiler C)
	{
		this.compilerObj = C;
	}
	public void parser()
	{
		buffer ="";
		for(int k=0;k<compilerObj.scannerObj.count;k++)
		{
			action(k);
			shiftReduce(k);
		}
		if( buffer.equals("stmt "))
		{
			System.out.println("Correct Statement");
		}
		else
		{
			System.out.println("this is not correct statemet");
		}
	}
	public void action(int k)
	{
		if(compilerObj.tokens[k].attributes.equals("identifier"))
		{
			if(compilerObj.tokens[k+1].attributes.equals("relationOp")||
					compilerObj.tokens[k+1].attributes.equals("assignOP")
					)
			{
				flag = "SA";
			}
			else
			{
				flag = "CH";
			}
			
		}
		if(compilerObj.tokens[k].attributes.equals("assignOP")||
				compilerObj.tokens[k].attributes.equals("arithmeticOp")||
				compilerObj.tokens[k].attributes.equals("relationOp"))
		{
			flag = "SA";
		}
		if(compilerObj.tokens[k].attributes.equals("SpecialChar")||
				compilerObj.tokens[k].attributes.equals("semicolen")||
				compilerObj.tokens[k].attributes.equals("reservWords"))
		{
			flag = "SL";
		}
		//System.out.println(flag);
	}
	public void shiftReduce(int k)
	{
		if(flag.equals("SA"))
		{
			buffer = buffer + compilerObj.tokens[k].attributes+" ";
			lenght++;
			System.out.println(buffer);
		}
		if(flag.equals("SL"))
		{
			buffer = buffer + compilerObj.tokens[k].lexeme+ " ";
			System.out.println(buffer);
			lenght++;
		}
		if((index=buffer.indexOf("main ( ) ")) >= 0 )
		{
			buffer = buffer.substring(0,index)+"stmt"+" "+buffer.substring(index+9, buffer.length());
			lenght = lenght - 2;
			System.out.println(buffer);
		}
		if((index=buffer.indexOf("end ")) >=0)
		{
			buffer = buffer.substring(0,index)+"stmt"+" "+buffer.substring(index+4, buffer.length());
			System.out.println(buffer);
		}
		if((index=buffer.indexOf("var ,"))>=0)
		{
			//buffer = buffer.replaceAll("var", "stmt");
			buffer = buffer.substring(0,index)+"stmt"+" "+buffer.substring(index+5, buffer.length());
			lenght = lenght -1;
			System.out.println(buffer);
		}
		
		//System.out.println(buffer);
		//while(lenght==1)
		{
			/*
			 * expr -> term ArOp term
			 * term -> ident |num |expr |(term)
			 * assStmt -> ident assOp term;
			 * relex ->  ident relOp term
			 * if Stmt -> if relOp then stmt
			 * whileStmt -> while regExpr do stmt
			 * stmt -> assStmt |If Stmt |While statemnt|{stmt stmt}
			 */
			if((index=buffer.indexOf("term arithmeticOp term ")) >= 0)
			{
				buffer = buffer.substring(0,index) + "expression"+" ";
				lenght = lenght - 2;
				System.out.println(buffer);
			}
			if((index = buffer.indexOf("expression "))>=0)
			{
				buffer = buffer.substring(0, index) + "term"+" "+";";
			}

			if((index = buffer.indexOf("term"))>=0)

			{
				buffer = buffer.substring(0, index) + "term"+" ";
				lenght = lenght - 2;
				System.out.println(buffer);
			}
			if((index = buffer.indexOf("term , term"))>=0)

			{
				buffer = buffer.substring(0, index) + "term"+" ";
				lenght = lenght - 2;
				System.out.println(buffer);
			}
			if((index = buffer.indexOf("expression"))>=0)

			{
				buffer = buffer.substring(0, index) + "term"+" ";
				lenght = lenght ;
				System.out.println(buffer);
			}
			if((index = buffer.indexOf("number"))>=0 )
			{	
				buffer = buffer.substring(0, index) + "term"+" ";
			}
			if((index = buffer.indexOf("identifier assignOP term ;"))>=0)
			{
				buffer = buffer.substring(0, index) + "assignStmt"+" ";
				lenght = lenght - 3;
				System.out.println(buffer);
			}
			if((index = buffer.indexOf("identifier relationOp term ;"))>=0)
			{
				buffer = buffer.substring(0, index) + "relationExpression"+" ";
				lenght = lenght - 3;
				System.out.println(buffer);
			} 
			if((index = buffer.indexOf("if relationExpression then stmt "))>=0)
			{
				buffer = buffer.substring(0, index) + "ifStmt"+" ";
				lenght = lenght - 3;
				System.out.println(buffer);
			}
			if((index = buffer.indexOf("while relationExpression do stmt "))>=0)
			{
				buffer = buffer.substring(0, index) + "whileStmt"+" ";
				lenght = lenght - 3;
				System.out.println(buffer);
			}
			if((index = buffer.indexOf("assignStmt"))>=0 ||
					(index = buffer.indexOf("ifStmt"))>=0  ||
					(index = buffer.indexOf("whileStmt"))>=0 ||
					(index = buffer.indexOf("{stmt stmt}"))>=0)
			{
				buffer = buffer.substring(0, index) + "stmt"+" ";
				lenght = lenght - 3;
			}
			if((index = buffer.indexOf("assignStmt"))>=0 )
			{
				buffer = buffer.substring(0, index)+"stmt"+" ";
				System.out.println(buffer);
			}
			System.out.println(buffer);
		}
	}
}

