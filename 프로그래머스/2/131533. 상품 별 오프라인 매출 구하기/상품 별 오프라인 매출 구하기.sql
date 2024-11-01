-- 코드를 입력하세요
SELECT product_code, sum(price * sales_amount) as sales
from product as p join offline_sale as s
on p.product_id = s.product_id
group by p.product_id
order by sales desc,
product_code asc;