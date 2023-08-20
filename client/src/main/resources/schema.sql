DROP TABLE IF EXISTS client cascade;

CREATE TABLE client
(
    client_id     INT AUTO_INCREMENT PRIMARY KEY,
    reg_num       INT           NOT NULL,
    password      varchar(60)   NOT NULL,
    first_name    varchar2(250),
    last_name     varchar2(250),
    passport_num  INT           NOT NULL,
    create_dt     timestamp,
    is_active     boolean
);