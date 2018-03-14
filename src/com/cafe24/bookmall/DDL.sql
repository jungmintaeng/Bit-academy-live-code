-- 서적
ALTER TABLE `BOOKMALL`.`BOOK`
	DROP FOREIGN KEY `FK_CATEGORY_TO_BOOK`; -- 카테고리 -> 서적

-- 카트
ALTER TABLE `BOOKMALL`.`CART`
	DROP FOREIGN KEY `FK_BOOK_TO_CART`; -- 서적 -> 카트

-- 카트
ALTER TABLE `BOOKMALL`.`CART`
	DROP FOREIGN KEY `FK_MEMBER_TO_CART`; -- 고객 -> 카트

-- 주문서
ALTER TABLE `BOOKMALL`.`ORDER_SHEET`
	DROP FOREIGN KEY `FK_MEMBER_TO_ORDER_SHEET`; -- 고객 -> 주문서

-- 주문 도서
ALTER TABLE `BOOKMALL`.`ORDER_BOOK`
	DROP FOREIGN KEY `FK_ORDER_SHEET_TO_ORDER_BOOK`; -- 주문서 -> 주문 도서

-- 주문 도서
ALTER TABLE `BOOKMALL`.`ORDER_BOOK`
	DROP FOREIGN KEY `FK_BOOK_TO_ORDER_BOOK`; -- 서적 -> 주문 도서

-- 카테고리
CREATE TABLE `BOOKMALL`.`CATEGORY` (
	`no`   INTEGER     NOT NULL COMMENT '번호', -- 번호
	`name` VARCHAR(50) NULL     COMMENT '이름' -- 이름
)
COMMENT '카테고리';

-- 카테고리
ALTER TABLE `BOOKMALL`.`CATEGORY`
	ADD CONSTRAINT `PK_CATEGORY` -- 카테고리 기본키
		PRIMARY KEY (
			`no` -- 번호
		);

ALTER TABLE `BOOKMALL`.`CATEGORY`
	MODIFY COLUMN `no` INTEGER NOT NULL AUTO_INCREMENT COMMENT '번호';

-- 서적
CREATE TABLE `BOOKMALL`.`BOOK` (
	`no`          INTEGER      NOT NULL COMMENT '번호', -- 번호
	`title`       VARCHAR(100) NULL     COMMENT '제목', -- 제목
	`price`       INTEGER      NULL     COMMENT '가격', -- 가격
	`category_no` INTEGER      NULL     COMMENT '카테고리 번호' -- 카테고리 번호
)
COMMENT '서적';

-- 서적
ALTER TABLE `BOOKMALL`.`BOOK`
	ADD CONSTRAINT `PK_BOOK` -- 서적 기본키
		PRIMARY KEY (
			`no` -- 번호
		);

ALTER TABLE `BOOKMALL`.`BOOK`
	MODIFY COLUMN `no` INTEGER NOT NULL AUTO_INCREMENT COMMENT '번호';

-- 고객
CREATE TABLE `BOOKMALL`.`MEMBER` (
	`no`           INTEGER     NOT NULL COMMENT '번호', -- 번호
	`name`         VARCHAR(50) NULL     COMMENT '이름', -- 이름
	`phone_number` VARCHAR(30) NULL     COMMENT '전화번호', -- 전화번호
	`email`        VARCHAR(40) NULL     COMMENT '이메일', -- 이메일
	`password`     VARCHAR(48) NULL     COMMENT '비밀번호' -- 비밀번호
)
COMMENT '고객';

-- 고객
ALTER TABLE `BOOKMALL`.`MEMBER`
	ADD CONSTRAINT `PK_MEMBER` -- 고객 기본키
		PRIMARY KEY (
			`no` -- 번호
		);

ALTER TABLE `BOOKMALL`.`MEMBER`
	MODIFY COLUMN `no` INTEGER NOT NULL AUTO_INCREMENT COMMENT '번호';

-- 카트
CREATE TABLE `BOOKMALL`.`CART` (
	`member_no` INTEGER NOT NULL COMMENT '고객 번호', -- 고객 번호
	`book_no`   INTEGER NOT NULL COMMENT '서적 번호', -- 서적 번호
	`quantity`  INTEGER NULL     COMMENT '수량' -- 수량
)
COMMENT '카트';

