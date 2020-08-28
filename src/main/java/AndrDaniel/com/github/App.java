package AndrDaniel.com.github;

import AndrDaniel.com.github.domain.guest.GuestService;
import AndrDaniel.com.github.domain.reservation.ReservationService;
import AndrDaniel.com.github.domain.room.RoomService;
import AndrDaniel.com.github.exceptions.PersistenceToFileException;
import AndrDaniel.com.github.ui.gui.PrimaryStage;
import AndrDaniel.com.github.ui.text.TextUI;
import AndrDaniel.com.github.util.Properties;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;


public class App extends Application {

    private static final TextUI textUI = new TextUI();
    private static final GuestService guestService = new GuestService();
    private static final RoomService roomService = new RoomService();
    private static final ReservationService reservationService = new ReservationService();

    public static void main(String[] args) {
        try {
            Properties.createDataDirectory();
            System.out.println("Trwa ładowanie danych...");
            guestService.readAll();
            roomService.readAll();
            reservationService.readAll();
        } catch (IOException e) {
            throw new PersistenceToFileException(Properties.DATA_DIRECTORY.toString(), "create", "directory");
        }
//            textUI.showSystemInfo();
//            textUI.showMainMenu();
        Application.launch(args);
    }

    public void start(Stage primaryStage) {
        PrimaryStage primary = new PrimaryStage();
        primary.initialize(primaryStage);
    }
}

