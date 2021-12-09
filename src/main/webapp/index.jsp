<%@ page import="com.example.taxes.model.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Karla:ital,wght@0,400;0,700;1,200;1,800&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="styles/main.css">
    <title>Taxes Calculator</title>
</head>
<body>
<header>
    <h1>Taxes Calculator</h1>
</header>
<main>
    <form:form cssClass="addnew" action="addnew" method="post" modelAttribute="newproduct">
        <form:input cssClass="field" path="name" type="text" required="true" placeholder="Product name"/>
        <form:input cssClass="field" path="price" type="number" required="true" placeholder="Price" step=".01" min="0"/>

        <form:label path="imported">Imported</form:label>
        <form:checkbox cssClass="field" path="imported"/>

        <input type="submit" class="button blue mobile" value="Add New Product" />
    </form:form>
    <table class="records">
        <thead>
            <tr>
                <th>Product</th>
                <th>Price</th>
                <th>Imported</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <% for (Product p: ((ArrayList<Product>) session.getAttribute("products"))){ %>
                <tr>
                    <td><%=p.getName()%></td>
                    <td>€ <%=p.getPrice()%></td>
                    <% if(p.getImported() == true) { %>
                        <td>Yes</td>
                    <% } else if(p.getImported() == false) { %>
                        <td>No</td>
                    <% } %>
                    <td>
                        <button type="button" class="button green">edit</button>
                        <button type="button" class="button red">delete</button>
                    </td>
                </tr>
            <% } %>
        </tbody>
    </table>
</main>
</body>
</html>