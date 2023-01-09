package com.visualnuts.exercice01;

import com.visualnuts.exceptions.VisualNutsException;
import org.junit.Test;

public class Exercice01Test {

    @Test
    public void doTest1(){
        Exercice01.doExercice(1, 100);
    }

    @Test
    public void doTest2() {
        Exercice01.doExercice(1, 500);
    }

    @Test(expected = VisualNutsException.class)
    public void doTest3() {
        Exercice01.doExercice(100, 1);
    }
}
