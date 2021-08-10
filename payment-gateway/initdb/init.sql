CREATE TABLE public.transaction (
    id integer NOT NULL,
    amount numeric(14,2),
    invoice_number character varying(32),
    status character varying(32)
);

ALTER TABLE public.transaction OWNER TO postgres;
CREATE SEQUENCE seq_transaction;
ALTER TABLE transaction ALTER COLUMN id SET DEFAULT nextval('seq_transaction');


insert into transaction (amount, invoice_number, status) values
(10000, 'INV-001', 'FAILED'),
(15000, 'INV-002', 'FAILED'),
(25000, 'INV-003', 'FAILED'),
(20000, 'INV-004', 'FAILED');