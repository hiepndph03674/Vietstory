-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 11, 2015 at 02:05 AM
-- Server version: 5.5.32
-- PHP Version: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `vietstories`
--
CREATE DATABASE IF NOT EXISTS `vietstories` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `vietstories`;

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE IF NOT EXISTS `comment` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDNguoiDung` int(11) NOT NULL,
  `IDTruyen` int(11) NOT NULL,
  `ThoiGian` datetime NOT NULL,
  `NoiDung` text NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `comment`
--

INSERT INTO `comment` (`ID`, `IDNguoiDung`, `IDTruyen`, `ThoiGian`, `NoiDung`) VALUES
(1, 1, 1, '2015-11-03 00:00:00', 'toi thich truyen nay`');

-- --------------------------------------------------------

--
-- Table structure for table `nguoidung`
--

CREATE TABLE IF NOT EXISTS `nguoidung` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TaiKhoan` varchar(20) NOT NULL,
  `MatKhau` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `nguoidung`
--

INSERT INTO `nguoidung` (`ID`, `TaiKhoan`, `MatKhau`) VALUES
(1, 'hieunt', '1'),
(2, 'hieunt2', '1');

-- --------------------------------------------------------

--
-- Table structure for table `tacgia`
--

CREATE TABLE IF NOT EXISTS `tacgia` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Ten` varchar(200) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `tacgia`
--

INSERT INTO `tacgia` (`ID`, `Ten`) VALUES
(1, 'tac gia 1'),
(2, 'tac gia 2');

-- --------------------------------------------------------

--
-- Table structure for table `theloai`
--

CREATE TABLE IF NOT EXISTS `theloai` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Ten` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `theloai`
--

INSERT INTO `theloai` (`ID`, `Ten`) VALUES
(1, 'kinh di'),
(2, 'tinh cam');

-- --------------------------------------------------------

--
-- Table structure for table `thich`
--

CREATE TABLE IF NOT EXISTS `thich` (
  `IDNguoiDung` int(11) NOT NULL,
  `IDTruyen` int(11) NOT NULL,
  `value` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `truyen`
--

CREATE TABLE IF NOT EXISTS `truyen` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TenTruyen` varchar(200) NOT NULL,
  `IDTacGia` int(11) NOT NULL,
  `IDTheLoai` int(11) NOT NULL,
  `NoiDung` text NOT NULL,
  `LuotLike` int(11) NOT NULL,
  `Comment` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `truyen`
--

INSERT INTO `truyen` (`ID`, `TenTruyen`, `IDTacGia`, `IDTheLoai`, `NoiDung`, `LuotLike`, `Comment`) VALUES
(1, 'truyen co tich 1', 1, 2, 'truyen so 1', 0, 0),
(2, 'truyen so 2', 2, 1, 'truyen so 2', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `yeuthich`
--

CREATE TABLE IF NOT EXISTS `yeuthich` (
  `NguoiDung` int(11) NOT NULL,
  `IDTruyen` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `yeuthich`
--

INSERT INTO `yeuthich` (`NguoiDung`, `IDTruyen`) VALUES
(1, 2),
(2, 1),
(1, 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
