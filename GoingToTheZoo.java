package com.goingtothezoo;

import java.util.Scanner;

public class GoingToTheZoo {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String userMenuInput = null;
		boolean menuCorrect = false;

		System.out.println("Let's talk about some animals that we saw at the zoo!");
		
		
		
		do {
			System.out.println("Pres 1 to read the DB" 
					+ "\nPress 2 to add to the database");
			userMenuInput = sc.nextLine();
			switch (userMenuInput) {
			case "1":
				DAO.readFromDB();
				break;
			case "2":
				DAO.writeToDB();
				break;

			default:
				System.out.println("You've entered an invalid option.");
				menuCorrect = true;
				break;

			}
		} while (menuCorrect);

	}

}

