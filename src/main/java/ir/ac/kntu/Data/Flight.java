package ir.ac.kntu.Data;


import java.util.Date;

public class Flight {
    private String flightId;
    private Address departFrom;
    private Address destination;
    private Date flightDate;
    private String airline;
    private Date arrivalDate;
    private String flightType;
    private Integer capacity;
    private Integer cost;
//    private String arrivalGate;
//    private String departureGate;
//    private String flightDuration;


    public Flight(String flightId, Address departFrom, Address destination, Date flightDate, String airline,
                  Date arrivalDate, String flightType, Integer capacity, Integer cost) {
        this.flightId = flightId;
        this.departFrom = departFrom;
        this.destination = destination;
        this.flightDate = flightDate;
        this.airline = airline;
        this.arrivalDate = arrivalDate;
        this.flightType = flightType;
        this.capacity = capacity;
        this.cost = cost;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public Address getDepartFrom() {
        return departFrom;
    }

    public void setDepartFrom(Address departFrom) {
        this.departFrom = departFrom;
    }

    public Address getDestination() {
        return destination;
    }

    public void setDestination(Address destination) {
        this.destination = destination;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getFlightType() {
        return flightType;
    }

    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightId='" + flightId + '\'' +
                ", departFrom=" + departFrom +
                ", Destination=" + destination +
                ", flightDate=" + flightDate +
                ", Airline='" + airline + '\'' +
                ", arrivalDate=" + arrivalDate +
                ", flightType='" + flightType + '\'' +
                ", capacity=" + capacity +
                ", cost=" + cost +
                '}';
    }
}
