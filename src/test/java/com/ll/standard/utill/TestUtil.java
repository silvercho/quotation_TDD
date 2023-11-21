package com.ll.standard.utill;

import java.io.*;
import java.util.Scanner;

public class TestUtil {
    // gen == generate 생성하다.
    // 자바에서 사용되는 유틸리티(도구) 클래스인 TestUtill 이다.

    // 사용자로부터 입력을 받기 위한 Scanner 객체를 생성하는 메서드
    // 매개변수로 전달된 문자열(input)을 입력으로 사용합니다.
    public static Scanner genScanner(String input) {
        // 입력 문자열을 바이트 배열로 변환한 후 ByteArrayInputStream에 넣어줍니다.
        InputStream in = new ByteArrayInputStream(input.getBytes());
        // 생성된 ByteArrayInputStream 로부터 Scanner 객체를 생성하여 반환합니다.
        return new Scanner(in);
    }

    // 콘솔에 출력되는 내용을 바이트 배열로 저장하는 매서드
    public static ByteArrayOutputStream setOutToByteArray() {
        // 기존의 표준출력 (System.out) 을 ByteArrayOutputStream으로 변경합니다.
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        // 변경된 ByteArrayOutputStream을 반환합니다.
        return output;
    }

    // 표준 출력을 원래대로 복구하고, ByteArrayOutputStream을 닫는 메서드
    // 예외가 발생하면 RuntimeException을 던집니다.
    public static void clearSetOutToByteArray(ByteArrayOutputStream output){
        // 표준 출력을 원래대로 되돌립니다.
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        // ByteArrayOutputStream을을 닫습니다.
        try {
            output.close();
        } catch (IOException e) { // 입출력 예외처리
            throw new RuntimeException(e);
        }
    }
}

// genScanner 메서드는 특정 문자열을 입력으로 받는 가상의 콘솔 입력을 만들어줍니다.
// setOutToByteArray 메서드는 콘솔 출력을 가로채어 바이트 배열에 저장해주는 기능을 합니다.

