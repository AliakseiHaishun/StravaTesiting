package api.pojos.activity;

import api.ulits.DateDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Activity {

    private String name;
    private String type;
    private LocalDateTime start_date_local;
    private int elapsed_time;
    private double distance;

    public Activity() {}

    public Activity(String name, String type, LocalDateTime start_date_local, int elapsed_time, double distance) {
        this.name = name;
        this.type = type;
        this.start_date_local = start_date_local;
        this.elapsed_time = elapsed_time;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getStart_date_local() {
        return start_date_local;
    }

    public void setStart_date_local(LocalDateTime start_date_local) {
        this.start_date_local = start_date_local;
    }

    public int getElapsed_time() {
        return elapsed_time;
    }

    public void setElapsed_time(int elapsed_time) {
        this.elapsed_time = elapsed_time;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", start_date_local=" + start_date_local +
                ", elapsed_time=" + elapsed_time +
                ", distance=" + distance +
                '}';
    }
}
