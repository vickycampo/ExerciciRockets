import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Coets {

    private String identificador;
    private ArrayList<Propulsor> propulsores = new ArrayList<>();
    private int factorAcelarcion = 10;

    public Coets ( String indetificador , List<Integer> potencias) throws Exception {
        this.setIdentificador( indetificador);
        int key = 0;
        for (Integer i: potencias)
        {
            this.setPropulsores( key ,  i );
            key++;
        }

    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) throws Exception {

        String pattern = "([A-Z]|\\d){8}";

        // Create a Pattern object
        Pattern p = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = p.matcher(identificador);
        if (m.matches( )) {
            this.identificador = identificador;
        }else {
            throw ( new Exception ( "El indetificador no tiene un formato permitido. Deber tener 8 caracteres." ));
        }

        this.identificador = identificador;
    }

    public List<Propulsor> getPropulsores() {
        return propulsores;
    }

    public void setPropulsores(int key , int potencia) throws Exception {
        if ( potencia > 0 )
        {
            Propulsor propulsor = new Propulsor(potencia);
            this.propulsores.add( key , propulsor );
        }
        else
            throw (new Exception("La potencia de los propulsores debe ser mayor que 0"));

    }
    public void printInfo ()
    {
        System.out.print( identificador + ": ");
        ListIterator iterator = propulsores.listIterator();
        Propulsor propulsor;
        while (iterator.hasNext())
        {
            propulsor = (Propulsor) iterator.next();
            System.out.print(propulsor.getPotenciaMaxima());

            if ( iterator.hasNext() )
            {
                System.out.print(", ");
            }
            else
            {
                System.out.println("");
            }
        }

    }


}
