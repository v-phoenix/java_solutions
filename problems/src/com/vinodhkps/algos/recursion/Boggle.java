package com.vinodhkps.algos.recursion;

import java.util.HashSet;
import java.util.Set;

public class Boggle {

	final char[][] input;
	final int size;
	final Set<String> dictionary;

	boolean[][] visited;

	public Boggle(char[][] input, Set<String> dictionary) {
		super();
		this.input = input;
		size = input.length;
		visited = new boolean[size][size];
		this.dictionary = dictionary;
	}

	Set<String> searchAndPrintWords() {
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				visited[i][j] = false;

		Set<String> words = new HashSet<String>();
		String word = "";

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				searchWords(i, j, words, word);
			}
		}

		return words;

	}

	void searchWords(int i, int j, Set<String> words, String word) {

		if (visited[i][j])
			return;
		else {
			word += input[i][j];

			visited[i][j] = true;
			if (dictionary.contains(word)) {
				words.add(word);
			} else {

				if (canMove(i + 1, j)) {
					searchWords(i + 1, j, words, word);
				}
				if (canMove(i + 1, j + 1)) {
					searchWords(i + 1, j + 1, words, word);
				}
				if (canMove(i + 1, j - 1)) {
					searchWords(i + 1, j - 1, words, word);
				}

				if (canMove(i, j - 1)) {
					searchWords(i, j - 1, words, word);
				}

				if (canMove(i, j + 1)) {
					searchWords(i, j + 1, words, word);
				}

				if (canMove(i - 1, j)) {
					searchWords(i - 1, j, words, word);
				}
				if (canMove(i - 1, j + 1)) {
					searchWords(i - 1, j + 1, words, word);
				}

				if (canMove(i - 1, j - 1)) {
					searchWords(i - 1, j - 1, words, word);
				}

				visited[i][j] = false;
				word = word.substring(0, word.length() - 1); // erase the last
																// // letter;
			}
		}

	}

	boolean canMove(int i, int j) {
		return (i >= 0 && i < size && j >= 0 && j < size);
	}
}
