
LOCK TABLES `contact_type` WRITE;
/*!40000 ALTER TABLE `contact_type` DISABLE KEYS */;
INSERT INTO `contact_type` VALUES (4,'new'),(5,'simple'),(6,'vip');
/*!40000 ALTER TABLE `contact_type` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (28,'Alexander','Pushkin','Sergeevich','author'),(40,'Leo','Tolstoy','Nikolaevich','author'),(41,'Petr','Kapica','Leonidovich','scientist'),(42,'Dmitry','Mendeleev','Ivanovich','scientist');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` VALUES (14,6,'+74950000001',28),(15,6,'+74950000002',40),(16,6,'+74950000003',28),(17,6,'+74950000004',41),(18,6,'+74950000005',42);
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('admin@admin.ru','$2a$10$9fyLydB5P4qdtl37SRXoSuJNPsfjEBHE7wK.Igc4JnoFlgl1juBiK','ROLE_ADMIN');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;