package com.rockets.java.elements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Coets {

    private String identificador;
    private ArrayList<Propulsor> propulsores;
    private int potenciaTotal = 0; //La potencia del cohete en este momento.
    private double speed = 0;

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

    public int calculatePotenciaMaxima ()
    {
        int potenciaMax = 0;
        for ( Propulsor propulsor : propulsores)
        {
            potenciaMax += propulsor.getPotenciaMaxima();
        }
        return potenciaMax;
    }

    public int acelar (  int acelerationFactor ) throws Exception
    {
        if ( acelerationFactor < 0)
        {
            throw (new Exception("Si usa una acelación negativa le recomiendo usar la funcion de frenado."));
        }
        else
        {

            potenciaTotal = 0;
            for ( Propulsor propulsor : propulsores )
            {
                potenciaTotal += propulsor.acelerar( acelerationFactor );
            }
            return potenciaTotal;
        }

    }

    public int frenar (  int acelerationFactor )  throws Exception
    {
        if ( acelerationFactor < 0)
        {
            throw (new Exception("Si usa una acelación negativa le recomiendo usar la funcion de acelerado."));
        }
        else
        {
            potenciaTotal = 0;
            for ( Propulsor propulsor : propulsores )
            {
                potenciaTotal = propulsor.frenar( acelerationFactor );
            }
            return potenciaTotal;
        }

    }

    public double calculateSpeed ()
    {
        //calculamos la velocidad
        speed = speed + 100*Math.sqrt(potenciaTotal);
        return speed;
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
