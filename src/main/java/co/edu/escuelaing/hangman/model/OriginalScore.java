package co.edu.escuelaing.hangman.model;
//import co.edu.escuelaing.hangman.model.GameScore;

import org.springframework.stereotype.Component;

@Component("originalScore")
public class OriginalScore implements GameScore{

    /**
     * Cálculo de puntaje iniciando en 100 puntos y penalizando con 10 puntos
     * por cada letra incorrecta
     * @param correctCount número de intentos correctos
     * @param incorrectCount número de intentos incorrectos
     * @return score Puntaje total
     */
    public int calculateScore(int correctCount, int incorrectCount)
    {
        int score = 100 - 10 * incorrectCount;
        if (score < 0) {
            return 0;
        }
        return score;
    }
}