package com.vinodhkps.datastructs;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Unit test cases for {@link SparseMatrix}
 * 
 * @author vinodhkps
 *
 */
public class SparseMatrixTest {

	@Test
	public void testNewInstanceWhenMaxRowAndMaxColumnHavePermissibleValues() {
		int maxRows = 1000;
		int maxColumns = 2000;
		SparseMatrix<Integer> actual = SparseMatrix.newInstance(maxColumns,
				maxRows);
		assertNotNull(actual);
	}

	@Test
	public void testNewInstanceWhenMaxRowAndMaxColumnDoesNotHavePermissibleValues() {
		int maxRows = Integer.MAX_VALUE;
		int maxColumns = Integer.MAX_VALUE;
		SparseMatrix<Integer> actual = SparseMatrix.newInstance(maxColumns,
				maxRows);
		assertNull(actual);
	}

	@Test
	public void testNewInstanceWhenMaxRowIsNull() {
		Integer maxRows = null;
		int maxColumns = Integer.MAX_VALUE;
		SparseMatrix<Integer> actual = SparseMatrix.newInstance(maxColumns,
				maxRows);
		assertNull(actual);
	}

	@Test
	public void testNewInstanceWhenMaxColumnIsNull() {
		Integer maxRows = Integer.MAX_VALUE;
		Integer maxColumns = null;
		SparseMatrix<Integer> actual = SparseMatrix.newInstance(maxColumns,
				maxRows);
		assertNull(actual);
	}

	@Test
	@Ignore
	public void testPut() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testGet() {
		fail("Not yet implemented");
	}

}
