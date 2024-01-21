package comp352.dsandalgos.huffman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Organize {
	
	static ArrayList<Character> alc = new ArrayList<>(); //arrayList Chars
	static ArrayList<Integer> alf = new ArrayList<>(); //arrayList Frequencies
	static int size = 0;
	
	public static void readAndOrganize(String file) {
		 
		 try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			    int character;
			    while ((character = reader.read()) != -1) {
			    	 char c = (char) character;
			    	 char ch = Character.toLowerCase(c);
			         if (!alc.isEmpty() && alc.contains(ch)) {
				         incFreq(alc.indexOf(ch), alf);
				     }
				     else {
					     size++;
					     alc.add(ch);
					     alf.add(1); 
			         }
			     }
			reader.close();
			} catch (IOException e) {
			    e.printStackTrace();
			}
	 }
	 
	private static void incFreq(int ind, ArrayList<Integer> alf) {
	    	int curFreq = alf.get(ind); //current frequency
	    	int newFreq = curFreq + 1;
	    	alf.set(ind, newFreq);
		}
	
	public static Node[] generateArray(ArrayList<Character> alc, ArrayList<Integer> alf, int size) {
		Node[] arr = new Node[size];
		for (int i = 0; i < size; i++) {
			
			arr[i] =  new Node(alc.get(i), alf.get(i));
		}
		return arr;
	}
	
	
	
	
	

}
