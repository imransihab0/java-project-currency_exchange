import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class CurrencyExchangeServlet extends HttpServlet {
    // Handles GET requests
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>Currency Exchange to BDT</h1>");
        out.println("<form method='POST'>");
        out.println("Currency Code (e.g. USD): <input type='text' name='currencyCode' required><br>");
        out.println("Amount: <input type='number' name='amount' required><br>");
        out.println("<input type='submit' value='Convert'>");
        out.println("</form>");

        // Check for form submission
        String currencyCode = request.getParameter("currencyCode");
        String amount = request.getParameter("amount");

        if (currencyCode != null && amount != null) {
            try {
                double conversionRate = getCurrencyRate(currencyCode);
                if (conversionRate != 0) {
                    double convertedAmount = Double.parseDouble(amount) * conversionRate;
                    out.println("<h3>" + amount + " " + currencyCode + " = " + convertedAmount + " BDT</h3>");
                } else {
                    out.println("<h3>Currency not found!</h3>");
                }
            } catch (Exception e) {
                out.println("<h3>Error: " + e.getMessage() + "</h3>");
            }
        }

        out.println("</body></html>");
    }

    private double getCurrencyRate(String code) throws SQLException {
        double rate = 0;
        // Query the database to get the exchange rate
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT rate_to_bdt FROM exchange_rates WHERE currency_code = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, code.toUpperCase());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                rate = rs.getDouble("rate_to_bdt");
            }
        }
        return rate;
    }
}
