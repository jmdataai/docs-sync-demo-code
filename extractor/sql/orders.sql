SELECT
    order_id,
    customer_id,
    order_dt,
    city_nm,
    region_cd,
    order_status,
    gross_amt,
    discount_amt
FROM {source_table}
WHERE order_dt >= DATEADD(month, -36, CURRENT_DATE)
