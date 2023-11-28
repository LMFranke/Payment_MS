
CREATE TABLE payments (
     id bigint(20) NOT NULL AUTO_INCREMENT,
     amount decimal(19,2) NOT NULL,
     name varchar(60) DEFAULT NULL,
     number varchar(16) DEFAULT NULL,
     expire varchar(7) DEFAULT NULL,
     code varchar(3) DEFAULT NULL,
     status varchar(255) NOT NULL,
     form_payment_id bigint(20) NOT NULL,
     request_id bigint(20) NOT NULL,
     PRIMARY KEY (id)
);