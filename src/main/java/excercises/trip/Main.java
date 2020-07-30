package excercises.trip;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Main {
    public static void main(String[] args) {

        List<Trip> trips = new ArrayList<>(List.of(new Trip("Super wycieczka", "Irlandia", 1999.0),
                new Trip("Ale zarąbista wycieczka", "Anglia", 200.0),
                new Trip("Zarąbista wycieczka", "Polska", 1.0)));

        trips.sort(new Comparator<Trip>() {
            @Override
            public int compare(Trip tripOne, Trip tripTwo) {
                return tripOne.getDestination().compareTo(tripTwo.getDestination());
            }
        });
        System.out.println(trips);

        trips.sort(new Trip().new NameComparator());
        System.out.println(trips);

        trips.sort(new Trip.PriceComparator());
        System.out.println(trips);
    }
}
