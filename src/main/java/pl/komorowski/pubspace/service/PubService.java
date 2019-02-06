package pl.komorowski.pubspace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.komorowski.pubspace.model.Pub;
import pl.komorowski.pubspace.repository.PubRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class PubService {

    @Autowired
    private PubRepo pubRepo;



    public List<Pub> getAllPubs() {

        List<Pub> pubs = new ArrayList<>();
        pubRepo.findAll().forEach(pubs::add);
        return pubs;

    }

    public Pub getPub(int id) {

        return pubRepo.findById(id).orElse(null);
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
