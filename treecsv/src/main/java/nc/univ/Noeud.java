package nc.univ;

import java.util.ArrayList;

public class Noeud {
    private String name;
    private Integer nbrHeure;
    private Type type;
    private ArrayList<Noeud> children;

    public Noeud(String name, Type type, Integer nbrHeure){
        this.name = name;
        this.type = type;
        this.nbrHeure = nbrHeure;
    }

    public Noeud(String name, Type type, Noeud csvToJson, Integer nbrHeure){
        this.name = name;
        this.type = type;
        this.children = new ArrayList<Noeud>();
        this.nbrHeure = nbrHeure;
        children.add(csvToJson);
    }

    public void addChildren(Noeud children){
        this.children.add(children);
    }

    
}
