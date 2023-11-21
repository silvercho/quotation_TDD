package com.ll.global.domain.quotation.quotation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor // 생성자를 자동으로 생성해주는 기능
public class Quotation {
    private final long id;
    private final String authorName;
    private final String content;
}
