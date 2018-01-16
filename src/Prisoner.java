import org.json.JSONObject;

public class Prisoner {

    private String name, crime;
    private int age, sentence;
    private boolean solitary;
    private Cell cell;

    /**
     * contstuctor of the class
     *
     * @param name     name
     * @param crime    crime
     * @param age      age
     * @param sentence years in prison
     * @param solitary is in solitary
     */
    public Prisoner(String name, String crime, int age, int sentence, boolean solitary, Cell cell) {
        this.name = name;
        this.crime = crime;
        this.age = age;
        this.sentence = sentence;
        this.solitary = solitary;
        this.cell = cell;
    }

    /**
     * this method creats a prisoner from the json-object given to it
     * @param jsonObject the object to convert
     */
    public Prisoner(JSONObject jsonObject){
        this.name = jsonObject.getString("name");
        this.crime = jsonObject.getString("crime");
        this.age = jsonObject.getInt("age");
        this.sentence = jsonObject.getInt("sentenced_for");
        this.solitary = jsonObject.getBoolean("solitary");
        this.cell = new Cell();
    }

    /**
     * this method creates a json-object from a prisoner.
     * @return the prisoner as json-object
     */
    protected JSONObject toJSONObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",name);
        jsonObject.put("crime",crime);
        jsonObject.put("age",age);
        jsonObject.put("sentenced_for",sentence);
        jsonObject.put("solitary",solitary);

        return jsonObject;
    }


    /**
     * retuns name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * returns crime
     *
     * @return crime
     */
    public String getCrime() {
        return crime;
    }

    /**
     * retuns age
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * retuns sentence
     *
     * @return sentence
     */
    public int getSentence() {
        return sentence;
    }

    public Cell getCell(){
        return cell;
    }

    /**
     * is in solitary
     *
     * @return if in solitary
     */
    public boolean isSolitary() {
        return solitary;
    }

    /**
     * sets name
     *
     * @param name name of prisoner
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * set crime
     *
     * @param crime crime commited
     */
    public void setCrime(String crime) {
        this.crime = crime;
    }

    /**
     * set age
     *
     * @param age age of prisoner
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * sets the sentence of prisoner
     *
     * @param sentence sentence of prisoner
     */
    public void setSentence(int sentence) {
        this.sentence = sentence;
    }

    /**
     * sets if prisoner is in solitary
     *
     * @param solitary is the prisoner in solitary
     */
    public void setSolitary(boolean solitary) {
        this.solitary = solitary;
    }

    /**
     * sets the cell where the prisoner sits
     * @param cell cell
     */
    public void setCell(Cell cell) {
        this.cell = cell;
    }
}
