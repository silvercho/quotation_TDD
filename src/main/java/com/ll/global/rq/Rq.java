package com.ll.global.rq;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Rq {
    private final String action;
    private final String queryString;
    private Map<String, String> params;

    public Rq(final String cmd) {
        // 명령어를 "?" 기준으로 나누어 cmdBits 배열에 저장
        final String[] cmdBits = cmd.split("\\?",2);

        // cmdBits의 첫 번째 요소를 액션으로 설정 (앞뒤 공백 제거)
        action = cmdBits[0].trim();

        // cmdBits의 길이가 2이면 두 번째 요소를 쿼리 스트링으로 설정 (앞뒤 공백 제거), 그렇지 않으면 빈 문자열로 설정
        queryString = cmdBits.length == 2 ? cmdBits[1].trim() : "";

        // 쿼리 스트링을 "&" 기준으로 나누고 파라미터를 추출하여 맵으로 저장
        params = Arrays.stream(queryString.split("&"))
                // "="를 포함하는 파라미터만 필터링
                .filter(param -> param.contains("="))
                // "=" 기준으로 파라미터를 나누어 배열로 저장
                .map(param -> param.split("=", 2))
                // 맵으로 변환 (파라미터 이름이 중복될 경우 마지막 값으로 덮어쓰기)
                .collect(Collectors.toMap(
                        paramBits -> paramBits[0].trim(),
                        paramBits -> paramBits[1].trim(),
                        (existing, replacement) -> replacement));
    }

    public String getAction() {
        return action;
    }

    public String getParameter(String paramName) {
        return params.get(paramName);
    }
}
