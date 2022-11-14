CREATE DATABASE DB_LIBRARY
CREATE TABLE T_Books (
  书号 char(6) NOT NULL PRIMARY KEY,
  书名 varchar(50) NOT NULL,
  作者 varchar(50) NOT NULL,
  数量 int  NULL CHECK (数量 > 0),
  单价 float(53) NULL,
  出版社名称 varchar(40)  NULL
  )
	
UPDATE T_Books
SET 单价=49
WHERE 书号 = '1111'

DELETE FROM T_Books
WHERE 书名='asda'

SELECT * FROM T_Books
WHERE 单价>30

SELECT * FROM T_Books
WHERE 书名 LIKE '%j%'

SELECT 书名,姓名,借书日期,还书日期
FROM T_Books
JOIN B ON T_Books.[书号]=B.[书号]
JOIN A ON B.[学号]=A.[学号]

SELECT 出版社名称,COUNT(*) AS 图书数量
FROM T_Books
GROUP BY 出版社名称

SELECT * FROM T_Bowwow
WHERE 学号 = (SELECT 学号 FROM T_Readers WHERE 院系='信息技术学院')