package com.model;


import java.util.Comparator;

public class SortbyAge implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		return ((Employee) o1).getSalary().compareTo(((Employee) o2).getSalary());
	}


}