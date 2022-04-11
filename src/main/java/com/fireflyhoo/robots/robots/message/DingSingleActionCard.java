package com.fireflyhoo.robots.robots.message;

import java.io.Serializable;

/**
 * 当个跳转消息
 * @author fireflyhoo
 */
public class DingSingleActionCard extends DingMessage {

    private SingleActionCard actionCard;

    public DingSingleActionCard() {
        setMsgtype(MsgType.ACTION_CARD.getType());
    }

    public SingleActionCard getActionCard() {
        return actionCard;
    }

    public void setActionCard(SingleActionCard actionCard) {
        this.actionCard = actionCard;
    }

    public DingSingleActionCard(SingleActionCard actionCard) {
        setMsgtype(MsgType.ACTION_CARD.getType());
        this.actionCard = actionCard;
    }


    public static class SingleActionCard implements Serializable {
        /**
         * 首屏会话透出的展示内容
         */
        private String title;
        /**
         * markdown格式的消息
         */
        private String text;
        /**
         * 0-按钮竖直排列，1-按钮横向排列
         */
        private String btnOrientation;
        /**
         * 单个按钮的标题。(设置此项和singleURL后btns无效)
         */
        private String singleTitle;
        /**
         * 点击singleTitle按钮触发的URL
         */
        private String singleURL;

        public SingleActionCard() {
        }

        public SingleActionCard(String title, String text, String btnOrientation, String singleTitle, String singleURL) {
            this.title = title;
            this.text = text;
            this.btnOrientation = btnOrientation;
            this.singleTitle = singleTitle;
            this.singleURL = singleURL;
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

        public String getBtnOrientation() {
            return btnOrientation;
        }

        public void setBtnOrientation(String btnOrientation) {
            this.btnOrientation = btnOrientation;
        }

        public String getSingleTitle() {
            return singleTitle;
        }

        public void setSingleTitle(String singleTitle) {
            this.singleTitle = singleTitle;
        }

        public String getSingleURL() {
            return singleURL;
        }

        public void setSingleURL(String singleURL) {
            this.singleURL = singleURL;
        }
    }
}
