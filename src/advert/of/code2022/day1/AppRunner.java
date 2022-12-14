package advert.of.code2022.day1;

import advert.of.code2022.common.Part;
import advert.of.code2022.common.PuzzleReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AppRunner {

    public static void main(String[] args) throws IOException {
        List<String> puzzleInput = PuzzleReader.transformPuzzleInputToList("day_one", Part.ONE);

        part1(puzzleInput);

        part2(puzzleInput);
    }

    private static void part1(List<String> puzzleInput) {
        Map<Integer, Long> numberOfElvesAndCalorieCarried = getNumberOfElvesAndCalorieCarried(puzzleInput);
        long highestCalories = findHighestCalories(numberOfElvesAndCalorieCarried, 1);
        System.out.println("Day 1 - Part One result [ " + highestCalories + " ]");
    }

    private static void part2(List<String> puzzleInput) {
        Map<Integer, Long> numberOfElvesAndCalorieCarried = getNumberOfElvesAndCalorieCarried(puzzleInput);
        long highestCalories = findHighestCalories(numberOfElvesAndCalorieCarried, 3);
        System.out.println("Day 1 - Part Two result [ " + highestCalories + " ]");
    }

    private static long findHighestCalories(final Map<Integer, Long> numberOfElvesAndCalorieCarried, final int top) {
        Map<Integer, Long> highest = new HashMap<>();
        for (int i = 0; i < top; i++) {
            Optional<Map.Entry<Integer, Long>> max = numberOfElvesAndCalorieCarried.entrySet().stream()
                    .max(Map.Entry.comparingByValue());
            highest.put(max.get().getKey(), max.get().getValue());
            numberOfElvesAndCalorieCarried.remove(max.get().getKey(), max.get().getValue());
        }
        System.out.println(highest);
        return highest.values().stream().mapToLong(l -> l).sum();
    }

    private static Map<Integer, Long> getNumberOfElvesAndCalorieCarried(List<String> puzzleInput) {
        Map<Integer, Long> calories = new HashMap<>();

        int elvesCount = 1;
        long numberOfCaloriesCarried = 0;
        for (String input : puzzleInput) {
            if (input.isBlank()) {
                elvesCount += 1;
                numberOfCaloriesCarried = 0;
            } else {
                long foodItemCalary = Long.parseLong(input);
                numberOfCaloriesCarried += foodItemCalary;
            }

            calories.put(elvesCount, numberOfCaloriesCarried);
        }
        return calories;
    }


}
