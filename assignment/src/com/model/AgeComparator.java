package com.model;

import java.util.Comparator;

public class AgeComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		int result = ((Employee) o1).getAge().compareTo(((Employee) o2).getAge());
		if (result == 0) {
			return ((Employee) o1).getDateOfJoining().compareTo(((Employee) o2).getDateOfJoining());
		}

		return result;
	}

}


