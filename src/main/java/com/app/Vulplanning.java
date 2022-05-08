package com.app;

import java.io.IOException;

public class Vulplanning {

    public static void main( String[] args){
        ScannerV3 scannakin = new ScannerV3();
        mainMenu(scannakin);
    }

        //mainMenu
    public static void mainMenu(ScannerV3 scannakin) {
        clearScreen();
        mainMenuLoop: while (true) {
            printMainMenu();
            int chooseAction = scannakin.nextInt();
            scannakin.nextLine();
            try {
                switch (chooseAction) {
                    case (1):
                        clearScreen();
                        maakPlanning();
                        clearScreen();
                        break;
                    case (2):
                        clearScreen();
                        getMedewerkers(scannakin);
                        clearScreen();
                        break;
                    case (3):
                        clearScreen();
                        Medewerker.medewerkerAdd(scannakin);
                        clearScreen();
                        break;
                    case (4):
                        clearScreen();
                        Medewerker.medewerkerDelete(scannakin);
                        clearScreen();
                        break;
                    case (5):
                        clearScreen();
                        Vracht.vrachtAdd(scannakin);
                        clearScreen();
                        break;
                    case (6):
                        clearScreen();
                        
                        clearScreen();
                        break;
                    case (7):
                        clearScreen();
                        //Medewerker.setWerkTijd(Kaaskoekje);
                        clearScreen();
                        break;
                    case (8):
                        clearScreen();
                        
                        clearScreen();
                        break;
                    case(0):
                        System.out.println("Saving Data.....");
                        break mainMenuLoop;
                    default:
                        System.out.println("Optie bestaat niet. Kies een juiste optie uit de lijst");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error in the mainMenu method!");
                System.out.println(e);
            }
        }
    }

        // clearScreen
        public static void clearScreen() {
            try {
                if (System.getProperty("os.name").contains("Windows"))
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                else
                    Runtime.getRuntime().exec("clear");
            } catch (IOException | InterruptedException ex) {}
        }
    
        // printMainMenu
        private static void printMainMenu() {
            System.out.println("1) Maak de planning");
            System.out.println("2) Lijst met medewerkers");
            System.out.println("3) Nieuwe medewerker aanmaken");
            System.out.println("4) Medewerker verwijderen");
            System.out.println("5) Vracht toevoegen");
            //System.out.println("6) Vulnorm Aanpassen"); 
            //System.out.println("7) Werktijd aanpassen");
            //System.out.println("8) ");
            System.out.println("0) Exit");
        }
        
        private static void maakPlanning() {
        if(checkVracht() && checkMedewerkers() && checkVulnorm()) {

        }
        if (!checkMedewerkers()){
            System.out.println("Er zijn geen medewerkers beschikbaar. Voeg medewerkers toe om de planning te kunnen maken.");
        }
        if (!checkVulnorm()){
            System.out.println("Er is geen vulnorm beschikbaar voor de paden voeg deze toe om de planning te kunnen maken.");
        }
        if (!checkVracht()){
            System.out.println("Er is geen vracht beschikbaar voor de paden voeg deze toe om de planning te kunnen maken.");
        }
            //https://www.geeksforgeeks.org/how-to-write-data-into-excel-sheet-using-java/
        }

    public static boolean checkVracht() {
        if (Pad.padDiepvries.getAantalDozen() == 0){
            return false;
        }
        return true;
    }

    private static boolean checkMedewerkers() {
        return true;
    }

    private static boolean checkVulnorm() {
        if (Pad.padDiepvries.getVulnorm() == 0){
            return false;
        }
        return true;
    }

    private static void getMedewerkers(ScannerV3 scannakin) {
            for (Medewerker e : Medewerker.MedewerkerList) {
                System.out.println(e.getNaam());
            }
        }
}
