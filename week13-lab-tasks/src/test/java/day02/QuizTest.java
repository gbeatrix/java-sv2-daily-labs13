package day02;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class QuizTest {
    @Test
    void testQuiz(){
        Quiz quiz = new Quiz();

        quiz.readData(Path.of("src/main/resources/result.txt"));
        assertEquals("ABACD", quiz.getAnswers());
        assertEquals(4, quiz.getContestants().size());

        assertFalse(quiz.hasCorrectAnswer("AB123", 2));
        assertTrue(quiz.hasCorrectAnswer("BD452", 4));

        assertEquals("GH1234", quiz.getWinner());
        assertEquals(-5, quiz.getPointsByAnswers(quiz.getContestants().get("AB123")));
    }
}