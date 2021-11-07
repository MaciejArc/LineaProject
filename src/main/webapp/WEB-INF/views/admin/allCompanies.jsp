<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<div class="container-fluid">
    <section>
        <a href="https://linea-project.herokuapp.com/admin/addCompany?id=">
            <button type="button" class="btn btn-primary btn-lg">Dodaj firmę</button>
        </a>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Nazwa</th>
                <th scope="col">NIP</th>
                <th scope="col">Telefon</th>
                <th scope="col">Właściciel</th>
                <th scope="col">Akcja</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${companies}" var="company" varStatus="count">
                <tr>

                    <td>${count.count}</td>
                    <td>${company.name}</td>
                    <td>${company.nip}</td>
                    <td>${company.phone}</td>
                    <td>${company.owner.fullName}</td>
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