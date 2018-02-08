package test.net.atshq.bindservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private boolean isConnect=false;
    MyService myService;

    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            isConnect=true;
            MyService.LocalBinder binder = (MyService.LocalBinder) service;
            myService = binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isConnect=false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    public void startService(View view) {
        if(!isConnect){
            bindService(new Intent(this,MyService.class),connection,BIND_AUTO_CREATE);
        }
    }

    public void stopService(View view) {
        if(isConnect){
            unbindService(connection);
        }
    }

    public void toastFromService(View view) {
        if(isConnect){
            myService.showToast();
        }
    }
}
