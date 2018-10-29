package com.example.core.properties;

public class ImageCodeProperties {
    private int width;
    private int hetight;
    private int length = 4;
    private int expired = 60;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHetight() {
        return hetight;
    }

    public void setHetight(int hetight) {
        this.hetight = hetight;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpired() {
        return expired;
    }

    public void setExpired(int expired) {
        this.expired = expired;
    }
}
