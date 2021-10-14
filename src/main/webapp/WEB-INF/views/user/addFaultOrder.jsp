<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>
<div class="container" style="height: 1000px">


    <section class="vh-100 gradient-custom">
        <div class="container py-5 h-100">
            <div class="row justify-content-center align-items-center h-100">
                <div class="col-12 col-lg-9 col-xl-7">
                    <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                        <div class="card-body p-4 p-md-5">
                            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Zgłoś usterkę</h3>
                            <form:form modelAttribute="faultOrder">

                                <div class="row">
                                    <div class="col-md-6 mb-4">

                                        <div class="form-outline">
                                            <form:input path="description"
                                                        cssClass="form-control form-control-lg"/><form:errors
                                                path="description"/>
                                            <label class="form-label" for="description">Opis usterki</label>
                                        </div>

                                    </div>


                                </div>

                                <div class="row">
                                    <div class="col-md-6 mb-4 pb-2">

                                        <div class="form-outline">
                                            <form:select path="address" items="${addresses}" itemLabel="fullAddress" itemValue="id"
                                                        cssClass="form-control form-control-lg"/><form:errors
                                                path="address"/>
                                            <label class="form-label" for="address">Adres</label>
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