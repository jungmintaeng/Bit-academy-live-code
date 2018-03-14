-- ����
ALTER TABLE `BOOKMALL`.`BOOK`
	DROP FOREIGN KEY `FK_CATEGORY_TO_BOOK`; -- ī�װ� -> ����

-- īƮ
ALTER TABLE `BOOKMALL`.`CART`
	DROP FOREIGN KEY `FK_BOOK_TO_CART`; -- ���� -> īƮ

-- īƮ
ALTER TABLE `BOOKMALL`.`CART`
	DROP FOREIGN KEY `FK_MEMBER_TO_CART`; -- �� -> īƮ

-- �ֹ���
ALTER TABLE `BOOKMALL`.`ORDER_SHEET`
	DROP FOREIGN KEY `FK_MEMBER_TO_ORDER_SHEET`; -- �� -> �ֹ���

-- �ֹ� ����
ALTER TABLE `BOOKMALL`.`ORDER_BOOK`
	DROP FOREIGN KEY `FK_ORDER_SHEET_TO_ORDER_BOOK`; -- �ֹ��� -> �ֹ� ����

-- �ֹ� ����
ALTER TABLE `BOOKMALL`.`ORDER_BOOK`
	DROP FOREIGN KEY `FK_BOOK_TO_ORDER_BOOK`; -- ���� -> �ֹ� ����

-- ī�װ�
CREATE TABLE `BOOKMALL`.`CATEGORY` (
	`no`   INTEGER     NOT NULL COMMENT '��ȣ', -- ��ȣ
	`name` VARCHAR(50) NULL     COMMENT '�̸�' -- �̸�
)
COMMENT 'ī�װ�';

-- ī�װ�
ALTER TABLE `BOOKMALL`.`CATEGORY`
	ADD CONSTRAINT `PK_CATEGORY` -- ī�װ� �⺻Ű
		PRIMARY KEY (
			`no` -- ��ȣ
		);

ALTER TABLE `BOOKMALL`.`CATEGORY`
	MODIFY COLUMN `no` INTEGER NOT NULL AUTO_INCREMENT COMMENT '��ȣ';

-- ����
CREATE TABLE `BOOKMALL`.`BOOK` (
	`no`          INTEGER      NOT NULL COMMENT '��ȣ', -- ��ȣ
	`title`       VARCHAR(100) NULL     COMMENT '����', -- ����
	`price`       INTEGER      NULL     COMMENT '����', -- ����
	`category_no` INTEGER      NULL     COMMENT 'ī�װ� ��ȣ' -- ī�װ� ��ȣ
)
COMMENT '����';

-- ����
ALTER TABLE `BOOKMALL`.`BOOK`
	ADD CONSTRAINT `PK_BOOK` -- ���� �⺻Ű
		PRIMARY KEY (
			`no` -- ��ȣ
		);

ALTER TABLE `BOOKMALL`.`BOOK`
	MODIFY COLUMN `no` INTEGER NOT NULL AUTO_INCREMENT COMMENT '��ȣ';

-- ��
CREATE TABLE `BOOKMALL`.`MEMBER` (
	`no`           INTEGER     NOT NULL COMMENT '��ȣ', -- ��ȣ
	`name`         VARCHAR(50) NULL     COMMENT '�̸�', -- �̸�
	`phone_number` VARCHAR(30) NULL     COMMENT '��ȭ��ȣ', -- ��ȭ��ȣ
	`email`        VARCHAR(40) NULL     COMMENT '�̸���', -- �̸���
	`password`     VARCHAR(48) NULL     COMMENT '��й�ȣ' -- ��й�ȣ
)
COMMENT '��';

-- ��
ALTER TABLE `BOOKMALL`.`MEMBER`
	ADD CONSTRAINT `PK_MEMBER` -- �� �⺻Ű
		PRIMARY KEY (
			`no` -- ��ȣ
		);

ALTER TABLE `BOOKMALL`.`MEMBER`
	MODIFY COLUMN `no` INTEGER NOT NULL AUTO_INCREMENT COMMENT '��ȣ';

-- īƮ
CREATE TABLE `BOOKMALL`.`CART` (
	`member_no` INTEGER NOT NULL COMMENT '�� ��ȣ', -- �� ��ȣ
	`book_no`   INTEGER NOT NULL COMMENT '���� ��ȣ', -- ���� ��ȣ
	`quantity`  INTEGER NULL     COMMENT '����' -- ����
)
COMMENT 'īƮ';

-- īƮ
ALTER TABLE `BOOKMALL`.`CART`
	ADD CONSTRAINT `PK_CART` -- īƮ �⺻Ű
		PRIMARY KEY (
			`member_no`, -- �� ��ȣ
			`book_no`    -- ���� ��ȣ
		);

