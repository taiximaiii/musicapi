-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: musicdb
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `album`
--

DROP TABLE IF EXISTS `album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `album` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `image_url` varchar(255) DEFAULT NULL,
  `release_date` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `artist_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmwc4fyyxb6tfi0qba26gcf8s1` (`artist_id`),
  CONSTRAINT `FKmwc4fyyxb6tfi0qba26gcf8s1` FOREIGN KEY (`artist_id`) REFERENCES `artist` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `album`
--

LOCK TABLES `album` WRITE;
/*!40000 ALTER TABLE `album` DISABLE KEYS */;
INSERT INTO `album` VALUES (1,'https://storage.googleapis.com/music-app-83261.appspot.com/img_album/6769a985-c061-47e4-95fd-aaaa313b94f3-skytour.jpg','12/06/2020','Sky Tour',1);
/*!40000 ALTER TABLE `album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artist`
--

DROP TABLE IF EXISTS `artist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artist` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `image_url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artist`
--

LOCK TABLES `artist` WRITE;
/*!40000 ALTER TABLE `artist` DISABLE KEYS */;
INSERT INTO `artist` VALUES (1,'https://storage.googleapis.com/music-app-83261.appspot.com/img_artist/5d0b2632-00e0-47c1-b10b-7f272574372f-mtp.jpg','Sơn Tùng M-TP'),(2,'https://storage.googleapis.com/music-app-83261.appspot.com/img_artist/a3ddbb88-f229-4627-b580-7bb681809d44-phanmanhquynh.jpg','Phan Mạnh Quỳnh'),(3,'https://storage.googleapis.com/music-app-83261.appspot.com/img_artist/ef66cc05-59ae-4c5d-bd18-670366f21ac2-noo.jpg','Noo Phước Thịnh'),(4,'https://storage.googleapis.com/music-app-83261.appspot.com/img_artist/e14b6fce-dd3d-4fef-b4dc-6ee73217386a-ducphuc.jpg','Đức Phúc'),(5,'https://storage.googleapis.com/music-app-83261.appspot.com/img_artist/c60d6e8e-6c80-419b-a45b-52f003a78f86-mck.jpg','MCK'),(6,'https://storage.googleapis.com/music-app-83261.appspot.com/img_artist/c1aeaa53-252e-4ede-91d3-f0aa334afe5a-hoangdung.jpg','Hoàng Dũng'),(7,'https://storage.googleapis.com/music-app-83261.appspot.com/img_artist/8ac5a1f2-b407-4792-acbf-edcf513f2ec8-huongtram.jpg','Hương Tràm'),(8,'https://storage.googleapis.com/music-app-83261.appspot.com/img_artist/c6d9deec-0c80-46d3-8119-f308488f238b-ngotband.jpg','Ngọt Band'),(9,'https://storage.googleapis.com/music-app-83261.appspot.com/img_artist/8eba82af-f6db-457a-8b41-6567b9b02d80-hoquanhieu.jpg','Hồ Quang Hiếu');
/*!40000 ALTER TABLE `artist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `timestamp` datetime(6) DEFAULT NULL,
  `track_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgvmrwo2ndvaej7ihhllxgemr2` (`track_id`),
  KEY `FK8kcum44fvpupyw6f5baccx25c` (`user_id`),
  CONSTRAINT `FK8kcum44fvpupyw6f5baccx25c` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKgvmrwo2ndvaej7ihhllxgemr2` FOREIGN KEY (`track_id`) REFERENCES `track` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playlist`
--

DROP TABLE IF EXISTS `playlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `playlist` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlbi6wsq41356go2ki0yirfixo` (`user_id`),
  CONSTRAINT `FKlbi6wsq41356go2ki0yirfixo` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlist`
--

LOCK TABLES `playlist` WRITE;
/*!40000 ALTER TABLE `playlist` DISABLE KEYS */;
/*!40000 ALTER TABLE `playlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `track`
--

DROP TABLE IF EXISTS `track`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `track` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `duration` varchar(255) DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `mp3url` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `album_id` bigint DEFAULT NULL,
  `artist_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKaxm9pbgk7ptorfyk3o6911q05` (`album_id`),
  KEY `FKi28jadqiuqk1dlxtl0me7hqh2` (`artist_id`),
  CONSTRAINT `FKaxm9pbgk7ptorfyk3o6911q05` FOREIGN KEY (`album_id`) REFERENCES `album` (`id`),
  CONSTRAINT `FKi28jadqiuqk1dlxtl0me7hqh2` FOREIGN KEY (`artist_id`) REFERENCES `artist` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `track`
--

