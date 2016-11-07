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

package com.github.maoruibin.helper;

/**
 * Created by GuDong on 2016/10/13 11:08.
 * Contact with gudong.name@gmail.com.
 */
public class UIReviewSetting {
    private static boolean isReviewMod = false;
    private static boolean isShowBorder = false;
    private static boolean isShowTextColor = false;
    private static boolean isShowTextSizeDp = false;
    private static boolean isShowTextSizeSp = false;
    private UIReviewSetting(){

    }

    public static UIReviewSetting getInstance(){
        return SingletonHolder.settingCenter;
    }

    private static class SingletonHolder{
        private static UIReviewSetting settingCenter = new UIReviewSetting();
    }

    public void isReviewMod(boolean flag){
        isReviewMod = flag;
    }

    public boolean isReviewMod(){
        return isReviewMod;
    }

    public void isShowBorder(boolean flag){
        isShowBorder = flag;
    }

    public boolean isShowBorder(){
        return isShowBorder;
    }

    public void isShowTextColor(boolean flag){
        isShowTextColor = flag;
    }

    public boolean isShowTextColor(){
        return isShowTextColor;
    }
    public void isShowTextSizeDp(boolean flag){
        isShowTextSizeDp = flag;
    }

    public boolean isShowTextSizeDp(){
        return isShowTextSizeDp;
    }

    public void isShowTextSizeSp(boolean flag){
        isShowTextSizeSp = flag;
    }

    public boolean isShowTextSizeSp(){
        return isShowTextSizeSp;
    }
}
