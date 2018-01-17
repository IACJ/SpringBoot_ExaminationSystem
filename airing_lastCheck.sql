-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 2018-01-17 21:07:13
-- 服务器版本： 10.1.28-MariaDB
-- PHP Version: 7.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `airing`
--

-- --------------------------------------------------------

--
-- 表的结构 `admin`
--

CREATE TABLE `admin` (
  `id` bigint(20) NOT NULL,
  `account` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `name` char(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` char(40) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- 转存表中的数据 `admin`
--

INSERT INTO `admin` (`id`, `account`, `name`, `password`) VALUES
(1, 'acj', 'acj', 'mgiOTEVA6f18FVjuqc7KUw=='),
(2, 'wty', '王腾叶', '4QrcOUm6Wau+VuBX8g+IPg=='),
(3, 'zyr', '钟燕榕', '4QrcOUm6Wau+VuBX8g+IPg=='),
(4, 'lyt', '鲁雅婷', '4QrcOUm6Wau+VuBX8g+IPg==');

-- --------------------------------------------------------

--
-- 表的结构 `choicedba`
--

CREATE TABLE `choicedba` (
  `id` bigint(20) NOT NULL,
  `question` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `option1` varchar(300) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `option2` varchar(300) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `option3` varchar(300) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `option4` varchar(300) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `rightanswer` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `secrecy` tinyint(1) NOT NULL DEFAULT '0',
  `chapters` smallint(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- 转存表中的数据 `choicedba`
--

INSERT INTO `choicedba` (`id`, `question`, `option1`, `option2`, `option3`, `option4`, `rightanswer`, `secrecy`, `chapters`) VALUES
(1, '数据库三级模式中，真正存在的是（ ）。\n\n', '外模式', '子模式', '模式', '内模式', 'D', 0, 1),
(2, '关系数据库中的关键字是指（ ）。', '能唯一决定关系的字段', '不可改动的专用保留字', '关键的很重要的字段\r\n', '能唯一标识元组的属性或属性集合\r\n', 'D', 0, 1),
(3, '数据库的三级模式之间存在的映象关系正确的是（ ）。\r\n', '外模式/内模式', '外模式/模式', '外模式/外模式', '模式/模式\r\n', 'B', 0, 1),
(4, '数据库三级结构从内到外的三个层次为（ ）。', '外模式、模式、内模式', '内模式、模式、外模式\r\n', '模式、外模式、内模式', '内模式、外模式、模式\r\n', 'B', 0, 1),
(5, '下述关于数据库系统的正确叙述是（ ）。\r\n', '数据库系统减少了数据冗余', '数据库系统避免了一切冗余', '数据库系统中数据的一致性是指数据类型一致', '数据库系统比文件系统能管理更多的数据', 'A', 0, 1),
(6, '数据库系统和文件系统的主要区别是（ ）。', '数据库系统复杂，而文件系统简单', '文件系统不能解决数据冗余和数据独立性问题，而数据库系统能够解决', '文件系统只能管理文件，而数据库系统还能管理其他类型的数据', '文件系统只能用于小型、微型机，而数据库系统还能用于大型机', 'B', 0, 1),
(7, '在数据库中存储的是（ ）。', '数据', '数据模型', '数据及数据间的联系', '信息', 'C', 0, 1),
(8, '数据库的概念模型独立于（ ）。', '具体的机器和DBMS', 'E-R图', '信息世界', '现实世界', 'A', 0, 1),
(9, '在数据库系统阶段，数据是（ ）。', '有结构的', '无结构的', '整体无结构，记录内有结构', '整体结构化的', 'D', 0, 1),
(10, '（ ）属于信息世界的模型，实际上是现实世界到机器世界的一个中间层次。', '数据模型', '概念模型', 'E-R图', '关系模型', 'B', 0, 1),
(11, '在数据管理技术的发展过程中，经历了人工管理阶段、文件系统阶段和数据库系统阶段。在这几个阶段中，数据独立性最高的是               阶段。', '数据库系统', '文件系统', '人工管理', '数据项管理', 'A', 0, 1),
(12, '并发操作会带来哪些数据不一致性                      。', '丢失修改、不可重复读、脏读、死锁', '不可重复读、脏读、死锁 ', '丢失修改、脏读、死锁', '丢失修改、不可重复读、脏读 ', 'D', 0, 11),
(13, '数据库的基本特点是                     。', '(1)数据可以共享(或数据结构化)    (2)数据独立性   (3)数据冗余大，易移植            (4)统一管理和控制', '(1)数据可以共享(或数据结构化)    (2)数据独立性   (3)数据冗余小，易扩充            (4)统一管理和控制', '(1)数据可以共享(或数据结构化)    (2)数据互换性   (3)数据冗余小，易扩充            (4)统一管理和控制', '(1)数据非结构化                  (2)数据独立性   (3)数据冗余小，易扩充            (4)统一管理和控制  ', 'B', 0, 1),
(14, '                  是存储在计算机内有结构的数据的集合。', '数据库系统', '数据库', '数据库管理系统', '数据结构', 'B', 0, 1),
(15, '数据库中，数据的物理独立性是指                     。', '数据库与数据库管理系统的相互独立', '用户程序与DBMS的相互独立', '用户的应用程序与存储在磁盘上数据库中的数据是相互独立的', '应用程序与数据库中数据的逻辑结构相互独立', 'C', 0, 1),
(16, '数据库的特点之一是数据的共享，严格地讲，这里的数据共享是指                 。', '同一个应用中的多个程序共享一个数据集合', '多个用户、同一种语言共享数据', '多个用户共享一个数据文件', '多种应用、多种语言、多个用户相互覆盖地使用数据集合 ', 'D', 0, 1),
(17, '数据库系统的核心是                   。', '数据库', '数据库管理系统', '数据模型', '软件工具', 'B', 0, 1),
(18, '下述关于数据库系统的正确叙述是                 。', '数据库系统减少了数据冗余', '数据库系统避免了一切冗余', '数据库系统中数据的一致性是指数据类型一致', '数据库系统比文件系统能管理更多的数据', 'A', 0, 1),
(19, '将数据库的结构划分成多个层次，是为了提高数据库的         和       。', '数据独立性  逻辑独立性', '管理规范性  数据的共享', '数据独立性  物理独立性 ', '逻辑独立性  物理独立性 ', 'D', 0, 1),
(20, '数据库(DB)、数据库系统(DBS)和数据库管理系统(DBMS)三者之间的关系是      。', 'DBS包括DB和DBMS       ', 'DDMS包括DB和DBS', 'DB包括DBS和DBMS', 'DBS就是DB，也就是DBMS', 'A', 0, 1),
(21, '在数据库中，产生数据不一致的根本原因是                。', '数据存储量太大', '没有严格保护数据', '未对数据进行完整性控制', '数据冗余', 'D', 0, 1),
(22, '数据库管理系统(DBMS)是                  。', '数学软件', '应用软件', '计算机辅助设计', '系统软件', 'D', 0, 1),
(23, '数据库管理系统(DBMS)的主要功能是                。', '修改数据库', '定义数据库', '应用数据库', '保护数据库', 'B', 0, 1),
(24, '数据库系统的特点是         、数据独立、减少数据冗余、避免数据不一致和加强了数据保护。', '数据共享', '数据存储', '数据应用', '数据保密', 'A', 0, 1),
(25, '数据库系统的最大特点是                。', '数据的三级抽象和二级独立性', '数据共享性 ', '数据的结构化', '数据独立性', 'A', 0, 1),
(26, '数据库管理系统能实现对数据库中数据的查询、插入、修改和删除等操作，这种功能称为                  。', '数据定义功能', '数据管理功能', '数据操纵功能', '数据控制功能', 'C', 0, 1),
(27, '数据库管理系统是                  。', '操作系统的一部分', '在操作系统支持下的系统软件 ', '一种编译程序', '一种操作系统 ', 'B', 0, 1),
(28, '数据库的三级模式结构中，描述数据库中全体数据的全局逻辑结构和特征的是（）', '外模式 ', '内模式', '存储模式', '模式', 'D', 0, 1),
(29, '数据库系统的数据独立性是指                   。', '不会因为数据的变化而影响应用程序 ', '不会因为系统数据存储结构与数据逻辑结构的变化而影响应用程序', '不会因为存储策略的变化而影响存储结构 ', '不会因为某些存储结构的变化而影响其他的存储结构 ', 'B', 0, 1),
(30, '信息世界中的术语，与之对应的数据库术语为                  。', '文件', '数据库', '字段', '记录 ', 'D', 0, 1),
(31, '层次型、网状型和关系型数据库划分原则是                  。', '记录长度 ', '文件的大小', '联系的复杂程度', '数据之间的联系', 'D', 0, 1),
(32, '传统的数据模型分类，数据库系统可以分为三种类型                。', '大型、中型和小型', '西文、中文和兼容 ', '层次、网状和关系', '数据、图形和多媒体', 'C', 0, 1),
(33, '层次模型不能直接表示           。', '1 ：1关系', '1 ：m关系 ', 'm ：n关系', '1 ：1和1 ：m关系', 'C', 0, 1),
(34, '数据库技术的奠基人之一E.F．Codd从1970年起发表过多篇论文，主要论述的是           。', '层次数据模型', '网状数据模型', '关系数据模型', '面向对象数据模型', 'C', 0, 1),
(35, '关系数据库管理系统应能实现的专门关系运算包括                   。', '排序、索引、统计 ', '选择、投影、连接', '关联、更新、排序', '显示、打印、制表', 'B', 0, 2),
(36, '关系模型中，一个关键字是                            。', '可由多个任意属性组成', '至多由一个属性组成', '可由一个或多个其值能惟一标识该关系模式中任何元组的属性组成', '以上都不是', 'C', 0, 2),
(37, '自然连接是构成新关系的有效方法。一般情况下，当对关系R和S使用自然连接时，要求R和S含有一个或多个共有的            。', '元组', '行', '记录', '属性', 'D', 0, 2),
(38, '关系运算中花费时间可能最长的运算是                  。', '投影', '选择', '笛卡尔积', '除 ', 'C', 0, 2),
(39, '关系模式的任何属性                  。', '不可再分', '可再分 ', '命名在该关系模式中可以不惟一', '以上都不是', 'A', 0, 2),
(40, '在关系代数运算中，五种基本运算为                  。', '并、差、选择、投影、自然连接 ', '并、差、交、选择、投影', '并、差、选择、投影、乘积', '并、差、交、选择、乘积', 'C', 0, 2),
(41, '对并发操作若不加以控制，可能会带来                     问题。', '不安全', '死锁', '死机', '不一致  ', 'D', 0, 11),
(42, 'SQL语言是                    的语言，易学习。', '过程化', '非过程化', '格式化', '导航式 ', 'B', 0, 3),
(43, 'SQL语言是                  语言。', '层次数据库', '网络数据库', '关系数据库', '非数据库', 'C', 0, 3),
(44, 'SQL语言具有                    的功能。', '关系规范化、数据操纵、数据控制 ', '数据定义、数据操纵、数据控制', '数据定义、关系规范化、数据控制', '数据定义、关系规范化、数据操纵', 'B', 0, 3),
(45, 'SQL语言具有两种使用方式，分别称为交互式SQL和                  。', '提示式SQL', '多用户SQL', '嵌入式SQL', '解释式SQL', 'C', 0, 3),
(46, '假定学生关系是S(S#，SNAME，SEX，AGE)，课程关系是C(C#，CNAME，TEACHER)，学生选课关系是SC(S#，C#，GRADE)。\r\n    要查找选修“COMPUTER”课程的“女”学生姓名，将涉及到关系          。\r\n', 'S ', 'SC，C', 'S，SC ', 'S，C，SC ', 'D', 0, 3),
(47, '如下面的数据库的表中，若职工表的主关键字是职工号，部门表的主关键字是部门号，SQL操作                   不能执行。', 'A．从职工表中删除行(‘025’，‘王芳’，‘03’，720)', 'B．将行(‘005，’，‘乔兴’，‘04’，750)插入到职工表中', 'C．将职工号为，‘001’的工资改为700', ' D．将职工号为，’038’的部门号改为‘03’', 'B ', 0, 3),
(48, '若用如下的SQL语句创建一个student表：\r\n    CREATE TABLE student(NO C(4) NOT NULL，\r\n    NAME C(8) NOT NULL，\r\n    SEX C(2)，\r\n    AGE N(2))\r\n    可以插入到student表中的是                    。\r\n', '(‘1031’，‘曾华’，男，23)', '(‘1031’，‘曾华’，NULL，NULL)', '(NULL，‘曾华’，‘男’，‘23’)', '(‘1031’，NULL，‘男’，23)  ', 'B', 0, 3),
(49, '第8到第11题基于这样的三个表即学生表S、课程表C和学生选课表SC，它们的结构如下：\r\n    S(S#，SN，SEX，AGE，DEPT)\r\n    C(C#，CN)\r\n    SC(S#，C#，GRADE)\r\n其中：S#为学号，SN为姓名，SEX为性别，AGE为年龄，DEPT为系别，C#为课程号，CN为课程名，GRADE为成绩。\r\n检索所有比“王华”年龄大的学生姓名、年龄和性别。正确的SELECT语句是          。       ', 'SELECT SN，AGE，SEX FROM S\r\n       WHERE AGE＞(SELECT AGE FROM S\r\n                    WHERE SN=“王华”)\r\n', 'SELECT SN，AGE，SEX\r\n        FROM S\r\n       WHERE SN＝“王华”\r\n', '．SELECT SN，AGE，SEX  FROM S\r\nWHERE AGE＞(SELECT AGE\r\n            WHERE SN=“王华”)\r\n', 'SELECT SN，AGE，SEX  FROM S\r\n          WHERE AGE＞王华．AGE\r\n', 'A', 0, 3),
(50, '检索选修课程“C2”的学生中成绩最高的学生的学号。正确的SELECT语句是          。', 'SELECT S# FORM SC    WHERE C#=“C2” AND GRAD＞＝\r\n             (SELECT GRADE FORM SC\r\n                WHERE C#=“C2”)\r\n', 'SELECT S# FORM SC\r\n            WHERE C#=“C2” AND GRADE IN\r\n               (SELECT GRADE FORM SC\r\n                 WHERE C#=“C2”)\r\n', 'SELECT S# FORM SC\r\n         WHERE C#=“C2” AND GRADE NOT IN\r\n                (SELECT GRADE FORM SC\r\n                 WHERE C#=“C2”)\r\n', 'SELECT S# FORM SC\r\n            WHERE C#=“C2” AND GRADE＞＝ALL\r\n            (SELECT GRADE FORM SC\r\n               WHERE C#=“C2”)\r\n', 'D', 0, 3),
(51, '检索学生姓名及其所选修课程的课程号和成绩。正确的SELECT语句是            。', 'SELECT S．SN，SC．C#，SC．GRADE\r\n         FROM S\r\n         WHERE S．S#=SC．S#\r\n', 'SELECT S．SN，SC．C#，SC．GRADE\r\n         FROM SC\r\n         WHERE S．S#＝SC．GRADE\r\n', 'SELECT S．SN，SC．C#，SC．GRADE\r\n         FROM S，SC\r\n         WHERE S．S#=SC．S#\r\n', 'SELECT S．SN，SC．C#，SC．GRADE\r\n         FROM S．SC\r\n', 'C', 0, 3),
(52, '检索选修四门以上课程的学生总成绩(不统计不及格的课程)，并要求按总成绩的降序排列出来。正确的SELECT语句是          。', 'SELECT S#，SUM(GRADE)FROM SC\r\n        WHERE GRADE＞=60\r\n        GROUP BY S#\r\n        ORDER BY 2 DESC\r\n        HAVING COUNT(*)＞＝4    WHERE C#=“C2” AND GRADE＞＝\r\n             (SELECT GRADE FORM SC\r\n             WHERE C#=“C2”)\r\n', 'SELECT S# FORM SC\r\n         WHERE C#=“C2” AND GRADE IN\r\n           (SELECT GRADE FORM SC\r\n            WHERE C#=“C2”)\r\n', 'SELECT S# FORM SC\r\n         WHERE C#=“C2” AND GRADE NOT IN\r\n           (SELECT GRADE FORM SC\r\n           WHERE C#=“C2”)\r\n', 'SELECT S# FORM SC\r\n         WHERE C#=“C2” AND GRADE＞＝ALL\r\n           (SELECT GRADE FORM SC\r\n           WHERE C#=“C2”)\r\n', 'D', 0, 3),
(53, '下面哪个不是数据库系统必须提供的数据控制功能              。', '安全性', '可移植性', '完整性', '并发控制', 'B', 0, 4),
(54, '保护数据库，防止未经授权的或不合法的使用造成的数据泄漏、更改破坏。这是指数据的            。', '安全性', '完整性', '并发控制', '恢复 ', 'A', 0, 4),
(55, '数据库的                是指数据的正确性和相容性。', '安全性', '完整性', '并发控制	', '恢复', 'B', 0, 4),
(56, '在数据系统中，对存取权限的定义称为                    。', '命令	', '授权', '定义', '审计 ', 'B', 0, 4),
(57, '数据库管理系统通常提供授权功能来控制不同用户访问数据的权限，这主要是为了实现数据库的                。', '可靠性', '一致性', '完整性', '安全性 ', 'D', 0, 4),
(58, '下列SQL语句中，能够实现“收回用户ZHAO对学生表（STUD）中学号（XH）的修改权”这一功能的是       ', 'REVOKE UPDATE(XH) ON TABLE FROM ZHAO ', 'REVOKE UPDATE(XH) ON TABLE FROM PUBLIC', 'REVOKE UPDATE(XH) ON STUD FROM ZHAO ', 'REVOKE UPDATE(XH) ON STUD FROM PUBLIC', 'C', 0, 4),
(59, '把对关系SC的属性GRADE的修改权授予用户ZHAO的SQL语句是                  ', 'GRANT GRADE ON SC TO ZHAO  ', 'GRANT UPDATE ON SC TO ZHAO', 'GRANT UPDATE (GRADE) ON SC TO ZHAO', 'GRANT UPDATE ON SC (GRADE) TO ZHAO ', 'C', 0, 4),
(60, '在SQL Server 中删除触发器用（　　）。', 'ROLLBACK  ', 'DROP', 'DELALLOCATE', 'DELETE', 'B', 0, 4),
(61, '在数据库系统中，保证数据及语义正确和有效的功能是 （     ）', '并发控制', '存取控制', '安全控制', '完整性控制', 'D', 0, 5),
(62, '关于主键约束以下说法错误的是（ 　）', '一个表中只能设置一个主键约束', '允许空值的字段上不能定义主键约束', '允许空值的字段上可以定义主键约束', '可以将包含多个字段的字段组合设置为主键', 'C', 0, 5),
(63, '在表或视图上执行除了（ 　）以外的语句都可以激活触发器', 'Insert ', 'Delete ', 'Update', 'Create  ', 'D', 0, 5),
(64, '数据库的____是指数据的正确性和相容性。', '安全性', '完整性', '并发控制', '恢复', 'B', 0, 5),
(65, '在数据库的表定义中，限制成绩属性列的取值在0到100的范围内，属于数据的________约束。', '实体完整性', '参照完整性', '用户自定义', '用户操作', 'C', 0, 5),
(66, '关系规范化中的删除操作异常是指          ', '不该删除的数据被删除', '不该插入的数据被插入', '应该删除的数据未被删除', '应该插入的数据未被插入', 'A', 0, 6),
(67, '关系规范化中的插入操作异常是指          ', '不该删除的数据被删除', '不该插入的数据被插入', '应该删除的数据未被删除', '应该插入的数据未被插入', 'D', 0, 6),
(68, '设计性能较优的关系模式称为规范化，规范化主要的理论依据是           。', '关系规范化理论', '关系运算理论', '关系代数理论', '数理逻辑', 'A', 0, 6),
(69, '规范化过程主要为克服数据库逻辑结构中的插入异常，删除异常以及           的缺陷。', '数据的不一致性', '结构不合理', '冗余度大', '数据丢失', 'C', 0, 6),
(70, '当关系模式R(A，B)已属于3NF，下列说法中           是正确的。', '它一定消除了插入和删除异常', '仍存在一定的插入和删除异常', '一定属于BCNF', 'A和C都是', 'B', 0, 6),
(71, '关系模型中的关系模式至少是           。', '1NF', '2NF', '3NF ', 'BCNF', 'A', 0, 6),
(72, '在关系DB中，任何二元关系模式的最高范式必定是           。', '1NF', '2NF', '3NF', 'BCNF', 'D', 0, 6),
(73, '在关系模式R中，若其函数依赖集中所有候选关键字都是决定因素，则R最高范式是            。', '2NF', '3NF', '4NF', 'BCNF ', 'C', 0, 6),
(74, '候选关键字中的属性称为           。', '非主属性 ', '主属性', '复合属性', '关键属性', 'B', 0, 6),
(75, '消除了部分函数依赖的1NF的关系模式，必定是            。', '1NF   ', '2NF', '3NF', '4NF', 'B', 0, 6),
(76, '关系模式的候选关键字可以有    ', '0个 ', '1个', '1个或多个', '多个', 'C', 0, 6),
(77, '关系模式的主关键字有  。', '0个 ', '1个 ', '1个或多个', '多个', 'B', 0, 6),
(78, '根据关系数据库规范化理论，关系数据库中的关系要满足第一范式。下面“部门”关系中，因哪个属性而使它不满足第一范式?            。\r\n    部门(部门号，部门名，部门成员，部门总经理)\r\n', '部门总经理', '部门成员', '部门名  ', '部门号 ', 'B', 0, 6),
(79, '在数据库设计中，用E-R图来描述信息结构但不涉及信息在计算机中的表示，它是数据库设计的             阶段。', '需求分析', '概念设计', '逻辑设计	', '物理设计', 'B', 0, 7),
(80, '在关系数据库设计中，设计关系模式是              的任务。', '需求分析阶段', '概念设计阶段', '逻辑设计阶段	', '物理设计阶段', 'C', 0, 7),
(81, '数据库物理设计完成后，进入数据库实施阶段，下列各项中不属于实施阶段的工作是                。', '建立库结构', '扩充功能	', '加载数据	', '系统调试', 'B', 0, 7),
(82, '在数据库的概念设计中，最常用的数据模型是               。', '形象模型', '物理模型', '逻辑模型	', '实体联系模型', 'D', 0, 7),
(83, '从E-R模型关系向关系模型转换时，一个M∶N联系转换为关系模型时，该关系模式的关键字是               。', 'M端实体的关键字	', 'N端实体的关键字', 'M端实体关键字与N端实体关键字组合	', '重新选取其他属性 ', 'C', 0, 7),
(84, '当局部E-R图合并成全局E-R图时可能出现冲突，不属于合并冲突的是            。', '属性冲突	', '语法冲突', '结构冲突', '命名冲突 ', 'B', 0, 7),
(85, '概念模型独立于                       。', 'E-R模型', '硬件设备和DBMS', '操作系统和DBMS', 'DBMS', 'B', 0, 7),
(86, '数据流程图（DFD）是用于描述结构化方法中                阶段的工具。', '可行性分析', '详细设计', '需求分析', '程序编码', 'C', 0, 7),
(87, '              是DBMS的基本单位，它是用户定义的一组逻辑一致的程序序列。', '程序', '命令', '事务', '文件 ', 'C', 0, 10),
(88, '事务的原子性是指                                               。', '事务中包括的所有操作要么都做，要么都不做    ', '事务一旦提交，对数据库的改变是永久的', '一个事务内部的操作及使用的数据对并发的其他事务是隔离的', '事务必须是使数据库从一个一致性状态变到另一个一致性状态', 'A', 0, 10),
(89, '事务的一致性是指                                              。', '事务中包括的所有操作要么都做，要么都不做', '事务一旦提交，对数据为的改变是永久的', '一个事务内部的操作及使用的数据对并发的其他事务是隔离的', '事务必须是使数据库从一个一致性状态变到另一个一致性状态', 'D', 0, 10),
(90, '事务的隔离性是指                                             。', '事务中包括的所有操作要么都做，要么都不做', '事务一旦提交，对数据库的改变是永久的', '一个事务内部的操作及使用的数据对并发的其他事务是隔离的', '事务必须是使数据库从一个一致性状态变到另一个一致性状态', 'C', 0, 10),
(91, '事务的持续性是指                                         。', '事务中包括的所有操作要么都做，要么都不做', '事务一旦提交，对数据库的改变是永久的', '一个事力内部的操作及使用的数据对并发的其他事务是隔离的', '事务必须是使数据库从一个一致性状态变到另一个一致性状态', 'B', 0, 10),
(92, '若数据库中只包含成功事务提交的结果，则此数据库就称为处于                状态。', '安全', '一致', '不安全', '不一致 ', 'B', 0, 10),
(93, '若系统在运行过程中，由于某种原因，造成系统停止运行，致使事务在执行过程中以非控制方式终止，这时内存中的信息丢失，而存储在外存上的数据未受影响，这种情况称为                  。', '事务故障', '系统故障', '介质故障', '运行故障 ', 'B', 0, 10),
(94, '若系统在运行过程中，由于某种硬件故障，使存储在外存上的数据部分损失或全部损失，这种情况称为                   。', '事务故障', '系统故障	', '介质故障	', '运行故障', 'C', 0, 10),
(95, '               用来记录对数据库中数据进行的每一次更新操作。', '后援副本	', '日志文件	', '数据库', '缓冲区', 'B', 0, 10),
(96, '用于数据库恢复的重要文件是                              。', '数据库文件', '索引文件', '日志文件', '备注文件 ', 'C', 0, 10),
(97, '数据库恢复的基础是利用转储的冗余数据。这些转储的冗余数据包括            。', '数据字典、应用程序、审计档案、数据库后备副本', '数据字典、应用程序、日志文件、审计档案', '日志文件、数据库后备副本  ', '数据字典、应用程序、数据库后备副本', 'C', 0, 10),
(98, '解决并发操作带来的数据不一致性总是普遍采用              。', '封锁		', '恢复', '存取控制', '协商 ', 'A', 0, 11),
(99, '若事务T对数据R已经加X锁，则其他事务对数据R                   。', '可以加S锁不能加X锁', '不能加S锁可以加X锁 ', '可以加S锁也可以加X锁	', '不能加任何锁 ', 'D', 0, 11),
(100, '关于“死锁”，下列说法中正确的是                         。', '死锁是操作系统中的问题，数据库操作中不存在', '在数据库操作中防止死锁的方法是禁止两个用户同时操作数据库', '当两个用户竞争相同资源时不会发生死锁', '只有出现并发操作时，才有可能出现死锁', 'D', 0, 11);

-- --------------------------------------------------------

--
-- 表的结构 `class`
--

CREATE TABLE `class` (
  `classid` bigint(20) NOT NULL,
  `tid` bigint(20) NOT NULL,
  `classname` char(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- 转存表中的数据 `class`
--

INSERT INTO `class` (`classid`, `tid`, `classname`) VALUES
(1, 1, '15网工'),
(2, 3, '15计创'),
(3, 3, '15计联'),
(4, 2, '15计科1'),
(5, 2, '15计科2'),
(6, 1, '15信安');

-- --------------------------------------------------------

--
-- 表的结构 `evadba`
--

CREATE TABLE `evadba` (
  `id` bigint(20) NOT NULL,
  `title` varchar(20) COLLATE utf8mb4_bin NOT NULL DEFAULT '无名题',
  `question` varchar(300) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `intable` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `rightanswer` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- 转存表中的数据 `evadba`
--

INSERT INTO `evadba` (`id`, `title`, `question`, `type`, `intable`, `rightanswer`) VALUES
(1, '小试牛刀', '已知有一个学生（students）表，有sno，sname，sex，height等属性，查询身高大于1.80m的男生的学号和姓名；', '查找题', 'null', '\r\nSELECT SNO,SNAME FROM students WHERE SEX=\'男\' AND HEIGHT>1.80;'),
(2, '稳步提升', '已知有一个课程（courses）表，有cno，cname，lhour，credit，semester等属性，查询计算机系秋季所开课程的课程号和学分数；', '查找题', 'null', 'SELECT CNO, CREDIT FROM Courses \r\nWHERE CNO LIKE \'CS%\' AND SEMESTER=\'秋\';'),
(3, '突飞猛进', '已知有一个学生（students）表，有sno，sname等属性；有一个课程（courses）表，有cno，cname，credit等属性；有一个学生选课（sc）表，有sno，cno，grade等属性。查询选修计算机系秋季所开课程的男生的姓名、课程号、学分数、成绩；', '查找题', 'null', 'SELECT SNAME, Courses.CNO, CREDIT, GRADE FROM students,Courses,SC\r\nWHERE students.SNO = SC.SNO AND Courses.CNO = SC.CNO\r\nAND Courses.CNO LIKE \'CS%\' AND SEMESTER=\'秋\';'),
(4, '名震四方', '已知有一个学生（students）表，有sno，sname，sex等属性；有一个课程（courses）表，有cno，cname等属性；有一个学生选课（sc）表，有sno，cno等属性。查询至少选修一门电机系课程的女生的姓名（假设电机系课程的课程号以EE开头）；', '查找题', 'null', 'SELECT SNAME  FROM students,Courses,SC\r\nWHERE students.SNO = SC.SNO AND Courses.CNO = SC.CNO\r\nAND Courses.CNO LIKE \'EE%\' AND SEX=\'女\';'),
(5, '出来吧成绩', '已知有一个学生（students）表，有sno，sname等属性；有一个学生选课（sc）表，有sno，cno，grade等属性。查询每位学生已选修课程的门数和总平均成绩；', '查找题', 'null', 'SELECT students.SNO,COUNT(*),AVG(sc. GRADE ) FROM Students,SC WHERE students.SNO = SC.SNO GROUP BY students.SNO'),
(6, '无名题', '已知有一个课程（courses）表，有cno，cname，credit等属性；有一个学生选课（sc）表，有sno，cno，grade等属性。查询每门课程选课的学生人数,最高成绩,最低成绩和平均成绩；', '查找题', 'null', 'SELECT Courses.CNO, COUNT(*)as \'学生人数\',MAX(GRADE),MIN(GRADE),AVG(GRADE) FROM SC,Courses\r\nWHERE  Courses.CNO = SC.CNO\r\nGROUP BY Courses.CNO;'),
(7, '出来吧学霸', '已知有一个学生（students）表，有sno，sname等属性；有一个学生选课（sc）表，有sno，cno，grade等属性。查询所有课程的成绩都在80分以上的学生的姓名、学号、且按学号升序排列；', '查找题', 'null', 'SELECT SNAME,students.SNO FROM Students,SC\r\nWHERE  students.SNO = SC.SNO \r\nGROUP BY students.SNO\r\nHAVING MIN(GRADE) >=80\r\nORDER BY students.SNO ASC;'),
(8, '你缺考我看到了', '已知有一个学生（students）表，有sno，sname等属性；有一个课程（courses）表，有cno，cname，credit等属性；有一个学生选课（sc）表，有sno，cno，grade等属性。查询缺成绩的学生的姓名，缺成绩的课程号及其学分数；', '查找题', 'null', 'SELECT SNAME, Courses.CNO, CREDIT FROM students,Courses,SC\r\nWHERE students.SNO = SC.SNO AND Courses.CNO = SC.CNO\r\nAND GRADE=NULL'),
(9, '你考得差我都看到了', '已知有一个学生（students）表，有sno，sname等属性；有一个课程（courses）表，有cno，cname，credit等属性；有一个学生选课（sc）表，有sno，cno，grade等属性。查询有一门以上(含一门)三个学分以上课程的成绩低于70分的学生的姓名；', '查找题', 'null', 'SELECT DISTINCT SNAME\r\nFROM students,SC,Courses\r\nWHERE students.SNO = SC.SNO\r\nAND Courses.CNO = SC.CNO\r\nAND Courses.CREDIT >=3\r\nAND GRADE <70\r\n'),
(10, '有名题', '已知有一个学生（students）表，有sno，sname，bdate等属性；有一个课程（courses）表，有cno，cname，credit等属性；有一个学生选课（sc）表，有sno，cno，grade等属性。查询1984年~1986年出生的学生的姓名,总平均成绩及已修学分数。', '查找题', 'null', 'SELECT SNAME,AVG(GRADE),SUM(CREDIT) FROM students,Courses,SC\r\nWHERE students.SNO = SC.SNO AND Courses.CNO = SC.CNO\r\nAND  BDATE > \'1984-01-01\' AND BDATE< \'1987-01-01\'\r\nGROUP BY Students.SNO'),
(11, '消失的学生', '已知有Students数据库包含如下表：\r\nStudents(sno,sname,sex,bdate,height,department)\r\nCourses(cno,cname,lhour,credit,semester)\r\nSC(sno,cno,grade)\r\n在students和sc关系中，删去sno以’20153031’头的所有记录。', '删除题', 'students,sc', 'DELETE SC,Students FROM SC JOIN Students ON SC.SNO = Students.SNO\r\nWHERE SC.SNO LIKE \'20153031%\';'),
(12, '神秘插班生', '已知有Students数据库包含如下表：\r\nStudents(sno,sname,sex,bdate,height,department)\r\nCourses(cno,cname,lhour,credit,semester)\r\nSC(sno,cno,grade)\r\n在students关系中增加以下记录：\r\n     <04091011111  何平　　女　　1987-03-02　　1.62  cs>\r\n     <04081300000  向阳　　男　　1986-12-11　　1.75  cs>', '插入题', 'students', 'INSERT INTO `students` (`SNO`, `SNAME`, `SEX`, `BDATE`, `HEIGHT`) VALUES \r\n(\'0409101\',\'何平\',\'女\',\'1987-03-02\',1.62),(\'0408130\',\'向阳\',\'男\',\'1986-12-11\',1.75);'),
(13, 'good good study', '已知有Students数据库包含如下表：\r\nStudents(sno,sname,sex,bdate,height,department)\r\nCourses(cno,cname,lhour,credit,semester)\r\nSC(sno,cno,grade)\r\n在courses关系中，将课程CS-221的学分数增为３，讲课时数增为６０', '更新题', 'sc', 'update Courses SET CREDIT=3,LHOUR=60 WHERE CNO=\'CS-221\';\r\n'),
(14, '消失的一米六', '已知有Students数据库包含如下表：\r\nStudents(sno,sname,sex,bdate,height,department)\r\nCourses(cno,cname,lhour,credit,semester)\r\nSC(sno,cno,grade)\r\n在students和sc关系中，删去身高为’1.6’的所有记录。', '删除题', 'students,sc', 'DELETE SC,Students FROM SC JOIN Students ON SC.SNO = Students.SNO\r\nWHERE students.height=\'1.6\';'),
(15, '又多了一门课', '已知有Students数据库包含如下表：\r\nStudents(sno,sname,sex,bdate,height,department)\r\nCourses(cno,cname,lhour,credit,semester)\r\nSC(sno,cno,grade)\r\n在courses表中增加一门课程，它的记录为：\r\n <C6  操作系统  64  4  秋 >', '插入题', 'courses', 'INSERT INTO `courses` (`cno`, `cname`, `lhour`, `credit`, `semester`) VALUES \r\n(\'C6\',\'操作系统\',64,4,\'秋\');'),
(16, '偷偷改成绩小游戏', '已知有Students数据库包含如下表：\r\nStudents(sno,sname,sex,bdate,height,department)\r\nCourses(cno,cname,lhour,credit,semester)\r\nSC(sno,cno,grade)\r\n在sc关系中，将学号为201530311042，课程号为C1的记录的成绩改为80;', '更新题', 'sc', 'update sc SET grade=80 WHERE sno=’201530311042\' and CNO=\'C1\';'),
(17, '变成女校', '已知有Students数据库包含如下表：\r\nStudents(sno,sname,sex,bdate,height,department)\r\nCourses(cno,cname,lhour,credit,semester)\r\nSC(sno,cno,grade)\r\n删除Students，SC中sex为男的学生记录', '删除题', 'students,sc', 'DELETE SC,Students FROM SC JOIN Students ON SC.SNO = Students.SNO\r\nWHERE students.height=\'1.6\';'),
(18, '开心消消乐', '已知有Students数据库包含如下表：\r\nStudents(sno,sname,sex,bdate,height,department)\r\nCourses(cno,cname,lhour,credit,semester)\r\nSC(sno,cno,grade)\r\n删除SC中grade>=90的成绩记录', '删除题', 'sc', 'DELETE * FROM SC where grade>=90;'),
(19, '再接再厉', '已知有Students数据库包含如下表：\r\nSC(sno,cno,grade)\r\n将学号为201530371190选修的EE4课程成绩改成59', '更新题', 'sc', 'update sc set grade=59 where sno=\'201530371190\' and cno=\'EE4\';'),
(20, '普通的更新题1', '已知有Students数据库包含如下表：\r\nStudents(sno,sname,sex,bdate,height,department)\r\nCourses(cno,cname,lhour,credit,semester)\r\nSC(sno,cno,grade)\r\n将1984年~1986年出生的学生的成绩更新为90', '更新题', 'students,sc', 'update sc,students set grade=90 \r\nwhere BDATE > \'1984-01-01\' AND BDATE< \'1987-01-01\';'),
(21, '考完一门', '已知有Students数据库包含如下表：\r\nStudents(sno,sname,sex,bdate,height,department)\r\nCourses(cno,cname,lhour,credit,semester)\r\nSC(sno,cno,grade)\r\n插入学号为201530311042的课程号为EE4，成绩为61的成绩记录', '插入题', 'sc', 'insert into sc values(\'201530311042\',\'EE4\',61);'),
(22, '女装大佬の潜入', '已知有Students数据库包含如下表：\r\nStudents(sno,sname,sex,bdate,height,department)\r\nCourses(cno,cname,lhour,credit,semester)\r\nSC(sno,cno,grade)\r\n将姓张的学生性别改成女', '更新题', 'students', 'update students set sex=\'女\'\r\nwhere sname like \'张%\';'),
(23, '普通的更新题2', '已知有Students数据库包含如下表：\r\nStudents(sno,sname,sex,bdate,height,department)\r\nCourses(cno,cname,lhour,credit,semester)\r\nSC(sno,cno,grade)\r\n将编译原理的学时改为60', '更新题', 'courses', 'update Courses set lhour=60\r\nwhere cname=\'编译原理\';'),
(24, '平平无奇的插入题1', '已知有Students数据库包含如下表：\r\nStudents(sno,sname,sex,bdate,height,department)\r\nCourses(cno,cname,lhour,credit,semester)\r\nSC(sno,cno,grade)\r\n插入学号为201530311042的课程号为EE4，成绩为59的成绩记录', '插入题', 'sc', 'insert into sc values(\'201530311042\',\'EE4\',59);'),
(25, '变成男校', '已知有Students数据库包含如下表：\r\nStudents(sno,sname,sex,bdate,height,department)\r\nCourses(cno,cname,lhour,credit,semester)\r\nSC(sno,cno,grade)\r\n删除Students，SC中sex为女的学生记录', '删除题', 'students,sc', 'DELETE SC,Students FROM SC JOIN Students ON SC.SNO = Students.SNO\r\nWHERE students.sex=\'女\';'),
(26, '平平无奇的插入题2', '已知有Students数据库包含如下表：\r\nStudents(sno,sname,sex,bdate,height,department)\r\n在students关系中增加以下记录：\r\n     <04091011098  卡比兽　　男　　2017-03-02　　1.62  null>', '插入题', 'students', 'INSERT INTO `students` (`SNO`, `SNAME`, `SEX`, `BDATE`, `HEIGHT`) VALUES \r\n(\'04091011098\',\'卡比兽\',\'男\',\'2017-03-02\',1.62\');'),
(27, '又又多了一门课', '已知有一个课程（courses）表，有cno，cname，lhour，credit，semester等属性\r\n增加一门课程：<EE6  成功学  64  4  秋 >', '插入题', 'courses', 'INSERT INTO `courses` (`cno`, `cname`, `lhour`, `credit`, `semester`) VALUES \r\n(\'EE6\',\'成功学\',64,4,\'秋\');');

-- --------------------------------------------------------

--
-- 表的结构 `judgedba`
--

CREATE TABLE `judgedba` (
  `id` bigint(20) NOT NULL,
  `question` varchar(500) COLLATE utf8_bin NOT NULL,
  `rightanswer` varchar(2) COLLATE utf8_bin NOT NULL,
  `secrecy` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- 转存表中的数据 `judgedba`
--

INSERT INTO `judgedba` (`id`, `question`, `rightanswer`, `secrecy`) VALUES
(1, '数据是表示信息的具体形式，信息是数据表达的内容。', 'T', 0),
(2, '在数据库的三级模式结构中内模式可以有多个。', 'F', 0),
(3, '数据独立性指数据的存储与应用程序无关，数据存储结构的改变不影响应用程序的正常运行。', 'T', 0),
(4, '当数据库的存储结构改变了，由数据库管理员对模式／内模式映射作相应改变，可以使模式保持不变，从而保证了数据的物理独立性。', 'T', 0),
(5, '数据处理是将信息转换成数据的过程。', 'F', 0),
(6, '数据库在计算机系统中不是以文件方式存储的。', 'F', 0),
(7, '数据库系统其实就是一个应用软件。', 'F', 0),
(8, '三级模式结构也就是从逻辑上对数据库的组织从内到外进行的3个层次描述。', 'T', 0),
(9, '三级模式间存在三个映射关系。', 'F', 0),
(10, 'DBMS不需要操作系统的支持就可以实现其功能。', 'F', 0),
(11, '用二维表结构表示实体型，外键实现实体之间联系的模型称为关系模型。', 'T', 0),
(12, '关系模型不能表示实体之间多对多联系。', 'F', 0),
(13, '任何一张二维表格都表示一个关系。', 'F', 0),
(14, '关系是元组的集合。', 'T', 0),
(15, '域是一组具有相同数据类型的值的集合。', 'T', 0),
(16, '一个域允许的不同取值个数称为这个域的基数.', 'T', 0),
(17, 'D1×D2×…×Dn的子集叫作在域D1，D2，…，Dn上的关系，表示为R（D1，D2，…，Dn）', 'T', 0),
(18, '超码/超键(superkey)能唯一地标识关系中的一个元组的一属性组', 'T', 0),
(19, '候选码（Candidate key）若关系中的某一属性组的值能唯一地标识一个元组，而其子集不能，则称该属性组为候选r码。', 'T', 0),
(20, '若一个关系有多个候选码，则选定其中一个为主码（Primary key）', 'T', 0);

-- --------------------------------------------------------

--
-- 表的结构 `paper`
--

CREATE TABLE `paper` (
  `id` bigint(20) NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `begintime` datetime NOT NULL,
  `finishtime` datetime NOT NULL,
  `choi` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `judg` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `sub` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `choiscore` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `judgscore` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `subscore` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `tid` bigint(20) DEFAULT NULL,
  `classid` varchar(100) COLLATE utf8mb4_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- 转存表中的数据 `paper`
--

INSERT INTO `paper` (`id`, `name`, `begintime`, `finishtime`, `choi`, `judg`, `sub`, `choiscore`, `judgscore`, `subscore`, `tid`, `classid`) VALUES
(1, '数据库平时练习第一次', '2017-12-09 18:00:00', '2018-12-09 19:00:00', '1,2,3,4,5,6,7,8,9,10', '1,2,3,4,5,', '1,2,3,4,5', '4,4,4,4,4,4,4,4,4,4', '4,4,4,4,4', '8,8,8,8,8', 1, '[|1|,|2|,|3|]'),
(2, '数据库平时练习第二次', '2017-12-09 19:00:00', '2018-12-09 20:00:00', '2,3,4,5,6,7,8,9,10,11', '2,3,4,5,6', '2,3,4,5,6', '4,4,4,4,4,4,4,4,4,4', '4,4,4,4,4', '8,8,8,8,8', 2, '[|1|,|2|]'),
(3, '数据库平时练习第三次', '2017-12-10 14:00:00', '2018-12-10 15:00:00', '21,22,23,24,25,26,27,28,29,30', '3,4,5,6,7', '1,2,3,4,5', '4,4,4,4,4,4,4,4,4,4', '4,4,4,4,4', '8,8,8,8,8', 3, '[|1|,|2|,|4|,|6|,|3|,|5|]'),
(4, '数据库平时练习第四次', '2017-12-09 15:00:00', '2018-12-09 16:00:00', '22,23,24,25,26,27,28,29,30,31', '4,5,6,7,8', '2,3,4,5,6', '4,4,4,4,4,4,4,4,4,4', '4,4,4,4,4', '8,8,8,8,8', 1, '[|1|,|5|,|2|,|3|]'),
(5, '数据库平时练习第五次', '2017-12-09 15:00:00', '2018-12-09 16:00:00', '22,23,24,25,26,27,28,29,30,31', '4,5,6,7,8', '1,3,4,5,6', '4,4,4,4,4,4,4,4,4,4', '4,4,4,4,4', '8,8,8,8,8', 1, '[|1|,|4|]'),
(6, '数据库期中考试', '2017-12-11 19:00:00', '2018-12-11 20:00:00', '1,11,21,31,41,51,61,71,81,91', '1,3,5,7,9', '1,3,5,7,9', '4,4,4,4,4,4,4,4,4,4', '4,4,4,4,4', '8,8,8,8,8', 2, '[|1|,|3|]'),
(7, '数据库期末考试', '2017-12-20 19:00:00', '2018-12-20 20:00:00', '2,12,22,32,42,52,62,72,82,92', '2,4,6,8,10', '2,4,6,8,10', '4,4,4,4,4,4,4,4,4,4', '4,4,4,4,4', '8,8,8,8,8', 1, '[|1|,|2|,|4|,|6|,|3|,|5|]');

-- --------------------------------------------------------

--
-- 表的结构 `record`
--

CREATE TABLE `record` (
  `sid` bigint(20) NOT NULL,
  `pid` bigint(20) NOT NULL,
  `record` varchar(5000) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `status` varchar(4) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `score` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- 转存表中的数据 `record`
--

INSERT INTO `record` (`sid`, `pid`, `record`, `status`, `score`) VALUES
(1, 1, '', '已批改', 20),
(2, 1, '{\"cho_1\":\"B\",\"cho_4\":\"C\",\"cho_5\":\"C\",\"cho_6\":\"D\",\"cho_2\":\"A\",\"cho_8\":\"C\",\"tf_2\":\"T\",\"tf_4\":\"T\",\"tf_6\":\"T\",\"sub_1\":\"zxcdscsd\",\"sub_2\":\"asd \",\"sub_3\":\"打撒大三的思维卫峰\",\"sub_4\":\"额分分\",\"sub_5\":\"第三次多少\"}', '已批改', 20),
(3, 1, '', '已批改', 10),
(4, 1, '', '已批改', 40),
(5, 1, '', '已批改', 50),
(6, 1, '', '已批改', 80),
(1, 2, '', '已批改', 80),
(2, 2, '{\"cho_3\":\"B\",\"cho_6\":\"C\",\"cho_2\":\"A\",\"cho_4\":\"A\",\"cho_5\":\"C\",\"cho_7\":\"B\",\"cho_8\":\"A\",\"cho_11\":\"A\",\"cho_10\":\"C\",\"cho_9\":\"B\",\"tf_3\":\"T\",\"tf_4\":\"T\",\"tf_2\":\"T\",\"tf_6\":\"T\",\"tf_5\":\"T\",\"sub_2\":\"是是是\",\"sub_4\":\"好好好\",\"sub_6\":\"对对对\",\"sub_5\":\"嗯嗯嗯\",\"sub_3\":\"呵呵呵呵呵呵\"}', '已批改', 60),
(3, 2, '', '已批改', 50),
(5, 2, '', '已批改', 55),
(6, 2, '', '已批改', 30),
(2, 3, '{\"cho_21\":\"B\",\"cho_26\":\"A\",\"cho_27\":\"D\",\"cho_28\":\"C\",\"cho_30\":\"A\",\"cho_22\":\"A\",\"cho_23\":\"A\",\"cho_25\":\"A\",\"cho_29\":\"A\",\"cho_24\":\"A\",\"tf_3\":\"T\",\"tf_5\":\"T\",\"tf_4\":\"T\",\"tf_6\":\"T\",\"tf_7\":\"T\",\"sub_4\":\"没有\",\"sub_3\":\"不知道\",\"sub_1\":\"母鸡 \",\"sub_5\":\"不懂\",\"sub_2\":\"哈哈哈哈哈哈哈\"}', '已批改', 28),
(5, 3, '{\"cho_21\":\"B\",\"cho_26\":\"A\",\"sub_1\":\"\",\"sub_2\":\"\",\"sub_4\":\"\",\"sub_3\":\"\",\"sub_5\":\"\"}', '已批改', 0),
(2, 4, '', '已批改', 90),
(2, 5, '{\"cho_26\":\"C\",\"cho_22\":\"B\",\"cho_27\":\"B\",\"cho_25\":\"A\",\"cho_23\":\"A\",\"cho_30\":\"B\",\"cho_29\":\"D\",\"cho_28\":\"C\",\"cho_31\":\"B\",\"cho_24\":\"B\",\"tf_5\":\"T\",\"tf_4\":\"T\",\"tf_7\":\"T\",\"tf_6\":\"T\",\"tf_8\":\"T\",\"sub_1\":\"123\",\"sub_3\":\"234\",\"sub_4\":\"345\",\"sub_5\":\"567\",\"sub_6\":\"888\"}', '已批改', 31),
(2, 6, '{\"cho_1\":\"A\",\"cho_41\":\"B\",\"cho_51\":\"B\",\"sub_1\":\"\",\"sub_undefined\":\"\"}', '已批改', 100),
(3, 7, '{\"cho_2\":\"D\",\"cho_22\":\"B\",\"cho_12\":\"B\",\"cho_62\":\"B\",\"cho_32\":\"B\",\"cho_52\":\"A\",\"cho_72\":\"C\",\"cho_82\":\"B\",\"cho_92\":\"D\",\"tf_2\":\"T\",\"tf_4\":\"T\",\"tf_6\":\"T\",\"tf_8\":\"T\",\"tf_10\":\"T\",\"sub_4\":\"qqqqrve\",\"sub_6\":\"adsdsvrve\",\"sub_2\":\"asdvdevrerve\",\"sub_8\":\"rvfdvfdververev\",\"sub_10\":\"dfvsdfverevr\"}', '已批改', 22),
(4, 7, '{\"cho_2\":\"B\",\"cho_32\":\"C\",\"cho_42\":\"B\",\"cho_22\":\"C\",\"cho_52\":\"D\",\"cho_92\":\"B\",\"cho_62\":\"B\",\"cho_72\":\"B\",\"tf_4\":\"T\",\"tf_2\":\"T\",\"tf_10\":\"T\",\"tf_6\":\"T\",\"tf_8\":\"T\",\"sub_2\":\"dscsdcwewfsdf\",\"sub_6\":\"\",\"sub_8\":\"dascaewcaawaef\",\"sub_4\":\"acecwedscsaewf\",\"sub_10\":\"wecwaecwecaewf\"}', '已批改', 36);

-- --------------------------------------------------------

--
-- 表的结构 `status`
--

CREATE TABLE `status` (
  `runid` bigint(20) NOT NULL,
  `eid` bigint(20) NOT NULL,
  `uid` bigint(20) NOT NULL,
  `sql2` varchar(300) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `time` datetime NOT NULL,
  `status` varchar(300) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- 转存表中的数据 `status`
--

INSERT INTO `status` (`runid`, `eid`, `uid`, `sql2`, `time`, `status`) VALUES
(1, 1, 2, 'SELECT SNO,SNAME FROM students WHERE SEX=\'男\' AND HEIGHT>1.80;', '2017-12-08 07:00:00', '回答正确'),
(2, 11, 2, 'delete * from students,sc where sno like \'20153031%\';', '2017-12-10 17:46:20', 'SQL语句出错：Can not issue data manipulation statements with executeQuery().'),
(3, 1, 2, 'select * from you;', '2017-12-10 18:51:23', 'SQL语句出错：Table \'dbtest.you\' doesn\'t exist'),
(4, 1, 2, 'select * from students Where height >1.8 and sex = \'男\'', '2017-12-10 18:52:15', 'SQL语句出错：You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near \'null\' at line 1'),
(5, 1, 2, 'select * from students where height >1.8 and sex = \'男\'', '2017-12-10 18:54:54', 'SQL语句出错：You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near \'null\' at line 1'),
(6, 1, 2, 'select * from students where height >1.8 and sex = \'男\'', '2017-12-10 18:56:13', 'SQL语句出错：You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near \'null\' at line 1'),
(7, 1, 2, 'select * from students where height > 1.8 and sex = \'男\'', '2017-12-10 19:01:49', '答案错误，你真笨!'),
(8, 1, 2, 'select  sno,sname from students where height > 1.8 and sex = \'男\';', '2017-12-10 19:02:37', '答案正确，你真棒！'),
(9, 11, 2, 'selete * from students,sc where sno like \'20153031%\'', '2017-12-10 19:04:49', 'SQL语句出错：You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near \'selete * from students,sc where sno like \'20153031%\'\' at line 1'),
(10, 11, 2, 'delete sc,students from sc join students on sc.sno = students.sno\r\nwhere sc.sno like \'20153031%\';', '2017-12-10 19:05:16', 'SQL语句出错：Lock wait timeout exceeded; try restarting transaction'),
(11, 11, 2, 'delete sc,students from sc join students on sc.sno = students.sno\r\nwhere sc.sno like \'20153031%\';', '2017-12-10 19:05:21', 'SQL语句出错：Lock wait timeout exceeded; try restarting transaction'),
(12, 11, 2, 'delete * from sc;', '2017-12-10 19:11:43', 'SQL语句出错：You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near \'* from sc\' at line 1'),
(13, 1, 2, 'select * from students;;', '2017-12-10 19:12:06', '答案错误，你真笨!'),
(14, 11, 2, 'delete  from sc where 1; ', '2017-12-10 19:12:28', 'SQL语句出错：Lock wait timeout exceeded; try restarting transaction'),
(15, 11, 2, 'delete from sc where 1;', '2017-12-10 19:21:57', '答案错误，你真笨!'),
(16, 11, 2, 'delete * from students', '2017-12-10 19:23:29', 'SQL语句出错：You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near \'* from students\' at line 1'),
(17, 11, 2, 'delete from students where 1', '2017-12-10 19:23:45', 'SQL语句出错：Lock wait timeout exceeded; try restarting transaction'),
(18, 11, 2, 'delete from students', '2017-12-10 19:27:06', 'SQL语句出错：Cannot delete or update a parent row: a foreign key constraint fails (`dbtest`.`sc`, CONSTRAINT `sc_ibfk_1` FOREIGN KEY (`SNO`) REFERENCES `students` (`SNO`))'),
(19, 11, 2, 'delete from students where 1', '2017-12-10 19:27:20', 'SQL语句出错：Lock wait timeout exceeded; try restarting transaction'),
(20, 11, 2, 'delete from sc where 1', '2017-12-10 19:36:02', '答案错误，你真笨!'),
(21, 1, 2, 'delete from sc where 1', '2017-12-10 19:36:29', 'SQL语句出错：Can not issue data manipulation statements with executeQuery().'),
(22, 11, 2, 'delete from sc where 1', '2017-12-10 19:37:05', '答案错误，你真笨!'),
(23, 11, 2, 'delete from sc where 1', '2017-12-10 19:37:12', '答案错误，你真笨!'),
(24, 11, 2, 'delete sc,students from sc join students on sc.sno = students.sno\r\nwhere sc.sno like \'20153031%\';', '2017-12-10 19:37:38', '答案错误，你真笨!'),
(25, 1, 2, 'delete sc,students from sc join students on sc.sno = students.sno\r\nwhere sc.sno like \'20153031%\';', '2017-12-10 19:38:00', 'SQL语句出错：Can not issue data manipulation statements with executeQuery().'),
(26, 11, 2, 'delete sc,students from sc join students on sc.sno = students.sno\r\nwhere sc.sno like \'20153031%\';', '2017-12-10 19:38:08', '答案错误，你真笨!'),
(27, 1, 2, 'select sname,sno from students where height > 1.8 and sex= \'男\'', '2017-12-10 19:43:28', '答案正确，你真棒！'),
(28, 5, 2, 'select * from you', '2017-12-10 19:44:27', 'SQL语句出错：Table \'dbtest.you\' doesn\'t exist'),
(29, 1, 2, 'drop database dbtest', '2017-12-10 19:49:36', 'SQL语句出错：Can not issue data manipulation statements with executeQuery().'),
(30, 15, 2, 'insert into courses values(\'C6\',\'操作系统\',\'64\',\'4\',\'秋\')', '2017-12-10 19:56:48', 'SQL语句出错：Lock wait timeout exceeded; try restarting transaction'),
(31, 15, 2, 'insert into courses values(\'C6\',\'操作系统\',\'64\',\'4\',\'秋\')', '2017-12-10 19:56:54', 'SQL语句出错：Lock wait timeout exceeded; try restarting transaction'),
(32, 12, 2, 'insert into courses values(\'c6\',\'操作系统\',\'64\',\'4\',\'秋\')', '2017-12-10 20:02:28', 'SQL语句出错：Duplicate entry \'0409101\' for key \'PRIMARY\''),
(33, 15, 2, 'insert into courses values(\'c6\',\'操作系统\',\'64\',\'4\',\'秋\')', '2017-12-10 20:02:41', 'SQL语句出错：Lock wait timeout exceeded; try restarting transaction'),
(34, 11, 2, 'DELETE SC,Students FROM SC JOIN Students ON SC.SNO = Students.SNO\r\nWHERE SC.SNO LIKE \'20153031%\';', '2017-12-10 20:05:15', 'SQL语句出错：Lock wait timeout exceeded; try restarting transaction'),
(35, 1, 2, 'select sname, sno from students where sex = \'男\' and height ? 1.8 and 1=1', '2017-12-10 23:23:21', 'SQL语句出错：You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near \'? 1.8 and 1=1\' at line 1'),
(36, 1, 2, 'select sname, sno from students where sex = \'男\' and height ? 1.8 and 1\'', '2017-12-10 23:23:43', 'SQL语句出错：You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near \'? 1.8 and 1\'\' at line 1'),
(37, 1, 2, 'select sname, sno from students where sex = \'男\' and height > 1.8 and 1=1', '2017-12-10 23:24:16', '答案正确，你真棒！'),
(38, 1, 2, 'select sname, sno from students where sex = \'男\' and height <1.8 and 1=1', '2017-12-10 23:24:31', '答案正确，你真棒！'),
(39, 1, 2, 'select sname, sno from students where sex = \'男\' and height < 1.8 and 1=1', '2017-12-10 23:24:45', '答案正确，你真棒！'),
(40, 1, 2, 'SELECT SNO,SNAME FROM students WHERE 1', '2017-12-10 23:27:00', '答案错误，你真笨!'),
(41, 1, 2, 'SELECT SNO,SNAME FROM students WHERE SEX=\'男\'', '2017-12-10 23:28:06', '答案正确，你真棒！'),
(42, 1, 2, 'select * from students', '2017-12-10 23:30:28', '答案错误，你真笨!'),
(43, 1, 2, 'SELECT SNO,SNAME FROM students WHERE SEX=\'男\' AND HEIGHT>1.80', '2017-12-10 23:30:44', '答案正确，你真棒！'),
(44, 14, 2, 'delete from students,sc where sc.sno=students.sno and height = 1.6', '2017-12-10 23:32:44', 'SQL语句出错：Cannot delete or update a parent row: a foreign key constraint fails (`dbtest1`.`sc`, CONSTRAINT `sc_ibfk_1` FOREIGN KEY (`SNO`) REFERENCES `students` (`SNO`))'),
(45, 1, 2, 'delete from students,sc where sc.sno=students.sno and height = 1.6', '2017-12-10 23:32:59', 'SQL语句出错：Can not issue data manipulation statements with executeQuery().'),
(46, 11, 2, '', '2017-12-10 23:35:53', '等待评测'),
(47, 11, 2, '', '2017-12-10 23:35:55', '等待评测'),
(48, 11, 2, '', '2017-12-10 23:36:29', '等待评测'),
(49, 11, 2, '', '2017-12-10 23:36:37', '等待评测'),
(50, 14, 2, '', '2017-12-10 23:37:47', 'SQL语句出错：Can not issue empty query.'),
(51, 14, 2, '', '2017-12-10 23:38:05', 'SQL语句出错：Lock wait timeout exceeded; try restarting transaction'),
(52, 14, 2, '', '2017-12-10 23:38:07', 'SQL语句出错：Can not issue empty query.'),
(53, 14, 2, '', '2017-12-10 23:38:09', 'SQL语句出错：Can not issue empty query.'),
(54, 14, 2, '', '2017-12-10 23:38:11', 'SQL语句出错：Lock wait timeout exceeded; try restarting transaction'),
(55, 11, 2, '', '2017-12-10 23:41:00', 'SQL语句出错：Lock wait timeout exceeded; try restarting transaction'),
(56, 1, 2, '', '2017-12-10 23:49:23', 'SQL语句出错：Can not issue empty query.'),
(57, 12, 2, '', '2017-12-10 23:49:31', 'SQL语句出错：No operations allowed after connection closed.'),
(58, 12, 2, '', '2017-12-10 23:49:38', 'SQL语句出错：No operations allowed after connection closed.'),
(59, 11, 2, '', '2017-12-10 23:49:51', 'SQL语句出错：No operations allowed after connection closed.'),
(60, 11, 2, '', '2017-12-10 23:49:59', 'SQL语句出错：No operations allowed after connection closed.'),
(61, 1, 2, '', '2017-12-10 23:51:25', 'SQL语句出错：Can not issue empty query.'),
(62, 11, 2, 'asdfdf', '2017-12-10 23:51:39', 'SQL语句出错：No operations allowed after connection closed.'),
(63, 1, 2, '', '2017-12-10 23:54:16', 'SQL语句出错：Can not issue empty query.'),
(64, 11, 2, '', '2017-12-10 23:54:27', 'SQL语句出错：No operations allowed after connection closed.'),
(65, 1, 2, '', '2017-12-10 23:55:18', 'SQL语句出错：Can not issue empty query.'),
(66, 14, 2, '', '2017-12-10 23:55:27', 'SQL语句出错：No operations allowed after connection closed.'),
(67, 1, 2, '', '2017-12-10 23:57:45', 'SQL语句出错：Can not issue empty query.'),
(68, 11, 2, '', '2017-12-10 23:59:03', 'SQL语句出错：No operations allowed after connection closed.'),
(69, 13, 2, '', '2017-12-11 00:00:15', 'SQL语句出错：Can not issue empty query.'),
(70, 13, 2, 'update courses set grade=3,hours=60 where cno =\'cs-221\'', '2017-12-11 00:01:11', 'SQL语句出错：Unknown column \'grade\' in \'field list\''),
(71, 1, 2, 'update courses set credit=3,hours=60 where cno =\'cs-221\'', '2017-12-11 00:01:46', 'SQL语句出错：Can not issue data manipulation statements with executeQuery().'),
(72, 13, 2, 'update courses set credit=3,hours=60 where cno =\'cs-221\'', '2017-12-11 00:01:57', 'SQL语句出错：Unknown column \'hours\' in \'field list\''),
(73, 13, 2, 'update courses set credit=3,Lhour=60 where cno =\'cs-221\'', '2017-12-11 00:02:24', '答案正确，你真棒！'),
(74, 1, 2, 'select sno,sname from students where sex=\'男\' and height>1.8', '2017-12-11 09:54:56', '答案正确，你真棒！'),
(75, 12, 2, 'fgbdfbfdbf', '2017-12-11 10:01:12', 'SQL语句出错：Duplicate entry \'0409101\' for key \'PRIMARY\''),
(76, 1, 2, 'select * from students', '2017-12-11 15:41:02', '答案错误，你真笨!'),
(77, 11, 2, 'delete from sc;', '2017-12-11 15:43:44', '答案错误，你真笨!'),
(78, 17, 2, 'delete from SC,Students where sex = \'男\';', '2017-12-11 16:34:55', 'SQL语句出错：You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near \'where sex = \'男\'\' at line 1'),
(79, 17, 2, 'delete from SC,Students where sex = \'男\';', '2017-12-11 16:36:29', 'SQL语句出错：You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near \'where sex = \'男\'\' at line 1'),
(80, 25, 2, 'DELETE SC,Students FROM SC JOIN Students ON SC.SNO = Students.SNO\r\nWHERE students.sex=\'女\';', '2017-12-11 16:36:44', '答案正确，你真棒！'),
(81, 25, 2, 'DELETE SC,Students FROM SC,Students\r\nWHERE students.sex=\'女\';', '2017-12-11 16:38:50', '答案错误，你真笨!'),
(82, 1, 5, 'select * from students', '2017-12-11 17:01:24', '答案错误，你真笨!'),
(83, 1, 2, 'select sno, sname from students where height > 1.8 and sex = \'男\';', '2017-12-20 18:20:37', '答案正确，你真棒！'),
(84, 17, 5, 'a', '2017-12-20 18:26:01', 'SQL语句出错：You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near \'a\' at line 1'),
(85, 22, 2, 'update students set `sex` =\'女\' where sname like \'张*\'', '2018-01-18 03:28:25', '答案错误，你真笨!'),
(86, 22, 2, 'update students set sex=\'女\'\r\nwhere sname like \'张%\';', '2018-01-18 03:29:01', '答案正确，你真棒！');

-- --------------------------------------------------------

--
-- 表的结构 `student`
--

CREATE TABLE `student` (
  `id` bigint(20) NOT NULL,
  `account` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `name` char(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` char(40) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `classid` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- 转存表中的数据 `student`
--

INSERT INTO `student` (`id`, `account`, `name`, `password`, `classid`) VALUES
(2, 'zal', '张爱玲', 'VQQ3hkE+cjZBYZQtG/noNg==', 1),
(3, 'gyq', '高雨晴', '4QrcOUm6Wau+VuBX8g+IPg==', 6),
(4, 'zcl', '郑春玲', '4QrcOUm6Wau+VuBX8g+IPg==', 4),
(5, 'ln', '黎宁', '4QrcOUm6Wau+VuBX8g+IPg==', 5),
(6, 'laq', '林安琪', '4QrcOUm6Wau+VuBX8g+IPg==', 2),
(8, 'wff', '魏凤凤', '4QrcOUm6Wau+VuBX8g+IPg==', 3);

-- --------------------------------------------------------

--
-- 表的结构 `subdba`
--

CREATE TABLE `subdba` (
  `id` bigint(20) NOT NULL,
  `question` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `refanswer` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `secrecy` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- 转存表中的数据 `subdba`
--

INSERT INTO `subdba` (`id`, `question`, `refanswer`, `secrecy`) VALUES
(1, '数据与信息有何区别，有何联系？', '答：数据是一组对客观事物定性或定量描述的原始物理符号的集合，包括文本、图形\r\n、图像、声音等形式，也是数据库存储和加工的基本对象。信息是一种已经被加工为\r\n特定形式的数据，是对现实世界事物存在方式或运动状态的反映。\r\n', 0),
(2, '简述数据库、数据库管理系统、数据库系统的概念。\r\n\r\n', '答：数据库：简单理解就是数据的仓库，长期存储可共享，冗余小，独立性高的数据\r\n      的集合。\r\n    数据库管理系统：用来操纵和管理数据库的软件，介于用户和操作系统之间，对\r\n      数据库进行统一的管理和控制。\r\n    数据库系统：数据库系统是数据库应用系统的简称，是计算机系统引入数据库之\r\n      后的系统，由计算机、数据库、数据库管理系统、应用程序和用户组成。\r\n', 0),
(3, '数据库管理技术经历了哪几个阶段？各阶段主要特点是什么？', '答：人工管理阶段：\r\n       1.数据不能长期保存；2.系统没有专用的软件对数据进行管理；3.程序与数\r\n         据不具有独立性；4.数据无法共享。\r\n    文件系统阶段：\r\n       1.数据可以长期保存；2.程序与数据有一定的独立性；3.文件系统对数据进\r\n    行统一管理，文件形式多种多样；\r\n       4.数据冗余度大；5数据独立性低。\r\n    数据库系统阶段：\r\n       1.数据整体结构化；2.数据共享性高，冗余度高，易扩展；3.数据独立性高；\r\n    4.数据由数据库管理系统统一管理。\r\n', 0),
(4, '文件系统与数据库系统有什么本质的区别？', '答：数据库系统是将所有应用程序需要的数据按照统一的结构集成在一起，即数据\r\n的结构化。\r\n\r\n', 0),
(5, '数据模型的组成要素有哪些，并详细阐述他们的含义：', '数据结构：描述数据库的组成对象，以及对象之间的联系。数据操作：对数据库中各种对象(型)的实例(值)允许执\r\n行的操作及有关的操作规则。完整性约束：反映和规定必须遵守的基本的通用的完整性约束条件。', 0),
(6, '常用的数据模型有：', '传统数据模型有层次模型，网状模型；关系模型(Relational Model)；对象关系模型(Object Relational Model)；面向对象模型(Object Oriented Model）；半 结 构 化 数 据 模 型 （ Semistruture Data\r\nModel）', 0),
(7, '数据库设计一般分为哪几个阶段，每个阶段的主要任务是什么？', '（1）数据库设计分为6个阶段：需求分析、概念结构设计、逻辑结构设计、物理结构设计、数据库实施、数据库运行和维护。\r\n（2）各阶段任务如下：①需求分析：准确了解与分析用户需求（包括数据与处理）。②概念结构设计：通过对用户需求进行综合、归纳与抽象，形成一个独立于具体 DBMS 的概念模型。③逻辑结构设计：将概念结构转换为某个 DBMS 所支持的数据模型，并对其进行优化。④数据库物理设计：为逻辑数据模型选取一个最适合应用环境的物理结构（包括存储结构和存取方法）。⑤数据库实施：设计人员运用 DBMS 提供的数据语言、工具及宿主语言，根据逻辑设计和物理设计的结果建立数据库，编制与调试应用程序，组织数据入库，并进行试运行。 ⑥数据库运行和维护：在数据库系统运行过程中对其进行评价、调整与修改。\r\n', 0),
(8, '什么是事务，事务有哪些特性?', '答：事务是DBMS的基本工作单位，它是用户定义的一组逻辑一致的程序序列。它是一个不可分割的工作单位，其中包含的所有操作，要么都执行，要么都不执行。\r\n事务具有4 个特性：原子性（Atomicity ）、一致性（consistency ）、隔离性( Isolation ）和持续性（Durability ）。这4 个特性也简称为ACID 特性。\r\n原子性：事务是数据库的逻辑工作单位，事务中包括的诸操作要么都做，要么都不做。\r\n一致性：事务执行的结果必须是使数据库从一个一致性状态变到另一个一致性状态。\r\n隔离性：一个事务的执行不能被其他事务干扰。即一个事务内部的操作及使用的数据  对其他并发事务是隔离的，并发执行的各个事务之间不能互相干扰。持续性：持续性也称永久性（Perfnanence ) ，指一个事务一旦提交，它对数据库中数据的改变就应该是永久性的。接下来的其他操作或故障不应该对其执行结果有任何影响。\r\n', 0),
(9, '事务中的提交和回滚是什么意思?', '答：事务中的提交(COMMIT)是提交事务的所有操作。具体说就是将事务中所有对数据库的更新写回到磁盘上的物理数据库中去，事务正常结束。事务中的回滚(ROLLBACK)是数据库滚回到事务开始时的状态。具体地说就是，在事务运行的过程中发生了某种故障，事务不能继续执行，系统将事务中对数据库的所有已完成的更新操作全部撤消，使数据库回滚到事务开始时的状态。', 0),
(10, '为什么要设立日志文件?', '答：设立日志文件的目的，是为了记录对数据库中数据的每一次更新操作。从而DBMS可以根据日志文件进行事务故障的恢复和系统故障的恢复，并可结合后援副本进行介质故障的恢复。', 0);

-- --------------------------------------------------------

--
-- 表的结构 `teacher`
--

CREATE TABLE `teacher` (
  `id` bigint(20) NOT NULL,
  `account` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `name` char(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` char(40) COLLATE utf8mb4_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- 转存表中的数据 `teacher`
--

INSERT INTO `teacher` (`id`, `account`, `name`, `password`) VALUES
(1, 'dsl2015', '董守玲', 'V/YuCFz98gs54S3osZkxEg=='),
(2, 'zjw2015', '张见威', '4QrcOUm6Wau+VuBX8g+IPg=='),
(3, 'dsb2015', '董守斌', '9PYXLrJlgZUqcNcZm/0t2w=='),
(5, 'zs', '张三', '123456'),
(6, 'ls', '李四', '123456'),
(7, 'wu', '王五', '123456'),
(8, '123', '顺', '123456');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `choicedba`
--
ALTER TABLE `choicedba`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`classid`),
  ADD KEY `teacher_id` (`tid`);

--
-- Indexes for table `evadba`
--
ALTER TABLE `evadba`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `judgedba`
--
ALTER TABLE `judgedba`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `paper`
--
ALTER TABLE `paper`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tid` (`tid`),
  ADD KEY `classid` (`classid`);

--
-- Indexes for table `record`
--
ALTER TABLE `record`
  ADD PRIMARY KEY (`pid`,`sid`),
  ADD KEY `sid` (`sid`);

--
-- Indexes for table `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`runid`),
  ADD KEY `pid` (`eid`),
  ADD KEY `status_ibfk_1` (`uid`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`),
  ADD KEY `classid` (`classid`);

--
-- Indexes for table `subdba`
--
ALTER TABLE `subdba`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `account` (`account`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `admin`
--
ALTER TABLE `admin`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- 使用表AUTO_INCREMENT `choicedba`
--
ALTER TABLE `choicedba`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=103;

--
-- 使用表AUTO_INCREMENT `class`
--
ALTER TABLE `class`
  MODIFY `classid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- 使用表AUTO_INCREMENT `evadba`
--
ALTER TABLE `evadba`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- 使用表AUTO_INCREMENT `judgedba`
--
ALTER TABLE `judgedba`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- 使用表AUTO_INCREMENT `paper`
--
ALTER TABLE `paper`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- 使用表AUTO_INCREMENT `status`
--
ALTER TABLE `status`
  MODIFY `runid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=87;

--
-- 使用表AUTO_INCREMENT `student`
--
ALTER TABLE `student`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- 使用表AUTO_INCREMENT `subdba`
--
ALTER TABLE `subdba`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- 使用表AUTO_INCREMENT `teacher`
--
ALTER TABLE `teacher`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
