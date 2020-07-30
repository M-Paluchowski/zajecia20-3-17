package excercises.trip;

import java.util.Comparator;

class Trip {

    private String name;
    private String destination;
    private double price;

    public Trip() {}

    public Trip(String name, String destination, double price) {
        this.name = name;
        this.destination = destination;
        this.price = price;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "name='" + name + '\'' +
                ", destination='" + destination + '\'' +
                ", price=" + price +
                '}';
    }

    class NameComparator implements Comparator<Trip> {

        @Override
        public int compare(Trip tripOne, Trip tripTwo) {
            return tripOne.name.compareTo(tripTwo.name);
        }
    }

    static class PriceComparator implements Comparator<Trip> {

        @Override
        public int compare(Trip tripOne, Trip tripTwo) {
            return Double.compare(tripOne.price, tripTwo.price);
        }
    }
}
