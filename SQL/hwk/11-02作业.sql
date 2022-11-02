--查询列 studentname,classname
--表  student,class
--条件 student.classid=class.classid
--查询学生名字和班级名称
--方法一、
SELECT studentName AS '学生姓名',className AS '班级名称'
FROM Student, Class
WHERE Student.classID = Class.classID 
--方法二
--内连接 只返回完全符合连接条件的记录
SELECT 
	studentName AS '学生姓名',className AS '班级名称'
FROM 
	Student JOIN Class ON Student.classID = Class.classID
--左外连接 返回满足连接条件的记录和左表中不符合连接条件的记录
SELECT 
	studentName AS '学生姓名',className AS '班级名称'
FROM 
	Student LEFT OUTER JOIN Class ON Student.classID = Class.classID

--右外连接   返回满足连接条件的记录和右表中不符合连接条件的记录
SELECT 
	studentName AS '学生姓名',className AS '班级名称'
FROM 
	Student RIGHT OUTER JOIN Class ON Student.classID = Class.classID
--全外连接
SELECT 
	studentName AS '学生姓名',className AS '班级名称'
FROM 
	Student FULL OUTER JOIN Class ON Student.classID = Class.classID
--交叉连接
--查询所有学生选课的可能性
SELECT 
	studentName AS '学生姓名',courseName AS '课程名称'
FROM 
	Student CROSS JOIN Course
--查询每个学生各门课程的成绩。
--列 studentname,coursename,grade
--表 student，course，grade
--连接条件 student.studentid=grade.studentid 
 --        course.courseid=grade.courseid    

SELECT 
	studentName AS '学生姓名',
	courseName AS '课程名称',
	score AS '成绩'
FROM 
	Student JOIN Grade ON Student.studentID = Grade.studentID
	JOIN Course ON Grade.courseID = Course.courseID

--学生名字，班级名称，专业名称
SELECT * FROM Student
	
SELECT * FROM	Class
	
SELECT * FROM	Speciality

SELECT
	studentName AS '学生姓名',
	className AS '课程名称',
	specialityName AS '专业名称'
FROM
	Student JOIN class ON Student.classID= Class.classID
	JOIN Speciality ON Class.specialityID= Speciality.specialityID
--显示全院师生信息
--学生信息
SELECT
	studentID AS '编号',
	studentName AS '姓名'
FROM
	Student UNION ALL
SELECT
	TeacherID,
	teacherName 
FROM
	Teacher 
ORDER BY
	studentName DESC