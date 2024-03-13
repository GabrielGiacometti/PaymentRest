
INSERT INTO `users` (`id`, `balance`, `cpf`, `email`, `nome`, `senha`, `type`)
VALUES 
(1, 1000.00, '12345678901', 'john@example.com', 'John Doe', 'password', 'COMMON'),
(2, 500.00, '98765432101', 'alice@example.com', 'Alice Smith', 'password', 'SHOPKEEPER');

INSERT INTO `emails` (`email_id`, `payer`, `receiver`, `send_date_email`, `sender`, `status_email`, `text`, `title`)
VALUES 
(1, 'john@example.com', 'mary@example.com', '2024-03-10 08:30:00', 'system@example.com', 1, 'This is a payment confirmation email.', 'Payment Confirmation'),
(2, 'alice@example.com', 'bob@example.com', '2024-03-10 09:45:00', 'system@example.com', 1, 'This is a receipt confirmation email.', 'Receipt Confirmation');

INSERT INTO `emails_seq` (`next_val`)
VALUES (3);

INSERT INTO `users` (`id`, `balance`, `cpf`, `email`, `nome`, `senha`, `type`)
VALUES 
(1, 1000.00, '12345678901', 'john@example.com', 'John Doe', 'password', 'COMMON'),
(2, 500.00, '98765432101', 'alice@example.com', 'Alice Smith', 'password', 'SHOPKEEPER');

INSERT INTO `transactions` (`id`, `date`, `value`, `payer`, `receiver`)
VALUES 
(1, '2024-03-10 10:00:00', 100.00, 1, 2),
(2, '2024-03-10 10:15:00', 50.00, 2, 1);
