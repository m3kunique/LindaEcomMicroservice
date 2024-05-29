create table if not exists products
(
    id                bigserial primary key,
    name              varchar(255) check ( length(trim(name)) > 3) not null,
    description       text                                         not null,
    available_quantity double precision                             not null,
    price             numeric(38, 2)                               not null,
    category_id       bigint                                       not null,
    foreign key (category_id) references categories (id)
)