<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
    <title>Liste des CDs</title>
</head>
<body>
<h1>Liste des CDs</h1>

<h:form>
    <h:dataTable value="#{cdController.cdList}" var="cd">
        <h:column>
            <f:facet name="header">Titre</f:facet>
            #{cd.title}
        </h:column>
        <h:column>
            <f:facet name="header">Artiste</f:facet>
            #{cd.artist}
        </h:column>
        <h:column>
            <f:facet name="header">Année</f:facet>
            #{cd.year}
        </h:column>
        <h:column>
            <f:facet name="header">Action</f:facet>
            <h:commandButton value="Emprunter" action="#{cdController.borrow(cd)}" />
        </h:column>
    </h:dataTable>
</h:form>

</body>
</html>
