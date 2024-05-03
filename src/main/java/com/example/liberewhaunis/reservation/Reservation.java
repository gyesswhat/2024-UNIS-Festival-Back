package com.example.liberewhaunis.reservation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="reservation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@NamedNativeQuery(
        name="Reservation.findAllList",
        query="SELECT date, time, customer_name FROM reservation ORDER BY date DESC, time DESC, created_at DESC",
        resultSetMapping = "ReservationListDtoMapping"
)
@SqlResultSetMapping(
        name="ReservationListDtoMapping",
        classes = {
                @ConstructorResult(
                        targetClass = ReservationListDto.class,
                        columns = {
                                @ColumnResult(name="date", type=Integer.class),
                                @ColumnResult(name="time", type= Integer.class),
                                @ColumnResult(name="customer_name", type=String.class)
                        }
                )
        }
)
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservationId;
    @Column
    private String createdAt;
    @Column
    private Integer date;
    @Column
    private Integer time;
    @Column
    private String customerName;
    @Column
    private String customerPhone;
    @Column
    private Integer menu1;
    @Column
    private Integer menu2;
    @Column
    private Integer menu3;
    @Column
    private Integer menu4;
    @Column
    private Integer menu5;
}
