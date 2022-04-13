package nc.univ;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileOutputStream;

public class App 
{
    public static void main( String[] args )
    {
        CsvToJson semestre1 = new CsvToJson("1", Type.semestre);
        CsvToJson semestre2 = new CsvToJson("2", Type.semestre);
        CsvToJson semestre3 = new CsvToJson("3", Type.semestre);
        CsvToJson semestre4 = new CsvToJson("4", Type.semestre);
        CsvToJson semestre5 = new CsvToJson("5", Type.semestre);
        CsvToJson parcoursCommun = new CsvToJson("commun", Type.parcours, semestre1);
        parcoursCommun.addChildren(semestre2);
        parcoursCommun.addChildren(semestre3);
        parcoursCommun.addChildren(semestre4);
        parcoursCommun.addChildren(semestre5);
        CsvToJson parcoursInfo = new CsvToJson("informatique", Type.parcours, semestre1);
        parcoursInfo.addChildren(semestre2);
        parcoursInfo.addChildren(semestre3);
        parcoursInfo.addChildren(semestre4);
        parcoursInfo.addChildren(semestre5);
        CsvToJson annee2022 = new CsvToJson("2022", Type.annee, parcoursCommun);
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
