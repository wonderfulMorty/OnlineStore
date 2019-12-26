/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : db_online_store

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2019-12-24 14:13:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_administrator
-- ----------------------------
DROP TABLE IF EXISTS `t_administrator`;
CREATE TABLE `t_administrator` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员编号',
  `account` varchar(20) NOT NULL COMMENT '管理员账号',
  `password` varchar(64) NOT NULL COMMENT '管理员密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_administrator
-- ----------------------------
INSERT INTO `t_administrator` VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e');

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类别编号',
  `name` varchar(20) NOT NULL COMMENT '类别名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES ('1', '手机数码');
INSERT INTO `t_category` VALUES ('2', '电脑办公');
INSERT INTO `t_category` VALUES ('3', '运动户外');
INSERT INTO `t_category` VALUES ('4', '家具家居');
INSERT INTO `t_category` VALUES ('6', '鞋靴类');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` varchar(32) NOT NULL COMMENT '订单号',
  `user_id` int(11) NOT NULL COMMENT '用户编号',
  `order_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '下单时间',
  `total` decimal(10,2) NOT NULL COMMENT '金额',
  `state` int(1) NOT NULL COMMENT '订单状态；0-未付款，1-已付款，2-已发货，3-已完成',
  `name` varchar(20) DEFAULT NULL COMMENT '收货人姓名',
  `telephone` varchar(20) DEFAULT NULL COMMENT '收货人手机号',
  `address` text COMMENT '收货人地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('106791734320191223122035', '2', '2019-12-23 23:05:28', '1190.00', '3', 'sasas', 'dadad', 'aasa');
INSERT INTO `t_order` VALUES ('122002677720191223164638', '2', '2019-12-23 22:58:26', '2299.00', '1', 'sas', 'sas', 'sasa');
INSERT INTO `t_order` VALUES ('68523410220191224104242', '4', '2019-12-24 10:42:50', '4087.00', '0', 'wqwq', 'wqwq', 'wqw');

