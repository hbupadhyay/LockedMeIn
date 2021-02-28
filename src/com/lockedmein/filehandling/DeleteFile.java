package com.lockedmein.filehandling;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import com.lockedmein.filehandling.interfaces.ShowOptionWizardInterface;

public class DeleteFile implements ShowOptionWizardInterface{
	
	private static Scanner sc;

	public DeleteFile() {
		// TODO Auto-generated constructor stub
	}
	
	public void showOptionWizard() {
		
		System.out.print("Please enter 1 if you want to delete specific file from the vault: ");
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
				
				System.out.print("\nPlease insert the file name which you want to delete from the vault: ");
				String fileToDelete = sc.next();
				
				if(!fileToDelete.contains(".txt"))
					System.out.println("Invalid signature found for File deletion. "
							+ "Please mention file with correct extension");
				else
					this.deleteFileFromTheVault(fileToDelete);
				
				break;
				
			default:
				
				System.out.println("\nInvalid selection done. Redirecting to the file searching wizard...");
				this.showOptionWizard();
				break;
				
		}
					
	}
	
	private void deleteFileFromTheVault(String fileName) {
		
		boolean check = new SearchForFiles().searchFile(fileName);
		if(check) {
			Path first = Paths.get("");
			String basePath = first.toAbsolutePath().toString();
			
			File file = new File(basePath + "\\Files\\" + fileName);
			try {
				if(file.delete()) {
					
					System.out.println("File " + fileName + " has been deleted successfully");
					for(String files : new ListExistingFiles().showAllFiles())
						System.out.println(files);
				}
				else {
					
					System.out.println("Failed to Delete the file with given name. Please close all the opened files and try again");
				}
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		else {
			System.out.println("File " + fileName + " is not present in your valut.");
		}
	}

}
