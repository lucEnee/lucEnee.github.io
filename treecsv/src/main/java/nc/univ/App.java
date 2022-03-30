package nc.univ;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileOutputStream;

public class App 
{
    public static void main( String[] args )
    {
        CsvToJson semestre1 = new CsvToJson("1", "semestre");
        CsvToJson semestre2 = new CsvToJson("2", "semestre");
        CsvToJson semestre3 = new CsvToJson("3", "semestre");
        CsvToJson semestre4 = new CsvToJson("4", "semestre");
        CsvToJson semestre5 = new CsvToJson("5", "semestre");
        CsvToJson parcoursCommun = new CsvToJson("commun", "parcours",semestre1);
        parcoursCommun.addList(semestre2);
        parcoursCommun.addList(semestre3);
        parcoursCommun.addList(semestre4);
        parcoursCommun.addList(semestre5);
        CsvToJson parcoursInfo = new CsvToJson("informatique", "parcours",semestre1);
        parcoursInfo.addList(semestre2);
        parcoursInfo.addList(semestre3);
        parcoursInfo.addList(semestre4);
        parcoursInfo.addList(semestre5);
        CsvToJson annee2022 = new CsvToJson("2022", "annee", parcoursCommun);
        annee2022.addList(parcoursInfo);

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
