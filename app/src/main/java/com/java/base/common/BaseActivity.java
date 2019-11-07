package com.java.base.common;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import com.java.base.R;
import com.java.base.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @ProjectName: AndroidBase
 * @Package: com.java.base.common
 * @ClassName: BaseActivity
 * @Description:  如果与第三方的BaseActivity冲突请看这个片文章
 *   https://juejin.im/post/590f09ec128fe100584ee6b0
 * @Author: 作者名
 * @CreateDate: 2019/11/4 15:18
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/11/4 15:18
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public abstract class BaseActivity  extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private static final String TAG = BaseActivity.class.getSimpleName();
    private BaseApplication application;
    private Unbinder unbinder;
    public SearchView search;

    @BindView(R.id.tool_bar)
    public Toolbar toolbar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = BaseApplication.getInstance();
        setContentView(getLayoutId());

        //控件注解，在setContentView之后
        unbinder = ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        initView();
        initData();


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShortToastSafe(R.string.toast_back);
                finish();
            }
        });




    }

    /**
     * 获取布局 ID
     */
    protected abstract int getLayoutId();
    /**
     * 初始化控件
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();



    /**
     * androidx下的 Toolbar https://www.cnblogs.com/wenhanxiao/archive/2019/03/11/10513498.html
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
        unbinder.unbind();
        super.onDestroy();

    }



}
