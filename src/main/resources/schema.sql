ALTER TABLE MEME ADD FOREIGN KEY (USER_ID) REFERENCES USERTABLE(ID);
ALTER TABLE USER_FOLLOW ADD FOREIGN KEY (USER_ID) REFERENCES USERTABLE(ID);
ALTER TABLE USER_FOLLOW ADD FOREIGN KEY (FRIEND_ID) REFERENCES USERTABLE(ID);
