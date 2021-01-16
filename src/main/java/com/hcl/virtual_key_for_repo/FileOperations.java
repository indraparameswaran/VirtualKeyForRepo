package com.hcl.virtual_key_for_repo;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import com.hcl.util.Constants;

public class FileOperations {

	

	public void initializeWithFiles() throws IOException {

		// File file = new File(Constants.fileRecordsPath);
		ArrayList<String> listOfInitialFiles = new ArrayList<>();

		listOfInitialFiles.add("Locks.txt");
		listOfInitialFiles.add("key.txt");
		listOfInitialFiles.add("lever.txt");
		listOfInitialFiles.add("Accounts.txt");

		// Creates the file if file is not present 

		for (String fileName : listOfInitialFiles) {
			try {

				boolean fileCreated = new File(Constants.fileRecordsPath + fileName).createNewFile();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
	
	
	public void initializeAddFiles() throws IOException {

		// File file = new File(Constants.fileRecordsPath);
		ArrayList<String> listOfInitialFiles = new ArrayList<>();

		listOfInitialFiles.add("employee.txt");
		listOfInitialFiles.add("Customers.txt");
		
		

		// Creates the file if file is not present 

		for (String fileName : listOfInitialFiles) {
			try {

				boolean fileCreated = new File(Constants.addFilesRecordsPath + fileName).createNewFile();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
	public static void retieveFiles(String filePath) {
		File[] listOfFiles = new File(filePath).listFiles();
		Set<String> sorted = new TreeSet<>();
		for(File file : listOfFiles) {
		sorted.add(file.getName());
		}
		System.out.println("Files in the directory(in ascending order with uppercase first, followed by lowercase):\n");
		System.out.println("------------------------------");
		sorted.forEach(System.out::println);
		System.out.println("------------------------------");
	}
	
	
	
	public static void addFiles(String fileName) throws FileAlreadyExistsException, IOException {
		try {

			Files.copy(Paths.get(Constants.addFilesRecordsPath + fileName), Paths.get(Constants.fileRecordsPath + fileName));
			//boolean fileCreated = new File(Constants.fileRecordsPath + fileName).createNewFile();

		} catch (FileAlreadyExistsException e) {
			System.out.println(fileName +" already exists.");
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void deleteFile(String fileName) throws NoSuchFileException, IOException {
		try {
			Files.deleteIfExists(Paths.get(Constants.fileRecordsPath + fileName));
		} catch (NoSuchFileException e) {
			System.out.println("No such file exists, Please verify the case of the entered file name.");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Deleted " + fileName +" successfully.");
	}
	
	public static void searchFile(String fileName) {
		File[] listOfFiles = new File(Constants.fileRecordsPath).listFiles();
		boolean foundFile = false;
		for(File file : listOfFiles) {
			if(fileName.equals(file.getName())) {
				foundFile = true;
			}
		}
			if(foundFile) {
				System.out.println("The file " + fileName + " exists in the directory\n");
			} else {
				System.out.println("The file " + fileName + " does not exists in the directory");
			}
		
			}
		
		
}
