import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import funtions.ExportToCSV;
import funtions.InsertNewEmployee;
import funtions.retriveEmployeeDetails;
import funtions.deleteParticularEmployee;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DatabaseHelper.getConnection()) {
            System.out.println("\n\033[1;32m✔ Connected to database!\033[0m"); // Green success message
            Scanner sc = new Scanner(System.in);
            boolean flag = true;

            while (flag) {
                // Displaying a clean menu
                System.out.println("\n\033[1;34m===========================================");
                System.out.println("💼 EMPLOYEE MANAGEMENT SYSTEM");
                System.out.println("===========================================\033[0m");
                System.out.println("\033[1;33m1️⃣ Insert New Employee");
                System.out.println("2️⃣ Retrieve Employee Details");
                System.out.println("3️⃣ Remove Employee");
                System.out.println("4️⃣ Export Employee Data");
                System.out.println("5️⃣ Exit");
                System.out.println("\033[1;34m===========================================\033[0m");

                // Taking user input
                System.out.print("\n\033[1;36m🔹 Enter your choice: \033[0m");

                while (!sc.hasNextInt()) {
                    System.out.print("\033[1;31m❌ Invalid input! Please enter a valid number (1-4): \033[0m");
                    sc.next(); // Clear invalid input
                }

                int choose = sc.nextInt();
                sc.nextLine(); // Clear buffer

                System.out.println(); // Spacing for better readability

                switch (choose) {
                    case 1 -> {
                        System.out.println("\033[1;35m📌 Adding a new employee...\033[0m");
                        InsertNewEmployee.insertFun(conn, sc);
                    }
                    case 2 -> {
                        System.out.println("\033[1;35m📌 Retrieving employee details...\033[0m");
                        retriveEmployeeDetails.retrieveFun(conn, sc);
                    }
                    case 3 -> {
                        System.out.println("\033[1;35m📌 Removing an employee...\033[0m");
                        deleteParticularEmployee.deleteFun(conn, sc);
                    }
                    case 4 -> {
                        System.out.println("\033[1;35m📂 Exporting employee data...\033[0m");
                        ExportToCSV.exportEmployeeDataToCSV(conn);
                    }
                    case 5 -> {
                        System.out.println("\033[1;31m🚪 Exiting the system. Thank you!\033[0m");
                        flag = false;
                    }
                    default -> System.out.println("\033[1;31m❌ Invalid choice! Please enter a number between 1 and 4.\033[0m");
                }
            }
        } catch (SQLException e) {
            System.out.println("\033[1;31m🚨 Database Error: " + e.getMessage() + "\033[0m");
        }
    }
}
