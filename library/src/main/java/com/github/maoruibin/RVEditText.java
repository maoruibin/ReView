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
import android.util.AttributeSet;
import android.widget.EditText;


/**
 * Created by GuDong on 2016/10/12 09:32.
 * Contact with gudong.name@gmail.com.
 */

class RVEditText extends EditText implements IReviewView {

    private IReviewControl developViewImpl = new UIDisplayFrameAndInfoImpl(this);

    public RVEditText(Context context) {
        super(context);
        init(context);
    }

    public RVEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public RVEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        developViewImpl.onInitPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        developViewImpl.onDraw(canvas);
    }


    @Override
    public Context getContextWrap() {
        return getContext();
    }

    @Override
    public float getTextSizeWarp() {
        return getTextSize();
    }

    @Override
    public int getTextColorWarp() {
        return getCurrentTextColor();
    }

    @Override
    public float getMeasuredWidthWarp() {
        return getMeasuredWidth();
    }

    @Override
    public float getMeasuredHeightWarp() {
        return getMeasuredHeight();
    }
}
