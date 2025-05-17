function showTab(tabId) {
    document.querySelectorAll('.tab-content').forEach(tab => {
        tab.style.display = "none";
    });

    document.getElementById(tabId).style.display = "block";
}

function fetchCards() {
    fetch('http://localhost:8080/cards')
        .then(response => response.json())
        .then(cards => {
            let tableBody = document.getElementById("cardList");
            tableBody.innerHTML = "";

            cards.forEach(card => {
                let row = `<tr>
                    <td>${card.id}</td>
                    <td>${card.name}</td>
                    <td>${card.type}</td>
                    <td>${card.description}</td>
                    <td><button onclick="deleteCard('${card.id}')">🗑️</button></td>
                </tr>`;
                tableBody.innerHTML += row;
            });
        })
        .catch(error => console.error('Erro ao buscar cards:', error));
}

function addCard() {
    const card = {
        name: document.getElementById("name").value,
        type: document.getElementById("type").value,
        description: document.getElementById("description").value
    };

    fetch("http://localhost:8080/cards", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(card)
    })
    .then(response => response.json())
    .then(data => {
        alert("Card criado com sucesso!");
        document.getElementById("name").value = "";
        document.getElementById("type").value = "";
        document.getElementById("description").value = "";
    })
    .catch(error => {
        console.error("Erro ao criar card:", error);
        alert("Erro ao criar card.");
    });
}

function deleteCard(id) {
    fetch(`http://localhost:8080/cards/${id}`, {
        method: 'DELETE'
    })
    .then(() => {
        alert("Card deletado com sucesso!");
        fetchCards(); 
    })
    .catch(error => {
        console.error("Erro ao deletar card:", error);
        alert("Erro ao deletar card.");
    });
}

function fetchCardById() {
    const id = document.getElementById('searchId').value.trim();
    const detailsDiv = document.getElementById('cardDetails');

    if (!id) {
        detailsDiv.innerHTML = "<p style='color: red;'>Por favor, insira um ID válido.</p>";
        return;
    }

    fetch(`http://localhost:8080/cards/${id}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Card não encontrado');
            }
            return response.json();
        })
        .then(card => {
            detailsDiv.innerHTML = `
                <h3>${card.name} (${card.id})</h3>
                <p><strong>Tipo:</strong> ${card.type}</p>
                <p><strong>Descrição:</strong> ${card.description}</p>
            `;
        })
        .catch(error => {
            detailsDiv.innerHTML = `<p style="color: red;">${error.message}</p>`;
        });
}

function updateCard() {
    const id = document.getElementById('updateId').value.trim();
    const name = document.getElementById('updateName').value.trim();
    const type = document.getElementById('updateType').value.trim();
    const description = document.getElementById('updateDescription').value.trim();

    if (!id || !name || !type || !description) {
        alert('Por favor, preencha todos os campos para atualizar.');
        return;
    }

    const cardData = {
        id: id,
        name: name,
        type: type,
        description: description
    };

    fetch(`http://localhost:8080/cards/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(cardData)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Falha ao atualizar o card.');
        }
        return response.json();
    })
    .then(updatedCard => {
        alert(`Card ${updatedCard.name} atualizado com sucesso!`);
        document.getElementById('updateId').value = '';
        document.getElementById('updateName').value = '';
        document.getElementById('updateType').value = '';
        document.getElementById('updateDescription').value = '';
    })
    .catch(error => {
        alert(error.message);
    });
}

