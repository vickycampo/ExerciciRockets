public class Propulsor {
    private int potencia;
    public Propulsor ( int potencia) throws Exception
    {
        this.setPotencia( potencia );
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) throws Exception
    {
        if ( potencia > 0 )
        {
            this.potencia = potencia;
        }
        else
            throw ( new Exception ("El propulsor no puede tener una potencia negativa"));
    }
}
