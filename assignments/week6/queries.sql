-- En la base de datos de aerolíneas escriba el script SQL para obtener el número total de vuelos en la base de datos.
SELECT COUNT(DISTINCT flight_number) n_vuelos 
FROM main;

-- En la base de datos de aerolíneas escriba el script SQL para obtener la distancia promedio de vuelo.
SELECT AVG(f.flight_mileage) average_distance
FROM main m 
JOIN flights f ON m.flight_number = f.flight_number;

-- En la base de datos de aerolíneas escriba el script SQL para obtener el número promedio de asientos.
SELECT AVG(f.aircraft_seats) average_seat_count 
FROM main m 
JOIN flights f ON m.flight_number = f.flight_number;

-- En la base de datos de aerolíneas escriba el script SQL para obtener el número promedio de millas voladas por los clientes agrupados por estatus.
SELECT c.customer_status ,AVG(c.customer_mileage) average_customer_miles
FROM main m
JOIN customers c ON m.customer_id = c.id 
GROUP BY 1;

-- En la base de datos de aerolíneas escriba el script SQL para obtener el número máximo de millas voladas por los clientes agrupados por estatus.
SELECT c.customer_status ,MAX(c.customer_mileage) max_customer_miles
FROM main m
JOIN customers c ON m.customer_id = c.id 
GROUP BY 1;
-- En la base de datos de aerolíneas escriba el script SQL para obtener el número total de aeronaves con un nombre que contiene Boeing.
SELECT COUNT(aircraft) boeing_count
FROM flights
WHERE aircraft REGEXP("(?i)boeing");
-- En la base de datos de aerolíneas escriba el script SQL para encontrar todos los vuelos con una distancia entre 300 y 2000 millas.
SELECT COUNT(f.flight_number) between_300_and_2000
FROM main m
JOIN flights f ON m.flight_number = f.flight_number
WHERE f.flight_mileage BETWEEN 300 AND 2000;
-- En la base de datos de aerolíneas escriba el script SQL para encontrar la distancia promedio de vuelo reservada agrupada por estatus de cliente (esto requerirá una unión).
SELECT c.customer_status, AVG(f.flight_mileage) average_flight_reservation_mileage
FROM main m
JOIN customers c ON m.customer_id= c.id
JOIN flights f ON m.flight_number = f.flight_number
GROUP BY 1;

-- En la base de datos de aerolíneas escriba el script SQL para encontrar la aeronave más a menudo reservada por los miembros de estatus de oro (esto requerirá una unión).
(SELECT c.customer_status, f.aircraft, COUNT(*) fcount 
FROM main m
JOIN customers c ON m.customer_id = c.id
JOIN flights f ON m.flight_number = f.flight_number
WHERE c.customer_status = "Gold"
GROUP BY f.aircraft
ORDER BY 3 DESC
LIMIT 1)

UNION
(SELECT c.customer_status, f.aircraft, COUNT(*) fcount 
FROM main m
JOIN customers c ON m.customer_id = c.id
JOIN flights f ON m.flight_number = f.flight_number
WHERE c.customer_status = "Silver"
GROUP BY f.aircraft
ORDER BY 3 DESC
LIMIT 1)

UNION
(SELECT c.customer_status, f.aircraft, COUNT(*) fcount 
FROM main m
JOIN customers c ON m.customer_id = c.id
JOIN flights f ON m.flight_number = f.flight_number
WHERE c.customer_status = "None"
GROUP BY f.aircraft
ORDER BY 3 DESC
LIMIT 1);
