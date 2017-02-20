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
				int idx = letters.indexOf(temp);
				System.out.println(inputArray[i] + " :  " +  idx);
				count[idx]++;
			}
		
		}
		return count;
		
	}
	
	public double[] convertToPer(String input)
	{
		int[] c = readInput(input);
		int cc = 65;
		System.out.println("Printing letter frequencies for cipher text\n");
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
		String input = "PBFPVYFBQXZTYFPBFEQJHDXXQVAPTPQJKTOYQWIPBWLXTOXBTFXQWAXBVCXQWAXFQJVWLEQNTOZQGGQLFXQWAKVWLXQWAEBIPBFXFQVXGTVJVWLBTPQWAEBFPBFHCVLXBQUFEWLXGDPEQVPQGVPPBFTIXPFHXZHVFAGFOTHFEFBQUFTDHZBQPOTHXTYFTODXQHFTDPTOGHFQPBQWAQJJTODXQHFOQPWTBDHHIXQVAPBFZQHCFWPFHPBFIPBQWKFABVYYDZBOTHPBQPQJTQOTOGHFQAPBFEQJHDXXQVAVXEBQPEFZBVFOJIWFFACFCCFHQWAUVWFLQHGFXVAFXQHFUFHILTTAVWAFFAWTEVDITDHFHFQAITIXPFHXAFQHEFZQWGFLVWPTOFFA";
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
			input = str;
			q = new Compute(input.toUpperCase());
		}
		double[] temp = q.convertToPer(input);
		
		//Drawing bar graphs 
		System.out.println("\nDrawing bar chart...");
		DrawChart s = new DrawChart();
		s.saveData();
		s.count = temp;
		s.main(args);
		
		
		//User Input
		System.out.println("Select Decrypting Method:\n" + "1: Shift by n \n" + "2: Enter Key");
		int shift = 0; //shift amount for decrypting
		Character[] keys = new Character[26];
		int k = 65; // Ascii for A
		int idx = 0;
		
		// Shift by n
		if(in.nextInt() == 1)
		{
			System.out.println("Enter shift amount: \n");
			shift = in.nextInt();
			if(shift < 25)
			{
				dec.shiftByN(input.toUpperCase(), shift);
				System.out.println(plaintext);
				in.close();
			}
			else
			{
				System.out.println("shift amount should be 0 < amt < 25");
				
			}
		}
		else{ // substitution using key
			System.out.println("Enter Key: \n");
			while(idx < 26)
			{
				System.out.print((char)(k+idx) + "-->");
				char keyVal = in.next().charAt(0);
				keys[idx] = keyVal;
				idx++;
			}
			plaintext = dec.keySubstitution(input.toUpperCase(), keys);
			System.out.println("Printing Plain text: \n" +plaintext);
			in.close();
		}
	}
	

}
