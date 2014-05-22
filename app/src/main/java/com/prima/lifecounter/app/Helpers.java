package com.prima.lifecounter.app;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by Primoz on 18.5.2014.
 */
public class Helpers {

    public static int[] Colors = new int[]{
        Color.WHITE, Color.RED, Color.GREEN, Color.BLUE, Color.CYAN, Color.YELLOW, Color.MAGENTA
    };

    public final static CharSequence[] getColorNames(){
        return new CharSequence[]{"White", "Red", "Green", "Blue", "Cyan", "Yellow", "Magenta"};
    }

    public static Integer getColor(Integer i){
        return Helpers.Colors[i];
    }

    public static int getRandomColor(){
        int ri = Helpers.randInt(0,Helpers.Colors.length-1);
        return Helpers.Colors[ri];
    }

    public static int randInt(int min, int max) {

        // Usually this should be a field rather than a method variable so
        // that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

}
