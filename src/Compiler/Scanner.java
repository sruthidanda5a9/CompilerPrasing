package Compiler;

import java.io.Serializable;
import java.util.StringTokenizer;

public class Scanner {
	int count =0;
	private Compiler compilerObj;
	//private Token Token;
	String token = "|,|(|:=|+|)|;|";
	String statement;
	String tempStr;
	//public String tokens[];
	public StringTokenizer stroke;
	int i=0;
	
	public  Scanner(Compiler C)
	{
		this.compilerObj =  C;
	}
	
	public void scanner()
	{
		tempStr = statement.replaceAll(" ","\\s");
		tempStr = statement;
		stroke = new StringTokenizer(token,"|");
		while(stroke.hasMoreTokens())
		{
			tempStr = separate(tempStr, makeRegex(stroke.nextToken()));
		}
		stroke = new StringTokenizer(tempStr);
		tempStr = tempStr.trim();
		while(stroke.hasMoreTokens())
		{
			String tokens = stroke.nextToken();
			//System.out.println(tokens);
			compilerObj.tokens[count].setLexeme(tokens);
			count++;
		}
	}
	private static String separate(String sentence, String delimiter){
		return sentence.replaceAll(delimiter,  " " +delimiter + " ");
	}
	private static String makeRegex(String special){
		return  "\\"+special; // Formats special character for regex
	}
}
