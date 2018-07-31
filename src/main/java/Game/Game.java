package Game;

public class Game {
    private int[] rolls = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public Integer getScore() {
        int score = 0;
        int firstFrame = 0;

        for(int frame = 0; frame < 10; frame++) {

            if(isStrike(firstFrame)) {
                score += 10 + nextTwoBallsForStrike(firstFrame);
                firstFrame += 1;
            }
            else if(isSpare(firstFrame)) {
                score += 10 + nextBallForSpare(firstFrame);
                firstFrame += 2;
            }
            else {
                score += rolls[firstFrame] + rolls[firstFrame + 1];
                firstFrame += 2;
            }
        }
        return score;
    }

    private int nextBallForSpare(int firstFrame) {
        return rolls[firstFrame + 2];
    }

    private int nextTwoBallsForStrike(int firstFrame) {
        return rolls[firstFrame + 1] + rolls[firstFrame + 2];
    }

    private boolean isStrike(int firstFrame) {
        return rolls[firstFrame] == 10;
    }

    private boolean isSpare(int firstFrame) {
        return rolls[firstFrame] + rolls[firstFrame + 1] == 10;
    }
}
