# Eng. de Software

We see three critical differences between programming and software engineering: time, scale, and the trade-offs at play. On a software engineering project, engineers need to be more concerned with the passage of time and the eventual need for change. In a software engineering organization, we need to be more concerned about scale and efficiency, both for the software we produce as well as for the organization that is producing it. Finally, as software engineers, we are asked to make more complex decisions with higher-stakes outcomes, often based on imprecise estimates of time and growth.

O texto exemplifica as diferenças principais entre um engenheiro de software e um programador. O engenheiro tem sua preocupação direcionada para variaveis que podem afetar o projeto de maneira mais drástica como o tempo e escala das tarefas realizadas, o mesmo deve estar preparado para possívies mudanças de rumo no projeto. Também pe apresentado como, em organizações focadas em engenharia de software, os engenheiros devem se preocupar como as variaveis citadas anteriormente afetam tanto o projeto quando a organização. O engenheiro tem como função tomar as decisões de alto risco para o andamento dos softwares.

# Exemplos de Trade-Off
1. Desenvolver um projeto em determinada linguagem ao invés de outra: A escolha é feita pesando as qualidades e defeitos de ambas as lingugens, por exemplo, usar Java para um projeto pela portabilidade em um software ao invés de Kobol.
2. Usar uma metodologia ágil ao invés de uma metodologia tradicional: A metodologia ágil é escolhida pela flexibilidade e adaptação a mudanças rápidas, sacrificando a previsibilidade e controle detalhado do escopo que a cascata oferece.
3. Usar armazenamento em disco local ao invés de armazenamento em nuvem: Armazenamento local é escolhido pelo menor custo a longo prazo e controle total, sacrificando a escalabilidade e a acessibilidade global que a nuvem oferece.

# Código da Lista + Testes JUnit

- Classe Avião

```java
public class Avião {
    // Criação das variáveis
    private String modelo;
    private String numeroSerie;

    // Criação do objeto Avião
    public Avião(String modelo, String numeroSerie) {
        this.modelo = modelo;
        this.numeroSerie = numeroSerie;
    }

    // Gets e Sets
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
}
```
- Classe Hangar

```java
import java.util.List;
import java.util.LinkedList;

// Classe Hangar que mantém uma lista de objetos do tipo Avião
public class Hangar {

    // Lista de aviões, inicializada como uma LinkedList
    private List<Avião> aviões = new LinkedList<Avião>();
    
    // Método para cadastrar um novo avião na lista
    public void cadastrarAvião(Avião avião) {
        aviões.add(avião);  // Adiciona o objeto Avião à lista
    }
    
    // Método para buscar aviões pelo modelo informado
    public List<Avião> buscarAviãoPorModelo(String modelo) {
        List<Avião> aviõesEncontrados = new LinkedList<Avião>();  // Cria uma lista para armazenar os aviões encontrados
        for(Avião avião : aviões) {  // Itera sobre a lista de aviões
            if(avião.getModelo().equals(modelo)) 
                aviõesEncontrados.add(avião);  // Se o modelo for igual, adiciona o avião à lista de encontrados
        }
        return aviõesEncontrados;  // Retorna a lista de aviões encontrados com o modelo solicitado
    }
    
    // Método para obter a lista completa de aviões cadastrados
    public List<Avião> getAviões() {
        return aviões;  // Retorna a lista de aviões
    }
}
```

- Classe de Teste

```java
  import static org.junit.jupiter.api.Assertions.*;  // Importa as funções de assert do JUnit para verificações de teste
import java.util.List;  // Importa a classe List para manipulação de listas
import org.junit.jupiter.api.Test;  // Importa a anotação @Test para marcar métodos de teste

// Classe de testes unitários
class Teste {

    // Método de teste
    @Test
    void test() {
        
        // Cria uma nova instância da classe Hangar
        Hangar hangarDoZeppelin = new Hangar();
        
        // Cria dois objetos Avião com modelos e números de série diferentes
        Avião AirbusA380 = new Avião("AirbusA380", "54321123");
        Avião Boeing747 = new Avião("Boeing747", "12345123");
        
        // Cadastra os aviões no hangar
        hangarDoZeppelin.cadastrarAvião(AirbusA380);
        hangarDoZeppelin.cadastrarAvião(Boeing747);
        
        // Verifica se o tamanho da lista de aviões cadastrados no hangar é 2
        assertEquals(hangarDoZeppelin.getAviões().size(), 2);
        
        // Busca todos os aviões com o modelo "Boeing747" e armazena a lista de resultados
        List<Avião> boeings = hangarDoZeppelin.buscarAviãoPorModelo("Boeing747");
        
        // Verifica se o número de série do primeiro avião encontrado corresponde ao número de série do Boeing747
        assertEquals(boeings.get(0).getNumeroSerie(), Boeing747.getNumeroSerie());
    }
}
```
