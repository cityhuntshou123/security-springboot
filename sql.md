### 创建 测试库
```CREATE DATABASE user_db CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';```

```USE user_db;```

### 创建 用户 表
```
CREATE TABLE t_user (
id BIGINT (20) NOT NULL COMMENT '用户id',
username VARCHAR(64) NOT NULL,
PASSWORD VARCHAR(64) NOT NULL,
fullname VARCHAR(255) NOT NULL COMMENT '用户姓名',
mobile VARCHAR(11) DEFAULT '' COMMENT '手机号',
PRIMARY KEY (id) USING BTREE
)ENGINE = INNODB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

SELECT * FROM t_user;

INSERT INTO t_user(id, username, PASSWORD, fullname, mobile) VALUES
(1, 'admin', 'admin', 'admin', '13800000000');
```
### 创建 角色 表
```
CREATE TABLE t_role(
id BIGINT(20) NOT NULL,
role_name VARCHAR(255) DEFAULT NULL,
description VARCHAR(255) DEFAULT NULL,
create_time DATETIME DEFAULT NULL,
update_time DATETIME DEFAULT NULL,
STATUS CHAR(1) NOT NULL,
PRIMARY KEY(id),
UNIQUE KEY unique_role_name (role_name)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO t_role (id, role_name, description, create_time, update_time, STATUS)
VALUES
(1, '管理员', NULL, NULL, NULL, '1');

SELECT * FROM t_role;
```
### 创建 用户角色关系 表
```
CREATE TABLE t_user_role (
user_id BIGINT(20) NOT NULL,
role_id BIGINT(20) NOT NULL,
create_time VARCHAR(32) DEFAULT NULL,
UNIQUE KEY unique_userId_roleId (user_id, role_id)
)ENGINE=INNODB DEFAULT CHARSET=utf8;
```

### 创建 权限 表
```
CREATE TABLE t_permission(
id BIGINT(20) NOT NULL,
CODE VARCHAR(12) NOT NULL COMMENT '权限编码',
description VARCHAR(255) NOT NULL COMMENT '权限描述',
url VARCHAR(255) DEFAULT NULL COMMENT '权限对应url',
PRIMARY KEY(id),
UNIQUE KEY unique_permission_code (CODE)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

SELECT * FROM t_permission;
```

### 创建 角色权限 表
```
CREATE TABLE t_role_permission (
role_id BIGINT(20) NOT NULL,
permission_id BIGINT(20) NOT NULL
)ENGINE=INNODB DEFAULT CHARSET=utf8;

SELECT * FROM t_role_permission;
```

### 填充测试数据
```
USE user_db;



SELECT * FROM t_permission;
INSERT INTO t_permission(id, CODE, description, url) VALUES
(1, 'p1', '测试资源1', '/r/r1'),
(2, 'p2', '测试资源2', '/r/r2');

SELECT * FROM t_role_permission;
INSERT INTO t_role_permission(role_id, permission_id) VALUES
(1, 1),(1, 2);

SELECT * FROM t_user_role;
INSERT INTO t_user_role(user_id, role_id, create_time) VALUES
(1, 1, NULL);
```