<%@ page import="com.example.taxes.model.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.taxes.model.ProductRepository" %>
<%@ page import="java.math.BigDecimal" %>
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
    <link rel="stylesheet" href="styles/modal.css">
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
                        <form:form action="/delete" method="post" modelAttribute="newproduct">
                            <form:input path="id" type="hidden" value="<%=p.getId()%>" />
                            <button type="submit" class="button red">delete</button>
                        </form:form>
                    </td>
                </tr>
            <% } %>
        </tbody>
    </table>
    <button class="button blue mobile calculate" id="calculate">Calculate Taxes</button>
    <div class="modal" id="modal">
        <div class="modal-content">
            <header class="modal-header">
                <h2>Results</h2>
                <span class="modal-close" id="modalClose">&#10006;</span>
            </header>
            <table class="records">
                <thead>
                <tr>
                    <th>Product</th>
                    <th>Imported</th>
                    <th>Price With Taxes</th>
                </tr>
                </thead>
                <tbody>
                <% for (Product p: ((ArrayList<Product>) session.getAttribute("products"))){ %>
                <tr>
                    <td><%=p.getName()%></td>
                    <% if(p.getImported() == true) { %>
                        <td>Yes</td>
                    <% } else if(p.getImported() == false) { %>
                        <td>No</td>
                    <% } %>
                    <td>€ <%=p.getPriceWithTaxes()%></td>
                </tr>
                <% } %>
                <tr>
                    <td></td>
                    <td>Total</td>
                    <td>
                        <%
                            BigDecimal total = ProductRepository.getInstance().calculateTotalTaxes();
                        %>
                        <%=total%>
                    </td>
                </tr>
                </tbody>
            </table>
            <footer class="modal-footer">
                <button class="button">New</button>
            </footer>
        </div>
    </div>
    <script type="text/javascript" src="main.js"></script>
</main>
</body>
</html>