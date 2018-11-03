package connectFour;

import java.util.Scanner;

public class connectFour {

	public static void main(String[] args) {
		// Scanner scan = new Scanner(System.in);
		char[][] board = new char[8][8];
		int winner = 0;
		int turn = 0;
		boolean freeSpace = true;
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				board[row][col] = ' ';
			}
		}
		printBoard(board);
		while (winner == 0) {
			if (freeSpace == true) {
				if (turn % 2 == 0) {
					System.out.println("----------------------");
					System.out.println("Player 1 Enter Column #");
				} else {
					System.out.println("----------------------");
					System.out.println("Player 2 Enter Column #");
				}
			}
			Scanner scan = new Scanner(System.in);
			int x = scan.nextInt() - 1;
			freeSpace = placePiece(board, x, turn);
			// System.out.println(freeSpace);
			if (freeSpace == false)
				turn++;
			turn++;
			// System.out.println("turn"+turn);
			checkWinner(board);
			if (checkWinner(board) == 0) {
				// System.out.println("no winner");
				winner = 0;
				// no winner
			} else if (checkWinner(board) == 1) {
				System.out.println("Player 1 wins!");
				winner = 1;
			} else if (checkWinner(board) == 2) {
				System.out.println("Player 2 wins!");
				winner = 2;
			}
		}
	}

	public static void printBoard(char[][] b) {
		int columnNum = 1;
		System.out.println(" 1 2 3 4 5 6 7 8");
		for (int row = 0; row < b.length; row++) {
			for (int col = 0; col < b[0].length; col++) {
				System.out.print("|");
				System.out.print(b[row][col]);

			}
			System.out.print("|");
			System.out.println();
			System.out.print("-----------------");
			System.out.println();
		}
	}

	public static boolean placePiece(char[][] a, int columnPlacement, int turnNum) {
		int turn = turnNum;
		int x = columnPlacement;
		System.out.println("Put in column number 1 - 8");
		if (x > 7 || x < 0) {
			System.out.println("COLUMN NUMBER IS NOT AVAILABLE");
			return false;
		}
		for (int i = 7; i <= 7; i--) {
			if (i < 0) {
				System.out.println("THIS COLUMN IS FULL PLEASE CHOOSE ANOTHER");
				return false;
			}
			if (turn % 2 == 0) {
				// X turn
				if (a[i][x] != '0' && a[i][x] != 'X') {
					a[i][x] = '0';
					// System.out.println(i +" "+x);
					break;
				}

			} else {
				// Y turn
				if (a[i][x] != 'X' && a[i][x] != '0') {
					a[i][x] = 'X';
					// System.out.println(i +" "+x);
					break;
				}

			}

		}

		printBoard(a);

		return true;
	}

	public static int checkWinner(char[][] c) {
		// System.out.println("checking Horizontal");
		for (int row = 0; row < c.length; row++) {
			for (int col = 0; col < 5; col++) {
				if (c[row][col] == 'X' && c[row][col + 1] == 'X' && c[row][col + 2] == 'X' && c[row][col + 3] == 'X')
					return 2;
				else if (c[row][col] == '0' && c[row][col + 1] == '0' && c[row][col + 2] == '0'
						&& c[row][col + 3] == '0')
					return 1;
				// System.out.println("Checking"+row+","+col+"--"+row+","+(col+1)+"--"+row+","+(col+2)+"--"+row+","+(col+3));
			}
		}
		// System.out.println("checking vertical");
		for (int row = 0; row < c.length; row++) {
			for (int col = 0; col < 5; col++) {
				if (c[col][row] == 'X' && c[col + 1][row] == 'X' && c[col + 2][row] == 'X' && c[col + 3][row] == 'X')
					return 2;
				if (c[col][row] == '0' && c[col + 1][row] == '0' && c[col + 2][row] == '0' && c[col + 3][row] == '0')
					return 1;
				// System.out.println("Checking"+col+","+row+"--"+(col+1)+","+row+"--"+(col+2)+","+row+"--"+(col+3)+","+row);
			}
		}
		return 0;
	}

}
