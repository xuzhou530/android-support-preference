package net.xpece.android.support.preference;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.support.annotation.AttrRes;
import android.support.annotation.ColorInt;
import android.support.annotation.StyleRes;
import android.support.v4.graphics.ColorUtils;
import android.util.TypedValue;

/**
 * Created by Eugen on 13. 5. 2015.
 * @hide
 */
public final class Util {
    public static final int[] DISABLED_STATE_SET = new int[]{-android.R.attr.state_enabled};
    public static final int[] EMPTY_STATE_SET = new int[0];

    public static final int[][] DISABLED_STATE_LIST = new int[][]{
        DISABLED_STATE_SET,
        EMPTY_STATE_SET
    };

    private static final int[] TEMP_ARRAY = new int[1];

    private Util() {}

    public static float dpToPx(Context context, int dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    public static int dpToPxOffset(Context context, int dp) {
        return (int) (dpToPx(context, dp));
    }

    public static int dpToPxSize(Context context, int dp) {
        return (int) (0.5f + dpToPx(context, dp));
    }

    public static int resolveResourceId(Context context, @AttrRes int attr, int fallback) {
        TEMP_ARRAY[0] = attr;
        TypedArray ta = context.obtainStyledAttributes(TEMP_ARRAY);
        try {
            return ta.getResourceId(0, fallback);
        } finally {
            ta.recycle();
        }
    }

    public static float resolveDimension(Context context, @AttrRes int attr, float fallback) {
        TEMP_ARRAY[0] = attr;
        TypedArray ta = context.obtainStyledAttributes(TEMP_ARRAY);
        try {
            return ta.getDimension(0, fallback);
        } finally {
            ta.recycle();
        }
    }

    public static int resolveDimensionPixelOffset(Context context, @AttrRes int attr, int fallback) {
        float dimen = resolveDimension(context, attr, fallback);
        return (int) (dimen);
    }

    public static int resolveDimensionPixelSize(Context context, @AttrRes int attr, int fallback) {
        float dimen = resolveDimension(context, attr, fallback);
        return (int) (dimen + 0.5f);
    }

    public static float resolveDimension(Context context, @StyleRes int style, @AttrRes int attr, float fallback) {
        TEMP_ARRAY[0] = attr;
        TypedArray ta = context.obtainStyledAttributes(style, TEMP_ARRAY);
        try {
            return ta.getDimension(0, fallback);
        } finally {
            ta.recycle();
        }
    }

    public static int resolveDimensionPixelOffset(Context context, @StyleRes int style, @AttrRes int attr, int fallback) {
        float dimen = resolveDimension(context, style, attr, fallback);
        return (int) (dimen);
    }

    public static int resolveDimensionPixelSize(Context context, @StyleRes int style, @AttrRes int attr, int fallback) {
        float dimen = resolveDimension(context, style, attr, fallback);
        return (int) (dimen + 0.5f);
    }

    public static float resolveFloat(Context context, @AttrRes int attr, float fallback) {
        TEMP_ARRAY[0] = attr;
        TypedArray ta = context.obtainStyledAttributes(TEMP_ARRAY);
        try {
            return ta.getFloat(0, fallback);
        } finally {
            ta.recycle();
        }
    }

    public static int pxToDp(Context context, int px) {
        float dp = context.getResources().getDisplayMetrics().density;
        return (int) (px / dp);
    }

    public static ColorStateList resolveColorStateList(Context context, @AttrRes int attr) {
        TEMP_ARRAY[0] = attr;
        TypedArray ta = context.obtainStyledAttributes(TEMP_ARRAY);
        try {
            return ta.getColorStateList(0);
        } finally {
            ta.recycle();
        }
    }

    @ColorInt
    public static int resolveColor(Context context, @AttrRes int attr, @ColorInt int fallback) {
        TEMP_ARRAY[0] = attr;
        TypedArray ta = context.obtainStyledAttributes(TEMP_ARRAY);
        try {
            return ta.getColor(0, fallback);
        } finally {
            ta.recycle();
        }
    }

    public static ColorStateList withDisabled(int color, int disabledAlpha) {
        int disabledColor = ColorUtils.setAlphaComponent(color, disabledAlpha);
        return new ColorStateList(DISABLED_STATE_LIST, new int[]{disabledColor, color});
    }
}
