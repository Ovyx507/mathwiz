/**
 * Created by Ovylock on 22.05.2015.
 */
import java.rmi.*;
import java.util.*;

public class ClientMathWiz
{
    private static final String gazda = "localhost";
    static String stare="0";
    static String memorie="0";
    static String optiune="";
    static Scanner intrare_local=new Scanner(System.in);
    static String a="";

    public static void main(String[] args)
    {
        try
        {
            InterfataMathWiz creierul = (InterfataMathWiz) Naming.lookup("rmi://"
                    + gazda + "/MathWiz");
            calculator(creierul);
        }
        catch (ConnectException eroare)
        {
            System.out.println(">server UNAVAILABLE...");
            System.exit(1);
        }
        catch (Exception eroare)
        {
            eroare.printStackTrace();
            System.exit(1);
        }

    }

    private static void calculator (InterfataMathWiz creierul)throws RemoteException
    {
        System.out.println("Welcome to MathWiz Alpha");
        System.out.println("--------------------------");
        System.out.printf("%-20s %-20s\n", "Commands", "Memory Commands");
        System.out.printf("%-20s %-20s\n", "add(1)", "m+");
        System.out.printf("%-20s %-20s\n", "sub(2)", "m-");
        System.out.printf("%-20s %-20s\n", "mult(2)", "ms");
        System.out.printf("%-20s %-20s\n", "div(4)", "mr");
        System.out.printf("%-20s %-20s\n", "--------------", "mc");
        System.out.println("inv(5)");
        System.out.println("pow(6)");
        System.out.println("fact(7)");
        System.out.println("sqrt(8)");
        System.out.println("quit(8)");

        do {
            optiune=intrare_local.nextLine();
            if(optiune.equals("add")||optiune.equals("1"))
            {
                System.out.print(stare + " + ");
                a=intrare_local.nextLine();
                if(a.equals("mr"))
                    a=memorie;
                stare=creierul.adunare(Double.parseDouble(stare),Double.parseDouble(a));
                System.out.println(stare);
            }
            if(optiune.equals("sub")||optiune.equals("2"))
            {
                System.out.print(stare + " - ");
                a=intrare_local.nextLine();
                if(a.equals("mr"))
                    a=memorie;
                stare=creierul.scadere(Double.parseDouble(stare), Double.parseDouble(a));
                System.out.println(stare);
            }
            if(optiune.equals("mult")||optiune.equals("3"))
            {
                System.out.print(stare + " * ");
                a=intrare_local.nextLine();
                if(a.equals("mr"))
                    a=memorie;
                stare=creierul.inmultire(Double.parseDouble(stare), Double.parseDouble(a));
                System.out.println(stare);
            }
            if(optiune.equals("div")||optiune.equals("4"))
            {
                System.out.print(stare + " / ");
                a=intrare_local.nextLine();
                if(a.equals("mr"))
                    a=memorie;
                if(a.equals("0"))
                    do {
                        System.out.println("cannot divide by zero,try another number");
                        a=intrare_local.nextLine();
                    }
                    while(a.equals("0"));
                stare=creierul.impartire(Double.parseDouble(stare), Double.parseDouble(a));
                System.out.println(stare);
            }
            if(optiune.equals("inv")||optiune.equals("5"))
            {
                if(stare.equals("0"))
                   {
                        System.out.println("cannot divide by zero,try another number");

                    }
                else{
                stare=creierul.inversare(Double.parseDouble(stare));
                System.out.println(stare);}
            }
            if(optiune.equals("pow")||optiune.equals("6"))
            {
                System.out.print(stare + " ^ ");
                a=intrare_local.nextLine();
                if(a.equals("mr"))
                    a=memorie;
                stare=creierul.putere(Double.parseDouble(stare), Double.parseDouble(a));
                System.out.println(stare);
            }
            if(optiune.equals("fact")||optiune.equals("7"))
            {
                if(Double.parseDouble(stare)<0)
                {
                    System.out.println("cannot fact a negative number");

                }
                else{
                stare=creierul.factorial(Double.parseDouble(stare));
                System.out.println(stare);}
            }
            if(optiune.equals("sqrt")||optiune.equals("8"))
            {
                if(Double.parseDouble(stare)<0)
                {
                    System.out.println("cannot sqrt a negative number");

                }
                else{
                    stare=creierul.radacina(Double.parseDouble(stare));
                    System.out.println(stare);}
            }
            if(optiune.equals("m+"))
            {
                memorie=Double.toString(Double.parseDouble(memorie)+Double.parseDouble(stare));
            }
            if(optiune.equals("m-"))
            {
                memorie=Double.toString(Double.parseDouble(memorie) - Double.parseDouble(stare));
            }
            if(optiune.equals("ms"))
            {
                memorie=stare;
            }
            if(optiune.equals("mr"))
            {
                stare=memorie;
                System.out.println(stare);
            }
            if(optiune.equals("mc"))
            {
                memorie="0";
            }
        }
        while(!optiune.equals("quit")&&!optiune.equals("9"));
        System.out.println("\nBye :)");
    }
}
