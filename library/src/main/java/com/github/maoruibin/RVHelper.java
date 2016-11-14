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
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by GuDong on 09/11/2016 23:43.
 * Contact with gudong.name@gmail.com.
 */

public class RVHelper {
    private static UIReviewSetting mSetting;
    static {
        mSetting = UIReviewSetting.getInstance();
    }
    public static void makeLayoutToReviewMod(Context context){
        LayoutInflater.from(context).setFactory(new LayoutInflater.Factory() {
            @Override
            public View onCreateView(String name, Context context, AttributeSet attrs) {
                View view = null;
                switch (name) {
                    case "TextView":
                        view = new RVTextView(context, attrs);
                        break;
                    case "Button":
                        view = new RVButton(context, attrs);
                        break;
                    case "ImageView":
                        view = new RVImageView(context, attrs);
                        break;
                    case "EditText":
                        view = new RVEditText(context, attrs);
                        break;
                    case "RadioButton":
                        view = new RVRadioButton(context, attrs);
                        break;
                    case "CheckBox":
                        view = new RVCheckBox(context, attrs);
                        break;
                    case "RadioGroup":
                        view = new RVRadioGroup(context, attrs);
                        break;
                }
                return view;
            }
        });
    }

    public static void isReviewMod(boolean flag){
        mSetting.isReviewMod(flag);
    }


    public static boolean isReviewMod(){
        return mSetting.isReviewMod();
    }

    public static void isShowBorder(boolean flag){
        mSetting.isShowBorder(flag);
    }

    public static boolean isShowBorder(){
        return mSetting.isShowBorder();
    }

    public static void isShowTextColor(boolean flag){
        mSetting.isShowTextColor(flag);
    }

    public static boolean isShowTextColor(){
        return mSetting.isShowTextColor();
    }
    public static void isShowTextSizeDp(boolean flag){
        mSetting.isShowTextSizeDp(flag);
    }

    public static boolean isShowTextSizeDp(){
        return mSetting.isShowTextSizeDp();
    }

    public static void isShowTextSizeSp(boolean flag){
        mSetting.isShowTextSizeSp(flag);
    }

    public static boolean isShowTextSizeSp(){
        return mSetting.isShowTextSizeSp();
    }
}
