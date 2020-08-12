package com.example.day02_networkframework;

import java.util.List;

public class Demo {
    /**
     * data : {"curPage":1,"datas":[{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"id":14590,"link":"https://www.jianshu.com/p/9c039a0bcbb1","niceDate":"17分钟前","niceShareDate":"17分钟前","origin":"","prefix":"","projectLink":"","publishTime":1596267479000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1596267479000,"shareUser":"折剑游侠","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"ViewModel原理分析","type":0,"userId":28244,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"id":14588,"link":"https://juejin.im/post/6855865111354851335","niceDate":"48分钟前","niceShareDate":"48分钟前","origin":"","prefix":"","projectLink":"","publishTime":1596265626000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1596265614000,"shareUser":"徐公码字","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"面试官系列 - LeetCode链表知识点&amp;题型总结","type":0,"userId":5339,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"id":14586,"link":"https://blog.csdn.net/xiao10034263/article/details/107726310","niceDate":"5小时前","niceShareDate":"5小时前","origin":"","prefix":"","projectLink":"","publishTime":1596249127000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1596247795000,"shareUser":"itxiaox","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Gradle发布总结&mdash;&mdash;Gradle发布那些事儿","type":0,"userId":24201,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"id":14582,"link":"https://www.jianshu.com/p/b5b919f24f82","niceDate":"20小时前","niceShareDate":"20小时前","origin":"","prefix":"","projectLink":"","publishTime":1596195582000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1596195582000,"shareUser":"彭旭锐","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Java | 深入理解方法调用的本质（含重载与重写区别）","type":0,"userId":30587,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"id":14580,"link":"https://www.jianshu.com/p/79ae2b49a725","niceDate":"20小时前","niceShareDate":"20小时前","origin":"","prefix":"","projectLink":"","publishTime":1596193622000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1596193622000,"shareUser":"折剑游侠","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"LiveData原理分析","type":0,"userId":28244,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"id":14579,"link":"https://www.jianshu.com/p/aff113e588e6","niceDate":"20小时前","niceShareDate":"20小时前","origin":"","prefix":"","projectLink":"","publishTime":1596193586000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1596193586000,"shareUser":"折剑游侠","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"LifeCycle原理分析","type":0,"userId":28244,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"id":14576,"link":"https://juejin.im/post/6844903987817218061","niceDate":"23小时前","niceShareDate":"23小时前","origin":"","prefix":"","projectLink":"","publishTime":1596185640000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1596185640000,"shareUser":"tokiii","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Android仿转转首页banner","type":0,"userId":15292,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":99,"chapterName":"具体案例","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14568,"link":"https://juejin.im/post/6855129007798894599","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1596126444000,"realSuperChapterId":37,"selfVisible":0,"shareDate":1596126321000,"shareUser":"鸿洋","superChapterId":126,"superChapterName":"自定义控件","tags":[],"title":"Android自定义控件 | 时隔一年，用新知识重构一个老库","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":423,"chapterName":"Architecture","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14569,"link":"https://juejin.im/post/6855129004165627911","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1596126430000,"realSuperChapterId":422,"selfVisible":0,"shareDate":1596126394000,"shareUser":"鸿洋","superChapterId":423,"superChapterName":"Jetpack","tags":[],"title":"是时候更新手里的武器了&mdash;Jetpack架构组件简析","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"code小生","canEdit":false,"chapterId":414,"chapterName":"code小生","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14583,"link":"https://mp.weixin.qq.com/s/1Kkt6zoqa670f-Dez8XBLw","niceDate":"1天前","niceShareDate":"16小时前","origin":"","prefix":"","projectLink":"","publishTime":1596124800000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1596208514000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/414/1"}],"title":"Android DEPPLINK、APPLink 原理简析","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","canEdit":false,"chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14584,"link":"https://mp.weixin.qq.com/s/gvgFzJgozACfjAWZYFd8TQ","niceDate":"1天前","niceShareDate":"16小时前","origin":"","prefix":"","projectLink":"","publishTime":1596124800000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1596208530000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"开发一个 IM App 需要会多少知识点？","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"郭霖","canEdit":false,"chapterId":409,"chapterName":"郭霖","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14585,"link":"https://mp.weixin.qq.com/s/LCN3ACxbvtGLiahqokYxTw","niceDate":"1天前","niceShareDate":"16小时前","origin":"","prefix":"","projectLink":"","publishTime":1596124800000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1596208544000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/409/1"}],"title":"Android内存管理知识百科","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":95,"chapterName":"相机Camera","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14543,"link":"https://www.jianshu.com/p/95cd95e961d7","niceDate":"2天前","niceShareDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1596041781000,"realSuperChapterId":38,"selfVisible":0,"shareDate":1596029849000,"shareUser":"鸿洋","superChapterId":95,"superChapterName":"多媒体技术","tags":[],"title":"Android相机拍照方向旋转的解决方案：ExifInterface","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"code小生","canEdit":false,"chapterId":414,"chapterName":"code小生","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14564,"link":"https://mp.weixin.qq.com/s/cwf-DSFx4T0AsR2AuEH0zA","niceDate":"2天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1596038400000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1596120355000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/414/1"}],"title":"滴滴开源 移动开发 方面的 4 个项目","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","canEdit":false,"chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14565,"link":"https://mp.weixin.qq.com/s/ilK_f8A6IxkAkDwplqVr1w","niceDate":"2天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1596038400000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1596120372000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"推荐一个更贴近 android 场景的启动框架 | Anchors","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14542,"link":"https://juejin.im/post/5f2116e76fb9a07e644f16ce","niceDate":"2天前","niceShareDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1596015084000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1596015084000,"shareUser":"逮虾户","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"再谈Android Lint","type":0,"userId":63284,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14538,"link":"https://mp.weixin.qq.com/s/uiVYTTFZhYPsC2ykjQ6Tfw","niceDate":"2020-07-29 09:24","niceShareDate":"2020-07-29 09:24","origin":"","prefix":"","projectLink":"","publishTime":1595985848000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1595985848000,"shareUser":"飞洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"你想要的Android性能优化系列：内存优化！","type":0,"userId":31360,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","canEdit":false,"chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14544,"link":"https://mp.weixin.qq.com/s/ixgiyEEDuLVfZHcjUF9DsA","niceDate":"2020-07-29 00:00","niceShareDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1595952000000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1596030968000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"直面底层：经常用的ViewTreeObserver 背后的原理","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"承香墨影","canEdit":false,"chapterId":411,"chapterName":"承香墨影","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14545,"link":"https://mp.weixin.qq.com/s/QXyezti9MzALhI39DlI2Mg","niceDate":"2020-07-29 00:00","niceShareDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1595952000000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1596030988000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/411/1"}],"title":"不要让你的Java对象&quot;逃逸&quot;了！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"郭霖","canEdit":false,"chapterId":409,"chapterName":"郭霖","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14546,"link":"https://mp.weixin.qq.com/s/qMrKdv10MQQsNrRBARzxcA","niceDate":"2020-07-29 00:00","niceShareDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1595952000000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1596031006000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/409/1"}],"title":"Android Resources.arsc文件结构分析","type":0,"userId":-1,"visible":1,"zan":0}],"offset":0,"over":false,"pageCount":448,"size":20,"total":8951}
     * errorCode : 0
     * errorMsg :
     */

