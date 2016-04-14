package wj.com.alldemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ViewFlipper;

/**
 * @author wangjian
 * @title FlipperDemo
 * @description
 * @modifier
 * @date
 * @since 2016/4/14 17:57
 **/
public class FlipperDemo extends Activity {
    ViewFlipper viewFlipper = null;
    float startX;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_flipper);
        init();
    }

    private void init() {
        viewFlipper = (ViewFlipper) this.findViewById(R.id.viewFlipper);
    }

    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                if (event.getX() > startX) { // 向右滑动
                    viewFlipper.setInAnimation(this, R.anim.in_leftright);
                    viewFlipper.setOutAnimation(this, R.anim.out_leftright);
                    viewFlipper.showNext();
                } else if (event.getX() < startX) { // 向左滑动
                    viewFlipper.setInAnimation(this, R.anim.in_rightleft);
                    viewFlipper.setOutAnimation(this, R.anim.out_rightleft);
                    viewFlipper.showPrevious();
                }
                break;
        }
        return super.onTouchEvent(event);
    }
}
