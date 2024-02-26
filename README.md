<h1 align="center">CVDS-lab-4</h1> 
<h1 align="center"> Desarrollo Dirigido por Pruebas + DIP + DI</h1> 

Trabajaremos el juego del ahoracado.

Propuestas de usuarios sobre esquemas de puntuación:

* OriginalScore:
    * Es el esquema actual, se inicia con 100 puntos.
    * No se bonifican las letras correctas.
    * Se penaliza con 10 puntos con cada letra incorrecta.
    * El puntaje minimo es 0.

* BonusScore:
    * El juego inicia en 0 puntos.
    * Se bonifica con 10 puntos cada letra correcta.
    * Se penaliza con 5 puntos cada letra incorrecta.
    * El puntaje mínimo es 0

* PowerBonusScore:
    * El juego inicia en 0 puntos.
    * La $i-ésima$ letra correcta se bonifica con $5^i$.
    * Se penaliza con 8 puntos cada letra incorrecta.
    * El puntaje mínimo es 0
    * Si con las reglas anteriores sobrepasa 500 puntos, el puntaje es
        500.
      
Lo anterior, se traduce en el siguiente modelo, donde se aplica el
principio de inversión de dependencias:

![image](https://github.com/JuanDpr99/CVDS-lab-4.2/assets/77819591/f5cb9817-93fb-4b74-8b70-6b4b7fed8fb3)

### Parte I

Implementación de los tres esquemas de puntuación descritos anteriormente:

<p align="center">Implementación clase `OriginalScore.java` .</p>

```java

package co.edu.escuelaing.hangman.model;
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
```

<p align="center">Implementación clase `PowerScore.java` .</p>

```java

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
```

<p align="center">Implementación clase `BonusScore.java` .</p>

```java

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
```


### Parte II

Adicionamos el metodo ´createGameScore()´ en clase interface encargado de crear las instancias de objetos de menor nivel 

![image](https://github.com/JuanDpr99/CVDS-lab-4.2/assets/77819591/7e99688d-a854-4c69-aa40-c916c666b624)

Cambiamos el comportamiento mediante la configuración de la Inyección:

  * Utilizar el esquema OriginalScore.
    ![image](https://github.com/JuanDpr99/CVDS-lab-4.2/assets/77819591/1d7e372d-9724-40cd-9833-45aa139fd223)

  * Utilizar el esquema BonusScore.

    ![image](https://github.com/JuanDpr99/CVDS-lab-4.2/assets/77819591/46eee86c-df2d-4c99-a317-a00bea0ae9e0)

  * Utilizar el idioma francés.

    ![image](https://github.com/JuanDpr99/CVDS-lab-4.2/assets/77819591/83a50937-9cc0-4480-8b46-01fceadcdd55)


  * Utilizar el diccionario francés.

    ![image](https://github.com/JuanDpr99/CVDS-lab-4.2/assets/77819591/f37da822-1499-4aca-a8e4-819ca9b59db4)

    



