package wj.com.alldemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.Keyframe;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * @author wangjian
 * @title LayoutTransitionDemo
 * @description add remove 或者显示隐藏时的动画效果
 * @modifier
 * @date
 * @since 2016/4/13 14:00
 **/
public class LayoutTransitionDemo extends BaseActivity {
    private LinearLayout parent;
    private int i = 0;

    private LayoutTransition mTransition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_layout_transition);

        parent = (LinearLayout) findViewById(R.id.lv_parent);
        initTransition();
        setTransition();
    }

    public void initTransition() {

        /**
         * LayoutTransition类定义了如下几种布局容器动画类型。
         * APPEARING ：当view出现或者添加的时候，view出现的动画
         * DISAPPEARING ：当view消失或者隐藏的时候，view消失的动画
         * CHANGE_APPEARING ：当添加view导致布局容器改变的时候，整个布局容器的动画
         * CHANGE_DISAPPEARING ：当删除或者隐藏view导致布局容器改变的时候，整个布局容器的动画
         * 你可以自定义这些动画，通过setAnimator() 方法把它们设置进一个 LayoutTransition 对象中去。
         */
        mTransition = new LayoutTransition();
        parent.setLayoutTransition(mTransition);
    }

    public void setTransition() {
        /**
         * view出现时 view自身的动画效果
         */
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(null, "rotationY", 90F, 0F).
                setDuration(mTransition.getDuration(LayoutTransition.APPEARING));
        mTransition.setAnimator(LayoutTransition.APPEARING, animator1);

        /**
         * view 消失时，view自身的动画效果
         */
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(null, "rotationX", 0F, 90F, 0F).
                setDuration(mTransition.getDuration(LayoutTransition.DISAPPEARING));
        mTransition.setAnimator(LayoutTransition.DISAPPEARING, animator2);

        /**
         * view 动画改变时，布局中的每个子view动画的时间间隔
         */
        mTransition.setStagger(LayoutTransition.CHANGE_APPEARING, 30);
        mTransition.setStagger(LayoutTransition.CHANGE_DISAPPEARING, 30);

        /**
         * 为什么这里要这么写？具体我也不清楚，ViewGroup源码里面是这么写的，我只是模仿而已
         * 不这么写貌似就没有动画效果了，所以你懂的！
         */
        PropertyValuesHolder pvhLeft = PropertyValuesHolder.ofInt("left", 0, 1);
        PropertyValuesHolder pvhTop = PropertyValuesHolder.ofInt("top", 0, 1);
        PropertyValuesHolder pvhRight = PropertyValuesHolder.ofInt("right", 0, 1);
        PropertyValuesHolder pvhBottom = PropertyValuesHolder.ofInt("bottom", 0, 1);


        /**
         * view出现时，导致整个布局改变的动画
         */
        PropertyValuesHolder animator3 = PropertyValuesHolder.ofFloat("scaleX", 1F, 2F, 1F);
        final ObjectAnimator changeIn = ObjectAnimator.ofPropertyValuesHolder(
        this, pvhLeft, pvhTop, pvhRight, pvhBottom, animator3).
        setDuration(mTransition.getDuration(LayoutTransition.CHANGE_APPEARING));
        changeIn.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                View view = (View) ((ObjectAnimator) animation).getTarget();
                view.setScaleX(1.0f);
            }
        });
        mTransition.setAnimator(LayoutTransition.CHANGE_APPEARING, changeIn);

        /**
         * view消失，导致整个布局改变时的动画
         */
        Keyframe kf0 = Keyframe.ofFloat(0f, 0f);
        Keyframe kf1 = Keyframe.ofFloat(.5f, 2f);
        Keyframe kf2 = Keyframe.ofFloat(1f, 0f);
        PropertyValuesHolder pvhRotation =
        PropertyValuesHolder.ofKeyframe("scaleX", kf0, kf1, kf2);
        final ObjectAnimator changeOut = ObjectAnimator.ofPropertyValuesHolder(
        this, pvhLeft, pvhTop, pvhRight, pvhBottom, pvhRotation).
        setDuration(mTransition.getDuration(LayoutTransition.CHANGE_DISAPPEARING));
        changeOut.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                View view = (View) ((ObjectAnimator) animation).getTarget();
                view.setScaleX(1.0f);
            }
        });
        mTransition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING, changeOut);
    }

    public void buttonClick(View v) {
        addView();
    }

    public void buttonClick1(View v) {
        removeView();
    }

    private void addView() {
        i++;
        Button bt = new Button(this);
        bt.setText("Button" + i);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        parent.addView(bt, params);
    }

    private void removeView() {
        if (i > 0) {
            try {
                parent.removeViewAt(0);
            } catch (Exception e){
                Toast.makeText(this, "没有可移除的Activity了", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
