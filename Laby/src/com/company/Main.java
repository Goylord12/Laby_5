package com.company;


import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

// Дан одномерный массив из 12 элементов. Отсортировать положительные элементы по возрастанию быстрой сортировкой


public class Main {

    public static void quickSort(int[] arr, int low, int high) {
        if (arr.length == 0)
            return;//завершить выполнение, если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент

        int middle = low + (high - low) / 2;
        int opora = arr[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < opora) {
                i++;
            }

            while (arr[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(arr, low, j);

        if (high > i)
            quickSort(arr, i, high);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random ran = new Random();

        int size = 12;
        int min = -100;
        int max = 100;

        int aver = max - min;
        int[] myArr = new int[size];


        for (int i = 0; i < myArr.length; i++) {
            myArr[i] = ran.nextInt(aver + 1);
            myArr[i] += min;
            System.out.print(myArr[i] + " ");
        }
        System.out.println();
        System.out.println("Было");
        System.out.println(Arrays.toString(myArr));

        int low = 0;
        int high = myArr.length - 1;

        quickSort(myArr, low, high);
        System.out.println("Стало");
        System.out.println(Arrays.toString(myArr));
    }
}