/*
 Navicat Premium Data Transfer

<<<<<<< HEAD
 Source Server         : LocalHost_3306
 Source Server Type    : MySQL
 Source Server Version : 80026
=======
 Source Server         : mysql_3306
 Source Server Type    : MySQL
 Source Server Version : 80031
>>>>>>> 8f55acbc23b45018839edeb24ef50896af27a918
 Source Host           : localhost:3306
 Source Schema         : teacher_admin

 Target Server Type    : MySQL
<<<<<<< HEAD
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 11/05/2023 14:53:35
=======
 Target Server Version : 80031
 File Encoding         : 65001

 Date: 04/05/2023 18:34:22
>>>>>>> 8f55acbc23b45018839edeb24ef50896af27a918
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
<<<<<<< HEAD
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
=======
-- Table structure for assignment
-- ----------------------------
DROP TABLE IF EXISTS `assignment`;
CREATE TABLE `assignment`  (
  `assignment_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `due_date` date NOT NULL,
  `max_points` int NULL DEFAULT NULL,
  `section_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`assignment_id`) USING BTREE,
  INDEX `section_id`(`section_id` ASC) USING BTREE,
  CONSTRAINT `assignment_ibfk_1` FOREIGN KEY (`section_id`) REFERENCES `section` (`section_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of assignment
-- ----------------------------
INSERT INTO `assignment` VALUES (1, 'Essay', 'Written', '2023-05-01', 100, 1);
INSERT INTO `assignment` VALUES (2, 'Presentation', 'Oral', '2023-06-15', 50, 2);
INSERT INTO `assignment` VALUES (3, 'Lab Report', 'Written', '2023-05-10', 75, 3);
INSERT INTO `assignment` VALUES (4, 'Group Project', 'Mixed', '2023-07-01', 150, 4);
INSERT INTO `assignment` VALUES (5, 'Midterm Exam', 'Written', '2023-05-30', 200, 1);
INSERT INTO `assignment` VALUES (6, 'Final Exam', 'Written', '2023-07-15', 300, 5);

-- ----------------------------
-- Table structure for attendance
-- ----------------------------
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance`  (
  `attendance_id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `present` tinyint(1) NULL DEFAULT NULL,
  `student_id` int NULL DEFAULT NULL,
  `section_id` int NULL DEFAULT NULL,
  `teacher_id` int NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`attendance_id`) USING BTREE,
  INDEX `student_id`(`student_id` ASC) USING BTREE,
  INDEX `section_id`(`section_id` ASC) USING BTREE,
  CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `attendance_ibfk_2` FOREIGN KEY (`section_id`) REFERENCES `section` (`section_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of attendance
-- ----------------------------
INSERT INTO `attendance` VALUES (21, '2022-01-03', 1, 1, 1, 1, '2');
INSERT INTO `attendance` VALUES (22, '2022-01-03', 1, 2, 1, 1, '2');
INSERT INTO `attendance` VALUES (23, '2022-01-03', 0, 3, 1, 2, '2');
INSERT INTO `attendance` VALUES (24, '2023-04-13', 1, 1, 1, 2, '1');
INSERT INTO `attendance` VALUES (25, '2023-04-18', 0, 1, 1, 2, '1');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `course_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `semester` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`course_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, 'Introduction to Computer Science', 'CS101', 'This course covers basic computer programming concepts.', 'Spring 2022');
INSERT INTO `course` VALUES (2, 'Calculus I', 'MATH101', 'This course covers limits, derivatives, and integrals of functions of one variable.', 'Spring 2022');
INSERT INTO `course` VALUES (3, 'Biology I', 'BIO101', 'This course covers cell biology, genetics, and evolution.', 'Spring 2022');
INSERT INTO `course` VALUES (4, 'World History I', 'HIST101', 'This course covers the history of world civilizations from prehistory to 1500 CE.', 'Spring 2022');
INSERT INTO `course` VALUES (5, 'Introduction to Psychology', 'PSY101', 'This course covers basic concepts in psychology, including perception, learning, and memory.', 'Spring 2022');

-- ----------------------------
-- Table structure for research
-- ----------------------------
DROP TABLE IF EXISTS `research`;
CREATE TABLE `research`  (
  `research_id` int NOT NULL AUTO_INCREMENT,
  `teacher_id` int NOT NULL,
  `research_topic` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `paper_title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `paper_journal` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `paper_date` date NULL DEFAULT NULL,
  `paper_volume` int NULL DEFAULT NULL,
  `paper_issue` int NULL DEFAULT NULL,
  `paper_pages` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `award_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `award_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`research_id`) USING BTREE,
  INDEX `teacher_id`(`teacher_id` ASC) USING BTREE,
  CONSTRAINT `research_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of research
-- ----------------------------
INSERT INTO `research` VALUES (1, 1, 'Machine Learning', 'An Introduction to Machine Learning', 'IEEE Transactions on Neural Networks and Learning Systems', '2022-01-01', 10, 2, '100-115', 'Best Paper Award', '2022-05-01');
INSERT INTO `research` VALUES (2, 2, 'Computer Vision', 'A Survey of Computer Vision Techniques', 'International Journal of Computer Vision', '2022-02-15', 5, 3, '50-65', NULL, NULL);
INSERT INTO `research` VALUES (3, 1, 'Natural Language Processing', 'A Comprehensive Study of Natural Language Processing', 'Journal of Machine Learning Research', '2022-03-01', 8, 1, '80-95', NULL, NULL);
INSERT INTO `research` VALUES (4, 3, 'Robotics', 'Robotic Control and Planning', 'IEEE Robotics and Automation Letters', '2022-04-20', 3, 4, '20-35', 'Best Paper Award', '2022-08-01');

-- ----------------------------
-- Table structure for schedule
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule`  (
  `schedule_id` int NOT NULL AUTO_INCREMENT,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `teacher_id` int NULL DEFAULT NULL,
  `section_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`schedule_id`) USING BTREE,
  INDEX `teacher_id`(`teacher_id` ASC) USING BTREE,
  INDEX `section_id`(`section_id` ASC) USING BTREE,
  CONSTRAINT `schedule_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `schedule_ibfk_2` FOREIGN KEY (`section_id`) REFERENCES `section` (`section_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of schedule
-- ----------------------------
INSERT INTO `schedule` VALUES (7, '2022-09-01', '2022-12-31', 1, 1);
INSERT INTO `schedule` VALUES (8, '2022-09-01', '2022-12-31', 2, 2);
INSERT INTO `schedule` VALUES (9, '2022-09-01', '2022-12-31', 3, 3);

-- ----------------------------
-- Table structure for section
-- ----------------------------
DROP TABLE IF EXISTS `section`;
CREATE TABLE `section`  (
  `section_id` int NOT NULL AUTO_INCREMENT,
  `section_number` int NOT NULL,
  `days` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `start_time` time NOT NULL,
  `end_time` time NOT NULL,
  `location` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `course_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`section_id`) USING BTREE,
  INDEX `course_id`(`course_id` ASC) USING BTREE,
  CONSTRAINT `section_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of section
-- ----------------------------
INSERT INTO `section` VALUES (1, 101, 'Monday', '08:00:00', '10:00:00', 'Room 101', 1);
INSERT INTO `section` VALUES (2, 102, 'Tuesday', '10:00:00', '12:00:00', 'Room 102', 1);
INSERT INTO `section` VALUES (3, 201, 'Monday', '13:00:00', '15:00:00', 'Room 201', 2);
INSERT INTO `section` VALUES (4, 202, 'Wednesday', '15:00:00', '17:00:00', 'Room 202', 2);
INSERT INTO `section` VALUES (5, 301, 'Friday', '10:00:00', '12:00:00', 'Room 301', 3);
INSERT INTO `section` VALUES (6, 302, 'Tuesday', '15:00:00', '17:00:00', 'Room 302', 3);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `student_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `enrollment_date` date NOT NULL,
  PRIMARY KEY (`student_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 'Alice', 'alice@example.com', '2022-01-01');
INSERT INTO `student` VALUES (2, 'Bob', 'bob@example.com', '2022-01-01');
INSERT INTO `student` VALUES (3, 'Charlie', 'charlie@example.com', '2022-01-01');
INSERT INTO `student` VALUES (4, 'David', 'david@example.com', '2022-01-01');
INSERT INTO `student` VALUES (5, 'Emma', 'emma@example.com', '2022-01-01');
>>>>>>> 8f55acbc23b45018839edeb24ef50896af27a918

-- ----------------------------
-- Table structure for substitute
-- ----------------------------
DROP TABLE IF EXISTS `substitute`;
<<<<<<< HEAD
CREATE TABLE `substitute` (
=======
CREATE TABLE `substitute`  (
>>>>>>> 8f55acbc23b45018839edeb24ef50896af27a918
  `id` int NOT NULL AUTO_INCREMENT,
  `original_teacher_id` int NOT NULL,
  `substitute_teacher_id` int NOT NULL,
  `course_id` int NOT NULL,
  `substitute_time` datetime NOT NULL,
<<<<<<< HEAD
  PRIMARY KEY (`id`),
  KEY `original_teacher_id` (`original_teacher_id`),
  KEY `substitute_teacher_id` (`substitute_teacher_id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `substitute_ibfk_1` FOREIGN KEY (`original_teacher_id`) REFERENCES `teacher` (`teacher_id`),
  CONSTRAINT `substitute_ibfk_2` FOREIGN KEY (`substitute_teacher_id`) REFERENCES `teacher` (`teacher_id`),
  CONSTRAINT `substitute_ibfk_3` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
=======
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `original_teacher_id`(`original_teacher_id` ASC) USING BTREE,
  INDEX `substitute_teacher_id`(`substitute_teacher_id` ASC) USING BTREE,
  INDEX `course_id`(`course_id` ASC) USING BTREE,
  CONSTRAINT `substitute_ibfk_1` FOREIGN KEY (`original_teacher_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `substitute_ibfk_2` FOREIGN KEY (`substitute_teacher_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `substitute_ibfk_3` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;
>>>>>>> 8f55acbc23b45018839edeb24ef50896af27a918

-- ----------------------------
-- Records of substitute
-- ----------------------------
<<<<<<< HEAD
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
=======
INSERT INTO `substitute` VALUES (1, 1, 2, 1, '2023-04-13 14:22:47');
INSERT INTO `substitute` VALUES (2, 2, 3, 1, '2023-04-29 16:00:00');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `teacher_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `subject` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `experience` int NULL DEFAULT NULL,
  `certification` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `permission` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `title` int NULL DEFAULT NULL,
  PRIMARY KEY (`teacher_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, 'John Doe', 'johndoe@example.com', '1234', 'Mathematics', 5, 'Certified Math Teacher', '123456', '1', '1', 2);
INSERT INTO `teacher` VALUES (2, 'Jane Doe', 'janedoe@example.com', '12345', 'Science', 8, 'Certified Science Teacher', '123456', '1', '1', 1);
INSERT INTO `teacher` VALUES (3, 'Mike Smith', 'mikesmith@example.com', '123', 'History', 3, 'Certified History Teacher', '123456', '1', '1', 3);
INSERT INTO `teacher` VALUES (4, 'Mical Jordan', 'jordan@example.com', '123456', 'BasketBall', 2, 'NBA Champine', '123456', '1', '2', 4);

-- ----------------------------
-- Table structure for title
-- ----------------------------
DROP TABLE IF EXISTS `title`;
CREATE TABLE `title`  (
  `title_id` int NOT NULL,
  `title_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `title_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`title_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of title
-- ----------------------------
INSERT INTO `title` VALUES (1, '三级教师', '基本掌握教育学生的原则和方法，能够正确教育和引导学生，具有教育学、心理学和教学法的基础知识，具备大学专科毕业学历，并在小学、初中教育教学岗位见习1年期满并考核合格；或者具备中等师范学校毕业学历，并在小学教育教学岗位见习1年期满并考核合格。');
INSERT INTO `title` VALUES (2, '二级教师', '具备硕士学位；或者具备学士学位或者大学本科毕业学历，见习期1年期满并考核合格；或者具备大学专科毕业学历，并在小学、初中三级教师岗位任教2年以上；或者具备中等师范学校毕业学历，并在小学三级教师岗位任教3年以上。');
INSERT INTO `title` VALUES (3, '一级教师', '具备博士学位；或者具备硕士学位，并在二级教师岗位任教2年以上；或者具备学士学位或者大学本科毕业学历，并在二级教师岗位任教4年以上；或者具备大学专科毕业学历，并在小学、初中二级教师岗位任教4年以上；或者具备中等师范学校毕业学历，并在小学二级教师岗位任教5年以上。');
INSERT INTO `title` VALUES (4, '高级教师', '具备博士学位，并在一级教师岗位任教2年以上；或者具备硕士学位、学士学位、大学本科毕业学历，并在一级教师岗位任教5年以上；或者具备大学专科毕业学历，并在小学、初中一级教师岗位任教5年以上。城镇中小学教师原则上要有1年以上在薄弱学校或农村学校任教经历。');
INSERT INTO `title` VALUES (5, '正高级教师', '具有崇高的职业理想和坚定的职业信念；长期工作在教育教学第一线，为促进青少年学生健康成长发挥了指导者和引路人的作用，出色地完成班主任、辅导员等工作任务，教书育人成果突出；一般应具有大学本科及以上学历，并在高级教师岗位任教5年以上。');
>>>>>>> 8f55acbc23b45018839edeb24ef50896af27a918

SET FOREIGN_KEY_CHECKS = 1;
