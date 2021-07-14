/*
 * Copyright (C) 2020 xuexiangjys(xuexiangjys@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.xuexiang.InsectIdentification.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.xuexiang.InsectIdentification.R;
import com.xuexiang.InsectIdentification.adapter.entity.NewInfo;
import com.xuexiang.xaop.annotation.MemoryCache;
import com.xuexiang.xui.adapter.simple.AdapterItem;
import com.xuexiang.xui.utils.ResUtils;
import com.xuexiang.xui.widget.banner.widget.banner.BannerItem;

import java.util.ArrayList;
import java.util.List;

/**
 * 演示数据
 *
 * @author xuexiang
 * @since 2018/11/23 下午5:52
 */
public class DemoDataProvider {

    public static String[] titles = new String[]{
            "图片1介绍",
            "图片2介绍",
            "图片3介绍",
            "图片4介绍",
            "图片5介绍",
    };

    public static String[] urls = new String[]{//640*360 360/640=0.5625
            "http://5b0988e595225.cdn.sohucs.com/images/20190827/82fb32d8648447a59c06cb95f9eb4324.jpeg",//图片1介绍
            "http://5b0988e595225.cdn.sohucs.com/q_70,c_zoom,w_640/images/20181208/8d3155c54d9a47a8b9fe1f8d3cec402f.jpeg",//图片2介绍
            "http://5b0988e595225.cdn.sohucs.com/images/20180510/790f47b7813247abb95fad3d927d81d3.jpg",//图片3介绍
            "https://ss2.meipian.me/users/39791919/3c96096df5e280615a4d7108eab74c69.jpg?imageView2/2/w/750/h/1400/q/80",//图片4介绍
            "https://ss3.baidu.com/9fo3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/54fbb2fb43166d22a50a637b4d2309f79152d2e4.jpg",//图片5介绍
    };

    @MemoryCache
    public static List<BannerItem> getBannerList() {
        List<BannerItem> list = new ArrayList<>();
        for (int i = 0; i < urls.length; i++) {
            BannerItem item = new BannerItem();
            item.imgUrl = urls[i];
            item.title = titles[i];

            list.add(item);
        }
        return list;
    }

    /**
     * 用于占位的空信息
     *
     * @return
     */




