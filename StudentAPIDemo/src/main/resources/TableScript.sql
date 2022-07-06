

CREATE TABLE student(
    id int AUTO_INCREMENT,
    name varchar(30),
    email varchar(50),
    dob DATE,
    country varchar(30),
    constraint ps_id_pk primary key (id)
);

INSERT INTO `student`(`id`, `name`, `email`, `dob`, `country`) VALUES (1,"jaydeep","jj@gmail.com",sysdate() - interval 9000 day,"INDIA");
INSERT INTO `student`(`id`, `name`, `email`, `dob`, `country`) VALUES (2,"steve","steve@gmail.com",sysdate() - interval 7800 day,"USA");
commit;