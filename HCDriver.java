/*
 * Theory Questions:
 * 
 * Q2)
 * The purpose of priority queue in a Huffman Coding Tree is that the priority queue automatically calibrates the priority when you add things to it. 
 * Most importantly, when removing an item, the item is always removed in O(1) time and the item is always of highest priority. 
 * With these properties, the priority queue helps generate optimal code, because as we combine the nodes of lowest frequency (highest priority), we are certain that 
 * symbols with higher frequencies are assigned to shorter bit sequences, which reduces the overall length of the coded sequence and allows for more compressed encoding.
 * 
 * Q3)
 * The length of a Huffman code is inversely proportional to the frequency of the character. The larger the frequency the less priority the node will have,
 * the higher up the node would be on the tree. Thus, the easier the character will be to retrieve and the smaller code sequence for that character. Therefore, 
 * frequently occurring symbols are represented by shorter codes, which reduces the total number of bits required to represent the entire data. Less frequent symbols, 
 * while assigned longer codes, have a smaller impact on the overall code length due to their lower frequency of occurrence (optimizing compression). 
 * 
 * Q4)
 * My Huffman tree was built in 0(n^2) time, which is definitely not the most efficient. This is due to the method of sorting the tree.
 * Since a stable algorithm was required and legitimate swapping was required (not just copying back into an array like MergeSort) I used insertion sort O(n^2). 
 * Counting the frequencies is done in O(n) time which has no effect since it is smaller. In order to optimize the Huffman Tree, a heap based priority queue
 * could have been used instead of an array version. The heap based priority queue can build the tree in O(nlogn) time.
 * 
 */





package comp352.dsandalgos.huffman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class HCDriver {
		

	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println("Only two arguments were expected, and required.");
			return;
		}
		
		else if (!(args[1].equals("encode")) && !(args[1].equals("decode"))) {
			System.out.println("Second argument must be encode or decode.");
			return;
		}
		
		
		String fileName = args[0];
		String action = args[1];
		
		Scanner sc = new Scanner(System.in);
		
		//Read the file and count the frequencies 
		Organize.readAndOrganize(fileName);
		
		//Attach chars and frequencies and place them in array
		Node[] arr = Organize.generateArray(Organize.alc, Organize.alf, Organize.size);
	
		//Sort with respect to ASCII then with respect to frequencies
		Sort.sortCHAR(arr);
		Sort.sortFREQ(arr);
		
		//Create the Huffman coding Tree
		Node root = HuffmanTree.generateHuffTree(arr);
		
		//Create the map used to connect the Characters to their respective encoded values
		TwoWayMap<Character, String> map = new TwoWayMap<Character, String>();
		
		int[] levels = new int[50]; //Assuming the depth is less than 100
		HuffmanTree.logCodes(map, root, levels, 0); //Retrieve each characters respective code sequence and keep record
		
		//System.out.println("Enter action: ");
		//String action = sc.nextLine();
		
		String code = "";
		if (action.equals("encode")) {
			//System.out.println("Please enter the words you would like to encode: ");
			String roughPhrase = sc.nextLine();
			String phrase = roughPhrase.toLowerCase();
			code = HuffmanTree.encoder(map, phrase);
		}
		
		if (action.equals("decode")) {
			//System.out.println("Please enter the sequence you would like to decode: ");
			String phrase = sc.nextLine();
			code = HuffmanTree.decoder(map, phrase);
		}
		
		System.out.println(code);

		
		

	}

}

/*
        Organize.readAndOrganize("haiku1.txt");
		String practiceStr = "1101101100111111010110000111010110111";
		System.out.println(HuffmanTree.decoder(map,practiceStr));
		
		System.out.println(HuffmanTree.encoder(map,"sci-fi a"));
 */







