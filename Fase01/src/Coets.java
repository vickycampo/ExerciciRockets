import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Coets {

    private String identificador;
    private int propulsores;

    public Coets ( String indetificador , int propulsors) throws Exception {
        this.setIdentificador( indetificador);
        this.setPropulsores( propulsors );
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

    public int getPropulsores() {
        return propulsores;
    }

    public void setPropulsores(int propulsores) throws Exception {
        if ( propulsores > 0 )
        {
            this.propulsores = propulsores;
        }
        else
            throw (new Exception("El número de propulsores debe ser mayor que 0"));

    }
    public void printInfo ()
    {
        System.out.println("Información del Cohete:");
        System.out.println("Identificador: " + this.identificador);
        System.out.println("Número de Propulsores: " + this.propulsores);
    }
}
