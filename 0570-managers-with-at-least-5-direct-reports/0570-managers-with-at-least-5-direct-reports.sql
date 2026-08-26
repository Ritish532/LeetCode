# Write your MySQL query statement below
select m.name as name
from employee as e
join employee as m
on e.managerId = m.id
group by m.id
having count(*) >= 5;