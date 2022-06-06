package com.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public abstract class LeaderBoard {

    public static ArrayList<Medewerker> medewerkers = new ArrayList<>();
    public static ArrayList<Medewerker> planningMedewerkers = new ArrayList<>();

    public static ArrayList<Medewerker> getUsers(){
        comparator();
        updateRanking();
        return medewerkers;
    }

    public static ArrayList<Medewerker> getPlanningUsers(){
        comparator();
        updateRanking();
        return planningMedewerkers;
    }

    private static void comparator(){
        Comparator<Medewerker> userComparator = Comparator.comparing(Medewerker::getWerktijd);
        Collections.sort(medewerkers, userComparator);
        Collections.reverse(medewerkers);
        updateRanking();
    }

    private static void updateRanking(){
        for (int i = 0; i < medewerkers.size(); i++) {
            medewerkers.get(i).setRank(i+1);
        }
    }
}
