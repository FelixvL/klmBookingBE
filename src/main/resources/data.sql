INSERT INTO `airport` (`id`, `name`) VALUES (1, 'Schiphol');
INSERT INTO `airport` (`id`, `name`) VALUES (2, 'Dusseldorf');
INSERT INTO `airport` (`id`, `name`) VALUES (3, 'Charles de Gaulle');

INSERT INTO `flight` (`id`, `duration`, `destination_id`, `origin_id`) VALUES (1, 120, 1, 2);

INSERT INTO `passenger` (`id`, `name`) VALUES (1, 'Frits');

INSERT INTO `plane` (`id`, `brand`) VALUES (1, 'Bowing');

INSERT INTO `passenger_flights` (`passenger_id`, `flights_id`) VALUES (1, 1);

INSERT INTO `plane_flights` (`plane_id`, `flights_id`) VALUES (1, 1);
