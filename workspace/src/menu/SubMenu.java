package menu;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import exception.IncorrectChoice;


public class SubMenu {
	
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
	
	public static void SubMenuOptions() throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		String con;
		String userEntry;
		
		do {
			System.out.println("\nOperations Menu\n");
			System.out.println("Please Select One of the Following Options:\n");
			System.out.println("1: Add File");
			System.out.println("2: Delete File");
			System.out.println("3: Search File");
			System.out.println("4: Return to the Main Menu");
			
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
				File f = new File("C:\\Project\\");
				
				System.out.println("\nPath: " + f.getPath() + "\n");
				
				System.out.println("Files: ");
				String allFiles[] = f.list();
				for (String name : allFiles)
				{
					System.out.println(name);
				}
				
				File ff = new File("C:\\Project\\");
				
				System.out.println("\nPlease enter File Name: ");
				
				String fname = sc.nextLine();
				
				FileOutputStream fi = new FileOutputStream("C:\\Project\\" + fname);
				
				ff.createNewFile();
				
			    fi.write('S');
				fi.close();

				System.out.println("\n" + fname + " is created.");
				break;

			case 2:
				File d = new File("C:\\Project\\");
				
				String allF[] = d.list();{
				System.out.println("Files: ");
				for (String name : allF)
				{
					System.out.println(name);
				}
				System.out.println("\nPlease Enter Name of File to Delete: \n");
				String fn = sc.nextLine();
				
				String newPath = "C:\\Project\\" + fn;

				f = new File(newPath);
				
				if(f.exists()) {
						f.delete();
						System.out.println("File Deleted Successfully.\n");
				}else {
					System.out.println("File Not Found!\n");
				}
				}
				break;
				
			case 3:
				File e = new File("C:\\Project\\");
				
				System.out.println("Please Enter Name of File to Search: \n");
				String fna = sc.nextLine();
				
				String dPath = "C:\\Project\\" + fna;
						e = new File(dPath);
						if(e.exists()) {
								System.out.println("\nFile Present!\n");
						}
						else {
								System.out.println("\nFile Not Present!\n");
						}
			break;
			case 4:
				MainMenu.menuOptions();
				break;
			default:
				 System.out.println(choice + " is an incorrect option, please try again.\n");
		    break;
			}
			System.out.println("Return to Operations Menu? (yes/no)");
			con = sc.nextLine();
			try {
				if(!con.equalsIgnoreCase("yes") && !con.equalsIgnoreCase("no")) {
					throw new IncorrectChoice(" Please enter yes or no\n");
				}
			}
				catch (Exception e) {
					System.out.print(e);
					con = sc.nextLine();
				}
			}
			while (con.equalsIgnoreCase("yes" + ""));
			if (con.equalsIgnoreCase("no"))
			{
				System.out.println("Thank You, Goodbye!!!");
				System.exit(0);
			}
			sc.close();
	}
}