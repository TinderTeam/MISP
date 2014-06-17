 
DROP DATABASE IF EXISTS `MISPDB`;
CREATE DATABASE `MISPDB` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `MISPDB`;

DROP TABLE IF EXISTS `d_system_user`;
CREATE TABLE `d_system_user` (
  `USER_ID` varchar(255) NOT NULL COMMENT '用户名称:',
  `PASSWORD` varchar(255) NOT NULL DEFAULT '123456' COMMENT '用户密码:',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 DROP TABLE IF EXISTS `s_system_menu`;
CREATE TABLE `s_system_menu` (
  `MENU_ID` int(32) NOT NULL DEFAULT '0' COMMENT '菜单ID:',
  `NAME` varchar(255) DEFAULT NULL COMMENT '菜单名称:',
  `VALUE` varchar(255) DEFAULT NULL COMMENT '菜单显示值:',
  `TYPE` varchar(255) DEFAULT NULL COMMENT '菜单风格:',
  `ICON` varchar(255) DEFAULT NULL COMMENT '图标风格:',
  `EXTENAL` varchar(255) DEFAULT NULL COMMENT '菜单跳转URL:',
  `FRESH` varchar(255) DEFAULT NULL COMMENT '菜单跳转URL:',
  `URL` varchar(255) DEFAULT NULL COMMENT '菜单跳转URL:',
  `PARENT_ID` int(32) DEFAULT NULL COMMENT '上一级菜单ID:',	  
  `FUNCTION_ID` int(32) DEFAULT NULL COMMENT '上一级菜单ID:',
  PRIMARY KEY (`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `s_system_meta_data` (
  `TABLE_NAME` varchar(255) NOT NULL,
  `ATTR_NAME` varchar(255) NOT NULL,
  `ATTR_DEFAULT_VALUE` varchar(255) DEFAULT NULL,
  `IS_DISPLAY` int(11) NOT NULL,
  `IS_FILTER` int(11) NOT NULL,
  `SORT_ORDER` int(11) NOT NULL,
  PRIMARY KEY (`TABLE_NAME`,`ATTR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `d_user_ext_attr` (
  `USER_ID` varchar(255) NOT NULL,
  `ATTR_NAME` varchar(255) NOT NULL,
  `ATTR_VALUE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`,`ATTR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;