CREATE TABLE egg_lot (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(15) NOT NULL,
    box_color VARCHAR(15),
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE chicken_lot ADD egg_lot_id INT;
ALTER TABLE chicken_lot ADD FOREIGN KEY (egg_lot_id) REFERENCES egg_lot(id);


CREATE TABLE egg_base (
	id INT NOT NULL AUTO_INCREMENT,
	quantity INT NOT NULL,
	production_date DATE NOT NULL,
	validity_date DATE NOT NULL,
    egg_lot_id INT NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (egg_lot_id) REFERENCES egg_lot(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE egg_type (
	id INT NOT NULL AUTO_INCREMENT,
	type VARCHAR(15) NOT NULL,
	category VARCHAR(2) NOT NULL,
    min_weight INT(2) NOT NULL,
    max_weight INT(2) NOT NULL,
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE classification (
	id INT NOT NULL AUTO_INCREMENT,
	quantity INT NOT NULL,
    egg_base_id INT NOT NULL,
    egg_type_id INT NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (egg_base_id) REFERENCES egg_base(id),
	FOREIGN KEY (egg_type_id) REFERENCES egg_type(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE packing (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(45) NOT NULL,
	packing_type VARCHAR(15) NOT NULL,
    quantity_by_packing INT NOT NULL,
    packing_by_box INT NOT NULL,
    quantity_by_box INT NOT NULL,
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE expedition (
	id INT NOT NULL AUTO_INCREMENT,
	date DATE NOT NULL,
	quantity INT NOT NULL,
	ret INT NOT NULL,
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE product (
	id INT NOT NULL AUTO_INCREMENT,
	quantity INT NOT NULL,
    classification_id INT NOT NULL,
    packing_id INT NOT NULL,
    expedition_id INT NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (classification_id) REFERENCES classification(id),
	FOREIGN KEY (packing_id) REFERENCES packing(id),
	FOREIGN KEY (expedition_id) REFERENCES expedition(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE line (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(15) NOT NULL,
    expedition_id INT NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (expedition_id) REFERENCES expedition(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE city (
	id INT NOT NULL AUTO_INCREMENT,
	city VARCHAR(45) NOT NULL,
    state VARCHAR(15) NOT NULL,
    line_id INT NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (line_id) REFERENCES line(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



