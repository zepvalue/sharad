-- Ads schema
-- !Ups

CREATE TABLE Ads (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  title VARCHAR(255)
);

-- !Downs

DROP TABLE Ads;