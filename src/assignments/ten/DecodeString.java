package assignments.ten;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        DecodeString string = new DecodeString();
        System.out.println(string.decodeStringRecursive("3[a2[c]]"));
    }

    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder currString = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0'); // to handle multi digit number
            } else if (c == '[') {
                // When '[' is encountered, push the current number and string onto their respective stacks
                numStack.push(num);
                strStack.push(currString);
                num = 0;
                currString = new StringBuilder();
            } else if (c == ']') {
                // When ']' is encountered, build the repeated string
                int repeat = numStack.pop();
                StringBuilder decodedStr = strStack.pop();// Get the string to which the repeated content will be appended
                for (int i = 0; i < repeat; i++) {
                    decodedStr.append(currString); // Append the repeated content
                }
                currString = decodedStr;
            } else {
                currString.append(c);
            }
        }
        return currString.toString();
    }


    //Recursive
    int index = 0;
    public String decodeStringRecursive(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        String tmp_string = "";

        while (index < s.length()) {
            char c = s.charAt(index);
            index++;

            if (c == '[') {
                tmp_string = decodeStringRecursive(s);
                for (int j = 0; j < count; j++) {
                    sb.append(tmp_string);
                }
                count = 0;
            } else if (c == ']') {
                break;
            } else if (Character.isAlphabetic(c)) {
                sb.append(c);
            } else {
                count = count * 10 + c - '0';
            }
        }

        return sb.toString();
    }
}
