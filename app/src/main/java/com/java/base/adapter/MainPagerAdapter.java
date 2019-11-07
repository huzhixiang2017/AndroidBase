package com.java.base.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.java.base.utils.EmptyUtils;

import java.util.List;

/**
 * @ProjectName: AndroidBase
 * @Package: com.java.base.adapter
 * @ClassName: MainPagerAdapter
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019/11/6 16:51
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/11/6 16:51
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class MainPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;

    /**
     * @param fm
     *   androidx中的Fragment懒加载方法 https://blog.csdn.net/qq_36486247/article/details/102531304
     * @param behavior  FragmentPagerAdapter时传入BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT，将加载数据的逻辑放到Fragment的onResume()方法中
     * @param fragments
     */
    public MainPagerAdapter(@NonNull FragmentManager fm, int behavior, List<Fragment> fragments) {
        super(fm, behavior);
        this.fragmentList = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        if(EmptyUtils.isNotEmpty(fragmentList)){
            return fragmentList.size();
        }
        return 0;
    }
}
