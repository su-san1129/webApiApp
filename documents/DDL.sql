create table users (
  id serial
  , name varchar(50) not null
  , email varchar(50) not null unique
  , password varchar(100) not null
  , weight double precision
  , height double precision
  , birth_day date
) ;

create table weights (
  id serial
  , user_id integer not null
  , name varchar(50) not null
  , weight double precision not null
  , body_fat_parcentage double precision
  , created_at date not null
  , updated_at date
) ;