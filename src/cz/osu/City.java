package cz.osu;

public class City {

    private String id;
    private String name;
    private City parent;
    private City child1;
    private City child2;
    private City child3;

    public City(String id, String name) {
        this.id = id;
        this.name = name;
        this.parent = null;
        this.child1 = null;
        this.child2 = null;
        this.child3 = null;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public City getParent() {
        return parent;
    }

    public void setParent(City parent) {
        this.parent = parent;
    }

    public City getChild1() {
        return child1;
    }

    public void setChild1(City child1) {
        this.child1 = child1;
    }

    public City getChild2() {
        return child2;
    }

    public void setChild2(City child2) {
        this.child2 = child2;
    }

    public City getChild3() {
        return child3;
    }

    public void setChild3(City child3) {
        this.child3 = child3;
    }

}
