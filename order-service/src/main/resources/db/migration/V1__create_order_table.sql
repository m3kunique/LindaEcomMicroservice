create table if not exists orders
(
    id               bigserial        not null primary key,
    reference        text             not null,
    total_amount     numeric(38,2) not null,
    payment_method   varchar(255) check ( trim(payment_method) in
                                          ('VISA', 'MASTERCARD', 'BITCOIN', 'CREDIT_CARD', 'PAYPAL')),
    customer_id      varchar(255)     not null,
    created_date      timestamp        not null,
    last_modified_date timestamp        not null
)