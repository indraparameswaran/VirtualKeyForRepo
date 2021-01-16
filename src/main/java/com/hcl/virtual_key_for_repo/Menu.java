package com.hcl.virtual_key_for_repo;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.NoSuchFileException;
import java.util.Scanner;

import com.hcl.util.Constants;

public class Menu {

	Scanner scanner = new Scanner(System.in);
	String userOptions;

	public void welcomeMenu() throws NoSuchFileException, IOException {

		System.out.println("Do you want to Continue or Exit ?\n");
		welcomeOptions();

	}

	public void welcomeOptions() throws NoSuchFileException, IOException {
		System.out.println("1.Continue\n");
		System.out.println("2.Exit\n");
		userOptions = scanner.nextLine();
		switch (userOptions) {
		case "1":
			mainMenu();
			break;

		case "2":
			closeApp();
			break;

		default:
			System.out.println("invalid option. Please retry\n");

		}
		welcomeMenu();

	}

	public void mainMenu() throws NoSuchFileException, IOException {
		System.out.println("Main menu\n");
		System.out.println("1.Retrieve files\n");
		System.out.println("2.File operations (add, delete, search)\n");
		System.out.println("3.Close app\n");
		mainOptions();

	}

	public void mainOptions() throws NoSuchFileException, IOException {
		System.out.println("Please choose 1, 2, or 3: ");
		userOptions = scanner.nextLine();
		switch (userOptions) {
		case "1":
			System.out.println("Retrieve files in ascending order");
			FileOperations.retieveFiles(Constants.fileRecordsPath);
			break;

		case "2":
			System.out.println("File operations");
			fileOperationsMenu();
			break;

		case "3":

			closeApp();
			break;

		default:
			System.out.println("invalid option. Please retry\n");

		}
		mainMenu();

	}

	public void fileOperationsMenu() throws NoSuchFileException, IOException {
		System.out.println("File operations menu\n");
		System.out.println("1.Add file\n");
		System.out.println("2.Delete file\n");
		System.out.println("3.Search file\n");
		System.out.println("4.Return to main menu\n");
		fileOperationsOptions();
	}

	public void fileOperationsOptions() throws NoSuchFileException, IOException {
		System.out.println("Please choose 1, 2, 3, or 4: ");
		userOptions = scanner.nextLine();
		
		switch (userOptions) {
		case "1":
			System.out.println("Add file");
			addOperation();
			
			break;

		case "2":
			System.out.println("Delete file");
			deleteOperation();
			break;
			
		case "3":

			System.out.println("search file");
			searchOperation();
			break;

		case "4":
		
			mainMenu();
			break;
		}

		 fileOperationsMenu();
	}

	public void addOperation() throws FileAlreadyExistsException, IOException {
		System.out.println("Available files to add are : ");
		FileOperations.retieveFiles(Constants.addFilesRecordsPath);
		System.out.println("Enter the file to be added from the list: \n");
		userOptions = scanner.nextLine();
		FileOperations.addFiles(userOptions);

	}
	
	public void deleteOperation() throws NoSuchFileException, IOException {
		System.out.println("Available files to delete are : ");
		FileOperations.retieveFiles(Constants.fileRecordsPath);
		System.out.println("Enter the file to be deleted from the list: \n");
		userOptions = scanner.nextLine();
		FileOperations.deleteFile(userOptions);
		
	}
	
	public void searchOperation() {
		System.out.println("Enter a file name to be searched : \n");
		userOptions = scanner.nextLine();
		FileOperations.searchFile(userOptions);
	}
	


	public void closeApp() {
		System.out.println("Thanks for using LockedMe.com. Closing application");
		System.exit(0);
	}

}
