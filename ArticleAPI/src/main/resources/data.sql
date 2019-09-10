DROP TABLE IF EXISTS article;
 
CREATE TABLE article (
  articleId INT AUTO_INCREMENT  PRIMARY KEY,
  articleTitle VARCHAR(64) NOT NULL,
  articleBody VARCHAR(250) NOT NULL,
  creationTime DATE NOT NULL
);
 
INSERT INTO article (articleTitle, articleBody, creationTime) VALUES
  ('Article1', 'Article1', CURDATE()),
  ('Article2', 'Article2', CURDATE()),
  ('Article3', 'Article3', '2018-09-09');