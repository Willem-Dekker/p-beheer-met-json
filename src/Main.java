import java.util.ArrayList;

public class Main {
    public void run() {
        Prison school = new Prison("school");
        school.addPrisoner("Jack the ripper", "Murder", 38, 40, true);
        school.addPrisoner("Casa Nova", "Stealing a heart", 21, 5, false);
        school.addPrisoner("Neptunis", "killing the dead sea", 53, 80, true);
        school.addPrisoner("Lazy Student", "Killing the time", 18, 3, false);
        school.addPrisoner("Justin Bieber", "Singing", 16, 7, true);
        school.addPrisoner("Lazy lecturer", "doing nothing", 34, 5, false);
        school.addPrisoner("Bill Clinton", "Not having sex with that woman", 66, 10, false);
        school.addPrisoner("Steve jobs", "Passing away before iphoneX release", 58, 5, false);
        school.addPrisoner("Harry Potter", "Killing voldermord", 18, 3, true);
        school.addPrisoner("Demo Dog", "attempted to kill Eleven", 2, 2, true);

        ArrayList<Prisoner> all = school.printAllPrisoner();
        System.out.println("all");
        printarray(all);
        ArrayList<Prisoner> abouveAge =school.printAllPrisoner(18);
        System.out.println("abouveAge");
        printarray(abouveAge);
        ArrayList<Prisoner> cirme =school.printAllPrisoner("Kill");
        System.out.println("cirme");
        printarray(cirme);
        ArrayList<Prisoner> inSolitary =school.printAllPrisoner(true);
        System.out.println("inSolitary");
        printarray(inSolitary);
        ArrayList<Prisoner> inSolitaryAboveAge =school.printAllPrisoner(false, 18);
        System.out.println("inSolitaryAboveAge");
        printarray(inSolitaryAboveAge);

        school.printCells();
    }

    public static void main(String[] args) {
        // write your code here
        new Main().run();
    }

    public static void printarray(ArrayList<Prisoner> arrayList){
        for (Prisoner p: arrayList) {
            System.out.printf("%s is locked up for: %s and is %d years old and needs to sit %d years and is in solitary: %s\n", p.getName(), p.getCrime(), p.getAge(), p.getSentence(), p.isSolitary());
        }
    }


}
