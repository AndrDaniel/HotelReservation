package AndrDaniel.com.github.ui.gui;

import AndrDaniel.com.github.domain.room.RoomService;
import AndrDaniel.com.github.domain.room.dto.RoomDTO;

import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;


public class RoomsTab {
    private Tab roomTab;
private RoomService roomService = new RoomService();
    public RoomsTab() {

        TableView<RoomDTO> tableView = new TableView<>();

        TableColumn<RoomDTO,Integer> numberColumn = new TableColumn<>("Numer");
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));

        TableColumn<RoomDTO,String> bedsColumn = new TableColumn<>("Typy łóżek");
        bedsColumn.setCellValueFactory(new PropertyValueFactory<>("beds"));

        TableColumn<RoomDTO,Integer> bedsCountColumn = new TableColumn<>("Ilość łóżek");
        bedsCountColumn.setCellValueFactory(new PropertyValueFactory<>("bedsCount"));

        TableColumn<RoomDTO,Integer> roomSizeColumn = new TableColumn<>("Ilość miejsc w pokoju");
        roomSizeColumn.setCellValueFactory(new PropertyValueFactory<>("roomSize"));

        tableView.getColumns().addAll(numberColumn,roomSizeColumn,bedsCountColumn,bedsColumn);

        List<RoomDTO> allAsDTO = roomService.getAllAsDTO();

        tableView.getItems().addAll(allAsDTO);

        this.roomTab = new Tab("Pokoje", tableView);
        this.roomTab.setClosable(false);
    }

     Tab getRoomTab() {
        return roomTab;
    }
}
