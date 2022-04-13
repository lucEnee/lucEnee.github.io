package nc.univ;

import java.util.ArrayList;

public class CsvToJson {
    private String name;
    private Integer nbrHeure;
    private Type type;
    private ArrayList<CsvToJson> children;

    public CsvToJson(String name, Type type){
        this.name = name;
        this.type = type;
    }

    public CsvToJson(String name, Type type, CsvToJson csvToJson){
        this.name = name;
        this.type = type;
        this.children = new ArrayList<CsvToJson>();
        children.add(csvToJson);
    }

    public void addChildren(CsvToJson children){
        this.children.add(children);
    }

    
}
