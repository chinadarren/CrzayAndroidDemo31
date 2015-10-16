package com.example.cl.crzayandroiddemo31;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;


public class MainActivity extends Activity {
TextSwitcher textSwitcher;
    String [] strs = new String []{
            "疯狂Java讲义","疯狂Android讲义","疯狂Ajax讲义","疯狂不知道讲啥"
    };
    int curStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textSwitcher = (TextSwitcher) findViewById(R.id.textSwitcher);
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView tv = new TextView(MainActivity.this);
                tv.setTextSize(40);
                tv.setTextColor(Color.MAGENTA);
                return tv;
            }
        });
        //调用next方法显示下一个字符串
        next(null);
    }
    //时间处理函数，控制显示下一个字符
    public void next(View source){
        textSwitcher.setText(strs[curStr++ % strs.length]);
    }
}
