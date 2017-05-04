package celtric.katas.game_of_life_2017_05;

public final class Neighbourhood {

    private final int numberOfLiveCells;

    private Neighbourhood(int numberOfLiveCells) {
        this.numberOfLiveCells = numberOfLiveCells;
    }

    public static Neighbourhood of(int numberOfLiveCells) {
        return new Neighbourhood(numberOfLiveCells);
    }

    public boolean isNextGenerationAlive(boolean currentlyAlive) {
        return currentlyAlive ? isStable() : isFertile();
    }

    private boolean isStable() {
        return numberOfLiveCells == 2 || numberOfLiveCells == 3;
    }

    private boolean isFertile() {
        return numberOfLiveCells == 3;
    }
}

// public class Neighbourhood {
//
//     private static class Stable extends Neighbourhood {}
//     private static class Fertile extends Stable {}
//
//     public static Neighbourhood of(int numberOfLiveCells) {
//         switch (numberOfLiveCells) {
//             case 2:  return new Stable();
//             case 3:  return new Fertile();
//             default: return new Neighbourhood();
//         }
//     }
//
//     public boolean isNextGenerationAlive(boolean currentlyAlive) {
//         return currentlyAlive ? this instanceof Stable : this instanceof Fertile;
//     }
// }

// public final class Neighbourhood {
//
//     private final boolean isStable;
//     private final boolean isFertile;
//
//     private Neighbourhood(boolean isStable, boolean isFertile) {
//         this.isStable = isStable;
//         this.isFertile = isFertile;
//     }
//
//     public static Neighbourhood of(int numberOfLiveCells) {
//         switch (numberOfLiveCells) {
//             case 2:
//                 return new Neighbourhood(true, false);
//             case 3:
//                 return new Neighbourhood(true, true);
//             default:
//                 return new Neighbourhood(false, false);
//         }
//     }
//
//     public boolean isNextGenerationAlive(boolean currentlyAlive) {
//         return currentlyAlive ? isStable : isFertile;
//     }
// }
