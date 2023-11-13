package com.ll.global.rq;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RqTest {
    @Test
    @DisplayName("t1 : getAction")
    void t1() {
        final Rq rq = new Rq("삭제?id=1");

        assertThat(rq.getAction()).isEqualTo("삭제");
    }
    @Test
    @DisplayName("t2 : getParameter")
    void t2() {
        final Rq rq = new Rq("삭제?이름=Paul");

        assertThat(rq.getParameter("이름")).isEqualTo("Paul");
    }

    @Test
    @DisplayName("getParameter 2")
    void t3() {
        final Rq rq = new Rq("삭제?이름=Alice");

        assertThat(rq.getParameter("이름")).isEqualTo("Alice");
    }

    @Test
    @DisplayName("getParameter 3")
    void t4() {
        final Rq rq = new Rq("삭제?id=4&이름=Alice");

        assertThat(rq.getParameter("id")).isEqualTo("4");
        assertThat(rq.getParameter("이름")).isEqualTo("Alice");
    }

    @Test
    @DisplayName("getParameterOr")
    void t5() {
        final Rq rq = new Rq("삭제?id=4&이름=Alice");

        String age = rq.getParameter("나이", "100");

        assertThat(age).isEqualTo(100);
    }
}
