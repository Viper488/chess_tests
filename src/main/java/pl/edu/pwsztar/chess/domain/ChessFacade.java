package pl.edu.pwsztar.chess.domain;

import org.springframework.transaction.annotation.Transactional;
import pl.edu.pwsztar.chess.dto.FigureMoveDto;

@Transactional
public class ChessFacade {

    private final ChessCreator chessCreator;
    private final ChessMap chessMap;
    // ...

    public ChessFacade(ChessCreator chessCreator, ChessMap chessMap) {
        this.chessCreator = chessCreator;
        this.chessMap = chessMap;
        // ...
    }

    public boolean isCorrectMove(FigureMoveDto figureMoveDto) {

        Point source = chessCreator.fromChessCoordinates(figureMoveDto.getSource());
        Point destination = chessCreator.fromChessCoordinates(figureMoveDto.getDestination());

        return chessMap.getMapChessFigureMethod(figureMoveDto.getType()).isCorrectMove(source, destination);
    }
}
