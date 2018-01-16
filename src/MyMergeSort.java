
public class MyMergeSort {
	private int[] array;
	private int[] tempMergArr;
	private int length;

	public static void main(String a[]){

		int[] inputArr = {45,23,11,89,77,98,4,28,65,43};
		int[] tmp = new int[inputArr.length];
		mymergesort(tmp, inputArr, 0 ,inputArr.length-1);
		for(int i:inputArr){
			System.out.print(i);
			System.out.print(" ");
		}
	}

	public void sort(int inputArr[]) {
		this.array = inputArr;
		this.length = inputArr.length;
		this.tempMergArr = new int[length];
		doMergeSort(0, length - 1);
	}
	
	public static void mymergesort(int[] temp, int[] array, int lowerIndex, int higherIndex){
		if (lowerIndex < higherIndex) {
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			// Below step sorts the left side of the array
			mymergesort(temp, array, lowerIndex, middle);
			// Below step sorts the right side of the array
			mymergesort(temp, array, middle + 1, higherIndex);
			// Now merge both sides
			mymergeParts(temp, array, lowerIndex, middle, higherIndex);
		}
	}
	
	private static void mymergeParts(int[] temp, int[] array, int lowerIndex, int middle, int higherIndex) {

		for (int i = lowerIndex; i <= higherIndex; i++) {
			temp[i] = array[i];
		}
		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;
		while (i <= middle && j <= higherIndex) {
			if (temp[i] <= temp[j]) {
				array[k] = temp[i];
				i++;
			} else {
				array[k] = temp[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			array[k] = temp[i];
			k++;
			i++;
		}

	}


	private void doMergeSort(int lowerIndex, int higherIndex) {

		if (lowerIndex < higherIndex) {
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			// Below step sorts the left side of the array
			doMergeSort(lowerIndex, middle);
			// Below step sorts the right side of the array
			doMergeSort(middle + 1, higherIndex);
			// Now merge both sides
			mergeParts(lowerIndex, middle, higherIndex);
		}
	}

	private void mergeParts(int lowerIndex, int middle, int higherIndex) {

		for (int i = lowerIndex; i <= higherIndex; i++) {
			tempMergArr[i] = array[i];
		}
		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;
		while (i <= middle && j <= higherIndex) {
			if (tempMergArr[i] <= tempMergArr[j]) {
				array[k] = tempMergArr[i];
				i++;
			} else {
				array[k] = tempMergArr[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			array[k] = tempMergArr[i];
			k++;
			i++;
		}

	}
}
