import java.util.Arrays;

/**
 * Arrays Question 1: Dutch Flag Partition
 * Similar to Quick Sort partitioning array around a pivot.
 * 
 * @author nishakk
 *
 */
public class DutchFlagPartition {
	public static void main(String[] args) {
		int[] arr = {1, 2, -1, 3, 1, 4, 0};
		dutchFlagPartition(arr, 0);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void dutchFlagPartition(int[] arr, int pivotIndex) {
		int small = 0, equal = 0, large = arr.length;
		int pivot = arr[pivotIndex];
		while (equal < large) {
			if (arr[equal] < pivot) {
				swap(arr, equal++, small++);
			} else if (arr[equal] == pivot) {
				equal++;
			} else {
				swap(arr, equal, --large);
			}
		}
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
