-- Inicialización de la base de datos cluedo
-- Compatible con MySQL 8.0 y docker-entrypoint-initdb.d

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;

-- ===============================
--   TABLA: usuarios
-- ===============================

CREATE TABLE usuarios (
                          nombre VARCHAR(30) NOT NULL,
                          contrasena VARCHAR(30) NOT NULL,
                          PRIMARY KEY (nombre)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO usuarios (nombre, contrasena) VALUES
    ('pascual', 'pascual');

-- ===============================
--   TABLA: puntuaciones
-- ===============================

CREATE TABLE puntuaciones (
                              id INT NOT NULL AUTO_INCREMENT,
                              nombre VARCHAR(30) DEFAULT NULL,
                              puntos INT(10) DEFAULT NULL,
                              PRIMARY KEY (id),
                              KEY nombre (nombre),
                              CONSTRAINT puntuaciones_ibfk_1 FOREIGN KEY (nombre) REFERENCES usuarios (nombre)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

COMMIT;
