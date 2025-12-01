import java.util.Scanner;

public class Hotel {
	public static HotelData hotel_ob = new HotelData();
	static Scanner sc = new Scanner(System.in);

	static void CustDetails(int i, int rn) {
		String name, contact, gender;
		String name2 = null, contact2 = null;
		String gender2 = "";
		System.out.print("\nEnter customer name: ");
		name = sc.next();
		System.out.print("Enter contact number: ");
		contact = sc.next();
		System.out.print("Enter gender: ");
		gender = sc.next();
		if (i < 3) {
			System.out.print("Enter second customer name: ");
			name2 = sc.next();
			System.out.print("Enter contact number: ");
			contact2 = sc.next();
			System.out.print("Enter gender: ");
			gender2 = sc.next();
		}

		switch (i) {
		case 1:
			hotel_ob.luxuryDoubleRoom[rn] = new DoubleRoom(name, contact, gender, name2, contact2, gender2);
			break;
		case 2:
			hotel_ob.deluxeDoubleRoom[rn] = new DoubleRoom(name, contact, gender, name2, contact2, gender2);
			break;
		case 3:
			hotel_ob.luxurySingleRoom[rn] = new SingleRoom(name, contact, gender);
			break;
		case 4:
			hotel_ob.deluxeSingleRoom[rn] = new SingleRoom(name, contact, gender);
			break;
		default:
			System.out.println("Wrong option");
			break;
		}
	}

	static void bookroom(int i) {
		int j;
		int rn;
		System.out.println("\nChoose room number from : ");
		switch (i) {
		case 1:
			for (j = 0; j < hotel_ob.luxuryDoubleRoom.length; j++) {
				if (hotel_ob.luxuryDoubleRoom[j] == null) {
					System.out.print(j + 1 + ",");
				}
			}
			System.out.print("\nEnter room number: ");
			try {
				rn = sc.nextInt();
				rn--;
				if (hotel_ob.luxuryDoubleRoom[rn] != null)
					throw new NotAvailable();
				CustDetails(i, rn);
			} catch (Exception e) {
				System.out.println("Invalid Option");
				return;
			}
			break;
		case 2:
			for (j = 0; j < hotel_ob.deluxeDoubleRoom.length; j++) {
				if (hotel_ob.deluxeDoubleRoom[j] == null) {
					System.out.print(j + 11 + ",");
				}
			}
			System.out.print("\nEnter room number: ");
			try {
				rn = sc.nextInt();
				rn = rn - 11;
				if (hotel_ob.deluxeDoubleRoom[rn] != null)
					throw new NotAvailable();
				CustDetails(i, rn);
			} catch (Exception e) {
				System.out.println("Invalid Option");
				return;
			}
			break;
		case 3:
			for (j = 0; j < hotel_ob.luxurySingleRoom.length; j++) {
				if (hotel_ob.luxurySingleRoom[j] == null) {
					System.out.print(j + 31 + ",");
				}
			}
			System.out.print("\nEnter room number: ");
			try {
				rn = sc.nextInt();
				rn = rn - 31;
				if (hotel_ob.luxurySingleRoom[rn] != null)
					throw new NotAvailable();
				CustDetails(i, rn);
			} catch (Exception e) {
				System.out.println("Invalid Option");
				return;
			}
			break;
		case 4:
			for (j = 0; j < hotel_ob.deluxeSingleRoom.length; j++) {
				if (hotel_ob.deluxeSingleRoom[j] == null) {
					System.out.print(j + 41 + ",");
				}
			}
			System.out.print("\nEnter room number: ");
			try {
				rn = sc.nextInt();
				rn = rn - 41;
				if (hotel_ob.deluxeSingleRoom[rn] != null)
					throw new NotAvailable();
				CustDetails(i, rn);
			} catch (Exception e) {
				System.out.println("Invalid Option");
				return;
			}
			break;
		default:
			System.out.println("Enter valid option");
			break;
		}
		System.out.println("Room Booked");
	}

	static void features(int i) {
		switch (i) {
		case 1:
			System.out.println("Number of double beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day:4000 ");
			break;
		case 2:
			System.out.println("Number of double beds : 1\nAC : No\nFree breakfast : Yes\nCharge per day:3000  ");
			break;
		case 3:
			System.out.println("Number of single beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day:2200  ");
			break;
		case 4:
			System.out.println("Number of single beds : 1\nAC : No\nFree breakfast : Yes\nCharge per day:1200 ");
			break;
		default:
			System.out.println("Enter valid option");
			break;
		}
	}

	static void availability(int i) {
		int j, count = 0;
		switch (i) {
		case 1:
			for (j = 0; j < 10; j++) {
				if (hotel_ob.luxuryDoubleRoom[j] == null)
					count++;
			}
			break;
		case 2:
			for (j = 0; j < hotel_ob.deluxeDoubleRoom.length; j++) {
				if (hotel_ob.deluxeDoubleRoom[j] == null)
					count++;
			}
			break;
		case 3:
			for (j = 0; j < hotel_ob.luxurySingleRoom.length; j++) {
				if (hotel_ob.luxurySingleRoom[j] == null)
					count++;
			}
			break;
		case 4:
			for (j = 0; j < hotel_ob.deluxeSingleRoom.length; j++) {
				if (hotel_ob.deluxeSingleRoom[j] == null)
					count++;
			}
			break;
		default:
			System.out.println("Enter valid option");
			break;
		}
		System.out.println("Number of rooms available : " + count);
	}

