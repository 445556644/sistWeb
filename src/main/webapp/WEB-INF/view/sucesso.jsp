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
body{
background-color: maroon;
}


.tabela {
	background-color: cyan;
	text-align: center;
	margin:auto;
	width:80%;
}
tr{
background-color: cyan;

}
th{
background-color: black;
color:white;
}

.estatisticas{
	background-color: white;
	color:black;
	margin:auto;
	text-align:center;
	width:60%;

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


				<td><a href="excluirPessoa?idPessoa=${p.id }"
					onclick="return confirm('deseja excluir?')">Excluir</a></td>
			</tr>
		</c:forEach>

	</table>
	
	<div class="estatistica">
	<p></p>
	<p></p>
	<p></p>
	
	</div>

</body>
</html>