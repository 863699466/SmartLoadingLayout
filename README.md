# SmartLoadingLayout
让loading的各种状态切换显示变得简单化..

![](https://github.com/RawnHwang/SmartLoadingLayout/blob/master/screenshots/screenshot_01.gif)

<b>1.defined the SmartLoadingLayout object</b>
```
private SmartLoadingLayout mLayout;
```

<b>2.init the layout with host activity</b>
```
mLayout = new SmartLoadingLayout(Activity);
```

<b>3.set the target view</b>
```
mLayout.setLoadingView(R.id.loading); // loading视图
mLayout.setContentView(R.id.content); // 内容视图
mLayout.setEmptyView(R.id.empty);     // 空视图
mLayout.setErrorView(R.id.error);     // 异常视图
```

<b>4.Call back according to diffrent DATA-LOADING status</b>
```
mLayout.onLoading();  // 显示loading视图
mLayout.onDone();     // 显示内容视图
mLayout.onEmpty();    // 显示空视图
mLayout.onError();    // 显示异常视图
```
