package activitytest.example.com.coolweather.util;

/**
 * Created by myb19930730 on 2016/3/24.
 */
public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
