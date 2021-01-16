package com.hcl.virtual_key_for_repo;

import java.io.IOException;
import java.util.Scanner;

public class App {
	public static void main(String[] args) throws IOException {
		
		
		// initializes the app with a list of files
		FileOperations appInitialize = new FileOperations();
		appInitialize.initializeWithFiles();
		appInitialize.initializeAddFiles();
		
		//creating menu object
		Menu menu = new Menu();
		String userOptions;
		
		

		System.out.println("\n*************************************************\n");
		System.out.println("\tWelcome to LockedMe.com \n");
		System.out.println("\tDeveloper Name - Indra Parameswaran \n");
		System.out.println("*************************************************");
		
		
		menu.welcomeMenu();
		
		                               
//		private  void collectMainMenuOption() {
//			System.out.println("Please choose 1, 2, or 3: ");
//			String option = scanner.nextLine();
//			switch (options) {
//			case "1":
//				showFilesInAscendingOrder();
//				break;
//				
//			case "2":
//				fileOperations();
//				break;
//				
//			case "3":
//				System.out.println("Thanks for using LockedMe.com. Closing application");
//			}
//			showMainMenu();
//			}
//			
//		}
//		switch (options) {
//			case 1:
//				System.out.println("Files available are listed below: \n");
//				System.out.println(listOfInitialFiles+"\n");
//				break;
//		}
//		
//		userOptions = menu.mainMenu();
//		if(userOptions.equalsIgnoreCase("1")) {
//			System.out.println("Retrieve files");
//		}
//		if(userOptions.equalsIgnoreCase("2")) {
//			System.out.println("File operation");
//		}
//		if(userOptions.equalsIgnoreCase("3")) {
//			System.out.println("Close app");
//		}


	}
	
	
	
}
