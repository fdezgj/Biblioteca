-- =========================
-- AUTORES
-- =========================
INSERT INTO autores (id, nombre_completo, pais_origen) VALUES
(1, 'Miguel de Cervantes', 'España'),
(2, 'Gabriel García Márquez', 'Colombia'),
(3, 'J.K. Rowling', 'Reino Unido'),
(4, 'George Orwell', 'Reino Unido');

-- =========================
-- LIBROS
-- =========================
INSERT INTO libros (isbn, titulo_obra, anio_publicacion, genero) VALUES
('ISBN-001', 'Don Quijote de la Mancha', 1605, 'NOVELA'),
('ISBN-002', 'Cien años de soledad', 1967, 'NOVELA'),
('ISBN-003', 'Harry Potter y la piedra filosofal', 1997, 'FANTASIA'),
('ISBN-004', '1984', 1949, 'DISTOPIA');

-- =========================
-- RELACIÓN LIBRO_AUTOR
-- =========================
INSERT INTO libro_autor (libro_isbn, autor_id) VALUES
('ISBN-001', 1),
('ISBN-002', 2),
('ISBN-003', 3),
('ISBN-004', 4);

-- =========================
-- EJEMPLARES
-- =========================
INSERT INTO ejemplares (id, codigo_barras_tag, estado_conservacion, prestado, libro_isbn) VALUES
(1, 'COD-001', 'BUENO', false, 'ISBN-001'),
(2, 'COD-002', 'BUENO', false, 'ISBN-001'),
(3, 'COD-003', 'REGULAR', false, 'ISBN-002'),
(4, 'COD-004', 'BUENO', false, 'ISBN-002'),
(5, 'COD-005', 'NUEVO', false, 'ISBN-003'),
(6, 'COD-006', 'BUENO', false, 'ISBN-004');

-- =========================
-- SOCIOS
-- =========================
INSERT INTO socios (id, dni, nombre_socio, penalizado) VALUES
(1, '12345678A', 'Luis García', false),
(2, '87654321B', 'Ana López', false),
(3, '11223344C', 'Carlos Pérez', false);