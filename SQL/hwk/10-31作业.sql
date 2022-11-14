/****************************************************************
			实验七 分组汇总查询
一、实验目的：
1.	熟记SELECT语句的语法；
2.	掌握数据分组、汇总的的方法；
3.	掌握数据排序、基本格式设置的方法；
二、实验内容：
*****************************************************************/
-- 附加数据sgms
--1、student 表
--1)统计所有学生人数 
	SELECT COUNT(*) AS '学生人数' FROM Student
--2)按照calssid 分组 统计各班级人数
	SELECT classID AS '班级ID', COUNT(*) AS '学生人数' FROM Student
	GROUP BY classID
--3)按照calssid 分组 统计各班女生级人数
	SELECT classID AS '班级ID', COUNT(*) AS '女学生人数' FROM Student
	WHERE sex = '女'
	GROUP BY classID
--4)按照calssid 分组 统计各班女生级人数，显示女生人数大于5的
	SELECT classID AS '班级ID', COUNT(*) AS '女学生人数' FROM Student
	WHERE sex = '女'
	GROUP BY classID
	HAVING COUNT(*) > 5

--2、grade 表
--1)统计所有学生的总成绩  
	SELECT 
		SUM	( score ) AS '所有学生总成绩'
	FROM
		Grade
--2)统计每个学生的总成绩 
	SELECT 
		学号,
		SUM	( 成绩 ) AS '学生总成绩'
	FROM
		Grade
	GROUP BY 学号
--3)统计学号2018001的学生的总成绩 
	SELECT 
		学号,
		SUM	( 成绩 ) AS '学生总成绩'
	FROM
		Grade
	-- 没有2018001这个学号，我用0711001这个学号替代一下
	WHERE 学号 = '0711001'
	GROUP BY 学号
--4)统计每个学生的总成绩 ，显示总成绩〉300的记录
	SELECT 
		学号,
		SUM	( 成绩 ) AS '学生总成绩'
	FROM
		Grade
	GROUP BY 学号
	HAVING SUM	( 成绩 ) > 300
--5)使用with rollup统计
--3、teacher
--1）统计各个职称教师的人数
SELECT
CASE WHEN ( GROUPING( 职称 ) = 1 ) THEN '人数小计'
		ELSE 职称 
END AS '职称',
		COUNT ( * ) AS '人数' 
	FROM
		Teacher 
	GROUP BY 职称 WITH ROLLUP
--2）统计各个部门，各个职称教师的人数
	SELECT
	CASE WHEN ( GROUPING( 部门名称 ) = 1 ) THEN 'UNKNOWN'
		ELSE 部门名称 
	END AS '部门名称',
	CASE WHEN ( GROUPING( 职称 ) = 1 ) THEN '人数小计'
		ELSE 职称 
	END AS '职称',
		COUNT ( * ) AS '人数' 
	FROM
		Teacher 
	GROUP BY 部门名称,职称 WITH ROLLUP
--3）使用with cube统计
	--1）统计各个职称教师的人数
	SELECT
	CASE WHEN ( GROUPING( 职称 ) = 1 ) THEN '人数小计'
		ELSE 职称 
	END AS '职称',
		COUNT ( * ) AS '人数' 
	FROM
		Teacher 
	GROUP BY 职称 WITH CUBE
	--2）统计各个部门，各个职称教师的人数
	SELECT
	CASE WHEN ( GROUPING( 部门名称 ) = 1 ) THEN 'UNKNOWN'
		ELSE 部门名称 
	END AS '部门名称',
	CASE WHEN ( GROUPING( 职称 ) = 1 ) THEN '人数小计'
		ELSE 职称 
	END AS '职称',
		COUNT ( * ) AS '人数' 
	FROM
		Teacher 
	GROUP BY 部门名称,职称 WITH CUBE

--5、多表查询
--1)查询学生的姓名和班级名称。
	SELECT 姓名,班级名称
	FROM Student JOIN Class
	ON Student.班级编号 = Class.班级编号
	
	SELECT 姓名,班级名称
	FROM Student, Class
	WHERE Student.[班级编号] = Class.[班级编号]
	
	SELECT 姓名,课程编号,班级编号
	FROM Student JOIN Class ON
	
	-- 左外连接
	SELECT [姓名],[班级名称]
	FROM Student LEFT OUTER JOIN Class ON Student.[班级编号] = Class.[班级编号]

	-- 右外连接
	SELECT [姓名],[班级名称]
	FROM Student RIGHT OUTER JOIN Class ON Student.[班级编号] = Class.[班级编号]

	-- 交叉连接
	SELECT [姓名],[班级名称]
	FROM CROSS JOIN Class
	-- 查询学生姓名，课程编号，成绩，显示所有学生
	SELECT [姓名],[课程编号],[成绩]
	FROM LEFT JOIN Class ON Student.[班级编号] = Class.[班级编号]