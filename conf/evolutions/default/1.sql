-- Ads schema
-- !Ups

CREATE TABLE Ads (
  id INT PRIMARY KEY,
  title VARCHAR(255)
);

-- !Downs

DROP TABLE Ads;