package com.vinodhkps.fun.threads;

/**
 * Simple Array Buffer to hold Integer data providing ways to add and remove
 * data from the buffer
 * 
 * @author vinodhkps
 *
 */

public class IntegerBuffer {

	private int index;
	private int[] buffer;

	public IntegerBuffer(int bufferSize) {
		super();
		buffer = new int[bufferSize];
	}

	boolean add(int num) {
		boolean ret = false;
		if (this.index < buffer.length) {
			this.buffer[this.index] = num;
			ret = true;
		}
		return ret;
	}

	int remove() {
		while (true) {
			if (this.index > 0) {
				return this.buffer[--this.index];
			}
		}
	}

}
