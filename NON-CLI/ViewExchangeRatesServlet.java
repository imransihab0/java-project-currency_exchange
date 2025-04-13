import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class ViewExchangeRatesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>View Exchange Rates</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }");
        out.println(".container { max-width: 600px; margin: 50px auto; background: white; padding: 30px; border-radius: 10px; box-shadow: 0 4px 10px rgba(0,0,0,0.1); }");
        out.println("h1 { text-align: center; color: #007BFF; margin-bottom: 20px; }");
        out.println("table { width: 100%; border-collapse: collapse; }");
        out.println("th, td { padding: 12px; border-bottom: 1px solid #ddd; text-align: center; }");
        out.println("th { background-color: #007BFF; color: white; }");
        out.println("tr:hover { background-color: #f1f1f1; }");
        out.println(".home-button { display: block; margin: 20px auto; padding: 10px 25px; background-color: #28a745; color: white; text-decoration: none; border-radius: 5px; font-size: 15px; text-align: center; }");
        out.println(".home-button:hover { background-color: #218838; }");
        out.println("</style>");
        out.println("</head><body>");

        out.println("<div class='container'>");
        out.println("<h1>All Currency Exchange Rates</h1>");
        out.println("<table>");
        out.println("<tr><th>Currency Code</th><th>Rate to BDT</th></tr>");

        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT currency_code, rate_to_bdt FROM exchange_rates";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String currencyCode = rs.getString("currency_code");
                double rateToBdt = rs.getDouble("rate_to_bdt");
                out.println("<tr><td>" + currencyCode + "</td><td>" + rateToBdt + "</td></tr>");
            }
        } catch (SQLException e) {
            out.println("<tr><td colspan='2' style='color:red;'>Error: " + e.getMessage() + "</td></tr>");
        }

        out.println("</table>");
        out.println("<a href='index.jsp' class='home-button'>Home</a>");
        out.println("</div>");
        out.println("</body></html>");
    }
}
d