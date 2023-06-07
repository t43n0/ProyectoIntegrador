<<<<<<< HEAD
CREATE DATABASE DDBB;

USE DDBB;

CREATE TABLE Usuario (
  Dni VARCHAR2(10) PRIMARY KEY,
  Nombre VARCHAR2(50),
  Apellido VARCHAR2(50),
  Email VARCHAR2(100),
  Contraseña VARCHAR2(100),
  Teléfono VARCHAR2(20),
  Dirección VARCHAR2(100)
);

CREATE TABLE Pista (
  ID_Pista INT PRIMARY KEY,
  Nombre VARCHAR2(100),
  Tipo VARCHAR2(100),
  Disponibilidad VARCHAR2(100)
);

CREATE TABLE Reserva (
  ID_Reserva INT PRIMARY KEY,
  Dni VARCHAR2(10),
  ID_Pista INT,
  Fecha DATE,
  HoraInicio TIME,
  HoraFin TIME,
  FOREIGN KEY (Dni) REFERENCES Usuario(Dni),
  FOREIGN KEY (ID_Pista) REFERENCES Pista(ID_Pista)
);

CREATE TABLE ReservaUsuario (
  ID_Reserva INT,
  Dni VARCHAR2(10),
  FOREIGN KEY (ID_Reserva) REFERENCES Reserva(ID_Reserva),
  FOREIGN KEY (Dni) REFERENCES Usuario(Dni)
);

INSERT INTO Usuario (Dni, Nombre, Apellido, Email, Contraseña, Teléfono, Dirección)
VALUES ('12345678A', 'Juan', 'Pérez', 'juan@example.com', 'password123', '123456789', 'Calle Ejemplo 123'),
       ('87654321B', 'María', 'López', 'maria@example.com', 'abc123', '987654321', 'Avenida Principal 456'),
       ('12', 'Pedro', 'García', 'pedro@example.com', '12', '123456789', 'Calle Ejemplo 321 ');

INSERT INTO Pista (ID_Pista, Nombre, Tipo, Disponibilidad)
VALUES (1, 'Pista de Tenis', 'Tenis', 'Disponible'),
       (2, 'Pista de Fútbol', 'Fútbol', 'No Disponible'),
       (3, 'Pista de Pádel', 'Pádel', 'Disponible');


INSERT INTO Reserva (ID_Reserva, Dni, ID_Pista, Fecha, HoraInicio, HoraFin)
VALUES (1, '12345678A', 1, '2023-06-01', '10:00:00', '12:00:00'),
       (2, '87654321B', 2, '2023-06-02', '14:00:00', '16:00:00'),
       (3, '12', 3, '2023-06-03', '18:00:00', '20:00:00');

INSERT INTO ReservaUsuario (ID_Reserva, Dni)
VALUES (1, '12345678A'),
       (2, '87654321B'),
       (3, '12');



=======
CREATE DATABASE DDBB;

USE DDBB;

CREATE TABLE Usuario (
  Dni VARCHAR2(10) PRIMARY KEY,
  Nombre VARCHAR2(50),
  Apellido VARCHAR2(50),
  Email VARCHAR2(100),
  Contraseña VARCHAR2(100),
  Teléfono VARCHAR2(20),
  Dirección VARCHAR2(100)
);

CREATE TABLE Pista (
  ID_Pista INT PRIMARY KEY,
  Nombre VARCHAR2(100),
  Tipo VARCHAR2(100),
  Disponibilidad VARCHAR2(100)
);

CREATE TABLE Reserva (
  ID_Reserva INT PRIMARY KEY,
  Dni VARCHAR2(10),
  ID_Pista INT,
  Fecha DATE,
  HoraInicio TIME,
  HoraFin TIME,
  FOREIGN KEY (Dni) REFERENCES Usuario(Dni),
  FOREIGN KEY (ID_Pista) REFERENCES Pista(ID_Pista)
);

CREATE TABLE ReservaUsuario (
  ID_Reserva INT,
  Dni VARCHAR2(10),
  FOREIGN KEY (ID_Reserva) REFERENCES Reserva(ID_Reserva),
  FOREIGN KEY (Dni) REFERENCES Usuario(Dni)
);

INSERT INTO Usuario (Dni, Nombre, Apellido, Email, Contraseña, Teléfono, Dirección)
VALUES ('12345678A', 'Juan', 'Pérez', 'juan@example.com', 'password123', '123456789', 'Calle Ejemplo 123'),
       ('87654321B', 'María', 'López', 'maria@example.com', 'abc123', '987654321', 'Avenida Principal 456'),
       ('12', 'Pedro', 'García', 'pedro@example.com', '12', '123456789', 'Calle Ejemplo 321 ');

INSERT INTO Pista (ID_Pista, Nombre, Tipo, Disponibilidad)
VALUES (1, 'Pista de Tenis', 'Tenis', 'Disponible'),
       (2, 'Pista de Fútbol', 'Fútbol', 'No Disponible'),
       (3, 'Pista de Pádel', 'Pádel', 'Disponible');


INSERT INTO Reserva (ID_Reserva, Dni, ID_Pista, Fecha, HoraInicio, HoraFin)
VALUES (1, '12345678A', 1, '2023-06-01', '10:00:00', '12:00:00'),
       (2, '87654321B', 2, '2023-06-02', '14:00:00', '16:00:00'),
       (3, '12', 3, '2023-06-03', '18:00:00', '20:00:00');

INSERT INTO ReservaUsuario (ID_Reserva, Dni)
VALUES (1, '12345678A'),
       (2, '87654321B'),
       (3, '12');



>>>>>>> cad94b9e6445191dc056084636f89faefe73f8b5
