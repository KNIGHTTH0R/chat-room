create index IX_30118287 on chatRoom_ChatUser (pseudo[$COLUMN_LENGTH:75$]);

create index IX_4C71DA8C on chatRoom_Contact (chatUserId);

create index IX_12270E8F on chatRoom_Lounge (priviledge);