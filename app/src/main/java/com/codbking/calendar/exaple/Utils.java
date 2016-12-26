package com.codbking.calendar.exaple;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.Gravity;
import android.view.WindowManager;

/**
 * Created by codbking on 2016/12/10.
 */
 class Utils {

    public static  int getColor(Context context,int res){
        Resources r=context.getResources();
        return r.getColor(res);
    }

    public static float getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        return width;
    }


    public static int px(float dipValue) {
        Resources r=Resources.getSystem();
        final float scale =r.getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }


    //获取显示版本
    public static String getVersionName(Context context) {
        try {
            PackageManager manager =context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            String version = info.versionName;
            return version;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    //获取版本信息
    public static int getVersion(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            int version = info.versionCode;
            return version;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static StateListDrawable getRoundSelectorDrawable(int alpha, int color, int radir) {
        Drawable pressDrawable = getRoundDrawalbe(alpha, color, radir);
        Drawable normalDrawable = getRoundDrawalbe(color, radir);
        return getStateListDrawable(pressDrawable, normalDrawable);
    }

    //获取带透明度的圆角矩形
    public static Drawable getRoundDrawalbe(int alpha, int color, int radir) {
        int normalColor = Color.argb(alpha, Color.red(color), Color.green(color), Color.blue(color));
        Drawable normalDrawable = getRoundDrawalbe(normalColor, radir);
        return normalDrawable;
    }


    //根据颜色获取圆角矩形
    public static Drawable getRoundDrawalbe(int color, int radir) {
        radir = px(radir);
        GradientDrawable drawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{color, color});
        drawable.setCornerRadius(radir);
        return drawable;
    }

    public static StateListDrawable getStateListDrawable(Drawable pressDrawable, Drawable normalDrawable) {
        int pressed = android.R.attr.state_pressed;
        int select = android.R.attr.state_selected;
        StateListDrawable drawable = new StateListDrawable();
        drawable.addState(new int[]{pressed}, pressDrawable);
        drawable.addState(new int[]{select}, pressDrawable);
        drawable.addState(new int[]{}, normalDrawable);
        return drawable;
    }

    public static StateListDrawable getSelectDrawable(int color) {
        int select = android.R.attr.state_selected;
        StateListDrawable drawable = new StateListDrawable();

        GradientDrawable drawable2=new GradientDrawable();
        drawable2.setShape(GradientDrawable.OVAL);
        drawable2.setColor(color);

        drawable.addState(new int[]{select}, drawable2);
        drawable.addState(new int[]{},null);

        return drawable;
    }




}
