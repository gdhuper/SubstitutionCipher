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
	
	
	public static void main(String[] args)
	{
		String input = "PBFPVYFBQXZTYFPBFEQJHDXXQVAPTPQJKTOYQWIPBWLXTOXBTFXQWA"
				+ "XBVCXQWAXFQJVWLEQNTOZQGGQLFXQWAKVWLXQWAEBIPBFXFQVXGTVJV"
				+"WLBTPQWAEBFPBFHCVLXBQUFEWLXGDPEQVPQGVPPBFTIXPFHXZHVFAG"
				+"FOTHFEFBQUFTDHZBQPOTHXTYFTODXQHFTDPTOGHFQPBQWAQJJTODXQH"
				+"FOQPWTBDHHIXQVAPBFZQHCFWPFHPBFIPBQWKFABVYYDZBOTHPBQPQJT"
				+"QHGFXVAFXQHFUFHILTTAVWAFFAWTEVDITDHFHFQAITIXPFHXAFQHEFZ"
				+ "QWGFLVWPTOFFA";
		Compute q = new Compute(input.trim());
		int[] c = q.readInput(input.trim());
		int cc = 65;
		System.out.println("Printing letter frequenct for cipher text");
		double sum = 0;
		for(int a : c)
		{
			System.out.println((char) cc + " : " + a);
			cc++;
			sum += a;
		}
		double[] temp = new double[26];
		for(int i = 0; i < c.length; i++)
		{
			double val = (c[i] / sum) * 100;
			temp[i] = val;
		}
		
		System.out.println("\nDrawing bar chart...");
		DrawChart s = new DrawChart();
		s.saveData();
		s.count = temp;
		s.main(args);
	}
	

}
