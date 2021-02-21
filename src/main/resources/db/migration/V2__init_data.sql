INSERT INTO "users"("id","first_name", "last_name", "email_address", "is_admin", "is_blocked", "username", "hashed_password")
 VALUES (-1, 'Vandam', 'Vandamyan', 'vandam@gmail.com', true, false, 'vandam', '$2a$10$du/TVwjbs5cbFtg8zPT6PuCTXjSWZDYwT4h2C1g.zJEzQJfyTw2hu');


INSERT INTO "categories"("id","name") VALUES (-1, 'Mobile phones');
INSERT INTO "categories"("id","name") VALUES (-2, 'TV');

INSERT INTO "products"("id","name", "description", "price", "category_id") VALUES (-1, 'Iphone11', 'lcd', 599.9, -1);
INSERT INTO "products"("id","name", "description", "price", "category_id") VALUES (-2, 'Sony', 'oled', 999.99, -2);
