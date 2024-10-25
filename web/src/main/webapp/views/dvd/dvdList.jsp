<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
    <title>Liste des DVDs</title>
</head>
<body>
<h1>Liste des DVDs</h1>

<h:form>
    <h:dataTable value="#{dvdController.dvdList}" var="dvd">
        <h:column>
            <f:facet name="header">Titre</f:facet>
            #{dvd.title}
        </h:column>
        <h:column>
            <f:facet name="header">Réalisateur</f:facet>
            #{dvd.director}
        </h:column>
        <h:column>
            <f:facet name="header">Année</f:facet>
            #{dvd.year}
        </h:column>
        <h:column>
            <f:facet name="header">Action</f:facet>
            <h:commandButton value="Emprunter" action="#{dvdController.borrow(dvd)}" />
        </h:column>
    </h:dataTable>
</h:form>

</body>
</html>
