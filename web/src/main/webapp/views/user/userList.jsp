<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
    <title>Liste des Utilisateurs</title>
</head>
<body>
<h1>Liste des Utilisateurs</h1>

<h:form>
    <h:dataTable value="#{userController.userList}" var="user">
        <h:column>
            <f:facet name="header">Nom</f:facet>
            #{user.name}
        </h:column>
        <h:column>
            <f:facet name="header">Email</f:facet>
            #{user.email}
        </h:column>
        <h:column>
            <f:facet name="header">Action</f:facet>
            <h:commandButton value="Supprimer" action="#{userController.delete(user)}" />
        </h:column>
    </h:dataTable>
</h:form>

</body>
</html>
