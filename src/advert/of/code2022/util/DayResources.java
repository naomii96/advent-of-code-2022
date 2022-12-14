package advert.of.code2022.util;

import advert.of.code2022.common.Part;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DayResources {
    private static final String DAY_ONE_TEST = "resources/day-one/test.txt";
    private static final String DAY_ONE_PART_ONE = "resources/day-one/one.txt";

    public static String readResource(final String dayResource, final Part part) throws IOException {
        switch (dayResource) {
            case "day_one":
                if (Part.TEST.equals(part)) {
                    return new String(Files.readAllBytes(Paths.get(DAY_ONE_TEST)));
                } else if (Part.ONE.equals(part)) {
                    return new String(Files.readAllBytes(Paths.get(DAY_ONE_PART_ONE)));
                }
            default:
                return "resources not defined";
        }
    }
}
