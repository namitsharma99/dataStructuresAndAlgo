package binaryTrees;

import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		String myArr[] = new String[n];
		String str = in.nextLine();
		myArr = str.split(" ");

		for (int i = n - 1; i >= 0; i--) {
			System.out.print(myArr[i] + " ");
		}

		in.close();
	}
}
