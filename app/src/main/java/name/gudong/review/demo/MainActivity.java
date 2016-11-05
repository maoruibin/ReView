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

package name.gudong.review.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import name.gudong.review.helper.UIReviewSetting;

public class MainActivity extends AppCompatActivity {
    LinearLayout llTvContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llTvContainer = (LinearLayout) findViewById(R.id.ll_tv_container);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.is_develop_mod).setChecked(UIReviewSetting.getInstance().isDevelop());
        menu.findItem(R.id.is_show_frame).setChecked(UIReviewSetting.getInstance().isShowBorder());
        menu.findItem(R.id.show_text_color).setChecked(UIReviewSetting.getInstance().isShowTextColor());
        menu.findItem(R.id.show_text_size_dp).setChecked(UIReviewSetting.getInstance().isShowTextSizeDp());
        menu.findItem(R.id.show_text_size_sp).setChecked(UIReviewSetting.getInstance().isShowTextSizeSp());
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.is_develop_mod:
                if (item.isChecked()) {
                    item.setChecked(false);
                    UIReviewSetting.getInstance().isDevelop(false);
                } else {
                    item.setChecked(true);
                    UIReviewSetting.getInstance().isDevelop(true);
                }
                break;
            case R.id.is_show_frame:
                if (item.isChecked()) {
                    item.setChecked(false);
                    UIReviewSetting.getInstance().isShowBorder(false);
                } else {
                    item.setChecked(true);
                    UIReviewSetting.getInstance().isShowBorder(true);
                }
                break;
            case R.id.show_text_color:
                if (item.isChecked()) {
                    item.setChecked(false);
                    UIReviewSetting.getInstance().isShowTextColor(false);
                } else {
                    item.setChecked(true);
                    UIReviewSetting.getInstance().isShowTextColor(true);
                }
                break;
            case R.id.show_text_size_dp:
                if (item.isChecked()) {
                    item.setChecked(false);
                    UIReviewSetting.getInstance().isShowTextSizeDp(false);
                } else {
                    item.setChecked(true);
                    UIReviewSetting.getInstance().isShowTextSizeDp(true);
                }
                break;
            case R.id.show_text_size_sp:
                if (item.isChecked()) {
                    item.setChecked(false);
                    UIReviewSetting.getInstance().isShowTextSizeSp(false);
                } else {
                    item.setChecked(true);
                    UIReviewSetting.getInstance().isShowTextSizeSp(true);
                }
                break;
        }
        recreate();
        return super.onOptionsItemSelected(item);
    }
}
