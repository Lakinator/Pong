package Game;

/**
 * 01.12.2016
 * Created by user Schalk (Lukas Schalk).
 */

public class Score {
    private static int neededWins = 3;
    private static int playerLeftWinCount = 0, playerRightWinCount = 0;

    public static int getPlayerLeftWinCount() {
        return playerLeftWinCount;
    }

    static void setPlayerLeftWinCount(int playerLeftWinCount) {
        Score.playerLeftWinCount = playerLeftWinCount;
    }

    public static int getPlayerRightWinCount() {
        return playerRightWinCount;
    }

    static void setPlayerRightWinCount(int playerRightWinCount) {
        Score.playerRightWinCount = playerRightWinCount;
    }

    public static int getNeededWins() {
        return neededWins;
    }

    static void setNeededWins(int neededWins) {
        Score.neededWins = neededWins;
    }
}
