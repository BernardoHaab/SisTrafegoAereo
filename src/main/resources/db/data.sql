INSERT INTO AEROPORTO VALUES ('POA', 'Porto Alegre')
INSERT INTO AEROPORTO VALUES ('FLO', 'Florianópolis')
INSERT INTO AEROPORTO VALUES ('CWB', 'Curitiba')
INSERT INTO AEROPORTO VALUES ('GRU', 'SÃO PAULO')


INSERT INTO AEROVIA VALUES (1, 30000, 450, 'POA-FLO', 'POA', 'FLO')
INSERT INTO AEROVIA VALUES (2, 29000, 450, 'POA-FLO', 'POA', 'FLO')
INSERT INTO AEROVIA VALUES (3, 29000, 450, 'FLO-POA', 'FLO', 'POA')

INSERT INTO AEROVIA VALUES (4, 28000, 1100, 'GRU-POA', 'GRU', 'POA')
INSERT INTO AEROVIA VALUES (5, 28000, 1100, 'POA-GRU', 'POA', 'GRU')

INSERT INTO AEROVIA VALUES (6, 33000, 400, 'CWB-POA', 'CWB', 'POA')
INSERT INTO AEROVIA VALUES (7, 33000, 400, 'POA-CWB', 'POA', 'CWB')

INSERT INTO AEROVIA VALUES (8, 25000, 300, 'CWB-FLO', 'CWB', 'FLO')
INSERT INTO AEROVIA VALUES (9, 25000, 300, 'FLO-CWB', 'FLO', 'CWB')


INSERT INTO AERONAVE VALUES ('P', 'PPABC', 1500, 850, NULL, NULL, 1, NULL, 'Paulo')
INSERT INTO AERONAVE VALUES ('CC', 'PPSTD', 30000, 850, 'PauloVia', 10000, 2, NULL, NULL)
INSERT INTO AERONAVE VALUES ('CP', 'PTFGH', 30000, 850, 'PauloVia', NULL, 3, 100, NULL)
