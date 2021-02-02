import java.util.Scanner;

public class MatrizEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int l = sc.nextInt();
		int c = sc.nextInt();
		int [][] matriz = new int[l][c];

		for(int i = 0; i < l; i++) {
			for(int j = 0; j < c; j++) {
				matriz[i][j] = sc.nextInt();
			}
		}

		int num = sc.nextInt();
		findNum(num,matriz);

		sc.close();
	}

	public static void findNum(int num, int[][]matriz){
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[i].length; j++) {
				if(matriz[i][j] == num) {
					System.out.println("Position " +i+","+j);
					if(Left(matriz, i, j) != null) {
						System.out.println("Left: " + Left(matriz, i, j));
					}
					if(Right(matriz, i, j) != null) {
						System.out.println("Right: " + Right(matriz, i, j));	
					}
					if(Up(matriz, i, j) != null) {
						System.out.println("Up: " + Up(matriz, i, j));	
					}
					if(Down(matriz, i, j) != null) {
						System.out.println("Down: " + Down(matriz, i, j));	
					}
				}
			}	
		}
	}

	public static Integer Left(int[][] matriz, int l, int c) {
		if(c != 0) {
			return matriz[l][c-1];
		}
		return null;
	}

	public static Integer Right(int[][] matriz, int l, int c) {
		if(c != matriz[l].length - 1) {
			return matriz[l][c+1];
		}
		return null;
	}

	public static Integer Up(int[][] matriz, int l, int c) {
		if(l != 0) {
			return matriz[l-1][c];
		}
		return null;
	}

	public static Integer Down(int[][] matriz, int l, int c) {
		if(l != matriz.length - 1) {
			return matriz[l+1][c];
		}
		return null;
	}
}

/*
 // ------------------------codigo do professor:
 package application;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] mat = new int[m][n];
		
		for (int i=0; i<mat.length; i++) {
			for (int j=0; j<mat[i].length; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		
		int x = sc.nextInt();
		
		for (int i=0; i<mat.length; i++) {
			for (int j=0; j<mat[i].length; j++) {
				if  (mat[i][j] == x) {
					System.out.println("Position " + i + "," + j + ":");
					if (j > 0) {
						System.out.println("Left: " + mat[i][j-1]);
					}
					if (i > 0) {
						System.out.println("Up: " + mat[i-1][j]);
					}
					if (j < mat[i].length-1) {
						System.out.println("Right: " + mat[i][j+1]);
					}
					if (i < mat.length-1) {
						System.out.println("Down: " + mat[i+1][j]);
					}
				}
			}
		}
		
		sc.close();
	}
}
 */