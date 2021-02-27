package com.lockedmein.filehandling;

import java.util.List;

public class SearchForFiles {

	public SearchForFiles() {
		// TODO Auto-generated constructor stub
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
