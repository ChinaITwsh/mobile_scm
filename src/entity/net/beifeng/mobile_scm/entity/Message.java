package net.beifeng.mobile_scm.entity;

import java.io.Serializable;

public class Message implements Serializable {

    private static final long serialVersionUID = 2164664160544585549L;
    private String title;
    private String img;
    private String content;
    private String link;

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
