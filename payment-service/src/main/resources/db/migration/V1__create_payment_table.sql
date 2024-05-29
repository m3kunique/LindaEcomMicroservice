create table if not exists payments
(
    id                 bigserial      not null primary key,
    amount             numeric(38, 2) not null,
    payment_method     varchar(255) check ( trim(payment_method) in
                                            ('VISA', 'MASTERCARD', 'BITCOIN', 'CREDIT_CARD', 'PAYPAL')),
    order_id            bigint         not null,
    created_date       timestamp      not null,
    last_modified_date timestamp      not null
)