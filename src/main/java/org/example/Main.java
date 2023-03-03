package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        Commander cm = new Commander();
        String s;
        cm.load();
        while(true) {
            s = cm.wait_command();
            if (s.equals("등록")) {
                cm.enroll();
            } else if(s.equals("목록")){
                cm.list();
            } else if(s.startsWith("삭제")){
                cm.delete(s);
            } else if(s.startsWith("수정")){
                cm.edit(s);
            } else if(s.equals("빌드")){
                cm.exportJson();
            } else if(s.equals("종료")){
                cm.save();
                break;
            }
        }
    }
}