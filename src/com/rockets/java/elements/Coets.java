package com.rockets.java.elements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Coets {

    private String identificador;
    private ArrayList<Propulsor> propulsores;
    private int potenciaActual; //La potencia del cohete en este momento.
    private int potenciaMaxima;
    private double speed;

    public Coets ( String indetificador , List<Integer> potencias) throws Exception
    {
        this.setIdentificador( indetificador);
        speed = 0;
        potenciaActual = 0;
        potenciaMaxima = 0;

        int key = 0;
        propulsores = new ArrayList<>();
        for (Integer i: potencias)
        {
            potenciaMaxima += i;
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
        String propulsorId;
        if ( potencia > 0 )
        {
            propulsorId = identificador + "_" + key;
            Propulsor propulsor = new Propulsor(propulsorId , potencia);
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
            potenciaMax += propulsor.getmaxPower();
        }
        return potenciaMax;
    }

    public void acelerar (  int acelerationFactor ) throws Exception
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
                newPotencia += propulsor.getmaxPower();
            }
            if ( potenciaActual != newPotencia )
            {
                potenciaActual = newPotencia;
                speed = calculateSpeed( potenciaActual );

            }

        }

    }

    public void frenar (  int acelerationFactor )  throws Exception
    {
        acelerar (-1* acelerationFactor);
    }

    public List<Double> calculateRequiredPower ( double targetSpeed ) throws Exception
    {
        double initialSpeed = 0;
        double requiredPower = Math.pow(((targetSpeed - initialSpeed) / 100 ), 2);
        double maxPower = calculatePotenciaMaxima();
        List<Double> thrusterPower = new ArrayList<>();
        if ( maxPower == requiredPower )
        {
            //if it is the same as the max power. We just set the thrusters to the maxpower.
            for ( Propulsor propulsor : propulsores)
            {
                thrusterPower.add( (double)propulsor.getmaxPower() );
            }

        }
        else if ( maxPower > requiredPower )
        {
            double residue = 0;
            double perThruster = requiredPower/propulsores.size();
            //distribuimos parejo
            for ( Propulsor propulsor : propulsores)
            {
                if ( perThruster <= propulsor.getmaxPower() )
                {
                    thrusterPower.add( perThruster );
                }
                else if ( perThruster > propulsor.getmaxPower() )
                {
                    thrusterPower.add( (double)propulsor.getmaxPower()  );
                    residue += ( perThruster - propulsor.getmaxPower());
                }
            }
            if ( residue > 0 )
            {
                // nos quedó un residuo, rellenamos los propulsores
                for (int i = 0; i < thrusterPower.size(); i++)
                {
                    if ( residue > 0)
                    {
                        if ( propulsores.get(i).getmaxPower() > thrusterPower.get(i) )
                        {
                            //Este propulsor aún puede aumentar
                            if ( propulsores.get(i).getmaxPower() - thrusterPower.get(i) >= residue )
                            {
                                thrusterPower.add(i, residue);
                                residue = 0;
                            }
                            else if ( propulsores.get(i).getmaxPower() - thrusterPower.get(i) < residue )
                            {
                                residue -=  propulsores.get(i).getmaxPower() - thrusterPower.get(i);
                                thrusterPower.add(i, (double)propulsores.get(i).getmaxPower());
                            }
                        }
                        else if ( propulsores.get(i).getmaxPower() == thrusterPower.get(i) )
                        {

                        }
                        else  if ( propulsores.get(i).getmaxPower() < thrusterPower.get(i) )
                        {
                            throw (new Exception("Se le ha asignado una potencia mayor que la máxima. ojo"));
                        }
                    }
                    else if (residue <= 0)
                    {
                        break;
                    }
                }
            }

        }
        else if ( maxPower < requiredPower )
        {
            double roquetMaxSpeed = calculateSpeed ( potenciaMaxima );
            throw ( new Exception("La potencia del cohete no es suficiente para alcanzar la velocidad deseada. \nEste cohere no puede sobrepasar la velocidad de: " + roquetMaxSpeed));
        }

        System.out.println("El cohete requiere una potencia total de " + requiredPower + " \npara llegar a la velocidad de " + targetSpeed);
        System.out.println("Y esta distribuida dela siguiente manera: ");
        System.out.println(thrusterPower.toString());

        return thrusterPower;
    }

    private double calculateSpeed ( double potenciaTotal )
    {
        //calculamos la velocidad
        double initialSpeed = 0;
        return initialSpeed + 100*Math.sqrt(potenciaTotal);
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
            stringBuilder.append ( iterator.next().getmaxPower() );
            if ( iterator.hasNext() )
                stringBuilder.append (", ");
            else
                stringBuilder.append ("\n");
        } while ( iterator.hasNext() );


        return stringBuilder.toString();

    }
}
