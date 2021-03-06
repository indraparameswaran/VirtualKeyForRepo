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

		ArrayList<String> listOfInitialFiles = new ArrayList<>();

		listOfInitialFiles.add(Constants.fileRecordsPath + "Locks.txt");
		listOfInitialFiles.add(Constants.fileRecordsPath + "key.txt");
		listOfInitialFiles.add(Constants.fileRecordsPath + "lever.txt");
		listOfInitialFiles.add(Constants.fileRecordsPath + "Accounts.txt");

		// Creates the file if file is not present

		for (String fileName : listOfInitialFiles) {
			try {
				boolean dirCreated = new File(fileName).getParentFile().mkdir();

				boolean fileCreated = new File(fileName).createNewFile();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	public void initializeAddFiles() throws IOException {

		ArrayList<String> listOfInitialFiles = new ArrayList<>();

		listOfInitialFiles.add(Constants.addFilesRecordsPath + "employee.txt");
		listOfInitialFiles.add(Constants.addFilesRecordsPath + "Customers.txt");
		listOfInitialFiles.add(Constants.addFilesRecordsPath + "Distribution.txt");
		listOfInitialFiles.add(Constants.addFilesRecordsPath + "benefits.txt");

		// Creates the file if file is not present

		for (String fileName : listOfInitialFiles) {
			try {
				boolean dirCreated = new File(fileName).getParentFile().mkdir();

				boolean fileCreated = new File(fileName).createNewFile();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	public static void retieveFiles(String Path) {
		File[] listOfFiles = new File(Path).listFiles();
		Set<String> sorted = new TreeSet<>();
		for (File file : listOfFiles) {
			sorted.add(file.getName());
		}
		System.out.println("Files in the directory(in ascending order with uppercase first, followed by lowercase):\n");
		System.out.println("------------------------------");
		sorted.forEach(System.out::println);
		System.out.println("------------------------------");
	}

	public static void addFiles(String fileName) throws FileAlreadyExistsException, IOException {
		try {

			File[] listOfFiles = new File(Constants.addFilesRecordsPath).listFiles();
			boolean foundFile = false;
			String foundFileNm = "xyz";
			for (File file : listOfFiles) {
				if (fileName.equalsIgnoreCase(file.getName())) {
					foundFile = true;
					foundFileNm = file.getName();
					break;
				}
			}
			if (foundFile) {
				boolean fileCreated = new File(Constants.fileRecordsPath + foundFileNm).createNewFile();
				if (fileCreated) {
					System.out.println("Added " + foundFileNm + " successfully.");
				} else {
					System.out.println("File " + foundFileNm + " already exists.");
				}
			} else {
				System.out.println("No such file exists in the available list of files.");
			}

		} catch (FileAlreadyExistsException e) {
			System.out.println(fileName + " already exists.");
		} catch (NoSuchFileException e) {
			System.out.println("No such file exists.");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void deleteFile(String fileName) throws NoSuchFileException, IOException {
		try {
			
			File[] listOfFiles = new File(Constants.fileRecordsPath).listFiles();
			boolean foundFile = false;
			ArrayList<String> foundFileNames = new ArrayList<>();
			for (File file : listOfFiles) {
				if (fileName.equals(file.getName())) {
					foundFile = true;
				}
			}
			
			if (foundFile) {
			for (File file : listOfFiles) {
				if (fileName.equalsIgnoreCase(file.getName())) {
					foundFileNames.add(file.getName());
				}
			}
			Files.deleteIfExists(Paths.get(Constants.fileRecordsPath + fileName));
			System.out.println("Deleted " + fileName + " successfully.");
			
			for (String file : foundFileNames) {
				if (!file.equals(fileName)) {
					boolean fileCreated = new File(Constants.fileRecordsPath + file).createNewFile();
				}
			}
			} else {
				System.out.println("No such file exists, Please verify the case of the entered file name.");
			}
			
			
		} catch (NoSuchFileException e) {
			System.out.println("No such file exists, Please verify the case of the entered file name.");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void searchFile(String fileName) {
		File[] listOfFiles = new File(Constants.fileRecordsPath).listFiles();
		boolean foundFile = false;
		for (File file : listOfFiles) {
			if (fileName.equals(file.getName())) {
				foundFile = true;
			}
		}
		if (foundFile) {
			System.out.println("The file " + fileName + " exists in the directory\n");
		} else {
			System.out.println("The file " + fileName
					+ " does not exists in the directory. Please verify the case of the entered file name. ");
		}

	}

}
