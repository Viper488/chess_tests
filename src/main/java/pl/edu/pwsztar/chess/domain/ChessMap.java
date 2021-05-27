package pl.edu.pwsztar.chess.domain;

import pl.edu.pwsztar.chess.dto.FigureType;

import java.util.HashMap;

public class ChessMap {
    private HashMap<FigureType, RulesOfGame> mapChessFigureMethod = new HashMap<>();
    private RulesOfGame bishop;
    private RulesOfGame knight;
    private RulesOfGame king;
    private RulesOfGame queen;
    private RulesOfGame rock;
    private RulesOfGame pawn;

    public ChessMap() {
        bishop = new RulesOfGame.Bishop();
        knight = new RulesOfGame.Knight();
        king = new RulesOfGame.King();
        queen = new RulesOfGame.Queen();
        rock = new RulesOfGame.Rock();
        pawn = new RulesOfGame.Pawn();

        mapChessFigureMethod.put(FigureType.KING, king);
        mapChessFigureMethod.put(FigureType.QUEEN, queen);
        mapChessFigureMethod.put(FigureType.KNIGHT, knight);
        mapChessFigureMethod.put(FigureType.ROCK, rock);
        mapChessFigureMethod.put(FigureType.BISHOP, bishop);
        mapChessFigureMethod.put(FigureType.PAWN, pawn);
    }

    public RulesOfGame getMapChessFigureMethod(FigureType figureType) {
        return mapChessFigureMethod.get(figureType);
    }
}
