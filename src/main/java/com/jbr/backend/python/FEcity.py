province=[
      "北京","上海","天津","重庆",
      "安徽", "福建", "广东", "广西", "贵州",
      "甘肃", "海南", "河南","黑龙江","湖北",
      "湖南", "河北", "江苏", "江西", "吉林",
      "辽宁", "宁夏","内蒙古","青海", "山东",
      "山西", "陕西", "四川", "新疆", "西藏",
      "云南", "浙江", "其他", "海外"
    ];
cityList={
      "北京":{"北京":"bj"},
      "上海":{"上海":"sh"},
      "天津":{"天津":"tj"},
      "重庆":{"重庆":"cq"},
      "安徽":{
        "合肥":"hf","芜湖":"wuhu","蚌埠":"bengbu","阜阳":"fy","淮南":"hn",
        "安庆":"anqing","宿州":"suzhou","六安":"la","淮北":"huaibei","滁州":"chuzhou",
        "马鞍山":"mas","铜陵":"tongling","宣城":"xuancheng","亳州":"bozhou","黄山":"huangshan",
        "池州":"chizhou","巢湖":"ch","和县":"hexian","霍邱":"hq","桐城":"tongcheng",
        "宁国":"ningguo","天长":"tianchang","东至":"dongzhi","无为":"wuweixian"
      },
      "福建":{
        "福州":"fz","厦门":"xm","泉州":"qz","莆田":"pt","漳州":"zhangzhou0",
        "宁德":"nd","三明":"sm","南平":"np","龙岩":"ly","武夷山":"wuyishan",
        "石狮":"shishi","晋江":"jinjiangshi","南安":"nananshi","龙海":"longhai","上杭":"shanghangxian",
        "福安":"fuanshi","福鼎":"fudingshi","安溪":"anxixian","永春":"yongchunxian","永安":"yongan",
        "漳浦":"zhangpu"
      },
      "广东":{
        "深圳":"sz","广州":"gz","东莞":"dg","佛山":"fs","中山":"zs",
        "珠海":"zh","惠州":"huizhou","江门":"jm","汕头":"st","湛江":"zhanjiang",
        "肇庆":"zq","茂名":"mm","揭阳":"jy","梅州":"mz","清远":"qingyuan",
        "阳江":"yj","韶关":"sg","河源":"heyuan","云浮":"yf","汕尾":"sw",
        "潮州":"chaozhou","台山":"taishan","阳春":"yangchun","顺德":"sd","惠东":"huidong",
        "博罗":"boluo","海丰":"haifengxian","开平":"kaipingshi","陆丰":"lufengshi"
      },
      "广西":{
        "南宁":"nn","柳州":"liuzhou","桂林":"gl","玉林":"yulin","梧州":"wuzhou",
        "北海":"bh","贵港":"gg","钦州":"qinzhou","百色":"baise","河池":"hc",
        "来宾":"lb","贺州":"hezhou","防城港":"fcg","崇左":"chongzuo","桂平":"guipingqu",
        "北流":"beiliushi","博白":"bobaixian","岑溪":"cenxi"
      },
      "贵州":{
        "贵阳":"gy","遵义":"zunyi","黔东南":"qdn","黔南":"qn","六盘水":"lps",
        "毕节":"bijie","铜仁":"tr","安顺":"anshun","黔西南":"qxn","仁怀":"renhuaishi",
        "清镇":"qingzhen"
      },
      "甘肃":{
        "兰州":"lz","天水":"tianshui","白银":"by","庆阳":"qingyang","平凉":"pl",
        "酒泉":"jq","张掖":"zhangye","武威":"wuwei","定西":"dx","金昌":"jinchang",
        "陇南":"ln","临夏":"linxia","嘉峪关":"jyg","甘南":"gn","敦煌":"dunhuang"
      },
      "海南":{
        "海口":"haikou","三亚":"sanya","五指山":"wzs","三沙":"sansha","琼海":"qh",
        "文昌":"wenchang","万宁":"wanning","屯昌":"tunchang","琼中":"qiongzhong","陵水":"lingshui",
        "东方":"df","定安":"da","澄迈":"cm","保亭":"baoting","白沙":"baish","儋州":"danzhou"
      },
      "河南":{
        "郑州":"zz","洛阳":"luoyang","新乡":"xx","南阳":"ny","许昌":"xc",
        "平顶山":"pds","安阳":"ay","焦作":"jiaozuo","商丘":"sq","开封":"kaifeng",
        "濮阳":"puyang","周口":"zk","信阳":"xy","驻马店":"zmd|","漯河":"luohe",
        "三门峡":"smx","鹤壁":"hb","济源":"jiyuan","明港":"mg|","鄢陵":"yanling",
        "禹州":"yuzhou","长葛":"changge","灵宝":"lingbaoshi","杞县":"qixianqu","汝州":"ruzhou",
        "项城":"xiangchengshi","偃师":"yanshiqu","长垣":"changyuan","滑县":"huaxian","林州":"linzhou",
        "沁阳":"qinyang","孟州":"mengzhou","温县":"wenxian","尉氏":"weishixian","兰考":"lankaoxian",
        "通许":"tongxuxian","新安":"lyxinan","伊川":"yichuan","孟津":"mengjinqu","宜阳":"lyyiyang",
        "舞钢":"wugang","永城":"yongcheng","睢县":"suixian","鹿邑":"luyi","渑池":"yingchixian",
        "沈丘":"shenqiu","太康":"taikang","商水":"shangshui","淇县":"qixianq","浚县":"junxian",
        "范县":"fanxian","固始":"gushixian","淮滨":"huaibinxian","邓州":"dengzhou","新野":"xinye"
      },
      "黑龙江":{
        "哈尔滨":"hrb","大庆":"dq","齐齐哈尔":"qqhr","牡丹江":"mdj","绥化":"suihua",
        "佳木斯":"jms","鸡西":"jixi","双鸭山":"sys","鹤岗":"hegang","黑河":"heihe",
        "伊春":"yich","七台河":"qth","大兴安岭":"dxal","安达":"shanda","肇东":"shzhaodong",
        "肇州":"zhaozhou"
      },
      "湖北":{
        "武汉":"wh","宜昌":"yc","襄阳":"xf","荆州":"jingzhou","十堰":"shiyan",
        "黄石":"hshi","孝感":"xiaogan","黄冈":"hg","恩施":"es","荆门":"jingmen",
        "咸宁":"xianning","鄂州":"ez","随州":"suizhou","潜江":"qianjiang","天门":"tm",
        "仙桃":"xiantao","神农架":"snj","宜都":"yidou","汉川":"hanchuan","枣阳":"zaoyang",
        "武穴":"wuxueshi","钟祥":"zhongxiangshi","京山":"jingshanxian","沙洋":"shayangxian","松滋":"songzi",
        "广水":"guangshuishi","赤壁":"chibishi","老河口":"laohekou","谷城":"gucheng","宜城":"yichengshi",
        "南漳":"nanzhang","云梦":"yunmeng","安陆":"anlu","大悟":"dawu","孝昌":"xiaochang",
        "当阳":"dangyang","枝江":"zhijiang","嘉鱼":"jiayuxian","随县":"suixia"
      },
      "湖南":{
        "长沙":"cs","株洲":"zhuzhou","益阳":"yiyang","常德":"changde","衡阳":"hy",
        "湘潭":"xiangtan","岳阳":"yy","郴州":"chenzhou","邵阳":"shaoyang","怀化":"hh",
        "永州":"yongzhou","娄底":"ld","湘西":"xiangxi","张家界":"zjj","醴陵":"liling",
        "澧县":"lixian","桂阳":"czguiyang","资兴":"zixing","永兴":"yongxing","常宁":"changningshi",
        "祁东":"qidongxian","衡东":"hengdong","冷水江":"lengshuijiangshi","涟源":"lianyuanshi","双峰":"shuangfengxian",
        "邵阳县":"shaoyangxian","邵东":"shaodongxian","沅江":"yuanjiangs","南县":"nanxian","祁阳":"qiyang",
        "湘阴":"xiangyin","华容":"huarong","慈利":"cilixian","攸县":"zzyouxian"
      },
      "河北":{
        "石家庄":"sjz","保定":"bd","唐山":"ts","廊坊":"lf","邯郸":"hd",
        "秦皇岛":"qhd","沧州":"cangzhou","邢台":"xt","衡水":"hs","张家口":"zjk",
        "承德":"chengde","定州":"dingzhou","馆陶":"gt","张北":"zhangbei","赵县":"zx",
        "正定":"zd","迁安市":"qianan","任丘":"renqiu","三河":"sanhe","武安":"wuan",
        "雄安新区":"xionganxinqu","燕郊":"lfyanjiao","涿州":"zhuozhou","河间":"hejian","黄骅":"huanghua",
        "沧县":"cangxian","磁县":"cixian","涉县":"shexian","霸州":"bazhou","香河":"xianghe",
        "固安":"lfguan","遵化市":"zunhua","迁西":"qianxixian","玉田":"yutianxian","滦南":"luannanxian",
        "沙河":"shaheshi"
      },
      "江苏":{
        "苏州":"su","南京":"nj","无锡":"wx","常州":"cz","徐州":"xz",
        "南通":"nt","扬州":"yz","盐城":"yancheng","淮安":"ha","连云港":"lyg",
        "泰州":"taizhou","宿迁":"suqian","镇江":"zj","沭阳":"shuyang","大丰":"dafeng",
        "如皋":"rugao","启东":"qidong","溧阳":"liyang","海门":"haimen","东海":"donghai",
        "扬中":"yangzhong","兴化":"xinghuashi","新沂":"xinyishi","泰兴":"taixing","如东":"rudong",
        "邳州":"pizhou","沛县":"xzpeixian","靖江":"jingjiang","建湖":"jianhu","海安":"haian",
        "东台":"dongtai","丹阳":"danyang","宝应县":"baoyingx","灌南":"guannan","灌云":"guanyun",
        "姜堰":"jiangyan","金坛":"jintan","昆山":"szkunshan","泗洪":"sihong","泗阳":"siyang",
        "句容":"jurong","射阳":"sheyang","阜宁":"funingxian","响水":"xiangshui","盱眙":"xuyi",
        "金湖":"jinhu"
      },
      "江西":{
        "南昌":"nc","赣州":"ganzhou","九江":"jj","宜春":"yichun","吉安":"ja",
        "上饶":"sr","萍乡":"px","抚州":"fuzhou","景德镇":"jdz","新余":"xinyu",
        "鹰潭":"yingtan","永新":"yxx","乐平":"lepingshi","进贤":"jinxian","分宜":"fenyi",
        "丰城":"fengchengshi","樟树":"zhangshu","高安":"gaoan","余江":"yujiang","南城":"nanchengx",
        "浮梁":"fuliangxian"
      },
      "吉林":{
        "长春":"cc","吉林":"jl","四平":"sp","延边":"yanbian","松原":"songyuan",
        "白城":"bc","通化":"th","白山":"baishan","辽源":"liaoyuan","公主岭":"gongzhuling",
        "梅河口":"meihekou","扶余":"fuyuxian","长岭":"changlingxian","桦甸":"huadian","磐石":"panshi",
        "梨树县":"lishu"
      },
      "辽宁":{
        "沈阳":"sy","大连":"dl","鞍山":"as","锦州":"jinzhou","抚顺":"fushun",
        "营口":"yk","盘锦":"pj","朝阳":"cy","丹东":"dandong","辽阳":"liaoyang",
        "本溪":"benxi","葫芦岛":"hld","铁岭":"tl","阜新":"fx","庄河":"pld",
        "瓦房店":"wfd","灯塔":"dengta","凤城":"fengcheng","北票":"beipiao","开原":"kaiyuan"
      },
      "宁夏":{
        "银川":"yinchuan","吴忠":"wuzhong","石嘴山":"szs","中卫":"zw","固原":"guyuan"
      },
      "内蒙古":{
        "呼和浩特":"hu","包头":"bt","赤峰":"chifeng","鄂尔多斯":"erds","通辽":"tongliao",
        "呼伦贝尔":"hlbe","巴彦淖尔市":"bycem","乌兰察布":"wlcb","锡林郭勒":"xl","兴安盟":"xam",
        "乌海":"wuhai","阿拉善盟":"alsm","海拉尔":"hlr"
      },
      "青海":{
        "西宁":"xn","海西":"hx","海北":"haibei","果洛":"guoluo","海东":"haidong",
        "黄南":"huangnan","玉树":"ys","海南":"hainan","格尔木":"geermushi"
      },
      "山东":{
        "青岛":"qd","济南":"jn","烟台":"yt","潍坊":"wf","临沂":"linyi",
        "淄博":"zb","济宁":"jining","泰安":"ta","聊城":"lc","威海":"weihai",
        "枣庄":"zaozhuang","德州":"dz","日照":"rizhao","东营":"dy","菏泽":"heze",
        "滨州":"bz","莱芜":"lw","章丘":"zhangqiu","垦利":"kl","诸城":"zc",
        "寿光":"shouguang","龙口":"longkou","曹县":"caoxian","单县":"shanxian","肥城":"feicheng",
        "高密":"gaomi","广饶":"guangrao","桓台":"huantaixian","莒县":"juxian","莱州":"laizhou",
        "蓬莱":"penglai","青州":"qingzhou","荣成":"rongcheng","乳山":"rushan","滕州":"tengzhou",
        "新泰":"xintai","招远":"zhaoyuan","邹城":"zoucheng","邹平":"zouping","临清":"linqing",
        "茌平":"chiping","郓城":"hzyc","博兴":"boxing","东明":"dongming","巨野":"juye",
        "无棣":"wudi","齐河":"qihe","微山":"weishan","禹城":"yuchengshi","临邑":"linyixianq",
        "乐陵":"leling","莱阳":"laiyang","宁津":"ningjin","高唐":"gaotang","莘县":"shenxian",
        "阳谷":"yanggu","冠县":"guanxian","平邑":"pingyi","郯城":"tancheng","沂源":"yiyuanxian",
        "汶上":"wenshang","梁山":"liangshanx","利津":"lijin","沂南":"yinanxian","栖霞":"qixia",
        "宁阳":"ningyang","东平":"dongping","昌邑":"changyishi","安丘":"anqiu","昌乐":"changle",
        "临朐":"linqu","鄄城":"juancheng"
      },
      "山西":{
        "太原":"ty","临汾":"linfen","大同":"dt","运城":"yuncheng","晋中":"jz",
        "长治":"changzhi","晋城":"jincheng","阳泉":"yq","吕梁":"lvliang","忻州":"xinzhou",
        "朔州":"shuozhou","临猗":"linyixian","清徐":"qingxu","柳林":"liulin","高平":"gaoping",
        "泽州":"zezhou","襄垣":"xiangyuanxian","孝义":"xiaoyi"
      },
      "陕西":{
        "西安":"xa","咸阳":"xianyang","宝鸡":"baoji","渭南":"wn","汉中":"hanzhong",
        "榆林":"yl","延安":"yanan","安康":"ankang","商洛":"sl","铜川":"tc",
        "神木":"shenmu","韩城":"hancheng","府谷":"fugu","靖边":"jingbian","定边":"dingbian"
      },
      "四川":{
        "成都":"cd","绵阳":"mianyang","德阳":"deyang","南充":"nanchong","宜宾":"yb",
        "自贡":"zg","乐山":"ls","泸州":"luzhou","达州":"dazhou","内江":"scnj",
        "遂宁":"suining","攀枝花":"panzhihua","眉山":"ms","广安":"ga","资阳":"zy",
        "凉山":"liangshan","广元":"guangyuan","雅安":"ya","巴中":"bazhong","阿坝":"ab",
        "甘孜":"ganzi","安岳":"anyuexian","广汉":"guanghanshi","简阳":"jianyangshi","仁寿":"renshouxian",
        "射洪":"shehongxian","大竹":"dazu","宣汉":"xuanhan","渠县":"qux","长宁":"changningx"
      },
      "新疆":{
        "乌鲁木齐":"xj","昌吉":"changji","巴音郭楞":"bygl","伊犁":"yili","阿克苏":"aks",
        "喀什":"ks","哈密":"hami","克拉玛依":"klmy","博尔塔拉":"betl","吐鲁番":"tlf",
        "和田":"ht","石河子":"shz","克孜勒苏":"kzls","阿拉尔":"ale","五家渠":"wjq",
        "图木舒克":"tmsk","库尔勒":"kel","阿勒泰":"alt","塔城":"tac"
      },
      "西藏":{
        "拉萨":"lasa","日喀则":"rkz","山南":"sn","林芝":"linzhi","昌都":"changdu",
        "那曲":"nq","阿里":"al","日土":"rituxian","改则":"gaizexian"
      },
      "云南":{
        "昆明":"km","曲靖":"qj","大理":"dali","红河":"honghe","玉溪":"yx",
        "丽江":"lj","文山":"ws","楚雄":"cx","西双版纳":"bn","昭通":"zt",
        "德宏":"dh","普洱":"pe","保山":"bs","临沧":"lincang","迪庆":"diqing",
        "怒江":"nujiang","弥勒":"milexian","安宁":"anningshi","宣威":"xuanwushi"
      },
      "浙江":{
        "杭州":"hz","宁波":"nb","温州":"wz","金华":"jh","嘉兴":"jx",
        "台州":"tz","绍兴":"sx","湖州":"huzhou","丽水":"lishui","衢州":"quzhou",
        "舟山":"zhoushan","乐清":"yueqingcity","瑞安":"ruiancity","义乌":"yiwu","余姚":"yuyao",
        "诸暨":"zhuji","象山":"xiangshanxian","温岭":"wenling","桐乡":"tongxiang","慈溪":"cixi",
        "长兴":"changxing","嘉善":"jiashanx","海宁":"haining","德清":"deqing","东阳":"dongyang",
        "安吉":"anji","苍南":"cangnanxian","临海":"linhai","永康":"yongkang","玉环":"yuhuan",
        "平湖":"pinghushi","海盐":"haiyan","武义县":"wuyix","嵊州":"shengzhou","新昌":"xinchang",
        "江山":"jiangshanshi","平阳":"pingyangxian"
      },
      "其他":{
        "香港":"hk","澳门":"am","台湾":"tw","全国":"quanguo","其他":"cn"
      },
      "海外":{
        "洛杉矶":"gllosangeles","旧金山":"glsanfrancisco","纽约":"glnewyork","多伦多":"gltoronto","温哥华":"glvancouver",
        "伦敦":"glgreaterlondon","莫斯科":"glmoscow","首尔":"glseoul","东京":"gltokyo","新加坡":"glsingapore",
        "曼谷":"glbangkok","清迈":"glchiangmai","迪拜":"gldubai","奥克兰":"glauckland","悉尼":"glsydney",
        "墨尔本":"glmelbourne","其他海外城市":"city"
      }
    }

