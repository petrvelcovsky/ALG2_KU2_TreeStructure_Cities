package cz.osu;

import java.util.ArrayList;
import java.util.List;

public class ParserCsv {

    String path;
    ArrayList<CityParsed> parsedCities = new ArrayList<CityParsed>();

    public ParserCsv(String path) {
        this.path = path;
        parsedCities = parseCities ();
    }

    public ArrayList<CityParsed> parseCities (){

        List<String> allRows = FileManager.convertFileToLines(path);

        for (String row : allRows.subList(1, allRows.size())) {

            String[] column = row.split(";");

            String id = column[0];
            String name = column[1];
            String parentId = null;
            String child1Id = null;
            String child2Id = null;
            String child3Id = null;

            if (!column[2].isEmpty()) {parentId = column[2];}
            //pokud jeden child neni vyplnen, nemusi to znamenat, ze nasledujici take neni vyplnen
            if (column.length > 3 && !column[3].isEmpty()) {child1Id = column[3];}
            if (column.length > 4 && !column[4].isEmpty()) {child2Id = column[4];}
            if (column.length > 5 &&!column[5].isEmpty()) {child3Id = column[5];}


            CityParsed newCity = new CityParsed(id, name, parentId, child1Id, child2Id, child3Id);
            parsedCities.add(newCity);
        }
        return parsedCities;
    }

    public CityParsed findRoot (){

        for (CityParsed city: parsedCities) {
            if (city.getParentId() == null){
                return city;
            }
        }
        return null;
    }

    public CityParsed findCity (String id){

        for (CityParsed city: parsedCities) {
            if (city.getId().equals(id)){
                return city;
            }
        }
        return null;
    }

    public void clearParsedCities() {
        parsedCities.clear();
        parsedCities = null;
    }
}
