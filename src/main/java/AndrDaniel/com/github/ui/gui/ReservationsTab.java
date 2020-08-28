package AndrDaniel.com.github.ui.gui;

import AndrDaniel.com.github.domain.guest.Guest;
import AndrDaniel.com.github.domain.reservation.ReservationService;
import AndrDaniel.com.github.domain.reservation.dto.ReservationDTO;
import AndrDaniel.com.github.domain.room.Room;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDateTime;
import java.util.List;

public class ReservationsTab {

    private Tab reservationTab;

    private ReservationService reservationService = new ReservationService();

    public ReservationsTab() {

        TableView<ReservationDTO> tableView =new TableView<>();



        TableColumn<ReservationDTO, LocalDateTime> dateTimeFromColumn = new TableColumn<>("Od");
        dateTimeFromColumn.setCellValueFactory(new PropertyValueFactory<>("from"));

        TableColumn<ReservationDTO, LocalDateTime> dateTimeToColumn = new TableColumn<>("Do");
        dateTimeToColumn.setCellValueFactory(new PropertyValueFactory<>("to"));

        TableColumn<ReservationDTO, Integer> roomColumn = new TableColumn<>("Pokój");
        roomColumn.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));

        TableColumn<ReservationDTO, Integer> guestColumn = new TableColumn<>("Rezerwujący");
        guestColumn.setCellValueFactory(new PropertyValueFactory<>("guestName"));


        tableView.getColumns().addAll(dateTimeFromColumn,dateTimeToColumn,roomColumn,guestColumn);

        List<ReservationDTO> allAsDTO = reservationService.getReservationsAsDTO();

        tableView.getItems().addAll(allAsDTO);

        this.reservationTab = new Tab("Rezerwacje",tableView);
        this.reservationTab.setClosable(false);
    }
    Tab getReservationTab(){
        return reservationTab;
    }
}
