CREATE TABLE `order` (
                         id BIGINT NOT NULL AUTO_INCREMENT,
                         status VARCHAR(10),
                         created_by BIGINT,
                         last_modified_by BIGINT,
                         created_date DATE,
                         created_at DATETIME(6),
                         last_modified_at DATETIME(6),
                         orderPrice VARCHAR(100),
                         dateTime DATE,
                         customer_id BIGINT,
                         employee_id BIGINT,
                         plane_id BIGINT,
                         PRIMARY KEY (id),
                         CONSTRAINT `employee_id_fk` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
                         CONSTRAINT `customer_id_fk` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
                         CONSTRAINT `plane_id_fk` FOREIGN KEY (`plane_id`) REFERENCES `plane` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;
