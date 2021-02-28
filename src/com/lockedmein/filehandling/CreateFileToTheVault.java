package com.lockedmein.filehandling;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import com.lockedmein.filehandling.interfaces.ShowOptionWizardInterface;

public class CreateFileToTheVault implements ShowOptionWizardInterface{
	
	private static Scanner sc;


	public CreateFileToTheVault() {
		// TODO Auto-generated constructor stub
	}
	
	public void showOptionWizard() {
		
		System.out.print("Please enter 1 if you want to create a blank file in the vault: ");
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
				
				System.out.print("\nPlease insert the file name which you want to create for the vault: ");
				String fileName = sc.next();
				
				if(!fileName.contains(".txt"))
					System.out.println("Invalid signature found for File creation. "
							+ "Please create file with correct extension");
				else
					this.createFile(fileName);
				break;
				
			default:
				
				System.out.println("\nInvalid selection done. Redirecting to the file creation wizard...");
				this.showOptionWizard();
				break;
				
		}
					
	}
	
	private void createFile(String fileName) {
		
		Path first = Paths.get("");
		String basePath = first.toAbsolutePath().toString();
		
		File file = new File(basePath + "\\Files\\" + fileName);
		try {
			if(file.createNewFile()) {
				
				System.out.println("File " + fileName + " has been created successfully");
				for(String files : new ListExistingFiles().showAllFiles())
					System.out.println(files);
			}	
			else
				System.out.println("File " + fileName + " is already present in the given Directory");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
