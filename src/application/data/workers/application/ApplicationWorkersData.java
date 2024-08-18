package application.data.workers.application;

import application.data.workers.entites.Departament;
import application.data.workers.entites.HourContract;
import application.data.workers.entites.WorkerData;
import application.data.workers.entites.enums.WorkersLevels;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;

public class ApplicationWorkersData {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        System.out.print("Enter departament's name: ");
        String dp = sc.nextLine();
        System.out.println("Enter workers Data ");
        System.out.print("Name :");
        String name = sc.nextLine();
        System.out.print("Level :");
        String level = sc.nextLine();
        System.out.print("Salary :");
        double salary = sc.nextDouble();
        WorkerData worker = new WorkerData(name,WorkersLevels.valueOf(level.toUpperCase()),salary,new Departament(dp));

        System.out.println(worker);

        System.out.print("How many contracts to this worker? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter contract #" + (i+1) + " data");
            System.out.print("Date (DD/MM/YYYY): ");
            Date dateContract = sdf.parse(sc.next());
            System.out.print("Value per hour: ");
            double valuePerHourContract = sc.nextDouble();
            System.out.print("Duration: ");
            int durationContract = sc.nextInt();
            worker.addContract(new HourContract(dateContract,valuePerHourContract, durationContract));
        }

        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0,2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name: " + worker.getName());
        System.out.println("Departament: " + worker.getDepartament());
        System.out.println("Income: " + worker.income(year,month));


        sc.close();
    }
}
