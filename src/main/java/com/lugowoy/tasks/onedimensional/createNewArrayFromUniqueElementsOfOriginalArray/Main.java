package com.lugowoy.tasks.onedimensional.createNewArrayFromUniqueElementsOfOriginalArray;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayNumbers;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.ArrayLength;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_INTEGER_NEGATIVE_BOUND;
import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_INTEGER_POSITIVE_BOUND;

/** Created by Konstantin Lugowoy on 29.05.2017. */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthArray = ArrayLength.getLengthArray(new ReadingConsole());

        Array<Integer> array = FactoryArray.getFactoryArray(new CreatorArrayNumbers<Integer>()).create(
                                                                new FillingArrayRandomIntegerNumbers().fill(lengthArray,
                                                                                                            DEFAULT_INTEGER_NEGATIVE_BOUND,
                                                                                                            DEFAULT_INTEGER_POSITIVE_BOUND));

        System.out.println("Original array : " + array);
        System.out.println();

        DeterminantUniqueness determinantUniqueness = DeterminantUniqueness::determineTheUniqueElementsOfTheOriginalArray;

        Array<Integer> newArrayFromTheUniqueElements = determinantUniqueness.determineUniqueness(array);

        System.out.println("New array from the unique elements : " + newArrayFromTheUniqueElements);
        System.out.println();

    }

}
