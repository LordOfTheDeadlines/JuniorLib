delete from article;
delete from subject;

insert into subject(id, name) values
(1, 'sub1'),
(2, 'sub2');

insert into article(id, content, subject_id, title) values
(1, 'content1', 1, 'title1'),
(2, 'content2', 2, 'title2');
