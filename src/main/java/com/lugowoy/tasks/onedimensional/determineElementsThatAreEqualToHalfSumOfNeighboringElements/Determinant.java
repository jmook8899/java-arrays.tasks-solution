package com.lugowoy.tasks.onedimensional.determineElementsThatAreEqualToHalfSumOfNeighboringElements;

import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.ArrayChecker;

import java.util.Objects;

import static com.lugowoy.helper.other.ArrayChecker.*;

/** Created by Konstantin Lugowoy on 03.09.2017. */

@FunctionalInterface
public interface Determinant {

    void determine(Array<Integer> array);

    static void determineElementsThatAreEqualToHalfSumOfNeighboringElements(Array<Integer> array) {
        try {
            if (checkArrayNonNull(array)) {
                if ((checkArrayNonNull(array.getArray())) && (array.getArray().length > 2)) {
                    int counterCoincidence = 0;
                    for (int i = 1; i < array.getLength() - 1; i++) {
                        if (((array.get(i - 1) + array.get((i + 1)) / 2) == array.get(i))) {
                            System.out.printf("Element %d at index %d is equal to half sum element %d at index %d and element %d at index %d.",
                                    array.get(i), i, array.get(i - 1), i - 1, array.get(i + 1), i + 1);
                            System.out.println();
                            counterCoincidence++;
                        }
                    }
                    if (counterCoincidence == 0) {
                        throw new RuntimeException("No items found that satisfied the condition.");
                    }
                }
            }
        } catch (RuntimeException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
