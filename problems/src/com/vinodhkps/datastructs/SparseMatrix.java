package com.vinodhkps.datastructs;

import java.util.HashMap;
import java.util.Map;

/**
 * A space efficient representation of sparse matrix. Any "m" rows, "n" column
 * matrix can be represented by this as long as m * n is <=
 * {@link Integer#MAX_VALUE}
 * 
 * @author vinodhkps
 *
 * @param <T>
 */
public class SparseMatrix<T> {

	private final Integer maxNumberOfColumns;
	private final Integer maxNumberOfRows;

	private Map<Integer, T> data;

	/**
	 * Creates a New Instance of the Matrix for the specified set of columns and
	 * rows. If the parameters are not valid and are out of the range supported
	 * by this Matrix, <code>null</code> will be returned
	 * 
	 * @param maxNumberOfColumns
	 *            -- Maximum number of columns that are possible in this Matrix
	 * @param maxNumberOfRows
	 *            -- Max Number of rows that are possible in this Matrix
	 * @return an instance of {@link SparseMatrix} if there is enough space
	 *         available or <code>null</code> otherwise. This implementation is
	 *         bound by {@link Integer#MAX_VALUE} as its maximum capacity.
	 */
	public static <T> SparseMatrix<T> newInstance(Integer maxNumberOfColumns,
			Integer maxNumberOfRows) {
		SparseMatrix<T> ret = null;
		if (maxNumberOfColumns != null && maxNumberOfRows != null) {
			Long maxNeeded = Long.valueOf(maxNumberOfColumns)
					* Long.valueOf(maxNumberOfRows);
			if (maxNeeded <= Integer.MAX_VALUE) {
				ret = new SparseMatrix<T>(maxNumberOfColumns, maxNumberOfRows);
			}
		}
		return ret;
	}

	/**
	 * private constructor to ensure only valid instances are created. Use
	 * {@link SparseMatrix#newInstance(Integer, Integer)} to create a new
	 * instance of this object
	 * 
	 * @param maxNumberOfColumns
	 *            -- Maximum number of columns that are possible in this Matrix
	 * @param maxNumberOfRows
	 *            -- Max Number of rows that are possible in this Matrix
	 */
	private SparseMatrix(Integer maxNumberOfColumns, Integer maxNumberOfRows) {
		super();
		this.maxNumberOfColumns = maxNumberOfColumns;
		this.maxNumberOfRows = maxNumberOfRows;
		this.data = new HashMap<Integer, T>();
	}

	/**
	 * Operation to add an element to this matrix. If there are elements
	 * previously stored in the location represented by this location, it will
	 * be overwritten
	 * 
	 * @param row
	 *            integer identifier for the row
	 * @param column
	 *            integer identifier for the column
	 * @param cellData
	 *            the data that needs to be stored in the cell location
	 *            specified by (row,column)
	 * 
	 * @throws IllegalArgumentException
	 *             when row or column values are out of bounds i.e. less than 0
	 *             or greater than maximum number of columns or rows
	 *             respectively
	 */
	public void put(int row, int column, T cellData)
			throws IllegalArgumentException {
		if (row < 0 || column < 0 || row > maxNumberOfRows
				|| column > maxNumberOfColumns) {
			throw new IllegalArgumentException(
					"Row or Column values are out of range!");
		}
		int position = (row * maxNumberOfColumns) + column;
		data.put(position, cellData);
	}

	/**
	 * Operation to obtain an element from the matrix
	 * 
	 * @param row
	 *            integer identifier for the row
	 * @param column
	 *            integer identifier for the column
	 * @return value stored at location (row,column); can be <code>null</code>
	 * 
	 * @throws IllegalArgumentException
	 *             when row or column values are out of bounds i.e. less than 0
	 *             or greater than maximum number of columns or rows
	 *             respectively
	 */
	public T get(int row, int column) throws IllegalArgumentException {
		if (row < 0 || column < 0 || row > maxNumberOfRows
				|| column > maxNumberOfColumns) {
			throw new IllegalArgumentException(
					"Row or Column values are out of range!");
		}
		int position = (row * maxNumberOfColumns) + column;
		return data.get(position);
	}
}
