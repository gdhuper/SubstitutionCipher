import java.text.DecimalFormat;
import java.util.Scanner;

public class Compute {
	
	private String input;
	
	public Compute(String input)
	{
		this.input = input;
	}
	
	public String getInput()
	{
		return this.input;
		
	}
	
	public void setInput(String input)
	{
		this.input = input;
	}
	
	public int[] readInput(String input)
	{
		
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXZY";
		char[] inputArray = input.toCharArray();
		
		int[] count = new int[26];
		for(int i = 0; i < inputArray.length; i++)
		{
			String temp = "" +  inputArray[i];
			if(letters.contains(temp))
			{
				int idx = (char) inputArray[i];
				count[idx - 65]++;
			}
		
		}
		return count;
		
	}
	
	public double[] convertToPer()
	{
		int[] c = readInput(this.input);
		int cc = 65;
		System.out.println("Printing letter frequenct for cipher text\n");
		double sum = 0;
		for(int val : c)
		{
			System.out.println((char) cc + " : " + val);
			cc++;
			sum += val;
		}
		double[] temp = new double[26];
		System.out.println("Converting letter freq to % ... \n");
		DecimalFormat df = new DecimalFormat("0.00"); 

		for(int i = 0; i < c.length; i++)
		{
			double val = (c[i] / sum) * 100;
			temp[i] = val;
			System.out.println((char) (65+i) + " : " + df.format(val));
			
		}
		return temp;
	}
	
	public static void main(String[] args)
	{
		String plaintext = "";
		String input = "PBFPVYFBQXZTYFPBFEQJHDXXQVAPTPQJKTOYQWIPBWLXTOXBTFXQWA"
				+ "XBVCXQWAXFQJVWLEQNTOZQGGQLFXQWAKVWLXQWAEBIPBFXFQVXGTVJV"
				+"WLBTPQWAEBFPBFHCVLXBQUFEWLXGDPEQVPQGVPPBFTIXPFHXZHVFAG"
				+"FOTHFEFBQUFTDHZBQPOTHXTYFTODXQHFTDPTOGHFQPBQWAQJJTODXQH"
				+"FOQPWTBDHHIXQVAPBFZQHCFWPFHPBFIPBQWKFABVYYDZBOTHPBQPQJT"
				+"QHGFXVAFXQHFUFHILTTAVWAFFAWTEVDITDHFHFQAITIXPFHXAFQHEFZ"
				+ "QWGFLVWPTOFFA";
		Compute q = null;
		Decrypt dec = new Decrypt();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter :\n" + "1: For using default input from Textbook \n" + "2: For custom input");
		if(in.nextInt() == 1)
		{
		 q = new Compute(input.trim());
		}
		else
		{
			String str = in.next();
			q = new Compute(str);
		}
		double[] temp = q.convertToPer();
		System.out.println("\nDrawing bar chart...");
		DrawChart s = new DrawChart();
		s.saveData();
		s.count = temp;
		s.main(args);
		
		System.out.println("Select Decrypting Method:\n" + "1: Shift by n \n" + "2: Enter Key");
		int shift = 0;
		char[] keys = new char[26];
		int k = 65;
		boolean done = false;
		int idx = 0;
		if(in.nextInt() == 1)
		{
			System.out.println("Enter shift amount: \n");
			shift = in.nextInt();
			if(shift < 25)
			{
				plaintext = dec.shiftByN(input, shift);
			}
			else
			{
				System.out.println("shift amount should be 0 < amt < 25");
				
			}
		}
		else{
			System.out.println("Enter Key: \n");
			while(idx < 26)
			{
				System.out.print((char)(k+idx) + "-->");
				char keyVal = in.next().charAt(0);
				keys[idx] = keyVal;
				idx++;
			}
			plaintext = dec.keySubstitution(input, keys);
			System.out.println(plaintext);
		}
	}
	

}
