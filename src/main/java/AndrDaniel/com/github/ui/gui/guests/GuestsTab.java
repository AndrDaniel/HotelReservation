package AndrDaniel.com.github.ui.gui.guests;

import AndrDaniel.com.github.domain.ObjectPool;
import AndrDaniel.com.github.domain.guest.dto.GuestDTO;
import AndrDaniel.com.github.domain.guest.GuestService;
import AndrDaniel.com.github.ui.gui.guests.AddNewGuestScene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.List;

public class GuestsTab {
    private Tab guestTab;
    private GuestService guestService = ObjectPool.getGuestService();

    public GuestsTab(Stage primaryStage) {
        TableView<GuestDTO> tableView = getGuestDTOTableView();

        Button btn = new Button("Dodaj nowego gościa");

        btn.setOnAction(actionEvent -> {
            Stage stg = new Stage();
            stg.initModality(Modality.WINDOW_MODAL);
            stg.initOwner(primaryStage);
            stg.setScene(new AddNewGuestScene(stg, tableView).getMainScene());
            stg.setTitle("Dodaj nowego gościa");

            stg.showAndWait();
        });
        VBox layout = new VBox(btn, tableView);

        this.guestTab = new Tab("Goście", layout);
        this.guestTab.setClosable(false);

    }

    private TableView<GuestDTO> getGuestDTOTableView() {
        TableView<GuestDTO> tableView = new TableView<>();

        TableColumn<GuestDTO, String> firstNameColumn = new TableColumn<>("Imię");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<GuestDTO, String> lastNameColumn = new TableColumn<>("Nazwisko");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<GuestDTO, Integer> ageColumn = new TableColumn<>("Wiek");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<GuestDTO, String> genderColumn = new TableColumn<>("Płeć");
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));

        tableView.getColumns().addAll(firstNameColumn, lastNameColumn, ageColumn, genderColumn);

        List<GuestDTO> allAsDTO = guestService.getGuestsAsDTO();

        tableView.getItems().addAll(allAsDTO);
        return tableView;
    }

    public Tab getGuestTab() {
        return guestTab;
    }
}
