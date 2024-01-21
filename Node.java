package comp352.dsandalgos.huffman;

	public class Node {
		
		char character;
		int frequency;
		Node left;
		Node right;
		
		public Node(char ch, int fr) {
			character = ch;
			frequency = fr;
			left = right = null;
		}
		public char getCharacter() {
			return character;
		}
		public void setCharacter(char character) {
			this.character = character;
		}
		public int getFrequency() {
			return frequency;
		}
		public void setFrequency(int frequency) {
			this.frequency = frequency;
		}
		public String toString() {
			return "Element [character = " + character + ", frequency = " + frequency + "]";
		}
		
	}





