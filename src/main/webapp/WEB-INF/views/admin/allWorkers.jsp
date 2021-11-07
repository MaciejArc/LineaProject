<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<div class="container-fluid">
    <section>
        <a href="https://linea-project.herokuapp.com/admin/addWorker">
            <button type="button" class="btn btn-primary btn-lg">Dodaj pracownika</button>
        </a>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Imię i Nazwisko</th>
                <th scope="col">Telefon</th>
                <th scope="col">Email</th>
                <th scope="col">Firma</th>
                <th scope="col">Akcja</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${workers}" var="worker" varStatus="count">
                <tr>

                    <td>${count.count}</td>
                    <td>${worker.fullName}</td>
                    <td>${worker.phone}</td>
                    <td>${worker.email}</td>
                    <td>${worker.company.name}</td>
                    <td>Edytuj Usuń</td>
                </tr>

            </c:forEach>

            </tbody>
        </table>


    </section>
</div>
</div>
<!-- End of Main Content -->

<%@ include file="footer.jsp" %>