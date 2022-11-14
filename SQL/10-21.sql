-- "*" 为代替所有列
SELECT * FROM Class

-- 仅向普通用户返回学生号与姓名

SELECT studentID AS '学号',studentName AS '姓名'
FROM Student

-- 查询学分小于30的学生

SELECT studentName AS '姓名',credithour AS '学分' 
FROM Student 
WHERE credithour < 30

-- 查询民族不是汉族的学生

SELECT * FROM Student WHERE nation<>'汉'

-- 查询包含“程序设计”的课名

SELECT * FROM Course
WHERE coursename LIKE '%程序设计%'

--【任务6-5】查询所有2001年出生的所有男生的详细信息。

SELECT * FROM Student
WHERE YEAR(birthday) LIKE '2001' AND sex='男'

--【任务6-6】查询1999年到2001年之间出生的学生详细信息。

SELECT * FROM Student
WHERE birthday BETWEEN '1999-01-01' AND '2001-12-31'

--【任务6-7】 查询来自合肥和芜湖的学生详细信息。

-- 方法一

SELECT * FROM Student 
WHERE address ='合肥' OR address = '芜湖'

-- 方法二

SELECT * FROM Student
WHERE address IN('合肥','芜湖','六安')

--【任务6-8】 查询电话未登记的学生信息。

SELECT * FROM Student
WHERE telephone IS NULL

--【任务6-9】学生管理人员需要按年龄升序显示所有学生信息。

SELECT * FROM Student
ORDER BY birthday DESC

-- 按学分排序

SELECT * FROM Student
ORDER BY credithour DESC

--【任务6-10】先按照班级升序、再按年龄降序显示所有学生信息。

SELECT * FROM Student
ORDER BY 
	classID ASC,
	birthday DESC
---


--【任务6-11】查看年龄最大的三个学生的详细信息。

SELECT TOP 3 WITH TIES * FROM Student
ORDER BY
	birthday ASC

--【任务6-12】查看学分最高的前10%的学生信息。

SELECT TOP 10 PERCENT WITH TIES * FROM Student
ORDER BY
	credithour DESC

--【任务6-13】学校招生工作人员需要查看学生生源地情况。

SELECT DISTINCT 学生生源地=address FROM Student
ORDER BY
	address ASC

--【任务6-14】查询学生学号、姓名及性别三列数据，并优化结果集的显示。

SELECT 学号=studentID,姓名=studentName,性别=sex FROM Student
ORDER BY
	sex ASC,
	studentID ASC
	
-- 结果集的合并

SELECT studentID,studentName
FROM Student
UNION
SELECT TeacherID,teacherName
FROM Teacher