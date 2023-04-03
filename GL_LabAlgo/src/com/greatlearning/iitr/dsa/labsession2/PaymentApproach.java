package com.greatlearning.iitr.dsa.labsession2;

import java.util.*;

/*
 * the size of the currency denominations, the currency denominations
 * themselves, and the amount to pay. It then sorts the denominations in
 * ascending order, and iterates through them from the largest to the smallest.
 * For each denomination, it computes the number of notes required to pay the
 * remaining amount, and pushes that denomination onto a stack if the note count
 * is greater than 0.
 * 
 * Once all the denominations have been processed, the program pops notes off
 * the stack and prints out the denomination and the number of notes required to
 * pay the remaining amount.
 */

public class PaymentApproach {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of currency denominations: ");
		int n = sc.nextInt();
		int[] currencies = new int[n];
		System.out.println("Enter the currency denominations value:");
		for (int i = 0; i < n; i++) {
			currencies[i] = sc.nextInt();
		}
		Arrays.sort(currencies); // sort in ascending order
		System.out.print("Enter the amount you want to pay: ");
		int amount = sc.nextInt();

		Stack<Integer> notes = new Stack<>();
		int remaining = amount;
		int i = n - 1; // start from highest denomination
		while (i >= 0 && remaining > 0) {
			int denom = currencies[i];
			if (denom <= remaining) {
				int count = remaining / denom;
				remaining %= denom;
				notes.push(denom);

				System.out.println(denom + ":" + count); // Finally, the program prints the minimum number of notes used
															// to pay the net amount.

			}
			i--;
			sc.close();
		}
	}
}