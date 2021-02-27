package com.lockedmein.filehandling;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateFileToTheVault {

	public CreateFileToTheVault() {
		// TODO Auto-generated constructor stub
	}
	
	public void createFile(String fileName) {
		
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
