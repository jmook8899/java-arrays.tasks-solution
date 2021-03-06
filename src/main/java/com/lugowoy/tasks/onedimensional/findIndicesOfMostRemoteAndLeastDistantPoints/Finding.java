package com.lugowoy.tasks.onedimensional.findIndicesOfMostRemoteAndLeastDistantPoints;

import com.lugowoy.helper.calculating.CalculationUsingTwoParameters;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point;

import java.util.Objects;

import static com.lugowoy.helper.other.ArrayChecker.checkArrayNonNull;
import static com.lugowoy.helper.other.ArrayChecker.checkLengthOfArrayIsGreaterZero;

/** Created by Konstantin Lugowoy on 03.07.2017. */

@FunctionalInterface
public interface Finding<T> {

    CalculationUsingTwoParameters<Double, Point<Double>, Point<Double>> CALCULATING = (kFirst, vSecond)
            -> Math.sqrt((Math.pow(kFirst.getCoordinateX() - vSecond.getCoordinateX(), 2))
                                                     + Math.pow(kFirst.getCoordinateY() - vSecond.getCoordinateY(), 2));


    void find(T t);

    static void findIndicesOfMaxDistanceBetweenPoints(Array<Point<Double>> pointArray) {
        int firstIndex = -1, secondIndex = -1;
        double tmpMax;
        try {
            if (checkArrayNonNull(pointArray)) {
                if (checkArrayNonNull(pointArray.getArray()) && checkLengthOfArrayIsGreaterZero(pointArray.getLength())) {
                    double distanceResult = CALCULATING.calculate(pointArray.get(0), pointArray.get(1));
                    for (int i = 1; i < pointArray.getLength() - 1; i++) {
                        for (int j = i + 1; j < pointArray.getLength(); j++) {
                            tmpMax = CALCULATING.calculate(pointArray.get(i), pointArray.get(j));
                            if (tmpMax > distanceResult) {
                                distanceResult = tmpMax;
                                firstIndex = i;
                                secondIndex = j;
                            }
                        }
                    }
                    System.out.printf("Max distance between two points with index %d and %d is equal %f", firstIndex,
                            secondIndex,
                            distanceResult);
                }
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
    }

    static void findIndicesOfMinDistanceBetweenPoints(Array<Point<Double>> pointArray) {
        int firstIndex = -1, secondIndex = -1;
        double distanceResult = -1;
        if (Objects.nonNull(pointArray)) {
            if ((Objects.nonNull(pointArray.getArray()) && (pointArray.getArray().length > 0))) {
                double tmpMin = CALCULATING.calculate(pointArray.getArray()[0], pointArray.getArray()[1]);
                for (int i = 1; i < pointArray.getArray().length - 1; i++) {
                    for (int j = i + 1; j < pointArray.getArray().length; j++) {
                        distanceResult = CALCULATING.calculate(pointArray.getArray()[i], pointArray.getArray()[j]);
                        if (distanceResult < tmpMin) {
                            tmpMin = distanceResult;
                            firstIndex = i;
                            secondIndex = j;
                        }
                    }
                }
                System.out.printf("Min distance between two points with index %d and %d is equal %f", firstIndex, secondIndex, distanceResult);
            }
        }

    }

}
