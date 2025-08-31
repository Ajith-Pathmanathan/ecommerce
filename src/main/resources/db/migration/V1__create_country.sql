create table country(
                        id uuid primary key ,
                        name varchar(255) not null
);
create table city(
                     id uuid primary key ,
                     name varchar(255) not null ,
                     country_id uuid not null references country
);
create table categories(
                           id uuid primary key ,
                           name varchar(255) not null ,
                           description varchar
);
create table products(
                         id uuid primary key ,
                         name varchar(255) not null ,
                         price double precision not null ,
                         description varchar not null ,
                         image_url varchar not null ,
                         stock_quantity INTEGER  check ( stock_quantity>=0 ),
                         created_at date,
                         category_id uuid references categories
);
create table role(
                     id uuid primary key ,
                     name varchar not null ,
                     description varchar
);
create table users(
                      id  uuid primary key ,
                      email varchar not null ,
                      first_name varchar not null ,
                      last_name varchar not null ,
                      phone_number varchar not null ,
                      created_at date,
                      address varchar not null ,
                      country_id uuid references country,
                      city_id uuid references city
);
create table user_role(
                          id uuid primary key ,
                          user_id uuid references users,
                          role_id uuid references role
);
create table order_status(
                             id uuid primary key,
                             name varchar not null
);
create table orders(
                       id uuid primary key ,
                       total_amount double precision not null ,
                       order_date date,
                       count INTEGER not null ,
                       product_id uuid references products,
                       status_id uuid references order_status,
                       user_id uuid references users
);
create table shopping_cart(
                              id uuid primary key ,
                              user_id uuid references users
);
create table card_items(
                           id uuid primary key ,
                           user_id uuid references users,
                           product_id uuid references products,
                           count INTEGER not null
);
create table card(
                     id uuid primary key ,
                     card_number varchar not null ,
                     card_holder_name varchar not null ,
                     expiry_Date date not null ,
                     created_date date not null ,
                     user_id uuid references users,
                     card_type varchar not null
);
create table payment_status(
                               id uuid primary key ,
                               name varchar not null
);
create table payments(
                         id uuid primary key ,
                         amount double precision not null ,
                         payment_date date not null ,
                         transaction_id varchar not null ,
                         card_id uuid references card,
                         order_id uuid references orders,
                         payment_status_id uuid references payment_status
);


