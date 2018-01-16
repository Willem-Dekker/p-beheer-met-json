import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Prison {
    private String nameOfPrison;
    private ArrayList<Prisoner> prisoners = new ArrayList<>();

    /**
     * creates a prison class
     *
     * @param nameOfPrison name of the prison
     */
    public Prison(String nameOfPrison) {
        this.nameOfPrison = nameOfPrison;
    }


    /**
     * loads the prisoners from json file
     * @param filename the file name of the prisoners
     */
    protected void load_prisoners(String filename){
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get(filename)));
            JSONArray jsonArray = new JSONArray(jsonString);
            for(int i=0; i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Prisoner prisoner = new Prisoner(jsonObject);
                prisoners.add(prisoner);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * saves the prisoners to json file
     * @param filename file to safe to
     */
    protected void save_prisoners(String filename){
        JSONArray jsonArray = new JSONArray();
        for (Prisoner p: prisoners) {
            jsonArray.put(p.toJSONObject());
        }
        try {
            String jsonString = jsonArray.toString(2);
            Files.write(Paths.get(filename),jsonString.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * adds prisoner to the list
     *
     * @param name     name of the prisoner
     * @param crime    crime of the prisoner
     * @param age      age of the prisoner
     * @param sentence sentence of the prisoner
     * @param solitary if he is in solitary
     */
    public void addPrisoner(String name, String crime, int age, int sentence, boolean solitary) {
        prisoners.add(new Prisoner(name, crime, age, sentence, solitary,new Cell()));
    }

    /**
     * prints all pristoners no conditions
     *
     * @return prisoners that meet condition given
     */
    public ArrayList<Prisoner> printAllPrisoner() {
        ArrayList<Prisoner> temp = new ArrayList<>();
        System.out.println("Prisoners in " + nameOfPrison);
        for (Prisoner p : prisoners) {
            //System.out.printf("Name:%s crime:%s Age:%d Sentence:%s Solitary:%s\n", p.getName(), p.getCrime(), p.getAge(), p.getSentence(), p.isSolitary());
            temp.add(p);
        }
        return temp;
    }

    /**
     * prints all prisoners above set age
     *
     * @param age age of the threshold
     *
     * @return prisoners that meet condition given
     */
    public ArrayList<Prisoner> printAllPrisoner(int age) {
        ArrayList<Prisoner> temp = new ArrayList<>();
        System.out.println("Prisoners in " + nameOfPrison + " Older than: " + age);
        for (Prisoner p : prisoners) {
            if (p.getAge() >= age) {
                //System.out.printf("Name:%s crime:%s Age:%d Sentence:%s Solitary:%s\n", p.getName(), p.getCrime(), p.getAge(), p.getSentence(), p.isSolitary());
                temp.add(p);
            }
        }
        return temp;
    }

    /**
     * prints all the prisoners with crime containing
     *
     * @param crime crime to look for
     * @return prisoners that meet condition given
     */
    public ArrayList<Prisoner> printAllPrisoner(String crime) {
        ArrayList<Prisoner> temp = new ArrayList<>();
        System.out.println("Prisoners in " + nameOfPrison + " With crime containing: " + crime);
        for (Prisoner p : prisoners) {
            if (p.getCrime().contains(crime)) {
                //System.out.printf("Name:%s crime:%s Age:%d Sentence:%s Solitary:%s\n", p.getName(), p.getCrime(), p.getAge(), p.getSentence(), p.isSolitary());
                temp.add(p);

            }
        }
        return temp;
    }

    /**
     * prints all the prisoners in solitary
     *
     * @param solitary is the prisoner in solitary
     * @return prisoners that meet condition given
     */
    public ArrayList<Prisoner> printAllPrisoner(Boolean solitary) {
        ArrayList<Prisoner> temp = new ArrayList<>();
        System.out.println("Prisoners in " + nameOfPrison + " that are in solitary");
        for (Prisoner p : prisoners) {
            if (p.isSolitary() == solitary) {
                temp.add(p);
            }
        }
        return temp;
    }

    /**
     * prints all prisoners in soltary and above set age
     *
     * @param solitary is the prisoner in solitairy
     * @param age      age of the prisoner
     *
     * @return prisoners that meet condition given
     */
    public ArrayList<Prisoner> printAllPrisoner(Boolean solitary, int age) {
        System.out.println("Prisoners in " + nameOfPrison + " that are in solitary and Older then:" + age);
        ArrayList<Prisoner> temp = new ArrayList<>();
        for (Prisoner p : prisoners) {
            if (p.isSolitary() == solitary && p.getAge() >= age) {
                temp.add(p);
            }
        }
        return temp;
    }

    /**
     * removes a prisoner from the system
     * @param name the name of the pisoner
     * @return if the prisoner was removed
     */
    public boolean remove_prisoner(String name){
        for (int i = 0; i < prisoners.size();i++){
            Prisoner p = prisoners.get(i);
            if(p.getName().equals(name)){
                prisoners.remove(i);
                return true;
            }
        }

        return false;
    }

    /**
     * prints all cells and displaces in which prisoner the are
     */
    public void printCells(){
        for (Prisoner p: prisoners) {
            System.out.printf("Cell %d: %s\n", p.getCell().getCellNumber(), p.getName());
        }
    }
}
