CREATE TABLE USERS(
	userID				VARCHAR2(30),
	pw					VARCHAR2(30),
	fName				VARCHAR2(30),
	lName				VARCHAR2(30),
	email				VARCHAR2(30),
	secQ				VARCHAR2(30),
	secA				VARCHAR2(30),
	reason				VARCHAR2(30),
	isAdmin				VARCHAR2(5),
	CONSTRAINT users_userid_pk PRIMARY KEY(userID),
	CONSTRAINT is_admin CHECK (isAdmin IN ('TRUE', 'FALSE')	);
	
CREATE TABLE PROJECTS(
	projectID			NUMBER(4),
	projectFileName		VARCHAR2(30),
	course#				VARCHAR2(10),
	abstract			VARCHAR2(30),
	comChair			VARCHAR2(30),
	comMember			VARCHAR2(30),
	semester			VARCHAR2(6),
	userID				VARCHAR2(30),
	CONSTRAINT	projects_projectid_pk PRIMARY KEY(projectID),
	CONSTRAINT	projects_userid_fk FOREIGN KEY(userID)	);
