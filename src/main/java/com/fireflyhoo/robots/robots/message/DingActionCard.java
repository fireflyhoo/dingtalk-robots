package com.fireflyhoo.robots.robots.message;

import java.io.Serializable;
import java.util.List;

/**
 * 带按钮信息
 *
 * @author fireflyhoo
 */
public class DingActionCard extends DingMessage {
    /**
     * {@link ActionCard}
     */
    private ActionCard actionCard;

    public DingActionCard() {
        setMsgtype(MsgType.ACTION_CARD.getType());
    }

    public DingActionCard(ActionCard actionCard) {
        setMsgtype(MsgType.ACTION_CARD.getType());
        this.actionCard = actionCard;
    }





    public ActionCard getActionCard() {
        return actionCard;
    }

    public void setActionCard(ActionCard actionCard) {
        this.actionCard = actionCard;
    }

    public static class ActionCard implements Serializable {

        public ActionCard(String title, String text, String btnOrientation, List<Button> btns) {
            this.title = title;
            this.text = text;
            this.btnOrientation = btnOrientation;
            this.btns = btns;
        }


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
         * 按钮
         */
        private List<Button> btns;

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

        public List<Button> getBtns() {
            return btns;
        }

        public void setBtns(List<Button> btns) {
            this.btns = btns;
        }

        public static class Button implements Serializable {
            /**
             * 按钮标题
             */
            private String title;
            /**
             * 点击按钮触发的URL
             */
            private String actionURL;

            public Button() {
            }

            public Button(String title, String actionURL) {
                this.title = title;
                this.actionURL = actionURL;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getActionURL() {
                return actionURL;
            }

            public void setActionURL(String actionURL) {
                this.actionURL = actionURL;
            }
        }
    }
}
