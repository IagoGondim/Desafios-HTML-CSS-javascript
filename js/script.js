

function initDropdownMenu() {
    const dropdownMenus = document.querySelectorAll('[data-dropdown]');
    dropdownMenus.forEach(menu => {
      ['touchstart', 'click'].forEach(userEvent => {
        menu.addEventListener(userEvent, handleClick);
      });
    });
  
    function handleClick(event) {
      event.preventDefault();
      this.classList.add('active');
      outsideClick(this, ['touchstart', 'click'], () => {
        this.classList.remove('active');
    });
  };
}

function verificarIdade() {
  var idade = parseInt(document.getElementById("idade").value);

  if (idade >= 18) {
    document.getElementById("resultado").innerText = "Você é maior de idade.";
    } else {
    document.getElementById("resultado").innerText = "Você é menor de idade.";
  }
}

function calcularMedia() {

  var nota1 = parseFloat(document.getElementById("nota1").value);
  var nota2 = parseFloat(document.getElementById("nota2").value);
  var nota3 = parseFloat(document.getElementById("nota3").value);
  var frequencia = parseFloat(document.getElementById("frequencia").value);

  var media = (nota1 + nota2 + nota3) / 3;

  if (media >= 6 && frequencia >= 75) {
    document.getElementById("resultado").innerText = "Aluno aprovado";
    } else if (media >= 4 && frequencia >= 75) {
    document.getElementById("resultado").innerText = "Aluno em Recuperação";
    } else {
    document.getElementById("resultado").innerText = "Aluno reprovado";
  }
}

function calcularIMC() {
  var peso = parseFloat(document.getElementById("peso").value);
  var altura = parseFloat(document.getElementById("altura").value);

  var alturaQuadrado = altura * altura;
  imc = peso / alturaQuadrado;

  document.getElementById("imc").innerText = "Seu IMC é: " + imc.toFixed(2);

  if (imc > 40) {
			document.getElementById("resultado").innerText = "Obesidade III";
		} else if (imc >= 35) {
			document.getElementById("resultado").innerText =  "Obesidade II";
		} else if (imc >= 30) {
			document.getElementById("resultado").innerText = "Obesidade I";
		} else if (imc >= 25) {
			document.getElementById("resultado").innerText = "Acima do peso";
		} else if (imc >= 18.5) {
			document.getElementById("resultado").innerText = "Peso normal";
		} else if (imc >= 17) {
			document.getElementById("resultado").innerText = "Abaixo do peso";
		} else {
			document.getElementById("resultado").innerText = "Muito abaixo do peso";
		}
}

function calcularSalario() {
  var select = document.getElementById('cargo');
  var cargo = select.options[select.selectedIndex].text;
  var salario = parseFloat(document.getElementById("salario").value);

  if (cargo == "Gerente") {
			aumento = salario * 0.05;
		} else if (cargo == "Supervisor") {
			aumento = salario * 0.08;
		} else if (cargo == "Operador") {
			aumento = salario * 0.09;
		} else {
			aumento = salario * 0.01;
		}
		novoSalario = salario + aumento;

    document.getElementById("salarioAtual").innerText = "Sálario atual: R$"  + salario.toFixed(2);
    document.getElementById("aumento").innerText = "Aumento foi de: R$" + aumento.toFixed(2);
    document.getElementById("salarioAtualizado").innerText = "Sálario atualizado: R$" +  novoSalario.toFixed(2);
}

  var frutas = [];

function adicionarFruta() {
    var frutaInput = document.getElementById("fruta");
    var fruta = frutaInput.value.trim();

    if (fruta === "") {
        alert("Digite o nome da fruta");
        return;
    } 

    frutas.push(fruta);

    frutaInput.value = "";

    atualizarLista();
}

function atualizarLista() {
    var listaFrutas = document.getElementById("listaFrutas");
    listaFrutas.innerHTML = "";

    for (var i = 0; i < frutas.length; i++) {
        var li = document.createElement("li");
        li.textContent = frutas[i];
        listaFrutas.appendChild(li);
    }
}

var contatos = [];

function adicionarContato(event) {
    event.preventDefault();

    var nome = document.getElementById("nome").value;
    var email = document.getElementById("email").value;
    var telefone = document.getElementById("telefone").value;

    var contato = { nome, email, telefone };
    contatos.push(contato);

    atualizarTabela();

    document.getElementById("nome").value = "";
    document.getElementById("email").value = "";
    document.getElementById("telefone").value = "";
}

function atualizarTabela() {
    var tabela = document.getElementById("tabelaContatos");
    tabela.innerHTML = `
        <tr>
            <th>Nome</th>
            <th>Email</th>
            <th>Telefone</th>
            <th>Ações</th>
        </tr>
    `;

    for (var i = 0; i < contatos.length; i++) {
        var contato = contatos[i];
        var tr = document.createElement("tr");
        tr.innerHTML = `
            <td>${contato.nome}</td>
            <td>${contato.email}</td>
            <td>${contato.telefone}</td>
            <td>
                <button onclick="editarContato(${i})">Editar</button>
                <button onclick="excluirContato(${i})">Excluir</button>
            </td>
        `;
        tabela.appendChild(tr);
    }
}

function editarContato(index) {
    var contato = contatos[index];
    var nome = prompt("Novo nome:", contato.nome);
    var email = prompt("Novo email:", contato.email);
    var telefone = prompt("Novo telefone:", contato.telefone);

    if (nome !== null && email !== null && telefone !== null) {
        contatos[index] = { nome, email, telefone };
        atualizarTabela();
    }
}

function excluirContato(index) {
    if (confirm("Tem certeza de que deseja excluir este contato?")) {
        contatos.splice(index, 1);
        atualizarTabela();
    }
}

var formContato = document.getElementById("formContato");
formContato.addEventListener("submit", adicionarContato);

atualizarTabela();

function carregarImagem() {
    var catCard = document.getElementById("catCard");
    catCard.innerHTML = '<p>Carregando imagem...</p>';

    fetch('https://api.thecatapi.com/v1/images/search')
        .then(response => response.json())
        .then(data => {
            if (data.length > 0 && data[0].url) {
                var imageUrl = data[0].url;
                catCard.innerHTML = `
                    <img src="${imageUrl}" alt="Imagem de Gato">
                `;
            } else {
                catCard.innerHTML = '<p>Não foi possível carregar a imagem de gato.</p>';
            }
        })
        .catch(error => {
            console.error('Erro ao carregar a imagem de gato:', error);
            catCard.innerHTML = '<p>Erro ao carregar a imagem de gato.</p>';
        });
}

