import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HolidayPlanner {
    private static final String HOLIDAY_PLANS_FILE = "holiday_plans.txt";
    private static final String USER_HOLIDAY_FILE = "user_holidays.txt";

    public void viewAllHolidayPlans() {
        try (Scanner scanner = new Scanner(new File(HOLIDAY_PLANS_FILE))) {
            System.out.println("List of Holiday Plans:");
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void viewAvailableHolidayPlans() {
        try (Scanner scanner = new Scanner(new File(HOLIDAY_PLANS_FILE))) {
            System.out.println("Available Holiday Plans:");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    System.out.println(parts[0] + ". " + parts[1] + " - " + parts[2]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void chooseHolidayPlan(String username, int planId) {
        System.out.println("User '" + username + "' selected Holiday Plan with ID " + planId);
    }

    public void displaySelectedHolidayPlan(String username, int planId) {
        System.out.println("User '" + username + "' selected Holiday Plan with ID " + planId);
    }

    public void viewSelectedHolidayPlan(String username) {
        try (Scanner scanner = new Scanner(new File(USER_HOLIDAY_FILE))) {
            System.out.println("Selected Holiday Plans for User '" + username + "':");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(username)) {
                    int planId = Integer.parseInt(parts[1]);
                    displaySelectedHolidayPlan(username, planId);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
