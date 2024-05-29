create table if not exists order_lines(
    id bigserial not null primary key,
    order_id bigint not null,
    product_id bigint not null,
    quantity double precision not null,
    foreign key (order_id) references orders(id)
)