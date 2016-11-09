/*
 * Copyright 2016 GuDong
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.maoruibin;

import android.content.Context;
import android.util.TypedValue;

import java.text.DecimalFormat;

/**
 * Created by GuDong on 2016/10/13 10:49.
 * Contact with gudong.name@gmail.com.
 */

class Utils {
    static String formatTextSize(float textPxSize, String unit) {
        return new DecimalFormat("0").format(textPxSize) + unit;
    }

    static String formatTextColor(int intColor) {
        return String.format("#%06X", 0xFFFFFFFF & intColor);
    }

    static float px2dp(Context context, float pxVal) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (pxVal / scale);
    }

    static float px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (pxValue / fontScale);
    }

    static int dp2px(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal, context.getResources().getDisplayMetrics());
    }
}
