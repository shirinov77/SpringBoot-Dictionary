DROP TABLE IF EXISTS dictionary;

CREATE TABLE dictionary
(
    id         BIGSERIAL PRIMARY KEY,
    word       VARCHAR(255) NOT NULL,
    meaning    TEXT         NOT NULL,
    created_at TIMESTAMP    NOT NULL DEFAULT NOW()
);