-- ----------------------------
-- Table structure for t_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_order_detail`;
CREATE TABLE `t_order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单项编号',
  `order_id` varchar(32) NOT NULL COMMENT '订单号',
  `product_id` int(11) NOT NULL COMMENT '商品编号',
  `count` int(11) NOT NULL COMMENT '商品购买数量',
  `subtotal` decimal(10,2) NOT NULL COMMENT '小计',
  PRIMARY KEY (`id`),
  KEY `fk_order_id` (`order_id`),
  KEY `fk_product_id` (`product_id`),
  CONSTRAINT `fk_order_id` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_product_id` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_detail
-- ----------------------------
INSERT INTO `t_order_detail` VALUES ('32', '106791734320191223122035', '8', '1', '1190.00');
INSERT INTO `t_order_detail` VALUES ('33', '122002677720191223164638', '31', '1', '2299.00');
INSERT INTO `t_order_detail` VALUES ('34', '68523410220191224104242', '16', '1', '4087.00');

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品编号',
  `category_id` int(11) NOT NULL COMMENT '类别编号',
  `product_name` varchar(100) NOT NULL COMMENT '商品名称',
  `market_price` decimal(10,2) NOT NULL COMMENT '市场价',
  `mall_price` decimal(10,2) NOT NULL COMMENT '商城价',
  `image` varchar(255) NOT NULL COMMENT '商品图片',
  `description` text NOT NULL COMMENT '商品描述',
  `shelf_time` date NOT NULL COMMENT '上架时间',
  `is_hot` int(1) NOT NULL COMMENT '是否热门；0-否，1-是',
  `is_down` int(1) NOT NULL COMMENT '是否下架；0-否，1-是',
  `stock` int(11) NOT NULL COMMENT '库存',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_product
-- ----------------------------
INSERT INTO `t_product` VALUES ('1', '1', '小米 4c 标准版', '1399.00', '1299.00', 'Resource/products/1/c_0001.jpg', '小米 4c 标准版 全网通 白色 移动联通电信4G手机 双卡双待', '2015-11-02', '1', '1', '10');
INSERT INTO `t_product` VALUES ('2', '1', '中兴 AXON', '2899.00', '2699.00', 'Resource/products/1/c_0002.jpg', '中兴 AXON 天机 mini 压力屏版 B2015 华尔金 移动联通电信4G 双卡双待', '2015-11-05', '1', '0', '20');
INSERT INTO `t_product` VALUES ('3', '1', '华为荣耀6', '1599.00', '1499.00', 'Resource/products/1/c_0003.jpg', '荣耀 6 (H60-L01) 3GB内存标准版 黑色 移动4G手机', '2015-11-02', '0', '0', '15');
INSERT INTO `t_product` VALUES ('4', '1', '联想 P1', '2199.00', '1999.00', 'Resource/products/1/c_0004.jpg', '联想 P1 16G 伯爵金 移动联通4G手机充电5分钟，通话3小时！科技源于超越！品质源于沉淀！5000mAh大电池！高端商务佳配！', '2015-11-02', '0', '0', '30');
INSERT INTO `t_product` VALUES ('5', '1', '摩托罗拉 moto x（x+1）', '1799.00', '1699.00', 'Resource/products/1/c_0005.jpg', '摩托罗拉 moto x（x+1）(XT1085) 32GB 天然竹 全网通4G手机11月11天！MOTO X震撼特惠来袭！1699元！带你玩转黑科技！天然材质，原生流畅系统！', '2015-11-02', '0', '0', '25');
INSERT INTO `t_product` VALUES ('6', '1', '魅族 MX5 16GB 银黑色', '1899.00', '1799.00', 'Resource/products/1/c_0006.jpg', '魅族 MX5 16GB 银黑色 移动联通双4G手机 双卡双待送原厂钢化膜+保护壳+耳机！5.5英寸大屏幕，3G运行内存，2070万+500万像素摄像头！长期省才是真的省！', '2015-11-01', '0', '0', '13');
INSERT INTO `t_product` VALUES ('7', '1', '三星 Galaxy On7', '1499.00', '1398.00', 'Resource/products/1/c_0007.jpg', '三星 Galaxy On7（G6000）昂小七 金色 全网通4G手机 双卡双待新品火爆抢购中！京东尊享千元良机！5.5英寸高清大屏！1300+500W像素！评价赢30元话费券！', '2015-11-14', '0', '0', '33');
INSERT INTO `t_product` VALUES ('8', '1', 'NUU NU5', '1288.00', '1190.00', 'Resource/products/1/c_0008.jpg', 'NUU NU5 16GB 移动联通双4G智能手机 双卡双待 晒单有礼 晨光金香港品牌 2.5D弧度前后钢化玻璃 随机附赠手机套+钢化贴膜 晒单送移动电源+蓝牙耳机', '2015-11-02', '0', '0', '37');
INSERT INTO `t_product` VALUES ('9', '1', '乐视（Letv）乐1pro（X800）', '2399.00', '2299.00', 'Resource/products/1/c_0009.jpg', '乐视（Letv）乐1pro（X800）64GB 金色 移动联通4G手机 双卡双待乐视生态UI+5.5英寸2K屏+高通8核处理器+4GB运行内存+64GB存储+1300万摄像头！', '2015-11-02', '0', '0', '9');
INSERT INTO `t_product` VALUES ('10', '1', '华为 Ascend Mate7', '2699.00', '2599.00', 'Resource/products/1/c_0010.jpg', '华为 Ascend Mate7 月光银 移动4G手机 双卡双待双通6英寸高清大屏，纤薄机身，智能超八核，按压式指纹识别！', '2015-11-02', '1', '0', '19');
INSERT INTO `t_product` VALUES ('11', '1', 'vivo X5Pro', '2399.00', '2298.00', 'Resource/products/1/c_0014.jpg', '移动联通双4G手机 3G运存版 极光白【购机送蓝牙耳机+蓝牙自拍杆】新升级3G运行内存·双2.5D弧面玻璃·眼球识别技术', '2015-11-02', '1', '0', '27');
INSERT INTO `t_product` VALUES ('12', '1', '努比亚（nubia）My 布拉格', '1899.00', '1799.00', 'Resource/products/1/c_0013.jpg', '努比亚（nubia）My 布拉格 银白 移动联通4G手机 双卡双待【嗨11，下单立减100】金属机身，快速充电！布拉格相机全新体验！', '2015-11-02', '0', '0', '39');
INSERT INTO `t_product` VALUES ('13', '1', '华为 麦芒4', '2599.00', '2499.00', 'Resource/products/1/c_0012.jpg', '华为 麦芒4 晨曦金 全网通版4G手机 双卡双待金属机身 2.5D弧面屏 指纹解锁 光学防抖', '2015-11-02', '1', '0', '40');
INSERT INTO `t_product` VALUES ('14', '1', 'vivo X5M', '1899.00', '1799.00', 'Resource/products/1/c_0011.jpg', 'vivo X5M 移动4G手机 双卡双待 香槟金【购机送蓝牙耳机+蓝牙自拍杆】5.0英寸大屏显示·八核双卡双待·Hi-Fi移动KTV', '2015-11-02', '0', '0', '34');
INSERT INTO `t_product` VALUES ('15', '1', 'Apple iPhone 6 (A1586)', '4399.00', '4288.00', 'Resource/products/1/c_0015.jpg', 'Apple iPhone 6 (A1586) 16GB 金色 移动联通电信4G手机长期省才是真的省！点击购机送费版，月月送话费，月月享优惠，畅享4G网络，就在联通4G！', '2015-11-02', '1', '0', '22');
INSERT INTO `t_product` VALUES ('16', '1', '华为 HUAWEI Mate S 臻享版', '4200.00', '4087.00', 'Resource/products/1/c_0016.jpg', '华为 HUAWEI Mate S 臻享版 手机 极昼金 移动联通双4G(高配)满星评价即返30元话费啦；买就送电源+清水套+创意手机支架；优雅弧屏，mate7升级版', '2015-11-03', '0', '0', '16');
INSERT INTO `t_product` VALUES ('17', '1', '索尼(SONY) E6533 Z3+', '4099.00', '3999.00', 'Resource/products/1/c_0017.jpg', '索尼(SONY) E6533 Z3+ 双卡双4G手机 防水防尘 涧湖绿索尼z3专业防水 2070万像素 移动联通双4G', '2015-11-02', '0', '0', '37');
INSERT INTO `t_product` VALUES ('18', '1', 'HTC One M9+', '3599.00', '3499.00', 'Resource/products/1/c_0018.jpg', 'HTC One M9+（M9pw） 金银汇 移动联通双4G手机5.2英寸，8核CPU，指纹识别，UltraPixel超像素前置相机+2000万/200万后置双镜头相机！降价特卖，惊喜不断！', '2015-11-02', '0', '0', '28');
INSERT INTO `t_product` VALUES ('19', '1', 'HTC Desire 826d 32G 臻珠白', '1599.00', '1469.00', 'Resource/products/1/c_0020.jpg', '后置1300万+UltraPixel超像素前置摄像头+【双】前置扬声器+5.5英寸【1080p】大屏！', '2015-11-02', '1', '0', '11');
INSERT INTO `t_product` VALUES ('20', '1', '小米 红米2A 增强版 白色', '649.00', '549.00', 'Resource/products/1/c_0019.jpg', '新增至2GB 内存+16GB容量！4G双卡双待，联芯 4 核 1.5GHz 处理器！', '2015-11-02', '0', '0', '40');
INSERT INTO `t_product` VALUES ('21', '1', '魅族 魅蓝note2 16GB 白色', '1099.00', '999.00', 'Resource/products/1/c_0021.jpg', '现货速抢，抢完即止！5.5英寸1080P分辨率屏幕，64位八核1.3GHz处理器，1300万像素摄像头，双色温双闪光灯！', '2015-11-02', '0', '0', '41');
INSERT INTO `t_product` VALUES ('22', '1', '三星 Galaxy S5 (G9008W) 闪耀白', '2099.00', '1999.00', 'Resource/products/1/c_0022.jpg', '5.1英寸全高清炫丽屏，2.5GHz四核处理器，1600万像素', '2015-11-02', '1', '0', '35');
INSERT INTO `t_product` VALUES ('23', '1', 'sonim XP7700 4G手机', '1799.00', '1699.00', 'Resource/products/1/c_0023.jpg', '三防智能手机 移动/联通双4G 安全 黑黄色 双4G美国军工IP69 30天长待机 3米防水防摔 北斗', '2015-11-09', '1', '0', '41');
INSERT INTO `t_product` VALUES ('24', '1', '努比亚（nubia）Z9精英版 金色', '3988.00', '3888.00', 'Resource/products/1/c_0024.jpg', '移动联通电信4G手机 双卡双待真正的无边框！金色尊贵版！4GB+64GB大内存！', '2015-11-02', '1', '0', '18');
INSERT INTO `t_product` VALUES ('25', '1', 'Apple iPhone 6 Plus (A1524) 16GB 金色', '5188.00', '4988.00', 'Resource/products/1/c_0025.jpg', 'Apple iPhone 6 Plus (A1524) 16GB 金色 移动联通电信4G手机 硬货 硬实力', '2015-11-02', '0', '0', '21');
INSERT INTO `t_product` VALUES ('26', '1', 'Apple iPhone 6s (A1700) 64G 玫瑰金色', '6388.00', '6088.00', 'Resource/products/1/c_0026.jpg', 'Apple iPhone 6 Plus (A1524) 16GB 金色 移动联通电信4G手机 硬货 硬实力', '2015-11-02', '0', '0', '9');
INSERT INTO `t_product` VALUES ('27', '1', '三星 Galaxy Note5（N9200）32G版', '5588.00', '5388.00', 'Resource/products/1/c_0027.jpg', '旗舰机型！5.7英寸大屏，4+32G内存！不一样的SPen更优化的浮窗指令！赠无线充电板！', '2015-11-02', '0', '0', '18');
INSERT INTO `t_product` VALUES ('28', '1', '三星 Galaxy S6 Edge+（G9280）32G版 铂光金', '5999.00', '5888.00', 'Resource/products/1/c_0028.jpg', '赠移动电源+自拍杆+三星OTG金属U盘+无线充电器+透明保护壳', '2015-11-02', '0', '0', '21');
INSERT INTO `t_product` VALUES ('29', '1', 'LG G4（H818）陶瓷白 国际版', '3018.00', '2978.00', 'Resource/products/1/c_0029.jpg', '李敏镐代言，F1.8大光圈1600万后置摄像头，5.5英寸2K屏，3G+32G内存，LG年度旗舰机！', '2015-11-02', '0', '0', '35');
INSERT INTO `t_product` VALUES ('30', '1', '微软(Microsoft) Lumia 640 LTE DS (RM-1113)', '1099.00', '999.00', 'Resource/products/1/c_0030.jpg', '微软首款双网双卡双4G手机，5.0英寸高清大屏，双网双卡双4G！', '2015-11-02', '0', '0', '15');
INSERT INTO `t_product` VALUES ('31', '2', '宏碁（acer）ATC705-N50 台式电脑', '2399.00', '2299.00', 'Resource/products/1/c_0031.jpg', '爆款直降，满千减百，品质宏碁，特惠来袭，何必苦等11.11，早买早便宜！', '2015-11-02', '0', '0', '17');
INSERT INTO `t_product` VALUES ('32', '2', 'Apple MacBook Air MJVE2CH/A 13.3英寸', '6788.00', '6688.00', 'Resource/products/1/c_0032.jpg', '宽屏笔记本电脑 128GB 闪存', '2015-11-02', '0', '0', '23');
INSERT INTO `t_product` VALUES ('33', '2', '联想（ThinkPad） 轻薄系列E450C(20EH0001CD)', '4399.00', '4199.00', 'Resource/products/1/c_0033.jpg', '联想（ThinkPad） 轻薄系列E450C(20EH0001CD)14英寸笔记本电脑(i5-4210U 4G 500G 2G独显 Win8.1)', '2015-11-02', '0', '0', '33');
INSERT INTO `t_product` VALUES ('34', '2', '联想（Lenovo）小新V3000经典版', '4599.00', '4499.00', 'Resource/products/1/c_0034.jpg', '14英寸超薄笔记本电脑（i7-5500U 4G 500G+8G SSHD 2G独显 全高清屏）黑色满1000減100，狂减！火力全开，横扫3天！', '2015-11-02', '0', '0', '40');
INSERT INTO `t_product` VALUES ('35', '2', '华硕（ASUS）经典系列R557LI', '3799.00', '3699.00', 'Resource/products/1/c_0035.jpg', '15.6英寸笔记本电脑（i5-5200U 4G 7200转500G 2G独显 D刻 蓝牙 Win8.1 黑色）', '2015-11-02', '0', '0', '21');
INSERT INTO `t_product` VALUES ('36', '2', '华硕（ASUS）X450J', '4599.00', '4399.00', 'Resource/products/1/c_0036.jpg', '14英寸笔记本电脑 （i5-4200H 4G 1TB GT940M 2G独显 蓝牙4.0 D刻 Win8.1 黑色）', '2015-11-02', '0', '0', '36');
INSERT INTO `t_product` VALUES ('37', '2', '戴尔（DELL）灵越 飞匣3000系列', '3399.00', '3299.00', 'Resource/products/1/c_0037.jpg', ' Ins14C-4528B 14英寸笔记本（i5-5200U 4G 500G GT820M 2G独显 Win8）黑', '2015-11-03', '0', '0', '43');
INSERT INTO `t_product` VALUES ('38', '2', '惠普(HP)WASD 暗影精灵', '5699.00', '5499.00', 'Resource/products/1/c_0038.jpg', '15.6英寸游戏笔记本电脑(i5-6300HQ 4G 1TB+128G SSD GTX950M 4G独显 Win10)', '2015-11-02', '0', '0', '22');
INSERT INTO `t_product` VALUES ('39', '2', 'Apple 配备 Retina 显示屏的 MacBook', '11299.00', '10288.00', 'Resource/products/1/c_0039.jpg', 'Pro MF840CH/A 13.3英寸宽屏笔记本电脑 256GB 闪存', '2015-11-02', '0', '0', '29');
INSERT INTO `t_product` VALUES ('40', '2', '机械革命（MECHREVO）MR X6S-M', '6799.00', '6599.00', 'Resource/products/1/c_0040.jpg', '15.6英寸游戏本(I7-4710MQ 8G 64GSSD+1T GTX960M 2G独显 IPS屏 WIN7)黑色', '2015-11-02', '0', '0', '17');
INSERT INTO `t_product` VALUES ('41', '2', '神舟（HASEE） 战神K660D-i7D2', '5699.00', '5499.00', 'Resource/products/1/c_0041.jpg', '15.6英寸游戏本(i7-4710MQ 8G 1TB GTX960M 2G独显 1080P)黑色', '2015-11-02', '0', '0', '33');
INSERT INTO `t_product` VALUES ('42', '2', '微星（MSI）GE62 2QC-264XCN', '6199.00', '5999.00', 'Resource/products/1/c_0042.jpg', '15.6英寸游戏笔记本电脑（i5-4210H 8G 1T GTX960MG DDR5 2G 背光键盘）黑色', '2015-11-02', '0', '0', '46');
INSERT INTO `t_product` VALUES ('43', '2', '雷神（ThundeRobot）G150S', '5699.00', '5499.00', 'Resource/products/1/c_0043.jpg', '15.6英寸游戏本 ( i7-4710MQ 4G 500G GTX950M 2G独显 包无亮点全高清屏) 金', '2015-11-02', '0', '0', '31');
INSERT INTO `t_product` VALUES ('44', '2', '惠普（HP）轻薄系列 HP', '3199.00', '3099.00', 'Resource/products/1/c_0044.jpg', '15-r239TX 15.6英寸笔记本电脑（i5-5200U 4G 500G GT820M 2G独显 win8.1）金属灰', '2015-11-02', '0', '0', '29');
INSERT INTO `t_product` VALUES ('45', '2', '未来人类（Terrans Force）T5', '10999.00', '9899.00', 'Resource/products/1/c_0045.jpg', '15.6英寸游戏本（i7-5700HQ 16G 120G固态+1TB GTX970M 3G GDDR5独显）黑', '2015-11-02', '0', '0', '14');
INSERT INTO `t_product` VALUES ('46', '2', '戴尔（DELL）Vostro 3800-R6308 台式电脑', '3299.00', '3199.00', 'Resource/products/1/c_0046.jpg', '（i3-4170 4G 500G DVD 三年上门服务 Win7）黑', '2015-11-02', '0', '0', '25');
INSERT INTO `t_product` VALUES ('47', '2', '联想（Lenovo）H3050 台式电脑', '5099.00', '4899.00', 'Resource/products/1/c_0047.jpg', '（i5-4460 4G 500G GT720 1G独显 DVD 千兆网卡 Win10）23英寸', '2015-11-11', '0', '0', '30');
INSERT INTO `t_product` VALUES ('48', '2', 'Apple iPad mini 2 ME279CH/A', '2088.00', '1888.00', 'Resource/products/1/c_0048.jpg', '（配备 Retina 显示屏 7.9英寸 16G WLAN 机型 银色）', '2015-11-02', '0', '0', '10');
INSERT INTO `t_product` VALUES ('49', '2', '小米（MI）7.9英寸平板', '1399.00', '1299.00', 'Resource/products/1/c_0049.jpg', 'WIFI 64GB（NVIDIA Tegra K1 2.2GHz 2G 64G 2048*1536视网膜屏 800W）白色', '2015-11-02', '0', '0', '14');
INSERT INTO `t_product` VALUES ('50', '2', 'Apple iPad Air 2 MGLW2CH/A', '2399.00', '2299.00', 'Resource/products/1/c_0050.jpg', '（9.7英寸 16G WLAN 机型 银色）', '2015-11-12', '0', '0', '31');
INSERT INTO `t_product` VALUES ('55', '1', 'morty_test1', '111.00', '111.00', 'products/4/C/D75B3047D5A34DFEBA3075E66BBDBEB0.jpg', '111', '2019-12-23', '0', '1', '22');
INSERT INTO `t_product` VALUES ('56', '1', 'morty_test2', '111.00', '110.00', 'products/C/A/B4ACDC549DB048148B19A9FAA7EBF607.jpg', 'ww', '2019-12-23', '0', '1', '22');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `account` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '用户密码',
  `name` varchar(20) DEFAULT NULL COMMENT '用户姓名',
  `sex` varchar(10) NOT NULL COMMENT '用户性别',
  `email` varchar(30) NOT NULL COMMENT '用户邮箱',
  `telephone` varchar(20) DEFAULT NULL COMMENT '用户手机号',
  `birthday` date DEFAULT NULL COMMENT '用户生日',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_user_account` (`account`) USING BTREE,
  UNIQUE KEY `unique_user_email` (`email`),
  UNIQUE KEY `account` (`account`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `unique_user_telephone` (`telephone`),
  UNIQUE KEY `telephone` (`telephone`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'll', 'e10adc3949ba59abbe56e057f20f883e', 'll', '0', '1468071675@qq.com', null, null);
INSERT INTO `t_user` VALUES ('2', 'morty', 'e10adc3949ba59abbe56e057f20f883e', 'morty', '1', '2110825316@qq.com', null, '2019-12-03');
INSERT INTO `t_user` VALUES ('3', 'rick', 'e10adc3949ba59abbe56e057f20f883e', 'rick', '1', '3344794331@qq.com', null, '1996-04-13');
INSERT INTO `t_user` VALUES ('4', 'lucy', 'e10adc3949ba59abbe56e057f20f883e', 'dd', '1', '13986511563@163.com', null, null);
