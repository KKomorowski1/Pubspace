package pl.komorowski.pubspace.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;

@Entity
@Table(name = "seat")
@XmlAccessorType(XmlAccessType.FIELD)
public class Seat {

    @Id
    @Column(name = "seat_id")
    private int seatId;
    @Column(name = "pub_id")
    private int pubId;
    @Column(name = "date_time")
    private Timestamp dateTime;
    @Column(name = "space")
    private String space;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(insertable=false, updatable=false, name = "pub_id")
    private Pub pub;

    public Seat(int seatId, int pubId, Timestamp dateTime, String space) {
        this.seatId = seatId;
        this.pubId = pubId;
        this.dateTime = dateTime;
        this.space = space;
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
