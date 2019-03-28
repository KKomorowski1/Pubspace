package pl.komorowski.pubspace.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.sql.Timestamp;

@Entity
@Table(name = "seat")
@XmlAccessorType(XmlAccessType.FIELD)
public class Seat {

    @Id
    @Column(name = "seat_id")
    private int seatId;

    @Column(name = "date_time")
    private Timestamp dateTime;
    @Column(name = "space")
    private String space;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pub_id")
    private Pub pub;

    public Seat(int seatId, Timestamp dateTime, String space, Pub pub) {
        this.seatId = seatId;
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
