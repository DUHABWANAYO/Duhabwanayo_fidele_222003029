-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 08:16 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `duhabwanayo_fidele_cts_222003029`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `fname` varchar(75) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `id_number` varchar(65) DEFAULT NULL,
  `phone` varchar(90) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `martial_status` varchar(55) DEFAULT NULL,
  `DoB` varchar(225) DEFAULT NULL,
  `email` varchar(88) DEFAULT NULL,
  `password` varchar(35) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`fname`, `lname`, `id_number`, `phone`, `gender`, `martial_status`, `DoB`, `email`, `password`) VALUES
('asdfghjm', 'sdfghj', NULL, '123456', 'Female', 'asdfghj', '2000-09-09', 'abcd@2024', 'abcd'),
('NTWARI', 'Eddy', NULL, '0784150155', 'Male', 'Married', '2000-02-09', 'eddyntwari@gmail.com', 'abcd');

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `attendance_id` int(11) NOT NULL,
  `student_id` int(11) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `attendance_date` date DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`attendance_id`, `student_id`, `course_id`, `attendance_date`, `status`) VALUES
(3, 5, 2, '1998-09-07', 'present'),
(4, 6, 3, '2002-11-07', 'Absent');

-- --------------------------------------------------------

--
-- Stand-in structure for view `attendance_view`
-- (See below for the actual view)
--
CREATE TABLE `attendance_view` (
`attendance_id` int(11)
,`student_id` int(11)
,`course_id` int(11)
,`attendance_date` date
,`status` varchar(50)
);

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `course_id` int(11) NOT NULL,
  `course_name` varchar(100) DEFAULT NULL,
  `course_code` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`course_id`, `course_name`, `course_code`) VALUES
(2, 'E-BIZ', '23454'),
(3, 'JAVA', '43234'),
(4, 'DATABASE', '2321'),
(5, 'JAVA', 'BIT2009'),
(6, 'MULTIMEDIA', 'MULTI23344');

-- --------------------------------------------------------

--
-- Stand-in structure for view `courses_view`
-- (See below for the actual view)
--
CREATE TABLE `courses_view` (
`course_id` int(11)
,`course_name` varchar(100)
,`course_code` varchar(20)
);

-- --------------------------------------------------------

--
-- Table structure for table `enrollment`
--

CREATE TABLE `enrollment` (
  `enrollment_id` int(11) NOT NULL,
  `student_id` int(11) DEFAULT NULL,
  `Contact_Information` varchar(255) DEFAULT NULL,
  `Lecturer_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `enrollment`
--

INSERT INTO `enrollment` (`enrollment_id`, `student_id`, `Contact_Information`, `Lecturer_name`) VALUES
(3, 2, 'TTYUUIUYFTRTYU', 'BUGINGO'),
(4, 5, 'fggggggg', 'eric'),
(5, 2, '0786453234', 'SESONGA');

-- --------------------------------------------------------

--
-- Table structure for table `faculty`
--

CREATE TABLE `faculty` (
  `Faculty_ID` int(11) NOT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Contact_Information` varchar(20) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `Lecturer_names` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `faculty`
--

INSERT INTO `faculty` (`Faculty_ID`, `Name`, `Contact_Information`, `course_id`, `Lecturer_names`) VALUES
(10, 'financial', '0780609487', 10, 'Dr Fidele'),
(11, 'financial', '0780609487', 10, 'Dr Fidele');

-- --------------------------------------------------------

--
-- Stand-in structure for view `faculty_view`
-- (See below for the actual view)
--
CREATE TABLE `faculty_view` (
`Faculty_ID` int(11)
,`Name` varchar(50)
,`Contact_Information` varchar(20)
,`course_id` int(11)
,`Lecturer_names` varchar(20)
);

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `Student_ID` int(11) NOT NULL,
  `First_Name` varchar(50) DEFAULT NULL,
  `Last_Name` varchar(50) DEFAULT NULL,
  `Date_Of_Birth` date DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`Student_ID`, `First_Name`, `Last_Name`, `Date_Of_Birth`, `Email`) VALUES
