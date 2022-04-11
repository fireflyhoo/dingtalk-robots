package com.fireflyhoo.robots.robots.message;

import java.io.Serializable;
import java.util.List;

/**
 * @author fireflyhoo
 */
public class DingFeedCard extends DingMessage {
    /**
     * {@link FeedCard}
     */
    private FeedCard feedCard;

    public DingFeedCard() {
        setMsgtype(MsgType.FEED_CARD.getType());
    }

    public DingFeedCard(List<FeedCard.Link> links) {
        setMsgtype(MsgType.FEED_CARD.getType());
        this.feedCard = new FeedCard(links);
    }

    public FeedCard getFeedCard() {
        return feedCard;
    }

    public void setFeedCard(FeedCard feedCard) {
        this.feedCard = feedCard;
    }

    public static class FeedCard implements Serializable {
        /**
         * {@link Link}
         */
        private List<Link> links;

        public FeedCard() {
        }

        public FeedCard(List<Link> links) {
            this.links = links;
        }

        public List<Link> getLinks() {
            return links;
        }

        public void setLinks(List<Link> links) {
            this.links = links;
        }

        public static class Link implements Serializable {
            /**
             * 单条信息文本
             */
            private String title;
            /**
             * 点击单条信息到跳转链接
             */
            private String messageURL;
            /**
             * 单条信息后面图片的URL
             */
            private String picURL;

            public Link() {
            }

            public Link(String title, String messageURL, String picURL) {
                this.title = title;
                this.messageURL = messageURL;
                this.picURL = picURL;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getMessageURL() {
                return messageURL;
            }

            public void setMessageURL(String messageURL) {
                this.messageURL = messageURL;
            }

            public String getPicURL() {
                return picURL;
            }

            public void setPicURL(String picURL) {
                this.picURL = picURL;
            }
        }
    }
}
