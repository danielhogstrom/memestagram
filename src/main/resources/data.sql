INSERT INTO USERTABLE (USERNAME, PASSWORD, EMAIL, BIO, AVATAR) VALUES ('Ante', 'password123', 'ante@mail.com', 'Tja, Ante heter jag, gillar memes och sånt. Ha det gött, tjooo!', 'https://i.postimg.cc/G4GzqdhY/7.jpg');
INSERT INTO USERTABLE (USERNAME, PASSWORD, EMAIL, BIO, AVATAR) VALUES ('Chris', 'password123', 'chris@mail.com', 'Whaddup. Chris is the name and I post the dopest memes. so long!', 'https://i.postimg.cc/1n9W82SF/3.jpg');
INSERT INTO USERTABLE (USERNAME, PASSWORD, EMAIL, BIO, AVATAR) VALUES ('Samuel', 'password123', 'samuel@mail.com', 'eat->sleep->meme->repeat', 'https://i.postimg.cc/nMSdL3Ps/9.jpg');
INSERT INTO USERTABLE (USERNAME, PASSWORD, EMAIL, BIO, AVATAR) VALUES ('Johan', 'password123', 'johan@mail.com', 'make memes not war', 'https://i.postimg.cc/wt5fTHCH/1.jpg');
INSERT INTO USERTABLE (USERNAME, PASSWORD, EMAIL, BIO, AVATAR) VALUES ('Nicke', 'password123', 'nicke@mail.com', 'original troll of memestagram', 'https://i.postimg.cc/RN3gJwkg/8.jpg');
INSERT INTO USERTABLE (USERNAME, PASSWORD, EMAIL, BIO, AVATAR) VALUES ('Hanna', 'password123', 'hanna@mail.com', 'All i do is meme, meme, meme no matter what!', 'https://i.postimg.cc/JH0PqXG4/2.jpg');
INSERT INTO USERTABLE (USERNAME, PASSWORD, EMAIL, BIO, AVATAR) VALUES ('Erika', 'password123', 'erika@mail.com', 'what am I even doing here?', 'https://i.postimg.cc/hzp2Ts45/5.jpg');
INSERT INTO USERTABLE (USERNAME, PASSWORD, EMAIL, BIO, AVATAR) VALUES ('Amanda', 'password123', 'amanda@mail.com', 'bonkers 4 memes', 'https://i.postimg.cc/jCSgKpZ0/4.jpg');
INSERT INTO USERTABLE (USERNAME, PASSWORD, EMAIL, BIO, AVATAR) VALUES ('Daniel', 'password123', 'daniel@mail.com', 'AIK FOR LIFE <3', 'https://i.postimg.cc/8jqtRjDN/6.jpg');

INSERT INTO MEME (PICURL, DESCRIPTION, LIKES, USER_ID) VALUES ('https://i.redd.it/uqk46zan8zo81.jpg','Finally someone who understands my humor!!', 12, 1);
INSERT INTO MEME (PICURL, DESCRIPTION, LIKES, USER_ID) VALUES ('https://i.imgur.com/x51rrjw.jpeg','Thats a mental illness, right??',11, 2);
INSERT INTO MEME (PICURL, DESCRIPTION, LIKES, USER_ID) VALUES ('https://i.redd.it/9iodhe6ss2p81.jpg','Who can relate?', 31, 3);
INSERT INTO MEME (PICURL, DESCRIPTION, LIKES, USER_ID) VALUES ('https://rankedbyvotes.com/wp-content/uploads/When-I-try-to-Smile.gif','100 % success rate', 21, 3);
INSERT INTO MEME (PICURL, DESCRIPTION, LIKES, USER_ID) VALUES ('https://pd-beamliving-cd.beamliving.com/-/media/bu-to-ch/cat-meme-netflix-funny-1000x666.png','Of course i am!', 11, 5);
INSERT INTO MEME (PICURL, DESCRIPTION, LIKES, USER_ID) VALUES ('https://64.media.tumblr.com/8b33555001dfd1f4c2b4a0d8894a6839/a3c4c5555a725646-ba/s640x960/4e02167f7137973c21ae0a55a94ce51f1fe0fe61.jpg','Wise words', 44, 6);
INSERT INTO MEME (PICURL, DESCRIPTION, LIKES, USER_ID) VALUES ('https://filmdaily.co/wp-content/uploads/2020/12/willsmith-2-.jpg','Hard times', 7,6 );
INSERT INTO MEME (PICURL, DESCRIPTION, LIKES, USER_ID) VALUES ('https://res.cloudinary.com/purnesh/image/upload/w_1000,f_auto,q_auto:eco,c_limit/71586859071755.jpg','True', 7,4 );
INSERT INTO MEME (PICURL, DESCRIPTION, LIKES, USER_ID) VALUES ('https://brobible.com/wp-content/uploads/2022/01/50-best-funny-memes-2022-so-far.jpg','It tastes like water', 7,6 );
INSERT INTO MEME (PICURL, DESCRIPTION, LIKES, USER_ID) VALUES ('https://images3.memedroid.com/images/UPLOADED536/6172f953593dc.jpeg','Always!', 11,2 );
INSERT INTO MEME (PICURL, DESCRIPTION, LIKES, USER_ID) VALUES ('https://www.jokejok.com/wp-content/uploads/2021/03/tenor.gif','Dramaqueen', 51, 4);
INSERT INTO MEME (PICURL, DESCRIPTION, LIKES, USER_ID) VALUES ('https://pbs.twimg.com/media/DlYjEZkWsAAgEjG?format=jpg&name=small','When you work with React', 21, 1);

INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (2,1);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (3,1);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (4,1);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (5,1);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (6,1);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (7,1);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (8,1);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (9,1);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (1,2);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (3,2);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (5,2);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (7,2);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (9,2);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (2,3);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (4,3);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (7,3);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (1,3);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (9,3);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (5,4);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (1,4);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (2,5);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (4,5);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (7,5);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (8,5);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (5,6);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (4,6);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (2,6);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (2,7);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (4,7);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (5,7);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (6,7);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (1,8);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (3,8);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (4,8);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (6,8);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (2,8);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (1,9);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (3,9);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (5,9);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (6,9);
INSERT INTO USER_FOLLOW (FRIEND_ID, USER_ID) VALUES (8,9);
