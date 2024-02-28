-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: thuethunhapcanhan
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `dailythue`
--

DROP TABLE IF EXISTS `dailythue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dailythue` (
  `id` varchar(255) NOT NULL,
  `ten` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dailythue`
--

LOCK TABLES `dailythue` WRITE;
/*!40000 ALTER TABLE `dailythue` DISABLE KEYS */;
INSERT INTO `dailythue` VALUES ('2301016906','ST TAX');
/*!40000 ALTER TABLE `dailythue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (7);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `masothue`
--

DROP TABLE IF EXISTS `masothue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `masothue` (
  `id` varchar(255) NOT NULL,
  `cccd` varchar(255) NOT NULL,
  `ho_ten` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `masothue`
--

LOCK TABLES `masothue` WRITE;
/*!40000 ALTER TABLE `masothue` DISABLE KEYS */;
INSERT INTO `masothue` VALUES ('123','292414832415','Đinh Mạnh Cường'),('456','174382976452','Nguyễn Trường Giang'),('789','854372195943','Trần Duy Hưng');
/*!40000 ALTER TABLE `masothue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nguoidung`
--

DROP TABLE IF EXISTS `nguoidung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nguoidung` (
  `id` bigint NOT NULL,
  `cccd` varchar(255) NOT NULL,
  `co_quan_thue` varchar(255) DEFAULT NULL,
  `dia_chi` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `ho_ten` varchar(255) NOT NULL,
  `ma_so_thue` varchar(255) DEFAULT NULL,
  `mat_khau` varchar(255) NOT NULL,
  `sdt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nguoidung`
--

LOCK TABLES `nguoidung` WRITE;
/*!40000 ALTER TABLE `nguoidung` DISABLE KEYS */;
INSERT INTO `nguoidung` VALUES (1,'292414832415','Hà Nội','Hà Tây','cuongdinh@gmail.com','Đinh Mạnh Cường','123','$2a$04$uMZubF9EaZqruDYB/C/iyeqNhwABfuooiJ0CNGdgNmFUmHvVOsqxa','0431354251'),(6,'854372195943','Hồ Chí Minh','Cà Mau','hungtran@gmail.com','Trần Duy Hưng','789','$2a$04$pfTh0XU.fSGrqCucshkaO.gaz5KZ87GcyTYncgMMmZ9YUTSQRWS3m','0328424254');
/*!40000 ALTER TABLE `nguoidung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tokhaithue`
--

DROP TABLE IF EXISTS `tokhaithue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tokhaithue` (
  `id` bigint NOT NULL,
  `chi_tieu20` bigint NOT NULL,
  `chi_tieu21` bigint NOT NULL,
  `chi_tieu22` bigint NOT NULL,
  `chi_tieu23` bigint NOT NULL,
  `chi_tieu24` bigint NOT NULL,
  `chi_tieu25` bigint NOT NULL,
  `chi_tieu26` bigint NOT NULL,
  `chi_tieu27` bigint NOT NULL,
  `chi_tieu28` bigint NOT NULL,
  `chi_tieu29` bigint NOT NULL,
  `chi_tieu30` bigint NOT NULL,
  `chi_tieu31` bigint NOT NULL,
  `chi_tieu32` bigint NOT NULL,
  `cu_tru` bit(1) NOT NULL,
  `dai_ly_thue` bit(1) NOT NULL,
  `dia_chi` varchar(255) DEFAULT NULL,
  `dia_chidlt` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `emaildlt` varchar(255) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `faxdlt` varchar(255) DEFAULT NULL,
  `ho_ten` varchar(255) DEFAULT NULL,
  `ky_tinh_thue` varchar(255) DEFAULT NULL,
  `loai_to_khai` varchar(255) DEFAULT NULL,
  `ma_so_thue` varchar(255) DEFAULT NULL,
  `ma_so_thuedlt` varchar(255) DEFAULT NULL,
  `nam_ke_khai` int NOT NULL,
  `ngay_hop_dong` varchar(255) DEFAULT NULL,
  `ngay_nop` date DEFAULT NULL,
  `quan_huyen` varchar(255) DEFAULT NULL,
  `quan_huyendlt` varchar(255) DEFAULT NULL,
  `quy_ke_khai` int NOT NULL,
  `sdt` varchar(255) DEFAULT NULL,
  `sdtdlt` varchar(255) DEFAULT NULL,
  `so_hop_dong` varchar(255) DEFAULT NULL,
  `ten_dai_ly_thue` varchar(255) DEFAULT NULL,
  `thang_ke_khai` int NOT NULL,
  `tinh_thanh` varchar(255) DEFAULT NULL,
  `tinh_thanhdlt` varchar(255) DEFAULT NULL,
  `nguoi_dung_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKm1svymdgtoufoh83qh67osrmp` (`nguoi_dung_id`),
  CONSTRAINT `FKm1svymdgtoufoh83qh67osrmp` FOREIGN KEY (`nguoi_dung_id`) REFERENCES `nguoidung` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tokhaithue`
--

LOCK TABLES `tokhaithue` WRITE;
/*!40000 ALTER TABLE `tokhaithue` DISABLE KEYS */;
INSERT INTO `tokhaithue` VALUES (2,134000000,0,11000000,11000000,0,0,0,0,123000000,33200000,0,20,0,_binary '',_binary '\0','Hà Tây',NULL,'cuongdinh@gmail.com',NULL,'',NULL,'Đinh Mạnh Cường','Tháng','Lần đầu','123',NULL,2022,NULL,'2022-04-26','Huyện Đan Phượng',NULL,1,'0431354251',NULL,NULL,NULL,4,'Hà Nội',NULL,1);
/*!40000 ALTER TABLE `tokhaithue` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-27 15:41:21
