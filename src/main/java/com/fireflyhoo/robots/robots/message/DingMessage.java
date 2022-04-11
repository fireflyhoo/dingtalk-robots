package com.fireflyhoo.robots.robots.message;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 钉钉消息
 *
 * @author fireflyhoo
 */
public class DingMessage {

    private String msgtype;

    public static DingMessageBuilder.TypeStep newBuilder() {
        return new DingMessageBuilder.Steps();
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }


}
