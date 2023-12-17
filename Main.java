import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserManager userManager = new UserManager();
        HolidayPlanner holidayPlanner = new HolidayPlanner();

        while (true) {
            System.out.println("Welcome To Holiday Planner website");
            System.out.println("1. Login as Admin");
            System.out.println("2. Login as User");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter admin username: ");
                    String adminUsername = sc.next();
                    System.out.print("Enter admin password: ");
                    String adminPassword = sc.next();
                    if (userManager.isAdminValid(adminUsername, adminPassword)) {
                        adminMenu(userManager, holidayPlanner);
                    } else {
                        System.out.println("Invalid credentials for admin.");
                    }
                    break;

                case 2:
                    System.out.print("Enter user username: ");
                    String userUsername = sc.next();
                    System.out.print("Enter user password: ");
                    String userPassword = sc.next();
                    if (userManager.isUserValid(userUsername, userPassword)) {
                        System.out.println("User Entered Sucessfully.");
                        userMenu(userManager, holidayPlanner, userUsername);
                    } else {
                        System.out.println("Invalid credentials for user.");
                    }
                    break;

                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void adminMenu(UserManager userManager, HolidayPlanner holidayPlanner) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. View all users");
            System.out.println("2. View all holiday plans");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    userManager.viewAllUsers();
                    break;

                case 2:
                    holidayPlanner.viewAllHolidayPlans();
                    break;

                case 3:
                    System.out.println("Logging out as admin.");
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void userMenu(UserManager userManager, HolidayPlanner holidayPlanner, String username) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("User Menu:");
            System.out.println("1. View available holiday plans");
            System.out.println("2. View selected holiday plan");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    holidayPlanner.viewAvailableHolidayPlans();
                    System.out.print("Enter the ID of the holiday plan you want to choose: ");
                    int planId = sc.nextInt();
                    holidayPlanner.chooseHolidayPlan(username, planId);
                    break;

                case 2:
                    holidayPlanner.viewSelectedHolidayPlan(username);
                    break;

                case 3:
                    System.out.println("Logging out as user.");
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}