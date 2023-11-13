package com.ll.global.app;

import com.ll.global.domain.quotation.quotation.entity.Quotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private final Scanner scanner;

    public App(final Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        List<Quotation> quotations = new ArrayList<>();

        long lastQuotationId = 0;

        while (true) {
            final String cmd = scanner.nextLine().trim();

            final String[] cmdBits = cmd.split("\\?",2); //?를 기준으로 둘로 나눈다.
            final String action = cmdBits[0];// cmdBits 배열의 첫 번째 요소를 action 변수에 할당한다.

            final String queryString = cmdBits.length == 2 ? cmdBits[1].trim() : "";
            // cmdBits 배열의 길이가 2일 경우 두 번째 요소를 trim() 메서드를 사용하여 앞뒤의 공백을 제거하고 queryString 변수에 할당한다.
            // cmdBits 배열의 길이가 2가 아닐 경우 빈 문자열("")을 queryString 변수에 할당한다.

            switch (action) { // ->를 넣으면 break;문을 안써도 된다!
                case "삭제" -> {
                    final String idStr = queryString.replace("id=", "");
                    final long id = Long.parseLong(idStr);

                    quotations
                            .removeIf(quotation -> quotation.getId() == id);
                    System.out.println("1번 명언이 삭제되었습니다.");
                }

                case "등록" -> {
                    System.out.print("명언 : ");
                    final String content = scanner.nextLine().trim();
                    System.out.print("작가 : ");
                    final String authorName = scanner.nextLine().trim();

                    final long id = ++lastQuotationId;

                    Quotation quotation = new Quotation(id, authorName, content);
                    quotations.add(quotation);

                    System.out.println("%d번 명언이 등록되었습니다.".formatted(id));
                }
                case "목록" -> {
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------------");

                    quotations
                            .reversed()
                            .forEach(
                                    quotation -> System.out.println(
                                            "%d / %s / %s".formatted(
                                                    quotation.getId(),
                                                    quotation.getAuthorName(),
                                                    quotation.getContent()
                                            )
                                    )
                            );
                }
                case "종료" -> {
                    return;
                }
            }
        }
    }
}

