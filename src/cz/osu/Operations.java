package cz.osu;

import java.util.ArrayList;

public class Operations {

    private CitiesTree citiesTree = new CitiesTree();
    private City root;


    public Operations() {
        root = citiesTree.getRoot();
    }

    public void displayAllCities(){
        System.out.println("Výpis všech měst řazených dle metody procházení stromu PRE-ORDER:");
        preorderPrint(root);
    }

    private void preorderPrint(City city){

        if(city == null){
            return;
        }

        System.out.println(city.getName());
        preorderPrint(city.getChild1());
        preorderPrint(city.getChild2());
        preorderPrint(city.getChild3());
    }

    public City preorderSearchByName(String name){
        return preorderSearchByName(root, name);
    }

    private City preorderSearchByName(City city, String name) {

        if (city == null) {
            return null;
        }

        if (city.getName().equals(name)) {
            return city;
        }

        City foundCity = preorderSearchByName(city.getChild1(), name);
        if (foundCity != null) {
            return foundCity;
        }

        foundCity = preorderSearchByName(city.getChild2(), name);
        if (foundCity != null) {
            return foundCity;
        }

        foundCity = preorderSearchByName(city.getChild3(), name);
        if (foundCity != null) {
            return foundCity;
        }

        return null; //pro pripad, ze by mesto v seznamu nebylo
    }

    public ArrayList<City> findRouteFromCityToCity (String firstName, String secondName)
    {
        ArrayList<City> cityToCity = new ArrayList<>();

        ArrayList<City> firstRoute = findRouteToRoot(firstName);
        ArrayList<City> secondRoute = findRouteToRoot(secondName);

        int firstIndex = firstRoute.size() - 1;
        int secondIndex = secondRoute.size() - 1;

        while (firstIndex >= 0 && secondIndex >= 0 && firstRoute.get(firstIndex) == secondRoute.get(secondIndex)) {
            firstIndex--;
            secondIndex--;
        }

        if (firstRoute.size() != 0 && secondRoute.size() != 0)
        {
            for (int i = 0; i <= firstIndex + 1; i++) {
                cityToCity.add(firstRoute.get(i));
            }

            for (int i = secondIndex; i >= 0; i--) {
                cityToCity.add(secondRoute.get(i));
            }
        }

        return cityToCity;
    }

    public ArrayList<City> findRouteToRoot (String name)
    {
        ArrayList<City> citiesToRoot = new ArrayList<>();
        City firstCity = preorderSearchByName(name);
        citiesToRoot = findRouteToRoot(firstCity, citiesToRoot);
        return citiesToRoot;
    }

    private ArrayList<City> findRouteToRoot(City city, ArrayList<City> citiesToRoot)
    {
        if (city == null)
        {
            return citiesToRoot;
        }

        citiesToRoot.add(city);
        city = city.getParent();
        return findRouteToRoot(city, citiesToRoot);
    }

    public void printRoute (ArrayList<City> toPrint)
    {
        if (toPrint.size() != 0)
        {
            for (City oneCity: toPrint) {
                System.out.print(oneCity.getName() + "  ") ;
            }
        }
        else
        {
            System.out.print("Alespoň jedno město v seznamu není.") ;
        }
        System.out.println();
    }

}

