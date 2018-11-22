package com.hometest.model;

import java.io.IOException;
import java.io.InputStream;

public class Picture {
    private boolean isMain;
    private byte[] data;
    private String url;

    public Picture() {
    }

    public Picture(boolean isMain, String url) {
        this.isMain = isMain;
        this.url = url;
    }

    public boolean isMain() {
        return isMain;
    }

    public void setMain(boolean main) {
        isMain = main;
    }

    public byte[] getData() throws IOException {
        if (data != null) {
            return data;
        }
        InputStream in = this.getClass().getClassLoader()
                .getResourceAsStream(this.url);
        in.read(data);
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
