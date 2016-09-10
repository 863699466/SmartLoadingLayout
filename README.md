# SmartLoadingLayout
让loading的各种状态切换显示变得简单化..

![](https://github.com/RawnHwang/SmartLoadingLayout/blob/master/screenshots/screenshot_01.gif)

```
    compile 'me.rawnhwang.library:app:1.2.4'
```

<b>Firtst of,get a SmartLoadingLayout(DefaultLoadingLayout/CustomLoadingLayout) object</b></br>
<b>If we select DefaultLoadingLayout</b>
```
private DefaultLoadingLayout mLayout;
//......
ListView lvContent = (ListView) findViewById(R.id.lv_content);
mLayout = SmartLoadingLayout.createDefaultLayout(this,lvContent); 
```
<b>When called onLoading</b>
```
mLayout.onLoading();
```
![](https://github.com/RawnHwang/SmartLoadingLayout/blob/master/screenshots/onLoading.gif)

<b>When called onDone</b>
```
mLayout.onDone();
```
![](https://github.com/RawnHwang/SmartLoadingLayout/blob/master/screenshots/onDone.gif)

<b>When called onEmpty</b>
```
mLayout.onEmpty();
```
![](https://github.com/RawnHwang/SmartLoadingLayout/blob/master/screenshots/onEmpty.png)

<b>When called onError</b>
```
mLayout.onError();
```
![](https://github.com/RawnHwang/SmartLoadingLayout/blob/master/screenshots/onError.png)

<b>if you don't like the original style,you can turn them into the way you like</b></br>
<b>for example:</b>
```
        mLayout.setErrorButtonListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLayout.replaceErrorIcon(R.mipmap.ic_launcher);
                mLayout.setErrorDescription("This my error information.");
                mLayout.setErrorDescriptionColor(Color.BLUE);
                mLayout.setErrorDescriptionTextSize(20);
                mLayout.setErrorButtonText("oh!no!");
                mLayout.setErrorButtonTextColor(Color.RED);
                mLayout.setErrorButtonBackground(R.drawable.bg_error);
            }
        });
```
![](https://github.com/RawnHwang/SmartLoadingLayout/blob/master/screenshots/changeStyle.gif)

<b>Android if you want to totally customize,youc can use  CustomLoadingLayout</b></br>
<b>for example:</b>
```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">
    <ListView
        android:id="@+id/lv_content"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_centerInParent="true" />
    <!-- this is your custom part -->
    <include
        android:id="@+id/my_empty_page"
        layout="@layout/my_empty_page" />

    <include
        android:id="@+id/my_error_page"
        layout="@layout/my_error_page" />

    <include
        android:id="@+id/my_loading_page"
        layout="@layout/my_loading_page" />
</LinearLayout>
```

```Java
private CustomLoadingLayout mLayout;

//.........

mLayout = SmartLoadingLayout.createCustomLayout(this);
mLayout.setContentView(R.id.lv_content);
mLayout.setLoadingView(R.id.my_loading_page);
mLayout.setEmptyView(R.id.my_empty_page);
mLayout.setErrorView(R.id.my_error_page);
```
![](https://github.com/RawnHwang/SmartLoadingLayout/blob/master/screenshots/cutomStyle.gif)
