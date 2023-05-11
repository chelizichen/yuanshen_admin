/*
 Navicat Premium Data Transfer

 Source Server         : LocalHost_3306
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : teacher_admin

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 11/05/2023 14:53:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Assignment
-- ----------------------------
DROP TABLE IF EXISTS `Assignment`;
CREATE TABLE `Assignment` (
  `assignment_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `type` varchar(20) NOT NULL,
  `due_date` date NOT NULL,
  `max_points` int DEFAULT NULL,
  `section_id` int DEFAULT NULL,
  PRIMARY KEY (`assignment_id`),
  KEY `section_id` (`section_id`),
  CONSTRAINT `assignment_ibfk_1` FOREIGN KEY (`section_id`) REFERENCES `Section` (`section_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of Assignment
-- ----------------------------
BEGIN;
INSERT INTO `Assignment` VALUES (1, 'Essay', 'Written', '2023-05-01', 100, 1);
INSERT INTO `Assignment` VALUES (2, 'Presentation', 'Oral', '2023-06-15', 50, 2);
INSERT INTO `Assignment` VALUES (3, 'Lab Report', 'Written', '2023-05-10', 75, 3);
INSERT INTO `Assignment` VALUES (4, 'Group Project', 'Mixed', '2023-07-01', 150, 4);
INSERT INTO `Assignment` VALUES (5, 'Midterm Exam', 'Written', '2023-05-30', 200, 1);
INSERT INTO `Assignment` VALUES (6, 'Final Exam', 'Written', '2023-07-15', 300, 5);
COMMIT;

-- ----------------------------
-- Table structure for Attendance
-- ----------------------------
DROP TABLE IF EXISTS `Attendance`;
CREATE TABLE `Attendance` (
  `attendance_id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `present` tinyint(1) DEFAULT NULL,
  `student_id` int DEFAULT NULL,
  `section_id` int DEFAULT NULL,
  `teacher_id` int DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`attendance_id`),
  KEY `student_id` (`student_id`),
  KEY `section_id` (`section_id`),
  CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `Student` (`student_id`),
  CONSTRAINT `attendance_ibfk_2` FOREIGN KEY (`section_id`) REFERENCES `Section` (`section_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of Attendance
-- ----------------------------
BEGIN;
INSERT INTO `Attendance` VALUES (21, '2022-01-03', 1, 1, 1, 1, '2');
INSERT INTO `Attendance` VALUES (22, '2022-01-03', 1, 2, 1, 1, '2');
INSERT INTO `Attendance` VALUES (23, '2022-01-03', 0, 3, 1, 2, '2');
INSERT INTO `Attendance` VALUES (24, '2023-04-13', 1, 1, 1, 2, '1');
COMMIT;

-- ----------------------------
-- Table structure for Course
-- ----------------------------
DROP TABLE IF EXISTS `Course`;
CREATE TABLE `Course` (
  `course_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `code` varchar(20) NOT NULL,
  `description` text,
  `semester` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of Course
-- ----------------------------
BEGIN;
INSERT INTO `Course` VALUES (1, 'Introduction to Computer Science', 'CS101', 'This course covers basic computer programming concepts.', 'Spring 2022');
INSERT INTO `Course` VALUES (2, 'Calculus I', 'MATH101', 'This course covers limits, derivatives, and integrals of functions of one variable.', 'Spring 2022');
INSERT INTO `Course` VALUES (3, 'Biology I', 'BIO101', 'This course covers cell biology, genetics, and evolution.', 'Spring 2022');
INSERT INTO `Course` VALUES (4, 'World History I', 'HIST101', 'This course covers the history of world civilizations from prehistory to 1500 CE.', 'Spring 2022');
INSERT INTO `Course` VALUES (5, 'Introduction to Psychology', 'PSY101', 'This course covers basic concepts in psychology, including perception, learning, and memory.', 'Spring 2022');
COMMIT;

-- ----------------------------
-- Table structure for Research
-- ----------------------------
DROP TABLE IF EXISTS `Research`;
CREATE TABLE `Research` (
  `research_id` int NOT NULL AUTO_INCREMENT,
  `teacher_id` int NOT NULL,
  `research_topic` varchar(100) NOT NULL,
  `paper_title` varchar(100) DEFAULT NULL,
  `paper_journal` varchar(100) DEFAULT NULL,
  `paper_date` date DEFAULT NULL,
  `paper_volume` int DEFAULT NULL,
  `paper_issue` int DEFAULT NULL,
  `paper_pages` varchar(20) DEFAULT NULL,
  `award_name` varchar(50) DEFAULT NULL,
  `award_date` date DEFAULT NULL,
  PRIMARY KEY (`research_id`),
  KEY `teacher_id` (`teacher_id`),
  CONSTRAINT `research_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `Teacher` (`teacher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of Research
-- ----------------------------
BEGIN;
INSERT INTO `Research` VALUES (1, 1, 'Machine Learning', 'An Introduction to Machine Learning', 'IEEE Transactions on Neural Networks and Learning Systems', '2022-01-01', 10, 2, '100-115', 'Best Paper Award', '2022-05-01');
INSERT INTO `Research` VALUES (2, 2, 'Computer Vision', 'A Survey of Computer Vision Techniques', 'International Journal of Computer Vision', '2022-02-15', 5, 3, '50-65', NULL, NULL);
INSERT INTO `Research` VALUES (3, 1, 'Natural Language Processing', 'A Comprehensive Study of Natural Language Processing', 'Journal of Machine Learning Research', '2022-03-01', 8, 1, '80-95', NULL, NULL);
INSERT INTO `Research` VALUES (4, 3, 'Robotics', 'Robotic Control and Planning', 'IEEE Robotics and Automation Letters', '2022-04-20', 3, 4, '20-35', 'Best Paper Award', '2022-08-01');
COMMIT;

-- ----------------------------
-- Table structure for Schedule
-- ----------------------------
DROP TABLE IF EXISTS `Schedule`;
CREATE TABLE `Schedule` (
  `schedule_id` int NOT NULL AUTO_INCREMENT,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `teacher_id` int DEFAULT NULL,
  `section_id` int DEFAULT NULL,
  PRIMARY KEY (`schedule_id`),
  KEY `teacher_id` (`teacher_id`),
  KEY `section_id` (`section_id`),
  CONSTRAINT `schedule_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `Teacher` (`teacher_id`),
  CONSTRAINT `schedule_ibfk_2` FOREIGN KEY (`section_id`) REFERENCES `Section` (`section_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of Schedule
-- ----------------------------
BEGIN;
INSERT INTO `Schedule` VALUES (7, '2022-09-01', '2022-12-31', 1, 1);
INSERT INTO `Schedule` VALUES (8, '2022-09-01', '2022-12-31', 2, 2);
INSERT INTO `Schedule` VALUES (9, '2022-09-01', '2022-12-31', 3, 3);
COMMIT;

-- ----------------------------
-- Table structure for Section
-- ----------------------------
DROP TABLE IF EXISTS `Section`;
CREATE TABLE `Section` (
  `section_id` int NOT NULL AUTO_INCREMENT,
  `section_number` int NOT NULL,
  `days` varchar(10) NOT NULL,
  `start_time` time NOT NULL,
  `end_time` time NOT NULL,
  `location` varchar(50) DEFAULT NULL,
  `course_id` int DEFAULT NULL,
  PRIMARY KEY (`section_id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `section_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `Course` (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of Section
-- ----------------------------
BEGIN;
INSERT INTO `Section` VALUES (1, 101, 'Monday', '08:00:00', '10:00:00', 'Room 101', 1);
INSERT INTO `Section` VALUES (2, 102, 'Tuesday', '10:00:00', '12:00:00', 'Room 102', 1);
INSERT INTO `Section` VALUES (3, 201, 'Monday', '13:00:00', '15:00:00', 'Room 201', 2);
INSERT INTO `Section` VALUES (4, 202, 'Wednesday', '15:00:00', '17:00:00', 'Room 202', 2);
INSERT INTO `Section` VALUES (5, 301, 'Friday', '10:00:00', '12:00:00', 'Room 301', 3);
INSERT INTO `Section` VALUES (6, 302, 'Tuesday', '15:00:00', '17:00:00', 'Room 302', 3);
COMMIT;

-- ----------------------------
-- Table structure for Student
-- ----------------------------
DROP TABLE IF EXISTS `Student`;
CREATE TABLE `Student` (
  `student_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `enrollment_date` date NOT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of Student
-- ----------------------------
BEGIN;
INSERT INTO `Student` VALUES (1, 'Alice', 'alice@example.com', '2022-01-01');
INSERT INTO `Student` VALUES (2, 'Bob', 'bob@example.com', '2022-01-01');
INSERT INTO `Student` VALUES (3, 'Charlie', 'charlie@example.com', '2022-01-01');
INSERT INTO `Student` VALUES (4, 'David', 'david@example.com', '2022-01-01');
INSERT INTO `Student` VALUES (5, 'Emma', 'emma@example.com', '2022-01-01');
COMMIT;

-- ----------------------------
-- Table structure for substitute
-- ----------------------------
DROP TABLE IF EXISTS `substitute`;
CREATE TABLE `substitute` (
  `id` int NOT NULL AUTO_INCREMENT,
  `original_teacher_id` int NOT NULL,
  `substitute_teacher_id` int NOT NULL,
  `course_id` int NOT NULL,
  `substitute_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `original_teacher_id` (`original_teacher_id`),
  KEY `substitute_teacher_id` (`substitute_teacher_id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `substitute_ibfk_1` FOREIGN KEY (`original_teacher_id`) REFERENCES `teacher` (`teacher_id`),
  CONSTRAINT `substitute_ibfk_2` FOREIGN KEY (`substitute_teacher_id`) REFERENCES `teacher` (`teacher_id`),
  CONSTRAINT `substitute_ibfk_3` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of substitute
-- ----------------------------
BEGIN;
INSERT INTO `substitute` VALUES (1, 1, 2, 1, '2023-04-13 14:22:47');
COMMIT;

-- ----------------------------
-- Table structure for Teacher
-- ----------------------------
DROP TABLE IF EXISTS `Teacher`;
CREATE TABLE `Teacher` (
  `teacher_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `subject` varchar(50) DEFAULT NULL,
  `experience` int DEFAULT NULL,
  `certification` varchar(50) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`teacher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of Teacher
-- ----------------------------
BEGIN;
INSERT INTO `Teacher` VALUES (1, 'John Doe', 'johndoe@example.com', '1234', 'Mathematics', 5, 'Certified Math Teacher', '123456', '1', '1');
INSERT INTO `Teacher` VALUES (2, 'Jane Doe', 'janedoe@example.com', '12345', 'Science', 8, 'Certified Science Teacher', '123456', '1', '1');
INSERT INTO `Teacher` VALUES (3, 'Mike Smith', 'mikesmith@example.com', '123', 'History', 3, 'Certified History Teacher', '123456', '1', '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
