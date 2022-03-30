package nc.univ;

import java.util.ArrayList;

public class CsvToJson {
    private String name;
    private String type;
    private ArrayList<CsvToJson> list;

    public CsvToJson(String name, String type){
        this.name = name;
        this.type = type;
    }

    public CsvToJson(String name, String type, CsvToJson csvToJson){
        this.name = name;
        this.type = type;
        this.list = new ArrayList<CsvToJson>();
        list.add(csvToJson);
    }

    public void addList(CsvToJson list){
        this.list.add(list);
    }

    
}
