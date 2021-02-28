package com.lockedmein.filehandling;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ListExistingFiles {
	
	private static Scanner sc;
	private static List<String> fileList;
	private static List<String> filesToReturn;

	public ListExistingFiles() {
		// TODO Auto-generated constructor stub
	}
	
	public List<String> showOptionWizard(){
		
		System.out.print("Please enter 1 if you want to list files without any specific extension: ");
		System.out.print("\nPlease enter 2 if you want to list files with the specific extension: ");
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
				filesToReturn = this.showListOfAllFiles();
				break;
			
			case 2:
				System.out.print("\nPlease enter the file extension type which you want to show:");
				String extension = sc.next();
				if(extension.startsWith("."))
					filesToReturn = this.showListOfAllFiles(extension);
				else
					filesToReturn = this.showListOfAllFiles("." + extension);
				break;
			
			default:
				System.out.println("\nInvalid selection done. Redirecting to the file selection wizard...");
				this.showOptionWizard();
				break;
		}
		return filesToReturn;
	}
	
	public List<String> showAllFiles(){
		
		return this.showListOfAllFiles();
	}
	
	/*	This function is responsible to get the root directory of the
		folder and listing the files present in the respective subdirectory
		named as Files*/
	private List<String> showListOfAllFiles(){
		
		Path first = Paths.get("");
		String basePath = first.toAbsolutePath().toString();
		
		File file = new File(basePath + "\\Files");
		fileList = Arrays.asList(file.list());
		
		return fileList;
	}
	
	private List<String> showListOfAllFiles(String extension){
		
		Path first = Paths.get("");
		String basePath = first.toAbsolutePath().toString();
		
		File file = new File(basePath + "\\Files");
		
		FilenameFilter filter = new FilenameFilter() {
			
			@Override
			public boolean accept(File file, String name) {
				// TODO Auto-generated method stub
				return name.endsWith(extension);
			}
		};
		fileList = Arrays.asList(file.list(filter));
		
		return fileList;
	}

}
