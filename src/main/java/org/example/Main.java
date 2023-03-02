package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

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
            }
            else if(s.equals("종료")){
                cm.save();
                break;
            }
        }
    }
}


class Commander {
    private Scanner sc;
    private int i;
    private HashMap<Integer, 명언> 명언모음;
    private File saveFile;

    Commander() {
        this.sc = new Scanner(System.in);
        this.i = 1;
        this.명언모음 = new HashMap<>();
        this.saveFile = new File("명언.txt");
        System.out.println("== 명언 앱 ==");
    }


    public String wait_command() {
        System.out.print("명령 ) ");
        return sc.nextLine().trim();
    }

    
    private String _print_and_wait(String notice) {
        System.out.print(notice);
        return sc.nextLine();
    }


    public void save() throws IOException {
        if (!saveFile.exists()) {
            saveFile.createNewFile();
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(saveFile));
        for (Integer key : 명언모음.keySet()) {
            bw.write(key + " / " + 명언모음.get(key));
            bw.newLine();
        }
        bw.close();
    }


    public void load() throws IOException {
        if (!saveFile.exists()) {
            return;
        }
        BufferedReader br = new BufferedReader(new FileReader(saveFile));
        String line;
        while ((line = br.readLine()) != null) {
            String[] readLine = line.split(" / ");
            명언모음.put(Integer.parseInt(readLine[0]), new 명언(readLine[1], readLine[2]));
        }
        br.close();
    }


    public void enroll() {
        String wiseSaying = _print_and_wait("명언 : ");
        String writter = _print_and_wait("작가 : ");
        명언모음.put(i, new 명언(writter, wiseSaying));
        System.out.println(i + "번 명언이 등록되었습니다.");
        i++;
    }


    public void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        List <Integer> keySet = new ArrayList<>(명언모음.keySet());
        Collections.reverse(keySet);
        for (Integer key : keySet) {
            System.out.println(key + " / " + 명언모음.get(key));
        }
    }


    public void delete(String s) {
        String 삭제임시번호 = s.replaceAll("[^0-9]","");
        int 삭제번호 = Integer.parseInt(삭제임시번호);
        if(명언모음.get(삭제번호) != null) {
            명언모음.remove(삭제번호);
            System.out.println(삭제번호 + "번 명언이 삭제되었습니다.");
        }else if(명언모음.get(삭제번호) == null){
            System.out.println(삭제번호 + "번 명언은 존재하지 않습니다.");
        }
    }


    public void edit(String s) {
        String 수정임시번호 = s.replaceAll("[^0-9]","");
        int 수정번호 = Integer.parseInt(수정임시번호);
        System.out.println("명언(기존) : " + 명언모음.get(수정번호).wiseSaying);
        String wiseSaying = _print_and_wait("명언 : ");
        System.out.println("작가(기존) : " + 명언모음.get(수정번호).writter);
        String writter = _print_and_wait("작가 : ");
        명언모음.put(수정번호, (new 명언(writter, wiseSaying)));
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