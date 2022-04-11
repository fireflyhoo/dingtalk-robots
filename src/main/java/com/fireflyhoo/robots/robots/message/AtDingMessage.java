package com.fireflyhoo.robots.robots.message;

import java.io.Serializable;
import java.util.List;

/**
 * @author fireflyhoo
 */
public class AtDingMessage extends DingMessage {
    private At at;

    public AtDingMessage() {
    }

    public AtDingMessage(At at) {
        this.at = at;
    }

    public At getAt() {
        return at;
    }

    public void setAt(At at) {
        this.at = at;
    }

    public static class At implements Serializable {
        /**
         * 被@人的手机号(在content里添加@人的手机号)
         */
        private List<String> atMobiles;


        private List<String> atUserIds;
        /**
         * `@所有人`时：true，否则为：false
         */
        private Boolean isAtAll = false;

        public At() {
        }

        public At(List<String> atMobiles) {
            this.atMobiles = atMobiles;
        }

        public At(Boolean isAtAll) {
            this.isAtAll = isAtAll;
        }

        public At(List<String> atMobiles, Boolean isAtAll) {
            this.atMobiles = atMobiles;
            this.isAtAll = isAtAll;
        }

        public List<String> getAtUserIds() {
            return atUserIds;
        }

        public void setAtUserIds(List<String> atUserIds) {
            this.atUserIds = atUserIds;
        }

        public List<String> getAtMobiles() {
            return atMobiles;
        }

        public void setAtMobiles(List<String> atMobiles) {
            this.atMobiles = atMobiles;
        }

        public Boolean getIsAtAll() {
            return isAtAll;
        }

        public void setIsAtAll(Boolean atAll) {
            isAtAll = atAll;
        }
    }
}
