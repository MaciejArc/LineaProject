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
        <h2>Lista usterek:</h2>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Opis usterki</th>
                <th scope="col">Data zgłoszenia</th>
                <th scope="col">Zgłaszający</th>
                <th scope="col">Adres</th>
                <th scope="col">Status</th>
                <th scope="col">Wykonawca</th>
                <th scope="col">Akcja</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${faultOrders}" var="faultOrder" varStatus="count">
                <tr>

                    <td>${count.count}</td>
                    <td>${faultOrder.description}</td>
                    <td>${faultOrder.pickUpDate}</td>
                    <td><a href="https://linea-project.herokuapp.com/admin/userInfo?id=${faultOrder.client.id}">${faultOrder.client.fullName}</a></td>
                    <td>${faultOrder.address.fullAddress}</td>
                    <td class="status">${faultOrder.status}</td>
                    <td><a href="https://linea-project.herokuapp.com/admin/userInfo?id=${faultOrder.user.id}">${faultOrder.user.fullName}</a> </td>
                    <td><a href="https://linea-project.herokuapp.com/admin/editFaultOrder?id=${faultOrder.id}">Edytuj</a></td>
                </tr>

            </c:forEach>

            </tbody>
        </table>

    </section>
</div>
</div>
<!-- End of Main Content -->

<%@ include file="footer.jsp" %>