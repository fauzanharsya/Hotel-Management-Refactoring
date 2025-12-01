import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

class DataSaver implements Runnable {
	HotelData hotel_ob;

	DataSaver(HotelData hotel_ob) {
		this.hotel_ob = hotel_ob;
	}

	@Override
	public void run() {
		try {
			FileOutputStream fout = new FileOutputStream("backup");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(hotel_ob);
		} catch (Exception e) {
			System.out.println("Error in writing " + e);
		}

	}

}