    private DataBean data;
    private int errorCode;
    private String errorMsg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static class DataBean {
        /**
         * curPage : 1
         * datas : [{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"id":14590,"link":"https://www.jianshu.com/p/9c039a0bcbb1","niceDate":"17分钟前","niceShareDate":"17分钟前","origin":"","prefix":"","projectLink":"","publishTime":1596267479000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1596267479000,"shareUser":"折剑游侠","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"ViewModel原理分析","type":0,"userId":28244,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"id":14588,"link":"https://juejin.im/post/6855865111354851335","niceDate":"48分钟前","niceShareDate":"48分钟前","origin":"","prefix":"","projectLink":"","publishTime":1596265626000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1596265614000,"shareUser":"徐公码字","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"面试官系列 - LeetCode链表知识点&amp;题型总结","type":0,"userId":5339,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"id":14586,"link":"https://blog.csdn.net/xiao10034263/article/details/107726310","niceDate":"5小时前","niceShareDate":"5小时前","origin":"","prefix":"","projectLink":"","publishTime":1596249127000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1596247795000,"shareUser":"itxiaox","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Gradle发布总结&mdash;&mdash;Gradle发布那些事儿","type":0,"userId":24201,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"id":14582,"link":"https://www.jianshu.com/p/b5b919f24f82","niceDate":"20小时前","niceShareDate":"20小时前","origin":"","prefix":"","projectLink":"","publishTime":1596195582000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1596195582000,"shareUser":"彭旭锐","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Java | 深入理解方法调用的本质（含重载与重写区别）","type":0,"userId":30587,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"id":14580,"link":"https://www.jianshu.com/p/79ae2b49a725","niceDate":"20小时前","niceShareDate":"20小时前","origin":"","prefix":"","projectLink":"","publishTime":1596193622000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1596193622000,"shareUser":"折剑游侠","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"LiveData原理分析","type":0,"userId":28244,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"id":14579,"link":"https://www.jianshu.com/p/aff113e588e6","niceDate":"20小时前","niceShareDate":"20小时前","origin":"","prefix":"","projectLink":"","publishTime":1596193586000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1596193586000,"shareUser":"折剑游侠","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"LifeCycle原理分析","type":0,"userId":28244,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"id":14576,"link":"https://juejin.im/post/6844903987817218061","niceDate":"23小时前","niceShareDate":"23小时前","origin":"","prefix":"","projectLink":"","publishTime":1596185640000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1596185640000,"shareUser":"tokiii","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Android仿转转首页banner","type":0,"userId":15292,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":99,"chapterName":"具体案例","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14568,"link":"https://juejin.im/post/6855129007798894599","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1596126444000,"realSuperChapterId":37,"selfVisible":0,"shareDate":1596126321000,"shareUser":"鸿洋","superChapterId":126,"superChapterName":"自定义控件","tags":[],"title":"Android自定义控件 | 时隔一年，用新知识重构一个老库","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":423,"chapterName":"Architecture","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14569,"link":"https://juejin.im/post/6855129004165627911","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1596126430000,"realSuperChapterId":422,"selfVisible":0,"shareDate":1596126394000,"shareUser":"鸿洋","superChapterId":423,"superChapterName":"Jetpack","tags":[],"title":"是时候更新手里的武器了&mdash;Jetpack架构组件简析","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"code小生","canEdit":false,"chapterId":414,"chapterName":"code小生","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14583,"link":"https://mp.weixin.qq.com/s/1Kkt6zoqa670f-Dez8XBLw","niceDate":"1天前","niceShareDate":"16小时前","origin":"","prefix":"","projectLink":"","publishTime":1596124800000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1596208514000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/414/1"}],"title":"Android DEPPLINK、APPLink 原理简析","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","canEdit":false,"chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14584,"link":"https://mp.weixin.qq.com/s/gvgFzJgozACfjAWZYFd8TQ","niceDate":"1天前","niceShareDate":"16小时前","origin":"","prefix":"","projectLink":"","publishTime":1596124800000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1596208530000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"开发一个 IM App 需要会多少知识点？","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"郭霖","canEdit":false,"chapterId":409,"chapterName":"郭霖","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14585,"link":"https://mp.weixin.qq.com/s/LCN3ACxbvtGLiahqokYxTw","niceDate":"1天前","niceShareDate":"16小时前","origin":"","prefix":"","projectLink":"","publishTime":1596124800000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1596208544000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/409/1"}],"title":"Android内存管理知识百科","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":95,"chapterName":"相机Camera","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14543,"link":"https://www.jianshu.com/p/95cd95e961d7","niceDate":"2天前","niceShareDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1596041781000,"realSuperChapterId":38,"selfVisible":0,"shareDate":1596029849000,"shareUser":"鸿洋","superChapterId":95,"superChapterName":"多媒体技术","tags":[],"title":"Android相机拍照方向旋转的解决方案：ExifInterface","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"code小生","canEdit":false,"chapterId":414,"chapterName":"code小生","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14564,"link":"https://mp.weixin.qq.com/s/cwf-DSFx4T0AsR2AuEH0zA","niceDate":"2天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1596038400000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1596120355000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/414/1"}],"title":"滴滴开源 移动开发 方面的 4 个项目","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","canEdit":false,"chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14565,"link":"https://mp.weixin.qq.com/s/ilK_f8A6IxkAkDwplqVr1w","niceDate":"2天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1596038400000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1596120372000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"推荐一个更贴近 android 场景的启动框架 | Anchors","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14542,"link":"https://juejin.im/post/5f2116e76fb9a07e644f16ce","niceDate":"2天前","niceShareDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1596015084000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1596015084000,"shareUser":"逮虾户","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"再谈Android Lint","type":0,"userId":63284,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14538,"link":"https://mp.weixin.qq.com/s/uiVYTTFZhYPsC2ykjQ6Tfw","niceDate":"2020-07-29 09:24","niceShareDate":"2020-07-29 09:24","origin":"","prefix":"","projectLink":"","publishTime":1595985848000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1595985848000,"shareUser":"飞洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"你想要的Android性能优化系列：内存优化！","type":0,"userId":31360,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","canEdit":false,"chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14544,"link":"https://mp.weixin.qq.com/s/ixgiyEEDuLVfZHcjUF9DsA","niceDate":"2020-07-29 00:00","niceShareDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1595952000000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1596030968000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"直面底层：经常用的ViewTreeObserver 背后的原理","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"承香墨影","canEdit":false,"chapterId":411,"chapterName":"承香墨影","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14545,"link":"https://mp.weixin.qq.com/s/QXyezti9MzALhI39DlI2Mg","niceDate":"2020-07-29 00:00","niceShareDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1595952000000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1596030988000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/411/1"}],"title":"不要让你的Java对象&quot;逃逸&quot;了！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"郭霖","canEdit":false,"chapterId":409,"chapterName":"郭霖","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14546,"link":"https://mp.weixin.qq.com/s/qMrKdv10MQQsNrRBARzxcA","niceDate":"2020-07-29 00:00","niceShareDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1595952000000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1596031006000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/409/1"}],"title":"Android Resources.arsc文件结构分析","type":0,"userId":-1,"visible":1,"zan":0}]
         * offset : 0
         * over : false
         * pageCount : 448
         * size : 20
         * total : 8951
         */

        private int curPage;
        private int offset;
        private boolean over;
        private int pageCount;
        private int size;
        private int total;
        private List<DatasBean> datas;

        public int getCurPage() {
            return curPage;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public boolean isOver() {
            return over;
        }

        public void setOver(boolean over) {
            this.over = over;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<DatasBean> getDatas() {
            return datas;
        }

        public void setDatas(List<DatasBean> datas) {
            this.datas = datas;
        }

        public static class DatasBean {
            /**
             * apkLink :
             * audit : 1
             * author :
             * canEdit : false
             * chapterId : 502
             * chapterName : 自助
             * collect : false
             * courseId : 13
             * desc :
             * descMd :
             * envelopePic :
             * fresh : true
             * id : 14590
             * link : https://www.jianshu.com/p/9c039a0bcbb1
             * niceDate : 17分钟前
             * niceShareDate : 17分钟前
             * origin :
             * prefix :
             * projectLink :
             * publishTime : 1596267479000
             * realSuperChapterId : 493
             * selfVisible : 0
             * shareDate : 1596267479000
             * shareUser : 折剑游侠
             * superChapterId : 494
             * superChapterName : 广场Tab
             * tags : []
             * title : ViewModel原理分析
             * type : 0
             * userId : 28244
             * visible : 1
             * zan : 0
             */

            private String apkLink;
            private int audit;
            private String author;
            private boolean canEdit;
            private int chapterId;
            private String chapterName;
            private boolean collect;
            private int courseId;
            private String desc;
            private String descMd;
            private String envelopePic;
            private boolean fresh;
            private int id;
            private String link;
            private String niceDate;
            private String niceShareDate;
            private String origin;
            private String prefix;
            private String projectLink;
            private long publishTime;
            private int realSuperChapterId;
            private int selfVisible;
            private long shareDate;
            private String shareUser;
            private int superChapterId;
            private String superChapterName;
            private String title;
            private int type;
            private int userId;
            private int visible;
            private int zan;
            private List<?> tags;

            public String getApkLink() {
                return apkLink;
            }

            public void setApkLink(String apkLink) {
                this.apkLink = apkLink;
            }

            public int getAudit() {
                return audit;
            }

            public void setAudit(int audit) {
                this.audit = audit;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public boolean isCanEdit() {
                return canEdit;
            }

            public void setCanEdit(boolean canEdit) {
                this.canEdit = canEdit;
            }

            public int getChapterId() {
                return chapterId;
            }

            public void setChapterId(int chapterId) {
                this.chapterId = chapterId;
            }

            public String getChapterName() {
                return chapterName;
            }

            public void setChapterName(String chapterName) {
                this.chapterName = chapterName;
            }

            public boolean isCollect() {
                return collect;
            }

            public void setCollect(boolean collect) {
                this.collect = collect;
            }

            public int getCourseId() {
                return courseId;
            }

            public void setCourseId(int courseId) {
                this.courseId = courseId;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getDescMd() {
                return descMd;
            }

            public void setDescMd(String descMd) {
                this.descMd = descMd;
            }

            public String getEnvelopePic() {
                return envelopePic;
            }

            public void setEnvelopePic(String envelopePic) {
                this.envelopePic = envelopePic;
            }

            public boolean isFresh() {
                return fresh;
            }

            public void setFresh(boolean fresh) {
                this.fresh = fresh;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getNiceDate() {
                return niceDate;
            }

            public void setNiceDate(String niceDate) {
                this.niceDate = niceDate;
            }

            public String getNiceShareDate() {
                return niceShareDate;
            }

            public void setNiceShareDate(String niceShareDate) {
                this.niceShareDate = niceShareDate;
            }

            public String getOrigin() {
                return origin;
            }

            public void setOrigin(String origin) {
                this.origin = origin;
            }

            public String getPrefix() {
                return prefix;
            }

            public void setPrefix(String prefix) {
                this.prefix = prefix;
            }

            public String getProjectLink() {
                return projectLink;
            }

            public void setProjectLink(String projectLink) {
                this.projectLink = projectLink;
            }

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public int getRealSuperChapterId() {
                return realSuperChapterId;
            }

            public void setRealSuperChapterId(int realSuperChapterId) {
                this.realSuperChapterId = realSuperChapterId;
            }

            public int getSelfVisible() {
                return selfVisible;
            }

            public void setSelfVisible(int selfVisible) {
                this.selfVisible = selfVisible;
            }

            public long getShareDate() {
                return shareDate;
            }

            public void setShareDate(long shareDate) {
                this.shareDate = shareDate;
            }

            public String getShareUser() {
                return shareUser;
            }

            public void setShareUser(String shareUser) {
                this.shareUser = shareUser;
            }

            public int getSuperChapterId() {
                return superChapterId;
            }

            public void setSuperChapterId(int superChapterId) {
                this.superChapterId = superChapterId;
            }

            public String getSuperChapterName() {
                return superChapterName;
            }

            public void setSuperChapterName(String superChapterName) {
                this.superChapterName = superChapterName;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getVisible() {
                return visible;
            }

            public void setVisible(int visible) {
                this.visible = visible;
            }

            public int getZan() {
                return zan;
            }

            public void setZan(int zan) {
                this.zan = zan;
            }

            public List<?> getTags() {
                return tags;
            }

            public void setTags(List<?> tags) {
                this.tags = tags;
            }
        }

    }
}
