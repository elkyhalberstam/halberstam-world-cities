import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class WorldCities {

    private ArrayList<String[]> cityList = new ArrayList<>();

    public WorldCities() throws IOException {
        InputStream inputStream = getClass().getClassLoader()
                .getResourceAsStream("worldcities.csv");
        //File csvData = new File("src/main/resources/worldcities.csv");
        CSVParser parser = CSVParser.parse(inputStream, Charset.defaultCharset(), CSVFormat.RFC4180);
            List<CSVRecord> cities= parser.getRecords();
            for (CSVRecord city : cities) {
                String name = city.get(1);
                String lat = city.get(2);
                String lng = city.get(3);
                String[] row= {name, lat, lng};
                cityList.add(row);
            }
    }

    public double getDistance(double lat1, double lng1, double lat2, double lng2 ) {
        return Math.sqrt(((lat2 - lat1) * (lat2 - lat1)) + ((lng2 - lng1) * (lng2 - lng1)));
    }

    public String[] getNearestCity(double lat, double lng) {
        int ixCity = 1;
        double minDistance = getDistance(lat, lng, Double.parseDouble(cityList.get(1)[1]), Double.parseDouble(cityList.get(1)[2]));
        for (int i = 2; i < cityList.size(); i++) {
            double currDistance = getDistance(lat, lng, Double.parseDouble(cityList.get(i)[1]), Double.parseDouble(cityList.get(i)[2]));
            if(currDistance < minDistance)
            {
                ixCity = i;
                minDistance = currDistance;
            }

        }
        return cityList.get(ixCity);
    }

}