    @MemoryCache
    public static List<NewInfo> getDemoNewInfos() {
        List<NewInfo> list = new ArrayList<>();
        list.add(new NewInfo("昆虫信息", "麻皮蝽")
                .setSummary("目：半翅目 \n 科：蝽科 \n 属：麻皮蝽属 \n 名称：麻皮蝽 \n 虫害代码：C15408105005 \n 拉丁学名：Erthesina fullo (Thunberg) \n 栖息地： \n 油桐、油茶、柿、梧桐、泡桐、杨、桃、杏、槐、樱花、构树、女贞、悬铃木 \n 分布区域： \n 宜兴；常州市；淮阴区、金湖县；浦口区、六合区、玄武区、栖霞区；靖江；宿迁沭阳、宿城区、宿豫区、泗洪；阜宁、盐都、大丰、射阳、东台；江都区、宝应县、扬州市开发区、瘦西湖；镇江市；常熟、吴中区、昆山、吴江、苏州高新区、太仓、丰泾村；徐州：云龙区、鼓楼区、泉山区、开发区、丰县、沛县、铜山区、睢宁县、邳州市、新沂市、贾汪区(全市)")
                .setDetailUrl("http://inews.gtimg.com/newsapp_bt/0/10684849959/1000.jpg")
                .setImageUrl("http://inews.gtimg.com/newsapp_bt/0/10684849959/1000.jpg"));//麻皮蝽
        list.add(new NewInfo("昆虫信息", "草履蚧")
                .setSummary("目：半翅目 \n 科：珠蚧科 \n 属：履绵蚧属 \n 名称：草履蚧 \n 虫害代码：C15331005010 \n 拉丁学名：Drosicha corpulenta (Kuwana) \n 栖息地： \n 杨、樟、石楠、女贞、山核桃、榆等、梨、紫薇、法国冬青、悬铃木、红叶石楠、金边黄杨、珊瑚树、紫叶李 \n 分布区域： \n 灌南；徐州：云龙区、鼓楼区、泉山区、开发区、丰县、沛县、铜山区、睢宁县、邳州市、新沂市、贾汪区(全市）")
                .setDetailUrl("http://pic.baike.soso.com/ugc/baikepic2/6430/20180617162848-1456067530_jpg_640_706_248451.jpg/0")
                .setImageUrl("http://pic.baike.soso.com/ugc/baikepic2/6430/20180617162848-1456067530_jpg_640_706_248451.jpg/0"));//草履蚧
        list.add(new NewInfo("昆虫信息", "褐边绿刺蛾")
                .setSummary("目：鳞翅目 \n 科：刺蛾科 \n 属：绿刺蛾属\n 名称：褐边绿刺蛾 \n 虫害代码：C22301090015 \n 拉丁学名：Latoria consocia Walker \n 栖息地： \n 杨树、枣、梨、杏、桃、李、柿、栗、苹果、海棠、樱桃、山楂、核桃等果树，杨、榆、柳、枫、槭、桑、梧桐、白蜡、紫荆、刺槐、乌桕、冬青、悬铃木等 \n 分布区域： \n 常州市；赣榆区、连云区；如皋；常熟；泰兴；宿迁泗阳、沭阳、宿城区、泗洪、宿豫区；镇江市；吴中区、吴江区、苏州高新区、昆山市、太仓市、御窑社区、常熟；云龙区、鼓楼区、泉山区、开发区、丰县、沛县、铜山区、睢宁县、邳州市、新沂市、贾汪区(全徐州市)")
                .setDetailUrl("http://5b0988e595225.cdn.sohucs.com/images/20200508/20d9910f8852496ba7d439b5a0ffa69f.jpeg")
                .setImageUrl("http://5b0988e595225.cdn.sohucs.com/images/20200508/20d9910f8852496ba7d439b5a0ffa69f.jpeg"));//褐边绿刺蛾
        list.add(new NewInfo("昆虫信息", "黄刺蛾")
                .setSummary("目：鳞翅目 \n 科：刺蛾科 \n 属：黄刺蛾属 \n 名称：黄刺蛾 \n 虫害代码：C22301070005 \n 拉丁学名：Cnidocampa flavescens（Walker） \n 栖息地： \n 杨、柿、桃、李、杏、桑、枣、梨、柳、榆、青桐、枫杨、枇杷、乌桕、樱桃、山楂、刺槐、梧桐、板栗、苦楝、苹果、石榴、核桃、五角枫、悬铃木重阳木、三角枫、大叶黄杨 \n 分布区域： \n 金湖县；赣榆区；如皋；泰兴；宿迁泗阳、宿豫区；江都区、扬州市开发区、瘦西湖；吴中区、太仓市、御窑；云龙区、鼓楼区、泉山区、开发区、丰县、沛县、铜山区、睢宁县、邳州市、新沂市、贾汪区（全徐州市）")
                .setDetailUrl("https://ss2.meipian.me/users/45497697/89d934781cb54c5a9b7ac66ea62b0bab.jpg?imageView2/2/w/750/h/1400/q/80")
                .setImageUrl("https://ss2.meipian.me/users/45497697/89d934781cb54c5a9b7ac66ea62b0bab.jpg?imageView2/2/w/750/h/1400/q/80"));//黄刺蛾
        list.add(new NewInfo("昆虫信息", "美国白蛾")
                .setSummary("目：鳞翅目 \n 科：灯蛾科 \n 属：白蛾属 \n 名称：美国白蛾 \n 虫害代码：C22345105005 \n 拉丁学名：Hyphantria cunea (Drury) \n 栖息地： \n 杨、柳、桑、柿、榆、桃、白蜡、构树、木槿、火炬树、君迁子、泡桐、苹果、马褂木、芦苇、大叶黄杨 \n 分布区域： \n 金湖县、青浦区；盐都、大丰；江宁区、浦口区；宿迁泗阳、沭阳、宿城区、泗洪、宿豫区；盐都区、射阳、阜宁、建湖、响水、亭湖区；江都区、宝应县；云龙区、鼓楼区、泉山区、开发区、丰县、沛县、铜山区、睢宁县、邳州市、新沂市、贾汪区（全徐州市）")
                .setDetailUrl("http://www.linhaizhibao.com/pic/news/20170725110354995.jpg")
                .setImageUrl("http://www.linhaizhibao.com/pic/news/20170725110354995.jpg"));//美国白蛾
        list.add(new NewInfo("昆虫信息", "人纹污灯蛾")
                .setSummary("目：鳞翅目 \n 科：灯蛾科 \n 属：污灯蛾属 \n 名称：人纹污灯蛾 \n 虫害代码：C22345170045 \n 拉丁学名：Spilarctia subcarnea (Walker) \n 栖息地： \n 桑、木槿、杨、榆、槐、蔷薇、月季、碧桃、十字花科蔬菜、豆类等 \n 分布区域： \n 金湖县；灌南、连云区；浦口区；如皋；泰兴；盐都区、射阳、建湖；宝应县；镇江市；常熟、渭南村；开发区、丰县、沛县*、铜山区、睢宁县")
                .setDetailUrl("http://qnsunong.365sn.cn/5731a28773fb0.jpg")
                .setImageUrl("http://qnsunong.365sn.cn/5731a28773fb0.jpg"));//人纹污灯蛾
        list.add(new NewInfo("昆虫信息", "丝带凤蝶")
                .setSummary("目：鳞翅目 \n 科：凤蝶科 \n 属：丝带凤蝶属 \n 名称：丝带凤蝶 \n 虫害代码：C22359050005 \n 拉丁学名：Sericinus montelus Grey \n 栖息地： \n 马兜铃、青木香 \n 分布区域： \n 宜兴；赣榆区、连云区；六合区、溧水区；姜堰；响水；江都区；镇江市；常熟；徐州云龙区、鼓楼区、泉山区、开发区、沛县*、铜山区、睢宁县、新沂市、贾汪区")
                .setDetailUrl("https://ss2.meipian.me/users/657902/97e9ce25557f46ef9f8414f844f586be.jpg?imageView2/2/w/750/h/1400/q/80")
                .setImageUrl("https://ss2.meipian.me/users/657902/97e9ce25557f46ef9f8414f844f586be.jpg?imageView2/2/w/750/h/1400/q/80"));//丝带凤蝶
        list.add(new NewInfo("昆虫信息", "霜天蛾")
                .setSummary("目：鳞翅目 \n 科：天蛾科 \n 属：霜天蛾属 \n 名称：霜天蛾 \n 虫害代码：C22341165010 \n 拉丁学名：Psilogramma menephron(Gramer.) \n 栖息地： \n 女贞、柳、泡桐、梧桐、丁香、樟树、桂花、楸树、苦楝、牡荆、白蜡、悬铃木、栀子花、金叶女贞等 \n 分布区域： \n 连云区；高淳区、建邺区、鼓楼区、浦口区、六合区；泰兴；泗阳县；射阳、阜宁、东台；江都区、宝应县、邗江区、仪征市；徐州云龙区、开发区、丰县、沛县*、铜山区、睢宁县、新沂市、贾汪区")
                .setDetailUrl("https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/baike/pic/item/10dfa9ec8a1363274b9e0bde978fa0ec09fac7e8.jpg")
                .setImageUrl("https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/baike/pic/item/10dfa9ec8a1363274b9e0bde978fa0ec09fac7e8.jpg"));//霜天蛾
        list.add(new NewInfo("昆虫信息", "杨扇舟蛾")
                .setSummary("目：鳞翅目 \n 科：舟蛾科 \n 属：扇舟蛾属 \n 名称：杨扇舟蛾 \n 虫害代码：C22342015005 \n 拉丁学名：Clostera anachoreta (Denis et Schiffermüller, 1775) \n 栖息地： \n 杨、柳 \n 分布区域： \n 金湖县；如皋；泰兴、靖江；江都区；徐州云龙区、鼓楼区、泉山区、开发区、丰县、沛县、铜山区、睢宁县、邳州市、新沂市、贾汪区(全市)")
                .setDetailUrl("http://img.blog.163.com/photo/atEM2k5JFmqHSgeVyDRclQ==/314126074009491797.jpg")
                .setImageUrl("http://img.blog.163.com/photo/atEM2k5JFmqHSgeVyDRclQ==/314126074009491797.jpg"));//杨扇舟蛾
        list.add(new NewInfo("昆虫信息", "杨小舟蛾")
                .setSummary("目：鳞翅目 \n 科：舟蛾科 \n 属：拟皮舟蛾属 \n 名称：杨小舟蛾 \n 虫害代码：C22342135005 \n 拉丁学名：Micromelalopha troglodyta (Graeser) \n 栖息地： \n 杨、柳 \n 分布区域： \n 金湖县；如皋；泰兴、靖江；建湖、大丰；广陵区；徐州云龙区、鼓楼区、泉山区、开发区、丰县、沛县、铜山区、睢宁县、邳州市、新沂市、贾汪区(全市)")
                .setDetailUrl("http://pics1.baidu.com/feed/902397dda144ad3477c4b41e4bff92f230ad8597.jpeg?token=c14b4b3240caaa5260e598fc69a2063d")
                .setImageUrl("http://pics1.baidu.com/feed/902397dda144ad3477c4b41e4bff92f230ad8597.jpeg?token=c14b4b3240caaa5260e598fc69a2063d"));//杨小舟蛾
        list.add(new NewInfo("昆虫信息", "日本脊吉丁")
                .setSummary("目：鞘翅目 \n 科：吉丁甲科 \n 属：脊吉丁属 \n 名称：日本脊吉丁 \n 虫害代码：C21301095005 \n 拉丁学名：Chalcophora japonica(Gory) \n 栖息地： \n   \n 分布区域： \n 宜兴")
                .setDetailUrl("https://iknow-pic.cdn.bcebos.com/3b87e950352ac65c7336a872f9f2b21193138a84?x-bce-process%3Dimage%2Fresize%2Cm_lfit%2Cw_600%2Ch_800%2Climit_1%2Fquality%2Cq_85%2Fformat%2Cf_jpg")
                .setImageUrl("https://iknow-pic.cdn.bcebos.com/3b87e950352ac65c7336a872f9f2b21193138a84?x-bce-process%3Dimage%2Fresize%2Cm_lfit%2Cw_600%2Ch_800%2Climit_1%2Fquality%2Cq_85%2Fformat%2Cf_jpg"));//日本脊吉丁
        list.add(new NewInfo("昆虫信息", "桑天牛")
                .setSummary("目：鞘翅目 \n 科：天牛科 \n 属：粒肩天牛属 \n 名称：桑天牛 \n 虫害代码：C21701080005 \n 拉丁学名：Apriona germari(Hope) \n 栖息地： \n 桑树、构树，杨、柳、柘树 \n 分布区域： \n 金湖县；灌云、连云区；浦口区、江宁区、六合区；海门、如皋；泰兴；泗阳县、泗洪、宿豫区；建湖、东台、阜宁、盐都；邗江区、仪征市；镇江市；吴江区、太仓市、昆山市、吴中区、苏州高新区；徐州：云龙区、鼓楼区、泉山区、开发区、丰县、沛县、铜山区、睢宁县、邳州市、新沂市、贾汪区(全市)")
                .setDetailUrl("http://n1.itc.cn/img8/wb/recom/2016/08/01/147001086227864194.JPEG")
                .setImageUrl("http://n1.itc.cn/img8/wb/recom/2016/08/01/147001086227864194.JPEG"));//桑天牛
        list.add(new NewInfo("昆虫信息", "松墨天牛")
                .setSummary("目：鞘翅目 \n 科：天牛科 \n 属：墨天牛属 \n 名称：松墨天牛 \n 虫害代码：C21701445005 \n 拉丁学名：Monochamus alternatus Hope, 1842 \n 栖息地： \n 马尾松 \n 分布区域： \n 宜兴；建邺区；赣榆区、连云区；泰兴；吴中区")
                .setDetailUrl("https://inews.gtimg.com/newsapp_bt/0/13598469166/1000")
                .setImageUrl("https://inews.gtimg.com/newsapp_bt/0/13598469166/1000"));//松墨天牛
        list.add(new NewInfo("昆虫信息", "星天牛")
                .setSummary("目：鞘翅目 \n 科：天牛科 \n 属：星天牛属 \n 名称：星天牛 \n 虫害代码：C21701065010 \n 拉丁学名：Anoplophora chinensis Forster,1771 \n 栖息地： \n 杨、柳、桑、榆、法桐、刺槐 \n 分布区域： \n 滨湖区、宜兴；常州市；金湖县；灌云、连云区；浦口区、玄武区、雨花区、江宁区、溧水区、鼓楼区、六合区；如皋；靖江、泰兴；泗阳县、沭阳、泗洪、宿豫区；盐都区、射阳、大丰、东台；镇江市；高新区、张家港市、车渡村、太仓市、昆山市、常熟市、吴江、吴中区；徐州：云龙区、鼓楼区、泉山区、开发区、丰县、沛县、铜山区、睢宁县、邳州市、新沂市、贾汪区(全市)")
                .setDetailUrl("http://www.yanyuancn.com/UserFiles/News/image/20180619/20180619104651_0055.jpg")
                .setImageUrl("http://www.yanyuancn.com/UserFiles/News/image/20180619/20180619104651_0055.jpg"));//星天牛
        list.add(new NewInfo("昆虫信息", "柳蓝叶甲")
                .setSummary("目：鞘翅目 \n 科：叶甲科 \n 属：圆叶甲属 \n 名称：柳蓝叶甲 \n 虫害代码：C21703280010 \n 拉丁学名：plagiodera versicolora  \n 栖息地： \n 垂柳、杨树，旱柳、桑 \n 分布区域： \n 金湖县；灌南县；江宁区；海门；姜堰、靖江；宿迁泗阳、沭阳、宿城区、宿豫区；盐都区、阜宁、东台、大丰、建湖；高邮县、宝应县、广陵区、江都区、扬州市开发区、瘦西湖；镇江市；徐州：云龙区、鼓楼区、泉山区、开发区、丰县、沛县、铜山区、睢宁县、邳州市、新沂市、贾汪区")
                .setDetailUrl("https://iknow-pic.cdn.bcebos.com/023b5bb5c9ea15ce2dd1e661bc003af33a87b29e?x-bce-process%3Dimage%2Fresize%2Cm_lfit%2Cw_600%2Ch_800%2Climit_1%2Fquality%2Cq_85%2Fformat%2Cf_jpg")
                .setImageUrl("https://iknow-pic.cdn.bcebos.com/023b5bb5c9ea15ce2dd1e661bc003af33a87b29e?x-bce-process%3Dimage%2Fresize%2Cm_lfit%2Cw_600%2Ch_800%2Climit_1%2Fquality%2Cq_85%2Fformat%2Cf_jpg"));//柳蓝叶甲
        return list;
    }

    public static List<AdapterItem> getGridItems(Context context) {
        return getGridItems(context, R.array.grid_titles_entry, R.array.grid_icons_entry);
    }


    private static List<AdapterItem> getGridItems(Context context, int titleArrayId, int iconArrayId) {
        List<AdapterItem> list = new ArrayList<>();
        String[] titles = ResUtils.getStringArray(titleArrayId);
        Drawable[] icons = ResUtils.getDrawableArray(context, iconArrayId);
        for (int i = 0; i < titles.length; i++) {
            list.add(new AdapterItem(titles[i], icons[i]));
        }
        return list;
    }

    /**
     * 用于占位的空信息
     *
     * @return
     */
    @MemoryCache
    public static List<NewInfo> getEmptyNewInfo() {
        List<NewInfo> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new NewInfo());
        }
        return list;
    }

}
