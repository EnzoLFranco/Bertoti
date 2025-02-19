package com.enzolfranco.cardapi;

import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController // Define que essa classe vai ser um controlador
@RequestMapping("/cards") // Define o caminho base para os endpoints
public class cardController {
    private List<card> cards = new ArrayList<>();

    @PostConstruct // Anotação que indica que esse metodo sera executado após o construtor da classe ser chamado
    public void init() {
        // Adiciona dois cards à lista quando o controlador é inicializado
        cards.add(new card("1", "Cavaleiro A", "Guerreiro", "O melhor guerreiro"));
        cards.add(new card("2", "Mago B", "Mago", "O mago mais sábio"));
    }

    @GetMapping // Define o endpoint HTTP GET para recuperar todos os cards
    List<card> getCards(){
        return cards; // Retorna a lista de cards
    }

    @GetMapping("/{id}") // Define o endpoint GET para recuperar um card específico com base no id
    Optional<card> getCardById(@PathVariable String id){
        for(card cd: cards){
            if(cd.getId().equals(id)){  // Se encontrar o card, retorna ele embrulhado em um Optional
                return Optional.of(cd);
            }
        }
        return Optional.empty(); // Se não encontrar, retorna um Optional vazio
    }

    @PostMapping // Define o endpoint POST para criar um novo card
    card createCard(@RequestBody card card){
        cards.add(card); // Adiciona o novo card à lista
        return card; // Retorna o card que foi criado
    }

    @PutMapping("/{id}") // Define o endpoint PUT para atualizar um card existente com base no id
    ResponseEntity<card> updateCard(@PathVariable String id, @RequestBody card card) {
        int cardIndex = -1;

        for (card c: cards) {
            if (c.getId().equals(id)) { // Se o id for encontrado, atualiza o card na lista
                cardIndex = cards.indexOf(c);  // Atualiza o índice do card
                cards.set(cardIndex, card);  // Substitui o card antigo pelo novo
            }
        }

        return (cardIndex == -1) ?
                new ResponseEntity<>(createCard(card), HttpStatus.CREATED) :
                new ResponseEntity<>(card, HttpStatus.OK);
    }

    @DeleteMapping("/{id}") // Define o endpoint DELETE para excluir um card com base no id
    public void deleteCard(@PathVariable String id) {  // Recebe o id do card a ser excluído
        // Remove o card da lista com base no id
        cards.removeIf(c -> c.getId().equals(id));
    }

}
