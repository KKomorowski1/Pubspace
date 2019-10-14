package pl.komorowski.pubspace;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import pl.komorowski.pubspace.controller.rest.PubController;
import pl.komorowski.pubspace.model.Pub;

import pl.komorowski.pubspace.service.PubService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
class PubTest {

    @InjectMocks
    PubController pubController;

    @Mock
    PubService pubService;

    @Test
    void getAllPubs(){
        // Given data
        Pub pub1 = new Pub(1, "asd", "asd");
        Pub pub2 = new Pub(2, "asdf", "asdf");
        Pub pub3 = null;

        List<Pub> pubs = new ArrayList<>();
        pubs.add(pub1);
        pubs.add(pub2);
        pubs.add(pub3);

        when(pubService.getAllPubs()).thenReturn(pubs);
        // When
        List result = pubController.getAllPub();
        // Then
        int size = result.size();
        assertThat(result.size()).isEqualTo(size);
        assertThat(result.get(size-1)).isEqualTo(pubs.get(size-1));
    }
}

