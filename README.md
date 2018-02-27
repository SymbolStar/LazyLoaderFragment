# LazyLoaderFragment
Android  Fragment 懒加载


效果图：

![gif](https://github.com/ScottFJD/LazyLoaderFragment/blob/master/image/sample.gif)

* ViewPager 的setOffscreenPageLimit() 默认为1  即加载第一个fragment的时候
会预加载第二个。使用懒加载只有在当前fragment显示的时候才会加载

* setUserVisibleHint(boolean isVisibleToUser) 在fragment 显示到当前页面和离开当前页面的时候会回调次方法
在当前页面isVisibleToUser 为 true

`注意fragment的生命周期 代码中回调方法都有log`


实现逻辑就是没有实例化一开始的时候全部显示懒加载的界面，数据加载结束之后在懒加载的view替换掉

具体的过程代码中有注释。