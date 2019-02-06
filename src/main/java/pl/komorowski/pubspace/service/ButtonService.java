package pl.komorowski.pubspace.service;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class ButtonService {



    public Map<String, String> populateSeat(){
        Map<String, String> seat=new LinkedHashMap<String, String>();
        seat.put("Brak miejsc", "Brak miejsc");
        seat.put("Okolo 5 miejsc", "Okolo 5 miejsc");
        seat.put("Okolo 10 miejsc", "Okolo 10 miejsc");
        return seat;

    }
}
