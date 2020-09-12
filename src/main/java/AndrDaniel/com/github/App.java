package AndrDaniel.com.github;

import AndrDaniel.com.github.domain.ObjectPool;
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
    private static final GuestService guestService = ObjectPool.getGuestService();
    private static final RoomService roomService = ObjectPool.getRoomService();
    private static final ReservationService reservationService = ObjectPool.getReservationService();

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
        Application.launch(args);
//        textUI.showSystemInfo();
//        textUI.showMainMenu();
    }

    @Override
    public void start(Stage primaryStage) {
        PrimaryStage primary = new PrimaryStage();
        primary.initialize(primaryStage);
    }

    @Override
    public void stop() {
        System.out.println("Wychodzę z aplikacji. Zapisuję dane.");
        guestService.saveAll();
        roomService.saveAll();
        reservationService.saveAll();
    }


}

