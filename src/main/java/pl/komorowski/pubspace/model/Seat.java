package pl.komorowski.pubspace.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "seat")
public class Seat {

    @Id
    @Column(name = "seat_id")
    private int seatId;
    @Column(name = "pub_id")
    private int pubId;
    @Column(name = "date_time")
    @DateTimeFormat(pattern = "HH:mm yyyy-MM-dd")
    private Timestamp dateTime;
    @Column(name = "space")
    private String space;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(insertable = false, updatable = false, name = "pub_id")
    private Pub pub;

    public Seat(int seatId, Timestamp dateTime, int pubId, String space, Pub pub) {
        this.seatId = seatId;
        this.pubId = pubId;
        this.dateTime = dateTime;
        this.space = space;
        this.pub = pub;
    }



    public Seat() {
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getPubId() {
        return pubId;
    }

    public void setPubId(int pubId) {
        this.pubId = pubId;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public String getSpace() {
        return space;
    }

    public void setSpace(String space) {
        this.space = space;
    }

    public Pub getPub() {
        return pub;
    }

    public void setPub(Pub pub) {
        this.pub = pub;
    }

    @Override
    public String toString() {
        return

                space +"\n " + dateTime;  //pub;

    }


}
