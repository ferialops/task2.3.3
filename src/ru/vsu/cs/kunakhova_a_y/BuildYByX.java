package ru.vsu.cs.kunakhova_a_y;

import java.util.Stack;

public class BuildYByX {
    public static int buildY(int x) throws Exception {
        Stack<Integer> number = new Stack<>();
        int xCopy = x;

        for (int i = 0; i < Integer.toString(x).length(); i++) {
            number.push(xCopy % 10);
            xCopy = xCopy/10;
        }

        int y = 0;
        for (int i = 0; i < Integer.toString(x).length(); i++) {
            y += (int) number.pop() * ((int) Math.pow(10, i));
        }
        return y;
    }
    public static int buildYStandard(int x) throws Exception {
        LinkedListStack number = new LinkedListStack();
        int xCopy = x;

        for (int i = 0; i < Integer.toString(x).length(); i++) {
            number.push(xCopy % 10);
            xCopy = xCopy/10;
        }

        int y = 0;
        for (int i = 0; i < Integer.toString(x).length(); i++) {
            y += (int) number.pop() * ((int) Math.pow(10, i));
        }
        return y;
    }
    private static class IntRef {
        int value;

        public IntRef( int value ) {
            this.value = value;
        }
    }

    public static int buildYByXRecursive( int x ) {
        IntRef result = new IntRef( 0 );
        reverseRec( x, 1, new IntRef( 0 ), result);

        return result.value;
    }

    private static void reverseRec( int x, int curDepth, IntRef maxDepth, IntRef result ) {
        if ( x < 10 ) {
            maxDepth.value = curDepth;
            result.value = x;
        } else {
            reverseRec( x/10, curDepth * 10, maxDepth, result );
            result.value = result.value + (x % 10) * maxDepth.value / curDepth;
        }
    }
}
