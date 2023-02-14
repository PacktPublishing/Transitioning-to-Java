
package com.kenfogel.typesafetytest;

public class TypeSafetyTest {

    private void print_hi(String x) {
        System.out.printf(x);
    }
    
    public void perform() {
        int x = 4;
        print_hi(x);
    }
    
    public static void main(String[] args) {
        var typeTest = new TypeSafetyTest();
        typeTest.perform();
    }
}
