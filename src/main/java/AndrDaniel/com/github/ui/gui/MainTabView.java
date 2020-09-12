package AndrDaniel.com.github.ui.gui;

import AndrDaniel.com.github.ui.gui.guests.GuestsTab;
import AndrDaniel.com.github.ui.gui.reservations.ReservationsTab;
import AndrDaniel.com.github.ui.gui.rooms.RoomsTab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class MainTabView {
    private TabPane mainTabs;

    public MainTabView(Stage primaryStage) {
        this.mainTabs = new TabPane();


        RoomsTab roomsTab = new RoomsTab(primaryStage);
        GuestsTab guestsTab = new GuestsTab(primaryStage);

        ReservationsTab reservationsTab = new ReservationsTab(primaryStage);

        this.mainTabs.getTabs().addAll(reservationsTab.getReservationTab(), guestsTab.getGuestTab(), roomsTab.getRoomTab());
    }

    TabPane getMainTabs() {
        return mainTabs;
    }
}
