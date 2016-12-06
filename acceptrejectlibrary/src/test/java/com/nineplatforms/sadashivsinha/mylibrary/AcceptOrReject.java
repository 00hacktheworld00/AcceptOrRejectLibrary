package com.nineplatforms.sadashivsinha.mylibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by saDashiv sinha on 05-Dec-16.
 */

public class AcceptOrReject extends RelativeLayout implements View.OnTouchListener, View.OnClickListener {

    private Context mContext;

    private  RelativeLayout layout_accept, reject_layout;

    private int screenWidthPixel;
    private int mScreenWidthInDp;
    private float density;
    private int paddingDp = 15;

    private ImageView circularBackGreen, circularBackRed, iconGreen, iconRed, ovalRectangleBox;

    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.reject_layout){
            onRejectClickListener.onClickChanged();
        }
    }

    private void setCircularBackGreenImage(int image){
        circularBackGreen.setImageResource(image);
    }

    private void setCircularBackRedImage(int image){
        circularBackRed.setImageResource(image);
    }

    private void setIconGreenImage(int image){
        iconGreen.setImageResource(image);
    }

    private void setIconRegImage(int image){
        iconRed.setImageResource(image);
    }

    private void setOvalRectangleBoxImage(int image){
        ovalRectangleBox.setImageResource(image);
    }

    public interface OnAcceptSliderListener{
        void onChanged();
    }

    public interface OnRejectClickListener{
        void onClickChanged();
    }

    private AcceptOrReject.OnAcceptSliderListener onAcceptSlideListener;
    private AcceptOrReject.OnRejectClickListener onRejectClickListener;

    public AcceptOrReject(Context context) {
        super(context);
        mContext = context;
        createView();
    }

    public AcceptOrReject(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        createView();
    }

    public AcceptOrReject(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        createView();
    }

    public void createView() {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_accept_reject, this, true);

        ovalRectangleBox = (ImageView) findViewById(R.id.oval_rectangle_box);
        circularBackGreen = (ImageView) findViewById(R.id.slider_image_background_circle_accept);
        circularBackRed = (ImageView) findViewById(R.id.slider_image_background_circle_reject);
        iconGreen = (ImageView) findViewById(R.id.icon_accept);
        iconRed = (ImageView) findViewById(R.id.icon_reject);

        layout_accept = (RelativeLayout) findViewById(R.id.layout_accept);
        reject_layout = (RelativeLayout) findViewById(R.id.reject_layout);

        layout_accept.setOnTouchListener(this);
        reject_layout.setOnClickListener(this);

        WindowManager manager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics ();
        display.getMetrics(outMetrics);

        density  = getResources().getDisplayMetrics().density;
        screenWidthPixel = outMetrics.widthPixels;
        mScreenWidthInDp = (int) (screenWidthPixel / density);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        LayoutParams layoutParams = (LayoutParams) v.getLayoutParams();
        int width = v.getWidth();
        float positionX = event.getRawX();

        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // You can add some clicked reaction here.
                reject_layout.setVisibility(GONE);
                break;
            case MotionEvent.ACTION_MOVE:
                reject_layout.setVisibility(GONE);

                if((positionX < (screenWidthPixel - width - paddingDp*density))) {

                    layoutParams.leftMargin = (int) positionX - width / 2;
                    layout_accept.setLayoutParams(layoutParams);
                }
                else
                {
                    if(positionX > paddingDp*density){
                        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_END);
                        layout_accept.setLayoutParams(layoutParams);
                    }
                    onAcceptSlideListener.onChanged();
                }
                break;

            case MotionEvent.ACTION_UP:
                if((positionX > (screenWidthPixel - width - paddingDp*density))) {
                    layoutParams.addRule(RelativeLayout.ALIGN_PARENT_END);
                    layout_accept.setLayoutParams(layoutParams);
                    reject_layout.setVisibility(GONE);
                }
                else {
                    reject_layout.setVisibility(VISIBLE);
                    layoutParams.leftMargin = 0;
                    layout_accept.setLayoutParams(layoutParams);
                }


                break;
            default:
                break;
        }

        return true;
    }

    public void setOnAcceptSlideListener(AcceptOrReject.OnAcceptSliderListener listener) {
        onAcceptSlideListener = listener;
    }

    public void setOnRejectClickListener(AcceptOrReject.OnRejectClickListener listener) {
        onRejectClickListener = listener;
    }

} //end of class
