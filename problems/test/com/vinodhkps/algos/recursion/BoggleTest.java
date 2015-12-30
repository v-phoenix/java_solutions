package com.vinodhkps.algos.recursion;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.vinodhkps.algos.recursion.Boggle;

public class BoggleTest {

	Boggle classUnderTest;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSearchAndPrintWords() {
		char[][] input = { { 'G', 'I', 'Z' }, { 'U', 'E', 'K' },
				{ 'Q', 'S', 'E' } };
		Set<String> dictionary = new HashSet<String>();
		dictionary.add("GEEKS");
		dictionary.add("QUIZ");

		classUnderTest = new Boggle(input, dictionary);
		Set<String> actual = classUnderTest.searchAndPrintWords();
		Set<String> expected = new HashSet<String>(Arrays.asList(new String[] {
				"GEEKS", "QUIZ" }));
		System.out.println("Obtained words " + actual.toString());

		assertEquals(expected, actual);

	}
}
