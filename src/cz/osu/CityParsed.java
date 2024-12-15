package cz.osu;

public class CityParsed {

    private String id;
    private String name;
    private String parentId;
    private String child1Id;
    private String child2Id;
    private String child3Id;

    public CityParsed(String id, String name, String parentId, String child1Id, String child2Id, String child3Id) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.child1Id = child1Id;
        this.child2Id = child2Id;
        this.child3Id = child3Id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getParentId() {
        return parentId;
    }

    public String getChild1Id() {
        return child1Id;
    }

    public String getChild2Id() {
        return child2Id;
    }

    public String getChild3Id() {
        return child3Id;
    }

}

