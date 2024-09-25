CREATE TABLE overhaul (
    id BIGSERIAL PRIMARY KEY,
    description VARCHAR NOT NULL,
    date DATE NOT NULL,
    status overhaul_status NOT NULL,
    equipment_id BIGINT REFERENCES equipment(id),
    guid UUID NOT NULL DEFAULT gen_random_uuid(),
    created_date TIMESTAMP NOT NULL,
    updated_date TIMESTAMP NOT NULL,
    created_by BIGINT,
    updated_by BIGINT
);