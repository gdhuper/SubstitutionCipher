import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Decrypt {
	
	
	
	
	public  void shiftByN(String input, int shiftAmt)
	{
	
		 int A = 65;
		 int Z = 90;
		 int a = 97;
		 int z = 122;
	        for (int i = 0; i < input.length(); i++) {
	            char c = input.charAt(i);
	            if       ((c-shiftAmt) >= A && (c-shiftAmt) <= Z) c -= shiftAmt;
	            else if  ((c-shiftAmt) >= a && (c-shiftAmt) <= z) c -= shiftAmt;
	           // else if  ((c-shiftAmt) > Z ) c = (char) ((c-shiftAmt) - 65);
	           // else if ((c-shiftAmt) > z) c = (char) ((c- shiftAmt) - 122);
	            else if  ((c-shiftAmt) < A) c = (char) ((c-shiftAmt) + 26);
	            else if ((c-shiftAmt) < a) c = (char) ((c- shiftAmt) + 26);
	            System.out.print(c);
	        }
	        System.out.println();
		
		
		//return "calling shift by n";
	}
	
	public  String keySubstitution(String input, Character[] keys)
	{
		char[] in = input.toCharArray();
		List<Character> list = Arrays.asList(keys);
		
		
		for(int i= 0; i< in.length; i++)
		{
			//System.out.println(in[i]);
			int idx = list.indexOf(in[i]);
			//System.out.println(idx);
			in[i] = (char) (65+idx);
			//System.out.println(in[i]);
		}
		String plaintext = new String(in);
		return plaintext;
		
	}
	
	
	
	//Tester
	public static void main(String[] args)
	{
		String input = "PBFPVYFBQXZTYFPBFEQJHDXXQVAPTPQJKTOYQWIPBWLXTOXBTFXQWA"
				+ "XBVCXQWAXFQJVWLEQNTOZQGGQLFXQWAKVWLXQWAEBIPBFXFQVXGTVJV"
				+"WLBTPQWAEBFPBFHCVLXBQUFEWLXGDPEQVPQGVPPBFTIXPFHXZHVFAG"
				+"FOTHFEFBQUFTDHZBQPOTHXTYFTODXQHFTDPTOGHFQPBQWAQJJTODXQH"
				+"FOQPWTBDHHIXQVAPBFZQHCFWPFHPBFIPBQWKFABVYYDZBOTHPBQPQJT"
				+"QHGFXVAFXQHFUFHILTTAVWAFFAWTEVDITDHFHFQAITIXPFHXAFQHEFZ"
				+ "QWGFLVWPTOFFA";
		
		Character[] keys = {'Q', 'G', 'Z', 'A', 'F', 'O', 'L', 'B', 'V', 'M', 'K', 'J','Y', 'W', 'T', 'C', 'R','H','X', 'P','D','U'
				, 'E', 'N', 'I', 'S'};
		
		Decrypt d = new Decrypt();
		String s  = d.keySubstitution(input.toUpperCase(), keys);
			
		System.out.println(s);
	}
	

}
