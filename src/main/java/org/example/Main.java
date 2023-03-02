package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String update = "등록";
        int i = 1;

        Scanner sc = new Scanner(System.in);

        System.out.println("== 명언 앱 ==");

        System.out.print("명령 ) ");

        String s = sc.nextLine().trim();

        HashMap<Integer, 명언> 명언모음 = new HashMap<>();

        while(true) {
            if (s.equals("등록")) {
                System.out.print("명언 : ");
                String wiseSaying = sc.nextLine();
                System.out.print("작가 : ");
                String writter = sc.nextLine();
                명언모음.put(i, new 명언(writter, wiseSaying));
                System.out.println(i + "번 명언이 등록되었습니다.");
                i++;
                System.out.print("명령 ) ");
                s = sc.nextLine().trim();
            } else if(s.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                List <Integer> keySet = new ArrayList<>(명언모음.keySet());
                Collections.reverse(keySet);
                    for (Integer key : keySet) {
                        System.out.println(key + " / " + 명언모음.get(key));
                    }
                System.out.print("명령 ) ");
                s = sc.nextLine().trim();
            } else if(s.startsWith("삭제")){
                String 삭제임시번호 = s.replaceAll("[^0-9]","");
                int 삭제번호 = Integer.parseInt(삭제임시번호);
                if(명언모음.get(삭제번호) != null) {
                    명언모음.remove(삭제번호);
                    System.out.println(삭제번호 + "번 명언이 삭제되었습니다.");
                }else if(명언모음.get(삭제번호) == null){
                    System.out.println(삭제번호 + "번 명언은 존재하지 않습니다.");
                }
                System.out.print("명령 ) ");
                s = sc.nextLine().trim();
            } else if(s.startsWith("수정")){
                String 수정임시번호 = s.replaceAll("[^0-9]","");
                int 수정번호 = Integer.parseInt(수정임시번호);
                System.out.println("명언(기존) : " + 명언모음.get(수정번호).wiseSaying);
                System.out.print("명언 : ");
                String wiseSaying = sc.nextLine();
                System.out.println("작가(기존) : " + 명언모음.get(수정번호).writter);
                System.out.print("작가 : ");
                String writter = sc.nextLine();
                명언모음.put(수정번호, (new 명언(writter, wiseSaying)));
                System.out.print("명령 ) ");
                s = sc.nextLine().trim();
            }
            else if(s.equals("종료")){
                break;
            }
        }
    }
}

class 명언{
    String writter;
    String wiseSaying;
    명언(String writter, String wiseSaying){
        this.writter = writter;
        this.wiseSaying = wiseSaying;
    }

    @Override
    public String toString() {
        return writter  + " / " + wiseSaying;
    }
}