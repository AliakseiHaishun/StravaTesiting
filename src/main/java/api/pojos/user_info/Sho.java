package api.pojos.user_info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sho {
    private String id;
    private boolean primary;
    private String name;
    private int resource_state;
    private int distance;

    public String getId() {
        return id;
    }

    public boolean isPrimary() {
        return primary;
    }

    public String getName() {
        return name;
    }

    public int getResource_state() {
        return resource_state;
    }

    public int getDistance() {
        return distance;
    }

    public Sho(String id, boolean primary, String name, int resource_state, int distance) {

        this.id = id;
        this.primary = primary;
        this.name = name;
        this.resource_state = resource_state;
        this.distance = distance;
    }
    public Sho ()
    {}

    public void setId(String id) {
        this.id = id;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setResource_state(int resource_state) {
        this.resource_state = resource_state;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
