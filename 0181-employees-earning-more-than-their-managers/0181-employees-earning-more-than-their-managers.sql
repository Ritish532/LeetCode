# Write your MySQL query statement below
select A.name as Employee
from Employee as A
where A.salary > (select salary from Employee where A.managerId = id);