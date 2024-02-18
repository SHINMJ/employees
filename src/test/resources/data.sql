INSERT INTO regions (region_id, region_name)
VALUES (
	101,
	'Asia'
	);

INSERT INTO countries (country_id, country_name, region_id)
VALUES (
	'KO',
	'Korea',
	101
	);

INSERT INTO locations (location_id, street_address, postal_code, city, country_id)
VALUES (
	1000,
	'1297 Via Cola di Rie',
	'00989',
	'Seoul',
	'KO'
	);

INSERT INTO locations (location_id, street_address, postal_code, city, country_id)
VALUES (
	1100,
	'1297 Via Cola di Rie',
	'00989',
	'Anyang',
	'KO'
	);

SET referential_integrity false;

INSERT INTO departments (department_id, department_name, manager_id, location_id)
VALUES (
	10,
	'Administration',
	200,
	1100
	);

INSERT INTO departments (department_id, department_name, manager_id, location_id)
VALUES (
	20,
	'Marketing',
	201,
	1200
	);


INSERT INTO jobs (job_id, job_title, min_salary, max_salary)
VALUES (
	'AD_PRES',
	'President',
	20000,
	40000
	);

INSERT INTO jobs (job_id, job_title, min_salary, max_salary)
VALUES (
	'AD_VP',
	'Administration Vice President',
	15000,
	30000
	);


INSERT INTO employees (employee_id, first_name, last_name, email, hire_date, salary, job_id, department_id)
VALUES (
	100,
	'Steven',
	'King',
	'SKING@email.com',
	PARSEDATETIME('17-07-1987', 'dd-MM-yyyy'),
	24000,
	'AD_PRES',
	10
	);

INSERT INTO employees (employee_id, first_name, last_name, email, hire_date, salary, job_id, department_id, manager_id)
VALUES (
	101,
	'Neena',
	'Kochhar',
	'NKOCHHAR@email.com',
	PARSEDATETIME('21-09-1989', 'dd-MM-yyyy'),
	17000,
	'AD_VP',
	20,
	100
	);

INSERT INTO employees (employee_id, first_name, last_name, email, hire_date, salary, job_id, department_id, manager_id)
VALUES (
	102,
	'Lex',
	'De Haan',
	'LDEHAAN',
	PARSEDATETIME('13-01-1993', 'dd-MM-yyyy'),
	17000,
	'AD_VP',
	10,
	100
	);


INSERT INTO job_history (employee_id, start_date, end_date, job_id, department_id)
VALUES (
	102,
	PARSEDATETIME('13-01-1993', 'dd-MM-yyyy'),
	PARSEDATETIME('24-06-1998', 'dd-MM-yyyy'),
	'AD_VP',
	10
	);

INSERT INTO job_history (employee_id, start_date, end_date, job_id, department_id)
VALUES (
	101,
	PARSEDATETIME('21-09-1989', 'dd-MM-yyyy'),
	PARSEDATETIME('27-10-1993', 'dd-MM-yyyy'),
	'AD_VP',
	20
	);

INSERT INTO job_history (employee_id, start_date, end_date, job_id, department_id)
VALUES (
	101,
	PARSEDATETIME('28-10-1993','dd-MM-yyyy'),
	PARSEDATETIME('15-05-1997','dd-MM-yyyy'),
	'AD_VP',
	20
	);

SET referential_integrity true;
