import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WorldCitiesServletTest {
    @Test
    public void doGet() throws IOException, ServletException {
        //given
        WorldCities cities = mock();
        doReturn(new String[]{"Tokyo", "35.6897", "139.6922"}).when(cities).getNearestCity(35.68, 139.69);
        Gson gson = new Gson();

        WorldCitiesServlet servlet = new WorldCitiesServlet(cities, gson);

        HttpServletRequest request = mock();
        doReturn("35.68").when(request).getParameter("lat");
        doReturn("139.69").when(request).getParameter("lng");

        HttpServletResponse response = mock();
        PrintWriter out = mock();
        doReturn(out).when(response).getWriter();

        // when
        servlet.doGet(request, response);
        //then
        verify(response).setContentType("text/json");
        verify(out).println(anyString());
    }
}