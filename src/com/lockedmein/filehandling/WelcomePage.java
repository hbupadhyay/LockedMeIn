package com.lockedmein.filehandling;

import java.util.List;
import java.util.Scanner;

public class WelcomePage {
	
	private static Scanner sc;

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
				+ "\n\tSelect 3 for Searching file with the matched name from the File List"
				+ "\n\tSelect 4 for Deleting file with the matched name from the File List\n"
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
				List<String> fileList = new ListExistingFiles().getListType();
				//System.out.println("Files currently present in the directory are " + fileList.toString());
				if(fileList.size() == 0)
					System.out.println("Currently No Files are present in the directory.");
				else {
					
					for(String file : fileList)
						System.out.println(file);
				}
				
				boolean check = setChoice();
				if(check)
					main(null);
				else {
					System.out.println("Thanks for using the application. Hope to see you soon!");
					System.exit(0);
				}
				break;
				
			case 2:
				System.out.print("\nPlease insert the file name which you want to create for the vault: ");
				String fileName = sc.next();
				
				if(!fileName.contains(".txt"))
					System.out.println("Invalid signature found for File creation. "
							+ "Please create file with correct extension");
				else
					new CreateFileToTheVault().createFile(fileName);

				check = setChoice();
				if(check)
					main(null);
				else {
					System.out.println("Thanks for using the application. Hope to see you soon!");
					System.exit(0);
				}
				
			case 3:
				System.out.print("Please enter the File you want to search for its' presence: ");
				String fileToCheck = sc.next();
				boolean checkPresence = new SearchForFiles().searchFile(fileToCheck);
				if(checkPresence)
					System.out.println("File " + fileToCheck + " is present in the Files Directory");
				else
					System.out.println("File " + fileToCheck + " is not present in the Files Directory");
				
				check = setChoice();
				if(check)
					main(null);
				else {
					System.out.println("Thanks for using the application. Hope to see you soon!");
					System.exit(0);
				}
			
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
