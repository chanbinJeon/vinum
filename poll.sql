CREATE TABLE pollAdmin (
	pollId NUMBER PRIMARY KEY,
	pollSubject VARCHAR2(30) NOT NULL,
	pollDesc VARCHAR2(300) NOT NULL
)

CREATE TABLE pollAdminAppend(
	pollId NUMBER PRIMARY KEY,
	pollQuestion VARCHAR2(50) NOT NULL,
	pollAnswer VARCHAR2(100) NOT NULL
)

ALTER TABLE pollAdminAppend
ADD CONSTRAINT fk_pollAdminApped_pollId FOREIGN KEY (pollId)
REFERENCES pollAdmin(pollId)

CREATE SEQUENCE poll_seq;