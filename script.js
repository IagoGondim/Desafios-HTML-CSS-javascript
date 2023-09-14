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
