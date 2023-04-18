/*
 Navicat Premium Data Transfer

 Source Server         : mysql_3306
 Source Server Type    : MySQL
 Source Server Version : 80031
 Source Host           : localhost:3306
 Source Schema         : teacher_admin

 Target Server Type    : MySQL
 Target Server Version : 80031
 File Encoding         : 65001

 Date: 18/04/2023 23:17:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
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
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 'Alice', 'alice@example.com', '2022-01-01');
INSERT INTO `student` VALUES (2, 'Bob', 'bob@example.com', '2022-01-01');
INSERT INTO `student` VALUES (3, 'Charlie', 'charlie@example.com', '2022-01-01');
INSERT INTO `student` VALUES (4, 'David', 'david@example.com', '2022-01-01');
INSERT INTO `student` VALUES (5, 'Emma', 'emma@example.com', '2022-01-01');

-- ----------------------------
-- Table structure for substitute
-- ----------------------------
DROP TABLE IF EXISTS `substitute`;
CREATE TABLE `substitute`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `original_teacher_id` int NOT NULL,
  `substitute_teacher_id` int NOT NULL,
  `course_id` int NOT NULL,
  `substitute_time` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `original_teacher_id`(`original_teacher_id` ASC) USING BTREE,
  INDEX `substitute_teacher_id`(`substitute_teacher_id` ASC) USING BTREE,
  INDEX `course_id`(`course_id` ASC) USING BTREE,
  CONSTRAINT `substitute_ibfk_1` FOREIGN KEY (`original_teacher_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `substitute_ibfk_2` FOREIGN KEY (`substitute_teacher_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `substitute_ibfk_3` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of substitute
-- ----------------------------
INSERT INTO `substitute` VALUES (1, 1, 2, 1, '2023-04-13 14:22:47');

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
  PRIMARY KEY (`teacher_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, 'John Doe', 'johndoe@example.com', '1234', 'Mathematics', 5, 'Certified Math Teacher', '123456', '1', '1');
INSERT INTO `teacher` VALUES (2, 'Jane Doe', 'janedoe@example.com', '12345', 'Science', 8, 'Certified Science Teacher', '123456', '1', '1');
INSERT INTO `teacher` VALUES (3, 'Mike Smith', 'mikesmith@example.com', '123', 'History', 3, 'Certified History Teacher', '123456', '1', '1');
INSERT INTO `teacher` VALUES (4, 'Mical Jordan', 'jordan@example.com', '123456', 'BasketBall', 2, 'NBA Champine', '123456', '1', '2');

SET FOREIGN_KEY_CHECKS = 1;
