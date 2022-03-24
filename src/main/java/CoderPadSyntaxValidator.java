/*
 * Click `Run` to execute the snippet below!
 Let’s say:

‘(‘, ‘{‘, ‘[‘ are called “openers.”
‘)’, ‘}’, ‘]’ are called “closers.”
Write an efficient function that tells us whether or not an input string’s openers and closers are properly nested.

Examples:

“{ [] ( ) }” should return 1
“{ [(] ) }” should return 0
“{ [ }” should return 0
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class CoderPadSyntaxValidator {

    // static Map<String, String> combinations = new HashMap<>() {{
    //   put("}","{");
    //   put("]","[");
    //   put(")","(");
    // }};


    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
        strings.add("This pad is running Java " + Runtime.getRuntime());

        for (String string : strings) {
            System.out.println(string);
        }


        String s1 = "{[(  ) ] }";

        String test1 = "    }{";
        String test2 = "{ [(] ) }";
        String test3 = "{ [ }";
        System.out.println("test1 result "+validateSyntax(test1));
        // System.out.println("test2 result "+validateSyntax(test2));
        // System.out.println("test3 result "+validateSyntax(test3));
        // System.out.println("test1 result"+validateSyntax(test1));
        //validateSyntax(test2);
        //validateSyntax(test3);
    }


    public static Integer validateSyntax(String s ) {
        Map<String, String> combinations = new HashMap<String, String>() {{
            put("}","{");
            put("]","[");
            put(")","(");
        }};
        Collection<String> openers =  combinations.values();
        Set<String> closers =  combinations.keySet();
        String currentChar;
        Stack<String> usedOpeners = new Stack<>();
        for( int i=0; i< s.length(); i++) {
            currentChar = String.valueOf(s.charAt(i));
            if( openers.contains(currentChar) ) {
                usedOpeners.push(currentChar);
                // System.out.println("usedOpeners"+usedOpeners);
            }
            if( closers.contains(currentChar) ) {
                if( usedOpeners == null || usedOpeners.isEmpty()) {
                    System.out.println("Openers are missing for currentChar "+currentChar);
                    return 0;
                }
                if( usedOpeners.peek().equals(combinations.get(currentChar))) {
                    // System.out.println("Match found"+ usedOpeners.peek());
                    usedOpeners.pop();
                    continue;
                } else {
                    System.out.println("No Match found for currentChar "+currentChar+ " openers "+ usedOpeners.peek() +currentChar);
                    return 0;
                }
            }
        }
        if( usedOpeners != null && !usedOpeners.isEmpty()) {//this should be empty
            System.out.println("Closers are missing for usedOpeners"+usedOpeners);
            return 0;
        }
        return 1;

    }
}
