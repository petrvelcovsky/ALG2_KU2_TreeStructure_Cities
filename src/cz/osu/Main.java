package cz.osu;

public class Main {
    public static void main(String[] args) {

        Operations operations = new Operations();

        operations.displayAllCities();
        System.out.println();

        operations.printRoute(operations.findRouteFromCityToCity("Ostrava", "Praha"));
        operations.printRoute(operations.findRouteFromCityToCity("Kyjov", "Jablunkov"));
        operations.printRoute(operations.findRouteFromCityToCity("Hlinsko", "Karviná"));
        operations.printRoute(operations.findRouteFromCityToCity("Jablunkov", "Semily"));

    }
}