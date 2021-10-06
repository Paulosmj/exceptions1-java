package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

		System.out.println("Room number: ");
		int number = sc.nextInt();
		System.out.println("Check-in date (dd/MM/yyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Check-out date (dd/MM/yyy): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after Check-in date");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Resevation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.println("Check-in date (dd/MM/yyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check-out date (dd/MM/yyy): ");
			checkOut = sdf.parse(sc.next());

			String error = reservation.updateDates(checkIn, checkOut);
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			} 
			else {
				System.out.println("Resevation: " + reservation);
			}

		}

		sc.close();
	}

}
