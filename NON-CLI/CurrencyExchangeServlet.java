import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class CurrencyExchangeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Convert Currency</title>");
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
        out.println(".result { margin-top: 20px; font-size: 16px; color: #333; }");
        out.println("</style>");
        out.println("</head><body>");

        out.println("<div class='container'>");
        out.println("<h1>Currency Exchange to BDT</h1>");
        out.println("<form method='POST'>");
        out.println("Currency Code (e.g. USD): <input type='text' name='currencyCode' required>");
        out.println("Amount: <input type='number' name='amount' step='any' required>");
        out.println("<input type='submit' value='Convert'>");
        out.println("</form>");

        // Handle conversion if form is submitted
        String currencyCode = request.getParameter("currencyCode");
        String amount = request.getParameter("amount");

        if (currencyCode != null && amount != null) {
            try {
                double conversionRate = getCurrencyRate(currencyCode);
                if (conversionRate != 0) {
                    double convertedAmount = Double.parseDouble(amount) * conversionRate;
                    out.println("<div class='result'><strong>" + amount + " " + currencyCode.toUpperCase() + "</strong> = <strong>" + convertedAmount + " BDT</strong></div>");
                } else {
                    out.println("<div class='result' style='color: red;'>Currency not found!</div>");
                }
            } catch (Exception e) {
                out.println("<div class='result' style='color: red;'>Error: " + e.getMessage() + "</div>");
            }
        }

        out.println("<a href='index.jsp' class='home-button'>Home</a>");
        out.println("</div>");
        out.println("</body></html>");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private double getCurrencyRate(String code) throws SQLException {
        double rate = 0;
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
