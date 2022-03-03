<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>cadastre-se</title>

<style>

*{

    box-sizing: border-box;
    padding: 0;
    margin: 0;
    font-family: Verdana, Geneva, Tahoma, sans-serif;
}



.titulo{

    margin-top: 13px;
    text-align: center;
    color:darkslateblue;
    font-family: Verdana, Geneva, Tahoma, sans-serif;
    font-size: 30px
}


.label2{

    margin-bottom: 10px;
}

.linha{

    margin: 12px auto;
    height: 3px;
    background-color: darkblue;
    border-radius: 15px;
    width: 60%;
}

.linha:hover{

    background-color: blue;
}

.bloco{

    align-items: center;
     display: flex;
    flex-direction: column;
}

input{
    
    padding: 4px;
    outline: none;
    margin-bottom: 12px;
    margin-top: 12px;
    width: 50%;
    border-radius: 7px;
    border: 1px solid darkslateblue;
}

.btn{

    border-radius: 10px;
    outline: none;
    background-color: darkslateblue;
    border: none;
    width: 50%;
    padding:8px;
    color: white;
}


.btn:hover{

    background-color: royalblue;
    cursor: pointer;
}

.rodape h3{

    margin-bottom: 12px;
    text-align: center;
    color: white;
}

label{

    text-align: left;
    font-weight: bold;
    color: darkslateblue;
}


.rodape{

    text-align: center;
    margin-top: 12px;
    padding: 7px;
    background-color: darkslateblue;
}

.rodape a{

    text-decoration: none;
    color: white;
    text-align: center;
}

select{

    outline: none;
    margin-bottom: 20px;
}

.rodape a:hover{


    color: blue;
}


.borda{

    border-radius: 10px;
    margin: auto;
    width: 45%;
    border: 2px solid royalblue;
}

body{

    background-image: url();
}

</style>

</head>
<body>

        <div class="borda">

            <h3 class="titulo">Company DJH</h3>

            <div class="linha"></div>

            <form class="bloco" action="sucesso" method="post">
            
            <input value="${pessoas.id }" type="hidden">

               <label>Nome:</label>
                <input  type="text" name="nome" id="nome" placeholder="Ex: joao" required value="${pessoas.nome }">
                <label>Endereço</label>
                <input type="text" name="endereco" placeholder="Ex: Av. Paulista" required value="${pessoas.endereco }">
                <label>E-mail</label>
                <input type="email" name="email" placeholder="Ex: Joao@gmail.com" required value="${pessoas.email }">
               
                <label>Data De Nascimento</label>
                <input type="date" name="nascimento" required="required"  value="<fmt:formatDate pattern="yyyy-MM-dd"
						value="${pessoas.nascimento.time }"/>">
                
                <label>Telefone</label>
                <input type="text" name="telefone" placeholder="Ex: (11) 4148-2010" required value="${pessoas.telefone }">
                
                <label>Informe O Produto de Interesse</label>
                <input type="text" name="tipoProduto" placeholder="Ex : Bolacha" required="required" value="${pessoas.tipoProduto }">

                <label class="label2">Genêro</label>

                <select required name="genero">

                    <option value="m">Masculino</option>
                    <option value="f">Feminino</option>
               

                </select>

                
           

                <button class="btn" type="submit">Enviar</button>
                

            </form>

            <footer class="rodape">


                <h3>Ainda Não Tem Conta ?</h3>

                <a href="#nome">Cadastre-se</a>
            </footer>

        </div>

    
</body>
</html>