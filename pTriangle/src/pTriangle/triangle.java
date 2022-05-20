package pTriangle;

public class triangle {

	int arr[] = {};


	public triangle(int x, int[] y) {

		int arr[] = new int[x+1];

		for (int i = 0; i < x+1; i++) {
			arr[i] = 1;
		}

		if (y.length > 1) {

			for (int i = 1; i < arr.length - 1; i++) {

				arr[i] = y[i-1] + y[i];
			}
		}

		this.arr = arr;
	}	 

	public void printarr() {

		for (int i2 = 0; i2 < arr.length; i2++) {
			System.out.print(arr[i2]);
		}
	}

	public int[] getarr() {

		return arr;
	}
}
