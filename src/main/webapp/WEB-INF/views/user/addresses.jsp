<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>
<div class="container" style="height: 1000px">
<section>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Ulica</th>
            <th scope="col">Nr domu</th>
            <th scope="col">Kod pocztowy</th>
            <th scope="col">Miasto</th>
            <th scope="col">Typ mieszkania</th>
            <th scope="col">Akcja</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${addresses}" var="address">
            <tr>
                <th scope="row"></th>
                <td>${address.street}</td>
                <td>${address.houseNumber}</td>
                <td>${address.zipCode}</td>
                <td>${address.city}</td>
                <td>${address.typeOfHouse}</td>
                <td>Edytuj Usuń</td>
            </tr>

        </c:forEach>

        </tbody>
    </table>


</section>

    <section class="vh-100 gradient-custom">
        <div class="container py-5 h-100">
            <div class="row justify-content-center align-items-center h-100">
                <div class="col-12 col-lg-9 col-xl-7">
                    <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                        <div class="card-body p-4 p-md-5">
                            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Dodaj nowy adres</h3>
                            <form:form modelAttribute="address">

                                <div class="row">
                                    <div class="col-md-6 mb-4">

                                        <div class="form-outline">
                                            <form:input path="street"
                                                        cssClass="form-control form-control-lg"/><form:errors
                                                path="street"/>
                                            <label class="form-label" for="street">Ulica</label>
                                        </div>

                                    </div>
                                    <div class="col-md-6 mb-4">

                                        <div class="form-outline">
                                            <form:input path="houseNumber"
                                                        cssClass="form-control form-control-lg"/><form:errors
                                                path="houseNumber"/>
                                            <label class="form-label" for="houseNumber">Nr domu</label>
                                        </div>

                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-6 mb-4 pb-2">

                                        <div class="form-outline">
                                            <form:input path="zipCode"
                                                        cssClass="form-control form-control-lg"/><form:errors
                                                path="zipCode"/>
                                            <label class="form-label" for="zipCode">Kod pocztowy(xx-xxx)</label>
                                        </div>

                                    </div>
                                    <div class="col-md-6 mb-4 pb-2">

                                        <div class="form-outline">
                                            <form:input path="city"
                                                        cssClass="form-control form-control-lg"/><form:errors
                                                path="city"/>
                                            <label class="form-label" for="city">Miasto</label>
                                        </div>

                                    </div>

                                </div>
                                <div class="row">

                                    <div class="col-md-6 mb-4 pb-2">

                                    <div class="form-outline">
                                        <form:input path="typeOfHouse"
                                                    cssClass="form-control form-control-lg"/><form:errors
                                            path="typeOfHouse"/>
                                        <label class="form-label" for="typeOfHouse">Typ mieszkania(opcjonalnie)</label>
                                    </div>

                                </div>
                                </div>

                                <div class="mt-4 pt-2">
                                    <input class="btn btn-primary btn-lg" type="submit" value="Wyślij"/>
                                </div>

                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
<%@ include file="footer.jsp" %>