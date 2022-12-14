package advert.of.code2022.common;

import advert.of.code2022.util.DayResources;

import java.io.IOException;
import java.util.List;

public class PuzzleReader {

    public static List<String> transformPuzzleInputToList(final String dayResource, final Part part) throws IOException {
        String resource = DayResources.readResource(dayResource, part);
        return List.of(resource.split("\n"));
    }
}
