package com.rockets.java.elements;

public class Propulsor {
    private int potenciaMaxima;
    private int potenciaActual = 0;

    public Propulsor ( int potencia) throws Exception
    {
        this.setPotenciaMaxima( potencia );
    }

    public int getPotenciaMaxima()
    {
        return potenciaMaxima;
    }

    public void setPotenciaMaxima(int potencia) throws Exception
    {
        if ( potencia > 0 )
        {
            this.potenciaMaxima = potencia;
        }
        else
            throw ( new Exception ("El propulsor no puede tener una potencia negativa"));
    }

    public int getPotenciaActual()
    {
        return this.potenciaActual;
    }

    public int acelerar ( int factorAcelarcion )
    {
        if ( potenciaActual + factorAcelarcion <= potenciaMaxima)
        {
            //como la potencia mas el incremento de acelarción es menor o igual que la potencia máxima aún podemos acelerar.
            potenciaActual += factorAcelarcion;
        }
        return potenciaActual;
    }

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
