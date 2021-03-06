package com.lugowoy.tasks.onedimensional.interchangedMaximumAndMinimumElementOfArray;

/** Created by Konstantin Lugowoy on 13.06.2017. */

public class Numbers {

    private int[] numbers;

    private int maxElement;
    private int minElement;

    public Numbers(int minElement, int maxElement, int[] numbers) {
        this.minElement = minElement;
        this.maxElement = maxElement;
        this.numbers = numbers;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public int getMaxElement() {
        return maxElement;
    }

    public void setMaxElement(int maxElement) {
        this.maxElement = maxElement;
    }

    public int getMinElement() {
        return minElement;
    }

    public void setMinElement(int minElement) {
        this.minElement = minElement;
    }

}
