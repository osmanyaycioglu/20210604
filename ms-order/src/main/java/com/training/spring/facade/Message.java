package com.training.spring.facade;

public class Message {

    private String dest;
    private String content;

    public String getDest() {
        return this.dest;
    }

    public void setDest(final String destParam) {
        this.dest = destParam;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(final String contentParam) {
        this.content = contentParam;
    }

    @Override
    public String toString() {
        return "Message [dest=" + this.dest + ", content=" + this.content + "]";
    }


}
