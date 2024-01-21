

package comp352.dsandalgos.huffman;


public class PriorityQueue {
	
	Node[] pq = null;
	int start;
	int end;
	
	public PriorityQueue(Node[] arr) {
		pq = arr;
		start = 0;
		end = arr.length-1;
	}
	
	public int getStart() {
		return start;
	}
	
	public int getEnd() {
		return end;
	}
	
	// O(1) time
	public Node poll() {
		Node topPriority = pq[start];
		pq[start++] = null;
		return topPriority;
	}
	
	// O(n) time
	public void add(Node elem) {
		if (start == 0) {
			return;
		}
		else {
			pq[--start] = elem;
			int temp = start;
			int j = temp + 1;
			while ((temp != end) && (elem.frequency >= pq[j].frequency)){
				pq[temp++] = pq[j++];
			}
			pq[--j] = elem;
		}
	}
	
	public Node peek() {
		return pq[start];
	}
	
	public boolean isEmpty() {
		return (pq[end] != null);
	}
	
	public int size() {
		return (end - start) +1;
	}
	
	
}










/*
 *  Attempt at priority queue, failed attempt because was only able to keep it sorted with respect to one aspect instead of the two
 * 
	class PriorityQueue {
		
	    private ArrayList<Node> heap;

	    public PriorityQueue() {
	        heap = new ArrayList<>();
	    }

	    public void insert(Node node) {
	        heap.add(node);
	        heapifyUp(heap.size() - 1);
	    }

	    public Node poll() {
	        if (heap.isEmpty()) {
	            return null;
	        }

	        Node root = heap.get(0);
	        Node lastNode = heap.remove(heap.size() - 1);

	        if (!heap.isEmpty()) {
	            heap.set(0, lastNode);
	            heapifyDown(0);
	        }

	        return root;
	    }

	    private void heapifyUp(int index) {
	        int parentIndex = (index - 1) / 2;

	        while (index > 0 && compareNodes(heap.get(index), heap.get(parentIndex)) < 0) {
	            swapNodes(index, parentIndex);
	            index = parentIndex;
	            parentIndex = (index - 1) / 2;
	        }
	    }

	    private void heapifyDown(int index) {
	        int smallest = index;
	        int leftChildIndex = 2 * index + 1;
	        int rightChildIndex = 2 * index + 2;

	        if (leftChildIndex < heap.size() && compareNodes(heap.get(leftChildIndex), heap.get(smallest)) < 0) {
	            smallest = leftChildIndex;
	        }
	        if ((leftChildIndex < heap.size()) && (heap.get(smallest).getFrequency() == heap.get(leftChildIndex).getFrequency())) {
	        	if (heap.get(smallest).getCharacter() > heap.get(leftChildIndex).getCharacter()) {
	        		smallest = leftChildIndex;
	        	}
	        }

	        if (rightChildIndex < heap.size() && compareNodes(heap.get(rightChildIndex), heap.get(smallest)) < 0) {
	            smallest = rightChildIndex;
	        }
	        if ((rightChildIndex < heap.size()) && (heap.get(smallest).getFrequency() == heap.get(rightChildIndex).getFrequency())) {
	        	if (heap.get(smallest).getCharacter() > heap.get(rightChildIndex).getCharacter()) {
	        		smallest = rightChildIndex;
	        	}
	        }
	        
	       

	        if (smallest != index) {
	            swapNodes(index, smallest);
	            heapifyDown(smallest);
	        }
	    }

	    private void swapNodes(int index1, int index2) {
	        Node temp = heap.get(index1);
	        heap.set(index1, heap.get(index2));
	        heap.set(index2, temp);
	    }

	    private int compareNodes(Node node1, Node node2) {
	        if (node1.getFrequency() == node2.getFrequency()) {
	            if (node1.getCharacter() == node2.getCharacter()) {
	                return 0;
	            } else if (node1.getCharacter() < node2.getCharacter()) {
	                return -1;
	            } else {
	                return 1;
	            }
	        }
	        return Integer.compare(node1.getFrequency(), node2.getFrequency());
	    }


	    public boolean isEmpty() {
	        return heap.isEmpty();
	    }
	}
*/



