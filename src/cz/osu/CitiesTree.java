package cz.osu;

public class CitiesTree {

    private City root;
    ParserCsv parserCsv = new ParserCsv("./dataRoute.csv");

    public CitiesTree() {
        CityParsed rootParsed = parserCsv.findRoot();
        root = createTree(rootParsed.getId(), null);
        parserCsv.clearParsedCities();
    }

    City createTree(String cityId, City parent){

        if (cityId == null){
            return null;
        }

        //pro pripad, kdy reference na dite existuje, ale samotne mesto v seznamu neni
        if (parserCsv.findCity(cityId) == null){
            return null;
        }

        String name = parserCsv.findCity(cityId).getName();
        String id = parserCsv.findCity(cityId).getId();

        City newCity = new City(id, name);

        newCity.setParent(parent);

        newCity.setChild1(createTree(parserCsv.findCity(cityId).getChild1Id(), newCity));
        newCity.setChild2(createTree(parserCsv.findCity(cityId).getChild2Id(), newCity));
        newCity.setChild3(createTree(parserCsv.findCity(cityId).getChild3Id(), newCity));

        return newCity;
    }

    public City getRoot() {
        return root;
    }

}

