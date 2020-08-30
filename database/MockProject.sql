CREATE DATABASE MockProject
GO 
USE MockProject
GO

CREATE TABLE [User](
	UserID INT IDENTITY PRIMARY KEY ,
	UserName NVARCHAR(50) NOT NULL,
	PassWord INT NOT NULL,
	[State] TINYINT CHECK ([State] BETWEEN 0 AND 1) NOT NULL
)

CREATE TABLE BookCase(
	BookCaseID INT IDENTITY PRIMARY KEY ,
	BookCaseName NVARCHAR(50) NOT NULL,
	constraint fk_BookCase foreign key (BookCaseID) references [user](UserID)

CREATE TABLE Book(
	BookID INT IDENTITY PRIMARY KEY ,
	BookName NVARCHAR(50) NOT NULL,
	BookTitle NVARCHAR(50) NOT NULL,
	Author NVARCHAR(50) NOT NULL,
	Brief NVARCHAR(255) NOT NULL,
	Publisher NVARCHAR(50) NOT NULL,
	Content NVARCHAR(255) NOT NULL,
	Category NVARCHAR(50) NOT NULL
)

CREATE TABLE Contain(
	BookCaseID INT FOREIGN KEY REFERENCES BookCase(BookCaseID),
	BookID INT FOREIGN KEY REFERENCES Book(BookID),
	CREATED_DATE DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT PK_Contain PRIMARY KEY (BookCaseID,BookID)
)

INSERT INTO [User](UserName,PassWord,State) VALUES
('user1', 12345, 0),
('user2', 2345, 0),
('user3', 4534, 0),
('user4', 1232, 0),
('admin1', 1199, 1)
GO

INSERT INTO BookCase(BookCaseName) VALUES
('Case1'),
('Case2'),
('Case3'),
('Case4'),
('Case5')
GO

INSERT INTO Book(BookName, BookTitle, Author, Brief, Publisher, Content, Category) VALUES
('Book1', 'Title1', 'Author1', 'Brief1', 'Publisher1', 'Content1', 'Category1'),
('Book2', 'Title2', 'Author2', 'Brief2', 'Publisher2', 'Content2', 'Category2'),
('Book3', 'Title3', 'Author3', 'Brief3', 'Publisher3', 'Content3', 'Category3'),
('Book4', 'Title4', 'Author4', 'Brief4', 'Publisher4', 'Content4', 'Category4'),
('Book5', 'Title5', 'Author5', 'Brief5', 'Publisher5', 'Content5', 'Category5')
GO

INSERT INTO Contain(BookCaseID,BookID,CREATED_DATE) VALUES
(1, 5, '2012-1-12'),
(2, 4, '2012-2-12'),
(3, 3, '2017-3-12'),
(4, 2, '2016-5-12'),
(5, 1, '2012-7-12')
GO