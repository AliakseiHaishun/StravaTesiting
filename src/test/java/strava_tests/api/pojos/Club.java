package strava_tests.api.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Club{
        private int id;
        private String name;
        private String sport_type;
        private String city;

        public Club() {
        }

        public int getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        public String getSport_type() {
                return sport_type;
        }

        public String getCity() {
                return city;
        }

        @Override
        public String toString() {
                return "Club{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", sport_type='" + sport_type + '\'' +
                        ", city='" + city + '\'' +
                        '}';
        }
}
