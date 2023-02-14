package com.kenfogel.threading;

public class JoinExample  {
    
    public int counter = 0;
    public void perform() {

        ThreadClass1 tc1 = new ThreadClass1();
//        ThreadClass tc2 = new ThreadClass();
//        ThreadClass tc3 = new ThreadClass();
//        ThreadClass tc4 = new ThreadClass();
//        ThreadClass tc5 = new ThreadClass();
        
        tc1.start();
//        tc2.start();
//        tc3.start();
//        tc4.start();
//        tc5.start();
//        try {;
//            System.out.println("Joining 2");
//            tc2.join();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        
////        System.out.println("Join thread 1 after starting threads 2 thru 5");
    }
    
    public static void main(String[] args) {
        new JoinExample().perform();
    }
    
   
//    @Override
//    public void run() {
//        //counter++;
//        for (int i = 1; i <= 250; i++) {
//            try {
//                Thread.sleep(500);
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//            System.out.printf("Thread #%d Value #%d%n",counter,i);
//        }
//    }
//
//    public static void main(String args[]) {
//        JoinExample th1 = new JoinExample();
//        th1.counter = 1;
//        JoinExample th2 = new JoinExample();
//        th2.counter = 2;
//        JoinExample th3 = new JoinExample();
//        th3.counter = 3;
//        th1.start();
//
//        th2.start();
//        th3.start();
//        try {
//            th1.join();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
}
