DROP TABLE IF EXISTS client_data cascade;

CREATE TABLE client
(
    client_id     INT AUTO_INCREMENT PRIMARY KEY,
    reg_num       INT,
    password      varchar(60)   NOT NULL,
    first_name    varchar2(250) NOT NULL,
    last_name     varchar2(250) NOT NULL,
    passport_num  INT           NOT NULL,
    create_dt     timestamp     NOT NULL,
    is_active     boolean
);