package pgdp.carol;

import static pgdp.MiniJava.*;

import java.util.Arrays;

public class CarolPfadfinder {
	
	public static boolean lastTurnsAreUseless(char[] instr, int filled) {
		if (instr[filled - 2] == 'l' && instr[filled - 1] == 'r') return true;
		else if (instr[filled - 2] == 'r' && instr[filled - 1] == 'l') return true;
		else if (instr[filled - 2] == 'r' && instr[filled - 1] == 'r') return true;
		else if (instr[filled -3] == 'l' && instr[filled - 2] == 'l' && instr[filled - 1] == 'l') return true;
		return false;
		
	}

	static int getMinimalStepsAndTurns(int x, int y, int direction, int findX, int findY) {
		int min = 0;
		double Dic = 0;
		if (x == findX && y == findY) min = 0;
		else if (findX > x && findY > y) Dic = 0.5;
		else if (findX > x && findY < y) Dic = 3.5;
		else if (findX < x && findY > y) Dic = 1.5;
		else if (findX < x && findY < y) Dic = 2.5;
		else if (findX == x && findY > y) Dic = 1;
		else if (findX == x && findY < y) Dic = 3;
		else if (findX > x && findY == y) Dic = 0;
		else Dic = 2;
		if (Math.abs(Dic - direction) == 0) min = 0;
		if (Math.abs(Dic - direction) <= 1) min = 1;
		else min = 2;
		int dis = Math.abs(findX - x) + Math.abs(findY - y);
		min += dis;
		return min;
	}

		
	public static void main(String[] args) {
		/*
		 * You can change this main-Method as you want. This is not being tested.
		 */

		// Note that in this array initialization the rows are in reverse order and both
		// x- and y-axis are swapped.
		int[][] playground = { //
				{ 0, -1, -1, -1, -1 }, //
				{ -1, -1, -1, -1, -1 }, //
				{ -1, -1, 7, 8, 9 }, //
				{ -1, -1, 8, 3, 5 }, //
				{ -1, -1, 9, 5, 3 } //
		};
		int startX = 2;
		int startY = 1;
		int startDir = 0;
		int startBlocks = 1;

		printPlayground(playground, startX, startY, startDir, startBlocks);

		int findX = 4;
		int findY = 4;
		
		int min = getMinimalStepsAndTurns(startX, startY, startDir, findX, findY);
		write(min);
		
//		public static boolean findInstructions(int[][] playground, int x, int y, int direction, int blocks, int findX, int findY, char[] instructions) {
//			
//			return false;
//		}

		// this is expected to have an optimal solution with exactly 40 instructions
		char[] instructions = null;
//		instructions = findOptimalSolution(playground, startX, startY, startDir, startBlocks, findX, findY, 40); // TODO implement
		boolean success = instructions != null;

		if (success) {
			write("SUCCESS");
			printPlayground(playground);
			write(Arrays.toString(instructions));
		} else {
			write("FAILED");
		}
	}
}
