package com.lockedmein.filehandling;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WelcomePage {
	
	private static Scanner sc;
	private static String choiceRegEx = "[0-9]";

	public WelcomePage() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to the LockedMeIn!");
		System.out.println("A prototype developed by:");
		System.out.println("\tCompany: Lockers Pvt. Ltd.\n\tDeveloper: Harsh Bharatbhai Upadhyay (Lead Software Engineer)");
		System.out.println("\nLockedMeIn is a prototyped project based on the Comman-Line interface with features such as:\n"
				+ "\n\tSelect 1 for Listing the Files present in the File List"
				+ "\n\tSelect 2 for Adding a file in the File List"
				+ "\n\tSelect 3 for Deleting file with the matched name from the File List"
				+ "\n\tSelect 4 for Reading file with the matched name from the File List"
				+ "\n\tSelect 5 for Going back to the main Menu\n");
		
		sc = new Scanner(System.in);
		System.out.print("Please select which operation you would like to perform: ");
		String choiceTemp = sc.next();
		Pattern choicePattern = Pattern.compile(choiceRegEx);
		Matcher matchPattern = choicePattern.matcher(choiceTemp);
		if(matchPattern.find()) {
			int choice = Integer.parseInt(choiceTemp);
			choiceSelection(choice);
		}
		else {
			int choice = -1;
			choiceSelection(choice);
		}
		
	}
	
	private static void choiceSelection(int choice) {
		
		sc = new Scanner(System.in);
		
		switch(choice) {
		
			case 1:
				System.out.println("Hello from the choice 1");
				boolean check = setChoice();
				if(check)
					main(null);
				break;
			case 2:
				System.out.println("Hello from the choice 2");
				break;
			default:
				System.out.println("Doing nothing here");
				break;
		}
	}
	
	private static boolean setChoice() {
		
		sc = new Scanner(System.in);
		
		System.out.print("Do you want to continue with the application interface? " );
		String choice = sc.next();
		if(choice.equalsIgnoreCase("yes"))
			return true;
		else
			return false;
	}

}
