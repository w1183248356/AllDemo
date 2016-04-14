package wj.com.alldemo;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.widget.Button;

/**
 * @author wangjian
 * @title GradientDrawableDemo
 * @description 用于按钮
 * @modifier
 * @date
 * @since 2016/4/14 16:10
 **/
public class GradientDrawableDemo extends Activity{
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn10;
    private Button btn11;
    private Button btn12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_gradient_frawable);
        btn1 = (Button) findViewById(R.id.btn_1);
        btn2 = (Button) findViewById(R.id.btn_2);
        btn3 = (Button) findViewById(R.id.btn_3);
        btn4 = (Button) findViewById(R.id.btn_4);
        btn5 = (Button) findViewById(R.id.btn_5);
        btn6 = (Button) findViewById(R.id.btn_6);
        btn7 = (Button) findViewById(R.id.btn_7);
        btn8 = (Button) findViewById(R.id.btn_8);
        btn9 = (Button) findViewById(R.id.btn_9);
        btn10 = (Button) findViewById(R.id.btn_10);
        btn11 = (Button) findViewById(R.id.btn_11);
        btn12 = (Button) findViewById(R.id.btn_12);
        initView();
    }

    public void initView(){
        /**
         * GradientDrawable允许指定绘制图形的种类：LINE，OVAL，RECTANGLE 或是 RING ，
         * 颜色渐变支持LINEAR_GRADIENT，RADIAL_GRADIENT 和 SWEEP_GRADIENT。
         */

        /** draw the gradient from the top to the bottom
        * TOP_BOTTOM,
        * draw the gradient from the top-right to the bottom-left
        * TR_BL,
        * draw the gradient from the right to the left
        * RIGHT_LEFT,
        * draw the gradient from the bottom-right to the top-left
        * BR_TL,
        * draw the gradient from the bottom to the top
        * BOTTOM_TOP,
        * draw the gradient from the bottom-left to the top-right
        * BL_TR,
        * draw the gradient from the left to the right
        * LEFT_RIGHT,
        * draw the gradient from the top-left to the bottom-right
        * TL_BR,*/

        float r = 16;

        //设置为RECTANGLE   LINEAR_GRADIENT
        GradientDrawable mDrawable1 = new GradientDrawable(GradientDrawable.Orientation.TL_BR,
                new int[]{0xFFFF0000, 0xFF00FF00, 0xFF0000FF});//红，绿，蓝
        mDrawable1.setShape(GradientDrawable.RECTANGLE);
        mDrawable1.setGradientRadius((float)(Math.sqrt(2) * 60));
        Canvas canvas = new Canvas();

        canvas.save();
        canvas.translate(10, 10);
        mDrawable1.setGradientType(GradientDrawable.LINEAR_GRADIENT);
        setCornerRadii(mDrawable1, r, r, r, r);
        mDrawable1.draw(canvas);
        canvas.restore();
        btn1.setBackground(mDrawable1);

        //设置为RECTANGLE RADIAL_GRADIENT
        GradientDrawable mDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TL_BR,
                new int[]{0xFFFF0000, 0xFF00FF00, 0xFF0000FF});//红，绿，蓝
        mDrawable2.setShape(GradientDrawable.RECTANGLE);
        mDrawable2.setGradientRadius((float)(Math.sqrt(2) * 60));
        Canvas canvas2 = new Canvas();
        canvas2.save();
        canvas2.translate(10, 10);
        mDrawable2.setGradientType(GradientDrawable.RADIAL_GRADIENT);
        setCornerRadii(mDrawable2, r, r, r, r);
        mDrawable2.draw(canvas2);
        canvas2.restore();
        btn2.setBackground(mDrawable2);

        //设置为RECTANGLE SWEEP_GRADIENT
        GradientDrawable mDrawable3 = new GradientDrawable(GradientDrawable.Orientation.TL_BR,
                new int[]{0xFFFF0000, 0xFF00FF00, 0xFF0000FF});//红，绿，蓝
        mDrawable3.setShape(GradientDrawable.RECTANGLE);
        mDrawable3.setGradientRadius((float)(Math.sqrt(2) * 60));
        Canvas canvas3 = new Canvas();
        canvas3.save();
        canvas3.translate(10, 10);
        mDrawable3.setGradientType(GradientDrawable.SWEEP_GRADIENT);
        setCornerRadii(mDrawable3, r, r, r, r);
        mDrawable3.draw(canvas3);
        canvas3.restore();
        btn3.setBackground(mDrawable3);

        //设置为RECTANGLE   LINEAR_GRADIENT
        GradientDrawable mDrawable4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,
                new int[]{0xFFFF0000, 0xFF00FF00, 0xFF0000FF});//红，绿，蓝
        mDrawable4.setShape(GradientDrawable.RECTANGLE);
        mDrawable4.setGradientRadius((float)(Math.sqrt(2) * 60));
        Canvas canvas4 = new Canvas();

        canvas4.save();
        canvas4.translate(10, 10);
        mDrawable4.setGradientType(GradientDrawable.LINEAR_GRADIENT);
        setCornerRadii(mDrawable4, r, r, r, r);
        mDrawable4.draw(canvas4);
        canvas4.restore();
        btn4.setBackground(mDrawable4);

        //设置为RECTANGLE RADIAL_GRADIENT
        GradientDrawable mDrawable5 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,
                new int[]{0xFFFF0000, 0xFF00FF00, 0xFF0000FF});//红，绿，蓝
        mDrawable5.setShape(GradientDrawable.RECTANGLE);
        mDrawable5.setGradientRadius((float)(Math.sqrt(2) * 60));
        Canvas canvas5 = new Canvas();
        canvas5.save();
        canvas5.translate(10, 10);
        mDrawable5.setGradientType(GradientDrawable.RADIAL_GRADIENT);
        setCornerRadii(mDrawable5, r, r, r, r);
        mDrawable5.draw(canvas5);
        canvas5.restore();
        btn5.setBackground(mDrawable5);

        //设置为RECTANGLE SWEEP_GRADIENT
        GradientDrawable mDrawable6 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,
                new int[]{0xFFFF0000, 0xFF00FF00, 0xFF0000FF});//红，绿，蓝
        mDrawable6.setShape(GradientDrawable.RECTANGLE);
        mDrawable6.setGradientRadius((float)(Math.sqrt(2) * 60));
        Canvas canvas6 = new Canvas();
        canvas6.save();
        canvas6.translate(10, 10);
        mDrawable6.setGradientType(GradientDrawable.SWEEP_GRADIENT);
        setCornerRadii(mDrawable6, r, r, r, r);
        mDrawable6.draw(canvas6);
        canvas6.restore();
        btn6.setBackground(mDrawable6);
    }

    static void setCornerRadii(GradientDrawable drawable, float r0,
                               float r1, float r2, float r3) {
        drawable.setCornerRadii(new float[] { r0, r0, r1, r1,
                r2, r2, r3, r3 });
    }
}
