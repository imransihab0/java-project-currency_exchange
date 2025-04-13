import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class DeleteCurrencyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Delete Currency</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f8f9fa; margin: 0; padding: 0; color: #333; }");
        out.println(".container { max-width: 400px; margin: 50px auto; background: white; padding: 30px; border-radius: 10px; box-shadow: 0 4px 10px rgba(0,0,0,0.1); text-align: center; }");
        out.println("h1 { color: #dc3545; margin-bottom: 20px; }");
        out.println("form { display: flex; flex-direction: column; }");
        out.println("input[type='text'] { padding: 10px; margin: 10px 0; border: 1px solid #ccc; border-radius: 5px; }");
        out.println("input[type='submit'] { padding: 10px; background-color: #dc3545; color: white; border: none; border-radius: 5px; cursor: pointer; }");
        out.println("input[type='submit']:hover { background-color: #c82333; }");
        out.println(".home-button { display: inline-block; margin-top: 20px; padding: 8px 25px; background-color: #28a745; color: white; text-decoration: none; border-radius: 5px; font-size: 15px; }");
        out.println(".home-button:hover { background-color: #218838; }");
        out.println("</style>");
        out.println("</head><body>");

        out.println("<div class='container'>");
        out.println("<h1>Delete Currency</h1>");
        out.println("<form method='POST'>");
        out.println("Currency Code (e.g. USD): <input type='text' name='currencyCode' required>");
        out.println("<input type='submit' value='Delete Currency'>");
        out.println("</form>");
        out.println("<a href='index.jsp' class='home-button'>Home</a>");
        out.println("</div>");

        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currencyCode = request.getParameter("currencyCode");

        try (Connection conn = DBConnection.getConnection()) {
            String query = "DELETE FROM exchange_rates WHERE currency_code = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, currencyCode.toUpperCase());
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                response.sendRedirect("viewExchangeRates");
            } else {
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<html><body>");
                out.println("<h3 style='color:red; text-align:center;'>Currency not found!</h3>");
                out.println("<a href='deleteCurrency' class='home-button' style='display:block; text-align:center; width:100px; margin:20px auto;'>Back</a>");
                out.println("</body></html>");
            }
        } catch (SQLException e) {
            response.getWriter().println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}
