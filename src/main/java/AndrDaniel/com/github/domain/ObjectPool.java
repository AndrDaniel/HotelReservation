package AndrDaniel.com.github.domain;

import AndrDaniel.com.github.domain.guest.GuestRepository;
import AndrDaniel.com.github.domain.guest.GuestService;
import AndrDaniel.com.github.domain.reservation.ReservationRepository;
import AndrDaniel.com.github.domain.reservation.ReservationService;
import AndrDaniel.com.github.domain.room.RoomRepository;
import AndrDaniel.com.github.domain.room.RoomService;

public class ObjectPool {

    private ObjectPool() {

    }

    public static GuestService getGuestService() {
        return GuestService.getInstance();
    }

    public static GuestRepository getGuestRepository() {
        return  GuestRepository.getInstance();
    }

    public static RoomService getRoomService() {
        return RoomService.getInstance();
    }

    public static RoomRepository getRoomRepository() {
        return RoomRepository.getInstance();
    }

    public static ReservationService getReservationService() {
        return ReservationService.getInstance();
    }

    public static ReservationRepository getReservationRepository() {
        return ReservationRepository.getInstance();
    }
}
