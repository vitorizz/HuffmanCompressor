package comp352.dsandalgos.huffman;

public class HuffmanTree {
	
	Node root;

	static PriorityQueue pq;
	
	//Remove two highest priority from priority queue then join them to new node and add them onto priority queue
	public static Node generateHuffTree(Node[] arr) {
		
		pq = new PriorityQueue(arr);
		
		while (pq.size() != 1) {
			
			Node left = pq.poll();
			Node right = pq.poll();
			
			//All internal nodes of Huffman Tree will have char ∆
			Node parent = new Node('∆', (left.frequency + right.frequency));
			parent.left = left;
			parent.right = right;
			
			pq.add(parent);
			
		}
		
		return pq.poll();
	}
	
	//Calls logCodes on every Node. Goes down left side first, then goes back up, then goes to right. POST ORDER TRAVERSAL
	//The array keeps path of the track its on, the level (depth) of the node is the index that would be altered to 0 or 1
	public static void logCodes(TwoWayMap<Character, String> map, Node root, int[] levels,
             int ind)
		{

		if (root.left != null) {
			levels[ind] = 0;
			logCodes(map, root.left, levels, ind + 1);
		}
	
		if (root.right != null) {
			levels[ind] = 1;
			logCodes(map, root.right, levels, ind + 1);
		}

		if (root.left == null && root.right == null) {
			log(map, root.character, levels, ind);
		}
	}

	private static void log(TwoWayMap<Character, String> map, char c, int[] levels, int ind) {
		String s = "";
		for (int i = 0; i < ind; ++i) {
			  s += levels[i];
			}
		map.put(c, s);
	}
	
	public static String decoder(TwoWayMap<Character, String> map, String s) {
		String c = "";
		String[] code = s.split("");
		String decoded = "";
		for (int i = 0; i < code.length; i++) {
			c += code[i];
			if (map.containsValue(c)) {
				char letter = map.getKey(c);
				decoded += letter;
				c = "";
			}
		}
		return decoded;
	}
	
	public static String encoder(TwoWayMap<Character, String> map, String s) {
		char[] nums = s.toCharArray();
		String encoded = "";
		for (int i = 0; i < nums.length; i++) {
			encoded += map.get(nums[i]);
		}
		return encoded;
	}
	
	
	
	
	
	
	
}



