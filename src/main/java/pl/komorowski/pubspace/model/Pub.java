package pl.komorowski.pubspace.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.Set;

@Entity
@Table(name = "pubs")
@XmlAccessorType(XmlAccessType.FIELD)
public class Pub {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @JsonIgnore
    @OneToMany(mappedBy = "pub", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Seat> seat;

    public Pub() {
    }

    public Pub(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Set<Seat> getSeat() {
        return seat;
    }

    public void setSeat(Set<Seat> seat) {
        this.seat = seat;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return
                "" + name;
    }
}
