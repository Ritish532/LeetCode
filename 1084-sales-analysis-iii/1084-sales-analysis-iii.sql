# Write your MySQL query statement below
select s.product_id , product_name
from sales as s
join product as p
on s.product_id = p.product_id
group by s.product_id
having min(year(s.sale_date)) = 2019 
    and max(year(s.sale_date)) = 2019
    and min(month(s.sale_date)) >= 1
    and max(month(s.sale_date)) <= 3;