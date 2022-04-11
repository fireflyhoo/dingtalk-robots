package com.fireflyhoo.robots.robots.message;

import java.io.Serializable;

/**
 * 链接文本
 *
 * @author fireflyhoo
 */
public class DingLink extends DingMessage {
    /**
     * {@link Link}
     */
    private Link link;

    public DingLink() {
        setMsgtype(MsgType.LINK.getType());
    }

    public DingLink(Link link) {
        this();
        this.link = link;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public static class Link implements Serializable {
        /**
         * 消息标题
         */
        private String title;
        /**
         * 消息内容。如果太长只会部分展示
         */
        private String text;
        /**
         * 点击消息跳转的URL
         */
        private String messageUrl;
        /**
         * 图片URL
         */
        private String picUrl;

        public Link() {
        }

        public Link(String title, String text, String messageUrl, String picUrl) {
            this.title = title;
            this.text = text;
            this.messageUrl = messageUrl;
            this.picUrl = picUrl;
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

        public String getMessageUrl() {
            return messageUrl;
        }

        public void setMessageUrl(String messageUrl) {
            this.messageUrl = messageUrl;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }
    }
}
