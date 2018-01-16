

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public void run() {
        Prison school = new Prison("school");
        Scanner scanner = new Scanner(System.in);
        /*
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

        school.load_prisoners("prisoners.json" );
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

        school.save_prisoners("test.json");
        */
        int menuoption = -1;
        boolean menu = true;
        while(menu){
            System.out.println("menu");
            System.out.println("1) print all prisoners");
            System.out.println("2) add prisoner");
            System.out.println("3) remove prisoner");
            System.out.println("4) save prisoners");
            System.out.println("5) load prisoners");
            System.out.println("6) quit");
            System.out.println("> ");
            menuoption = scanner.nextInt();
            switch (menuoption){
                case 1:{
                    System.out.println("All prisoners");
                    printarray(school.printAllPrisoner());
                    menuoption= -1;
                    break;
                }
                case 2:{
                    String name, crime;
                    int age, sentence;
                    boolean solitary;
                    scanner.nextLine();
                    System.out.println("prisoner adding system");
                    System.out.println("enter the name of the prisoner");
                    name = scanner.nextLine();
                    System.out.println("enter the crime committed");
                    crime = scanner.nextLine();
                    System.out.println("enter the age of the prisoner");
                    age = scanner.nextInt();
                    System.out.println("enter the sentence of the prisoner");
                    sentence = scanner.nextInt();
                    System.out.println("is the prisoner in solitary (true/false)");
                    solitary = scanner.nextBoolean();
                    school.addPrisoner(name,crime,age,sentence,solitary);
                    System.out.printf("The prisoner: %s has been added to the system",name);
                    menuoption = -1;
                    break;
                }
                case 3:{
                    String name;
                    System.out.println("Enter the name of the prisoner you want to remove");
                    name = scanner.nextLine();
                    if(school.remove_prisoner(name)){
                        System.out.println("the prisoner has been removed");
                    }else{
                        System.out.println("the prisoner has not been found in the system");
                    }
                    menuoption = -1;
                    break;
                }
                case 4:{
                    school.save_prisoners("prisoners.json");
                    System.out.println("the prisoners have been saved");
                    menuoption = -1;
                    break;
                }
                case 5:{
                    school.load_prisoners("prisoners.json");
                    System.out.println("the prisoners have been loaded in the system");
                    menuoption= -1;
                    break;
                }
                case 6:{
                    menu = false;
                    break;
                }
                default:{
                    System.out.println("this has never happened before");
                }
            }
        }
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