-- 카트
ALTER TABLE `BOOKMALL`.`CART`
	ADD CONSTRAINT `PK_CART` -- 카트 기본키
		PRIMARY KEY (
			`member_no`, -- 고객 번호
			`book_no`    -- 서적 번호
		);

-- 주문서
CREATE TABLE `BOOKMALL`.`ORDER_SHEET` (
	`no`        INTEGER      NOT NULL COMMENT '번호', -- 번호
	`code`      VARCHAR(16)  NULL     COMMENT '주문번호', -- 주문번호
	`address`   VARCHAR(255) NULL     COMMENT '배송지', -- 배송지
	`member_no` INTEGER      NULL     COMMENT '주문 고객 번호' -- 주문 고객 번호
)
COMMENT '주문서';

-- 주문서
ALTER TABLE `BOOKMALL`.`ORDER_SHEET`
	ADD CONSTRAINT `PK_ORDER_SHEET` -- 주문서 기본키
		PRIMARY KEY (
			`no` -- 번호
		);

ALTER TABLE `BOOKMALL`.`ORDER_SHEET`
	MODIFY COLUMN `no` INTEGER NOT NULL AUTO_INCREMENT COMMENT '번호';

-- 주문 도서
CREATE TABLE `BOOKMALL`.`ORDER_BOOK` (
	`order_no`      INTEGER NOT NULL COMMENT '주문서 번호', -- 주문서 번호
	`book_no`       INTEGER NOT NULL COMMENT '서적 번호', -- 서적 번호
	`quantity`      INTEGER NULL     COMMENT '수량', -- 수량
	`bookprice_old` INTEGER NULL     COMMENT '당시 책 금액' -- 당시 책 금액
)
COMMENT '주문 도서';

-- 주문 도서
ALTER TABLE `BOOKMALL`.`ORDER_BOOK`
	ADD CONSTRAINT `PK_ORDER_BOOK` -- 주문 도서 기본키
		PRIMARY KEY (
			`order_no`, -- 주문서 번호
			`book_no`   -- 서적 번호
		);

-- 서적
ALTER TABLE `BOOKMALL`.`BOOK`
	ADD CONSTRAINT `FK_CATEGORY_TO_BOOK` -- 카테고리 -> 서적
		FOREIGN KEY (
			`category_no` -- 카테고리 번호
		)
		REFERENCES `BOOKMALL`.`CATEGORY` ( -- 카테고리
			`no` -- 번호
		);

-- 카트
ALTER TABLE `BOOKMALL`.`CART`
	ADD CONSTRAINT `FK_BOOK_TO_CART` -- 서적 -> 카트
		FOREIGN KEY (
			`book_no` -- 서적 번호
		)
		REFERENCES `BOOKMALL`.`BOOK` ( -- 서적
			`no` -- 번호
		);

-- 카트
ALTER TABLE `BOOKMALL`.`CART`
	ADD CONSTRAINT `FK_MEMBER_TO_CART` -- 고객 -> 카트
		FOREIGN KEY (
			`member_no` -- 고객 번호
		)
		REFERENCES `BOOKMALL`.`MEMBER` ( -- 고객
			`no` -- 번호
		);

-- 주문서
ALTER TABLE `BOOKMALL`.`ORDER_SHEET`
	ADD CONSTRAINT `FK_MEMBER_TO_ORDER_SHEET` -- 고객 -> 주문서
		FOREIGN KEY (
			`member_no` -- 주문 고객 번호
		)
		REFERENCES `BOOKMALL`.`MEMBER` ( -- 고객
			`no` -- 번호
		);

-- 주문 도서
ALTER TABLE `BOOKMALL`.`ORDER_BOOK`
	ADD CONSTRAINT `FK_ORDER_SHEET_TO_ORDER_BOOK` -- 주문서 -> 주문 도서
		FOREIGN KEY (
			`order_no` -- 주문서 번호
		)
		REFERENCES `BOOKMALL`.`ORDER_SHEET` ( -- 주문서
			`no` -- 번호
		);

-- 주문 도서
ALTER TABLE `BOOKMALL`.`ORDER_BOOK`
	ADD CONSTRAINT `FK_BOOK_TO_ORDER_BOOK` -- 서적 -> 주문 도서
		FOREIGN KEY (
			`book_no` -- 서적 번호
		)
		REFERENCES `BOOKMALL`.`BOOK` ( -- 서적
			`no` -- 번호
		);