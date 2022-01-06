package com.example.embeddedback.utils;

import com.aliyun.iot20180120.Client;
import com.aliyun.iot20180120.models.*;
import com.aliyun.teaopenapi.models.Config;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


@Setter
@Service
@ConfigurationProperties(prefix = "aliyun")
public class AliyunService {

    private String accessKeyId;

    private String accessKeySecret;

    private String productKey;

    private String iotInstanceId;

    private String productSecret;

    final Client createClient() throws Exception {
        Config config = new Config()
                .setAccessKeyId(accessKeyId)
                .setAccessKeySecret(accessKeySecret);
        config.endpoint = "iot.cn-shanghai.aliyuncs.com";
        return new Client(config);
    }

    /**
     * 创建物联网设备
     * @return
     * @throws Exception
     */
    @Async
    public RegisterDeviceResponseBody.RegisterDeviceResponseBodyData createDevice() throws Exception {
        Client client = createClient();
        RegisterDeviceRequest registerDeviceRequest = new RegisterDeviceRequest()
                .setProductKey(productKey)
                .setIotInstanceId(iotInstanceId);
        RegisterDeviceResponse registerDeviceResponse = client.registerDevice(registerDeviceRequest);
        if (registerDeviceResponse.body.success == true) {
            return registerDeviceResponse.body.data;
        } else {
            return null;
        }
    }

    /**
     * 删除物联网设备
     * @param iotId
     * @return
     * @throws Exception
     */
    @Async
    public boolean deleteDevice(String iotId) throws Exception {
        Client client = createClient();
        DeleteDeviceRequest deleteDeviceRequest = new DeleteDeviceRequest()
                .setProductKey(productKey)
                .setIotInstanceId(iotInstanceId)
                .setIotId(iotId);
        DeleteDeviceResponse deleteDeviceResponse = client.deleteDevice(deleteDeviceRequest);
        return deleteDeviceResponse.body.success;
    }

    @Async
    public boolean updateDeviceConfig() throws Exception {
        Client client = createClient();
        PubBroadcastRequest pubBroadcastRequest = new PubBroadcastRequest()
                .setIotInstanceId(iotInstanceId)
                .setProductKey(productKey)
                .setTopicFullName("/broadcast/" + productKey + "/update_config")
                .setMessageContent(Base64.getEncoder().encodeToString("Config updated".getBytes(StandardCharsets.UTF_8)));
        PubBroadcastResponse pubBroadcastResponse = client.pubBroadcast(pubBroadcastRequest);
        return pubBroadcastResponse.body.success;
    }
}
