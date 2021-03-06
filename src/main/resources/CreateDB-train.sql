-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE train;
-- 使用数据库
USE train;
-- 创建用户表

CREATE TABLE user (uid INT AUTO_INCREMENT PRIMARY KEY COMMENT '用户id',
                   username VARCHAR(30) NOT NULL UNIQUE KEY COMMENT '用户名',
                   password VARCHAR(20) NOT NULL COMMENT '密码',
                   name VARCHAR(30) NOT NULL COMMENT '真实姓名',
                   IDType ENUM('1', '2', '3', '4') DEFAULT '1' COMMENT '证件类型 1:身份证 2:港澳通行证 3:台湾通行证 4:护照',
                   ID VARCHAR(18) NOT NULL COMMENT '证件号',
                   email VARCHAR(30) COMMENT '邮箱',
                   telephone VARCHAR(20) NOT NULL COMMENT '电话号码',
                   Passenger ENUM('1', '2', '3', '4') DEFAULT '1' COMMENT '旅客类型 1:成人 2:儿童 3:学生 4:残疾军人、伤残人民警察'
)ENGINE = InnoDB CHARSET = utf8 COMMENT = '用户表';

-- 创建站点表
CREATE TABLE station (sid INT PRIMARY KEY AUTO_INCREMENT COMMENT '站点id',
                      sname VARCHAR(30) NOT NULL COMMENT '站点名',
                      province VARCHAR(30) NOT NULL COMMENT '所在省份',
                      city VARCHAR(30) NOT NULL COMMENT '所在城市',
                      latitude NUMERIC(12,5) COMMENT '纬度',
                      longitude NUMERIC(12,5) COMMENT '经度'
)ENGINE = InnoDB CHARSET = utf8 COMMENT = '站点表';

-- 创建距离表
CREATE TABLE distance(sid1 INT NOT NULL COMMENT '站点1的id',
                      sid2 INT NOT NULL COMMENT '站点2的id',
                      time INT NOT NULL COMMENT '两站点所需时间',
  PRIMARY KEY (sid1, sid2),
  FOREIGN KEY (sid1) REFERENCES station(sid),
  FOREIGN KEY (sid2) REFERENCES station(sid)
)ENGINE = InnoDB CHARSET = utf8 COMMENT = '距离表';

-- 创建列车表
CREATE TABLE train (tid VARCHAR(6) PRIMARY KEY NOT NULL COMMENT '列车id',
                    stratTime TIME NOT NULL COMMENT '发车时间',
                    endTime TIME NOT NULL COMMENT '到达时间',
                    startSid INT COMMENT '发车站点id',
                    endSid INT COMMENT '到达站点id',
  FOREIGN KEY (startSid) REFERENCES station(sid),
  FOREIGN KEY (endSid) REFERENCES station(sid)
)ENGINE = InnoDB CHARSET = utf8 COMMENT = '列车表';

-- 创建列车时刻表
CREATE TABLE traintime(sid INT NOT NULL COMMENT '到达站点id',
                  tid VARCHAR(6) NOT NULL COMMENT '列车id',
                  arriveTime TIME COMMENT '到达时间',
                  departTime TIME COMMENT '离开时间',
  PRIMARY KEY (sid, tid) ,
  FOREIGN KEY (sid) REFERENCES station(sid) ,
  FOREIGN KEY (tid) REFERENCES train(tid)
)ENGINE = InnoDB CHARSET = utf8 COMMENT = '列车时刻表';

-- 创建车厢表
CREATE TABLE carriage(cid TINYINT NOT NULL COMMENT '车厢id',
                      tid VARCHAR(6) NOT NULL COMMENT '列车id',
                      totalNumber SMALLINT NOT NULL COMMENT '车厢总人数',
                      seatNumber SMALLINT NOT NULL COMMENT '座位总数',
                      description VARCHAR(8) COMMENT '车厢描述',
  PRIMARY KEY (cid, tid),
  FOREIGN KEY (tid) REFERENCES train(tid)
)ENGINE = InnoDB CHARSET = utf8 COMMENT = '车厢表';

-- 创建座位表
CREATE TABLE seat(seatId VARCHAR(4) NOT NULL COMMENT '座位id',
                  cid TINYINT NOT NULL COMMENT '车厢id',
                  description VARCHAR(6) COMMENT '座位描述',
  PRIMARY KEY (seatId, cid),
  FOREIGN KEY (cid) REFERENCES carriage(cid)
)ENGINE = InnoDB CHARSET = utf8 COMMENT = '座位表';

-- 创建列车日期表
CREATE TABLE traindate(date DATE NOT NULL COMMENT '日期',
                       tid VARCHAR(6) NOT NULL COMMENT '列车id',
                       firstSeatNum INT COMMENT '一等座票数量',
                       secondSeatNum INT COMMENT '二等座票数量',
                       standNum INT COMMENT '站票数量',
  PRIMARY KEY (date, tid) ,
  FOREIGN KEY (tid) REFERENCES train(tid)
)ENGINE = InnoDB CHARSET = utf8 COMMENT = '列车日期表';

-- 创建车票表
CREATE TABLE trick(uid INT NOT NULL COMMENT '用户id',
                   tid VARCHAR(6) NOT NULL COMMENT '列车id',
                   cid TINYINT NOT NULL COMMENT '车厢id',
                   seatId VARCHAR(4) NOT NULL COMMENT '座位id',
                   startSid INT NOT NULL COMMENT '开始站点id',
                   endSid INT NOT NULL COMMENT '结束站点id',
                   date DATE NOT NULL COMMENT '所乘车日期',
                   state ENUM('1', '2', '3', '4') DEFAULT '1' COMMENT '车票状态 1:订票 2:出票 3:过期 4:改签',
  PRIMARY KEY (uid, tid, date),
  FOREIGN KEY (uid) REFERENCES user(uid),
  FOREIGN KEY (date, tid) REFERENCES traindate(date, tid),
  FOREIGN KEY (seatId, cid) REFERENCES seat(seatId, cid),
  FOREIGN KEY (startSid) REFERENCES station(sid),
  FOREIGN KEY (endSid) REFERENCES station(sid)
)ENGINE = InnoDB CHARSET = utf8 COMMENT = '车票表';

-- 创建车票临时表
CREATE TABLE temporary(tid VARCHAR(6) NOT NULL COMMENT '列车id',
                       cid TINYINT NOT NULL COMMENT '车厢id',
                       seatId VARCHAR(4) NOT NULL COMMENT '座位id',
                       startSid INT NOT NULL COMMENT '开始站点id',
                       endSid INT NOT NULL COMMENT '结束站点id',
                       date DATE NOT NULL COMMENT '所乘车日期',
  FOREIGN KEY (date, tid) REFERENCES traindate(date, tid),
  FOREIGN KEY (seatId, cid) REFERENCES seat(seatId, cid),
  FOREIGN KEY (startSid) REFERENCES station(sid),
  FOREIGN KEY (endSid) REFERENCES station(sid)
)ENGINE = InnoDB CHARSET = utf8 COMMENT = '车票临时表';