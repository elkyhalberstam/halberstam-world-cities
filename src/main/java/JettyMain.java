import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

//http://localhost:8080/worldCities?lat=40.771724&lon=-73.988326
public class JettyMain {

    public static void main(String[] args) throws Exception {
        // Starts loads the server on port 8080
        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8080);
        server.setConnectors(new Connector[]{connector});

        // Adds the WordleDictionaryServlet to the Server
        ServletHandler handler = new ServletHandler();
        handler.addServletWithMapping(WorldCitiesServlet.class, "/worldCities");
        server.setHandler(handler);

        // Starts the server until this program exists.
        // You must stop the program manually
        server.start();
    }
}