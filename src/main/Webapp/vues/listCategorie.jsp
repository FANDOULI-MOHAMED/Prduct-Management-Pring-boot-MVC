<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

    <meta charset="ISO-8859-1">
    <title>All Products</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="stylesheet" href="//use.fontawesome.com/releases/v5.0.7/css/all.css">

</head>

<body>


<nav class="navbar navbar-expand-lg navbar-light bg-light" style="background-color: #7E909A;">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/ProductController/all">My Products <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/CategorieController/ajouter">Add Category</a>
            </li>

        </ul>
    </div>
</nav>


<div>
    <form class="form-inline my-2 my-lg-0" action="/CategorieController/search" method="Get">
        <input class="form-control mr-sm-2 type="text" placeholder="Search" name="mc">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit" name=act >Search</button>
    </form>
</div>


<table class="table">

    <tr> <th>id</th> <th>nom</th>
    <c:forEach items="${Categories}" var="p">
        <tr><td>${p.id}</td>
            <td>${p.nom}</td>
            <td> <a href="/CategorieController/delete/${p.id}" class="btn btn-danger fa fa-trash" ></a></td>
            <td> <a href="/CategorieController/update/${p.id}" class="btn btn-warning fa fa-edit" ></a></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>