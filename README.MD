# ReView
[![](https://jitpack.io/v/maoruibin/ReView.svg)](https://jitpack.io/#maoruibin/ReView)
[![](https://img.shields.io/hexpm/l/plug.svg)](https://github.com/maoruibin/ReView/blob/master/LICENSE.txt)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-ReView-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/4652)

A view to [help](#Demo) developers and designers view the View's font size, color, and border, so far, it only support TextView Button and ImageView.

Only by one line code,and all TextView、Button、ImageView and others support view will show text border、color attr in top of View like gif demo.

<img src="files/review.gif" width="264">

An introductory article written in Chinese [关于 ReView](http://gudong.name/2016/11/07/about-review.html)

## Demo 

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
	 compile 'com.github.maoruibin:ReView:1.1.0'
}
```

### Step 3
use  `RVHelper.makeLayoutToReviewMod(context)` like this.

```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    RVHelper.makeLayoutToReviewMod(this);
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
}
```

`Note:it  should be called before super.onCreate()`

### Step 4

Setting options 
 
```java
// set current is review mod or not
RVHelper.isReviewMod(true);
// set is show border or not 
RVHelper.isShowBorder(true);
// set is show text color or not
RVHelper.isShowTextColor(true);
// set is show text size by dp or not
RVHelper.isShowTextSizeDp(true);
// set is show text size by sp or not
RVHelper.isShowTextSizeSp(true);
```
you can get more information by watch demo.  


Inspired by douban 

## Support View

* TextView 
* Button 
* ImageView 
* EditText 
* CheckBox 
* RadioButton 
* ProgressBar


## Author
[http://gudong.name](http://gudong.name)

[https://github.com/maoruibin](https://github.com/maoruibin)


[http://weibo.com/maoruibin](http://weibo.com/maoruibin)


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
