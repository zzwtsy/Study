USE SGMS
GO

-- 查询学生姓名，以及该学生的平均分
SELECT studentName AS '学生姓名',AVG(score) AS '平均分'
FROM Student JOIN Grade ON Student.studentID = Grade.studentID
GROUP BY studentName
ORDER BY '平均分' ASC

-- 查询选修过课程的学生详细信息

SELECT * FROM Student
WHERE studentID IN (SELECT studentID FROM Grade)

-- 查询没有学生的班级详细信息
SELECT * FROM Class
WHERE classID NOT IN (SELECT classID FROM Student)

-- 查询'木子'同班同学的学生信息
SELECT * FROM Student 
WHERE 
	classID = (SELECT classID FROM Student WHERE studentName='木子')
	AND studentName<>'木子'
-- 查询大于来自合肥的所有学生年龄的学生信息
SELECT
	* 
FROM
	Student 
WHERE
	birthday < ALL ( SELECT birthday FROM Student WHERE address = '合肥' ) 
	AND address <> '合肥'
ORDER BY birthday DESC
	
	