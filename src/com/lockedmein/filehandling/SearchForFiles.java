package com.lockedmein.filehandling;

import java.util.List;
import java.util.Scanner;

public class SearchForFiles {
	
	private static Scanner sc;

	public SearchForFiles() {
		// TODO Auto-generated constructor stub
	}
	
	public void showOptionWizard() {
		
		System.out.print("Please enter 1 if you want to search for the specific file in the vault: ");
		System.out.print("\nPlease enter 0 if you want to go back to the main menu: ");
		
		System.out.print("\nPlease enter your choice: ");
		sc = new Scanner(System.in);
		String check = sc.next();
		int getChoice = new RegExUtil().returnChoiceValue(check);
		switch(getChoice) {
		
			case 0:
				WelcomePage.main(null);
				break;
			
			case 1:
				
				System.out.print("Please enter the File you want to search for its' presence: ");
				String fileToCheck = sc.next();
				boolean checkPresence = new SearchForFiles().searchFile(fileToCheck);
				if(checkPresence)
					System.out.println("File " + fileToCheck + " is present in the Files Directory");
				else
					System.out.println("File " + fileToCheck + " is not present in the Files Directory");
				
				break;
				
			default:
				
				System.out.println("\nInvalid selection done. Redirecting to the file searching wizard...");
				this.showOptionWizard();
				break;
				
		}
					
	}
	
	public boolean searchFile(String fileName) {
		
		List<String> allFiles = new ListExistingFiles().showAllFiles();
		
		for(String file : allFiles) {
			
			if(file.length() == fileName.length()) {
				if(file.equals(fileName)) {
					
					return true;
				}
			}
		}
		
		return false;
	}

}
