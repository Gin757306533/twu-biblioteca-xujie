/*1.Who checked out the book 'The Hobbit'?*/
SELECT member.name 
	FROM 
member 
    JOIN 
        checkout_item 
    ON 
        member.id == checkout_item.member_id 
    JOIN 
        book 
    ON 
    checkout_item.book_id == book.id 
WHERE 
book.title ='The Hobbit';

/*2. How many people have not checked out anything?*/
SELECT COUNT(id)
FROM member
WHERE id NOT IN (
	SELECT member_id
	FROM checkout_item
);


/*3. What books and movies aren't checked out?*/

SELECT title
FROM book
WHERE id NOT IN (
	SELECT book_id
	FROM checkout_item
	WHERE book_id != NULL
)
UNION
SELECT title
FROM movie
WHERE id NOT IN (
	SELECT movie_id
	FROM checkout_item
	WHERE movie_id != NULL
);


/*4. Add the book 'The Pragmatic Programmer', and add yourself as a member. Check out 'The Pragmatic Programmer'. Use your query from question 1 to verify that you have checked it out. Also, provide the SQL used to update the database.
*/

INSERT INTO book (title)
VALUES ('The Pragmatic Programmer');

INSERT INTO member (name)
VALUES ('xujie');

INSERT INTO checkout_item (member_id, book_id)
VALUES (43, 11);

SELECT member.name 
	FROM 
member 
    JOIN 
        checkout_item 
    ON 
        member.id == checkout_item.member_id 
    JOIN 
        book 
    ON 
    checkout_item.book_id == book.id 
WHERE 
book.title ='The Pragmatic Programmer';

/*5. Who has checked out more than 1 item? */
SELECT name
FROM member
WHERE id IN (
	SELECT member_id
	FROM checkout_item
	GROUP BY member_id
	HAVING COUNT(*) > 1
);