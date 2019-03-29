package gx.com.home;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

import gx.com.common.Utils.CJS.CJSUtil;
import gx.com.home.activity.MyFragment;
import gx.com.home.adapter.MyFragmentPager;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeMainFragment extends Fragment implements IHomeView{
    private TabLayout tbs;
    private ViewPager viewP;
    private List<String> titls = new ArrayList<>();
    int width =0;
    int height=0;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment_main, container, false);
        CJSUtil.setStatusBar(getActivity());
        initView(view);
        initEvent();
        ViewGroup.LayoutParams layoutParams = tbs.getLayoutParams();
        layoutParams.height = (int) (height*0.06);
        layoutParams.width = (int) (width*0.75);
        tbs.setLayoutParams(layoutParams);

        return view;
    }
    public void initView(View view){
        titls.add("推荐");
        titls.add("按位置排列");
        tbs = view.findViewById(R.id.tabs);
        getWH();
        viewP = view.findViewById(R.id.viewP);
    }

    private void getWH() {
        WindowManager manager = getActivity().getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        width = outMetrics.widthPixels;
        height = outMetrics.heightPixels;
    }

    private void initEvent() {
        for (int i = 0; i < titls.size(); i++) {
            TabLayout.Tab tab = tbs.newTab();
            tbs.addTab(tab.setText(titls.get(i)));
        }
        List<Fragment> fragments = new ArrayList<Fragment>();
        for (int i = 0; i < titls.size(); i++) {
            fragments.add(new MyFragment());
        }

        MyFragmentPager fragmentPager = new MyFragmentPager(getActivity().getSupportFragmentManager(), fragments, titls);
        // 给ViewPager 设置适配器
        viewP.setAdapter(fragmentPager);
        //  将TabLayout 和 ViewPager 关联起来
        tbs.setupWithViewPager(viewP);
    }

}
