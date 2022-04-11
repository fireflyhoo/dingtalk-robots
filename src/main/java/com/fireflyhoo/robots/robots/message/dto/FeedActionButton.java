package com.fireflyhoo.robots.robots.message.dto;

/**
 * @author fireflyhoo
 */
public class FeedActionButton {
    private final String image;
    private String title;
    private String url;

    public FeedActionButton(String title, String url, String image) {
        this.title = title;
        this.url = url;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
