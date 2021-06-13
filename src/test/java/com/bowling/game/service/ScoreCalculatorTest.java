package com.bowling.game.service;

import com.bowling.game.repositories.ScoreCardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class ScoreCalculatorTest {

    @InjectMocks
    private ScoreCalculator scoreCalculator;

    @Mock
    private ScoreCardRepository scoreCardRepository;


    @Test
    public void startGame() {
        scoreCalculator.startGame(1, Arrays.asList(1,2,3),1);
        verify(scoreCardRepository,atLeast(30)).save(any());
    }

    @Test
    public void TestFalseSpare() {
        boolean result = scoreCalculator.isRollSpare(1, 3);
        assertFalse(result);
    }

    @Test
    public void TestTrueSpare() {
        boolean result = scoreCalculator.isRollSpare(5, 5);
        assertTrue(result);
    }

    @Test
    public void TestFalseStrike() {
        boolean result = scoreCalculator.isRollStrike(6, 0);
        assertFalse(result);
    }

    @Test
    public void TestTrueStrike() {
        boolean result = scoreCalculator.isRollStrike(10, 5);
        assertTrue(result);
    }
}