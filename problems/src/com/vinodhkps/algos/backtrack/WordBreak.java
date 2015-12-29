package com.vinodhkps.algos.backtrack;

import java.util.Set;

public class WordBreak {

	boolean breakAll(String input, Set<String> dictionary) {
		if (input == null || input.length() == 0 || dictionary.isEmpty())
			return false;

		if (!findWords(input, dictionary, "")) {
			System.out.println("Could not break the input String");
			return false;
		}
		return true;

	}

	boolean findWords(String input, Set<String> dictionary, String string) {
		if (input.length() == 0) {
			System.out.println("Broken Words:" + string);
			return true;
		} else {
			int index = 0;
			String word = "";
			while (index < input.length()) {
				word += input.charAt(index);
				if (dictionary.contains(word)) {
					if (findWords(input.substring(index + 1), dictionary,
							string + " " + word)) {
						return true;
					} else {
						// Backtrack
						index++;
					}
				} else {
					index++;
				}
			}
		}
		return false;
	}

}
