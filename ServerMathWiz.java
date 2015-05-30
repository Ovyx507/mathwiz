/**
 * Created by Ovylock on 22.05.2015.
 */
import java.rmi.*;

public class ServerMathWiz {

    private static final String gazda = "localhost";

    public static void main(String[] args) throws Exception {

        ImplementareMathWiz creierul = new ImplementareMathWiz();

        String adresa = "rmi://" + gazda + "/MathWiz";

        Naming.rebind(adresa, creierul);

        System.out.println("server RUNNING...");
    }
}
