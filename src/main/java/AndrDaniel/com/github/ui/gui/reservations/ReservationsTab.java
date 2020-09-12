package AndrDaniel.com.github.ui.gui.reservations;

import AndrDaniel.com.github.domain.ObjectPool;
import AndrDaniel.com.github.domain.reservation.ReservationService;
import AndrDaniel.com.github.domain.reservation.dto.ReservationDTO;
import AndrDaniel.com.github.ui.gui.reservations.AddNewReservationScene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.util.List;

public class ReservationsTab {

    private Tab reservationTab;

    private ReservationService reservationService = ObjectPool.getReservationService();

    public ReservationsTab(Stage primaryStage) {

        TableView<ReservationDTO> tableView = getReservationDTOTableView();

        Button btn = new Button("Utwórz rezerwację");

        btn.setOnAction(actionEvent -> {
            Stage stg = new Stage();
            stg.initModality(Modality.WINDOW_MODAL);
            stg.initOwner(primaryStage);
            stg.setScene(new AddNewReservationScene(stg, tableView).getMainScene());
            stg.setTitle("Uwtwórz rezerwację");
            stg.showAndWait();
        });
        VBox layout = new VBox(btn, tableView);



        this.reservationTab = new Tab("Rezerwacje",layout);
        this.reservationTab.setClosable(false);
    }

    private TableView<ReservationDTO> getReservationDTOTableView() {
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
        return tableView;
    }

    public Tab getReservationTab(){
        return reservationTab;
    }
}
