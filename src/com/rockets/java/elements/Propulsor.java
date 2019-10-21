package com.rockets.java.elements;

public class Propulsor extends Thread
{
    private Thread t;
    private int maxPower;
    private int currentPower;
    private int targetPower;
    private String propulsorId;

    public Propulsor ( String propulsorId , int potencia) throws Exception
    {
        setPorulsorId ( propulsorId );
        setmaxPower( potencia );
        currentPower = 0;
    }
    public void setPorulsorId ( String propulsorId )
    {
        this.propulsorId = propulsorId;
    }
    public String getPropulsorId ()
    {
        return this.propulsorId;
    }
    public int getmaxPower()
    {
        return maxPower;
    }

    public void setmaxPower(int potencia) throws Exception
    {
        if ( potencia > 0 )
        {
            this.maxPower = potencia;
        }
        else
            throw ( new Exception ("El propulsor no puede tener una potencia negativa"));
    }

    public int getcurrentPower()
    {
        return this.currentPower;
    }

    public void acelerar ( int factorAcelarcion )
    {
        targetPower = 0;
        if ( ( currentPower + factorAcelarcion >=0 ) && ( currentPower + factorAcelarcion <= maxPower) )
        {
            //como la potencia mas el incremento de acelarción es menor o igual que la potencia máxima aún podemos acelerar.
            targetPower = currentPower + factorAcelarcion;
        }
        else if  ( currentPower + factorAcelarcion > maxPower)
        {
            targetPower = maxPower;
        }
        else if ( currentPower + factorAcelarcion < 0 )
        {
            targetPower = 0;
        }
        start ();
    }

    public void frenar (  int factorAcelarcion  )
    {
        targetPower = 0;
        if ( currentPower - factorAcelarcion >= 0)
        {
            //No generaremos un una potencia negativa
            targetPower = currentPower - factorAcelarcion;
        }
        else
        {
            targetPower = 0;
        }
    }
    public void start ()
    {
        System.out.println("Inicializando Propulsor " + propulsorId + "." );
        if (t == null)
        {
            t = new Thread (this);
            t.start ();
        }

    }
    public void run()
    {
        int incrementFactor = 1;
        int sleepTime = (int)(200 + Math.random()*50);
        System.out.println("Running " + propulsorId + "." );
        try
        {
            if ( currentPower < targetPower )
            {
                while ( currentPower < targetPower )
                {
                    currentPower += incrementFactor;
                    System.out.println( propulsorId + " power: " + currentPower );
                    Thread.sleep(sleepTime);
                }
            }
            else if ( currentPower > targetPower )
            {
                while ( currentPower > targetPower )
                {
                    System.out.println(currentPower);
                    currentPower -= incrementFactor;
                    Thread.sleep(sleepTime);
                }
            }
        }
        catch (InterruptedException e) {
            System.out.println("Propulsor " +  propulsorId + " interrupted.");
        }
        System.out.println("Propulsor " +  propulsorId + " exiting.");
    }

    
}