(1, 'DUHABWANAYO', 'Fidele', '2023-09-01', 'duhabwanayofidele@gmail.com'),
(2, 'DUHABWANAYO', 'Fidele', '2023-09-01', 'duhabwanayofidele@gmail.com'),
(4, 'NIYOMUGABO', 'Leonard', '2000-12-09', 'samuelmasengesho@gmail.com'),
(5, 'NDAYISENGA', 'Emmanuel', '1998-06-05', 'emmanuelndayisenga@gmail.com'),
(6, 'ISHIMWE', 'Emile', '2000-01-01', 'emileishimwe@gmail.com');

-- --------------------------------------------------------

--
-- Stand-in structure for view `students_view`
-- (See below for the actual view)
--
CREATE TABLE `students_view` (
`Student_ID` int(11)
,`First_Name` varchar(50)
,`Last_Name` varchar(50)
,`Date_Of_Birth` date
,`Email` varchar(100)
);

-- --------------------------------------------------------

--
-- Structure for view `attendance_view`
--
DROP TABLE IF EXISTS `attendance_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `attendance_view`  AS  select `attendance`.`attendance_id` AS `attendance_id`,`attendance`.`student_id` AS `student_id`,`attendance`.`course_id` AS `course_id`,`attendance`.`attendance_date` AS `attendance_date`,`attendance`.`status` AS `status` from `attendance` ;

-- --------------------------------------------------------

--
-- Structure for view `courses_view`
--
DROP TABLE IF EXISTS `courses_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `courses_view`  AS  select `courses`.`course_id` AS `course_id`,`courses`.`course_name` AS `course_name`,`courses`.`course_code` AS `course_code` from `courses` ;

-- --------------------------------------------------------

--
-- Structure for view `faculty_view`
--
DROP TABLE IF EXISTS `faculty_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `faculty_view`  AS  select `faculty`.`Faculty_ID` AS `Faculty_ID`,`faculty`.`Name` AS `Name`,`faculty`.`Contact_Information` AS `Contact_Information`,`faculty`.`course_id` AS `course_id`,`faculty`.`Lecturer_names` AS `Lecturer_names` from `faculty` ;

-- --------------------------------------------------------

--
-- Structure for view `students_view`
--
DROP TABLE IF EXISTS `students_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `students_view`  AS  select `students`.`Student_ID` AS `Student_ID`,`students`.`First_Name` AS `First_Name`,`students`.`Last_Name` AS `Last_Name`,`students`.`Date_Of_Birth` AS `Date_Of_Birth`,`students`.`Email` AS `Email` from `students` ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`attendance_id`),
  ADD KEY `student_id` (`student_id`),
  ADD KEY `course_id` (`course_id`);

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`course_id`);

--
-- Indexes for table `enrollment`
--
ALTER TABLE `enrollment`
  ADD PRIMARY KEY (`enrollment_id`),
  ADD KEY `student_id` (`student_id`);

--
-- Indexes for table `faculty`
--
ALTER TABLE `faculty`
  ADD PRIMARY KEY (`Faculty_ID`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`Student_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `attendance`
--
ALTER TABLE `attendance`
  MODIFY `attendance_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `courses`
--
ALTER TABLE `courses`
  MODIFY `course_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `enrollment`
--
ALTER TABLE `enrollment`
  MODIFY `enrollment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `faculty`
--
ALTER TABLE `faculty`
  MODIFY `Faculty_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `Student_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `attendance`
--
ALTER TABLE `attendance`
  ADD CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `students` (`Student_ID`),
  ADD CONSTRAINT `attendance_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`);

--
-- Constraints for table `enrollment`
--
ALTER TABLE `enrollment`
  ADD CONSTRAINT `enrollment_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `students` (`Student_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
