package wj.com.alldemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import wj.com.adapter.MainRcleViewAdapter;


public class MainActivity extends AppCompatActivity {
    private RecyclerView rcleView;
    private List<String> list;
    private MainRcleViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcleView = (RecyclerView) findViewById(R.id.rcleView);
        initView();
        initDate();
    }

    public void initView(){
        rcleView.setLayoutManager(new LinearLayoutManager(this));
        rcleView.setHasFixedSize(true);
        rcleView.setItemAnimator(new DefaultItemAnimator());
        adapter = new MainRcleViewAdapter();
        rcleView.setAdapter(adapter);

        rcleView.setOnItemClickListener(new RecyclerView.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                try {
                    Intent intent = new Intent(MainActivity.this, Class.forName(adapter.getList().get(i)));
                    startActivity(intent);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void initDate(){
        list = new ArrayList<>();
        list.add("wj.com.alldemo.LayoutTransitionDemo");
        list.add("wj.com.alldemo.GradientDrawableDemo");
        list.add("wj.com.alldemo.FlipperDemo");
        list.add("wj.com.alldemo.SwipeToLoadLayoutDemo");
        adapter.setList(list);
    }
}
