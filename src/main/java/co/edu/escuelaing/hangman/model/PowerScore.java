package co.edu.escuelaing.hangman.model;

import org.springframework.stereotype.Component;

@Component("powerScore")
public  class PowerScore implements GameScore {

    /**
     * Cálculo de puntaje iniciando con 0 puntos, se penaliza con 8 puntos
     * por cada letra incorrecta y se bonifica 5**i con la i-ésima letra correcta
     * Su puntaje mínimo es 0 y si sobre pasa los 500 puntos devuelve 500
     * @param correctCount número de intentos correctos
     * @param incorrectCount número de intentos incorrectos
     * @return score Total puntaje
     */
    public int calculateScore(int correctCount, int incorrectCount)
    {
        int pow = correctCount == 0 ? 0 : (int)  Math.pow(5,correctCount);
        int score = 0 + ( 8 * incorrectCount) + ( pow ) ;

        if(score < 0 ) {
            return 0;
        }
        else if(score >= 500) {
            return 500;
        }

        return score;
    }
}

