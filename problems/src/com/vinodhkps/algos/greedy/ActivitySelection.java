package com.vinodhkps.algos.greedy;

import java.util.ArrayList;
import java.util.List;

/*

 You are given n activities with their start and finish times. 
 Select the maximum number of activities that can be performed 
 by a single person, assuming that a person can only work on 
 a single activity at a time.

 Consider the following 6 activities. 
 start[]  =  {1, 3, 0, 5, 8, 5};
 finish[] =  {2, 4, 6, 7, 9, 9};
 The maximum set of activities that can be executed 
 by a single person is {0, 1, 3, 4}

 */
public class ActivitySelection {

	// Assumes, end times (et[]) are in non decreasing order

	List<Integer> select(int[] st, int[] et) {

		List<Integer> ret = new ArrayList<Integer>();

		int i = 0;
		ret.add(i);

		for (int j = 1; j < st.length; j++) {
			if (st[j] > et[i]) {
				ret.add(j);
				i = j;
			}
		}

		return ret;
	}

}
