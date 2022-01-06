package com.example.embeddedback.utils;

import com.baidu.aip.face.AipFace;
import com.example.embeddedback.pojo.BaiduApiInfo;
import com.example.embeddedback.pojo.Result;
import org.json.JSONObject;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

@Setter
@Service
@ConfigurationProperties(prefix = "baidu")
public class BaiduApiService {
    private String api_id;

    private String api_key;

    private String api_secret;

    private String globalGroupId;


    public JSONObject detect(String file) throws IOException {

        // 初始化一个AipFace
        AipFace client = new AipFace(api_id, api_key, api_secret);
        System.out.println(api_id);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 调用接口
        String imageType = "BASE64";

        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("max_face_num", "1");
        options.put("liveness_control", "NORMAL");

        // 人脸检测
        JSONObject res = client.detect(file, imageType, options);

        System.out.println(res.toString(2));
        return res;
    }

    public JSONObject addUser(String userId,String groupId,String faceToken) throws IOException {

        // 初始化一个AipFace
        AipFace client = new AipFace(api_id, api_key, api_secret);
        System.out.println(api_id);
//        // 初始化一个AipFace
//        AipFace client = new AipFace(api_id, api_key, api_secret);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 调用接口
        String imageType = "FACE_TOKEN";

        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "NORMAL");

        if (groupId == null) {
            // 人脸注册global
            JSONObject res = client.addUser(faceToken, imageType, globalGroupId, userId, options);
            System.out.println(res.toString(2));
            return res;
        }

        JSONObject res = client.addUser(faceToken, imageType, getUserGroupName(groupId), userId, options);
        System.out.println(res.toString(2));
        return res;
    }

    public JSONObject deleteFace(String userId,String groupId,String faceToken) throws IOException {
        // 初始化一个AipFace
        AipFace client = new AipFace(api_id, api_key, api_secret);
        System.out.println(api_id);
//        // 初始化一个AipFace
//        AipFace client = new AipFace(api_id, api_key, api_secret);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        if (groupId == null) {
            // 人脸注册global
            JSONObject res = client.faceDelete(userId, globalGroupId, faceToken, null);
            System.out.println(res.toString(2));
            return res;
        }


        JSONObject res = client.faceDelete(userId, getUserGroupName(groupId), faceToken, null);
        System.out.println(res.toString(2));
        return res;
    }

    public JSONObject addGroup(String groupId) throws IOException {
        // 初始化一个AipFace
        AipFace client = new AipFace(api_id, api_key, api_secret);
        System.out.println(api_id);
//        // 初始化一个AipFace
//        AipFace client = new AipFace(api_id, api_key, api_secret);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理


        JSONObject res = client.groupAdd(getUserGroupName(groupId), null);

        System.out.println(res.toString(2));
        return res;
    }

    public JSONObject deleteGroup(String groupId) throws IOException {
        // 初始化一个AipFace
        AipFace client = new AipFace(api_id, api_key, api_secret);
        System.out.println(api_id);
//        // 初始化一个AipFace
//        AipFace client = new AipFace(api_id, api_key, api_secret);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理


        JSONObject res = client.groupDelete(getUserGroupName(groupId), null);

        System.out.println(res.toString(2));
        return res;
    }

    public JSONObject addUserToGroup(String guestId,String groupId) throws IOException {
        // 初始化一个AipFace
        AipFace client = new AipFace(api_id, api_key, api_secret);
        System.out.println(api_id);
//        // 初始化一个AipFace
//        AipFace client = new AipFace(api_id, api_key, api_secret);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("src_group_id", globalGroupId);
        options.put("dst_group_id", getUserGroupName(groupId));

        JSONObject res = client.userCopy(guestId, options);

        System.out.println(res.toString(2));
        return res;
    }

    public JSONObject deleteUserFromGroup(String guestId,String groupId) throws IOException {
        // 初始化一个AipFace
        AipFace client = new AipFace(api_id, api_key, api_secret);
        System.out.println(api_id);
//        // 初始化一个AipFace
//        AipFace client = new AipFace(api_id, api_key, api_secret);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 传入可选参数调用接口
//        HashMap<String, String> options = new HashMap<String, String>();
//        options.put("src_group_id", globalGroupId);
//        options.put("dst_group_id", getUserGroupName(groupId));

        JSONObject res = client.deleteUser(getUserGroupName(groupId), guestId, null);

        System.out.println(res.toString(2));
        return res;
    }

    public String getUserGroupName(String groupId) {
        if (groupId.equals("@ALL")) {
            return groupId;
        }
        return "group_" + groupId;
    }

    public BaiduApiInfo getInfo() {
        return new BaiduApiInfo(api_id,api_key,api_secret);
    }

}
