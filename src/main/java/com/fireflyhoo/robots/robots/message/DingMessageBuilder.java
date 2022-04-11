package com.fireflyhoo.robots.robots.message;

import com.fireflyhoo.robots.robots.message.dto.ActionButton;
import com.fireflyhoo.robots.robots.message.dto.FeedActionButton;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author fireflyhoo
 */
public class DingMessageBuilder{

    public interface TypeStep {

        /**
         * 文本内容
         *
         * @return TextStep
         */
        TextStep text();


        /**
         * 链接文本
         *
         * @return LinkTextStep
         */
        LinkTextStep link();

        /**
         * markdown 内容
         *
         * @return MarkdownStep
         */
        MarkdownStep markdown();

        /**
         * 事件卡片
         *
         * @return ActionCardStep
         */
        ActionCardStep actionCard();


        /**
         * 自由卡片
         *
         * @return FeedCardStep
         */
        FeedCardStep feedCard();

    }

    /**
     * 构建步骤
     */
    public interface BuildStep {
        DingMessage build();
    }

    public interface AtStep extends BuildStep {

        /**
         * 通过手机号
         *
         * @param phone 手机号
         * @return AtStep
         */
        AtStep byMobiles(String... phone);

        /**
         * 通过手机号
         *
         * @param userIds 钉钉用户id,需要用企业相关api才能获取到
         * @return AtStep
         */
        AtStep byUserIds(String... userIds);


        /**
         *  at 全部
         * @return BuildStep
         */
        BuildStep all();
    }

    public interface TextStep {


        /**
         * 文本内容
         *
         * @param content 文本内容
         * @return TextStep
         */
        TextStep content(String content);


        /**
         *  at  谁
         *
         * @return  AtStep
         *
         */
        AtStep at();


        /**
         * 不 at
         *
         * @return BuildStep
         */
        BuildStep noAt();


    }

    public interface LinkTextStep {

        /**
         * 内容
         *
         * @param title   标题
         * @param content 内容
         * @return LinkTextStep
         */
        LinkTextStep content(String title, String content);


        /**
         * 链接地址
         *
         * @param linkUrl 链接地址
         * @param pcSlide 是否在侧边栏打开
         * @return LinkTextStep
         */
        LinkTextStep link(String linkUrl, boolean pcSlide);


        /**
         * 图片内容
         *
         * @param imageUrl 图片地址
         * @return LinkTextStep
         */
        LinkTextStep image(String imageUrl);


        /**
         *  不进行 at
         *
         * @return BuildStep
         */
        BuildStep noAt();
    }


    public interface MarkdownStep {

        /**
         * 内容
         *
         * @param title   标题
         * @param content 内容
         * @return MarkdownStep
         */
        MarkdownStep contentMarkdown(String title, String content);

        /**
         * at
         *
         * @return BuildStep
         */
        BuildStep noAt();


        /**
         *  at 对应的人
         *
         * @return AtStep
         *
         */
        AtStep at();

    }

    public interface ActionCardStep {

        /**
         * 内容
         *
         * @param title   标题
         * @param content 内容
         * @return ActionCardStep
         */
        ActionCardStep actionContent(String title, String content);

        /**
         * 单按钮
         *
         * @param singleTitle 按钮标题
         * @param singleURL  跳转地址
         * @param btnOrientation 横放(true)/竖放(false)
         * @return BuildStep
         */
        BuildStep singleButton(String singleTitle, String singleURL, boolean btnOrientation);

        /**
         * 多按钮
         *
         * @param action 按钮
         * @return BuildStep
         */
        BuildStep moreButton(List<ActionButton> action);


    }




    public interface FeedCardStep {
        BuildStep feedActions(List<FeedActionButton> actions);
    }

