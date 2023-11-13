package com.ll.standard.utill;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class TestUtillTest {
    @Test
    @DisplayName("IOUtill.genScanner() 테스트")
    void t1(){
        Scanner scanner = TestUtill.genScanner("""
                등록
                나의 죽음을 적에게 알리지 말라!
                이순신
                """.stripIndent());
        String cmd = scanner.nextLine();
        String content = scanner.nextLine();
        String authorName = scanner.nextLine();

        assertThat(cmd).isEqualTo("등록");
        assertThat(content).isEqualTo("나의 죽음을 적에게 알리지 말라!");
        assertThat(authorName).isEqualTo("이순신");
    }

}
