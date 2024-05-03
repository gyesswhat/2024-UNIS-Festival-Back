package com.example.liberewhaunis.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    @Query(value = "SELECT COUNT(*) FROM reservation WHERE date = :date AND time = :time", nativeQuery = true)
    int countReservations(@Param("date") Integer date, @Param("time") Integer time);

    @Query(name="Reservation.findAllList", nativeQuery = true)
    List<ReservationListDto> findAllList();
}
