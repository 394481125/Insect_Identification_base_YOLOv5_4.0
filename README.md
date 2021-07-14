# Insect_Identification_APP_Project

Android+ncnn+yolov5实现的昆虫识别项目，个人参赛用，请勿他用。

## 此项目我们使用了XUI

[![github](https://img.shields.io/badge/GitHub-xuexiangjys-blue.svg)](https://github.com/xuexiangjys)  

## 此项目使用了YOLOv5

[![github](https://img.shields.io/badge/GitHub-ultralytics-blue.svg)](https://github.com/ultralytics/yolov5) 

## 此项目使用了YOLOv5-ncnn

[![github](https://img.shields.io/badge/GitHub-nihui-blue.svg)](https://github.com/nihui/ncnn-android-yolov5) 

## 回忆一下出现的问题

### 1.debug时候正常没有任何报错，但打包成APK的release版本时报错？

解决：在app中的gradle里取消minifyEnabled，就是将它设为false，我的问题就解决了。

参考文章：https://blog.csdn.net/shenzhongaboluo/article/details/78325363

### 2.因为之前都是C#所以找Android字典没找到，果断用了hashmap？

解决：

```python
import java.util.HashMap;
HashMap hm=new HashMap();
hm.put("001","张三");
hm.put("002","李四");
hm.put("003","王五");
String s=(String)hm.get("001");
```

参考文章：https://www.cnblogs.com/zzy-frisrtblog/p/5559467.html

其他问题我再想想吧……（Android assets、getAssets（）、android.content.context、bitmap与uri、还有ndk的版本问题、TextView使用、[TextView多行数据显示](https://www.cnblogs.com/jiduoduo/p/13852825.html)、[Android studio的常见布局](https://blog.csdn.net/qq_41454799/article/details/82595203?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-3.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-3.control)、[FrameLayout](http://blog.csdn.net/yihui823/article/details/6702273)、[decodeStream()](https://blog.csdn.net/lknlll/article/details/77340614)、[cmake 常用变量和常用环境变量](https://www.cnblogs.com/linuxAndMcu/p/10670591.html)）

