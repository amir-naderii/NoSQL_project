package ir.ac.kntu.scrapping;


public class Flight {
    private Integer flightId;
    private String departFrom;
    private String Destination;
    private String flightDate;
    private String Airline;
    private String departureTime;
    private String arrivalTime;
    private String arrivalGate;
    private String departureGate;
    private String flightDuration;


    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        try {
            this.flightId = Integer.parseInt(flightId);
        }catch(Exception e){
            this.flightId = 0;
        }
    }

    public String getDepartFrom() {
        return departFrom;
    }

    public void setDepartFrom(String departFrom) {
        this.departFrom = departFrom;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public String getAirline() {
        return Airline;
    }

    public void setAirline(String airline) {
        Airline = airline;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getArrivalGate() {
        return arrivalGate;
    }

    public void setArrivalGate(String arrivalGate) {
        this.arrivalGate = arrivalGate;
    }

    public String getDepartureGate() {
        return departureGate;
    }

    public void setDepartureGate(String departureGate) {
        this.departureGate = departureGate;
    }

    public String getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(String flightDuration) {
        this.flightDuration = flightDuration;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightId=" + flightId +
                ", departFrom='" + departFrom + '\'' +
                ", Destination='" + Destination + '\'' +
                ", flightDate='" + flightDate + '\'' +
                ", Airline='" + Airline + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", arrivalGate='" + arrivalGate + '\'' +
                ", departureGate='" + departureGate + '\'' +
                '}';
    }
}
