# dingtalk-robots
钉钉自定义机器SDK封装



### 文本消息

```java

  DingRobotClient clinet = DingRobotClient.newBuilder()
                .url("https://oapi.dingtalk.com/robot/send?access_token=cd6f4e983d1ae0272afb3ed1fe1e896a72a2b08026XXXXXXXXXXXX")
                .secret("SEC49179307e72e616e37458c8a471ca888c5e43XXXXXXXXX").build();

        try {
            boolean res = clinet.sendMessage(DingMessage.newBuilder().text().content("测试一下机器人@自己")
                    .at().byMobiles("137872994XX").build());
            System.out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }


```

### 链接消息

```java
       DingRobotClient clinet = DingRobotClient.newBuilder()
        .url("https://oapi.dingtalk.com/robot/send?access_token=cd6f4e983d1ae0272afb3ed1fe1e896a72a2b08026XXXXXXXXXXXX")
        .secret("SEC49179307e72e616e37458c8a471ca888c5e43XXXXXXXXX").build();

        DingMessage message = DingMessage.newBuilder().link().content("链接标题", "链接内容")
                .image("https://pics6.baidu.com/feed/203fb80e7bec54e704c069acf79f21564ec26a85.jpeg")
                .link("http://www.baidu.com", false).noAt().build();
        boolean res = clinet.sendMessage(message);

```


###  Markdown


```java

 DingMessage atMsg = DingMessage.newBuilder().markdown().contentMarkdown("测试Markdown", "# 嘻嘻嘻呵呵 \n test @ 1132313212")
                .at().all().build();
                
// Markdown 消息不支持指定手机号 @ 只能 @ALL


```



###  ActionCard

```java

// 单按钮
        DingMessage msg = DingMessage.newBuilder().actionCard().actionContent("我就是个调整", "我就是个跳转测试")
                .moreButton(Arrays.asList(new ActionButton("标题1", "http://www.coollf.com"),
                        new ActionButton("标题3", "http://www.coollf.com/1")))
                .build();

// 多按钮
        DingMessage sing = DingMessage.newBuilder().actionCard().actionContent("测试ACT", "sss").singleButton("bots", "http://www.fireflyhoo.com", false)
                .build();


```


### FeedCard

```java

   DingMessage ms = DingMessage.newBuilder().feedCard().feedActions(Arrays.asList(
                new FeedActionButton("测试内容", "http://www.fireflyhoo.com/fs",
                        "https://pics6.baidu.com/feed/203fb80e7bec54e704c069acf79f21564ec26a85.jpeg"),
        new FeedActionButton("测试内容2", "http://www.fireflyhoo.com/fs",
                "https://pics6.baidu.com/feed/203fb80e7bec54e704c069acf79f21564ec26a85.jpeg"))
                ).build();

```

