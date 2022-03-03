<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro realizado com sucesso</title>

<style>
.tabela {
	border: 3px solid blue;
	text-align: center;
	margin: auto;
	width: 80%;
}

th {
	background-color: black;
	color: white;
	padding: 12px;
	font-family: Verdana, Geneva, Tahoma, sans-serif;
}


a:hover{

color: blue;
}

td {
	font-family: Verdana, Geneva, Tahoma, sans-serif;
	padding: 5px;
}

.tituloEs {
	text-align: center;
}

.estatisticas {
	display: block;
	width: 80%;
	background-color: #a2d2ff;
	text-align: center;
	border-radius: 8px;
	padding: 6px;
	margin: 50px auto;
	text-align: center;
	color: white;
}

.tituloEs {
	text-transform: uppercase;
	font-weight: bold;
	font-size: 45px;
}

h3 {
	margin-right: 5px;
}

a {
	color: black;
	text-decoration: none;
}

h2 {
	font-family: verdana;
	color: black;
}
</style>

</head>
<body>
	<table border="1" class="tabela">
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Tipo de produto</th>
			<th>Endereço</th>
			<th>Email</th>
			<th>Telefone</th>
			<th>genêro</th>
			<th>Data de nascimento</th>
			<th>Dia/hora de cadastro</th>
			<th>Excluir</th>
			<th>Alterar</th>
		</tr>



		<c:forEach items="${pessoa}" var="p">
			<tr>
				<td>${p.id }</td>
				<td>${p.nome }</td>
				<td>${p.tipoProduto}</td>
				<td>${p.endereco}</td>
				<td>${p.email}</td>
				<td>${p.telefone}</td>
				<td>${p.genero}</td>
				
				<td><fmt:formatDate pattern="dd/MM/yyyy"
						value="${p.nascimento.time }" /></td>
						
					<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss"
						value="${p.dataRegistro.time}"/></td>
				<td><a href="excluirPessoa?idPessoa=${p.id }"
					onclick="return confirm('deseja excluir?')">Excluir</a></td>

				<td><a href="alterarPessoa?idPessoa=${p.id }">Alterar</a></td>
			</tr>
		</c:forEach>

	</table>

	<div class="estatisticas">

		<h1 class="tituloEs">Estatisticas</h1>

		<h2>Quantidade De pessoas Cadastradas Por Generos</h2>

		<h3>Feminino: ${generoFem}</h3>
		<h3>Masculino: ${generoMasc}</h3>

		<h2>Quantidade De pessoas Cadastradas Por Faixa Etária</h2>


		<h3>Jovem: ${jovem}</h3>
		<h3>Adulto: ${adulto}</h3>
		<h3>Idoso: ${idoso}</h3>

		<h2>Quantidades de Pessoas cadastradas Por Periodo Do Dia</h2>
		<h3>Cadastros Realizados Durante o Dia : ${dia}</h3>
		<h3>Cadastros Realizados Durante a Tarde: ${tarde}</h3>
		<h3>Cadastros Realizados Durante a Noite : ${noite}</h3>
		
		<h2>Quantidades de Pessoas cadastradas Por Periodo Da Semana</h2>
		<h3>Cadastros Realizados Durante a segunda : ${segunda}</h3>
		<h3>Cadastros Realizados Durante a terca : ${terca}</h3>
		<h3>Cadastros Realizados Durante a quarta : ${quarta}</h3>
		<h3>Cadastros Realizados Durante a quinta : ${quinta}</h3>
		<h3>Cadastros Realizados Durante a sexta : ${sexta}</h3>
		<h3>Cadastros Realizados Durante a sabado : ${sabado}</h3>
		<h3>Cadastros Realizados Durante a domingo : ${domingo}</h3>

	</div>

</body>
</html>