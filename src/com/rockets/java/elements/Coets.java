package com.rockets.java.elements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Coets {

    private String identificador;
    private ArrayList<Propulsor> propulsores;
    private int potenciaActual = 0; //La potencia del cohete en este momento.
    private double speed;

    public Coets ( String indetificador , List<Integer> potencias) throws Exception
    {
        this.setIdentificador( indetificador);
        int key = 0;
        propulsores = new ArrayList<>();
        for (Integer i: potencias)
        {
            this.setPropulsores( key ,  i );
            key++;
        }
        speed = 0;

    }

    public String getIdentificador()
    {
        return identificador;
    }

    public void setIdentificador(String identificador) throws Exception
    {
        // Creamos el patron que debe tener el identificador, 8 caracteres letras o números
        String pattern = "([A-Z]|\\d){8}";
        // Create a Pattern object
        Pattern p = Pattern.compile(pattern);
        // Now create matcher object.
        Matcher m = p.matcher(identificador);
        if (m.matches( ))
            this.identificador = identificador;
        else
            throw ( new Exception ( "El indetificador no tiene un formato permitido. Deber tener 8 caracteres." ));
        this.identificador = identificador;
    }

    public List<Propulsor> getPropulsores()
    {
        return propulsores;
    }

    public void setPropulsores(int key , int potencia) throws Exception
    {
        if ( potencia > 0 )
        {
            Propulsor propulsor = new Propulsor(potencia);
            this.propulsores.add( key , propulsor );
        }
        else
            throw (new Exception("La potencia de los propulsores debe ser mayor que 0"));

    }

    public double getSpeed ()
    {
        return speed;
    }

    public int calculatePotenciaMaxima ()
    {
        int potenciaMax = 0;
        for ( Propulsor propulsor : propulsores)
        {
            potenciaMax += propulsor.getPotenciaMaxima();
        }
        return potenciaMax;
    }

    public void acelar (  int acelerationFactor ) throws Exception
    {
        if ( acelerationFactor < 0)
        {
            throw (new Exception("Si usa una acelación negativa le recomiendo usar la funcion de frenado."));
        }
        else
        {
            int newPotencia = 0;
            for ( Propulsor propulsor : propulsores )
            {
                propulsor.acelerar( acelerationFactor );
                newPotencia += propulsor.getPotenciaActual();
            }
            if ( potenciaActual != newPotencia )
            {
                potenciaActual = newPotencia;
                calculateSpeed ();

            }

        }

    }

    public void frenar (  int acelerationFactor )  throws Exception
    {
        if ( acelerationFactor < 0)
        {
            throw (new Exception("Si usa una acelación negativa le recomiendo usar la funcion de acelerado."));
        }
        else
        {
            int newPotencia = 0;
            for ( Propulsor propulsor : propulsores )
            {
                propulsor.frenar( acelerationFactor );
                newPotencia += propulsor.getPotenciaActual();
            }
            if ( potenciaActual != newPotencia )
            {
                potenciaActual = newPotencia;
                calculateSpeed ();

            }
        }

    }

    private void calculateSpeed ()
    {
        //calculamos la velocidad
        speed = speed + 100*Math.sqrt(potenciaActual);
    }



    @Override
    public String toString ()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Output: \n" + identificador + " : \n");
        Iterator<Propulsor> iterator = propulsores.iterator();
        if (! iterator.hasNext())
        {
            stringBuilder.append ("No tiene propulsores.");
            return stringBuilder.toString();
        }
        do
        {
            stringBuilder.append ( iterator.next().getPotenciaMaxima() );
            if ( iterator.hasNext() )
                stringBuilder.append (", ");
            else
                stringBuilder.append ("\n");
        } while ( iterator.hasNext() );


        return stringBuilder.toString();

    }
}
