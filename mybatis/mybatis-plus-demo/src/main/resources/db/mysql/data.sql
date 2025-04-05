
create database test;
use test;
-- 创建 class 表
CREATE TABLE `class`
(
    id BIGINT NOT NULL COMMENT '主键ID',
    class_name varchar(30) null  comment '班级名称',
    PRIMARY KEY (id)
);

-- 创建 user 表
CREATE TABLE `user`
(
    id BIGINT NOT NULL COMMENT '主键ID',
    first_dept_id bigint null  comment '一级部门id',
    second_dept_id bigint null  comment '二级部门id',
    name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
    age INT NULL DEFAULT NULL COMMENT '年龄',
    email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
    class_id int not null  comment '班级id',
    PRIMARY KEY (id)
);

-- 向 class 表插入 3 条测试数据
INSERT INTO `class` (id, class_name)
VALUES (1, '一班'),
       (2, '二班'),
       (3, '三班');

-- 向 user 表插入 10 条测试数据
INSERT INTO `user` (id, first_dept_id, second_dept_id, name, age, email, class_id)
VALUES (1, 001, 102, '张三', 20, 'zhangsan@example.com', 1),
       (2, 001, 102, '李四', 21, 'lisi@example.com', 1),
       (3, 004, 105, '王五', 22, 'wangwu@example.com', 2),
       (4, 004, 105, '赵六', 23, 'zhaoliu@example.com', 2),
       (5, 004, 107, '孙七', 24, 'sunqi@example.com', 3),
       (6, 004, 108, '周八', 25, 'zhouba@example.com', 3),
       (7, 005, 110, '吴九', 26, 'wujiu@example.com', 3),
       (8, 005, 111, '郑十', 27, 'zhengshi@example.com', 1),
       (9, 005, 112, '王十一', 28, 'wangshiyi@example.com', 1),
       (10, 005, 113, '李十二', 29, 'lishier@example.com', 1);