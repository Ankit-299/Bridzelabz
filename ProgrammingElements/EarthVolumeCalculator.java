public class EarthVolumeCalculator {

    public static void main(String[] args) {
        double radiusKm = 6378;
        double pi = Math.PI;

        double volumeKm3 = (4.0 / 3.0) * pi * radiusKm * radiusKm * radiusKm;

        double kmToMilesFactor = 0.621371;
        double km3ToMiles3Factor = kmToMilesFactor * kmToMilesFactor * kmToMilesFactor;

        double volumeMiles3 = volumeKm3 * km3ToMiles3Factor;

        System.out.println("The volume of earth in cubic kilometers is " + String.format("%.2f", volumeKm3) + " and cubic miles is " + String.format("%.2f", volumeMiles3));
    }
}
