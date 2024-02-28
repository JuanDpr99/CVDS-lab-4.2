package co.edu.escuelaing.hangman.model;

public interface GameScore {

    public int calculateScore(int correctCount, int incorrectCount);
}