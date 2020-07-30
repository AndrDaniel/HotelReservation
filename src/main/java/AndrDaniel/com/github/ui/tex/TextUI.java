package AndrDaniel.com.github.ui.tex;

import AndrDaniel.com.github.domain.guest.Guest;
import AndrDaniel.com.github.domain.guest.GuestService;
import AndrDaniel.com.github.exceptions.OnlyNumberException;
import AndrDaniel.com.github.exceptions.WrongOptionException;
import AndrDaniel.com.github.domain.room.Room;
import AndrDaniel.com.github.domain.room.RoomService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TextUI {
  private final GuestService guestService = new GuestService();
    private final RoomService roomService = new RoomService();

   private void readNewGuestData(Scanner input) {
        System.out.println("Tworzymy nowego gościa.");
        try {
            System.out.println("Podaj imię: ");
            String firstName = input.next();
            System.out.println("Podaj nazwisko: ");
            String lastName = input.next();
            System.out.println("Podaj wiek: ");
            int age = input.nextInt();
            System.out.println("Podaj płeć:");
            System.out.println("1. Mężczyzna");
            System.out.println("2. Kobieta");
            int genderOption = input.nextInt();
            if (genderOption != 1 && genderOption != 2) {
                throw new WrongOptionException("Wrong option in gender selection");
            }

            boolean isMale = false;
            if(genderOption == 1){
                isMale = true;
            }
            Guest newGuest = guestService.createNewGuest(firstName, lastName, age, isMale);
            System.out.println("Dodano nowego gościa: " + newGuest.getInfo());

        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Use only numbers when choosing gender");
        }
    }

   private void readNewRoomData(Scanner input) {
        System.out.println("Tworzymy nowy pokój.");
        try {
            System.out.println("Numer: ");
            int number = input.nextInt();
            int[] bedTypes = chooseBedType(input);

            Room newRoom = roomService.createNewRoom(number, bedTypes);
            System.out.println("Dodano nowy pokoj: " + newRoom.getInfo());
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Use numbers when creating new room");
        }
    }

    private static int[] chooseBedType(Scanner input) {
        System.out.println("Ile łóżek w pokoju?: ");
        int bedNumber = input.nextInt();
        int[] bedTypes = new int[bedNumber];
        for (int i = 0; i < bedNumber; i = i + 1) {
            System.out.println("Typy łóżek: ");
            System.out.println("\t1. Pojedyncze");
            System.out.println("\t2. Podwójne");
            System.out.println("\t3. Królewskie");
            int bedTypeOption = input.nextInt();

            bedTypes[i] = bedTypeOption;
        }
        return bedTypes;
    }

    public static void showSystemInfo(String hotelName, int systemVersion, boolean isDeveloperVersion) {
        System.out.print("Witam w systemie rezerwacji dla hotelu " + hotelName);
        System.out.println("Aktualna wersja systemu: " + systemVersion);
        System.out.println("Wersja developerska: " + isDeveloperVersion);
        System.out.println("\n=========================\n");
    }

    public void showMainMenu() {

        System.out.println("Trwa ładowanie danych...");
        this.guestService.readAll();
        this.roomService.readAll();

            Scanner input = new Scanner(System.in);
            try {
                performAction(input);
            } catch (WrongOptionException | OnlyNumberException e) {
                System.out.println("Wystąpił niespodziewany błąd");
                System.out.println("Kod błędu: " + e.getCode());
                System.out.println("Komunikat błędu: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Wystąpił niespodziewany błąd");
                System.out.println("Nieznany kod błędu");
                System.out.println("Komunikat błędu: " + e.getMessage());
            }
        }

    private void performAction(Scanner input) {
        int option = -1;
        while (option !=0) {
           option = getActionFromUser(input);
            if (option == 1) {
                readNewGuestData(input);
            } else if (option == 2) {
                readNewRoomData(input);
            } else if (option == 3) {
                showAllGuests();
            }else if (option == 4) {
                showAllRooms();
            }else if (option == 0) {
                    System.out.println("Wychodzę z aplikacji. Zapisuję dane.");
                    this.guestService.saveAll();
                    this.roomService.saveAll();
            } else {
                throw new WrongOptionException("Wrong option in main menu");
            }
        }
    }

    private void showAllRooms() {
       List<Room> rooms= this.roomService.getAllRooms();
       for(Room room: rooms){
           System.out.println(room.getInfo());
       }
    }

    private void showAllGuests() {
       List<Guest> guests =this.guestService.getAllGuests();
       for(Guest guest : guests){
           System.out.println(guest.getInfo());
       }
    }

    private static int getActionFromUser(Scanner in) {
        System.out.println("1. Dodaj nowego gościa.");
        System.out.println("2. Dodaj nowy pokój.");
        System.out.println("3. Wypisz wszystkich gości.");
        System.out.println("4. Wypisz wszystkie dane o pokojach.");
        System.out.println("0. Wyjście z aplikacji");

        System.out.println("Wybierz opcję: ");
        int option;
        try {
            option = in.nextInt();
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Use only numbers in main menu");
        }
        return option;
    }
}

