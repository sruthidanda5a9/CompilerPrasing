package Compiler;

public class Token {
	public String lexeme,attributes,address;
	public Token(String lex,String attr,String addres)
	{
		lexeme =lex;
		attributes = attr;
		address = addres;
	}
	public String getLexeme() {
		return lexeme;
	}
	public void setLexeme(String lexeme) {
		this.lexeme = lexeme;
	}
	public String getAttributes() {
		return attributes;
	}
	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
