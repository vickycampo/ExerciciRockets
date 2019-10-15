public class Propulsor {
    private int potenciaMaxima;
    private int potenciaActual = 0;
    private int factorAcelarcion = 10;

    public Propulsor ( int potencia) throws Exception
    {
        this.setPotenciaMaxima( potencia );
    }

    public int getPotenciaMaxima() {
        return potenciaMaxima;
    }

    /**
     * Establecemos la potencia máxima que tendrá cada propulsor
     * @param potencia
     * @throws Exception
     */
    public void setPotenciaMaxima(int potencia) throws Exception
    {
        if ( potencia > 0 )
        {
            this.potenciaMaxima = potencia;
        }
        else
            throw ( new Exception ("El propulsor no puede tener una potencia negativa"));
    }

    public int getPotenciaActual() {
        return this.potenciaActual;
    }

    /**
     * Acelera el propulsor y devuelve la potencia actual de este propulsor
     * @param factorAcelarcion
     * @return
     */
    public int acelerar ( int factorAcelarcion )
    {
        if ( potenciaActual + factorAcelarcion <= potenciaMaxima)
        {
            //como la potencia mas el incremento de acelarción es menor o igual que la potencia máxima aún podemos acelerar.
            potenciaActual += factorAcelarcion;
        }
        return potenciaActual;
    }

    /**
     * Frena el propulsor y devuelve la potencia actual de este propulsor
     * @param factorAcelarcion
     * @return
     */
    public int frenar (  int factorAcelarcion  )
    {
        if ( potenciaActual - factorAcelarcion >= 0)
        {
            //No generaremos un una potencia negativa
            potenciaActual -= factorAcelarcion;
        }
        return potenciaActual;
    }
    
}
