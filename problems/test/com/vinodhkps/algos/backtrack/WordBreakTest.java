package com.vinodhkps.algos.backtrack;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WordBreakTest {

	WordBreak classUnderTest = new WordBreak();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBreakAll() {
		Set<String> dictionary = new HashSet<String>();
		dictionary.add("this");
		dictionary.add("is");
		dictionary.add("a");
		dictionary.add("good");
		dictionary.add("day");

		assertTrue(classUnderTest.breakAll("thisisagoodday", dictionary));
		assertFalse(classUnderTest.breakAll("thisissagoodday", dictionary));
	}

}
