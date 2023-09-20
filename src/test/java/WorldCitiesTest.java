import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class WorldCitiesTest {

    @Test
    public void getNearestCity() throws IOException {
        //given
        WorldCities cities = new WorldCities();
        //when
        String[] nearestCity = cities.getNearestCity(35.68, 139.69);
        //then
        assertEquals("Tokyo", nearestCity[0]);
    }

    @Test
    public void getDistance() throws IOException {
        //given
        WorldCities cities = new WorldCities();
        //when
        double num = cities.getDistance(35.6, 139.6, 13.45, 54.76);
        //then
        assertEquals(87.68379610851711 , num);
    }
}