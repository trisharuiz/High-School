import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static int cupOpt;
	public static int cupOpt2;
	public static int opt = 0;
	public static int sellOpt = 0;
	public static int action;
	public static int fill;
	static ArrayList<Cups> list = new ArrayList<Cups>();

	public static void main(String[] args) {

		while (opt == 0) {
			System.out.println("Welcome to Cups'R'Us");
			System.out.println("Menu Options:");
			System.out.println("1.)Buy");
			System.out.println("2.)Sell");
			System.out.println("3.)Maintenance");
			System.out.println("4.)Inventory Report");
			System.out.println("5.)Logout");
			Scanner scan = new Scanner(System.in);
			opt = scan.nextInt();

			if (opt == 1) {
				System.out.println("What Type of cup is it?");
				System.out.println("1.)Mug");
				System.out.println("2.)Glass");
				System.out.println("3.)Tumbler");
				cupOpt = scan.nextInt();
				askQuestions();
			}
			if (opt == 2) {
				if (list.size() == 0) {
					System.out.println("You don't have any cups yet...");
					opt = 0;
				} else {
					printNames();
					System.out.println("WHICH CUP WOULD YOU LIKE TO SELL? (ENTER number)");
					sellOpt = scan.nextInt();
					list.remove(sellOpt - 1);
					System.out.println("You sold the cup.");
					opt = 0;
				}

			}
			if (opt == 3) {
				System.out.println("Maintenance Menu");
				System.out.println("1.)Fill Cup");
				System.out.println("2.)Empty Cup");
				System.out.println("3.)Drop Cup");
				System.out.println("4.)Break Cup");
				action = scan.nextInt();
				askWhichCup();

			}
			if (opt == 4) {
				printList();
				opt = 0;
			}
			if (opt == 5) {
				System.out.println("Thank you for using this program");
				System.exit(0);
			}
		}

	}

	public static void askQuestions() {
		Scanner scan = new Scanner(System.in);

		String name = new String("");
		System.out.println("Name?");
		name = scan.nextLine();

		String color = new String("");
		System.out.println("Color?");
		color = scan.nextLine();
		
		int serial;
		System.out.println("Serial? (1 & up)");
		serial = scan.nextInt();

		while (serial - 1 > list.size()) {
			System.out.println("That serial number is not available. Please input a number that is less than or equal to "
							+ (list.size() + 1));
			System.out.println("Serial? (1 & up)");
			serial = scan.nextInt();
		}

		double maxFluid;
		System.out.println("Max Fluid?");
		maxFluid = scan.nextDouble();

		boolean handle;
		if (cupOpt == 3) {
			handle = false;
		} else {

			System.out.println("Handle? (insert True or False)");
			handle = scan.nextBoolean();
		}

		createCup(name, serial, maxFluid, color, handle);
		System.out.println("Thank You");
		opt = 0;

	}

	public static void createCup(String name, int serial, double maxFluid, String color, boolean handle) {
		if (cupOpt == 1)
			list.add(serial - 1, new Mug(name, serial, color, handle, maxFluid, 0));
		if (cupOpt == 2)
			list.add(serial - 1, new Glass(name, serial, color, handle, maxFluid, 0));
		if (cupOpt == 3)
			list.add(serial - 1, new Tumbler(name, serial, color, handle, maxFluid, 0));
	}

	public static void printList() {
		if (list.size() == 0) {
			System.out.println("You don't have any cups yet");
		} else {
			System.out.println("Name\tSerial\tColor\tFluid\tHandle\tBroken?");
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).toString());
			}
		}
	}

	public static void printNames() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i + 1) + ".)" + list.get(i).toName());
		}

	}

	public static void main() {
		if (action == 1)
			fluid();
		if (action == 2)
			empty();
		if (action == 3) {
			list.get(cupOpt2 - 1).dropCup();
			System.out.println("You have dropped the cup.");
			if(list.get(cupOpt2-1).getIsBroken() == false) {
				System.out.println("The cup did not break");
			}else {
				System.out.println("The cup broke");
			}
		}
		if (action == 4) {
			list.get(cupOpt2 - 1).breakCup();
			if(list.get(cupOpt2-1).getIsBroken() == false) {
				System.out.println("The cup did not break");
			}else {
				System.out.println("The cup broke");
			}
		}
		opt = 0;

	}

	public static void askWhichCup() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Which Cup?");
		printNames();
		cupOpt2 = scan.nextInt();
		main();

	}

	public static void fluid() {
		Scanner scan = new Scanner(System.in);
		double fillFluid;
		System.out.println("How much would you like to fill? (Press -1 for full cup)");
		fill = scan.nextInt();
		if (fill == -1) {
			list.get(cupOpt2 - 1).fillCup();
		} else if (fill > list.get(cupOpt2 - 1).getMax()) {
			list.get(cupOpt2 - 1).fillCup();
			System.out.println("Your cup overflowed but");
		} else {
			list.get(cupOpt2 - 1).fillCup(fill);
		}
		System.out.println("You have filled the cup");
		opt = 0;
	}

	public static void empty() {
		Scanner scan = new Scanner(System.in);
		double Fluid;
		System.out.println("How much would you like to empty? (Press -1 for entire cup)");
		fill = scan.nextInt();
		if (fill == -1) {
			list.get(cupOpt2 - 1).emptyCup();
		} else if (fill > list.get(cupOpt2 - 1).getMax()) {
			list.get(cupOpt2 - 1).emptyCup();
		} else {
			list.get(cupOpt2 - 1).emptyCup(fill);
		}
		System.out.println("You have emptied the cup");
		opt = 0;

	}

}
