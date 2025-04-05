DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `class`;

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

CREATE TABLE `class`
(
    id BIGINT NOT NULL COMMENT '主键ID',
    class_name varchar(30) null  comment '班级名称',
    PRIMARY KEY (id)
);