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
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.TextUtils;

/**
 * show view's border line and text color and size info at the top of view
 * Created by GuDong on 2016/10/13 10:46.
 * Contact with gudong.name@gmail.com.
 */

class UIDisplayFrameAndInfoImpl implements IReviewControl {
    private static final String TAG = "UIDisplayFrameAndInfoImpl";
    private static final int min_width = 100;
    private Paint mPaintInfo;
    private Paint mPaintTextInfo;
    private String textColor = "";
    private String textSizeDp = "";
    private String textSizeSp = "";
    private float textInfoRectHeight = 0;
    private float paddingTextDistance = 6;

    private IReviewView mDevelopView;

    private Context mContext;

    private UIReviewSetting mSetting;

    public UIDisplayFrameAndInfoImpl(IReviewView mDevelopView) {
        this.mDevelopView = mDevelopView;
        mContext = mDevelopView.getContextWrap();
        mSetting = UIReviewSetting.getInstance();
    }

    @Override
    public boolean isReviewMod() {
        return mSetting.isReviewMod();
    }

    @Override
    public void onInitPaint() {
        if (isReviewMod()) {
            mPaintInfo = new Paint();
            mPaintInfo.setColor(Color.parseColor("#FFF00000"));
            // set line width 4 px
            mPaintInfo.setStrokeWidth(4);

            mPaintTextInfo = new TextPaint();
            mPaintTextInfo.setColor(Color.WHITE);
            mPaintTextInfo.setTextSize(Utils.dp2px(mContext, 8));
            mPaintTextInfo.setAntiAlias(true);
            textInfoRectHeight = Math.abs(mPaintTextInfo.descent() + mPaintTextInfo.ascent()) + 2 * paddingTextDistance;

            Float textSize = mDevelopView.getTextSizeWarp();
            if (textSize > 0) {
                int intColor = mDevelopView.getTextColorWarp();
                float textFloatSizeDp = Utils.px2dp(mContext, textSize);
                float textFloatSizeSp = Utils.px2sp(mContext, textSize);

                textColor = Utils.formatTextColor(intColor);
                textSizeDp = Utils.formatTextSize(textFloatSizeDp, "dp");
                textSizeSp = Utils.formatTextSize(textFloatSizeSp, "sp");
            }
        }
    }

    @Override
    public void onDraw(Canvas canvas) {
        if (isReviewMod()) {
            if (mPaintInfo == null) {
                onInitPaint();
            }

            if (mSetting.isShowBorder()) {
                mPaintInfo.setStyle(Paint.Style.STROKE);
                mPaintInfo.setColor(Color.parseColor("#80F00000"));
                canvas.drawRect(new RectF(0, 0, mDevelopView.getMeasuredWidthWarp(), mDevelopView.getMeasuredHeightWarp()), mPaintInfo);
            }

            if (mSetting.isShowTextColor() || mSetting.isShowTextSizeDp() || mSetting.isShowTextSizeSp()) {
                String info = getShowInfo(mSetting.isShowTextColor(), mSetting.isShowTextSizeDp(), mSetting.isShowTextSizeSp());
                float textWidth = getTextWidth(info);
                float forPadding = 2 * paddingTextDistance;
                mPaintInfo.setStyle(Paint.Style.FILL);
                canvas.drawRect(new RectF(0, 0, textWidth + forPadding, textInfoRectHeight), mPaintInfo);
                canvas.drawText(info, 0 + paddingTextDistance, textInfoRectHeight - paddingTextDistance, mPaintTextInfo);
            }
        }
    }

    private String getShowInfo(boolean isShowTextColor, boolean isShowTextSizeDp, boolean isShowTextSizeSp) {
        StringBuilder sb = new StringBuilder();
        if (isShowTextColor) {
            sb.append(textColor);
        }
        if (isShowTextSizeDp) {
            sb.append(" ");
            sb.append(textSizeDp);
        }
        if (isShowTextSizeSp) {
            sb.append(" ");
            sb.append(textSizeSp);
        }
        return sb.toString();
    }

    private float getTextWidth(String text) {
        if (!TextUtils.isEmpty(text)) {
            return mPaintTextInfo.measureText(text);
        } else {
            return min_width;
        }
    }
}
