package grammar;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static grammar.Grammar.*;

public class Parser {
	static final public String id = "id";
	static public int position;
	static String[] in;
	//modify this  
	public boolean parse(String[] input) {
		position = 0;
		in = input;
		boolean e = E();
		return e && position == in.length;
	}
	
	public static boolean accept(String s){
		if(position >= in.length){
			return false;
		}
		else if(in[position]==s){
			position++;
			return true;
		}else if(s == id){
			if(in[position] == "0"){
				position++;
				return true;
			}
			else if(in[position].charAt(0) == '1' || in[position].charAt(0) == '2' ||in[position].charAt(0) == '3' ||in[position].charAt(0) == '4' ||in[position].charAt(0) == '5' ||in[position].charAt(0) == '6' ||in[position].charAt(0) == '7' ||in[position].charAt(0) == '8' ||in[position].charAt(0) == '9' ){
				int i = 0;
				while( i<in[position].length() && (in[position].charAt(i) == '0' ||in[position].charAt(i) == '1' || in[position].charAt(i) == '2' ||in[position].charAt(i) == '3' ||in[position].charAt(i) == '4' ||in[position].charAt(i) == '5' ||in[position].charAt(i) == '6' ||in[position].charAt(i) == '7' ||in[position].charAt(i) == '8' ||in[position].charAt(i) == '9') ){					
					i++;
				}
				if(i==in[position].length()){
					position++;
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean E(){
		return T() && Eprime() ;
	}
	//TODO il vaut mieux faire les appels dans le return?
	public boolean Eprime(){
		if(position >= in.length){
			return true;
		}
		else if( in[position]==RIGHTPAR ){
			return true;
		}
		else if(accept(MINUS)){
			return E();
		}
		else if(accept(PLUS)){
			return E();
		}
		return false;
	}
	
	public boolean T(){
		return F() && Tprime();
	}
	
	public boolean Tprime(){
		if(position >= in.length){
			return true;
		}
		else if( in[position]==RIGHTPAR  || in[position]==PLUS || in[position]==MINUS){
			return true;
		}
		else if(accept(DIVIDE)){
			return T();
		}
		else if(accept(TIMES)){
			return T();
		}
		return false;
	}
	
	public boolean F(){
		if(position >= in.length){
			return false;
		}
		if(accept(LEFTPAR)){
			return E() && accept(RIGHTPAR);
		}
		else if(accept(id)){
			return true;
		}
		return false;
	}
}
