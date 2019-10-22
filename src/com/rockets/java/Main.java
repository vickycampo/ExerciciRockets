package com.rockets.java;

import com.rockets.java.elements.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main (String[] args)
    {
        /* Creamos dos cohetes */

        String identificador1 = "32WESSDS";
        List<Integer> propulsors1 = new ArrayList<>();
        String identificador2 = "LDSFJA32";
        List<Integer> propulsors2 = new ArrayList<>();

        try {
            //creamos el cohete 1
            propulsors1.addAll( Arrays.asList(new Integer[]{10, 30, 80} ) );
            Coets cohete1 = new Coets( identificador1 , propulsors1 );
            cohete1.acelerar(60);

            cohete1.calculateRequiredPower(10000).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            //Creamos el cohete 2
            propulsors2.addAll( Arrays.asList(new Integer[]{ 30 , 40 , 50 , 50 , 30 , 10 } ) );
            Coets cohete2 = new Coets( identificador2 , propulsors2 );
            cohete2.acelerar(60);

            cohete2.calculateRequiredPower(75).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
