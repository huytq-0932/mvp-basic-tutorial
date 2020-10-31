package com.tr4n.mvpbasic.data.model;

import java.util.UUID;

/**
 * Là những POJO class, định nghĩa 1 thực thể(entity) nào đó
 */
public class Task {
    private String id;
    private String title;
    private String content;

    public Task(String title, String content) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