	static void bill(int rn, int rtype) {
        double amount = 0;
        System.out.println("\n*******");
        System.out.println(" Bill:-");
        System.out.println("*******");

        switch (rtype) {
            case 1:
                amount = printBillDetails(4000, hotel_ob.luxuryDoubleRoom[rn].food);
                break;
            case 2:
                amount = printBillDetails(3000, hotel_ob.deluxeDoubleRoom[rn].food);
                break;
            case 3:
                amount = printBillDetails(2200, hotel_ob.luxurySingleRoom[rn].food);
                break;
            case 4:
                amount = printBillDetails(1200, hotel_ob.deluxeSingleRoom[rn].food);
                break;
            default:
                System.out.println("Not valid");
        }
        System.out.println("\nTotal Amount- " + amount);
    }

	static void deallocate(int rn, int rtype) {
		int j;
		char w;
		switch (rtype) {
		case 1:
			if (hotel_ob.luxuryDoubleRoom[rn] != null)
				System.out.println("Room used by " + hotel_ob.luxuryDoubleRoom[rn].name);
			else {
				System.out.println("Empty Already");
				return;
			}
			System.out.println("Do you want to checkout ?(y/n)");
			w = sc.next().charAt(0);
			if (w == 'y' || w == 'Y') {
				bill(rn, rtype);
				hotel_ob.luxuryDoubleRoom[rn] = null;
				System.out.println("Deallocated succesfully");
			}

			break;
		case 2:
			if (hotel_ob.deluxeDoubleRoom[rn] != null)
				System.out.println("Room used by " + hotel_ob.deluxeDoubleRoom[rn].name);
			else {
				System.out.println("Empty Already");
				return;
			}
			System.out.println(" Do you want to checkout ?(y/n)");
			w = sc.next().charAt(0);
			if (w == 'y' || w == 'Y') {
				bill(rn, rtype);
				hotel_ob.deluxeDoubleRoom[rn] = null;
				System.out.println("Deallocated succesfully");
			}

			break;
		case 3:
			if (hotel_ob.luxurySingleRoom[rn] != null)
				System.out.println("Room used by " + hotel_ob.luxurySingleRoom[rn].name);
			else {
				System.out.println("Empty Already");
				return;
			}
			System.out.println(" Do you want to checkout ? (y/n)");
			w = sc.next().charAt(0);
			if (w == 'y' || w == 'Y') {
				bill(rn, rtype);
				hotel_ob.luxurySingleRoom[rn] = null;
				System.out.println("Deallocated succesfully");
			}

			break;
		case 4:
			if (hotel_ob.deluxeSingleRoom[rn] != null)
				System.out.println("Room used by " + hotel_ob.deluxeSingleRoom[rn].name);
			else {
				System.out.println("Empty Already");
				return;
			}
			System.out.println(" Do you want to checkout ? (y/n)");
			w = sc.next().charAt(0);
			if (w == 'y' || w == 'Y') {
				bill(rn, rtype);
				hotel_ob.deluxeSingleRoom[rn] = null;
				System.out.println("Deallocated succesfully");
			}
			break;
		default:
			System.out.println("\nEnter valid option : ");
			break;
		}
	}

	static void order(int rn, int rtype) {
		int i, q;
		char wish;
		try {
			System.out.println(
					"\n==========\n   Menu:  \n==========\n\n1.Sandwich\tRs.50\n2.Pasta\t\tRs.60\n3.Noodles\tRs.70\n4.Coke\t\tRs.30\n");
			do {
				i = sc.nextInt();
				System.out.print("Quantity- ");
				q = sc.nextInt();

				switch (rtype) {
				case 1:
					hotel_ob.luxuryDoubleRoom[rn].food.add(new Food(i, q));
					break;
				case 2:
					hotel_ob.deluxeDoubleRoom[rn].food.add(new Food(i, q));
					break;
				case 3:
					hotel_ob.luxurySingleRoom[rn].food.add(new Food(i, q));
					break;
				case 4:
					hotel_ob.deluxeSingleRoom[rn].food.add(new Food(i, q));
					break;
				}
				System.out.println("Do you want to order anything else ? (y/n)");
				wish = sc.next().charAt(0);
			} while (wish == 'y' || wish == 'Y');
		} catch (NullPointerException e) {
			System.out.println("\nRoom not booked");
		} catch (Exception e) {
			System.out.println("Cannot be done");
		}
	}
	
    private static double printBillDetails(double roomCharge, java.util.ArrayList<Food> foodList) {
        double totalAmount = roomCharge;
        String[] list = { "Sandwich", "Pasta", "Noodles", "Coke" };
        
        System.out.println("\nRoom Charge - " + roomCharge);
        System.out.println("\n===============");
        System.out.println("Food Charges:- ");
        System.out.println("===============");
        System.out.println("Item   Quantity    Price");
        System.out.println("-------------------------");
        
        for (Food obb : foodList) {
            totalAmount += obb.price;
            String format = "%-10s%-10s%-10s%n";
            System.out.printf(format, list[obb.itemno - 1], obb.quantity, obb.price);
        }
        
        return totalAmount;
    }
}