USE `jpa_manytomany`;
DROP TABLE IF EXISTS `course_teacher`;
CREATE TABLE `course_teacher` (
  `courseId` int(10) unsigned NOT NULL,
  `teacherId` varchar unsigned NOT NULL,
  PRIMARY KEY (courseId,teacherId),
  KEY `fk_bookpublisher_publisher_idx` (`taecherId`),
  CONSTRAINT `fk_bookpublisher_book` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_bookpublisher_publisher` FOREIGN KEY (`teacherId`) REFERENCES `publisher` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
)