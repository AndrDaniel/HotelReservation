package AndrDaniel.com.github.domain.reservation;

import AndrDaniel.com.github.domain.guest.Guest;
import AndrDaniel.com.github.domain.reservation.dto.ReservationDTO;
import AndrDaniel.com.github.domain.room.Room;

import java.time.LocalDateTime;

public class Reservation {
    private final int id;
    private final Room room;
    private final Guest guest;
    //LocalDate
    //LocalTime
    //LocalDateTime
    private final LocalDateTime from;
    private final LocalDateTime to;

    public Reservation(int id, Room room, Guest guest, LocalDateTime from, LocalDateTime to) {
        this.id = id;
        this.room = room;
        this.guest = guest;
        this.from = from;
        this.to = to;
    }
    String toCSV() {
        return String.format("%s,%s,%s,%d,%s%s",
                this.room,
                this.guest,
                this.from,
                this.to,
                System.getProperty("line.separator"));
    }
    public int getId() {
        return this.id;
    }

    public ReservationDTO getAsDTO() {
        return new ReservationDTO(this.id,this.from,this.to,this.room.getId(),this.room.getNumber(),this.guest.getId(),this.guest.getFirstName()+" "+this.guest.getLastName());
    }
}
