package pl.komorowski.pubspace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pl.komorowski.pubspace.model.Pub;
import pl.komorowski.pubspace.repository.PubRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class PubService {

    private PubRepo pubRepo;

    @Autowired
    public PubService(PubRepo pubRepo) {
        this.pubRepo = pubRepo;
    }

    public PubService() {
    }

    public List getAllPubs() {
        return new ArrayList<>(pubRepo.findAll());
    }

    public Pub getPub(int id) {
        return pubRepo.findById(id);
    }

    public void addPub(Pub pub) {
        pubRepo.save(pub);
    }

    public void updatePub(int id, Pub pub) {
        pubRepo.save(pub);
    }

    public void deletePub(int id) {
        pubRepo.deleteById(id);
    }

}
