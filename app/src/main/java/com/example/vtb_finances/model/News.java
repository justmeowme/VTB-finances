package com.example.vtb_finances.model;

public class News {
    private String image;
    private String title;
    private String content;
    private int level;
    private int steps;
    private int segment;

    public News() {
    }

    public News(String image, String title, String content, int level, int steps, int segment) {
        this.image = image;
        this.title = title;
        this.content = content;
        this.level = level;
        this.steps = steps;
        this.segment = segment;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getSegment() {
        return segment;
    }

    public void setSegment(int segment) {
        this.segment = segment;
    }

    @Override
    public String toString() {
        return "News{" +
                "image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", level=" + level +
                ", steps=" + steps +
                ", segment=" + segment +
                '}';
    }
}