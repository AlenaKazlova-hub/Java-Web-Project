### user
INSERT INTO user(name, surname) VALUES ('nick', 'cave');
INSERT INTO user(name, surname) VALUES ('anna', 'fox');
INSERT INTO user(name, surname) VALUES ('tom', 'sawyer');
INSERT INTO user(name, surname) VALUES ('ira', 'nosova');
INSERT INTO user(name, surname) VALUES ('tamara', 'brown');
INSERT INTO user(name, surname) VALUES ('felix', 'tomson');
INSERT INTO user(name, surname) VALUES ('nikolas', 'pepe');
INSERT INTO user(name, surname) VALUES ('bruce', 'blanchard');
INSERT INTO user(name, surname) VALUES ('michael', 'korsd');
INSERT INTO user(name, surname) VALUES ('alena', 'makey');
INSERT INTO user(name, surname) VALUES ('bill', 'grey');


### account
INSERT INTO account (amount, user_id) SELECT 2067, user.id FROM user WHERE user.name='nick' AND user.surname='cave';
INSERT INTO account (amount, user_id) SELECT 1067, user.id FROM user WHERE user.name='anna' AND user.surname='fox';
INSERT INTO account (amount, user_id) SELECT 1111, user.id FROM user WHERE user.name='tom' AND user.surname='sawyer';
INSERT INTO account (amount, user_id) SELECT 7018, user.id FROM user WHERE user.name='ira' AND user.surname='nosova';
INSERT INTO account (amount, user_id) SELECT 0018, user.id FROM user WHERE user.name='tamara' AND user.surname='brown';
INSERT INTO account (amount, user_id) SELECT 7658, user.id FROM user WHERE user.name='felix' AND user.surname='tomson';
INSERT INTO account (amount, user_id) SELECT 9876, user.id FROM user WHERE user.name='nikolas' AND user.surname='pepe';
INSERT INTO account (amount, user_id) SELECT 4567, user.id FROM user WHERE user.name='bruce' AND user.surname='blanchard';
INSERT INTO account (amount, user_id) SELECT 4663, user.id FROM user WHERE user.name='michael' AND user.surname='korsd';
INSERT INTO account (amount, user_id) SELECT 4, user.id FROM user WHERE user.name='alena' AND user.surname='makey';
INSERT INTO account (amount, user_id) SELECT 5678, user.id FROM user WHERE user.name='alena' AND user.surname='makey';
INSERT INTO account (amount, user_id) SELECT 9989, user.id FROM user WHERE user.name='bill' AND user.surname='grey';
INSERT INTO account (amount, user_id) SELECT 0010, user.id FROM user WHERE user.name='bill' AND user.surname='grey';