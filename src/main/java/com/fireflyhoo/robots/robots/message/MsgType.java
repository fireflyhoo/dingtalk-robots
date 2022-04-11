package com.fireflyhoo.robots.robots.message;

/**
 * 消息内容
 * @author fireflyhoo
 */
public enum MsgType {
    /**
     * text类型
     */
    TEXT("text"),

    /**
     * link类型
     */
    LINK("link"),

    /**
     * markdown类型
     */
    MARKDOWN("markdown"),

    /**
     * ActionCard类型
     */
    ACTION_CARD("actionCard"),

    /**
     * FeedCard类型
     */
    FEED_CARD("feedCard")

    ;

    private String type;

    public String getType() {
        return type;
    }

    MsgType(String type) {
        this.type = type;
    }
}
