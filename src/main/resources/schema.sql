create table `studentserver`.`student` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    `dob` DATE NOT NULL,
    `department` VARCHAR(50),
    `major` VARCHAR(50)
);