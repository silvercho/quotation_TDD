package com.ll.standard.utill;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class TestUtilTest {
    @Test
    @DisplayName("IOUtill.genScanner() 테스트")
    void t1(){
        Scanner scanner = TestUtil.genScanner("""
                등록
                나의 죽음을 적에게 알리지 말라!
                이순신
                """.stripIndent()); // 여러줄로 이루어진 문자열의 각 줄의 공백을 제거하여 가독성을 높이는데 사용됩니다.
        String cmd = scanner.nextLine();
        String content = scanner.nextLine();
        String authorName = scanner.nextLine();

        assertThat(cmd).isEqualTo("등록");
        assertThat(content).isEqualTo("나의 죽음을 적에게 알리지 말라!");
        assertThat(authorName).isEqualTo("이순신");
        // assertThat 은 테스트에서 예상결과와 실제 결과를 비교하는데 사용됩니다.
    }
    @Test
    @DisplayName("IOUtil.setOutToByteArray() 테스트")
    void t2() {
        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();

        System.out.println("2 / 이순신 / 나의 죽음을 적들에게 알리지 말라!");

        String out = byteArrayOutputStream.toString().trim();
        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);

        assertThat(out).isEqualTo("2 / 이순신 / 나의 죽음을 적들에게 알리지 말라!");

        System.out.println("이제는 화면에 출력 됩니다.");
    }
}
