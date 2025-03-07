package com.a.memo.bean;

public class NoteData {
    private int _id;
    private String mid;
    private String title;
    private String text;
    private String time;

    public NoteData(int _id, String mid, String title, String text, String time) {
        this._id = _id;
        this.mid = mid;
        this.title = title;
        this.text = text;
        this.time = time;
    }


    @Override
    public String toString() {
        return "NoteData{" +
                "_id=" + _id +
                ", mid='" + mid + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
