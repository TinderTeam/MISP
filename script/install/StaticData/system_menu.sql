USE `mispdb`;
INSERT INTO `s_system_menu`(MENU_ID,NAME,VALUE,TYPE,ICON,EXTENAL,FRESH,URL,PARENT_ID,FUNCTION_ID) VALUES (10000,'SystemConfig','系统设置','','icon icon-home','','','IndexInit.do',0,1);
INSERT INTO `s_system_menu`(MENU_ID,NAME,VALUE,TYPE,ICON,EXTENAL,FRESH,URL,PARENT_ID,FUNCTION_ID) VALUES (11000,'groupManage','权限组管理','','icon icon-home','','','groupManage.action',10000,1);
INSERT INTO `s_system_menu`(MENU_ID,NAME,VALUE,TYPE,ICON,EXTENAL,FRESH,URL,PARENT_ID,FUNCTION_ID) VALUES (12000,'userManage','用户管理','','icon icon-home','','','userManage.action',10000,1);
INSERT INTO `s_system_menu`(MENU_ID,NAME,VALUE,TYPE,ICON,EXTENAL,FRESH,URL,PARENT_ID,FUNCTION_ID) VALUES (13000,'orgManage','组织机构管理','','icon icon-home','','','orgManage.action',10000,1);


INSERT INTO `s_system_menu`(MENU_ID,NAME,VALUE,TYPE,ICON,EXTENAL,FRESH,URL,PARENT_ID,FUNCTION_ID) VALUES (20000,'PersonalConfig','个人设置','','icon icon-home','','','IndexInit.do',0,1);
INSERT INTO `s_system_menu`(MENU_ID,NAME,VALUE,TYPE,ICON,EXTENAL,FRESH,URL,PARENT_ID,FUNCTION_ID) VALUES (21000,'password','信息/密码修改','','icon icon-home','','','platform\userInfo\passwordConfig.jsp',20000,1);






