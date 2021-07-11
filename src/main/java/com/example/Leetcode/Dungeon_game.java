package com.example.Leetcode;

import java.util.List;

import org.springframework.boot.SpringApplication;

public class Dungeon_game {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[][] dungeon = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		int res;
		res = dungeon(dungeon);
		System.out.println(res);
	}

	public static int dungeon(int[][] dungeon) {
		int r = dungeon.length;
		int c = dungeon[0].length;
		int[][] sol = new int[r][c];

		sol[r - 1][c - 1] = dungeon[r - 1][c - 1] > 0 ? 1 : 1 - dungeon[r - 1][c - 1];

		for (int i = r - 2; i >= 0; --i)
			sol[i][c - 1] = Math.max(sol[i + 1][c - 1] - dungeon[i][c - 1], 1);
		for (int j = c - 2; j >= 0; --j)
			sol[r - 1][j] = Math.max(sol[r - 1][j + 1] - dungeon[r - 1][j], 1);

		for (int i = r - 2; i >= 0; --i) {
			for (int j = c - 2; j >= 0; --j) {
				sol[i][j] = Math.max(Math.min(sol[i + 1][j], sol[i][j + 1]) - dungeon[i][j], 1);
			}
		}
		return sol[0][0];
	}
}
