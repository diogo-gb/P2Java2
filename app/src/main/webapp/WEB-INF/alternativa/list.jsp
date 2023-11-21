<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>Alternativas</title>
</head>
<body>
    <div class="container">
        <h1>Alternativas</h1>

        <a href="/Alternativa/insert" class="btn btn-primary">Nova alternativa</a>

        <table class="table">
            <tr>
                <th>Id</th>
                <th>Texto</th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach var="item" items="${Texto}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.Texto}</td>
                   <td>
                       <a href="Alternativa/update?id=${item.id}" class="btn btn-warning">Editar</a>
                       <a href="Alternativa/delete?id=${item.id}" class="btn btn-danger">Excluir</a>
                   </td>  
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>