package comm.model;

import java.util.Comparator;

public class Desccomparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {

		return ((Todo)o1).getDesc().compareTo(((Todo)o2).getDesc());
	}



}
