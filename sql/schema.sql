DROP DATABASE IF EXISTS db_panda;

CREATE DATABASE db_panda;

USE db_panda;

CREATE TABLE t_user(
`user_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户id',
`username` VARCHAR(50) NOT NULL COMMENT '用户名',
`password` VARCHAR(20) NOT NULL COMMENT '密码',
`real_name` VARCHAR(10) NOT NULL COMMENT '真实姓名',
`phone` VARCHAR(20) NOT NULL COMMENT '电话号码',
`address` VARCHAR(100) COMMENT '地址',
`user_type` TINYINT UNSIGNED NOT NULL DEFAULT '0' COMMENT '用户类型：0-普通会员；1-管理员',
`create_time` INT(11) NOT NULL COMMENT '创建时间',
`update_time` INT(11) NOT NULL COMMENT '更新时间',
PRIMARY KEY (user_id),
UNIQUE (phone),
KEY idx_create_time(create_time) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7000 DEFAULT CHARSET=utf8 COMMENT '用户信息表';

INSERT INTO t_user (username, password, real_name, phone, address, user_type, create_time, update_time)
VALUES
('spike','123456','黄皓','15600057761','四舍204',1,1523463011,1523463011),
('tom','123','张三','18800008888','三舍412',0,1523807451,1523807451),
('战神','123','李四','13500005555','二舍109',0,1523810245,1523810245),
('su_yt','123','赵五','13600006666','一舍423',0,1524070809,1524070809);

CREATE TABLE t_goods_cat(
`cat_id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '商品类型id',
`cat_name` VARCHAR(50) NOT NULL COMMENT '商品类型名称',
PRIMARY KEY (cat_id),
KEY idx_cat_id(cat_id) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '商品类型表';

INSERT INTO t_goods_cat (cat_id, cat_name)
VALUES
(1,'日用百货'), 
(2,'电子产品'), 
(3,'鞋帽配饰'), 
(4,'图书'), 
(5,'球类'),
(6,'乐器');

CREATE TABLE t_goods(
`goods_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '商品id',
`user_id` BIGINT UNSIGNED NOT NULL COMMENT '发布者id',
`name` VARCHAR(20) NOT NULL COMMENT '商品名',
`img` VARCHAR(150) COMMENT '商品图片',
`price` DECIMAL(11, 2) NOT NULL COMMENT '价格',
`cat_id` INT(11) NOT NULL COMMENT '商品分类id',
`status` TINYINT UNSIGNED NOT NULL DEFAULT '0' COMMENT '商品状态：0-待交易；1-交易中；2-已下架',
`description` TEXT NOT NULL COMMENT '商品描述',
`create_time` INT(11) NOT NULL COMMENT '创建时间',
`update_time` INT(11) NOT NULL COMMENT '更新时间',
PRIMARY KEY (goods_id),
KEY idx_price(price) USING BTREE,
KEY idx_cat_id(cat_id) USING BTREE,
KEY idx_create_time(create_time) USING BTREE,
CONSTRAINT `fk_t_goods_t_goods_cat` FOREIGN KEY (`cat_id`) REFERENCES `t_goods_cat` (`cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=70000 DEFAULT CHARSET=utf8 COMMENT '商品信息表';

INSERT INTO t_goods (user_id, name, img, price, cat_id, description, create_time, update_time)
VALUES
(7001,'HTC ONE','/img/htcone1525233132.jpg',800,2,'用了2年的HTC ONE，正品行货，当时买的时候花了4000多，外壳稍有磨损，功能一切正常',1525233132,1525233132),
(7002,'40寸吉他','/img/guitar1525233523.jpg',150.88,6,'十字军吉他，用了1年不到，适合入门过渡学习，附送一套爱丽丝琴弦、固弦锥、换弦神器',1525233523,1525233523),
(7003,'Java编程思想','/img/tij1525233802.jpg',35,4,'八成新Java编程思想第四版',1525233802,1525233802),
(7003,'移动硬盘','/img/disk1526961225.jpg',350,2,'希捷（Seagate）Backup Plus 睿品1TB （限量白色版）USB3.0 2.5英寸 移动硬盘( STDR1000307) 刚买一周多，全新，没用过，有发票。',1526961225,1526961225),
(7001,'耐克运动鞋','/img/nike1526971629.jpg',289,3,'18年3月中旬耐克官网购买，九成新以上，现在买新了，只穿过3次，时间都不长',1526971629,1526971629),
(7001,'泰国皇家乳胶枕','/img/pillow1526971892.jpg',220,1,'全新泰国皇家乳家枕,原价320,处理价220',1526971892,1526971892),
(7001,'转26寸女式单车','/img/bike1526972101.jpg',230,1,'自行车完好，保证质量，如实图 ',1526972101,1526972101),
(7001,'男士腰包','/img/bag1526975851.jpg',35,3,'帆布腰包 男士小包 腰带包 钥匙包 手机包 贴身挂包 TSD夏日出行推荐！该款造沿用美军腰包，五金统一采用纯铜，坚固可信。包的底角用牛皮补强及铆钉加固。背面有横纵织带。可穿入所有宽度腰带。空间容量乐观。正常扣袋身，长度是5.5寸。若移扣一个位置。长度可达6.5寸。一般智能手机，烟盒，钥匙。不在话下。后期水洗做旧更显时尚！包装完好，颜色多样，可以随机发货哦(????????)哦。多数为黑色，咖啡，军绿，浅军色样！非质量问题，不退不换。喜欢的可以私聊我，当天拍下，当天发走。包邮哦！ 本交易支持自提、当面交易、邮寄',1526975851,1526975851),
(7001,'Java语言','/img/java1526975942.jpg',30,4,'Java语言 2本 delphi 语言 ',1526975942,1526975942),
(7001,'zippo打火机','/img/zippo1526976109.png',95,1,'09年的真品纯铜打火机如假包退',1526976109,1526976109),
(7001,'古筝','/img/guzheng1526976263.png',680,6,'2018年1月8日入手的古筝。几乎全新。包装完好无损。 ',1526976263,1526976263),
(7001,'男女式手表','/img/watch1526976360.jpg',39,1,'这是朋友抵账抵来的，都是新的，而且款式多样，这只是其中的两款 ',1526976360,1526976360);

CREATE TABLE t_order(
`order_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '订单id',
`user_id` BIGINT UNSIGNED NOT NULL COMMENT '用户id',
`goods_id` BIGINT UNSIGNED NOT NULL COMMENT '商品id',
`status` TINYINT UNSIGNED NOT NULL DEFAULT '0' COMMENT '订单状态：0-交易中；1-交易成功；2-交易取消',
`money` DECIMAL(11, 2) NOT NULL COMMENT '订单金额',
`create_time` INT(11) NOT NULL COMMENT '创建时间',
`update_time` INT(11) NOT NULL COMMENT '更新时间',
PRIMARY KEY (order_id),
KEY idx_create_time(create_time) USING BTREE,
CONSTRAINT `fk_t_order_t_user` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`),
CONSTRAINT `fk_t_order_t_goods` FOREIGN KEY (`goods_id`) REFERENCES `t_goods` (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=700000 DEFAULT CHARSET=utf8 COMMENT '订单信息表';
