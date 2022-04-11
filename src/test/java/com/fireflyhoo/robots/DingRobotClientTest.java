package com.fireflyhoo.robots;

import com.fireflyhoo.robots.robots.DingRobotClient;
import com.fireflyhoo.robots.robots.message.DingMessage;
import com.fireflyhoo.robots.robots.message.DingMessageBuilder;
import com.fireflyhoo.robots.robots.message.dto.ActionButton;
import com.fireflyhoo.robots.robots.message.dto.FeedActionButton;
import com.google.gson.Gson;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class DingRobotClientTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testTextMessage() {
        DingRobotClient clinet = makerClient();

        try {
            boolean res = clinet.sendMessage(DingMessage.newBuilder().text().content("测试一下机器人@自己")
                    .at().byMobiles("137872994XX").build());
            System.out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertTrue(true);
    }


    @Test
    public void textLinkMessage() throws IOException {
        DingRobotClient clinet = makerClient();

        DingMessage message = DingMessage.newBuilder().link().content("链接标题", "链接内容")
                .image("https://pics6.baidu.com/feed/203fb80e7bec54e704c069acf79f21564ec26a85.jpeg")
                .link("http://www.baidu.com", false).noAt().build();
        boolean res = clinet.sendMessage(message);
        assertTrue(res);
    }



    @Test
    public void testMarkdowMessage() throws  IOException{

        DingRobotClient clinet = makerClient();

//        DingMessage message = DingMessage.newBuilder().markdown().contentMarkdown("测试Markdown", "# 嘻嘻嘻呵呵 \n test")
//                .noAt().build();
//
//        clinet.sendMessage(message);

        DingMessage atMsg = DingMessage.newBuilder().markdown().contentMarkdown("测试Markdown", "# 嘻嘻嘻呵呵 \n test @ 1132313212")
                .at().all().build();
        System.err.println(new Gson().toJson(atMsg));
      //  clinet.sendMessage(atMsg);
    }

    @Test
    public  void testAction() throws  IOException{
        DingRobotClient clinet = makerClient();
        DingMessage msg = DingMessage.newBuilder().actionCard().actionContent("我就是个调整", "我就是个跳转测试")
                .moreButton(Arrays.asList(new ActionButton("标题1", "http://www.coollf.com"),
                        new ActionButton("标题3", "http://www.coollf.com/1")))
                .build();


        DingMessage sing = DingMessage.newBuilder().actionCard().actionContent("测试ACT", "sss").singleButton("bots", "http://www.fireflyhoo.com", false)
                .build();

        clinet.sendMessage(msg);
        clinet.sendMessage(sing);

    }


    @Test
    public void testFeedCard() throws IOException{
        DingRobotClient clinet = makerClient();
        DingMessage ms = DingMessage.newBuilder().feedCard().feedActions(Arrays.asList(
                new FeedActionButton("测试内容", "http://www.fireflyhoo.com/fs",
                        "https://pics6.baidu.com/feed/203fb80e7bec54e704c069acf79f21564ec26a85.jpeg"),
        new FeedActionButton("测试内容2", "http://www.fireflyhoo.com/fs",
                "https://pics6.baidu.com/feed/203fb80e7bec54e704c069acf79f21564ec26a85.jpeg"))
                ).build();
        clinet.sendMessage(ms);
    }



    private DingRobotClient makerClient() {
        return DingRobotClient.newBuilder()
                .url("https://oapi.dingtalk.com/robot/send?access_token=52644237696164656408cfca1683805b96effa918dd28f11XXXXX")
                .secret("SEC0c0e1f0fdeacfe2ace81eafad598bbf0efa0efc635c65e0c9c105a44XXXX").build();
    }
}
