package application.data.workers.entites;

import application.data.workers.entites.enums.WorkersLevels;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WorkerData {

    private String name;

    private WorkersLevels levels;

    private Double salary;

    private Departament departament;

    private List<HourContract> contracts = new ArrayList<>();

    public WorkerData() {
    }

    public WorkerData(String name, WorkersLevels levels, Double salary, Departament departament) {
        this.name = name;
        this.levels = levels;
        this.salary = salary;
        this.departament = departament;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkersLevels getLevels() {
        return levels;
    }

    public void setLevels(WorkersLevels levels) {
        this.levels = levels;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    public void addContract (HourContract contract) {
        contracts.add(contract);
    }

    public void removeContract (HourContract contract) {
        contracts.remove(contract);
    }

    public Double income (int year, int mouth) {
        double sum = salary;
        Calendar cal = Calendar.getInstance();
        for (HourContract c : contracts) {
            cal.setTime(c.getDate());
            int c_year = cal.get(Calendar.YEAR);
            int c_mounth = 1 + cal.get(Calendar.MONTH);
            if (year == c_year && mouth == c_mounth) {
                sum += c.totalValue();
            }
        }
        return sum;
    }


    @Override
    public String toString() {
        return "WorkerData : " +
                " name = " + name +
                ", Departament = " + departament.getName() +
                ", Levels = " + levels +
                ", Salary = " + salary;
    }
}
