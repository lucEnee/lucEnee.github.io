package nc.univ;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileOutputStream;

public class App 
{
    public static void main( String[] args )
    {
        Noeud semestre1 = new Noeud("1", Type.semestre, 10);
        Noeud semestre2 = new Noeud("2", Type.semestre, 10);
        Noeud semestre3 = new Noeud("3", Type.semestre, 10);
        Noeud semestre4 = new Noeud("4", Type.semestre, 10);
        Noeud semestre5 = new Noeud("5", Type.semestre, 10);
        Noeud parcoursCommun = new Noeud("commun", Type.parcours, semestre1, 10);
        parcoursCommun.addChildren(semestre2);
        parcoursCommun.addChildren(semestre3);
        parcoursCommun.addChildren(semestre4);
        parcoursCommun.addChildren(semestre5);
        Noeud parcoursInfo = new Noeud("informatique", Type.parcours, semestre1, 10);
        parcoursInfo.addChildren(semestre2);
        parcoursInfo.addChildren(semestre3);
        parcoursInfo.addChildren(semestre4);
        parcoursInfo.addChildren(semestre5);
        Noeud annee2022 = new Noeud("2022", Type.annee, parcoursCommun, 10);
        annee2022.addChildren(parcoursInfo);

        Gson gson = new Gson();
        File save = new File("ressources/save.json");
        String json = gson.toJson(annee2022);

        try {
            if (save.createNewFile())
                System.out.println("File created");
            else
                System.out.println("File already exists");

            FileOutputStream fos = new FileOutputStream("ressources/save.json");
            fos.write(json.getBytes());
            fos.flush();
            fos.close();

        } catch (Exception e) {
            System.err.println(e);
        }

        System.out.println(json);
    }
}
