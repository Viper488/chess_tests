package pl.edu.pwsztar.chess.domain;

interface RulesOfGame {

    /**
     * Metoda zwraca true, tylko gdy przejscie z polozenia
     * source na destination w jednym ruchu jest zgodne
     * z zasadami gry w szachy
     */
    boolean isCorrectMove(Point source, Point destination);

    class Bishop implements RulesOfGame {

        @Override
        public boolean isCorrectMove(Point source, Point destination) {
            if(source.getX() == destination.getX() && source.getY() == destination.getY()) {
                return false;
            }

            return Math.abs(destination.getX() - source.getX()) ==
                    Math.abs(destination.getY() - source.getY());
        }
    }

    class Knight implements RulesOfGame {

        @Override
        public boolean isCorrectMove(Point source, Point destination) {
            return (Math.abs(destination.getX() - source.getX()) * Math.abs(destination.getY() - source.getY())) == 2;
        }
    }

    class King implements RulesOfGame {

        @Override
        public boolean isCorrectMove(Point source, Point destination) {
            return (destination.getX() == source.getX() ||
                    destination.getX() == source.getX() + 1 ||
                    destination.getX() == source.getX() - 1) &&
                    (destination.getY() == source.getY() ||
                            destination.getY() == source.getY() + 1 ||
                            destination.getY() == source.getY() - 1);
        }
    }

    class Queen implements RulesOfGame {

        @Override
        public boolean isCorrectMove(Point source, Point destination) {
            if((destination.getY() == source.getY() && destination.getX() != source.getX())
                    || (destination.getX() == source.getX() && destination.getY() != source.getY())){
                return true;
            }
            else if(Math.abs(destination.getX() - source.getX()) ==
                    Math.abs(destination.getY() - source.getY()))
            {
                return true;
            }
            return false;
        }
    }

    class Rock implements RulesOfGame {

        @Override
        public boolean isCorrectMove(Point source, Point destination) {
            return (destination.getY() == source.getY() && destination.getX() != source.getX())
                    || (destination.getX() == source.getX() && destination.getY() != source.getY());
        }
    }

    class Pawn implements RulesOfGame {

        @Override
        public boolean isCorrectMove(Point source, Point destination) {
            return destination.getX() != source.getX() && destination.getY() == source.getY();
        }
    }

    // TODO: Prosze dokonczyc implementacje kolejnych figur szachowych: Knight, King, Queen, Rook, Pawn
    // TODO: Prosze stosowac zaproponowane nazwy klas !!!
    // TODO: Kazda klasa powinna implementowac interfejs RulesOfGame
}
