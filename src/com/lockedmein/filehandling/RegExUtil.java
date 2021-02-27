package com.lockedmein.filehandling;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExUtil {
	
	private static String choiceRegEx = "\\d";

	public RegExUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public int returnChoiceValue(String getChoice) {
		
		Pattern choicePattern = Pattern.compile(choiceRegEx);
		Matcher matchPattern = choicePattern.matcher(getChoice);
		
		if(matchPattern.find()) {
			return Integer.parseInt(getChoice);
			
		}
		else {
			return -1;
		}
		
	}

}