    protected static class Steps
            implements TypeStep, AtStep, TextStep, LinkTextStep, MarkdownStep, ActionCardStep, FeedCardStep, BuildStep {

        private MsgType type;

        /**
         * 手机号
         */
        private List<String> atMobiles;
        /**
         * 用户id
         */
        private List<String> atUserIds;

        /**
         * 通知所有人
         */
        private boolean atAll;


        /**
         * 标题
         */
        private String title;

        /**
         * 内容
         */
        private String content;

        /**
         * 文本跳转链接
         */
        private String linkUrl;

        /**
         * 是否侧边栏打开
         */
        private boolean pcSlide;

        /**
         * 图片地址
         */
        private String imageUrl;

        /**
         * action 的标题
         */
        private String singleTitle;

        /**
         * 跳转地址
         */
        private String singleURL;


        /**
         * 按钮方向
         */
        private boolean btnOrientation;

        /**
         * 多个按钮
         */
        private List<ActionButton> actions;

        /**
         * 自由调整
         */
        private List<FeedActionButton> feedAction;


        @Override
        public TextStep text() {
            type = MsgType.TEXT;
            return this;
        }

        @Override
        public LinkTextStep link() {
            this.type = MsgType.LINK;
            return this;
        }

        @Override
        public MarkdownStep markdown() {
            this.type = MsgType.MARKDOWN;
            return this;
        }

        @Override
        public ActionCardStep actionCard() {
            this.type = MsgType.ACTION_CARD;
            return this;
        }

        @Override
        public FeedCardStep feedCard() {
            this.type = MsgType.FEED_CARD;
            return this;
        }

        @Override
        public AtStep byMobiles(String... phone) {
            this.atMobiles = Arrays.asList(phone);
            return this;
        }

        @Override
        public AtStep byUserIds(String... userIds) {
            this.atUserIds = Arrays.asList(userIds);
            return this;
        }

        @Override
        public BuildStep all() {
            this.atAll = true;
            return this;
        }

        @Override
        public TextStep content(String content) {
            this.content = content;
            return this;
        }


        @Override
        public ActionCardStep actionContent(String title, String content) {
            this.title = title;
            this.content = content;
            return this;
        }

        @Override
        public BuildStep singleButton(String singleTitle, String singleURL, boolean btnOrientation) {
            this.singleTitle = singleTitle;
            this.singleURL = singleURL;
            this.btnOrientation = btnOrientation;
            return this;
        }

        @Override
        public BuildStep moreButton(List<ActionButton> action) {
            this.actions = action;
            return this;
        }

        @Override
        public AtStep at() {
            return this;
        }

        @Override
        public LinkTextStep content(String title, String content) {
            this.title = title;
            this.content = content;
            return this;
        }

        @Override
        public LinkTextStep link(String linkUrl, boolean pcSlide) {
            this.linkUrl = linkUrl;
            this.pcSlide = pcSlide;
            return this;
        }

        @Override
        public LinkTextStep image(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        @Override
        public MarkdownStep contentMarkdown(String title, String content) {
            this.title = title;
            this.content = content;
            return this;
        }

        @Override
        public BuildStep noAt() {
            return this;
        }

        @Override
        public BuildStep feedActions(List<FeedActionButton> actions) {
            this.feedAction = actions;
            return this;
        }


        @Override
        public DingMessage build() {
            if (this.type == MsgType.TEXT) {
                DingText dingText = new DingText(new DingText.Text(this.content));
                dingText.setAt(buildAt());
                return dingText;
            }
            if (this.type == MsgType.LINK) {
                DingLink dingLink = new DingLink(new DingLink.Link(title, content, getDingURL(linkUrl, pcSlide), this.imageUrl));
                return dingLink;
            }

            if (this.type == MsgType.MARKDOWN) {
                DingMarkDown markDown = new DingMarkDown(new DingMarkDown.MarkDown(title, content));
                markDown.setAt(buildAt());
                return markDown;
            }

            if (this.type == MsgType.ACTION_CARD) {
                if (this.actions == null) {
                    DingSingleActionCard singleActionCard = new DingSingleActionCard(
                            new DingSingleActionCard.SingleActionCard(
                                    title, content, btnOrientation ? "1" : "0", singleTitle, singleURL));
                    return singleActionCard;
                } else {
                    DingActionCard actionCard = new DingActionCard(
                            new DingActionCard.ActionCard(title, content,
                                    btnOrientation ? "1" : "0", this.actions.stream().map(it -> {
                                return new DingActionCard.ActionCard.Button(it.getTitle(), it.getUrl());
                            }).collect(Collectors.toList())));
                    return actionCard;
                }
            }

            if (this.type == MsgType.FEED_CARD) {
                DingFeedCard feedCard = new DingFeedCard(this.feedAction.stream().map(it -> {
                    DingFeedCard.FeedCard.Link link = new DingFeedCard.FeedCard.Link(it.getTitle()
                            , it.getUrl(), it.getImage());
                    return link;
                }).collect(Collectors.toList()));
                return feedCard;
            }

            return null;
        }


        /**
         * 处理侧边栏打开
         *
         * @param linkUrl
         * @param pcSlide
         * @return
         */
        private String getDingURL(String linkUrl, boolean pcSlide) {
            try {
                return String.format("dingtalk://dingtalkclient/page/link?url=%s&pc_slide=%s",
                        URLEncoder.encode(linkUrl), pcSlide);
            } catch (Exception e) {
                e.printStackTrace();
                //
            }
            return linkUrl;
        }


        private AtDingMessage.At buildAt() {
            AtDingMessage.At at = new AtDingMessage.At();
            if (this.atAll) {
                at.setIsAtAll(true);
            }
            if (this.atMobiles != null) {
                at.setAtMobiles(this.atMobiles);
            } else {
                at.setAtMobiles(new ArrayList<>());
            }

            if (this.atUserIds != null) {
                at.setAtUserIds(this.atUserIds);
            } else {
                at.setAtUserIds(new ArrayList<>());
            }
            return at;
        }
    }
}

