package com.fireflyhoo.robots.robots;

import com.fireflyhoo.robots.robots.message.DingMessage;
import com.google.gson.Gson;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author fireflyhoo
 */
public class DingRobotClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(DingRobotClient.class);
    private final OkHttpClient okHttpClient = new OkHttpClient();
    private final Gson gson = new Gson();

    private final String url;
    private final String secret;

    private DingRobotClient(String url, String secret) {
        this.url = url;
        this.secret = secret;
    }


    public static AuthStep newBuilder() {
        return new Steps();
    }

    public static void main(String[] args) {
        DingMessage message = DingMessage.newBuilder().text().content("test").at().byMobiles("13787299475").build();

        DingRobotClient clent = DingRobotClient.newBuilder()
                .url("https://oapi.dingtalk.com/robot/send?access_token=cd6f4e983d1ae0272afb3ed1fe1e896a72a2b08026b8c89d387cc0345a19d037")
                .secret("SEC49179307e72e616e37458c8a471ca888c5e43e48c52f7c231f8e841f18e4bc9a")
                .build();
        try {
            boolean success = clent.sendMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送消息
     *
     * @param message
     * @return
     */
    public boolean sendMessage(DingMessage message) throws IOException {
        MediaType json = MediaType.parse("application/json; charset=utf-8");
        Request.Builder request = new Request.Builder().url(getSignedUrl()).post(RequestBody.create(gson.toJson(message), json));
        Call call = okHttpClient.newCall(request.build());
        Response resp = call.execute();
        LOGGER.info(resp.message());
        if (resp.isSuccessful()) {
            return true;
        }
        LOGGER.error("调用钉钉机器人出错 : {}", resp.body().string());
        return false;
    }

    /**
     * 获取签名后的url
     *
     * @return
     */
    private String getSignedUrl() {
        if (this.secret == null) {
            return url;
        }

        try {
            Long timestamp = System.currentTimeMillis();
            String stringToSign = timestamp + "\n" + secret;
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
            byte[] signData = mac.doFinal(stringToSign.getBytes(StandardCharsets.UTF_8));
            String sign = URLEncoder.encode(Base64.getEncoder().encodeToString(signData), "UTF-8");
            String signedUrl = String.format("%s&timestamp=%s&sign=%s", url, timestamp, sign);
            LOGGER.info("请求url:", signedUrl);
            return signedUrl;
        } catch (Exception e) {
            LOGGER.error("加签出现异常");
        }
        return url;
    }

    public interface AuthStep {

        /**
         * 地址
         *
         * @param url
         * @return
         */
        BuildStep url(String url);

    }

    public interface BuildStep {


        /**
         * 带秘钥
         *
         * @param secret
         * @return
         */
        BuildStep secret(String secret);


        DingRobotClient build();


    }

    public static class Steps implements AuthStep, BuildStep {

        private String url;

        private String secret;

        @Override
        public BuildStep url(String url) {
            this.url = url;
            return this;
        }

        @Override
        public BuildStep secret(String secret) {
            this.secret = secret;
            return this;
        }

        @Override
        public DingRobotClient build() {
            return new DingRobotClient(url, secret);
        }
    }


}
