package com.lugowoy.tasks.onedimensional.insertAnIntegerInSequencePositionWithoutViolatingIncrease;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayNumbers;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.ArrayLength;

import java.util.Arrays;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_INTEGER_NEGATIVE_BOUND;
import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_INTEGER_POSITIVE_BOUND;

/** Created by Konstantin Lugowoy on 11.03.2017. */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthArray = ArrayLength.getLengthArray(new ReadingConsole());

        Array<Integer> array = FactoryArray.getFactoryArray(new CreatorArrayNumbers<Integer>()).create(
                                                                new FillingArrayRandomIntegerNumbers().fill(lengthArray,
                                                                                                            DEFAULT_INTEGER_NEGATIVE_BOUND,
                                                                                                            DEFAULT_INTEGER_POSITIVE_BOUND));

        System.out.println("Original sequence : ");
        Arrays.stream(array.getArray()).forEachOrdered(integer -> System.out.print(integer + " "));
        System.out.println();

        System.out.println("Sorted sequence : ");
        Sorting<Integer> sorting = Sorting::sortingIntegerSequence;
        sorting.sort(array);
        Arrays.stream(array.getArray()).forEachOrdered(integer -> System.out.print(integer + " "));
        System.out.println();

        System.out.println("Enter numbers to insert : ");
        int insertNumber = Reader.getReader(new ReadingConsole()).readInt();
        System.out.println();

        System.out.println("Result sequence : ");
        Inserting<Integer> inserting = Inserting::insertElement;
        inserting.insert(insertNumber, array);
        Arrays.stream(array.getArray()).forEachOrdered(integer -> System.out.print(integer + " "));

    }

}
