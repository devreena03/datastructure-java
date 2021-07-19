package array;

import java.util.Random;

public class MatrixUtil {
	
	static Random  random = new Random();
	
	public static void print(int[][] matrix) {
		System.out.println("[");
		for(int i =0; i< matrix.length; i++) {
			System.out.println("{");
			for(int j =0; j< matrix[i].length; j++) {
				System.out.print(matrix[i][j] +", ");
			}
			System.out.print("}");
		}
		System.out.println("]");
	}
	
	public static int[][] geRandomMatrix(int n, int m){
		
		int[][] matrix = new int[n][m];
		for(int i =0; i< matrix.length; i++) {
			for(int j =0; j< matrix[i].length; j++) {
				matrix[i][j] = random.nextInt(10);
			}
		}
		return matrix;
	}

}
