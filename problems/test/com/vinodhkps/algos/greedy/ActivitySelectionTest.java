package com.vinodhkps.algos.greedy;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Unit test cases for {@link ActivitySelection}
 * 
 * @author Vinodh Periyasamy
 *
 */
public class ActivitySelectionTest {

	@Test
	public void testSelect() {
		int[] startTimes = { 1, 3, 0, 5, 8, 5 };
		int[] endTimes = { 2, 4, 6, 7, 9, 9 };

		List<Integer> expected = new ArrayList<Integer>();
		expected.add(0);
		expected.add(1);
		expected.add(3);
		expected.add(4);

		List<Integer> actual = new ActivitySelection().select(startTimes,
				endTimes);

		assertEquals(expected, actual);

	}

}
