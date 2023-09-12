package com.viegasb.taskmanager.utils;

import java.time.format.DateTimeParseException;
import java.util.Scanner;

import com.viegasb.taskmanager.config.DateConfig;
import com.viegasb.taskmanager.config.MessageConfig;
import com.viegasb.taskmanager.config.exceptions.InvalidDateInputException;
import com.viegasb.taskmanager.models.Account;
import com.viegasb.taskmanager.models.Task;
import com.viegasb.taskmanager.models.UserProfile;
import com.viegasb.taskmanager.models.exceptions.InvalidInputException;

public class ConsoleUI {
	public static int menuMain(Scanner scan) {
		System.out.println("-=-=-=-=-= Menu -=-=-=-=-=");
		System.out.println("- 1 > Create");
		System.out.println("- 2 > Read");
		System.out.println("- 3 > Update");
		System.out.println("- 4 > Delete");
		System.out.println("- 0 > Exit");
		System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=\n@ ");

		return Integer.parseInt(scan.nextLine());
	}

	public static Account createAccount(Scanner scan) {
		while (true) {
			try {
				System.out.println("-=-=-=-=-=-=- Account -=-=-=-=-=-=");

				System.out.print("Email: ");
				String email = scan.nextLine();

				System.out.print("Password: ");
				String password = scan.nextLine();

				if (!ValidateUI.isEmailAndPasswordCheck(email, password))
					continue;

				System.out.println("-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=\n");
				return new Account(email, password);
			}
			catch (InvalidInputException ex) { MessageConfig.errorMessage(ex); }
		}
	}

	public static UserProfile createUserProfile(Scanner scan) {
		while(true) {
			try {
				System.out.println("-=-=-=-=-=- User-Profile -=-=-=-=-=");

				System.out.print("First-Name: ");
				String firstName = scan.nextLine();

				System.out.print("Last-Name: ");
				String lastName = scan.nextLine();

				System.out.print("Birth-Of-Day: ");
				String birthOfDay = scan.nextLine();

				if(!ValidateUI.hasDateCheck(DateConfig.dateFormatter(birthOfDay)))
					continue;

				System.out.println("-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=\n");
				return new UserProfile(firstName, lastName, birthOfDay);
			}
			catch(InvalidDateInputException ex) { MessageConfig.errorMessage(ex); }
			catch(DateTimeParseException ex) { MessageConfig.errorMessage(ex); }
		}
	}

	public static Task createTask(Scanner scan) {
		System.out.println("-=-=-=-=-= Task -=-=-=-=-=");

		System.out.print("Description: ");
		String description = scan.nextLine();

		System.out.print("Category: ");
		String category = scan.nextLine();

		System.out.println("-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=\n");
		return new Task(description, category);
	}
}