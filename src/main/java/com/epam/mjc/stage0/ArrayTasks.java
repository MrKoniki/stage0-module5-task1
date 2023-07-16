package com.epam.mjc.stage0;


/**
 * Here are the tasks for working with the arrays.
 * <p>
 * The usage of any additional packages (such as java.util.*) is forbidden.
 */
public class ArrayTasks {

    /**
     * Return a String[] array that will list all the seasons of the year, starting with winter.
     */
    public String[] seasonsArray() {
        String[] seasons;
        seasons = new String[]{"Winter", "Spring", "Summer", "Autumn"};
        return seasons;
    }

    /**
     * Generate an int[] array of consecutive positive integers
     * starting at 1 of the given length (length parameter > 0).
     * <p>
     * Example:
     * <p>
     * length = 1  -> [1]
     * length = 3  -> [1, 2, 3]
     * length = 5  -> [1, 2, 3, 4, 5]
     */
    public int[] generateNumbers(int length) {
        int[] mass = new int[length];
        for (int i = 1; i <= length; i ++) {
            mass[i-1] = i;
        }
        return mass;
    }

    /**
     * Find the sum of all elements of the int[] array.
     * <p>
     * Example:
     * <p>
     * arr = [1, 3, 5]   -> sum = 9
     * arr = [5, -3, -4] -> sum = -2
     */
    public int totalSum(int[] arr) {
        int sum = 0;
        for (int i =0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }

    /**
     * Return the index of the first occurrence of number in the arr array.
     * If there is no such element in the array, return -1.
     * <p>
     * Example:
     * <p>
     * arr = [99, -7, 102], number = -7    ->   2
     * arr = [5, -3, -4],   number = 10    ->  -1
     */
    public int findIndexOfNumber(int[] arr, int number) {
        int answer = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == number) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    /**
     * Return the new String[] array obtained from the arr array
     * by reversing the order of the elements.
     * <p>
     * Example:
     * <p>
     * arr = ["Bob", "Nick"]               -> ["Nick", "Bob"]
     * arr = ["pineapple", "apple", "pen"] -> ["pen", "apple", "pineapple"]
     */
    public String[] reverseArray(String[] arr) {
        String[] answer = new String[arr.length];
        int counter = 0;
        for (int i = arr.length-1; i >= 0; i--) {
            answer[counter] = arr[i];
            counter++;
        }
        return answer;
    }

    /**
     * Return new int[] array obtained from arr int[] array
     * by choosing positive numbers only.
     * P.S. 0 is not a positive number =)
     * <p>
     * Example:
     * <p>
     * arr = [1,-2, 3]      -> [1, 3]
     * arr = [-1, -2, -3]   -> []
     * arr = [1, 2]         -> [1, 2]
     */
    public int[] getOnlyPositiveNumbers(int[] arr) {
        int [] positiveNumbers = new int[arr.length];
        int [] answer ;
        int counter = 0;
        for (int i = 0; i < arr.length; i ++) {
            if (arr[i] > 0) {
                positiveNumbers[counter] = arr[i];
                counter++;
            }
        }
        answer = new int[counter];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = positiveNumbers[i];
        }
        return answer;
    }

    /**
     * Return a sorted, ragged, two-dimensional int[][] array following these rules:
     * Incoming one-dimensional arrays must be arranged in ascending order of their length;
     * numbers in all one-dimensional arrays must be in ascending order.
     * <p>
     * Example:
     * <p>
     * arr = [[3, 1, 2,], [3,2]] -> [[2, 3], [1, 2, 3]]
     * arr = [[5, 4], [7]]       -> [[7], [4, 5]]
     */
    public int[][] sortRaggedArray(int[][] arr) {
        int[] mass; //copy mass
        int[][] answer = new int[arr.length][];
        int[] massSize = new int[arr.length];

        for (int k = 0; k < arr.length; k++) {
            mass = new int[arr[k].length];
            massSize[k] = k;
            //duplicate arr to mass
            for (int i = 0; i < arr[k].length; i++) {
                mass[i] = arr[k][i];
            }
            //bubble sort
            for (int i = 0; i < mass.length - 1; i++) {
                for (int j = 0; j < mass.length - i - 2; j++) {
                    if (mass[j] > mass[j++]) {
                        int swap = mass[j];
                        mass[j] = mass[j + 1];
                        mass[j + 1] = swap;
                    }
                }
            }
            //add sort mass to arr
            for (int i = 0; i < mass.length; i++) {
                arr[k][i] = mass[i];
            }
        }
        //sorting ragged array
        for (int i = 0; i < massSize.length - 1; i++) {
            for (int j = 0; j < massSize.length - i - 1; j++) {
                if (arr[massSize[j]].length > arr[massSize[j+1]].length) {
                    int swap = massSize[j];
                    massSize[j] = massSize[j + 1];
                    massSize[j + 1] = swap;
                }
            }
        }

        for (int i = 0; i < massSize.length; i++) {
            //copy mass
            answer[i] = new int[arr[massSize[i]].length];

            for (int k = 0; k < arr[massSize[i]].length; k++) {
                answer[i][k] = arr[massSize[i]][k];
            }
        }
        return answer;
    }
}
