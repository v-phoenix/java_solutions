package com.vinodhkps.algos.backtrack;

/*
 Given the following maze, find the path where a rat can travel from source to destination

 Source: (0,0)
 Destination: (3,3)

 {1, 0, 0, 0}
 {1, 1, 0, 1}
 {0, 1, 0, 0}
 {1, 1, 1, 1}

 Cells in the above marked as zero are non accessible or in other words, blocked.

 */

public class RatsInAMaze {

	enum Direction {
		up, down, left, right
	};

	int[][] solve(int[][] inputMaze) {
		int size = inputMaze.length;
		int ret[][] = new int[size][size];

		findPath(inputMaze, 0, 0, ret, Direction.up);

		return ret;

	}

	boolean findPath(int[][] inputMaze, int i, int j, int[][] ret, Direction dir) {
		int size = inputMaze[0].length;
		if (i == size - 1 && j == size - 1) {
			ret[i][j] = 1;
			return true;
		} else {
			if (canMove(inputMaze, i, j)) {
				ret[i][j] = 1;
				// Try Moving Up
				if (dir != Direction.down
						&& findPath(inputMaze, i + 1, j, ret, Direction.up)) {
					return true;
				}
				// Try Moving Down
				if (dir != Direction.up
						&& findPath(inputMaze, i - 1, j, ret, Direction.down)) {
					return true;
				}
				// Try Moving Left
				if (dir != Direction.right
						&& findPath(inputMaze, i, j - 1, ret, Direction.left)) {
					return true;
				}
				// Try Moving Right
				if (dir != Direction.left
						&& findPath(inputMaze, i, j + 1, ret, Direction.right)) {
					return true;
				}
				// No Paths worked, BackTrack
				ret[i][j] = 0;
				return false;
			}
			return false;
		}
	}

	boolean canMove(int[][] inputMaze, int i, int j) {
		return i >= 0 && j >= 0 && i < inputMaze[0].length
				&& j < inputMaze[0].length && inputMaze[i][j] != 0;
	}
}
