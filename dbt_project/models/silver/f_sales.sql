select
    o.order_dt                    as sale_dt,
    o.city_nm,
    o.region_cd,
    c.customer_segment,
    count(distinct o.order_id)    as order_cnt,
    sum(o.gross_amt)              as net_revenue_amt
from {{ ref('stg_orders') }} o
join {{ ref('d_customer') }} c
  on o.customer_id = c.customer_id
group by 1, 2, 3, 4
