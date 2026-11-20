select
    customer_id,
    customer_nm,
    coalesce(customer_segment, 'UNKNOWN') as customer_segment,
    created_dt
from {{ source('bronze', 'customers_raw') }}
