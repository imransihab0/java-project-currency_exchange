import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class AddCurrencyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Add Currency</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f8f9fa; margin: 0; padding: 0; color: #333; }");
        out.println(".container { max-width: 400px; margin: 50px auto; background: white; padding: 30px; border-radius: 10px; box-shadow: 0 4px 10px rgba(0,0,0,0.1); text-align: center; }");
        out.println("h1 { color: #007BFF; margin-bottom: 20px; }");
        out.println("form { display: flex; flex-direction: column; }");
        out.println("input[type='text'], input[type='number'] { padding: 10px; margin: 10px 0; border: 1px solid #ccc; border-radius: 5px; }");
        out.println("input[type='submit'] { padding: 10px; background-color: #007BFF; color: white; border: none; border-radius: 5px; cursor: pointer; }");
        out.println("input[type='submit']:hover { background-color: #0056b3; }");
        out.println(".home-button { display: inline-block; margin-top: 20px; padding: 8px 25px; background-color: #28a745; color: white; text-decoration: none; border-radius: 5px; font-size: 15px; }");
        out.println(".home-button:hover { background-color: #218838; }");
        out.println(".error { color: red; text-align: center; margin-top: 10px; }");
        out.println("</style>");
        out.println("</head><body>");

        out.println("<div class='container'>");
        out.println("<h1>Add New Currency</h1>");
        out.println("<form method='POST'>");
        out.println("Currency Code (e.g. USD): <input type='text' name='currencyCode' required>");
        out.println("Rate to BDT: <input type='number' name='rateToBdt' step='any' required>");
        out.println("<input type='submit' value='Add Currency'>");
        out.println("</form>");
        out.println("<a href='index.jsp' class='home-button'>Home</a>");
        out.println("</div>");

        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currencyCode = request.getParameter("currencyCode").toUpperCase();
        double rateToBdt = Double.parseDouble(request.getParameter("rateToBdt"));
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try (Connection conn = DBConnection.getConnection()) {

            // Check if currency already exists
            String checkQuery = "SELECT * FROM exchange_rates WHERE currency_code = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, currencyCode);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                // Currency already exists
                out.println("<html><body>");
                out.println("<div style='text-align:center;margin-top:50px;'>");
                out.println("<p class='error' style='color:red;'>Currency already exists!</p>");
                out.println("<a href='addCurrency' style='display:inline-block;margin-top:15px;padding:10px 20px;background-color:#007BFF;color:white;text-decoration:none;border-radius:5px;'>Back</a>");
                out.println("</div>");
                out.println("</body></html>");
            } else {
                // Insert new currency
                String insertQuery = "INSERT INTO exchange_rates (currency_code, rate_to_bdt) VALUES (?, ?)";
                PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
                insertStmt.setString(1, currencyCode);
                insertStmt.setDouble(2, rateToBdt);
                int rowsAffected = insertStmt.executeUpdate();

                if (rowsAffected > 0) {
                    response.sendRedirect("viewExchangeRates");
                } else {
                    out.println("<p class='error'>Failed to add the currency!</p>");
                }
            }

        } catch (SQLException e) {
            out.println("<p class='error'>Error: " + e.getMessage() + "</p>");
        }
    }
}
