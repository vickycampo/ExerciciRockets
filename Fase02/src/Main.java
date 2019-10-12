import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args)
    {
        /* Creamos dos cohetes */

        String identificador1 = "32WESSDS";
        List<Integer> propulsors1 = new ArrayList<>();
        System.out.println("Output:");
        try {
            propulsors1.add(10);
            propulsors1.add(30);
            propulsors1.add(80);
            Coets cohete1 = new Coets( identificador1 , propulsors1 );
            cohete1.printInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String identificador2 = "LDSFJA32";
        List<Integer> propulsors2 = new ArrayList<>();
        try {
            propulsors2.add(30);
            propulsors2.add(40);
            propulsors2.add(50);
            propulsors2.add(50);
            propulsors2.add(30);
            propulsors2.add(10);

            Coets cohete2 = new Coets( identificador2 , propulsors2 );
            cohete2.printInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
