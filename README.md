use account;

create table
	LOAN_ACCOUNT
	   (LOAN_ACC_NO int not null auto_increment primary key,
		ACCOUNT_NO int not null,
		USER_ID varchar(100) not null,
		LOAN_AMOUNT FLOAT not null, 
		LOAN_TENURE int not null, 
		INT_RATE float not null,
		OPEN_DATE date not null default current_timestamp,
		MONTHLY_EMI FLOAT not null,
		LOAN_TYPE varchar(20) not null);