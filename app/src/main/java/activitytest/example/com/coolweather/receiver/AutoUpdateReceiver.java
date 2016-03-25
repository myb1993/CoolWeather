package activitytest.example.com.coolweather.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by myb19930730 on 2016/3/25.
 */
public class AutoUpdateReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, AutoUpdateReceiver.class);
        context.startService(i);
    }
}
