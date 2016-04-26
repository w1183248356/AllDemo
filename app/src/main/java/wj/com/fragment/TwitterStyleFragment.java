package wj.com.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import wj.com.alldemo.R;

/**
 * @author wangjian
 * @title TwitterStyleFragment
 * @description
 * @modifier
 * @date
 * @since 2016/4/18 16:57
 **/
public class TwitterStyleFragment extends BaseFragment {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Adapter mAdapter;

    public static TwitterStyleFragment newInstance(){
        return new TwitterStyleFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new Adapter(getChildFragmentManager());
        String[] titles = getTitles();
        for (int i = 0; i < titles.length; i++) {
            mAdapter.addFragment(getFragment(i), titles[i]);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nav_twitter, container, false);
        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        viewPager.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Twitter");
    }

    protected String[] getTitles() {
        return new String[]{"ListView", "GridView",
                "RecyclerView", "Grid RecyclerView", "StaggeredGrid RecyclerView",
                "ScrollView", "WebView",
                "FrameLayout", "RelativeLayout",
                "LinearLayout", "ImageView", "TextView"};
    }

    protected Fragment getFragment(int position) {
        String title = getTitles()[position];
        Fragment fragment = null;
        if (title.equals("ListView")) {
            fragment = new TwitterStyleFragment();
//        } else if (title.equals("GridView")) {
//            fragment = new TwitterGridViewFragment();
//        } else if (title.equals("RecyclerView")) {
//            fragment = TwitterRecyclerFragment.newInstance(TwitterRecyclerFragment.TYPE_LINEAR);
//        } else if (title.equals("Grid RecyclerView")) {
//            // grid
//            fragment = TwitterRecyclerFragment.newInstance(TwitterRecyclerFragment.TYPE_GRID);
//        } else if (title.equals("StaggeredGrid RecyclerView")) {
//            fragment = TwitterRecyclerFragment.newInstance(TwitterRecyclerFragment.TYPE_STAGGERED_GRID);
//        } else if (title.equals("ScrollView")) {
//            fragment = new TwitterScrollViewFragment();
//        } else if (title.equals("WebView")) {
//            fragment = new TwitterWebViewFragment();
//        } else if (title.equals("FrameLayout")
//                || title.equals("RelativeLayout")
//                || title.equals("LinearLayout")
//                || title.equals("ImageView")
//                || title.equals("TextView")) {
//            fragment = TwitterOtherViewFragment.newInstance(title);
        }
        return fragment;
    }

    protected static class Adapter extends FragmentPagerAdapter {
        private List<Fragment> fragments = new ArrayList<>();
        private List<CharSequence> titles = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, CharSequence title) {
            fragments.add(fragment);
            titles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }
}
