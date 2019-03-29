package gx.com.myfirstapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import gx.com.common.Utils.CJS.CJSUtil;
import gx.com.myfirstapp.R;

/**
 * Created by Asus on 2019/3/28.
 */

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        CJSUtil.setStatusBar(this);
    }
}
