<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        
        <title>Все сотрудники</title>
        
    </head>
    <body>
        <h3>Информация обо всех сотрудниках</h3>
        <br><br>

        <security:authorize access="hasRole('HR')">
            <input type="button" value="Зарплаты" onclick="window.location.href = 'hrinfo'">
            Для HR-специалистов
            <br><br>
        </security:authorize>

        <security:authorize access="hasRole('MANAGER')">
            <input type="button" value="Продуктивность сотрудников" onclick="window.location.href = 'managerinfo'">
            Только для менеджеров
        </security:authorize>
    </body>
</html>
