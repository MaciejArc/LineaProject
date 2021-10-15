<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>
<div class="container-fluid">
    <section class="vh-100 gradient-custom">
        <div class="container py-5 h-100">
            <div class="row justify-content-center align-items-center h-100">
                <div class="col-12 col-lg-9 col-xl-7">
                    <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                        <div class="card-body p-4 p-md-5">
                            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Registration Form</h3>
                            <form:form modelAttribute="user">

                                <div class="row">
                                    <div class="col-md-6 mb-4">

                                        <div class="form-outline">
                                            <form:input path="firstName"
                                                        cssClass="form-control form-control-lg"/><form:errors
                                                path="firstName"/>
                                            <label class="form-label" for="firstName">Imię</label>
                                        </div>

                                    </div>
                                    <div class="col-md-6 mb-4">

                                        <div class="form-outline">
                                            <form:input path="lastName"
                                                        cssClass="form-control form-control-lg"/><form:errors
                                                path="lastName"/>
                                            <label class="form-label" for="firstName">Nazwisko</label>
                                        </div>

                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-6 mb-4 pb-2">

                                        <div class="form-outline">
                                            <form:input path="email"
                                                        cssClass="form-control form-control-lg"/><form:errors
                                                path="email"/>
                                                ${error}
                                            <label class="form-label" for="firstName">Email</label>
                                        </div>

                                    </div>
                                    <div class="col-md-6 mb-4 pb-2">

                                        <div class="form-outline">
                                            <form:input path="phone"
                                                        cssClass="form-control form-control-lg"/><form:errors
                                                path="phone"/>
                                            <label class="form-label" for="firstName">Telefon</label>
                                        </div>

                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6 mb-4 pb-2">

                                        <div class="form-outline">
                                            <form:password path="password"
                                                           cssClass="form-control form-control-lg"/><form:errors
                                                path="password"/>
                                            <label class="form-label" for="firstName">Hasło</label>
                                        </div>
                                    </div>
                                    <div class="form-outline">
                                        <div class="form-outline">
                                            <form:select items="${company}" path="company" itemValue="id"
                                                         itemLabel="name" cssClass="form-control form-control-lg"/>
                                            <form:errors path="company"/>
                                            <label class="form-label" for="firstName">Firma</label>
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
</div>
<!-- End of Main Content -->

<%@ include file="footer.jsp" %>