/* Populate tabla clientes */

INSERT INTO `db_springboot_backend`.`grados` (`nombre`) VALUES ('7° Grado');
INSERT INTO `db_springboot_backend`.`grados` (`nombre`) VALUES ('8° Grado');
INSERT INTO `db_springboot_backend`.`grados` (`nombre`) VALUES ('9° Grado');
INSERT INTO `db_springboot_backend`.`grados` (`nombre`) VALUES ('Bachillerato');


INSERT INTO `db_springboot_backend`.`alumnos` (`apellidos`, `edad`, `grado`, `nombre`, `nombre_madre`, `nombre_padre`, `nota_final`, `carnet`) VALUES ('Flores', '15', '1', 'Maria', 'Josselyn', 'Pedro', '7.8', 'MF142441');
INSERT INTO `db_springboot_backend`.`alumnos` (`apellidos`, `edad`, `grado`, `nombre`, `nombre_madre`, `nombre_padre`, `nota_final`, `carnet`) VALUES ('Magaña', '13', '1', 'Karina', 'Andrea', 'Pedro', '7.8', 'MF142442');
INSERT INTO `db_springboot_backend`.`alumnos` (`apellidos`, `edad`, `grado`, `nombre`, `nombre_madre`, `nombre_padre`, `nota_final`, `carnet`) VALUES ('Pleitez', '14', '1', 'Guadalupe', 'Stefania', 'Pedro', '7.8', 'MF142443');
INSERT INTO `db_springboot_backend`.`alumnos` (`apellidos`, `edad`, `grado`, `nombre`, `nombre_madre`, `nombre_padre`, `nota_final`, `carnet`) VALUES ('Gónzales', '11', '1', 'Jossie', 'Marta', 'Pedro', '7.8', 'MF142444');
INSERT INTO `db_springboot_backend`.`alumnos` (`apellidos`, `edad`, `grado`, `nombre`, `nombre_madre`, `nombre_padre`, `nota_final`, `carnet`) VALUES ('Nolasco', '16', '1', 'Andrea', 'Margarita', 'Pedro', '7.8', 'MF142445');

INSERT INTO `db_springboot_backend`.`profesores` (`apellidos`, `edad`, `grado`, `nombre`, `sexo`, `titulo`) VALUES ('Góznales', '38', '1', 'Marcos', 'Masculino', 'Profesor');
INSERT INTO `db_springboot_backend`.`profesores` (`apellidos`, `edad`, `grado`, `nombre`, `sexo`, `titulo`) VALUES ('Magaña', '42', '2', 'Maria', 'Femnino', 'Profesora');
INSERT INTO `db_springboot_backend`.`profesores` (`apellidos`, `edad`, `grado`, `nombre`, `sexo`, `titulo`) VALUES ('Aldana', '45', '3', 'Karina', 'Femenino', 'Profesora');