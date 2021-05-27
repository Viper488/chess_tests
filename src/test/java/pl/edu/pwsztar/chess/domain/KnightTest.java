package pl.edu.pwsztar.chess.domain;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnightTest {
    private final RulesOfGame.Knight knight = new RulesOfGame.Knight();

    @Tag("Knight")
    @ParameterizedTest
    @CsvSource({
            " 0,  1,  2,  2",
            "-1, -1, 0, 1",
            "2, 0, 3,  2",
            "4, 2, 5,  4",
    })
    void checkCorrectMoveForKnight(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(knight.isCorrectMove(new Point(xStart, yStart), new Point(xStop, yStop)));
    }

    @ParameterizedTest
    @CsvSource({
            "0,  1,  6,   7",
            "6,  4, 7,   5 "
    })
    void checkIncorrectMoveForKnight(int xStart, int yStart, int xStop, int yStop) {
        assertFalse(knight.isCorrectMove(new Point(xStart, yStart), new Point(xStop, yStop)));
    }
}
