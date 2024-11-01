-- 코드를 작성해주세요
with year_data as(
select year(DIFFERENTIATION_DATE) as year, max(size_of_colony) as year_max
from ecoli_data
group by year
)

select year(DIFFERENTIATION_DATE) as year, (d.year_max - size_of_colony) as year_dev, id 
from ecoli_data as e join year_data as d
on year(e.DIFFERENTIATION_DATE) = d.year
order by year asc,
year_dev asc;