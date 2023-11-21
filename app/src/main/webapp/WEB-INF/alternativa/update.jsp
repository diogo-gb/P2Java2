<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>Editar alternativa</title>
</head>
<body>
    <div class="container">
        <h1>Editar alternativa</h1>
        <form action="/Alternativa/update" method="post">
            <input type="hidden" name="id" value="${Alternativa.id}">
            <div class="form-group">
                <label for="Enunciado">Enunciado:</label>
                <input type="text" name="nome" class="form-control" value="${Alternativa.Enunciado}"/>
            </div>
            <br>
            <a href="/Alternativa/list" class="btn btn-primary">Voltar</a>
            <button type="submit" class="btn btn-sucess">Salvar</button>
        </form>
    </div>
</body>
</html>