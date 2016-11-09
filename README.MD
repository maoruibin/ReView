# ReView
[![](https://jitpack.io/v/maoruibin/ReView.svg)](https://jitpack.io/#maoruibin/ReView)
[![](https://img.shields.io/hexpm/l/plug.svg)](https://github.com/maoruibin/ReView/blob/master/LICENSE.txt)

A view to help developers and designers view the View's font size, color, and border, so far, it only support TextView Button and ImageView.

<img src="files/review.gif" width="264">

An introductory article written in Chinese [关于 ReView](http://gudong.name/2016/11/07/about-review.html)

## Demo 
Because of quality of gif, the effect of ReView demo is not looks clear,fell free to download demo apk and run it on mobile device,
you will watch it more clearly.

[download link](files/app-debug.apk)

or Qrcode

![qrcode](http://7xr9gx.com1.z0.glb.clouddn.com/fir-review.png)

## Usage
### Step 1
Add the JitPack repository to your build file
```groovy
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

### Step 2
Add the dependency
```groovy
dependencies {
	 compile 'com.github.maoruibin:ReView:1.0.3'
}
```

### Step 3
use  `RVHelper.makeLayoutToReviewMod(context);` before super.onCreate(),like this.

```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    RVHelper.makeLayoutToReviewMod(this);
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
}
```

### Step 4

Setting options
 
```java
// set current is review mod or not
UIReviewSetting.getInstance().isReviewMod(true);
// set is show border or not 
UIReviewSetting.getInstance().isShowBorder(true);
// set is show text color or not
UIReviewSetting.getInstance().isShowTextColor(true);
// set is show text size by dp or not
UIReviewSetting.getInstance().isShowTextSizeDp(true);
// set is show text size by sp or not
UIReviewSetting.getInstance().isShowTextSizeSp(true);
```
you can get more information by watch demo.  

## Author

[Github](https://github.com/maoruibin)

[Home](http://gudong.name)

[Weibo](http://weibo.com/maoruibin)


## License

    Copyright 2016 GuDong
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
        http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
