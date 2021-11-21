<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp"%>

<div class="container">

   <h2>Lista usterek:</h2>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Opis usterki</th>
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
                <td>${faultOrder.address.fullAddress}</td>
                <td>${faultOrder.status}</td>
                <td>${faultOrder.user.fullName}</td>
                <td><a href="https://linea-project.herokuapp.com/user/addFaultOrder?id=${faultOrder.id}">Edytuj</a></td>
            </tr>

        </c:forEach>

        </tbody>
    </table>
</div>

<%@ include file="footer.jsp"%>


