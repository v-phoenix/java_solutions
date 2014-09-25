package com.vinodhkps.fun.threads;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test cases for {@link IntegerBuffer}
 * 
 * @author vinodhkps
 *
 */
public class IntegerBufferTest {

	IntegerBuffer classUnderTest;

	@Test
	public void testAddWhenIndexIsLessThanBufferLength() {
		classUnderTest = new IntegerBuffer(10);
		assertTrue(classUnderTest.add(27));
	}

	@Test
	public void testAddWhenIndexIsNotLessThanBufferLength() {
		classUnderTest = new IntegerBuffer(0);
		assertFalse(classUnderTest.add(27));
	}

}
