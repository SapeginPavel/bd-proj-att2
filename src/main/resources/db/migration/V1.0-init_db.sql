CREATE TABLE public.car
(
    car_id serial NOT NULL,
    reg_number character varying(9) NOT NULL,
    brand character varying NOT NULL,
    year integer,
    cost integer,
    PRIMARY KEY (car_id)
);

CREATE TABLE public.client
(
    client_id serial NOT NULL,
    passport_ser character varying(4) NOT NULL,
    passport_num character varying(6) NOT NULL,
    surname character varying,
    name character varying,
    phone character varying,
    PRIMARY KEY (client_id)
);

CREATE TABLE public.service
(
    service_id serial NOT NULL,
    start_date timestamp without time zone NOT NULL,
    end_date timestamp without time zone,
    car_id serial NOT NULL,
    client_id serial NOT NULL,
    PRIMARY KEY (service_id),
    FOREIGN KEY (car_id)
        REFERENCES public.car (car_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    FOREIGN KEY (client_id)
        REFERENCES public.client (client_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

CREATE TABLE public.offense
(
    offense_id serial NOT NULL,
    problem character varying NOT NULL,
    fine integer,
    PRIMARY KEY (offense_id)
);

CREATE TABLE public.offense_service
(
    service_id serial NOT NULL,
    offense_id serial NOT NULL,
    PRIMARY KEY (service_id, offense_id),
    FOREIGN KEY (service_id)
        REFERENCES public.service (service_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    FOREIGN KEY (offense_id)
        REFERENCES public.offense (offense_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);