package pl.edu.pwsztar.chess.domain;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RockTest {
    private final RulesOfGame.Rock rock = new RulesOfGame.Rock();

    @Tag("Rock")
    @ParameterizedTest
    @CsvSource({
            " 0,  0,  0,  10",
            "-1, -1, 3, -1",
            "6,  4, 6,   -6 ",
            " 4,  3,  -4,  3 ",
    })
    void checkCorrectMoveForRock(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(rock.isCorrectMove(new Point(xStart, yStart), new Point(xStop, yStop)));
    }

    @ParameterizedTest
    @CsvSource({
            "0,  0,  7,   7",
            "-4, -2, -6,  -3"
    })
    void checkIncorrectMoveForRock(int xStart, int yStart, int xStop, int yStop) {
        assertFalse(rock.isCorrectMove(new Point(xStart, yStart), new Point(xStop, yStop)));
    }
}
