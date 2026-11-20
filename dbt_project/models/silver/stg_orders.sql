select
    order_id,
    customer_id,
    cast(order_dt as date)        as order_dt,
    upper(trim(city_nm))          as city_nm,
    region_cd,
    order_status,
    cast(gross_amt as decimal(18,2))    as gross_amt,
    cast(discount_amt as decimal(18,2)) as discount_amt
from {{ source('bronze', 'orders_raw') }}
