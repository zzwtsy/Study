-- 创建视图
CREATE VIEW V_Student_Guest3(姓名,性别)
-- 对视图脚本加密
WITH ENCRYPTION
AS
SELECT studentName,sex FROM Student
WITH CHECK 

--
CREATE VIEW V_Girls ( 学号,姓名,性别,出生日期,班级,专业名称 ) 
AS
SELECT
	studentID,
	studentName,
	sex,
	birthday,
	className,
	specialityName
FROM
	Student
	JOIN Class ON Student.classID= Class.classID
	JOIN Speciality ON Speciality.specialityID= Class.specialityID 
-- 条件，修改成绩的视图必时须符合这个条件
WHERE
	Student.sex= '女'
WITH CHECK OPTION

--创建视图V_GradeAVG，包含学生姓名、各科成绩的平均分等信息
CREATE VIEW V_GradeAVG ( 姓名,平均分 ) 
WITH ENCRYPTION
AS SELECT
studentName,
AVG ( Grade.score ) 
FROM
	Student
	JOIN Grade ON Student.studentID= Grade.studentID 
GROUP BY
	Student.studentName
-- 使用视图
SELECT * FROM V_GradeAVG
WHERE 平均分>85

-- 修改：如果是聚合函数不可修改