package com.kenfogel.javadocsexample;

/**
 * This is an example of using Javadocs in your source code. It is only used for
 * commenting a class, a method, or a public field. It cannot be used inline. It
 * begins with a forward slash followed by two asterisks.
 *
 * You can inline certain HTML designations such as:
 * <p>
 * <b>bold</b></p>
 * <p>
 * paragraph</p>
 * <p>
 * <i>italic</i></p>
 *
 * You can even create a list:
 * <ul>
 * <li>First item in the list
 * <li>Second item in the list
 * </ul>
 *
 *
 * There is much discussion on whether the {@literal @version} tag should be
 * used or version should come from a repo such as Git.
 *
 * @version 1.0
 * @author Ken Fogel
 */
public class JavaDocsExample {

    /**
     * This is a private field so this comment will not appear
     */
    private final String name;
    /**
     * This is a public field so this comment, written above the field, will
     * appear using the /** to start the comment.
     */
    public final int number;

    /**
     * In the method's Javadoc, list all the method parameters with the tag
     * {@literal @param}. That this is also a constructor is recognized as the
     * method has the same name as the class and does not have a return type.
     *
     * @param name user's name
     * @param number answer to the ultimate question
     */
    public JavaDocsExample(String name, int number) {
        this.name = name;
        this.number = number;
    }

    /**
     * While you can and should comment private methods as Javadocs, they will
     * not appear in the HTML page. Only public methods appear in the Javadocs.
     *
     * @param day day of the week that will be displayed
     * @return string to display
     */
    private String constructMessage(String day) {
        return name + " " + number + " " + day;
    }

    /**
     * Here is a public method whose Javadoc block will appear in the HTML.
     *
     * @param day day of the week
     */
    public void displayTheMessage(String day) {
        System.out.printf("%s%n", constructMessage(day));
    }

    /**
     * Here is the method where the program will begin
     *
     * @param args values passed at the command line
     */
    public static void main(String[] args) {
        new JavaDocsExample("Ken", 42).displayTheMessage("Wednesday");
    }
}

