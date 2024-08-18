package application.data.workers.entites;

import java.time.Instant;

public class HourContract {

    private Instant date;

    private Double valuePerHour;

    private Integer hours;

    public HourContract() {

    }

    public HourContract(Instant date, Double valuePerHour, Integer hours) {
        this.date = date;
        this.valuePerHour = valuePerHour;
        this.hours = hours;
    }

    public Instant getDate() {
        return date;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(Double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Double totalValue() {
        return valuePerHour * hours;
    }
}
