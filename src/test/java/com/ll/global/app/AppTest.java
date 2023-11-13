package com.ll.global.app;

import com.ll.standard.utill.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

// 테스트 클래스 정의
public class AppTest {
    // 테스트 메서드 정의
    @Test
    @DisplayName("프로그램 시작 시 \"== 명언 앱 ==\" 출력")
    void t1(){
        Scanner scanner = TestUtil.genScanner("""
                종료
                """.stripIndent());
        // 표준 출력을 ByteArrayOutputStream 으로 변경하여 출력을 캡쳐합니다.
        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();

        // 명언 앱의 인스턴스를 생성합니다.
        new App(scanner).run();
    // ByteArrayOutputStream 에 저장된 출력을 문자열로 가져옵니다.
        String out = byteArrayOutputStream.toString().trim();

        // 표준출력을 원래대로 복구하고 , ByteArrayOutputStream을 닫습니다.
        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);

        // 가져온 출력 문자열에 "== 명언 앱 =="이 포함되어 있는지를 검증합니다.
        assertThat(out)
                .contains("== 명언 앱 ==");
    }

    @Test
    @DisplayName("종료")
    void t2() {
        Scanner scanner = TestUtil.genScanner("""
                종료
                """.stripIndent());
        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();
        new App(scanner).run();

        String out = byteArrayOutputStream.toString().trim();
        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);

    }
}
