package AndrDaniel.com.github.ui.gui;

import AndrDaniel.com.github.domain.guest.dto.GuestDTO;
import AndrDaniel.com.github.domain.guest.Gender;
import AndrDaniel.com.github.domain.guest.GuestService;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class GuestsTab {
    private Tab guestTab;
    private GuestService guestService = new GuestService();

    public GuestsTab() {
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

        this.guestTab = new Tab("Goście", tableView);
        this.guestTab.setClosable(false);

    }

    Tab getGuestTab() {
        return guestTab;
    }
}
