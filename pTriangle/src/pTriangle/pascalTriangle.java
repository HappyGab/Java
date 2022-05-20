package pTriangle;

public class pascalTriangle {

	static int arr[] = {};
	
	public static void main(String[] args) {
		
		for (int i = 0; i<10; i++) {
			
			triangle Pasc = new triangle(i, arr);
					
			arr = Pasc.getarr();
			
			for (int i2 = 0; i2 < arr.length; i2++) {
				System.out.print(arr[i2]);
				System.out.print(" ");
				}
			System.out.println("");
		}
		
	}

}
