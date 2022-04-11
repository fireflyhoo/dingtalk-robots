package com.fireflyhoo.robots.robots.message;

import java.io.Serializable;

/**
 * @author fireflyhoo
 */
public class DingMarkDown extends AtDingMessage {
    /**
     * {@link MarkDown}
     */
    private MarkDown markdown;

    public DingMarkDown(MarkDown markdown) {
        setMsgtype(MsgType.MARKDOWN.getType());
        this.markdown = markdown;
    }

    public MarkDown getMarkdown() {
        return markdown;
    }

    public void setMarkdown(MarkDown markdown) {
        this.markdown = markdown;
    }

    public static class MarkDown implements Serializable {

        private String title;

        /**
         * markdown格式的消息
         */
        private String text;

        public MarkDown() {
        }

        public MarkDown(String title, String text) {
            this.title = title;
            this.text = text;
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
    }

}
