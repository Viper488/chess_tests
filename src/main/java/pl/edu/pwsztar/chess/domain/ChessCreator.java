package pl.edu.pwsztar.chess.domain;

class ChessCreator {
    Point fromChessCoordinates(String coordinates){
        return new Point(coordinates.charAt(2), coordinates.charAt(0)-96);
    }
}
