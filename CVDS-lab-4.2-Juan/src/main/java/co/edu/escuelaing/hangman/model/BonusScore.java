package co.edu.escuelaing.hangman.model;

import org.springframework.stereotype.Component;

@Component("bonusScore")
public class BonusScore implements GameScore {

    /**
     * Cálculo de puntaje iniciando con 0 puntos, penalizando con 5 puntos
     * por cada letra incorrecta y bonificando con 10 puntos por cada letra correcta
     * @param correctCount número de intentos correctos
     * @param incorrectCount número de intentos incorrectos
     * @return score Total puntaje
     */
    public int calculateScore(int correctCount, int incorrectCount)
    {
        int score = 0 + (10 * correctCount) - (5 * incorrectCount);
        if(score < 0)
        {
            return 0 ;
        }
        else if(score > 100)
        {
            return  100;
        }
        return score;
    }
}