CREATE TABLE transactions (
    id BIGINT NOT NULL AUTO_INCREMENT,
    payer BIGINT NOT NULL,
    receiver BIGINT NOT NULL,
    value DECIMAL(7,2) NOT NULL,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (payer) REFERENCES users (id),
    FOREIGN KEY (receiver) REFERENCES users (id)
);