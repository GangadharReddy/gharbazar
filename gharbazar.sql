-- phpMyAdmin SQL Dump
-- version 2.11.6
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 23, 2014 at 09:03 AM
-- Server version: 5.0.51
-- PHP Version: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `gharbazar`
--

-- --------------------------------------------------------

--
-- Table structure for table `electronics`
--
-- Creation: Mar 22, 2014 at 10:37 PM
--

DROP TABLE IF EXISTS `electronics`;
CREATE TABLE IF NOT EXISTS `electronics` (
  `ele_id` bigint(20) NOT NULL,
  `reg_date` date NOT NULL,
  `category` varchar(30) NOT NULL default 'Others',
  `title` varchar(20) NOT NULL,
  `price` bigint(10) default NULL,
  `detail` varchar(100) default NULL,
  `contact` bigint(12) NOT NULL,
  `state` varchar(20) default NULL,
  `city` varchar(20) default NULL,
  `image1` varchar(100) default NULL,
  `image2` varchar(20) default NULL,
  `image3` varchar(20) default NULL,
  `reg_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`ele_id`),
  KEY `reg_id` (`reg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `electronics`
--

INSERT DELAYED IGNORE INTO `electronics` (`ele_id`, `reg_date`, `category`, `title`, `price`, `detail`, `contact`, `state`, `city`, `image1`, `image2`, `image3`, `reg_id`) VALUES
(6, '2014-03-22', 'TVCameraAndMultimedia', 'Flat-screen-TV', 37000, 'A new flat tv', 9474694712, 'Andhra Pradesh', 'Hyderabad', 'Flat-screen-TV.jpg', NULL, NULL, 91),
(7, '2014-03-22', 'HomeAppliances', 'Iron', 700, 'A bajaj iron is on sell.', 9474448955, 'Bihar', 'Patna', 'iron.jpg', NULL, NULL, 92),
(8, '2014-03-22', 'IndustrialMachineryTools', 'Dozer Machine', 2000000, 'A bull dozer is on sell ', 9531756976, 'Andhra Pradesh', 'Vijaywada', 'dozer-machine-construction-industry-machinery.jpg', NULL, NULL, 93),
(9, '2014-03-22', 'ITPeripherals', 'Transcend-mobile', 4500, 'A transcend hard disk is on sell whose color is yellow.', 8287564212, 'Kerala', 'Allipey', 'Transcend-mobile-hard-drive-yellow.jpg', NULL, NULL, 94),
(10, '2014-03-23', 'TVCameraAndMultimedia', 'Samsung Tv 45 Inches', 200000, 'One year old LED TV', 9832625282, 'Karnataka', 'Banglore', 'samsung.jpg', NULL, NULL, 94);

-- --------------------------------------------------------

--
-- Table structure for table `homenlifestyle`
--
-- Creation: Mar 22, 2014 at 10:37 PM
--

DROP TABLE IF EXISTS `homenlifestyle`;
CREATE TABLE IF NOT EXISTS `homenlifestyle` (
  `home_id` bigint(10) NOT NULL,
  `category` varchar(50) NOT NULL,
  `title` varchar(20) NOT NULL,
  `detail` varchar(100) default NULL,
  `price` bigint(20) default NULL,
  `contact` bigint(12) NOT NULL,
  `state` varchar(50) default NULL,
  `city` varchar(50) default NULL,
  `image1` varchar(20) default NULL,
  `image2` varchar(20) default NULL,
  `image3` varchar(20) default NULL,
  `reg_date` date NOT NULL,
  `reg_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`home_id`),
  KEY `reg_id` (`reg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `homenlifestyle`
--

INSERT DELAYED IGNORE INTO `homenlifestyle` (`home_id`, `category`, `title`, `detail`, `price`, `contact`, `state`, `city`, `image1`, `image2`, `image3`, `reg_date`, `reg_id`) VALUES
(1, 'Health-BeautyFitness', 'Garnier Facewash', 'Reduces Redness, Dry Pimples, Tightens Pores, Lighten Marks, Controls Oil', 150, 8971117769, 'West Bengal', 'Durgapur', 'GAR0024_2.jpg', NULL, NULL, '2014-03-22', 95),
(2, 'Therapy', 'MarmaTherapy', 'Therapy for headache.', 340, 9087645987, 'Chhattisgarh', 'Raipur', 'MarmaTherapy.jpg', NULL, NULL, '2014-03-22', 106),
(3, 'Health-BeautyFitness', 'Lakme Cream', 'Lakme cream.', 250, 9051234456, 'Gujarat', 'Porbandar', 'lakme.jpeg', NULL, NULL, '2014-03-22', 107),
(4, 'DoctorDetails', 'Neck Surgery', 'Dr. Moni Abraham Kuriakose', 1000, 905124123, 'Jharkhand', 'Jharia', 'doctor-details.jpg', NULL, NULL, '2014-03-22', 108),
(5, 'Babysitter', 'One nanny is require', 'One nanny is required to take care of one baby.', 4500, 9531123487, 'Gujarat', 'Ahemedabad', 'babysitter(1).jpg', NULL, NULL, '2014-03-22', 96),
(6, 'Health-BeautyFitness', 'Olay Fresh Effects', 'It gives freshness and makes skin smoother.', 600, 8088593884, 'Andhra Pradesh', 'Vijaywada', 'Olay.jpg', NULL, NULL, '2014-03-22', 95),
(7, 'Health-BeautyFitness', 'Loreal Shampoo', '25% discount on Loreal. Limited period in Big Bazar.', 80, 9993335465, 'Karnataka', 'Banglore', 'loreal.jpg', NULL, NULL, '2014-03-23', 100);

-- --------------------------------------------------------

--
-- Table structure for table `maruadmintaru`
--
-- Creation: Mar 22, 2014 at 10:37 PM
--

DROP TABLE IF EXISTS `maruadmintaru`;
CREATE TABLE IF NOT EXISTS `maruadmintaru` (
  `email` varchar(40) NOT NULL,
  `password` varchar(20) NOT NULL,
  `lastlogin` date default NULL,
  PRIMARY KEY  (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `maruadmintaru`
--

INSERT DELAYED IGNORE INTO `maruadmintaru` (`email`, `password`, `lastlogin`) VALUES
('admin@gharbazar.com', 'admin', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `mobile`
--
-- Creation: Mar 22, 2014 at 10:37 PM
--

DROP TABLE IF EXISTS `mobile`;
CREATE TABLE IF NOT EXISTS `mobile` (
  `S_id` bigint(15) NOT NULL,
  `reg_id` int(20) default NULL,
  `mobile_type` varchar(30) NOT NULL,
  `title` varchar(20) NOT NULL,
  `Model` varchar(25) NOT NULL,
  `Price` double NOT NULL,
  `state` varchar(20) NOT NULL,
  `city` varchar(50) default NULL,
  `Selling_date` date NOT NULL,
  `Details` varchar(100) NOT NULL,
  `Contact_No` double default NULL,
  `Image1` varchar(200) default NULL,
  `Image2` varchar(200) default NULL,
  `image3` varchar(200) default NULL,
  KEY `reg_id` (`reg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mobile`
--

INSERT DELAYED IGNORE INTO `mobile` (`S_id`, `reg_id`, `mobile_type`, `title`, `Model`, `Price`, `state`, `city`, `Selling_date`, `Details`, `Contact_No`, `Image1`, `Image2`, `image3`) VALUES
(1, 89, 'Tablets', 'Samsung Galaxy Tab', 'Note III', 31000, 'Tamil Nadu', 'Chennai', '2014-03-22', 'It is a new tablet under 3 months of warranty period.', 7200572933, 'Samsung-Galaxy-Tab-10.jpg', NULL, NULL),
(2, 89, 'WindowPhones', 'Nokia Lumia', '1200', 21500, 'Tamil Nadu', 'Chennai', '2014-03-22', 'A brand new Nokia Lumia is under 6 months warranty with headphones.', 7200572933, '1200-nokia-lumia-900_cyan_combo.jpg', NULL, NULL),
(4, 89, 'AndroidPhones', 'Sony Xperia', 'Z1', 39000, 'Tamil Nadu', 'Chennai', '2014-03-22', 'A brand new Sony Xperia Z1 is on sell.', 7200572933, 'xperia-zl.jpeg', NULL, NULL),
(5, 89, 'Other', 'Sony', 'WH303 Head Big', 1500, 'Tamil Nadu', 'Chennai', '2014-03-22', 'A headphone with super beat and in reasonable price.', 7200572933, 'sony-WH303-head-big.jpg', NULL, NULL),
(6, 89, 'Other', 'Bluetooth-headset', 'Angle-1000', 1200, 'Tamil Nadu', 'Chennai', '2014-03-22', 'A new headphone of Nokia.', 7200572933, '00-bluetooth-headset-angle-1000.jpg', NULL, NULL),
(7, 100, 'AndroidPhones', 'Sony Xperia Zl', 'Xperia ZL', 34000, 'Andhra Pradesh', 'Kurnool', '2014-03-23', 'White color piece and two months old', 8985505675, 'xperia.jpeg', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `realestate`
--
-- Creation: Mar 22, 2014 at 10:37 PM
--

DROP TABLE IF EXISTS `realestate`;
CREATE TABLE IF NOT EXISTS `realestate` (
  `real_id` bigint(20) NOT NULL,
  `category` varchar(20) NOT NULL,
  `subcategory` varchar(20) NOT NULL,
  `title` varchar(30) NOT NULL,
  `price` bigint(10) default NULL,
  `details` varchar(100) default NULL,
  `contact` bigint(12) NOT NULL,
  `state` varchar(20) default NULL,
  `city` varchar(20) default NULL,
  `image1` varchar(100) default NULL,
  `image2` varchar(20) default NULL,
  `image3` varchar(20) default NULL,
  `reg_date` date NOT NULL,
  `reg_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`real_id`),
  KEY `reg_id` (`reg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `realestate`
--

INSERT DELAYED IGNORE INTO `realestate` (`real_id`, `category`, `subcategory`, `title`, `price`, `details`, `contact`, `state`, `city`, `image1`, `image2`, `image3`, `reg_date`, `reg_id`) VALUES
(2, 'Rent', 'Commercial', 'Office', 15000, 'Office for rent which is for it sector.', 7200572813, 'Karnataka', 'Bangalore', 'Office-Meeting-Room-Novel-Tech-Park.jpeg', NULL, NULL, '2014-03-22', 96),
(3, 'Rent', 'Residential', 'PG', 5000, 'Gents pg with 3 times food and wifi.', 9038456123, 'Arunachal Pradesh', 'Bana', 'PG.jpeg', NULL, NULL, '2014-03-22', 102),
(4, 'Sell', 'Commercial', 'Apartment-For-Sale', 250000, 'Apartment for sell with well furnished furniture.', 9051123123, 'Haryana', 'Panipat', 'Apartment-For-Sale.jpeg', NULL, NULL, '2014-03-22', 103),
(5, 'Sell', 'Residential', 'Single-room', 5000, 'well furnished room with all facilities.', 8904256312, 'Jammu and Kashmir', 'Srinagar', 'Single-room.jpeg', NULL, NULL, '2014-03-22', 104),
(6, 'Sell', 'Commercial', 'Hennur', 350000, '550 sq ft of land is on sell for residential purpose.', 9743451126, 'Delhi', 'Gurgaon', 'Hennur.jpg', NULL, NULL, '2014-03-22', 105),
(7, 'Sell', 'Residential', 'Niranjan Treda Appartments', 3000000, '2 Bed room apartments for sale.', 6876868, 'Karnataka', 'Banglore', 'Apartment.jpeg', NULL, NULL, '2014-03-23', 105);

-- --------------------------------------------------------

--
-- Table structure for table `registration`
--
-- Creation: Mar 22, 2014 at 10:37 PM
--

DROP TABLE IF EXISTS `registration`;
CREATE TABLE IF NOT EXISTS `registration` (
  `reg_id` bigint(20) NOT NULL,
  `fname` varchar(30) NOT NULL,
  `lname` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `mobile` bigint(13) NOT NULL,
  `password` varchar(30) NOT NULL,
  `reg_date` date NOT NULL,
  `last_modified` date default NULL,
  PRIMARY KEY  (`reg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registration`
--

INSERT DELAYED IGNORE INTO `registration` (`reg_id`, `fname`, `lname`, `email`, `mobile`, `password`, `reg_date`, `last_modified`) VALUES
(90, 'Arun', 'Kumar', 'arun.kumar@yahoo.in', 8971117769, '123', '2014-03-22', '2014-03-23'),
(91, 'SANU', 'NARAYAN', 'sanu2@gmail.com', 897654324, '3456', '2014-03-22', '2014-03-22'),
(92, 'Arunava', 'Karmakar', 'a.karmakar@gmail.com', 9474448955, '123', '2014-03-22', '2014-03-22'),
(93, 'Subhadip', 'Reddy', 'subha3521110151@yahoo.in', 9531756976, '123', '2014-03-22', '2014-03-22'),
(94, 'Tharun', 'Reddy', 'reddy.tharun@gmail.com', 9474561236, '123', '2014-03-22', '2014-03-23'),
(95, 'Kaushik', 'Chakraborty', 'chakraborty.kaushik749@gmail.com', 8971117769, '123', '2014-03-22', '2014-03-22'),
(96, 'Subhadip', 'Chatterjee', 'subhadip24x7@gmail.com', 7200572813, '123', '2014-03-22', '2014-03-22'),
(97, 'Bhavik', 'Savaliya', 'bhavik.savaliya1991@gmail.com', 7411552004, '123', '2014-03-22', '2014-03-22'),
(98, 'Natha', 'Khistariya', 'nathan.dk@gmail', 7411551230, '123', '2014-03-22', '2014-03-22'),
(99, 'Ankita', 'Kundu', 'kunduankita30@gmail.com', 8088593884, '123', '2014-03-22', '2014-03-22'),
(100, 'Gangadhar', 'Reddy', 'gangadhar.reddy18@gmail.com', 94443254516, '123', '2014-03-22', '2014-03-23'),
(101, 'Debashish', 'Kumar', 'hr@dscit.in', 9038523456, '123', '2014-03-22', '2014-03-22'),
(102, 'Ravinder', 'Jadeja', 'jaddu@yahoo.in', 9645781236, '123', '2014-03-22', '2014-03-22'),
(103, 'Tabreez', 'Khan', 'tabreez@gmail.com', 9051123123, '123', '2014-03-22', '2014-03-22'),
(104, 'RAINA', 'SEN', 'raina_sen@gmail.com', 9087655342, '890', '2014-03-22', '2014-03-22'),
(105, 'SNEHA', 'MOITRA', 'sneha_moitra@hotmail.com', 9763542211, 'sudip', '2014-03-22', '2014-03-23'),
(106, 'SUDIP', 'MUKHERJEE', 'sudip_mukh@yahoo.com', 9087654321, 'sneha', '2014-03-22', '2014-03-22'),
(107, 'Sunil', 'Rastogi', 'sunil12@gmail.com', 9051234456, '123', '2014-03-22', '2014-03-22'),
(108, 'Jugal', 'Hanshraj', 'jugal.hanshraj@gmail.com', 9051123124, '123', '2014-03-22', '2014-03-22');

-- --------------------------------------------------------

--
-- Table structure for table `state_master`
--
-- Creation: Mar 22, 2014 at 10:37 PM
--

DROP TABLE IF EXISTS `state_master`;
CREATE TABLE IF NOT EXISTS `state_master` (
  `s_id` int(11) NOT NULL auto_increment,
  `state` varchar(50) NOT NULL,
  PRIMARY KEY  (`s_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=34 ;

--
-- Dumping data for table `state_master`
--

INSERT DELAYED IGNORE INTO `state_master` (`s_id`, `state`) VALUES
(1, 'Andhra Pradesh'),
(2, 'Arunachal Pradesh'),
(3, 'Assam'),
(4, 'Bihar'),
(5, 'Chandigarh'),
(6, 'Chhattisgarh'),
(7, 'Dadra and Nagar Haveli'),
(8, 'Daman and Diu'),
(9, 'Delhi'),
(10, 'Goa'),
(11, 'Gujarat'),
(12, 'Haryana'),
(13, 'Himachal Pradesh'),
(14, 'Jammu and Kashmir'),
(15, 'Jharkhand'),
(16, 'Karnataka'),
(17, 'Kerala'),
(18, 'Madhya Pradesh'),
(19, 'Maharashtra'),
(20, 'Manipur'),
(21, 'Meghalaya'),
(22, 'Mizoram'),
(23, 'Nagaland'),
(24, 'Orissa'),
(25, 'Puducherry'),
(26, 'Punjab'),
(27, 'Rajasthan'),
(28, 'Sikkim'),
(29, 'Tamil Nadu'),
(30, 'Tripura'),
(31, 'Uttar Pradesh'),
(32, 'Uttarakhand'),
(33, 'West Bengal');

-- --------------------------------------------------------

--
-- Table structure for table `vehicle`
--
-- Creation: Mar 22, 2014 at 10:37 PM
--

DROP TABLE IF EXISTS `vehicle`;
CREATE TABLE IF NOT EXISTS `vehicle` (
  `vehicle_id` bigint(20) NOT NULL,
  `category` varchar(20) NOT NULL,
  `subcategory` varchar(20) default NULL,
  `title` varchar(20) NOT NULL,
  `model` varchar(20) default NULL,
  `year` int(4) default NULL,
  `price` bigint(10) default NULL,
  `detail` varchar(100) default NULL,
  `contact` bigint(12) default NULL,
  `state` varchar(20) default NULL,
  `city` varchar(20) default NULL,
  `image1` varchar(100) default NULL,
  `image2` varchar(20) default NULL,
  `image3` varchar(20) default NULL,
  `reg_date` date NOT NULL,
  `reg_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`vehicle_id`),
  KEY `reg_id` (`reg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vehicle`
--

INSERT DELAYED IGNORE INTO `vehicle` (`vehicle_id`, `category`, `subcategory`, `title`, `model`, `year`, `price`, `detail`, `contact`, `state`, `city`, `image1`, `image2`, `image3`, `reg_date`, `reg_id`) VALUES
(1, 'VehicleAccessories', 'Sell', 'Helmet', 'New', 1500, 1500, 'A brand new crush helmet.', 7411552004, 'Gujarat', 'Gandhi Nagar', 'VE-FKA-_is.jpg', NULL, NULL, '2014-03-22', 97),
(2, 'Vehicles', 'Rent', 'Ambassador', 'Ambassador 4561', 5000, 5000, 'An ambassador is in for rent.', 7411551230, 'Madhya Pradesh', 'Bhopal', 'Ambassador.jpg', NULL, NULL, '2014-03-22', 98),
(3, 'Vehicles', 'Sell', 'TVS-Scooty-Pep', 'Scooty-Pep 2300', 6000, 6000, 'A second hand scooty is on sell in a very good condition.', 8088593884, 'Jharkhand', 'Dhanbad', 'TVS-Scooty-Pep.jpg', NULL, NULL, '2014-03-22', 99),
(4, 'VehicleAccessories', 'Sell', 'Hand Gloves', 'Harleyappmerc', 800, 800, 'A harley davidson hand glove is on sell in a reasonable price.', 94442364152, 'Andhra Pradesh', 'Kurnool', 'harleyappmerc_9.jpg', NULL, NULL, '2014-03-22', 100),
(5, 'Vehicles', 'Sell', 'Scooter', 'Bajaj Cheetak', 9000, 9000, 'A old scooter is in sale with a good price.', 9474448923, 'West Bengal', 'Asansol', 'scooter.jpg', NULL, NULL, '2014-03-22', 101),
(6, 'Vehicles', 'Sell', 'Bajaj Pulser 250cc', 'Pulser', 50000, 50000, 'Bike with life time insurence.', 9993335465, 'Delhi', 'Delhi', 'bikes.jpg', NULL, NULL, '2014-03-23', 90);
