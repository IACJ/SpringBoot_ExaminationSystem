-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 2017-11-12 08:17:38
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
-- Database: `examination`
--

-- --------------------------------------------------------

--
-- 表的结构 `admin`
--

CREATE TABLE `admin` (
  `id` bigint(20) NOT NULL,
  `account` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `name` char(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` char(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- 转存表中的数据 `admin`
--

INSERT INTO `admin` (`id`, `account`, `name`, `password`) VALUES
(1, 'acj', '贾中昊', 'acj'),
(2, 'wty', '王腾叶', 'wty'),
(3, 'zyr', '钟燕榕', 'zyr');

-- --------------------------------------------------------

--
-- 表的结构 `class`
--

CREATE TABLE `class` (
  `classid` bigint(20) NOT NULL,
  `teacherid` bigint(20) NOT NULL,
  `classname` char(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- 转存表中的数据 `class`
--

INSERT INTO `class` (`classid`, `teacherid`, `classname`) VALUES
(1, 1, '15网工'),
(2, 3, '15计创'),
(3, 3, '15计联'),
(4, 2, '15计科1'),
(5, 2, '15计科2'),
(6, 1, '15信安');

-- --------------------------------------------------------

--
-- 表的结构 `student`
--

CREATE TABLE `student` (
  `id` bigint(20) NOT NULL,
  `account` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `name` char(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `sex` char(2) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` char(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `classid` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- 转存表中的数据 `student`
--

INSERT INTO `student` (`id`, `account`, `name`, `sex`, `password`, `classid`) VALUES
(2, 'zal', '张爱玲', '女', 'zal', 1),
(3, 'gyq', '高雨晴', '女', 'gyq', 6),
(4, 'zcl', '郑春玲', '女', 'zcl', 4),
(5, 'ln', '黎宁', '男', 'ln', 5),
(6, 'laq', '林安琪', '女', 'laq', 2),
(8, 'wff', '魏凤凤', '女', 'wff', 3);

-- --------------------------------------------------------

--
-- 表的结构 `teacher`
--

CREATE TABLE `teacher` (
  `id` bigint(20) NOT NULL,
  `account` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `name` char(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` char(20) COLLATE utf8mb4_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- 转存表中的数据 `teacher`
--

INSERT INTO `teacher` (`id`, `account`, `name`, `password`) VALUES
(1, 'dsl2015', '董守玲', 'dsl2015'),
(2, 'zjw2015', '张见威', 'zjw2015'),
(3, 'dsb2015', '董守斌', 'dsb2015');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`classid`),
  ADD KEY `teacher_id` (`teacherid`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`),
  ADD KEY `classid` (`classid`);

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
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- 使用表AUTO_INCREMENT `class`
--
ALTER TABLE `class`
  MODIFY `classid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- 使用表AUTO_INCREMENT `student`
--
ALTER TABLE `student`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- 使用表AUTO_INCREMENT `teacher`
--
ALTER TABLE `teacher`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- 限制导出的表
--

--
-- 限制表 `class`
--
ALTER TABLE `class`
  ADD CONSTRAINT `class_ibfk_1` FOREIGN KEY (`teacherid`) REFERENCES `teacher` (`id`);

--
-- 限制表 `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`classid`) REFERENCES `class` (`classid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
