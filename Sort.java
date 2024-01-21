package comp352.dsandalgos.huffman;
//Would have used QuickSort but not stable, would have used ShellSort but not stable, would have used mergeSort but does not actually swap, just copies and I need swap
public class Sort {
	
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void sortCHAR(Node[] arr) {
		
		for (int i = 1; i < arr.length; i++) {
			int j = i;
			Node temp = arr[i];
			while(( j > 0) && (arr[j-1].character > temp.character)) {
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = temp;
		}
	}
	
	public static void sortFREQ(Node[] arr) {
		
		for (int i = 1; i < arr.length; i++) {
			int j = i;
			Node temp = arr[i];
			while(( j > 0) && (arr[j-1].frequency > temp.frequency)) {
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = temp;
		}
		
	}
	
	
	
	
}


