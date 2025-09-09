class HotelBooking {
    String guestName;
    String roomType;
    int nights;

    HotelBooking() {
        guestName = "Unknown";
        roomType = "Standard";
        nights = 1;
    }

    HotelBooking(String g, String r, int n) {
        guestName = g;
        roomType = r;
        nights = n;
    }

    HotelBooking(HotelBooking hb) {
        guestName = hb.guestName;
        roomType = hb.roomType;
        nights = hb.nights;
    }

    void display() {
        System.out.println("Guest: " + guestName + ", Room: " + roomType + ", Nights: " + nights);
    }
}

public class Main {
    public static void main(String[] args) {
        HotelBooking b1 = new HotelBooking();
        b1.display();

        HotelBooking b2 = new HotelBooking("Ankit", "Deluxe", 3);
        b2.display();

        HotelBooking b3 = new HotelBooking(b2);
        b3.display();
    }
}
