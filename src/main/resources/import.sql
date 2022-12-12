INSERT INTO user_details(id, first_name, last_name,created_at, updated_at) VALUES(1,'NoBankAccount', 'Surname1',current_timestamp,current_timestamp);
INSERT INTO user_details(id, first_name, last_name,created_at, updated_at) VALUES(2,'HasBankAccount', 'Debit',current_timestamp,current_timestamp);
INSERT INTO user_details(id, first_name, last_name,created_at, updated_at) VALUES(3,'HasBankAccount', 'Credit',current_timestamp,current_timestamp);
INSERT INTO user_details(id, first_name, last_name,created_at, updated_at) VALUES(4,'HasNoLimit', 'Debit',current_timestamp,current_timestamp);
INSERT INTO user_details(id, first_name, last_name,created_at, updated_at) VALUES(5,'HasNoLimit', 'Credit',current_timestamp,current_timestamp);

INSERT INTO bank_account(id, user_id,iban, current_balance,created_at, updated_at) VALUES(1,2, 'IBAN1', 100.0 , current_timestamp,current_timestamp);
INSERT INTO bank_account(id, user_id,iban, current_balance,created_at, updated_at) VALUES(2,3, null, 100.0 , current_timestamp,current_timestamp);
INSERT INTO bank_account(id, user_id,iban, current_balance,created_at, updated_at) VALUES(3,4, 'IBAN1', 5.0 , current_timestamp,current_timestamp);
INSERT INTO bank_account(id, user_id,iban, current_balance,created_at, updated_at) VALUES(4,5, null, 5.0 , current_timestamp,current_timestamp);

INSERT INTO card_details(id, bank_account_id,card_type, card_number, holder_name, expiry_date,cvv,created_at, updated_at) VALUES(1,1, 'DEBIT_CARD','1111222233334444', 'H. HasBankAccount','12/23','123' , current_timestamp,current_timestamp);
INSERT INTO card_details(id, bank_account_id,card_type, card_number, holder_name, expiry_date,cvv,created_at, updated_at) VALUES(2,2, 'CREDIT_CARD','5555222233334444', 'H. HasBankAccount','12/23','321' , current_timestamp,current_timestamp);
INSERT INTO card_details(id, bank_account_id,card_type, card_number, holder_name, expiry_date,cvv,created_at, updated_at) VALUES(3,3, 'DEBIT_CARD','1111222255554444', 'H. HasBankAccount','12/23','123' , current_timestamp,current_timestamp);
INSERT INTO card_details(id, bank_account_id,card_type, card_number, holder_name, expiry_date,cvv,created_at, updated_at) VALUES(4,4, 'CREDIT_CARD','5555555533334444', 'H. HasBankAccount','12/23','321' , current_timestamp,current_timestamp);