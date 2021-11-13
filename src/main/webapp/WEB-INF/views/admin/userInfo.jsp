<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<div class="container-fluid">
    <section>

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

                <tr>

                    <td>1</td>
                    <td>${user.fullName}</td>
                    <td>${user.phone}</td>
                    <td>${user.email}</td>
                    <td>${user.company.name}</td>
                    <td><a href="https://linea-project.herokuapp.com/admin/editWorker?id=${user.id}" >Edytuj</a> Usuń</td>
                </tr>

            </tbody>
        </table>


    </section>
</div>
</div>
<!-- End of Main Content -->

<%@ include file="footer.jsp" %>