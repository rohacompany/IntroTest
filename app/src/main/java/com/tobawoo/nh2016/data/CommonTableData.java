package com.tobawoo.nh2016.data;

/**
 * Created by tommy on 2016-06-12.
 */
public class CommonTableData {

    private String title;
    private int width;
    private int gravity;

    public CommonTableData(String title , int gravity ,int width) {
        this.title = title;
        this.width = width;
        this.gravity = gravity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getGravity() {
        return gravity;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    @Override
    public String toString() {
        return "CommonTableData{" +
                "title='" + title + '\'' +
                ", width=" + width +
                ", gravity=" + gravity +
                '}';
    }
}
