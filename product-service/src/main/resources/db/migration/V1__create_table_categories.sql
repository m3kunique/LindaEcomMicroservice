create table if not exists categories
(
    id          bigserial primary key,
    name        varchar(255) check ( length(trim(name)) > 3) not null,
    description text                                         not null
)