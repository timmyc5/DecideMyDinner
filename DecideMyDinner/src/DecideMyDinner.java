import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.io.*;

public class DecideMyDinner {

	public static void main(String [] args) {
		Scanner scnr = new Scanner(System.in);
		ArrayList<String> restaurantList = new ArrayList<String>();
		boolean loop = true;

		System.out.println("Ahhhh I see no one can decide where to eat again. I will decide, since "
				+ "this is my only purpose on Earth.");

		while(loop) {
			System.out.println("Enter (D) for Dine-in or (T) for Take-out: ");

			String choice = scnr.nextLine();

			if(choice.equalsIgnoreCase("T")){
				populateTakeOutList(restaurantList);
			}
			else{
				populateDineInList(restaurantList);
			}

			System.out.println("Restaurant generated: " + getPlaceToEat(restaurantList));
			
			System.out.println("Would you like a different suggestion? (Y)es or (N)o");
			String another = scnr.nextLine();
			
			if(another.equalsIgnoreCase("yes") || another.equalsIgnoreCase("y")){
				loop = true;
			}
			else {
				loop = false;
			}
		}
	}

	//method to populate a list with dine-in food options
	public static ArrayList<String> populateDineInList(ArrayList<String> dineIn) {

		File file = new File("/Users/timmyc5/Desktop/JavaPrac/DecideMyDinner/DecideMyDinner/src/DineIn.txt");
		String restaurant = null;

		try {
			Scanner scnr = new Scanner(file);
			while(scnr.hasNextLine()) {
				restaurant = scnr.nextLine();
				dineIn.add(restaurant);
			}

			scnr.close();
		}catch (FileNotFoundException e) {}

		return dineIn;
	}

	//method to populate a list with take-out food options
	public static ArrayList<String> populateTakeOutList(ArrayList<String> takeOut) {

		File file = new File("/Users/timmyc5/Desktop/JavaPrac/DecideMyDinner/DecideMyDinner/src/TakeOut.txt");
		String restaurant = null;

		try {
			Scanner scnr = new Scanner(file);
			while(scnr.hasNextLine()) {
				restaurant = scnr.nextLine();
				takeOut.add(restaurant);
			}

			scnr.close();
		}catch (FileNotFoundException e) {}

		return takeOut;
	}

	public static String getPlaceToEat(ArrayList<String> list) {
		int num = genRandomNum(0, list.size()-1);

		return list.get(num);
	}

	public static int genRandomNum(int lowerBound, int upperBound) {
		int rand = ThreadLocalRandom.current().nextInt(lowerBound, upperBound + 1);

		return rand;
	}
}
