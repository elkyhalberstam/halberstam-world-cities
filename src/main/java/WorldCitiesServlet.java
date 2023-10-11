import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WorldCitiesServlet extends HttpServlet {

    private WorldCities cities;
    private Gson gson;

    public WorldCitiesServlet() throws IOException {
        this(new WorldCities(), new Gson());
    }

    public WorldCitiesServlet(WorldCities worldCities, Gson gson) {
        this.cities = worldCities;
        this.gson = gson;
    }

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        double lat =  Double.parseDouble(req.getParameter("lat"));
        double lng = Double.parseDouble(req.getParameter("lng"));

        String[] nearestCity = cities.getNearestCity(lat,  lng);

        WorldCitiesResponse worldCitiesResponse = new WorldCitiesResponse(nearestCity[0], Double.parseDouble(nearestCity[1]), Double.parseDouble(nearestCity[2]));
        resp.setContentType("text/json");
        resp.getWriter().println(gson.toJson(worldCitiesResponse));
    }
}