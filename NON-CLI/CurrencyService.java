import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CurrencyService {

    public void convertToBDT(String code, double amount) {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT rate_to_bdt FROM exchange_rates WHERE currency_code = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, code.toUpperCase());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                double rate = rs.getDouble("rate_to_bdt");
                double total = rate * amount;
                System.out.printf("%.2f %s = %.2f BDT\n", amount, code.toUpperCase(), total);
            } else {
                System.out.println("Currency not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewAll() {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT * FROM exchange_rates";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            System.out.println("\nCurrency | Rate to BDT");
            while (rs.next()) {
                System.out.printf("%s	 | %.2f\n", rs.getString("currency_code"), rs.getDouble("rate_to_bdt"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCurrency(String code, double rate) {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "INSERT INTO exchange_rates (currency_code, rate_to_bdt) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, code.toUpperCase());
            stmt.setDouble(2, rate);
            stmt.executeUpdate();
            System.out.println("Currency added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCurrency(String code, double rate) {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "UPDATE exchange_rates SET rate_to_bdt = ? WHERE currency_code = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setDouble(1, rate);
            stmt.setString(2, code.toUpperCase());
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Currency updated.");
            } else {
                System.out.println("Currency not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCurrency(String code) {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "DELETE FROM exchange_rates WHERE currency_code = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, code.toUpperCase());
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Currency deleted.");
            } else {
                System.out.println("Currency not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}