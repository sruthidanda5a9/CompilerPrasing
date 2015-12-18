package Compiler;

public class Compiler {
	public int DA = 1000;
	/*
	 * starting address of the identifier.
	 */
	public String  buffer[] = {"main()","var x,y;","x:=y+2;","end"};
	int id =0;
	public static Token[] tokens = new Token[50];
	public Identifier[] identifierObject = new Identifier[50];
	public Scanner scannerObj =  new Scanner(this);
	public Errors errorsObj =  new Errors(this);
	public Attributes attrObj = new Attributes(this);
	public Parser parseObj = new Parser(this);
	/*
	 * tokens : everything is token
	 * lexemes : <identifier , x >
	 * attributes : associated values of tokens.
	 */
	Compiler()
	{
		for(int i=0;i<50;i++)
		{
			tokens[i] = new Token("lexeme", "error", "addres");
		}
		for(int i=0;i<buffer.length;i++)
		{
			scannerObj.statement = buffer[i];
			scannerObj.scanner();
		}
		errorsObj.errors();
		attrObj.attributes();
		parseObj.parser();
		for(int i=0;i<scannerObj.count;i++)
		{
			//System.out.println(tokens[i].lexeme+"      "+tokens[i].attributes+"      "+tokens[i].address);
		}
	}
	public static void main(String args[])
	{
		Compiler obj = new Compiler();
	}
/*
 * modify the identifier numbers and DA to string and change to int do the
 * operations and then converts to string
 */
}
