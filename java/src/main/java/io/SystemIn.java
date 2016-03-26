package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by mandy on 2016/3/22.
 */
public class SystemIn {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter the input");
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String s = bufferedReader.readLine();
        System.out.println(s);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the input2");
        System.out.println(scanner.nextLine());
    }
}
