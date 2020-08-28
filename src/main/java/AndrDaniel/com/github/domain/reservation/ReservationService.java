package AndrDaniel.com.github.domain.reservation;

import AndrDaniel.com.github.domain.guest.Guest;
import AndrDaniel.com.github.domain.guest.GuestService;
import AndrDaniel.com.github.domain.reservation.dto.ReservationDTO;
import AndrDaniel.com.github.domain.room.Room;
import AndrDaniel.com.github.domain.room.RoomService;
import AndrDaniel.com.github.util.Properties;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservationService {
    private final static RoomService roomService = new RoomService();
    private final static GuestService guestService = new GuestService();
    private  final static ReservationRepository repository = new ReservationRepository();
    public Reservation createNewReservation(LocalDate from, LocalDate to, int roomId, int guestId) {
        //TODO: handle null room
        Room room = this.roomService.getRoomById(roomId);
        //TODO: handle null guest
        Guest guest = this.guestService.getGuestById(guestId);
        LocalDateTime fromWithTime = from.atTime(Properties.HOTEL_NIGHT_START_HOUR, Properties.HOTEL_NIGHT_START_MINUTE);
        LocalDateTime toWithTime = to.atTime(Properties.HOTEL_NIGHT_END_HOUR, Properties.HOTEL_NIGHT_END_MINUTE);
        return this.repository.createNewReservation(room, guest, fromWithTime, toWithTime);
    }
    public void readAll() {
        this.repository.readAll();
    }
    public void saveAll() {
        this.repository.saveAll();
    }

    public List<ReservationDTO> getReservationsAsDTO() {

        List<ReservationDTO> result = new ArrayList<>();

        List<Reservation> allReservations = this.repository.getAllReservations();

        for (Reservation reservation : allReservations) {
            ReservationDTO dto = reservation.getAsDTO();
            result.add(dto);
        }
        return result;
    }
}