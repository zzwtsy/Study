SELECT 
	AVG	( score ) AS '平均分',
	MAX ( score ) AS '最高分',
	MIN ( score ) AS '最低分' 
FROM
	Grade
WHERE studentID = 1811032

SELECT 
	courseID,
	AVG ( score ) AS '平均分'
FROM 
	Grade
GROUP BY 
	courseID

-- 统计学生表中每个班级的人数，人数小于5的班级
SELECT * FROM Student
WHERE 5>ALL (SELECT COUNT(classID) FROM Student GROUP BY classID)
