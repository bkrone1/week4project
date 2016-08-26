package com.goingtothezoo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


public class DAO {
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/?user=root&autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "sesame";

	static Connection CONN = null;
	static Statement STMT = null;
	static PreparedStatement PREP_STMT = null;
	static ResultSet RES_SET = null;
	
	static Scanner sc = new Scanner(System.in);

	public static void connToDB() {

		try {
			System.out.println("Trying to connect to the Database...");
			CONN = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			System.out.println("Connected to the Database!");
		} catch (SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();

		}
	}
	
	public static void readFromDB() {

		connToDB();

		ArrayList<Animals> zooAnimals = new ArrayList<>();

		try {
			STMT = CONN.createStatement();
			RES_SET = STMT.executeQuery("SELECT * FROM students.animals_at_zoo;");

			while (RES_SET.next()) {

				Animals animalInDB = new Animals();

				animalInDB.setAnimalID(RES_SET.getString("animal_id"));
				animalInDB.setSpecies(RES_SET.getString("species"));
				animalInDB.setTypeOfCage(RES_SET.getString("type_of_cage"));
				animalInDB.setFood(RES_SET.getString("food"));
				animalInDB.setName(RES_SET.getString("name"));
				animalInDB.setWeight(RES_SET.getFloat("weight"));

				zooAnimals.add(animalInDB);
			}

			for (Animals animals : zooAnimals) {
				System.out.println(animals.toString());
				
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public static void writeToDB() {
		Animals animalToAdd = new Animals();

		animalToAdd = aboutTheAnimal();

		connToDB();

		try {
			PREP_STMT = CONN.prepareStatement(insertToDB);

			PREP_STMT.setString(1, animalToAdd.getSpecies());// this goes to...
			PREP_STMT.setString(2, animalToAdd.getTypeOfCage());
			PREP_STMT.setString(3, animalToAdd.getFood());
			PREP_STMT.setString(4, animalToAdd.getName());
			PREP_STMT.setFloat(5, animalToAdd.getWeight());

			PREP_STMT.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static String insertToDB = "INSERT INTO `students`.`animals_at_zoo`" + "(species, type_of_cage, food, name, weight)"
			+ " VALUES " + "(?, ?, ?, ?, ?)";// ...THIS!!!!!

	private static Animals aboutTheAnimal() {

		Animals animalToAdd = new Animals();

		System.out.println("What species is the animal?");
		animalToAdd.setSpecies(sc.nextLine());

		System.out.println("What is the type of cage used for the animal?");
		animalToAdd.setTypeOfCage(sc.nextLine());

		System.out.println("What does the animal eat?");
		animalToAdd.setFood(sc.nextLine());
		
		System.out.println("What's the animals name?");
		animalToAdd.setName(sc.nextLine());
		
		System.out.println("How much does the animal weight?");
		animalToAdd.setWeight(Float.parseFloat(sc.nextLine()));

		return animalToAdd;

	}
}

