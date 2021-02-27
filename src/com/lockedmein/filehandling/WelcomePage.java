package com.lockedmein.filehandling;

import java.util.List;
import java.util.Scanner;

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
				+ "\n\tSelect 3 for Deleting file with the matched name from the File List\n"
				//+ "\n\tSelect 4 for Reading file with the matched name from the File List"
				);
		
		sc = new Scanner(System.in);
		System.out.print("Please select which operation you would like to perform: ");
		String choiceTemp = sc.next();
		int getChoice = new RegExUtil().returnChoiceValue(choiceTemp);
		choiceSelection(getChoice);
		
	}
	
	private static void choiceSelection(int choice) {
		
		sc = new Scanner(System.in);
		
		switch(choice) {
		
			case 1:
				System.out.println("\nWelcome to the File Listing wizard!\n");
				new WelcomePage().listFiles();
				boolean check = setChoice();
				if(check)
					main(null);
				break;
				
			case 2:
				System.out.print("\nPlease insert the file name which you want to create for the vault: ");
				String fileName = sc.next();
				
				if(!fileName.contains(".txt"))
					System.out.println("Invalid signature found for File creation. "
							+ "Please create file with correct extension");
				else
					new CreateFileToTheVault().createFile(fileName);

				new WelcomePage().listFiles();
				
				check = setChoice();
				if(check)
					main(null);
				break;
				
			case 3:
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
	
	private void listFiles(){
		
		List<String> fileList = new ListExistingFiles().getListType();
		//System.out.println("Files currently present in the directory are " + fileList.toString());
		
		for(String file : fileList)
			System.out.println(file);
	}

}
