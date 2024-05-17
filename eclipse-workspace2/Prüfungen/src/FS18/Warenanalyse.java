package FS18;

import java.io.*;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.*;

public class Warenanalyse {
	String product;
	String name;
	int quantity;
	int price;
	int width;

	
	Warenanalyse(String product, String name, int quantity, int price, int width) {
		this.product=product;
		this.name = name;
		this.quantity = quantity;
		this.price=price;
	}
	
	static void analyse(File input, File output) throws FileNotFoundException {
		int width = 0;
		int priceDifference = 0;
		String winnerProduct = "hey";
		int quantity = 0;
		int price = 0;
		String maxProduct = "m";
		String maxPerson = "m";
		Scanner in = new Scanner (input);
		PrintStream out = new PrintStream(output);
		List <Warenanalyse> transaktionen = new ArrayList<Warenanalyse>();
		while (in.hasNextLine()) {
			String product = in.next();
			String name = in.next();
			for(int i = 0; i<transaktionen.size(); i++) {
				if (name == transaktionen.get(i).name) {
					quantity = in.nextInt();
					price = in.nextInt();
					width = quantity *price;
					transaktionen.get(i).quantity += quantity;
					transaktionen.get(i).price += price;
				}
			}
			if(in.hasNextInt()) {
			quantity = in.nextInt();
			price = in.nextInt();
			width = quantity*price;
			}
			for(int i = 0; i<transaktionen.size(); i++) {
				if (product == transaktionen.get(i).product) {
					int dif = Math.abs(price -transaktionen.get(i).price);
					if (dif > priceDifference) {
						priceDifference = dif;
						winnerProduct = product;
					}
				}
			}
			Warenanalyse transaktion = new Warenanalyse(product, name, quantity, price, width);
			transaktionen.add(transaktion);
		}	
			int maxWidth=0;
			int maxSum = 0;
			for (int i = 0; i<transaktionen.size(); i++) {	
				int w = transaktionen.get(i).width;
				int p = transaktionen.get(i).price;
				if(w>maxWidth) {
					maxWidth = w;
					maxProduct = transaktionen.get(i).product;
				}
				if (p>maxSum) {
					maxSum = p;
					maxPerson = transaktionen.get(i).name;
				}
			}
			System.out.println(maxProduct + " " +maxWidth);
			System.out.println(maxPerson + " " +maxProduct);
			System.out.println(winnerProduct + " " + priceDifference);
			in.close();
			out.close();
			}
	
	public static void main (String [] args) {
		File input = new File("transaktionen.txt");
		File output = new File ("max3");
		try {
			analyse(input, output);
		} catch (FileNotFoundException e) {
			System.out.println("YO fck kunt mate lik mi arse");
		}
	}
	
			
}
