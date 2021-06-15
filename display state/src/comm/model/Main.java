package comm.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		//Creating a List to hold the input strings
		List<String>countryStateList=new ArrayList<String>();
		//Creating a set to hold the country names
		Set<String>set=new LinkedHashSet<String>();
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
		String countryStateCapitalPair=sc.next();
		//Adding the input string to the 'countryStateList'
		countryStateList.add(countryStateCapitalPair);
		//Splitting the input string on the basis of '|'
		//as the delimeter
		String[]array=countryStateCapitalPair.split("\\|");
		//Adding the country name to the set
		set.add(new String(array[0]));
		}
		//Creating a List to hold the 'Country' ojects
		List<Country>countryList=new ArrayList<Country>();
		//Picking up a country name from the set
		for(String country:set)
		{
			//Creating a list to hold all the 'State' objects belonging to the country
			List<State>stateList=new ArrayList<State>();
			for(String countryState:countryStateList)
			{
				String[]array2=countryState.split("\\|");
				if(country.equalsIgnoreCase(array2[0]))
				{
					//Adding a 'State' object to the 'stateList'
					stateList.add(new State(array2[1]));
				}
			}
			//Creating a new 'Country' object
			Country cntr=new Country(country,stateList);
			//Adding the 'Country' object to the 'countryList'
			countryList.add(cntr);
		}
		System.out.println("Countries and States in ascending order\r\n" + 
				"");
		//Sorting the 'countryList' on countryNames
		Collections.sort(countryList);
		//Picking up a 'Country' object from the 'countryList'
		for(Country cntry:countryList)
		{
			//Printing the countryname
			System.out.println(cntry.getName());
			//Sorting the list of states of the retrieved country
			Collections.sort(cntry.getStateList());
			//Printing all the states belonging to the country
			for(State st:cntry.getStateList())
			{
				System.out.println("--"+st.getName());
			}
		}

	}

}

