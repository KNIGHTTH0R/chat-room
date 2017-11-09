create table chatRoom_ChatUser (
	id_ LONG not null primary key,
	pseudo VARCHAR(75) null,
	description VARCHAR(75) null,
	userId LONG,
	avatar VARCHAR(75) null
);

create table chatRoom_Contact (
	id_ LONG not null primary key,
	category VARCHAR(75) null,
	priviledge INTEGER,
	status INTEGER,
	chatUserId LONG
);

create table chatRoom_Lounge (
	id_ LONG not null primary key,
	name VARCHAR(75) null,
	priviledge INTEGER,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null
);