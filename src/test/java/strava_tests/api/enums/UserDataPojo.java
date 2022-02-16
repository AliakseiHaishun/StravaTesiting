package strava_tests.api.enums;

public enum UserDataPojo{

    USER_DATA_POJO1(96513877, "Frank", "Lampard");

    private long id;
    private String firstname;
    private String lastname;

    UserDataPojo(long id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;

    }

    public long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String userInfo() {
        return id + firstname + lastname;
    }
}
