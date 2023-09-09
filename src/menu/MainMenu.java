package menu;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import exception.IncorrectChoice;
import exception.IncorrectOption;

public class MainMenu {
	
	public static boolean checkInput(String userEntry)
	{
		boolean hasString = false;
		int index = 0;
		
		while (index < userEntry.length())
		{
			if (!(userEntry.charAt(index) >= '0' && userEntry.charAt(index) <= '9'))
			{
				hasString = true;
			}
			
			index++;
		}
		return hasString;
	}
	
	static File rootPath = new File("C:\\Project\\");

	public static void menuOptions() throws IOException
	{
		Scanner sc =new Scanner(System.in);
		
		String con;
		String userEntry;
		
		do {
			
			System.out.println("\nMain Menu\n");
			System.out.println("Please Select One of the Following Options:");
			System.out.println("");
			System.out.println("1: Display All Files");
			System.out.println("2: Operations Menu");
			System.out.println("3: Exit\n");
			
			userEntry = sc.nextLine();
			
			while (checkInput(userEntry))
			{
				System.out.println("\nInvalid!\n");
				System.out.println("Please Enter a Number and Not Letter(s)/Character(s)\n");
				userEntry = sc.nextLine();
			}
			int choice = Integer.parseInt(userEntry);
			
			switch (choice) {
			case 1:
				String listOfFiles[] = rootPath.list();
				Arrays.sort(listOfFiles);
				System.out.println("Files: ");
				for(String name:listOfFiles)
					{
						System.out.println(name);
					}
				break;
				
			case 2:
				SubMenu.SubMenuOptions();
				break;
				
			case 3:
				System.out.println("Thank You, Goodbye!!!");
				System.exit(0);
				break;
				
			default:
				 System.out.println(choice + " is an incorrect option, please try again.\n");
		    break;
		       
			}
				System.out.println("\nReturn to Main Menu?(yes/no)\n");
				con = sc.nextLine();
				try {
					if(!con.equals("yes") && !con.equals("no")) {
						throw new IncorrectChoice(" Please enter yes or no\n");
					}
				}
					catch (Exception e) {
						System.out.print(e);
						con = sc.nextLine();
					}
				}
				while (con.equalsIgnoreCase("yes" + ""));
				if (con.equals("no"))
				{
					System.out.println("Thank You, Goodbye!!!");
					System.exit(0);					
				}
				sc.close();
		}
}
