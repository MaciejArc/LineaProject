<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>"/>
    <title>Linea Project</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="http://localhost:8080">Linea</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="https://linea-project.herokuapp.com/about">O projekcie</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="https://linea-project.herokuapp.com/instruction">Instrukcja</a>
                </li>


            </ul>


            <div class="col-md-3 text-end">
                <a href="https://linea-project.herokuapp.com/login">
                    <button type="button" class="btn btn-outline-primary me-2">Logowanie</button>
                </a>

                <a href="https://linea-project.herokuapp.com/register">
                    <button type="button" class="btn btn-primary">Rejestracja</button>
                </a>
            </div>


        </div>
    </div>
</nav>

<div class="container" style="text-align: center">
    <h2>Linea Project</h2>
    <p>Projekt stworzony na potrzeby pracy zaliczeniowej kursu programowania w CodersLab.<br>
        Projekt w trakcie realizacji!</p>
    <p>Aplikacja umożliwia zgłaszanie usterek przez klientów.<br>
        Przyjmowanie usterek przez administratora, wyznaczasnie pracownika do konkretnego zgłoszenia oraz zarządzanie
        statusem usterki.</p>

    <p>
        Cel:<br>
        Celem aplikacj jest usystematyzowanie procesu związanego z usterkami. Stworzenie miejsca w którym osoby
        upoważnione mają dostęp do wszystkich zgłoszonych usterek, informacji na temat etapu ich realizacji(zgłoszone/w
        trakcie realizacji/zrealizowane).
    </p>
    <p>Funkcje aplikacji:</p>
    <p>Klient:<br>
        -Rejestracja<br>
        -Logowanie<br>
        -Adres zamieszkania(dodawanie/edycja)<br>
        -Usterki(dodawanie/edycja/kontrola statusu zgłoszenia)</p>
    <p>
        Administrator:<br>
        -Rejestracja<br>
        -Logowanie<br>
        -Firmy(dodawanie/edycja)<br>
        -Pracownicy(dodawanie/edycja)<br>
        -Usterki(lista wszystkich usterek/przydzielanie pracowników do usterek/kontrola wykonania usterek)<br>
        -Dostęp do danych klientów(adresy/dane kontaktowe)<br>
    </p>
    <p>Pracownik:<br>
        -Rejestracja<br>
        -Logowanie<br>
        -Usterki(lista przydzielonych usterek/edycja statusu usterki)</p>
</div>
<!-- Optional JavaScript; choose one of the two! -->

<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

<!-- Option 2: Separate Popper and Bootstrap JS -->
<!--
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
-->
</body>
</html>