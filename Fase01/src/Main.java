public class Main {
    public static void main (String[] args)
    {
        /* Creamos dos cohetes */

        String identificador1 = "32WESSDS";
        int propulsors1 = 3;
        try {
            Coets cohete1 = new Coets( identificador1 , propulsors1 );
            cohete1.printInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String identificador2 = "LDSFJA32";
        int propulsors2 = 3;
        try {
            Coets cohete2 = new Coets( identificador2 , propulsors2 );
            cohete2.printInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
