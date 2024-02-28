package co.edu.escuelaing.hangman;

import co.edu.escuelaing.hangman.model.ValidateGameScore;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GameScoreTest {

    @Test
    void contextLoads() throws Exception {
        //TODO
        validateOriginalScoreTest(1,0,100);
        validateOriginalScoreTest(0,1,90);
        validateBonusScoreTest(11,0,110);
        validateBonusScoreTest(0,5,0);
        validatePowerBonusScore(1,0,5);
        validatePowerBonusScore(0,4,0);

    }

    void validateOriginalScoreTest(int correctCount, int incorrectCount, int result){
        //Arrange
        ValidateGameScore validateGameScore = new ValidateGameScore();
        int myScore;
        //Act
        myScore = validateGameScore.validateOriginalScore(correctCount,incorrectCount);
        //Assert
        Assertions.assertEquals(result, myScore);
    }
    void validateBonusScoreTest(int correctCount, int incorrectCount, int result) throws Exception {
        //Arrange
        ValidateGameScore validateBonusScore = new ValidateGameScore();
        int myScore;
        //Act
        myScore = validateBonusScore.validateBonusScore(correctCount,incorrectCount);
        //Assert
        Assertions.assertEquals(result, myScore);
    }
    void validatePowerBonusScore(int correctCount, int incorrectCount, int result) throws Exception {
        //Arrange
        ValidateGameScore validatePowerBonusScore = new ValidateGameScore();
        int myScore;
        //Act
        myScore = validatePowerBonusScore.validatePowerBonusScore(correctCount,incorrectCount);
        //Assert
        Assertions.assertEquals(result, myScore);
    }

}
