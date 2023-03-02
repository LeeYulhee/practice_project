package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("== 명언 앱 ==");

        System.out.print("명령 ) ");
        String s = sc.nextLine();

        String update = "등록";

        if(s.equals(update)){
            System.out.print("명언 : ");
            sc.nextLine();
            System.out.print("작가 : ");
            sc.nextLine();
            System.out.println("1번 명언이 등록되었습니다.");
            System.out.print("명령 ) ");
            sc.nextLine();
        }
    }
}