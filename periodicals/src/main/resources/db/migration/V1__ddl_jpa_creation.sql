--
-- PostgreSQL database dump
--

-- Dumped from database version 13.1
-- Dumped by pg_dump version 13.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: category; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.category (
    id integer NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.category OWNER TO postgres;

--
-- Name: frequency; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.frequency (
    id integer NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.frequency OWNER TO postgres;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- Name: language; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.language (
    id integer NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.language OWNER TO postgres;

--
-- Name: order_list; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.order_list (
    id integer NOT NULL,
    order_id integer,
    release_id integer
);


ALTER TABLE public.order_list OWNER TO postgres;

--
-- Name: orders; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orders (
    id integer NOT NULL,
    date_order timestamp without time zone,
    state_payment boolean,
    state_shipment boolean,
    sum_order double precision,
    user_id integer,
    user_address_id integer
);


ALTER TABLE public.orders OWNER TO postgres;

--
-- Name: payment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.payment (
    id integer NOT NULL,
    date_pay timestamp without time zone,
    transaction character varying(255),
    order_id integer,
    sum double precision
);


ALTER TABLE public.payment OWNER TO postgres;

--
-- Name: period; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.period (
    id integer NOT NULL,
    name character varying(255),
    part_year integer
);


ALTER TABLE public.period OWNER TO postgres;

--
-- Name: product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product (
    id integer NOT NULL,
    date_first_available timestamp without time zone,
    isin character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    publisher_id integer,
    category_id integer,
    frequency_id integer,
    language_id integer
);


ALTER TABLE public.product OWNER TO postgres;

--
-- Name: publisher; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.publisher (
    id integer NOT NULL,
    contact character varying(255) NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.publisher OWNER TO postgres;

--
-- Name: release; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.release (
    id integer NOT NULL,
    description character varying(255),
    link_cover character varying(255),
    name character varying(255) NOT NULL,
    product_id integer,
    filename character varying(255),
    price double precision
);


ALTER TABLE public.release OWNER TO postgres;

--
-- Name: user_address; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_address (
    id integer NOT NULL,
    address character varying(255),
    addressee character varying(255),
    phone_number character varying(255),
    user_id integer
);


ALTER TABLE public.user_address OWNER TO postgres;

--
-- Name: user_table; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_table (
    id integer NOT NULL,
    activation_code character varying(255),
    active boolean,
    password character varying(255) NOT NULL,
    user_role character varying(255),
    username character varying(255)
);


ALTER TABLE public.user_table OWNER TO postgres;

--
-- Data for Name: category; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.category (id, name) VALUES (199, 'Entertainment');
INSERT INTO public.category (id, name) VALUES (200, 'Business');
INSERT INTO public.category (id, name) VALUES (201, 'Lifestyle');
INSERT INTO public.category (id, name) VALUES (202, 'News');
INSERT INTO public.category (id, name) VALUES (203, 'Newspapers');
INSERT INTO public.category (id, name) VALUES (204, 'Home');
INSERT INTO public.category (id, name) VALUES (205, 'Fashion');
INSERT INTO public.category (id, name) VALUES (206, 'Automotive');
INSERT INTO public.category (id, name) VALUES (207, 'Men''s Interest');
INSERT INTO public.category (id, name) VALUES (208, 'Celebrity');
INSERT INTO public.category (id, name) VALUES (209, 'Health');
INSERT INTO public.category (id, name) VALUES (210, 'Children');
INSERT INTO public.category (id, name) VALUES (211, 'Women''s Interest');
INSERT INTO public.category (id, name) VALUES (212, 'Science');
INSERT INTO public.category (id, name) VALUES (213, 'Comics');
INSERT INTO public.category (id, name) VALUES (214, 'Gardening');


--
-- Data for Name: frequency; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.frequency (id, name) VALUES (193, 'Weekly');
INSERT INTO public.frequency (id, name) VALUES (194, 'Fortnightly');
INSERT INTO public.frequency (id, name) VALUES (195, 'Four-weekly');
INSERT INTO public.frequency (id, name) VALUES (196, 'Monthly');
INSERT INTO public.frequency (id, name) VALUES (197, 'Daily');
INSERT INTO public.frequency (id, name) VALUES (229, '7 Issues/Year');
INSERT INTO public.frequency (id, name) VALUES (233, '10 Issues/Year');


--
-- Data for Name: language; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.language (id, name) VALUES (187, 'French');
INSERT INTO public.language (id, name) VALUES (141, 'Spanish');
INSERT INTO public.language (id, name) VALUES (188, 'Russian');
INSERT INTO public.language (id, name) VALUES (189, 'Portuguese');
INSERT INTO public.language (id, name) VALUES (190, 'German');
INSERT INTO public.language (id, name) VALUES (191, 'English');
INSERT INTO public.language (id, name) VALUES (192, 'Chinese');


--
-- Data for Name: order_list; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.order_list (id, order_id, release_id) VALUES (156, 155, 40);
INSERT INTO public.order_list (id, order_id, release_id) VALUES (157, 155, 67);
INSERT INTO public.order_list (id, order_id, release_id) VALUES (160, 159, 41);
INSERT INTO public.order_list (id, order_id, release_id) VALUES (162, 161, 68);
INSERT INTO public.order_list (id, order_id, release_id) VALUES (163, 161, 70);
INSERT INTO public.order_list (id, order_id, release_id) VALUES (165, 164, 42);
INSERT INTO public.order_list (id, order_id, release_id) VALUES (166, 164, 70);
INSERT INTO public.order_list (id, order_id, release_id) VALUES (170, 169, 44);
INSERT INTO public.order_list (id, order_id, release_id) VALUES (173, 172, 68);
INSERT INTO public.order_list (id, order_id, release_id) VALUES (176, 175, 42);
INSERT INTO public.order_list (id, order_id, release_id) VALUES (179, 178, 42);
INSERT INTO public.order_list (id, order_id, release_id) VALUES (180, 178, 42);
INSERT INTO public.order_list (id, order_id, release_id) VALUES (181, 178, 42);


--
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.orders (id, date_order, state_payment, state_shipment, sum_order, user_id, user_address_id) VALUES (159, '2021-01-31 17:42:35.425', false, false, 8, 45, 66);
INSERT INTO public.orders (id, date_order, state_payment, state_shipment, sum_order, user_id, user_address_id) VALUES (161, '2021-01-31 17:42:51.861', false, false, 118.99000000000001, 45, 66);
INSERT INTO public.orders (id, date_order, state_payment, state_shipment, sum_order, user_id, user_address_id) VALUES (164, '2021-01-31 17:43:14.832', false, false, 61.99, 59, 97);
INSERT INTO public.orders (id, date_order, state_payment, state_shipment, sum_order, user_id, user_address_id) VALUES (169, '2021-01-31 18:26:48.136', false, false, 1000, 45, 65);
INSERT INTO public.orders (id, date_order, state_payment, state_shipment, sum_order, user_id, user_address_id) VALUES (172, '2021-01-31 18:28:22.378', false, false, 59, 45, 65);
INSERT INTO public.orders (id, date_order, state_payment, state_shipment, sum_order, user_id, user_address_id) VALUES (175, '2021-01-31 18:31:35.288', false, false, 2, 59, 96);
INSERT INTO public.orders (id, date_order, state_payment, state_shipment, sum_order, user_id, user_address_id) VALUES (155, '2021-01-31 17:42:21.455', true, true, 25.3, 45, 65);
INSERT INTO public.orders (id, date_order, state_payment, state_shipment, sum_order, user_id, user_address_id) VALUES (178, '2021-01-31 18:41:43.321', true, false, 6, 59, 96);


--
-- Data for Name: payment; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.payment (id, date_pay, transaction, order_id, sum) VALUES (171, '2021-01-31 18:27:16.613', 'Payment: John Smiht|2424-2323-2121-2222|111|11/11summa:1.25', NULL, 1.25);
INSERT INTO public.payment (id, date_pay, transaction, order_id, sum) VALUES (174, '2021-01-31 18:28:36.972', 'Payment: |||summa:10.0', NULL, 10);
INSERT INTO public.payment (id, date_pay, transaction, order_id, sum) VALUES (177, '2021-01-31 18:31:42.409', 'Order - 175| Payment: |||summa:10.0', NULL, 10);
INSERT INTO public.payment (id, date_pay, transaction, order_id, sum) VALUES (158, '2021-01-31 17:42:23.8', 'Payment: |||summa:', 155, NULL);
INSERT INTO public.payment (id, date_pay, transaction, order_id, sum) VALUES (167, '2021-01-31 17:43:16.342', 'Payment: |||summa:', 155, NULL);
INSERT INTO public.payment (id, date_pay, transaction, order_id, sum) VALUES (182, '2021-01-31 18:41:49.088', 'Order - 178| Payment: |||summa:3.0', 178, 3);


--
-- Data for Name: period; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.product (id, date_first_available, isin, name, publisher_id, category_id, frequency_id, language_id) VALUES (230, '1997-01-01 00:08:00', '9780471196532', 'Forbes ', 218, 200, 229, 191);
INSERT INTO public.product (id, date_first_available, isin, name, publisher_id, category_id, frequency_id, language_id) VALUES (226, '2008-01-01 00:02:00', '9780850793130 ', 'OK! Magazine Australia', 217, 208, 193, 191);
INSERT INTO public.product (id, date_first_available, isin, name, publisher_id, category_id, frequency_id, language_id) VALUES (231, '1886-01-01 00:03:00', '0010-9541', 'Cosmopolitan', 219, 205, 196, 191);
INSERT INTO public.product (id, date_first_available, isin, name, publisher_id, category_id, frequency_id, language_id) VALUES (232, '1867-01-02 00:01:00', '2692-3815', 'Harper''s BAZAAR', 219, 205, 233, 191);
INSERT INTO public.product (id, date_first_available, isin, name, publisher_id, category_id, frequency_id, language_id) VALUES (235, '2009-01-24 00:08:00', '0093-7673', 'People', 220, 199, 193, 191);
INSERT INTO public.product (id, date_first_available, isin, name, publisher_id, category_id, frequency_id, language_id) VALUES (236, '1923-01-03 00:03:00', '0040-781X', 'Time ', 220, 202, 193, 191);
INSERT INTO public.product (id, date_first_available, isin, name, publisher_id, category_id, frequency_id, language_id) VALUES (237, '2000-01-01 00:01:00', 'XXXXXXX', 'NoName', 220, 213, 193, 188);
INSERT INTO public.product (id, date_first_available, isin, name, publisher_id, category_id, frequency_id, language_id) VALUES (234, '2021-01-01 00:02:00', '0013-6298', 'ELLE ', 217, 199, 193, 187);
INSERT INTO public.product (id, date_first_available, isin, name, publisher_id, category_id, frequency_id, language_id) VALUES (239, '2003-01-01 00:03:00', '978-0376003027', 'This Old House Magazine', 221, 204, 196, 191);
INSERT INTO public.product (id, date_first_available, isin, name, publisher_id, category_id, frequency_id, language_id) VALUES (240, '2014-01-01 00:04:00', '978-0525935513', 'Old House Journal', 221, 204, 194, 191);
INSERT INTO public.product (id, date_first_available, isin, name, publisher_id, category_id, frequency_id, language_id) VALUES (241, '2008-01-01 00:08:00', '405900572X', 'Woman This Month', 221, 211, 196, 191);
INSERT INTO public.product (id, date_first_available, isin, name, publisher_id, category_id, frequency_id, language_id) VALUES (242, '2015-01-01 00:01:00', '978-1526150677', 'Ideal Home', 221, 204, 194, 191);


--
-- Data for Name: publisher; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.publisher (id, contact, name) VALUES (217, 'Customer service subscriptions
Tel.: +44 (0) 1858 438884
bauer@subscription.co.uk

New magazine subscriptions
Tel.: +44 (0) 1858 438884
www.greatmagazines.co.uk', 'Bauer Media');
INSERT INTO public.publisher (id, contact, name) VALUES (218, '499 Washington Blvd
Jersey City, NJ 07310
Phone (800) 295-0893', 'Forbes');
INSERT INTO public.publisher (id, contact, name) VALUES (219, 'Hearst is a leading global, diversified media, information and services company with more than 360 businesses. Managed by Hearst Communications.', 'Hearst magazines');
INSERT INTO public.publisher (id, contact, name) VALUES (220, 'Customer service can be reached at www.time.com/customerservice or 1-800-843-8463, if you wish to cancel or if you have questions about your subscription.', 'Time Inc');
INSERT INTO public.publisher (id, contact, name) VALUES (221, 'LLC, 262 Harbor Drive, Stamford, CT 06902

Phone: (475) 209-8665

Email: contact@thisoldhouse.com', 'This Old House Ventures');


--
-- Data for Name: release; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.release (id, description, link_cover, name, product_id, filename, price) VALUES (254, 'ARE YOU READY FOR AWKWAFINA? “I’ve spent my entire life walking into a room surprising them.” Maya Rudolph & Natasha Lyonne in Conversation Photographs by Daria Kobayashi Ritch.', NULL, 'February 2021', 232, 'df7fb058-8a50-4bff-8d6f-ac3eb0c13faf.2 (11).jpg', 7);
INSERT INTO public.release (id, description, link_cover, name, product_id, filename, price) VALUES (255, 'Hi, this question may casually save your next first date. Psychics are here with a sneak peek of alllll the celeb drama. Is it just us, or have TV scenes been *extremely* sexy lately?', NULL, 'February 2021', 231, '131c982d-7099-443a-b0db-926b33f5a176.2 (12).jpg', 8);
INSERT INTO public.release (id, description, link_cover, name, product_id, filename, price) VALUES (256, 'Your entire feed is about to copy the hair on this page. Here’s when stuff will go back to normal-ish!!! Emma Roberts: new year, new everything.', NULL, 'December 2020/ January 2021', 231, 'ba1f76b5-b377-4de4-9231-46d94b72ba60.2 (13).jpg', 8);
INSERT INTO public.release (id, description, link_cover, name, product_id, filename, price) VALUES (257, 'Lucy Hale started breaking rules a long time ago—you just weren’t paying attention. Exclusive! Shirtless! Pilot Pete! Photos! Inside! That is all..', NULL, 'March 2020', 231, '0a961ca8-7511-42c7-a4fe-904f22b0b5f4.2 (14).jpg', 8);
INSERT INTO public.release (id, description, link_cover, name, product_id, filename, price) VALUES (258, 'Milestones: billionaire Sheldon Adelson; “Wall of Sound” producer Phil Spector Ian Bremmer on the strings Biden finds attached to China Madeleine Albright names the two most dangerous words...', NULL, 'February 01 - 08, 2021', 236, '2015a372-940e-4da9-bd30-9aa236100790.2 (15).jpg', 20);
INSERT INTO public.release (id, description, link_cover, name, product_id, filename, price) VALUES (40, '444411123', NULL, '4444411123', 237, '66b9380e-13b4-4237-b506-4ebd25caf22e.8.jpg', 2.3);
INSERT INTO public.release (id, description, link_cover, name, product_id, filename, price) VALUES (41, '/admin/', NULL, 'Aliaksei', 237, '050e9dd4-1eed-45b1-8238-3f66597c0aae.55.jpg', 8);
INSERT INTO public.release (id, description, link_cover, name, product_id, filename, price) VALUES (42, 'awdawd', NULL, 'dawdadw', 237, '265fcb87-ea59-4ca3-aa62-8677c80785c5.7.jpg', 2);
INSERT INTO public.release (id, description, link_cover, name, product_id, filename, price) VALUES (259, 'Star Warriors Inside America’s very real Space Force By W.J. Hennigan Anatomy of a Pandemic The hunt for “patient zero” and the groundbreaking global effort to map the virus. By Charlie Campbell and A', NULL, 'August 03 - 10, 2020', 236, '52a97648-79fd-4bfc-b025-d676f1bdb8a2.2 (16).jpg', 20);
INSERT INTO public.release (id, description, link_cover, name, product_id, filename, price) VALUES (44, 'awdadw', NULL, 'Tatsiana', 237, 'a6db5776-c2ad-454a-bf72-81e6362994ba.5.jpg', 1000);
INSERT INTO public.release (id, description, link_cover, name, product_id, filename, price) VALUES (67, 'SEPARATE LIVES Can they go the distance? Why Alec and Hilaria Baldwin’s new living arrangement is setting off alarm bells. PRIVATE PAIN Heartbreak, addiction and depression: An insider spills on Owen Wilson’s secret struggles and his big comeback.', NULL, 'February 01, 2021', 237, 'ca9c0952-a229-4263-8575-e6059982bf08.February 01, 2021.jpg', 23);
INSERT INTO public.release (id, description, link_cover, name, product_id, filename, price) VALUES (260, 'Question of Strength Hospitalized for COVID-19 four weeks before the election, the President remained obsessed with image By Molly Ball Cutting-Edge Medicine Will three unapproved therapies for Trump ', NULL, 'October 19, 2020', 236, 'c89f7281-9f0a-4fb4-a592-233087947d64.2 (17).jpg', 20);
INSERT INTO public.release (id, description, link_cover, name, product_id, filename, price) VALUES (70, 'Hello, World How Joe Biden’s team of professionals plans to repair the ties between the U.S. and the rest of the globe. By Kimberly', NULL, 'December 14, 2020', 237, '4533cfb4-84f4-41a1-ab22-9829f155bb0f.December 14, 2020.jpg', 59.99);
INSERT INTO public.release (id, description, link_cover, name, product_id, filename, price) VALUES (186, 'Milestones: billionaire Sheldon Adelson; “Wall of Sound” producer Phil Spector Ian Bremmer on the strings Biden finds attached to China Madeleine', NULL, '11jan20201', 237, '3e33025e-c673-482a-bc86-50535e8d081a.33.jpg', 8);
INSERT INTO public.release (id, description, link_cover, name, product_id, filename, price) VALUES (43, 'daw', NULL, 'Aliaksei', 230, '0c8dfaaa-29d3-45e1-9a60-302ecd2f94ba.3.jpg', 1.2);
INSERT INTO public.release (id, description, link_cover, name, product_id, filename, price) VALUES (68, 'Milestones: billionaire Sheldon Adelson; “Wall of Sound” producer Phil Spector Ian Bremmer on the strings Biden finds attached to China Madeleine', NULL, ' February 01 - 08, 2021', 236, '6c063fcc-9211-45c1-9dcd-b832d33ff152.February 01 - 08, 2021.jpg', 59);
INSERT INTO public.release (id, description, link_cover, name, product_id, filename, price) VALUES (243, 'JLo''s easy 5kg shred Ashton & Mila Inside Suri''s world', NULL, 'May 11, 2020', 226, 'f0df130a-1457-4c68-bce4-6846994eb04e.111.jpg', 0.99);
INSERT INTO public.release (id, description, link_cover, name, product_id, filename, price) VALUES (244, 'Kate Hudson''s simple 6kg shred Harry & Meghan Tiger King', NULL, 'April 20, 2020', 226, '51d20ab0-9fbf-41a1-8f02-e560d2389056.2 (1).jpg', 0.99);
INSERT INTO public.release (id, description, link_cover, name, product_id, filename, price) VALUES (245, 'Cameron''s joy - baby no. 2! Harry''s ultimatum to Meghan Katy & Orly', NULL, 'May 4, 2020', 226, '776db10d-90d1-4b66-a1b7-3f5a02c9536e.2 (2).jpg', 0.99);
INSERT INTO public.release (id, description, link_cover, name, product_id, filename, price) VALUES (246, 'Ryan Blindsides Eva War over Archie More than Friends', NULL, 'April 13, 2020', 226, '15610857-6242-40cb-a9c6-1e027099d0e4.2 (3).jpg', 0.99);
INSERT INTO public.release (id, description, link_cover, name, product_id, filename, price) VALUES (247, 'Liam & Gabriella Mikey & Stacey Michelle Williams', NULL, 'April 6, 2020', 226, '209049bf-2af2-4ff4-a53a-ef02eab0980e.2 (4).jpg', 0.99);
INSERT INTO public.release (id, description, link_cover, name, product_id, filename, price) VALUES (248, 'Tory Burch’s Survival Sketchbook Amid a luxury fashion apocalypse, one of the century’s greatest entrepreneurial retailers (and one of America’s richest self-made women) brought us deep inside the bat', NULL, 'November 2020', 230, '85ac8c52-aac6-4ff8-93b0-82972555905e.2 (5).jpg', 5.99);
INSERT INTO public.release (id, description, link_cover, name, product_id, filename, price) VALUES (249, 'Reed Hastings Rewrites the Hollywood Script Netflix had already upended Hollywood when the pandemic hit. But by making use of a highly unusual management style, its billionaire founder has positioned ', NULL, 'October 2020', 230, 'd5878e9b-8ef1-4f42-a22e-af916810fe48.2 (6).jpg', 5);
INSERT INTO public.release (id, description, link_cover, name, product_id, filename, price) VALUES (250, 'Greater Capitalism Our economic system suffered from a number of preexisting conditions—inequality, education gaps, cronyism—before Covid-19 arrived. But it’s already busy reinventing itself into some', NULL, 'June - July 2020', 230, '1af1a3a1-4f8c-46ee-859f-fcbfc49e0cd4.2 (7).jpg', 5);
INSERT INTO public.release (id, description, link_cover, name, product_id, filename, price) VALUES (251, 'AGENTS OF CHANGE AS THE CORONAVIRUS UPENDS THE ECONOMY, HEALTH-CARE SYSTEMS AND GLOBAL ORDER, ENTREPRENEURS MUST REINVENT THEMSELVES, THEIR INDUSTRIES—AND THE WORLD AT LARGE.', NULL, 'May 2020', 230, '948051de-51d7-40a9-b76c-dd270907104e.2 (8).jpg', 5);
INSERT INTO public.release (id, description, link_cover, name, product_id, filename, price) VALUES (252, 'NORMAL PEOPLE Maggie Lange looks at the designer collaborations making the mundane shine. ELLE INTERNATIONAL BEAUTY AWARDS 2021 ELLE’s global editors come together to crown the best products of the ye', NULL, 'February 2021', 234, '716d0eab-1c83-41bb-845f-f99da3c21a5a.2 (9).jpg', 6);
INSERT INTO public.release (id, description, link_cover, name, product_id, filename, price) VALUES (253, 'ZENDAYA THE COOLEST GIRL IN HOLLYWOOD MAKES HISTORY. SHOULD YOU TRY THE NEW ZOOM LIFT?', NULL, 'December 2020 - January 2021', 234, '7ced701f-c697-4e15-a895-be433ecef65d.2 (10).jpg', 6);
INSERT INTO public.release (id, description, link_cover, name, product_id, filename, price) VALUES (261, 'Larry King Remembering the incredible TV host, who died Jan. 23 at age 87. My Life in Pictures Acting legend Cicely Tyson looks back on her trailblazing career.', NULL, 'February 08, 2021', 235, '27044bbb-4e8c-47b9-b6c3-cde1bd6319fd.2 (18).jpg', 15);
INSERT INTO public.release (id, description, link_cover, name, product_id, filename, price) VALUES (262, 'Katy Perry - The pop star and new mom opens up about finding balance in her life. Madeline Fugate - California teen sews a quilt to honor the victims of COVID-19.', NULL, 'January 25, 2021', 235, 'bf23e0d3-9b43-43f5-b747-ece637dd5fd4.2 (19).jpg', 15);
INSERT INTO public.release (id, description, link_cover, name, product_id, filename, price) VALUES (263, 'India Oxenberg She was brainwashed and branded by the leaders of Nxivm—then her mother helped her escape. Zak Williams Robin Williams’s son Zak hopes to help others by sharing his struggles with depre', NULL, 'October 26, 2020', 235, 'bd988fd4-127a-44e0-888c-0964f93aae62.2 (20).jpg', 15);


--
-- Data for Name: user_address; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.user_address (id, address, addressee, phone_number, user_id) VALUES (65, 'Гродно, Щорса, 32', 'Иванов Иван', '+375297777777', 45);
INSERT INTO public.user_address (id, address, addressee, phone_number, user_id) VALUES (66, 'Минск, пл. Победы, 1', 'Петров Петр', '+3752955555555', 45);
INSERT INTO public.user_address (id, address, addressee, phone_number, user_id) VALUES (96, 'Минск, пл. Победы, 135', 'Иванов Иван', '+375000000000', 59);
INSERT INTO public.user_address (id, address, addressee, phone_number, user_id) VALUES (97, 'Минск, пл. Победы, 135', 'Иванова Мария', '+375291112233', 59);


--
-- Data for Name: user_table; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.user_table (id, activation_code, active, password, user_role, username) VALUES (37, NULL, true, '$2a$08$HN/ovTJfe0SpoiMj5I43teCHAgftjDJOtgv0UpYsYkKytcD5M0/na', 'ADMIN', 'a@a.by');
INSERT INTO public.user_table (id, activation_code, active, password, user_role, username) VALUES (45, NULL, true, '$2a$08$HN/ovTJfe0SpoiMj5I43teCHAgftjDJOtgv0UpYsYkKytcD5M0/na', 'USER', 'b@b.by');
INSERT INTO public.user_table (id, activation_code, active, password, user_role, username) VALUES (59, NULL, true, '$2a$08$HN/ovTJfe0SpoiMj5I43teCHAgftjDJOtgv0UpYsYkKytcD5M0/na', 'USER', 'c@c.by');
INSERT INTO public.user_table (id, activation_code, active, password, user_role, username) VALUES (185, NULL, false, '$2a$08$HN/ovTJfe0SpoiMj5I43teCHAgftjDJOtgv0UpYsYkKytcD5M0/na', 'USER', 'd@d.by');
INSERT INTO public.user_table (id, activation_code, active, password, user_role, username) VALUES (238, '05a00a35-576e-481b-b3cd-bb94676f12c4', true, '$2a$08$7sKtJjhlnyqMozqlxQJSJuaETNnsyTD5yLqmqJr739QLJgk9lnxKa', 'USER', 'e@e.by');


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 263, true);


--
-- Name: category category_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (id);


--
-- Name: frequency frequency_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.frequency
    ADD CONSTRAINT frequency_pkey PRIMARY KEY (id);


--
-- Name: language language_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.language
    ADD CONSTRAINT language_pkey PRIMARY KEY (id);


--
-- Name: order_list order_list_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_list
    ADD CONSTRAINT order_list_pkey PRIMARY KEY (id);


--
-- Name: orders orders_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);


--
-- Name: payment payment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payment
    ADD CONSTRAINT payment_pkey PRIMARY KEY (id);


--
-- Name: period period_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.period
    ADD CONSTRAINT period_pkey PRIMARY KEY (id);


--
-- Name: product product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);


--
-- Name: publisher publisher_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.publisher
    ADD CONSTRAINT publisher_pkey PRIMARY KEY (id);


--
-- Name: release release_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.release
    ADD CONSTRAINT release_pkey PRIMARY KEY (id);


--
-- Name: user_table uk_en3wad7p8qfu8pcmh62gvef6v; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_table
    ADD CONSTRAINT uk_en3wad7p8qfu8pcmh62gvef6v UNIQUE (username);


--
-- Name: user_address user_address_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_address
    ADD CONSTRAINT user_address_pkey PRIMARY KEY (id);


--
-- Name: user_table user_table_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_table
    ADD CONSTRAINT user_table_pkey PRIMARY KEY (id);


--
-- Name: product fk1mtsbur82frn64de7balymq9s; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT fk1mtsbur82frn64de7balymq9s FOREIGN KEY (category_id) REFERENCES public.category(id);


--
-- Name: product fk2bhlky2a7c2mm0lbkjncfrbw1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT fk2bhlky2a7c2mm0lbkjncfrbw1 FOREIGN KEY (frequency_id) REFERENCES public.frequency(id);


--
-- Name: release fk4aopcer6xfqrjas12e8xwu2g1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.release
    ADD CONSTRAINT fk4aopcer6xfqrjas12e8xwu2g1 FOREIGN KEY (product_id) REFERENCES public.product(id);


--
-- Name: order_list fk84ksds192y1tymsjmq1qmqro8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_list
    ADD CONSTRAINT fk84ksds192y1tymsjmq1qmqro8 FOREIGN KEY (order_id) REFERENCES public.orders(id);


--
-- Name: orders fk8mburwc0vwu8tq9cq95kdnfcx; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT fk8mburwc0vwu8tq9cq95kdnfcx FOREIGN KEY (user_id) REFERENCES public.user_table(id);


--
-- Name: product fke7cpbpxindm6xcdy0g3d2aq6q; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT fke7cpbpxindm6xcdy0g3d2aq6q FOREIGN KEY (language_id) REFERENCES public.language(id);


--
-- Name: orders fkf46ojb6wsk3uibo9vmp55gipy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT fkf46ojb6wsk3uibo9vmp55gipy FOREIGN KEY (user_address_id) REFERENCES public.user_address(id);


--
-- Name: user_address fkhutkgdwvm3sxd7dq0y02klbi6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_address
    ADD CONSTRAINT fkhutkgdwvm3sxd7dq0y02klbi6 FOREIGN KEY (user_id) REFERENCES public.user_table(id);


--
-- Name: product fkjfg1nl4bf425evnmy1cy8dd9e; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT fkjfg1nl4bf425evnmy1cy8dd9e FOREIGN KEY (publisher_id) REFERENCES public.publisher(id);


--
-- Name: payment fklouu98csyullos9k25tbpk4va; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payment
    ADD CONSTRAINT fklouu98csyullos9k25tbpk4va FOREIGN KEY (order_id) REFERENCES public.orders(id);


--
-- Name: order_list fkpmo0r4241kh60ajiyuf2v7d46; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_list
    ADD CONSTRAINT fkpmo0r4241kh60ajiyuf2v7d46 FOREIGN KEY (release_id) REFERENCES public.release(id);


--
-- PostgreSQL database dump complete
--

