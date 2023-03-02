package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String update = "등록";
        int i = 1;

        Scanner sc = new Scanner(System.in);

        System.out.println("== 명언 앱 ==");

        System.out.print("명령 ) ");

        String s = sc.nextLine().trim();

        while(s.equals("등록")){

                System.out.print("명언 : ");
                sc.nextLine();
                System.out.print("작가 : ");
                sc.nextLine();
                System.out.println(i + "번 명언이 등록되었습니다.");
                i++;
                System.out.print("명령 ) ");
                s = sc.nextLine();

        }
    }
}