CREATE TABLE equipment (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR NOT NULL,
    type VARCHAR NOT NULL,
    facility_id BIGINT REFERENCES facility(id),
    guid UUID NOT NULL DEFAULT gen_random_uuid(),
    created_date TIMESTAMP NOT NULL,
    updated_date TIMESTAMP NOT NULL,
    created_by BIGINT,
    updated_by BIGINT
);