package io.android_tech.myexample;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import io.android_tech.myexample.Activity.Activity_Main;
import io.android_tech.myexample.AdapterView.AdapterView_Main;
import io.android_tech.myexample.BroadcastReceiver.Receiver_Main;
import io.android_tech.myexample.ContentProvider.Provider_Main;
import io.android_tech.myexample.Layouts.Layout_Main;
import io.android_tech.myexample.Location.Location_Main;
import io.android_tech.myexample.MultiMedia.MultiMedia_Main;
import io.android_tech.myexample.Network.Network_Main;
import io.android_tech.myexample.SNS.SNS_Main;
import io.android_tech.myexample.Service.Service_Main;
import io.android_tech.myexample.Thread.Thread_Main;
import io.android_tech.myexample.Views.View_Main;
import io.android_tech.myexample.WebView.WebView_Main;
import io.android_tech.myexample.Widgets.Widget_Main;

public class MainActivity extends ListActivity implements OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        String[] args = res.getStringArray(R.array.main_menu);

        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, args));

        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        Resources res = getResources();
        String[] args = res.getStringArray(R.array.main_menu);
        Intent i = null;
        switch (arg2) {
            case 0:
                i = new Intent(this, View_Main.class);
                break;
            case 1:
                i = new Intent(this, Layout_Main.class);
                break;
            case 2:
                i = new Intent(this, Widget_Main.class);
                break;
            case 3:
                i = new Intent(this, AdapterView_Main.class);
                break;
            case 4:
                i = new Intent(this, Thread_Main.class);
                break;
            case 5:
                i = new Intent(this, Activity_Main.class);
                break;
            case 6:
                i = new Intent(this, Service_Main.class);
                break;
            case 7:
                i = new Intent(this, Receiver_Main.class);
                break;
            case 8:
                i = new Intent(this, Provider_Main.class);
                break;
            case 9:
                i = new Intent(this, MultiMedia_Main.class);
                break;
            case 10:
                i = new Intent(this, Network_Main.class);
                break;
            case 11:
                i = new Intent(this, WebView_Main.class);
                break;
            case 12:
                i = new Intent(this, Location_Main.class);
                break;
            case 13:
                i = new Intent(this, SNS_Main.class);
                break;
            default:
                Toast.makeText(this, "준비중", Toast.LENGTH_SHORT).show();
                return;
        }
        startActivity(i);
        Toast.makeText(this, args[arg2], Toast.LENGTH_SHORT).show();


    }
}
