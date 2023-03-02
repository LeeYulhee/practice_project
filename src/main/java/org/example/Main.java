package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String update = "등록";
        int i = 1;

        Scanner sc = new Scanner(System.in);

        System.out.println("== 명언 앱 ==");

        System.out.print("명령 ) ");

        String s = sc.nextLine().trim();

        ArrayList<명언> 명언모음 = new ArrayList<>();

        while(true) {
            if (s.equals("등록")) {
                System.out.print("명언 : ");
                String wiseSaying = sc.nextLine();
                System.out.print("작가 : ");
                String writter = sc.nextLine();
                명언모음.add(new 명언(i, writter, wiseSaying));
                System.out.println(i + "번 명언이 등록되었습니다.");
                i++;
                System.out.print("명령 ) ");
                s = sc.nextLine();
            } else if(s.equals("목록")){
                System.out.println("----------------------");
                for(int a = 명언모음.size() -1; a < 명언모음.size() && a >= 0; a--){
                    System.out.println(명언모음.get(a));
                }
                System.out.print("명령 ) ");
                s = sc.nextLine();
            } else if(s.equals("종료")){
                break;
            }
        }
    }
}

class 명언{
    int num;
    String writter;
    String wiseSaying;
    명언(int num, String writter, String wiseSaying){
        this.num = num;
        this.writter = writter;
        this.wiseSaying = wiseSaying;
    }

    @Override
    public String toString() {
        return num + " / " + writter  + " / " + wiseSaying;
    }
}