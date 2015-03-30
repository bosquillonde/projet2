package grammar;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static grammar.Grammar.*;

public class test {
	static final public String id = "id";
	static public int position;
	static String[] in;
	public static void main(String[] args) {

		
		
		int seed = 1;
		int depth = 4;
		
		Parser parser = new Parser();
		Generator generator = new Generator(seed);
		String[] tab = generator.generate(depth);
		//print(tab);
			
		tab[3] = ")";
		tab[4] = "2";
		//print(tab);
		
		System.out.println("lol");
		for(int i = 0; i<100 ; i++){
			Generator generato = new Generator(seed);
			for(int j = 0 ; j<100 ; j++){
				tab = generato.generate(depth);
				if(!parser.parse(tab)){
					System.out.println("errroorr vieuuux");
					print(tab);
					System.out.println("lool");
				}
			}
		}
		
		//System.out.println(parser.parse(tab));
		System.out.println("lol");
		
		String[] l = new String[6];
		l[0] = "1";
		l[1] = "+";
		l[2] = "2";
		l[3] = "+";
		l[4] = "(";
		l[5] = "3";
		print(l);
		System.out.println(parser.parse(l));
		
		
		
		
		/*System.out.println("lol" + tab[3] + tab[4] + tab[5] + tab[6]);


		System.out.println("Hello, World");
		System.out.println(tab[1] == MINUS );


		position = 0;
		in = generator.generate(4);
		System.out.println(in[0]);
		System.out.println(in[1]);
		System.out.println(in[2]);
		System.out.println(in[2] == "+");

		in[0] = "9029921234567890098764321";
		position = 0;
		System.out.println(accept(id));
		System.out.println(lol());*/
		
		

	}
	public static void print(String[] tab)
	{
		for(int i = 0 ; i<tab.length ; i++){
			System.out.print(tab[i]);
		}
		System.out.println();
	}
	public static boolean accept(String s){
		if(position >= in.length){
			return false;
		}
		if(in[position]==s){
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

}










































