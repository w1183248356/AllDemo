package wj.com.alldemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

/**
 * @author wangjian
 * @title SwipeToLoadLayoutDemo
 * @description
 * @modifier
 * @date
 * @since 2016/4/15 15:13
 **/
public class SwipeToLoadLayoutDemo extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static final String ITEM_ID = "itemId";
    private DrawerLayout drawerLayout;

    // TODO: 2016/4/15 为了重新学习下，老不用不熟悉了。。。
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle bundle = msg.getData();
            int itemId = bundle.getInt(ITEM_ID);
            if (msg.what == 1) {
                Log.e("send_message", "ABOUT = " + itemId);
            } else if (msg.what == 2) {
                Log.e("send_message", "FRAGMENT = " + itemId);
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void initView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drwrView);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navView);

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(final MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        int itemId = item.getItemId();
        // TODO: 2016/4/15 下面的都是为了熟悉下最近有点忘记的代码
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int itemId = item.getItemId();
                if(itemId == R.id.nav_about){
                    Log.e("postDelayed", "ABOUT = " + itemId);
                } else {
                    Log.e("postDelayed", "FRAGMENT = " + itemId);
                }
            }
        }, 200);
        new Thread(new Runnable() {
            @Override
            public void run() {
                int itemId = item.getItemId();
                Message msg = new Message();
                Bundle bundle = new Bundle();
                if (itemId == R.id.nav_about) {
                    msg.what = 1;
                    bundle.putInt(ITEM_ID, itemId);
                } else {
                    msg.what = 2;
                    bundle.putInt(ITEM_ID, itemId);
                }
                msg.setData(bundle);
                handler.sendMessage(msg);
            }
        });
        return true;
    }
}
