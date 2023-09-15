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

function calcularIMC(){
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

function calcularSalario(){
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