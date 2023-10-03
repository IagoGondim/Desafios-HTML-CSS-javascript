function carregarImagens() {
    var listaImagens = document.getElementById("listaImagens");
    listaImagens.innerHTML = ''; // Limpa a lista de imagens antes de adicionar novas

    fetch('https://api.thecatapi.com/v1/images/search?limit=10')
        .then(response => response.json())
        .then(data => {
            data.forEach(cat => {
                var imagem = document.createElement("img");
                imagem.src = cat.url;
                imagem.alt = "Imagem de Gato";

                var listItem = document.createElement("li");
                listItem.appendChild(imagem);
                listaImagens.appendChild(listItem);
            });
        })
        .catch(error => {
            console.error('Erro ao carregar as imagens de gato:', error);
        });
}

carregarImagens();