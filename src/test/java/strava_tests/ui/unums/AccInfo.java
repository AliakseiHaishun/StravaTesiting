package strava_tests.ui.unums;

public enum AccInfo {
    ACC_INFO1("Frank", "Lampard", 24, 5, 1985, "M", "London", 84);

    private String firstName;
    private String lastName;
    private int day;
    private int month;
    private int year;
    private String sex;
    private String city;
    private int weight;

    AccInfo(String firstName, String lastName, int day, int month, int year, String sex, String city, int weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.day = day;
        this.month = month;
        this.year = year;
        this.sex = sex;
        this.city = city;
        this.weight = weight;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getSex() {
        return sex;
    }

    public String getCity() {
        return city;
    }

    public int getWeight() {
        return weight;
    }
}