-- �ֹ���
CREATE TABLE `BOOKMALL`.`ORDER_SHEET` (
	`no`        INTEGER      NOT NULL COMMENT '��ȣ', -- ��ȣ
	`code`      VARCHAR(16)  NULL     COMMENT '�ֹ���ȣ', -- �ֹ���ȣ
	`address`   VARCHAR(255) NULL     COMMENT '�����', -- �����
	`member_no` INTEGER      NULL     COMMENT '�ֹ� �� ��ȣ' -- �ֹ� �� ��ȣ
)
COMMENT '�ֹ���';

-- �ֹ���
ALTER TABLE `BOOKMALL`.`ORDER_SHEET`
	ADD CONSTRAINT `PK_ORDER_SHEET` -- �ֹ��� �⺻Ű
		PRIMARY KEY (
			`no` -- ��ȣ
		);

ALTER TABLE `BOOKMALL`.`ORDER_SHEET`
	MODIFY COLUMN `no` INTEGER NOT NULL AUTO_INCREMENT COMMENT '��ȣ';

-- �ֹ� ����
CREATE TABLE `BOOKMALL`.`ORDER_BOOK` (
	`order_no`      INTEGER NOT NULL COMMENT '�ֹ��� ��ȣ', -- �ֹ��� ��ȣ
	`book_no`       INTEGER NOT NULL COMMENT '���� ��ȣ', -- ���� ��ȣ
	`quantity`      INTEGER NULL     COMMENT '����', -- ����
	`bookprice_old` INTEGER NULL     COMMENT '��� å �ݾ�' -- ��� å �ݾ�
)
COMMENT '�ֹ� ����';

-- �ֹ� ����
ALTER TABLE `BOOKMALL`.`ORDER_BOOK`
	ADD CONSTRAINT `PK_ORDER_BOOK` -- �ֹ� ���� �⺻Ű
		PRIMARY KEY (
			`order_no`, -- �ֹ��� ��ȣ
			`book_no`   -- ���� ��ȣ
		);

-- ����
ALTER TABLE `BOOKMALL`.`BOOK`
	ADD CONSTRAINT `FK_CATEGORY_TO_BOOK` -- ī�װ� -> ����
		FOREIGN KEY (
			`category_no` -- ī�װ� ��ȣ
		)
		REFERENCES `BOOKMALL`.`CATEGORY` ( -- ī�װ�
			`no` -- ��ȣ
		);

-- īƮ
ALTER TABLE `BOOKMALL`.`CART`
	ADD CONSTRAINT `FK_BOOK_TO_CART` -- ���� -> īƮ
		FOREIGN KEY (
			`book_no` -- ���� ��ȣ
		)
		REFERENCES `BOOKMALL`.`BOOK` ( -- ����
			`no` -- ��ȣ
		);

-- īƮ
ALTER TABLE `BOOKMALL`.`CART`
	ADD CONSTRAINT `FK_MEMBER_TO_CART` -- �� -> īƮ
		FOREIGN KEY (
			`member_no` -- �� ��ȣ
		)
		REFERENCES `BOOKMALL`.`MEMBER` ( -- ��
			`no` -- ��ȣ
		);

-- �ֹ���
ALTER TABLE `BOOKMALL`.`ORDER_SHEET`
	ADD CONSTRAINT `FK_MEMBER_TO_ORDER_SHEET` -- �� -> �ֹ���
		FOREIGN KEY (
			`member_no` -- �ֹ� �� ��ȣ
		)
		REFERENCES `BOOKMALL`.`MEMBER` ( -- ��
			`no` -- ��ȣ
		);

-- �ֹ� ����
ALTER TABLE `BOOKMALL`.`ORDER_BOOK`
	ADD CONSTRAINT `FK_ORDER_SHEET_TO_ORDER_BOOK` -- �ֹ��� -> �ֹ� ����
		FOREIGN KEY (
			`order_no` -- �ֹ��� ��ȣ
		)
		REFERENCES `BOOKMALL`.`ORDER_SHEET` ( -- �ֹ���
			`no` -- ��ȣ
		);

-- �ֹ� ����
ALTER TABLE `BOOKMALL`.`ORDER_BOOK`
	ADD CONSTRAINT `FK_BOOK_TO_ORDER_BOOK` -- ���� -> �ֹ� ����
		FOREIGN KEY (
			`book_no` -- ���� ��ȣ
		)
		REFERENCES `BOOKMALL`.`BOOK` ( -- ����
			`no` -- ��ȣ
		);