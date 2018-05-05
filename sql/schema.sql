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
UNIQUE KEY (phone),
KEY idx_create_time(create_time) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7000 DEFAULT CHARSET=utf8 COMMENT '用户信息表';

INSERT INTO t_user (username, password, real_name, phone, address, user_type, create_time, update_time)
VALUES
('spike','123456','黄皓','15600057761','四舍204',1,UNIX_TIMESTAMP(NOW()),UNIX_TIMESTAMP(NOW())),
('tom','123','张三','18800008888','三舍412',0,UNIX_TIMESTAMP(NOW()),UNIX_TIMESTAMP(NOW())),
('战神','123','李四','19900013098','二舍109',0,UNIX_TIMESTAMP(NOW()),UNIX_TIMESTAMP(NOW())),
('su_yt','123','赵五','13665829916','一舍423',0,UNIX_TIMESTAMP(NOW()),UNIX_TIMESTAMP(NOW()));

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
(5,'宠物'), 
(6,'乐器');

CREATE TABLE t_goods(
`goods_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '商品id',
`user_id` BIGINT UNSIGNED NOT NULL COMMENT '发布者id',
`name` VARCHAR(20) NOT NULL COMMENT '商品名',
`img` VARCHAR(150) COMMENT '商品图片',
`price` DECIMAL(11, 2) NOT NULL COMMENT '价格',
`cat_id` INT(11) NOT NULL COMMENT '商品分类id',
`status` TINYINT UNSIGNED NOT NULL DEFAULT '0' COMMENT '商品状态：0-已上架；1-交易中；2-已下架',
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
(7001,'HTC ONE','/img/htcone1525233132.jpg',800,2,'用了2年的HTC ONE，正品行货，当时买的时候花了4000多，外壳稍有磨损，功能一切正常',UNIX_TIMESTAMP(NOW()),UNIX_TIMESTAMP(NOW())),
(7002,'40寸吉他','/img/guitar1525233523.jpg',150.88,6,'十字军吉他，用了1年不到，适合入门过渡学习，附送一套爱丽丝琴弦、固弦锥、换弦神器',UNIX_TIMESTAMP(NOW()),UNIX_TIMESTAMP(NOW())),
(7003,'Java编程思想','/img/tij1525233802.jpg',35,4,'八成新Java编程思想第四版',UNIX_TIMESTAMP(NOW()),UNIX_TIMESTAMP(NOW()));

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
