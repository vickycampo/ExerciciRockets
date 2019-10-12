import java.util.ArrayList;
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
            propulsors1.add(10);
            propulsors1.add(30);
            propulsors1.add(80);
            Coets cohete1 = new Coets( identificador1 , propulsors1 );


            //Creamos el cohete 2
            propulsors2.add(30);
            propulsors2.add(40);
            propulsors2.add(50);
            propulsors2.add(50);
            propulsors2.add(30);
            propulsors2.add(10);

            Coets cohete2 = new Coets( identificador2 , propulsors2 );
            System.out.println(" ");
            System.out.println("2.- Mostramos el codigo del cohete, Número de propulsores, y la potencia máxima de cada propulsor.");
            cohete1.printInfo();
            cohete2.printInfo();

            System.out.println(" ");
            System.out.println("3.- Mostrar en pantalla la velocidad actual de los coets");
            System.out.println("El cohete con identificador " + cohete1.getIdentificador() + " va a una velocidad de " + cohete1.calculateSpeed());
            System.out.println("El cohete con identificador " + cohete2.getIdentificador() + " va a una velocidad de " + cohete2.calculateSpeed());

            System.out.println(" ");
            System.out.println("4.- Acelerar 3 veces.");
            for (int i = 0; i < 3; i++)
            {
                cohete1.acelar( 10 );
                cohete2.acelar( 10 );

            }

            System.out.println(" ");
            System.out.println("5.- Mostrar en pantalla la velocidad actual de los coets");
            System.out.println("El cohete con identificador " + cohete1.getIdentificador() + " va a una velocidad de " + cohete1.calculateSpeed());
            System.out.println("El cohete con identificador " + cohete2.getIdentificador() + " va a una velocidad de " + cohete2.calculateSpeed());

            System.out.println(" ");
            System.out.println("6.- Frenar cinco veces con el cohete 1 y acelerar 7 veces con el cohete 2");
            for (int i = 0; i < 5 ; i++)
            {
                cohete1.frenar(10);
            }
            for (int i = 0; i < 7; i++)
            {
                cohete2.acelar(10);
            }

            System.out.println(" ");
            System.out.println("7.- Mostrar en pantalla la velocidad actual de los coets");
            System.out.println("El cohete con identificador " + cohete1.getIdentificador() + " va a una velocidad de " + cohete1.calculateSpeed());
            System.out.println("El cohete con identificador " + cohete2.getIdentificador() + " va a una velocidad de " + cohete2.calculateSpeed());

            System.out.println(" ");
            System.out.println("8.- Acelerar 15 veces.");
            for (int i = 0; i < 15; i++)
            {
                cohete1.acelar( 10 );
                cohete2.acelar( 10 );
            }

            System.out.println(" ");
            System.out.println("9.- Mostrar en pantalla la velocidad actual de los coets");
            System.out.println("El cohete con identificador " + cohete1.getIdentificador() + " va a una velocidad de " + cohete1.calculateSpeed());
            System.out.println("El cohete con identificador " + cohete2.getIdentificador() + " va a una velocidad de " + cohete2.calculateSpeed());




        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
