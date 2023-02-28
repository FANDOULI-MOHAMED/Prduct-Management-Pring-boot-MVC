<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Product</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous"> 
<link rel="stylesheet" href="//use.fontawesome.com/releases/v5.0.7/css/all.css">


<nav class="navbar navbar-expand-lg navbar-light bg-light" style="background-color: #7E909A;">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/ProductController/all">All Products <span class="sr-only">(current)</span></a>
      </li>


     </ul>
  </div>
</nav>   
       

</head>
<body>



<form action="/ProductController/saveup" method="Post" enctype="multipart/form-data">
    <c:forEach items="${prod}" var="p">
    <input type="hidden"  class="form-control" name="id" value="${p.id}">

    <div class="form-group  mx-sm-3 mb-2 col-2">
        <label >nom :</label>
        <input type="text"  class="form-control" name="nom" value="${p.nom}">
    </div>

    <div class="form-group  mx-sm-3 mb-2 col-2">
        <label >prix :</label>
        <input class="form-control" type="text" name="prix" value="${p.prix}">
    </div>

    <div class="form-group  mx-sm-3 mb-2 col-2">
        <label >quantite :</label>
        <input type="text" class="form-control" name="quantite" value="${p.quantite}">
    </div>

        <div class="form-group  mx-sm-3 mb-2 col-2">
            <label >image :</label>
            <img  src="${pageContext.request.contextPath}/uploads/${p.picture}" alt="Default Image">
            <input class="form-control"  type="file" value="${pageContext.request.contextPath}/uploads/${p.picture}" name="files" multiple>



        </div>

    <div class="form-group  mx-sm-3 mb-2 col-2">
        <label >categorie :</label>
        <select name="cat" class="form-control">

            <option selected>${""}</option>
           <c:forEach items="${categories}" var="c">

                <option   value="${c.id}">${c.nom}</option>
            </c:forEach>
        </select>
    </div>
    </c:forEach>
    <button type="submit" class="btn btn-success mx-sm-3 mb-2" >add</button>

</form>
</body>
</html>