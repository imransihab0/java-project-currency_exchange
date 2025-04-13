<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*, javax.servlet.*, javax.servlet.http.*" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f0f0f0; color: #333; }
        table { width: 80%; margin: 20px auto; border-collapse: collapse; background-color: white; }
        th, td { padding: 12px 15px; text-align: left; border-bottom: 1px solid #ddd; }
        th { background-color: #007BFF; color: white; }
        .home-button { display: block; width: 150px; margin: 20px auto; padding: 10px; text-align: center; background-color: #28a745; color: white; border: none; border-radius: 5px; cursor: pointer; text-decoration: none; font-size: 16px; }
        .home-button:hover { background-color: #218838; }
    </style>
</head>
<body>

<h1 style="text-align: center;">Exchange Rates</h1>

<table>
    <tr>
        <th>Currency Code</th>
        <th>Rate to BDT</th>
    </tr>
    
    <% 
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM exchange_rates";
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                String currencyCode = rs.getString("currency_code");
                double rateToBdt = rs.getDouble("rate_to_bdt");
    %>
    
    <tr>
        <td><%= currencyCode %></td>
        <td><%= rateToBdt %></td>
    </tr>

    <% 
            }
            conn.close();
        } catch (SQLException e) {
    %>
        <tr>
            <td colspan="2">Error: <%= e.getMessage() %></td>
        </tr>
    <% 
        }
    %>
</table>

<a href="index.jsp" class="home-button">Home</a>

</body>
</html>
