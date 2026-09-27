import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class Admin extends Customer {
    Customer customer = new Customer();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Connection con;

    public Admin() {
        try {
            // JDBC connection setup
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "your_password");
        } catch (Exception e) {
            System.out.println("Database Connection Failed: " + e);
        }
    }

    public void displayAdminLoginPanel() throws IOException {
        System.out.println("--------------------------------------------------" + "\n" + "               ADMIN LOGIN  PANEL                " + "\n" + "--------------------------------------------------");
        System.out.println("");

        System.out.print("Enter Admin ID: ");
        String s = br.readLine();
        System.out.print("Enter Admin Password: ");
        String s2 = br.readLine();
        // Add authentication if needed using DB check
    }

    public void showAdminMenu() throws IOException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("");
            System.out.println("--------------------------------------------------" + "\n" + "                    ADMIN MENU                " + "\n" + "--------------------------------------------------");
            System.out.println("");
            System.out.println("Press 1 :: View All Customers");
            System.out.println("Press 2 :: Search Customer By Account");
            System.out.println("Press 3 :: Register New Customer");
            System.out.println("Press 4 :: Update Customer Details");
            System.out.println("Press 5 :: Delete Customer Account");
            System.out.println("Press 6 :: Reset PIN");
            System.out.println("Press 7 :: View All Transactions");
            System.out.println("Press 8 :: Deposit Money");
            System.out.println("Press 9 :: Withdraw Money");
            System.out.println("Press 10 :: EXIT!!");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    try {
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM customers");
                        while (rs.next()) {
                            System.out.println("Name: " + rs.getString("name") + ", Account: " + rs.getString("account_number") + ", Balance: " + rs.getDouble("balance"));
                        }
                    } catch (SQLException e) {
                        System.out.println(e);
                    }
                    break;

                case 2:
                    System.out.print("Enter Account Number to Search: ");
                    String acc = br.readLine();
                    try {
                        PreparedStatement ps = con.prepareStatement("SELECT * FROM customers WHERE account_number = ?");
                        ps.setString(1, acc);
                        ResultSet rs = ps.executeQuery();
                        if (rs.next()) {
                            System.out.println("Customer Found: Name: " + rs.getString("name") + ", Mobile: " + rs.getString("mobile") + ", Balance: " + rs.getDouble("balance"));
                        } else {
                            System.out.println("Account not found.");
                        }
                    } catch (SQLException e) {
                        System.out.println(e);
                    }
                    break;

                case 3:
                    customer.displayCustomerRegistration();
                    break;

                case 4:
                    System.out.print("Enter Account Number to Update: ");
                    String updateAcc = br.readLine();
                    System.out.print("Enter New Name: ");
                    String newName = br.readLine();
                    System.out.print("Enter New Mobile: ");
                    String newMobile = br.readLine();
                    try {
                        PreparedStatement ps = con.prepareStatement("UPDATE customers SET name = ?, mobile = ? WHERE account_number = ?");
                        ps.setString(1, newName);
                        ps.setString(2, newMobile);
                        ps.setString(3, updateAcc);
                        int rows = ps.executeUpdate();
                        if (rows > 0) System.out.println("Details updated.");
                        else System.out.println("Account not found.");
                    } catch (SQLException e) {
                        System.out.println(e);
                    }
                    break;

                case 5:
                    System.out.print("Enter Account Number to Delete: ");
                    String delAcc = br.readLine();
                    try {
                        PreparedStatement ps = con.prepareStatement("DELETE FROM customers WHERE account_number = ?");
                        ps.setString(1, delAcc);
                        int rows = ps.executeUpdate();
                        if (rows > 0) System.out.println("Customer deleted.");
                        else System.out.println("Account not found.");
                    } catch (SQLException e) {
                        System.out.println(e);
                    }
                    break;

                case 6:
                    System.out.print("Enter Account Number to Reset PIN: ");
                    String pinAcc = br.readLine();
                    System.out.print("Enter New 4-digit PIN: ");
                    String newPin = br.readLine();
                    if (newPin.length() == 4) {
                        try {
                            PreparedStatement ps = con.prepareStatement("UPDATE customers SET pin = ? WHERE account_number = ?");
                            ps.setString(1, newPin);
                            ps.setString(2, pinAcc);
                            int rows = ps.executeUpdate();
                            if (rows > 0) System.out.println("PIN updated.");
                            else System.out.println("Account not found.");
                        } catch (SQLException e) {
                            System.out.println(e);
                        }
                    } else {
                        System.out.println("Invalid PIN length.");
                    }
                    break;

                case 7:
                    try {
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM transactions");
                        while (rs.next()) {
                            System.out.println("Account: " + rs.getString("account_number") + ", Type: " + rs.getString("type") + ", Amount: " + rs.getDouble("amount") + ", Date: " + rs.getTimestamp("timestamp"));
                        }
                    } catch (SQLException e) {
                        System.out.println(e);
                    }
                    break;

                case 8:
                    customer.depositMoney();
                    break;

                case 9:
                    customer.withdrawMoney();
                    break;

                case 10:
                    System.out.println("-----Thank you Admin!!-----");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please select 1-10.");
            }
        }
    }
} 
