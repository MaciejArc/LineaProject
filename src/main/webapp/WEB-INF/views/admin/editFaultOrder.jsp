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
                            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Edytuj usterkę</h3>
                            <form:form modelAttribute="faultOrder">

                                <div class="row">
                                    <div class="col-md-6 mb-4">

                                        <div class="form-outline">
                                            Zgłaszający
                                            <h4>${faultOrder.client.fullName}</h4>
                                        </div>

                                    </div>
                                    <div class="col-md-6 mb-4">

                                        <div class="form-outline">
                                            Adres
                                            <h4>${faultOrder.address.fullAddress}</h4>
                                        </div>

                                    </div>

                                </div>
                                <div class="row">
                                    <div class="col-lg-12 mb-4">

                                        <div class="form-outline">
                                            Opis usterki:
                                            <h4>${faultOrder.description}</h4>

                                        </div>

                                    </div>


                                </div>

                                <div class="row">
                                    <div class="col-md-6 mb-4 pb-2">

                                        <div class="form-outline">
                                            <label class="form-label" for="user">Wykonawca</label> <form:select path="user" items="${workers}" itemLabel="fullName" itemValue="id"
                                                         cssClass="form-control form-control-lg" cssStyle="font-size: 0.9rem"/><form:errors
                                                path="user"/>

                                        </div>
                                    </div>
                                    <div class="col-md-6 mb-4 pb-2">

                                        <div class="form-outline">
                                            <label class="form-label" for="user">Status</label> <form:input path="status"
                                                           cssClass="form-control form-control-lg"/><form:errors
                                                path="status"/>

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