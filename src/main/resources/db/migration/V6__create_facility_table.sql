CREATE TABLE facility (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR NOT NULL,
    address VARCHAR NOT NULL,
    department department NOT NULL,
    guid UUID NOT NULL DEFAULT gen_random_uuid(),
    created_date TIMESTAMP NOT NULL,
    updated_date TIMESTAMP NOT NULL,
    created_by BIGINT,
    updated_by BIGINT
);