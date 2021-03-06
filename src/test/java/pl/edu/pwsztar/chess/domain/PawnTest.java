package pl.edu.pwsztar.chess.domain;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PawnTest {
    private final RulesOfGame.Pawn pawn = new RulesOfGame.Pawn();

    @Tag("Pawn")
    @ParameterizedTest
    @CsvSource({
            " 0,  0,  1,  0",
            "-1, -1, 0, -1",
            "6,  6, 5,   6 ",
            " 4,  3,  5,  3 ",
    })
    void checkCorrectMoveForPawn(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(pawn.isCorrectMove(new Point(xStart, yStart), new Point(xStop, yStop)));
    }

    @ParameterizedTest
    @CsvSource({
            "0,  1,  -1,   0",
            "2, 0, 3,  1"
    })
    void checkIncorrectMoveForPawn(int xStart, int yStart, int xStop, int yStop) {
        assertFalse(pawn.isCorrectMove(new Point(xStart, yStart), new Point(xStop, yStop)));
    }
}
