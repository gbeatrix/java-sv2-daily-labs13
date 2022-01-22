package day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Quiz {
    private String answers;
    private Map<String, String> contestants = new TreeMap<>();

    public String getAnswers() {
        return answers;
    }

    public Map<String, String> getContestants() {
        return contestants;
    }

    public void readData(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            answers = br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                addAnswer(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("File not found", e);
        }
    }

    public boolean hasCorrectAnswer(String id, int number) {
        return contestants.get(id).charAt(number - 1) == answers.charAt(number - 1);
    }

    public String getWinner() {
        String winnerId = null;
        int maxPoints = Integer.MIN_VALUE;
        for (Map.Entry<String, String> entry : contestants.entrySet()) {
            int points = getPointsByAnswers(entry.getValue());
            if (points > maxPoints) {
                maxPoints = points;
                winnerId = entry.getKey();
            }
        }
        return winnerId;
    }

    public int getPointsByAnswers(String actual) {
        int sum = 0;
        for (int i = 0; i < answers.length(); i++) {
            if (answers.charAt(i) == actual.charAt(i)) {
                sum += i + 1;
            } else if (actual.charAt(i) != 'X') {
                sum -= 2;
            }
        }
        return sum;
    }

    private void addAnswer(String line) {
        String[] parts = line.split(" ");
        String id = parts[0];
        char answer = parts[1].charAt(0);
        String prev = contestants.computeIfAbsent(id, k -> "");
        contestants.put(id, prev + answer);
    }
}
