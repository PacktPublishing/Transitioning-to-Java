package com.kenfogel.patternswitch;

/**
 * Example of using the preview pattern matching switch To be able to run this
 * with you need Java 19. Do not forget to change your path to Java 19 and set
 * JAVA_HOME to Java 19
 *
 * @author Ken Fogel
 */
public class PatternSwitch {

    public void perform() {
        int age = 4;
        String designation = switch ((Integer) age) {
            case Integer i when i < 12 ->
                "child";
            case Integer i when i < 18 ->
                "teenager";
            case Integer i when i < 25 ->
                "young adult";
            case Integer i when i < 65 ->
                "adult";
            default ->
                "senior";
        };
        System.out.printf("Designation is %s%n", designation);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new PatternSwitch().perform();
    }
}
