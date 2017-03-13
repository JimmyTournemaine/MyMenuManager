
import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.UnknownHostException;

public class Client {

    private static String portRmiregistry = "12345";
    private RestaurantInterface stub;

    public RestaurantInterface getStubInstance() {
        if (stub == null) stub = connect();
        return stub;
    }

    private static RestaurantInterface connect() {

        RestaurantInterface restaurant = null;
        try {
            InetAddress machine = InetAddress.getLocalHost();
            String hostname = machine.getHostName();

            if (hostname.indexOf(".") != -1)
                hostname = hostname.substring(0, hostname.indexOf("."));

            String nomService = "//" + hostname + ":" + portRmiregistry + "/RestaurantRMI";
            System.out.println(" Connexion au service : " + nomService);

            restaurant = (RestaurantInterface) Naming.lookup(nomService);

        } catch (UnknownHostException e) {
            System.out.println("MyHostName exception: " + e.getMessage());
            e.printStackTrace();
        } catch (RemoteException e) {
            System.out.println("RemoteException: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }

        return restaurant;
    }
}
