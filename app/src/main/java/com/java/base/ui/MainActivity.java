package com.java.base.ui;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.java.base.R;
import com.java.base.common.BaseApplication;
import com.java.base.utils.ToastUtils;
import com.java.base.views.main.AlphaRadioGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

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

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, View.OnClickListener {

    @BindView(R.id.view_pager)
    public ViewPager viewPager;//使用注解后必须为public
    @BindView(R.id.radio_group)
    public AlphaRadioGroup alphaRadioGroup;
    @BindView(R.id.tool_bar)
    public Toolbar toolbar;

    private Unbinder unbinder;
    private SearchView search;
    private BaseApplication application;

    private String[] title = new String[]{
           "消息", "通讯录","发现","我的"
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        application = BaseApplication.getInstance();
        //如果有使用黄油刀(控件注解功能)，请在这边加入即可
        unbinder = ButterKnife.bind(this);

        initView();
        initData();
        registerListener();

    }



    private void initView() {
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); //在ToolBar对象上启用返回钮
        }

    }



    private void initData(){
        alphaRadioGroup.showDot(1);//show the dot on bottomBar
        alphaRadioGroup.showDot(3);
        alphaRadioGroup.showUnreadCount(0, 9);//show the unreadCount on bottomBar
        alphaRadioGroup.showUnreadCount(2, 99);

        new Thread(new Runnable() {//测试2秒后关闭消息提示
            @Override
            public void run() {
                SystemClock.sleep(1000);
                alphaRadioGroup.hideUnreadCount(2);//hide the unreadCount after show it
                SystemClock.sleep(1000);
                alphaRadioGroup.hideDot(3);//hide the dot on bottomBar after show it
            }
        }).start();

        List<TestFragment> list = new ArrayList<>();
        for (int i = 0; i < alphaRadioGroup.getChildCount(); i++) {
            TestFragment fragment = new TestFragment();
            Bundle bundle = new Bundle();
            bundle.putString(TestFragment.CONTENT, title[i]);
            fragment.setArguments(bundle);
            list.add(fragment);
        }

        viewPager.setAdapter(new ChatPagerAdapter(getSupportFragmentManager(), list));
        alphaRadioGroup.setViewPager(viewPager);
    }

    private void registerListener(){
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShortToastSafe(R.string.toast_back);
                finish();
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }


    /**
     * androidx下的Toolbar https://www.cnblogs.com/wenhanxiao/archive/2019/03/11/10513498.html
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        search = (SearchView) searchItem.getActionView();
        // 设置提交按钮是否可见（默认不可见）
        search.setSubmitButtonEnabled(true);
        // 设置左侧是否显示搜索图标（false默认不可见）
        search.setIconifiedByDefault(true);

        return super.onCreateOptionsMenu(menu);
    }

    //设置监听 普通的Delete按钮
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
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                if (!search.isIconified()) {
                    search.setIconified(true);
                    return true;
                }
                break;
        }
        return super.onKeyUp(keyCode, event);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }




    class ChatPagerAdapter extends FragmentPagerAdapter {

        List<TestFragment> mData;

        ChatPagerAdapter(FragmentManager fm, List<TestFragment> data) {
            super(fm);
            mData = data;
        }

        @Override
        public Fragment getItem(int position) {
            return mData.get(position);
        }

        @Override
        public int getCount() {
            return mData.size();
        }
    }
}