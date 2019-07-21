package pl.komorowski.pubspace.DTO;

import java.util.Date;

public class PubspaceDto {
    private String name;
    private String space;
    private Date dateTime;
    private Integer seatId;

    public PubspaceDto() {
    }

    public PubspaceDto(String name, String space, Date dateTime, Integer seatId) {
        this.name = name;
        this.space = space;
        this.dateTime = dateTime;
        this.seatId = seatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpace() {
        return space;
    }

    public void setSpace(String space) {
        this.space = space;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    @Override
    public String toString() {
        return name + " " + space + " " + dateTime;
    }

}
