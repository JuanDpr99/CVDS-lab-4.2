package co.edu.escuelaing.hangman.model;

public class ValidateGameScore {

    public int validateOriginalScore (int correctCount, int incorrectCount){
        int score = 100-(10*incorrectCount);
        if (score <= 0){
            return 0;
        } else if (score >= 100) {
            return 100;
        }
        return score;

    }
    public int validateBonusScore(int correctCount, int incorrectCount) throws Exception {
        int score = (10 * correctCount) - (5 * incorrectCount);
        if (correctCount < 0 || incorrectCount < 0) {
            throw new Exception();
        }
        if (score <= 0){
            return 0;
        }
        return score;

    }

    public int validatePowerBonusScore(int correctCount, int incorrectCount){
        int score = (int) ((Math.pow(5,correctCount)) - (8 * incorrectCount));
        if (score <= 0){
            return 0;
        } else if (score >= 500) {
            return 500;
        }
        return score;
    }
}

