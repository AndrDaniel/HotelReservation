package AndrDaniel.com.github.ui.gui;

import AndrDaniel.com.github.util.Properties;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PrimaryStage {
    public void initialize(Stage primaryStage) {
        String hotelName = Properties.HOTEL_NAME;
        int systemVersion = Properties.SYSTEM_VERSION;

        MainTabView mainTabView = new MainTabView(primaryStage);

        Scene scene = new Scene(mainTabView.getMainTabs(), 740, 580);
        scene.getStylesheets()
                .add(getClass()
                        .getClassLoader()
                        .getResource("hotelReservation.css")
                        .toExternalForm());
        String title = String.format("System rezerwacji hotelu %s (%d)", hotelName, systemVersion);
        primaryStage.setTitle(title);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
