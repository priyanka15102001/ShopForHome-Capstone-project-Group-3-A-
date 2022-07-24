-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: shopping_cart
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (3,'deepanshu','12345'),(6,'tarun','123'),(7,'manoj','123'),(11,'admin','123'),(12,'harshita','admin'),(13,'gaurav','admin123'),(14,'ritesh','123');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `id` int NOT NULL AUTO_INCREMENT,
  `item_name` varchar(45) NOT NULL,
  `quantity` varchar(45) NOT NULL,
  `product_price` float NOT NULL,
  `discount_amt` float NOT NULL,
  `username` varchar(45) NOT NULL,
  `img_url` varchar(1000) NOT NULL,
  `product_id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=140 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (89,'white sofa','1',4999,20,'admin','https://www.ulcdn.net/images/products/309981/original/FNSF52WCNW3_-_main_1.png?1606711207',28);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(45) NOT NULL,
  `category_type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'light','light'),(2,'mobile','accesories');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(45) NOT NULL,
  `product_type` varchar(45) NOT NULL,
  `product_price` int NOT NULL,
  `product_desc` varchar(45) NOT NULL,
  `stocks` int NOT NULL,
  `img_url` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (54,'London-Bed','Bed',400,'London bed for comfort',99,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQrh8Oju9sfDVcJSShbAM_YIZFx9ODae4cyiQ&usqp=CAU'),(55,'King-Queen bed','Bed',500,'Bed like a king- queen',98,'https://images.eq3.com/product-definitions/cjzcwjmin0bfe0166a8sbjpd4/instance/ck1b4r68806pr0194dc7g5jlq/THUMBNAIL/e1bcda03-d631-4791-b321-4cee039768e8.jpg'),(56,'Windemere','Bed',300,'Best bed ',99,'https://bedarena.co.uk/602-large_default/windemere-double-bed.jpg'),(57,'Wooden Chair','Chair',200,'Best Wooden Chair',99,'https://static8.depositphotos.com/1022715/834/i/950/depositphotos_8346493-stock-photo-wooden-chair-over-white-with.jpg'),(58,'Blue Chair','Chair',400,'blue color chair ',100,'https://media.istockphoto.com/photos/turquoise-arm-chair-isolated-on-white-background-front-view-of-picture-id1199428736?k=20&m=1199428736&s=612x612&w=0&h=vRS-zg2d6tF7jqQ8lI3oYFs_JC3fXdPCZhkvlEhHJkc='),(59,'Sofa Chair','Chair',500,'sofa type chair ',99,'https://images.unsplash.com/photo-1598300042247-d088f8ab3a91?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8c29mYSUyMGNoYWlyfGVufDB8fDB8fA%3D%3D&w=1000&q=80'),(61,'Fabric sofa','Sofa',500,'sofa fabric type',98,'https://m.media-amazon.com/images/I/716j4-UMkKL._SL1100_.jpg'),(62,'Malic sofa','Sofa',600,'Malic sofa',100,'https://m.media-amazon.com/images/I/51fmRXrbhbL._SX425_.jpg'),(63,'wooden sofa','Sofa',400,'wooden type sofa',100,'https://images.woodenstreet.de/image/data%2Fwooden-sofa%2Fmarriott-wooden-sofa%2Frevised%2Frevised-looks%2Fhoney%2Ffront-3s.jpg'),(64,'Dinner table','Dinner table',500,'best simple dinner table',100,'https://m.media-amazon.com/images/I/910Em9myCQL._SL1500_.jpg'),(65,'Glass table','Dinner table',600,'best simple glass dinner table',100,'https://5.imimg.com/data5/SH/BQ/TO/SELLER-11706930/img-20170321-wa0040-500x500.jpg'),(66,'Five seater ','Dinner table',700,'best five seater dinner table',99,'https://5.imimg.com/data5/MC/SW/UB/SELLER-87445875/dinner-table-500x500.jpg');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales_log`
--

DROP TABLE IF EXISTS `sales_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales_log` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `product_name` varchar(45) NOT NULL,
  `product_price` int NOT NULL,
  `quantity` int NOT NULL,
  `date` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales_log`
--

LOCK TABLES `sales_log` WRITE;
/*!40000 ALTER TABLE `sales_log` DISABLE KEYS */;
INSERT INTO `sales_log` VALUES (26,'snehal','blue chair',380,1,'16/7/2022-08:40:22'),(27,'gaurav','king-Queen',480,1,'29/7/2022-02:40:22');
/*!40000 ALTER TABLE `sales_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'deepanshu','admin','123'),(3,'ritesh','admin','12345');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wishlist`
--

DROP TABLE IF EXISTS `wishlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wishlist` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `product_price` float NOT NULL,
  `quantity` int NOT NULL,
  `total_amt` float NOT NULL,
  `username` varchar(45) NOT NULL,
  `img_url` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wishlist`
--

LOCK TABLES `wishlist` WRITE;
/*!40000 ALTER TABLE `wishlist` DISABLE KEYS */;
INSERT INTO `wishlist` VALUES (10,'white sofa',1,4999,4979,'admin','https://www.ulcdn.net/images/products/309981/original/FNSF52WCNW3_-_main_1.png?1606711207');
/*!40000 ALTER TABLE `wishlist` ENABLE KEYS */;
UNLOCK TABLES;


CREATE TABLE IF NOT EXISTS `discount`
(
    `id` VARCHAR(255) NOT NULL,
    `status` BIGINT(20),
    CONSTRAINT `discount_pkey` PRIMARY KEY (`id`)
)
ENGINE=InnoDB
AUTO_INCREMENT = 1;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-26 22:42:50
