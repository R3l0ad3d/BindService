package test.net.atshq.bindservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

    //create binder object
    public LocalBinder binder = new LocalBinder();

    public MyService() {
    }

    //return binder object
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }


    //Create a class for getting service reference
    public class LocalBinder extends Binder{
        public MyService getService(){
            return MyService.this;
        }
    }

    public void showToast(){
        Log.d("Service : ","Show Toast");
        Toast.makeText(this, "From Service ...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Service : ","onCreate");
        Toast.makeText(this, "onCreate ...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("Service : ","onStartCommand");
        Toast.makeText(this, "Service onStartCommand", Toast.LENGTH_SHORT).show();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Service : ","onDestroy");
        Toast.makeText(this, "Service Destroy", Toast.LENGTH_SHORT).show();
    }
}
