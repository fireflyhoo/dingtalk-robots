package com.fireflyhoo.robots.robots.message;

import java.io.Serializable;

/**
 * @author fireflyhoo
 */
public class DingText extends AtDingMessage {
    /**
     * 消息内容
     * */
    private Text text;

    public DingText(Text text) {
        setMsgtype(MsgType.TEXT.getType());
        this.text = text;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public static class Text implements Serializable {
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Text() {
        }

        public Text(String content) {
            this.content = content;
        }
    }
}
