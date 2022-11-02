--查询列 studentname,classname
--表  student,class
--条件 student.classid=class.classid
--查询学生名字和班级名称
--方法一、
select studentname as '姓名','班级名称'=classname
from student as s,class as c
where s.classID=c.classID
--方法二
--内连接 只返回完全符合连接条件的记录
select studentname,classname
from student as s inner join class as c on s.classID=c.classID 

--左外连接 返回满足连接条件的记录和左表中不符合连接条件的记录
select studentname,classname
from student as s left  outer join class as c on s.classID=c.classID 

--右外连接   返回满足连接条件的记录和右表中不符合连接条件的记录
select studentname,classname
from student as s right   outer join class as c on s.classID=c.classID 
--全外连接
select studentname,classname
from student as s full   outer join class as c on s.classID=c.classID 
--交叉连接
--查询所有学生选课的可能性
select studentname,Coursename
from student cross join  course

--查询每个学生各门课程的成绩。
--列 studentname,coursename,grade
--表 student，course，grade
--连接条件 student.studentid=grade.studentid 
 --        course.courseid=grade.courseid    

 select studentname,coursename,grade
 from student as s join grade  as g on s.studentID=g.studentID
      join Course  as c on g.courseID=c.courseID 

--学生名字，班级名称，专业名称
select * from Student
select * From Class
select * from Speciality

select studentname,classname,Specialityname
from student as s join class as c on s.classID=c.classID
                  join Speciality as sp on c.specialityID=sp.specialityID
--显示全院师生信息
--学生信息
select studentid as '编号',studentname as'姓名'
from student
union all
select teacherid,teachername
from teacher
order by studentname desc