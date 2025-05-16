package com.enzolfranco.cardapi;

import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/cards")
public class cardController {
    private List<card> cards = new ArrayList<>();

    private String generateId() {
        int nextId = cards.size() + 1;
        return String.format("CARD-%04d", nextId);
    }

    @PostConstruct
    public void init() {
        cards.add(new card("CARD-0001", "Cavaleiro A", "Guerreiro", "O melhor guerreiro"));
        cards.add(new card("CARD-0002", "Mago B", "Mago", "O mago mais sábio"));
    }

    @GetMapping
    List<card> getCards(){
        return cards;
    }

    @GetMapping("/{id}")
    Optional<card> getCardById(@PathVariable String id){
        for(card cd: cards){
            if(cd.getId().equals(id)){
                return Optional.of(cd);
            }
        }
        return Optional.empty();
    }

    @PostMapping
    card createCard(@RequestBody card card){
        card.setId(generateId());
        cards.add(card);
        return card;
    }

    @PutMapping("/{id}")
    ResponseEntity<card> updateCard(@PathVariable String id, @RequestBody card card) {
        int cardIndex = -1;

        for (card c: cards) {
            if (c.getId().equals(id)) {
                cardIndex = cards.indexOf(c);
                cards.set(cardIndex, card);
            }
        }

        return (cardIndex == -1) ?
                new ResponseEntity<>(createCard(card), HttpStatus.CREATED) :
                new ResponseEntity<>(card, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteCard(@PathVariable String id) {
        cards.removeIf(c -> c.getId().equals(id));
    }

}
