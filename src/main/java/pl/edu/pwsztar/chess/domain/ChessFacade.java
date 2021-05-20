package pl.edu.pwsztar.chess.domain;

import org.springframework.transaction.annotation.Transactional;
import pl.edu.pwsztar.chess.dto.FigureMoveDto;

@Transactional
public class ChessFacade {

    private RulesOfGame bishop;
    private RulesOfGame knight;
    private RulesOfGame king;
    private RulesOfGame queen;
    private RulesOfGame rock;
    private RulesOfGame pawn;
    private final ChessCreator chessCreator;
    // ...

    public ChessFacade(ChessCreator chessCreator) {
        this.chessCreator = chessCreator;
        bishop = new RulesOfGame.Bishop();
        knight = new RulesOfGame.Knight();
        king = new RulesOfGame.King();
        // ...
    }

    public boolean isCorrectMove(FigureMoveDto figureMoveDto) {

        Point source = chessCreator.fromChessCoordinates(figureMoveDto.getSource());
        Point destination = chessCreator.fromChessCoordinates(figureMoveDto.getDestination());

        // refaktoryzacja?
        switch (figureMoveDto.getType()) {
            case BISHOP:
                // wywolaj konwerter punktow oraz popraw ponizszy kod
                return bishop.isCorrectMove(source, destination);
            case KNIGHT:
                // wywolaj konwerter punktow oraz popraw ponizszy kod
                return knight.isCorrectMove(source, destination);
            case KING:
                return king.isCorrectMove(source, destination);
        }

        return false;
    }
}
