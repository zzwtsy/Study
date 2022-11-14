USE SGMS
SELECT
	courseID AS '学号',
	AVG ( score ) AS '平均分',
	MAX ( score ) AS '最高分',
	MIN ( score ) AS '最低分' 
FROM
	Grade
GROUP BY
	courseID
HAVING AVG ( score ) < 80

-- 显示人数小于5的班级
SELECT
	classID AS '班级ID',
	COUNT ( * ) AS '学生数' 
FROM
	Student 
WHERE
	sex = '女' 
GROUP BY
	classID 
HAVING
	COUNT ( * ) < 5
	
-- 
SELECT
CASE
	WHEN
		GROUPING( ( 班级编号 ) = 1 ) THEN
			'性别人数小计' ELSE ISNULL( 班级编号, 'UNKNOWN' )
	END
	AS '班级',
CASE 
	WHEN GROUPING((性别)=1) THEN ''班级人数小计
	ELSE statement_list
END

