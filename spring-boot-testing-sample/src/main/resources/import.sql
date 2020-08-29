-- CREATE DATABASE test CHARACTER SET utf8 COLLATE utf8_general_ci;
drop table if exists USER;
CREATE TABLE User  (
  ID varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  NAME varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
insert into User (id, name) values ('1', 'San Francisco');