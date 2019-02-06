package pl.komorowski.pubspace.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Seat {

    @Id
    @Column(name = "seat_id")
    private int seatId;
    @Column(name = "pub_id")
    private int pubId;
    @Column(name = "date_time")
    private LocalDateTime dateTime;
    @Column(name = "space")
    private String space;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinColumn(name = "pub_id")
//    private Pub pub;

    //, insertable = false, updatable = false
    public Seat(int seatId, LocalDateTime dateTime, int pubId, String space, Pub pub) {
        this.seatId = seatId;
        this.pubId = pubId;
        this.dateTime = dateTime;
        this.space = space;
        //  this.pub = pub;
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getSpace() {
        return space;
    }

    public void setSpace(String space) {
        this.space = space;
    }

//    public Pub getPub() {
//        return pub;
//    }
//
//    public void setPub(Pub pub) {
//        this.pub = pub;
//    }

    @Override
    public String toString() {
        return

                space;  //pub;

    }


}
