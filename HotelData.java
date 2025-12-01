import java.io.Serializable;

public class HotelData implements Serializable {
	public DoubleRoom luxuryDoubleRoom[] = new DoubleRoom[10]; // Luxury
	public DoubleRoom deluxeDoubleRoom[] = new DoubleRoom[20]; // Deluxe
	public SingleRoom luxurySingleRoom[] = new SingleRoom[10]; // Luxury
	public SingleRoom deluxeSingleRoom[] = new SingleRoom[20]; // Deluxe
}
