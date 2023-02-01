package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static class MyThread implements Runnable {
        private List<Integer> list;
        private int no;
        private static List<Integer> minArray = new ArrayList<Integer>();

        public MyThread(List<Integer> list, int i) {
            this.list = list;
            this.no = i;
        }

        @Override
        public void run() {
            Integer min = 999;
            for(Integer el : list)
                if(el < min)
                    min = el;
            System.out.println("Thread" + no + " - " + min);
            minArray.add(min);
            System.out.println("Min lista: " + minArray);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(11, 2, 234, 23, 12, 3, 2, 34, 7, 4, 678, 9, 78, 97, 5, 54, 69);

        int i = 0;
        int quarterSize = list.size() / 4;
        while(quarterSize * i < list.size()) {
            Thread thread;
            if(quarterSize * i + 4 > list.size())
                thread = new Thread(new MyThread(list.subList(quarterSize * i, list.size()), i));
            else
                thread = new Thread(new MyThread(list.subList(quarterSize * i, quarterSize * i + 4), i));
            thread.start();
            i++;
        }


        System.out.println("Hello");
    }
}
