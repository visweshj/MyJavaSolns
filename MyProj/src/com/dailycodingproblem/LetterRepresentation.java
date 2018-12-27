package com.dailycodingproblem;

import java.util.*;

/**
 * @author visweshjagadeesan
 * Given a mapping of digits to letters (as in a phone number), and a digit string, 
 * return all possible letters the number could represent. You can assume each valid number in the mapping 
 * is a single digit.
	For example if {“2”: [“a”, “b”, “c”], 3: [“d”, “e”, “f”], …} 
	then “23” should return [“ad”, “ae”, “af”, “bd”, “be”, “bf”, “cd”, “ce”, “cf"].
 */
public class LetterRepresentation {
	public static void main(String[] args) {
		Map<String, List<String>> numberCombo = new HashMap<>();
		
		numberCombo.put("0", List.of(" "));
		numberCombo.put("1", List.of(""));
		numberCombo.put("2", List.of("a","b","c"));
		numberCombo.put("3", List.of("d","e","f"));
		numberCombo.put("4", List.of("g","h","i"));
		numberCombo.put("5", List.of("j","k","l"));
		numberCombo.put("6", List.of("m","n","0"));
		numberCombo.put("7", List.of("p","q","r","s"));
		numberCombo.put("8", List.of("t","u","v"));
		numberCombo.put("9", List.of("w","x","y","z"));
				
		List<String> result = findCombos(numberCombo, "23");
		System.out.println(result);
	}

	private static List<String> findCombos(Map<String, List<String>> numberCombo, String number) {
		
		
		
		
		
		return null;
	}
	
	
	
	
	
	
}