careerTotal={
        '餐饮': 'zplvyoujiudian', '家政保洁/安保': 'jiazhengbaojiexin', '美容/美发': 'meirongjianshen',
        '旅游': 'zpjiudian', '娱乐/休闲': 'zpwentiyingshi', '保健按摩': 'zpanmo',
        '运动健身': 'zpjianshen', '人事/行政/后勤': 'renli', '司机': 'siji',
        '高级管理': 'zpguanli', '销售': 'yewu', '客服': 'kefu',
        '贸易/采购': 'zpshangwumaoyi', '超市/百货/零售': 'chaoshishangye', '淘宝职位': 'zptaobao',
        '房产中介': 'zpfangchan', '酒店': 'jiudianzp', '市场/媒介/公关': 'shichang',
        '广告/会展/咨询': 'zpguanggao', '美术/设计/创意': 'zpmeishu', '普工/技工': 'zpshengchankaifa',
        '生产管理/研发': 'zpshengchan', '物流/仓储': 'zpwuliucangchu', '服装/纺织/食品': 'xiaofeipin',
        '质控/安防': 'zhikonganfang', '汽车制造/服务': 'zpqiche', '计算机/互联网/通信': 'tech',
        '电子/电气': 'zpjixieyiqi', '机械/仪器仪表': 'zpjixie', '法律': 'zpfalvzixun',
        '教育培训': 'zhuanye', '翻译': 'fanyizhaopin', '编辑/出版/印刷': 'zpxiezuochuban',
        '职业培训': 'zpzhiyepeixun', '财务/审计/统计': 'zpcaiwushenji', '金融/银行/证券/投资': 'jinrongtouzi',
        '保险': 'zpjinrongbaoxian', '医院/医疗/护理': 'zpyiyuanyiliao', '制药/生物工程': 'zpzhiyao',
        '环保': 'huanbao', '建筑': 'zpfangchanjianzhu', '物业管理': 'zpwuye',
        '农/林/牧/渔业': 'nonglinmuyu', '其他招聘信息': 'zhaopin', '招聘会': 'zhaopinhui'
}

career={'职业培训': 'zpzhiyepeixun', '财务/审计/统计': 'zpcaiwushenji', '金融/银行/证券/投资': 'jinrongtouzi',
        '保险': 'zpjinrongbaoxian', '医院/医疗/护理': 'zpyiyuanyiliao', '制药/生物工程': 'zpzhiyao',
        '环保': 'huanbao', '建筑': 'zpfangchanjianzhu', '物业管理': 'zpwuye',
        '农/林/牧/渔业': 'nonglinmuyu', '其他招聘信息': 'zhaopin', '招聘会': 'zhaopinhui'}