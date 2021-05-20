package pl.edu.pwsztar.chess.domain;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class KingTest {
    private final RulesOfGame.King king = new RulesOfGame.King();

    @Tag("King")
    @ParameterizedTest
    @CsvSource({
            " 0,  0,  1,  1",
            "-1, -1, 0, 0",
            "6,  4, 7,   5 ",
            " 4,  3,  3,  4 ",
    })
    void checkCorrectMoveForKing(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(king.isCorrectMove(new Point(xStart, yStart), new Point(xStop, yStop)));
    }

    @ParameterizedTest
    @CsvSource({
            "0,  1,  6,   7",
            "2, 0, 3,  2"
    })
    void checkIncorrectMoveForKing(int xStart, int yStart, int xStop, int yStop) {
        assertFalse(king.isCorrectMove(new Point(xStart, yStart), new Point(xStop, yStop)));
    }
}
