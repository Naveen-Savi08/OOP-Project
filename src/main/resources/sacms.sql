-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 29, 2023 at 11:07 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sacms`
--

-- --------------------------------------------------------

--
-- Table structure for table `advisor`
--

CREATE TABLE `advisor` (
  `advisor_id` varchar(10) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `dob` date NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `contact_number` varchar(10) NOT NULL,
  `gender` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `advisor`
--

INSERT INTO `advisor` (`advisor_id`, `first_name`, `last_name`, `dob`, `email`, `password`, `contact_number`, `gender`) VALUES
('1212', 'surathal', 'maluwa', '2023-10-30', 'maluwa@gmail.com', '123', '0789089766', 'male'),
('123e', 'kamal', 'rajev', '2023-10-30', 'kmac@gmail.com', '1234', '0786778900', 'male'),
('A1', 'eminem', 'sama', '2023-10-30', 'eminemsama@gmail.com', '333', '0789766890', 'male'),
('A33', 'sudu', 'nanda', '2023-11-13', 'sudu@gmail.com', '123', '0789877433', 'Female');

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `student_id` varchar(20) NOT NULL,
  `event_id` varchar(20) NOT NULL,
  `attendance_date` date NOT NULL,
  `is_present` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`student_id`, `event_id`, `attendance_date`, `is_present`) VALUES
('e123', 'E14', '2023-11-29', 1),
('e123', 'E45', '2023-11-29', 1);

-- --------------------------------------------------------

--
-- Table structure for table `club`
--

CREATE TABLE `club` (
  `club_id` varchar(10) NOT NULL,
  `club_name` varchar(100) NOT NULL,
  `advisor_id` varchar(10) DEFAULT NULL,
  `members` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `sport` varchar(50) DEFAULT NULL,
  `academic_type` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `club`
--

INSERT INTO `club` (`club_id`, `club_name`, `advisor_id`, `members`, `description`, `sport`, `academic_type`) VALUES
('1000', 'Gall gladiators', 'A1', 101, 'Down south ', 'Cricket', NULL),
('1001', 'Voleyball Club', 'A1', 12, 'Jump and smash the ball', 'Voleyball', NULL),
('104', 'Anthesia', '1212', 300, 'Hallo demncisa', NULL, 'Lit'),
('1122', 'wdwdt', 'A1', 211, 'wddwd', 'eerere', NULL),
('123', 'OOP', 'A1', 120, 'jjgjgjgjgjgjgjgj', 'net ball', NULL),
('45T', 'AC Milan', '1212', 500, 'Forever Zlatan', 'Football', NULL),
('67E', 'Unisex', '1212', 200, 'World Health', NULL, 'Healthy'),
('A56', 'dkfjbk', 'A1', 56, 'jhge', NULL, NULL),
('C1', 'MCC', 'A1', 111, 'Hello', 'crcket', NULL),
('erer', 'tok', 'A1', 12, 'americano wespusi', NULL, NULL),
('err', 'wdwdwdw', '1212', 12, 'wwdwdwd', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE `event` (
  `scheduleId` varchar(20) NOT NULL,
  `scheduleName` varchar(100) DEFAULT NULL,
  `scheduleLocation` varchar(100) DEFAULT NULL,
  `clubId` varchar(20) DEFAULT NULL,
  `scheduleDate` date DEFAULT NULL,
  `scheduleTime` time DEFAULT NULL,
  `eventType` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`scheduleId`, `scheduleName`, `scheduleLocation`, `clubId`, `scheduleDate`, `scheduleTime`, `eventType`) VALUES
('E14', 'JJJJj', 'dfefw', 'C1', '2023-11-07', '12:50:00', 'physical'),
('E23', 'sagara', 'wersa', '104', '2023-11-19', '10:34:00', 'physical'),
('E45', 'Green', 'Akuressa', 'C1', '2023-11-15', '11:34:00', 'online');

-- --------------------------------------------------------

--
-- Table structure for table `join_club`
--

CREATE TABLE `join_club` (
  `student_id` varchar(10) NOT NULL,
  `club_id` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `join_club`
--

INSERT INTO `join_club` (`student_id`, `club_id`) VALUES
('1111', '1000'),
('1111', '67E'),
('e123', '1000'),
('e123', '1001'),
('e123', '104'),
('e123', '123'),
('e123', '45T'),
('e123', '67E'),
('e123', 'A56'),
('e123', 'C1'),
('e123', 'erer'),
('e123', 'err'),
('erer', '45T');

-- --------------------------------------------------------

--
-- Table structure for table `meeting`
--

CREATE TABLE `meeting` (
  `scheduleId` varchar(20) NOT NULL,
  `scheduleName` varchar(100) DEFAULT NULL,
  `scheduleLocation` varchar(100) DEFAULT NULL,
  `clubId` varchar(20) DEFAULT NULL,
  `scheduleDate` date DEFAULT NULL,
  `scheduleTime` time DEFAULT NULL,
  `meetingType` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `student_id` varchar(10) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `dob` date NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `contact_number` varchar(10) NOT NULL,
  `gender` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`student_id`, `first_name`, `last_name`, `dob`, `email`, `password`, `contact_number`, `gender`) VALUES
('1011', 'saman', 'lenin', '2023-11-01', 'lemon@gmail.com', '123', '0897867881', 'male'),
('1111', 'chamara', 'saman', '2023-11-10', 'chamara@gmail.com', '1111', '0789744288', 'Male'),
('6677', 'saman', 'dulaj', '2023-11-27', 'saman@gmail.com', '123', '0988877890', 'male'),
('e123', 'kurama', 'perera', '2023-10-29', 'kurama@gmail.com', '123', '0763748885', 'male'),
('erer', 'Kumara', 'Saman', '2023-11-01', 'cv@gmail.com', '4', '0777906897', 'male'),
('S33', 'Max', 'Well', '2005-04-25', 'max@gmail.com', '123', '0786789990', 'Male'),
('wdwd', 'rrrr', 'wdwdw', '2023-11-01', 'wdwdw@gmail.com', '123', '1234567890', 'male'),
('wesd', 'good', 'bad', '2023-10-29', 'giiid@gmail.com', '1234', '0789788677', 'male');

-- --------------------------------------------------------

--
-- Table structure for table `workshop`
--

CREATE TABLE `workshop` (
  `scheduleId` varchar(20) NOT NULL,
  `scheduleName` varchar(100) DEFAULT NULL,
  `scheduleLocation` varchar(100) DEFAULT NULL,
  `clubId` varchar(20) DEFAULT NULL,
  `scheduleDate` date DEFAULT NULL,
  `scheduleTime` time DEFAULT NULL,
  `conductor` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `workshop`
--

INSERT INTO `workshop` (`scheduleId`, `scheduleName`, `scheduleLocation`, `clubId`, `scheduleDate`, `scheduleTime`, `conductor`) VALUES
('W1', 'Automobile', 'Rathanapura', 'C1', '2023-12-04', '10:34:00', 'saman');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `advisor`
--
ALTER TABLE `advisor`
  ADD PRIMARY KEY (`advisor_id`);

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`student_id`,`event_id`,`attendance_date`),
  ADD KEY `event_id` (`event_id`);

--
-- Indexes for table `club`
--
ALTER TABLE `club`
  ADD PRIMARY KEY (`club_id`),
  ADD KEY `advisor_id` (`advisor_id`);

--
-- Indexes for table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`scheduleId`),
  ADD KEY `clubId` (`clubId`);

--
-- Indexes for table `join_club`
--
ALTER TABLE `join_club`
  ADD PRIMARY KEY (`student_id`,`club_id`),
  ADD KEY `club_id` (`club_id`);

--
-- Indexes for table `meeting`
--
ALTER TABLE `meeting`
  ADD PRIMARY KEY (`scheduleId`),
  ADD KEY `clubId` (`clubId`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`student_id`);

--
-- Indexes for table `workshop`
--
ALTER TABLE `workshop`
  ADD PRIMARY KEY (`scheduleId`),
  ADD KEY `clubId` (`clubId`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `attendance`
--
ALTER TABLE `attendance`
  ADD CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `event` (`scheduleId`);

--
-- Constraints for table `club`
--
ALTER TABLE `club`
  ADD CONSTRAINT `club_ibfk_1` FOREIGN KEY (`advisor_id`) REFERENCES `advisor` (`advisor_id`);

--
-- Constraints for table `event`
--
ALTER TABLE `event`
  ADD CONSTRAINT `event_ibfk_1` FOREIGN KEY (`clubId`) REFERENCES `club` (`club_id`);

--
-- Constraints for table `join_club`
--
ALTER TABLE `join_club`
  ADD CONSTRAINT `join_club_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`),
  ADD CONSTRAINT `join_club_ibfk_2` FOREIGN KEY (`club_id`) REFERENCES `club` (`club_id`);

--
-- Constraints for table `meeting`
--
ALTER TABLE `meeting`
  ADD CONSTRAINT `meeting_ibfk_1` FOREIGN KEY (`clubId`) REFERENCES `club` (`club_id`);

--
-- Constraints for table `workshop`
--
ALTER TABLE `workshop`
  ADD CONSTRAINT `workshop_ibfk_1` FOREIGN KEY (`clubId`) REFERENCES `club` (`club_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
