package org.ssglobal.training.codes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Fruits {
	
	private List<String> stand = new ArrayList<>();
	
	public boolean addFruits(String... fruits) {
		try {
			for(String f: fruits) {
				stand.add(f);
			}
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public int countFruit() {
		return 0;
	}
	
	
	public boolean defruit(String fruit) {
		boolean result = stand.remove(fruit);
		if (result) {
			return true;
		}
		return false;
	}
	
	public List<String> getStand(){
		return stand;
	}
	
	public Stream<String> getFruitStream(){
		return Stream.of("Apple", "Mango"); // nag create
	}

}
