package com.solvd.laba.lacture1.task2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Sorting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int[] arr = new int[6];

        for (int i = 0; i < 6; i++) {
            arr[i] = random.nextInt(100);
        }


        while (true) {
            System.out.println("Random numbers in the array:");
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();

            System.out.println("Choose a sorting algorithm:");
            System.out.println("1. Insertion Sort");
            System.out.println("2. Selection Sort");
            System.out.println("3. Bubble Sort");
            System.out.println("4. Merge Sort");
            System.out.println("5. Quick Sort");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();

            if (choice == 6) {
                System.out.println("Exiting the program.");
                break;
            }

            int[] sortedArray = Arrays.copyOf(arr, arr.length);

            switch (choice) {
                case 1:
                    insertionSort(sortedArray);
                    break;
                case 2:
                    selectionSort(sortedArray);
                    break;
                case 3:
                    bubbleSort(sortedArray);
                    break;
                case 4:
                    mergeSort(sortedArray, 0, sortedArray.length - 1);
                    break;
                case 5:
                    quickSort(sortedArray, 0, sortedArray.length - 1);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }

            System.out.println("Sorted array:");
            for (int num : sortedArray) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    // Insertion Sort
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        System.arraycopy(arr, left, leftArray, 0, n1);
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);

            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}

