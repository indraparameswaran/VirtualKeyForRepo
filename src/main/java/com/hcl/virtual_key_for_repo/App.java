package com.hcl.virtual_key_for_repo;

import java.io.IOException;
import java.util.Scanner;

public class App {
	public static void main(String[] args) throws IOException {

		// initializes the app with a list of files
		FileOperations appInitialize = new FileOperations();
		appInitialize.initializeWithFiles();
		appInitialize.initializeAddFiles();

		// creating menu object
		Menu menu = new Menu();

		System.out.println("\n*************************************************\n");
		System.out.println("\tWelcome to LockedMe.com \n");
		System.out.println("\tDeveloper Name - Indra Parameswaran \n");
		System.out.println("*************************************************\n");

		menu.welcomeMenu();

	}

}
