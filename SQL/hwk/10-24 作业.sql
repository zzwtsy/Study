--1、仅向普通用户返回学号与姓名两列。(部分列)
SELECT 学号=studentID,姓名= studentName FROM Student

--2、查看所有学生的详细信息。(* 代替所有的列)
SELECT * FROM Student

--3、查看学号为“0711001”的学生详细信息。
SELECT * FROM Student
WHERE studentID='0711001'

--4、查看少数民族的学生信息。（比较表达式）
SELECT * FROM Student
WHERE nation<>'汉'
--5、查询姓李的学生信息。（模糊查询）
SELECT * FROM Student
WHERE studentName LIKE '李%'
--6、查询1987年出生的学生详细信息。(between and 范围查询)
SELECT * FROM Student
WHERE birthday BETWEEN '1987-1-1' AND '1987-12-31'
--成绩在80到90之间的信息
--方法一
SELECT * FROM Student
WHERE credithour BETWEEN 80 AND 90
--方法二
SELECT * FROM Student
WHERE credithour>=80 AND credithour<=90
--7、查询1987年出生的男生的详细信息。（多条件查询 要用and、or、not 进行连接）
SELECT * FROM Student
WHERE YEAR(birthday)=1987 AND sex='男'

--8、查询来自合肥、芜湖、六安的学生详细信息。(列表查询)
--方法一
SELECT * FROM Student
WHERE address = '合肥' OR address = '芜湖' OR address = '六安'
--方法二
SELECT * FROM Student
WHERE address IN('合肥','芜湖','六安')

--9、查询未登记电话的学生信息 。
SELECT * FROM Student
WHERE telephone IS NULL

--10、按年龄升序显示所有学生信息 。
SELECT * FROM Student
ORDER BY
	birthday DESC

--11、查看年龄最大的4个学生详细信息。(top n 取前面n条记录，top n percent 前n%条记录)
SELECT TOP(4) * FROM Student
ORDER BY
	birthday ASC

--12、查看学分最高的前10%的学生信息。
SELECT TOP 10 PERCENT WITH TIES * FROM Student
ORDER BY
	credithour DESC

--13、显示学生的生源地。(消除重复行)
SELECT DISTINCT address as 生源地 FROM Student