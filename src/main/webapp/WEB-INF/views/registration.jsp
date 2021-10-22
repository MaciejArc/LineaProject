<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>"/>
    <title>Line Project</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="http://localhost:8080">Linea</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">O projekcie</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Instrukcja</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link"  href="#">
                        O mnie
                    </a>
                </li>

            </ul>


            <div class="col-md-3 text-end">
                <a href="https://linea-project.herokuapp.com/login"><button type="button" class="btn btn-outline-primary me-2">Logowanie</button></a>

                <a href="https://linea-project.herokuapp.com/register"><button type="button" class="btn btn-primary">Rejestracja</button></a>
            </div>


        </div>
    </div>
</nav>

<div class="container">
    <section class="vh-100 gradient-custom">
        <div class="container py-5 h-100">
            <div class="row justify-content-center align-items-center h-100">
                <div class="col-12 col-lg-9 col-xl-7">
                    <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                        <div class="card-body p-4 p-md-5">
                            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Registration Form</h3>
                            <form:form modelAttribute="user" >

                                <div class="row">
                                    <div class="col-md-6 mb-4">

                                        <div class="form-outline">
                                            <form:input path="firstName" cssClass="form-control form-control-lg"/>
                                            <p><form:errors path="firstName"/></p>
                                            <label class="form-label" for="firstName">Imię</label>
                                        </div>

                                    </div>
                                    <div class="col-md-6 mb-4">

                                        <div class="form-outline">
                                            <form:input path="lastName" cssClass="form-control form-control-lg"/>
                                            <p><form:errors path="lastName"/></p>
                                            <label class="form-label" for="firstName">Nazwisko</label>
                                        </div>

                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-6 mb-4 pb-2">

                                        <div class="form-outline">
                                            <form:input path="email" cssClass="form-control form-control-lg"/>
                                           <p><form:errors path="email"/></p>
                                            <label class="form-label" for="firstName">Email</label>
                                        </div>

                                    </div>
                                    <div class="col-md-6 mb-4 pb-2">

                                        <div class="form-outline">
                                            <form:input path="phone" cssClass="form-control form-control-lg"/>
                                            <p><form:errors path="phone"/></p>
                                            <label class="form-label" for="firstName">Telefon</label>
                                        </div>

                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6 mb-4 pb-2">

                                        <div class="form-outline">
                                            <form:password path="password" cssClass="form-control form-control-lg"/>
                                            <p><form:errors path="password"/></p>
                                            <label class="form-label" for="firstName">Hasło</label>
                                        </div>

                                    </div>
                                </div>

                                <div class="mt-4 pt-2">
                                    <input class="btn btn-primary btn-lg" type="submit" value="Wyślij" />
                                </div>

                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
<!-- Optional JavaScript; choose one of the two! -->

<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

<!-- Option 2: Separate Popper and Bootstrap JS -->
<!--
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
-->
</body>
</html>