-- 查询班级名称以及学生人数
SELECT className AS '班级名称',COUNT(*) AS '学生人数'
FROM Student JOIN Class ON Student.classID = Class.classID
GROUP BY Class.className
ORDER BY COUNT(*) DESC

-- 查询选修100001课程，没有选修200000课程的学生
SELECT
	studentName AS '学生姓名' 
FROM
	Student 
WHERE
	studentID = ANY ( SELECT studentID FROM Grade WHERE courseID = '100001' EXCEPT SELECT studentID FROM Grade WHERE courseID = '200000' )

-- 查询学生信息，条件：学分比2018001班级学生都高
SELECT *
FROM Student
WHERE credithour>ALL(SELECT credithour FROM Student WHERE classID =2018001)
