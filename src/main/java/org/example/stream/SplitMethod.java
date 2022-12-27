package org.example.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SplitMethod {
//    Scanner sc = new Scanner(System.in);
//    String txt = "";
//        while(!txt.equals("kill")){
//        List<String> lists = new ArrayList<>();
//        txt = sc.nextLine();
//        if(txt.equals("kill")){
//            break;
//        }
////          txt = "aaaa,bbbb,\"cc,c\"c\",dd\"ee,f,gg,,ijk,\"l,m\",n";
//        int endPoint = 0;
//        boolean flag = true;
//        while (flag){
//            if(txt.startsWith(" ")){                                    // 공백제거
//                txt = txt.substring(1,txt.length());
//            }
//            if(!txt.startsWith("\"")){                                  // "로 시작하지 않는 단어
//                endPoint = txt.indexOf(",");                            // ,의 인덱스 번호 반환
//                if(endPoint != -1){                                     // ,를 찾으면
//                    lists.add(txt.substring(0, endPoint));              // 잘라내어 리스트에 추가
//                    txt = txt.substring(endPoint + 1,txt.length());     // 입력단어 잘라내기
//                }else{                                                  // ,를 못 찾으면
//                    lists.add(txt.substring(0, txt.length()));          // 마지막이므로 리스트에 추가
//                    flag = false;                                       // while 종료
//                }
//            }else{                                                      // "로 시작하는 단어
//                endPoint = txt.indexOf("\",",1);                          // ",의 인덱스 번호 반환
//                if(endPoint != -1){                                     // ",를 찾으면
//                    lists.add(txt.substring(0, endPoint + 1));          // 잘라내어 리스트에 추가
//                    txt = txt.substring(endPoint + 2,txt.length());     // 입력단어 잘라내기
//                }else{                                                  // ", 를 못찾으면
//                    lists.add(txt.substring(0, txt.length()));          // 마지막으로 리스트에 추가
//                    flag = false;                                       // while 종료
//                }
//            }
//        }
//        System.out.println(lists.size() + "개");
//        System.out.println(lists);
}
