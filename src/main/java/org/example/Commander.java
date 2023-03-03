package org.example;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Commander {
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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(saveFile), "utf-8"));
        for (Integer key : 명언모음.keySet()) {
            bw.write(명언모음.get(key).toString());
            bw.newLine();
        }
        bw.close();
    }


    public void load() throws IOException {
        if (!saveFile.exists()) {
            return;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(saveFile), "utf-8"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] readLine = line.split(" / ");
            i = Integer.parseInt(readLine[0]);
            명언모음.put(i, new 명언(i, readLine[1], readLine[2]));
        }
        br.close();
    }


    public void exportJson() throws IOException{
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data.json"), "utf-8"));
        gson.toJson(명언모음.values(), bw);
        bw.close();
        System.out.println("data.json 파일의 내용이 갱신되었습니다.");
    }


    public void enroll() {
        String wiseSaying = _print_and_wait("명언 : ");
        String writter = _print_and_wait("작가 : ");
        명언모음.put(i, new 명언(i, writter, wiseSaying));
        System.out.println(i + "번 명언이 등록되었습니다.");
        i++;
    }


    public void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        List <Integer> keySet = new ArrayList<>(명언모음.keySet());
        Collections.reverse(keySet);
        for (Integer key : keySet) {
            System.out.println(명언모음.get(key).toString());
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
        if (!명언모음.containsKey(수정번호)) {
            System.out.println(수정번호 + "번 명언은 존재하지 않습니다.");
            return;
        }
        명언 수정대상 = 명언모음.get(수정번호);
        System.out.println("명언(기존) : " + 수정대상.getContent());
        String wiseSaying = _print_and_wait("명언 : ");
        System.out.println("작가(기존) : " + 수정대상.getAuthor());
        String writter = _print_and_wait("작가 : ");
        수정대상.setContent(wiseSaying);
        수정대상.setAuthor(writter);
    }
}
