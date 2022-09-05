CREATE TABLE IF NOT EXISTS BET (
    BET_ID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    USER_ID INT NOT NULL,
    POINTS DECIMAL(10,2) NOT NULL,
    PRIZE DECIMAL(10,2) NOT NULL,
    ODD DECIMAL(5,2) NOT NULL,
    WINNER_INDICATOR CHAR(1) NULL,
    TSTAMP DATETIME NOT NULL,
    PRIMARY KEY (BET_ID));

-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS BET_FIXTURES (
    BET_FIXTURES_ID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    BET_ID INT NOT NULL,
    SPORT_CODE CHAR(2) NOT NULL,
    EVENT INT NOT NULL,
    ODD DECIMAL(5,2) NOT NULL,
    BET_TYPE VARCHAR(3) NOT NULL,
    OPTION VARCHAR(70) NOT NULL,
    CORRECT CHAR(1) NULL,
    PRIMARY KEY (BET_FIXTURES_ID));


-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS FRIENDS (
    FRIENDS_ID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    USER_ONE INT NOT NULL,
    USER_TWO INT NOT NULL,
    FROM_DATE DATE NOT NULL,
    PRIMARY KEY (FRIENDS_ID));


-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS FRIEND_REQUEST (
    FRIEND_REQUEST_ID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    USER_SENDING INT NOT NULL,
    USER_RECEIVING INT NOT NULL,
    PRIMARY KEY (FRIEND_REQUEST_ID));


-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS REFRESH_TOKEN (
    REFRESH_TOKEN_ID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    USER_ID INT NOT NULL,
    TOKEN VARCHAR(500) NOT NULL,
    EXPIRE_AT DATETIME NOT NULL,
    PRIMARY KEY (REFRESH_TOKEN_ID));


-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS USERS (
    USER_ID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    USERNAME VARCHAR(50) NOT NULL,
    EMAIL VARCHAR(100) NOT NULL,
    PASSWORD VARCHAR(500) NOT NULL,
    ROLE CHAR(2) NOT NULL,
    DISABLED_INDICATOR CHAR(1) NOT NULL,
    PRIMARY KEY (USER_ID));


-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS USER_INFO (
    USER_INFO_ID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    USER_ID INT NOT NULL,
    NAME VARCHAR(50) NOT NULL,
    SURNAME VARCHAR(80) NOT NULL,
    BANNED_INDICATOR CHAR(1) NOT NULL,
    BANNED_TO DATE NULL,
    POINTS DECIMAL(10,2) NOT NULL,
    BANKRUPT_TIMES INT NOT NULL,
    PRIMARY KEY (USER_INFO_ID));


-- -----------------------------------------------------
alter table BET
    add constraint fk_BET_USER1 foreign key (USER_ID)
        references USERS (USER_ID)
        on delete restrict;

alter table BET_FIXTURES
    add constraint fk_BET_FIXTURES_BET1 foreign key (BET_ID)
        references BET (BET_ID)
        on delete restrict;

alter table FRIENDS
    add constraint fk_FRIENDS_USER1 foreign key (USER_ONE)
        references USERS (USER_ID)
        on delete restrict;

alter table FRIENDS
    add constraint fk_FRIENDS_USER2 foreign key (USER_TWO)
        references USERS (USER_ID)
        on delete restrict;

alter table FRIEND_REQUEST
    add constraint fk_FRIEND_REQUEST_USER1 foreign key (USER_SENDING)
        references USERS (USER_ID)
        on delete restrict;

alter table FRIEND_REQUEST
    add constraint fk_FRIEND_REQUEST_USER2 foreign key (USER_RECEIVING)
        references USERS (USER_ID)
        on delete restrict;

alter table REFRESH_TOKEN
    add constraint fk_REFRESH_TOKEN_USER1 foreign key (USER_ID)
        references USERS (USER_ID)
        on delete restrict;

alter table USER_INFO
    add constraint fk_USER_INFO_USER foreign key (USER_ID)
        references USERS (USER_ID)
        on delete restrict;