LOCK TABLES `track` WRITE;
/*!40000 ALTER TABLE `track` DISABLE KEYS */;
INSERT INTO `track` VALUES (1,'271000','Pop','https://storage.googleapis.com/music-app-83261.appspot.com/img_track/f2d7e4c0-3749-4420-9757-3dedb9da0605-img1.jpg','https://storage.googleapis.com/music-app-83261.appspot.com/mp3/981174b7-e6d8-4b06-af63-851eeacd82fe-HayTraoChoAnh-SonTungMTPSnoopDogg-6010660.mp3','Hãy trao cho anh',1,1),(2,'271000','Pop','https://storage.googleapis.com/music-app-83261.appspot.com/img_track/0bcf498d-16f3-46d0-8594-142093c6610e-img1.jpg','https://storage.googleapis.com/music-app-83261.appspot.com/mp3/69e3436e-2e94-459d-9c36-3d150c47a6c5-BinhYenNhungPhutGiay-SonTungMTP-4915711.mp3','Bình yên những phút giây',NULL,1),(3,'271000','Pop','https://storage.googleapis.com/music-app-83261.appspot.com/img_track/1e7ed559-a1b6-4309-850b-796575797418-img1.jpg','https://storage.googleapis.com/music-app-83261.appspot.com/mp3/ac82d258-203b-4c6a-877a-4c6a50b349ff-ChungTaKhongThuocVeNhau-SonTungMTP-4528181.mp3','Chúng ta không thuộc về nhau',1,1),(4,'271000','Nhạc trẻ','https://storage.googleapis.com/music-app-83261.appspot.com/img_track/908a7d4e-382e-4846-b5c8-a3f7ec865c6a-causeily.jpg','https://storage.googleapis.com/music-app-83261.appspot.com/mp3/c4c0f013-e7bc-4de3-83d8-eaa22b76a746-CauseILoveYou-NooPhuocThinh-6400289.mp3','Cause I Love You',NULL,3),(6,'271000','Nhạc trẻ','https://storage.googleapis.com/music-app-83261.appspot.com/img_track/7c1e22d3-c72e-4331-8e91-30aef58fb863-chamkhetimanh.jpg','https://storage.googleapis.com/music-app-83261.appspot.com/mp3/9092dce2-81d0-43d8-b2cc-f355e4977f1b-ChamKheTimAnhMotChutThoi-NooPhuocThinh-5219031.mp3','Chạm khẽ tim anh một chút thôi',NULL,3),(7,'271000','Nhạc trẻ','https://storage.googleapis.com/music-app-83261.appspot.com/img_track/c5a5011b-02d0-423a-a4b4-dd500cefa68f-nhuphutbandau.jpg','https://storage.googleapis.com/music-app-83261.appspot.com/mp3/af35cacb-19ac-43d1-837a-1261e366760e-NhuPhutBanDau-NooPhuocThinh-6458668.mp3','Như phút ban đầu',NULL,3),(8,'271000','Nhạc trẻ','https://storage.googleapis.com/music-app-83261.appspot.com/img_track/d259f536-3bab-423a-a443-68e5ee674823-matbiec.jpg','https://storage.googleapis.com/music-app-83261.appspot.com/mp3/4ec6df79-cf78-40f5-80c2-c73670cc2d89-CoChangTraiVietLenCayMatBiecOst-PhanManhQuynh-6181112.mp3','Có chàng trai viết lên cây',NULL,2),(9,'271000','Nhạc trẻ','https://storage.googleapis.com/music-app-83261.appspot.com/img_track/95be04c0-12e9-4186-9468-3c0248c2c131-matbiec.jpg','https://storage.googleapis.com/music-app-83261.appspot.com/mp3/5ab07f0e-bb56-41aa-a3e4-65d91cfce199-TuDoMatBiecOst-PhanManhQuynh-6182376.mp3','Từ đó',NULL,2),(10,'271000','Nhạc trẻ','https://storage.googleapis.com/music-app-83261.appspot.com/img_track/14c9be92-35cf-4c4b-a02c-f13e78b2c4b6-vonguoita.jpg','https://storage.googleapis.com/music-app-83261.appspot.com/mp3/abdb6b1a-2351-40e7-b382-09c94b1d10d8-VoNguoiTa-PhanManhQuynh-4109355.mp3','Vợ người ta',NULL,2),(11,'271000','Nhạc trẻ','https://storage.googleapis.com/music-app-83261.appspot.com/img_track/4fb1b21a-b934-45d5-848e-ca917e5b60ea-yesido.jpg','https://storage.googleapis.com/music-app-83261.appspot.com/mp3/0ef87f41-84be-4721-bba5-f233388fb792-EmDongYIDo-DucPhucx911-9034315.mp3','Yes I do',NULL,4);
/*!40000 ALTER TABLE `track` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `birth_day` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,'tai1234@gmail.com','Trần Công Tài','$2a$10$q.vSYhuWTyTAnGXD9ZLVvu5tsocGFQE6e20Q46DjeJdNhjHRAl2By','16/08/2002','https://storage.googleapis.com/music-app-83261.appspot.com/img_user/61008579-79db-4012-9579-941fbf3cc83b-avt.jpg'),(3,'tai12345@gmail.com','Trần Công Tài','$2a$10$jsQSYYc92D9aMUwHZMprleOTIKfSeNFI0FUdEybORVIhvYMbt9nUS','16/08/2002','https://storage.googleapis.com/music-app-83261.appspot.com/img_user/1b1e1db9-08e3-4bc9-966c-6a45154b299f-halee.jpg'),(4,'tai@1234.com','Tai','$2a$10$GmAzntdizqt.SF7WQ8XhCOiO4lGCLs4ReANIn.v6ke0XqcZmr492.','16/08/2000',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-09 15:53:36
