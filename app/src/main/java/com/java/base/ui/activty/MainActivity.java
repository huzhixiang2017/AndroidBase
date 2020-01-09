package com.java.base.ui.activty;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.java.base.R;
import com.java.base.adapter.MainPagerAdapter;
import com.java.base.common.BaseActivity;
import com.java.base.databinding.ActivityMainBinding;
import com.java.base.ui.fragment.HomeFragment;
import com.java.base.ui.fragment.TestFragment;
import com.java.base.ui.fragment.ThreeFragment;
import com.java.base.ui.fragment.TwoFragment;
import com.java.base.utils.ToastUtils;
import com.java.base.views.main.AlphaRadioGroup;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;

/**
  *
  * @ProjectName:    ${PROJECT_NAME}
  * @Package:        ${PACKAGE_NAME}
  * @ClassName:      ${NAME}
  * @Description:     java类作用描述
  * @Author:         作者名
  * @CreateDate:     ${DATE} ${TIME}
  * @UpdateUser:     更新者：
  * @UpdateDate:     ${DATE} ${TIME}
  * @UpdateRemark:   更新说明：
  * @Version:        1.0
 */

public class MainActivity extends BaseActivity<ActivityMainBinding> {
    private static final String TAG = MainActivity.class.getSimpleName();
    private MainPagerAdapter adapter;

    @BindView(R.id.view_pager)
    public ViewPager viewPager;//使用注解后必须为public
    @BindView(R.id.radio_group)
    public AlphaRadioGroup alphaRadioGroup;
    @BindView(R.id.tool_bar)
    public Toolbar toolbar;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    protected void initView(Bundle savedInstanceState) {
        viewPager = bindView.viewPager;
        alphaRadioGroup = bindView.radioGroup;
        toolbar = bindView.toolBar;


        setSupportActionBar(toolbar);//隐藏toolbar
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); //在ToolBar对象上启用返回钮
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {//返回按钮
            @Override
            public void onClick(View v) {
                ToastUtils.showShortToastSafe(R.string.toast_back);
                finish();
            }
        });
    }


    @Override
    public void initData(){

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(HomeFragment.newInstance());
        fragmentList.add(TwoFragment.newInstance());
        fragmentList.add(ThreeFragment.newInstance());
        fragmentList.add(TestFragment.newInstance());
        adapter = new MainPagerAdapter(getSupportFragmentManager(),FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fragmentList);
        viewPager.setOffscreenPageLimit(fragmentList.size());//ViewPager中Fragment切换过程不被销毁
        viewPager.setAdapter(adapter);
        alphaRadioGroup.setViewPager(viewPager);

        alphaRadioGroup.showDot(1);//show the dot on bottomBar
        alphaRadioGroup.showDot(3);
        alphaRadioGroup.showUnreadCount(0, 9);//show the unreadCount on bottomBar
        alphaRadioGroup.showUnreadCount(2, 99);

        new Thread(new Runnable() {//测试2秒后关闭消息提示
            @Override
            public void run() {
                SystemClock.sleep(1500);
                alphaRadioGroup.hideUnreadCount(2);//hide the unreadCount after show it
                SystemClock.sleep(1000);
                alphaRadioGroup.hideDot(3);//hide the dot on bottomBar after show it
            }
        }).start();


    }



    //设置监听 普通的Delete按钮等
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_del:
                ToastUtils.showShortToastSafe(R.string.toast_delete);
                break;
            case R.id.action_warn:
                ToastUtils.showShortToastSafe(R.string.toast_warn);
                break;
            case R.id.action_settings:
                ToastUtils.showShortToastSafe(R.string.toast_settings);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        ToastUtils.showShortToastSafe(R.string.toast_settings);
        Toast.makeText(MainActivity.this, "Submit" + query, Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Toast.makeText(MainActivity.this, "Change" + newText, Toast.LENGTH_SHORT).show();
        return false;
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}