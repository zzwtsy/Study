--��ѯ�� studentname,classname
--��  student,class
--���� student.classid=class.classid
--��ѯѧ�����ֺͰ༶����
--����һ��
select studentname as '����','�༶����'=classname
from student as s,class as c
where s.classID=c.classID
--������
--������ ֻ������ȫ�������������ļ�¼
select studentname,classname
from student as s inner join class as c on s.classID=c.classID 

--�������� �����������������ļ�¼������в��������������ļ�¼
select studentname,classname
from student as s left  outer join class as c on s.classID=c.classID 

--��������   �����������������ļ�¼���ұ��в��������������ļ�¼
select studentname,classname
from student as s right   outer join class as c on s.classID=c.classID 
--ȫ������
select studentname,classname
from student as s full   outer join class as c on s.classID=c.classID 
--��������
--��ѯ����ѧ��ѡ�εĿ�����
select studentname,Coursename
from student cross join  course

--��ѯÿ��ѧ�����ſγ̵ĳɼ���
--�� studentname,coursename,grade
--�� student��course��grade
--�������� student.studentid=grade.studentid 
 --        course.courseid=grade.courseid    

 select studentname,coursename,grade
 from student as s join grade  as g on s.studentID=g.studentID
      join Course  as c on g.courseID=c.courseID 

--ѧ�����֣��༶���ƣ�רҵ����
select * from Student
select * From Class
select * from Speciality

select studentname,classname,Specialityname
from student as s join class as c on s.classID=c.classID
                  join Speciality as sp on c.specialityID=sp.specialityID
--��ʾȫԺʦ����Ϣ
--ѧ����Ϣ
select studentid as '���',studentname as'����'
from student
union all
select teacherid,teachername
from teacher
order by studentname desc