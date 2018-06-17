-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 14, 2018 lúc 09:13 PM
-- Phiên bản máy phục vụ: 10.1.32-MariaDB
-- Phiên bản PHP: 5.6.36

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `tkxdpm`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `book`
--

CREATE TABLE `book` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  `publishing_company` varchar(45) DEFAULT NULL,
  `publishing_date` varchar(45) DEFAULT NULL,
  `ISBN` varchar(45) DEFAULT NULL,
  `total_quantity` int(11) DEFAULT NULL,
  `current_quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `book`
--

INSERT INTO `book` (`id`, `name`, `author`, `publishing_company`, `publishing_date`, `ISBN`, `total_quantity`, `current_quantity`) VALUES
('KN0001', 'Đắc nhân tâm', 'Dale carnegie', 'Nhà xuất bản TH Hồ Chí Minh', '2017', '786045739', 32, 31),
('KN0002', 'Nhà giả kim', 'Paulo Coelho', 'Nhà xuất bản văn học', '2015', '123567345', 25, 26),
('KN0003', 'Đời ngắn đừng ngủ dài', 'Robin sharma', 'Nhà xuất bản trẻ', '2017', '978694104', 15, 14),
('TS0001', 'Thân thế và sự nghiệp của Leopold Cardiere', 'Câu lạc bộ Paolo', 'Nhà xuất bản tri thức', '2011', '123563728', 20, 19),
('TS0002', 'Friedrich Hayek-Cuộc đời và sự nghiệp', 'Alan Ebenstein', 'Nhà xuất bản tri thức', '2007', '234567890', 30, 30),
('VN0001', 'Đời sống xã hội việt nam đương đại (tập 1)', 'Nhiều tác giả', 'Nhà xuất bản tri thức', '2013', '123456789', 20, 20),
('VN0002', 'Đời sống xã hội Việt Nam đương đại (tập 2)', 'Nhiều tác giả', 'Nhà xuất bản tri thức', '2013', '211345678', 15, 15);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `borrower`
--

CREATE TABLE `borrower` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `birthday` varchar(45) DEFAULT NULL,
  `sex` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `borrower`
--

INSERT INTO `borrower` (`id`, `name`, `birthday`, `sex`, `address`, `email`, `phone`, `username`, `password`, `status`) VALUES
(1, 'Lê Văn Sang', '20/05/2997', 'Nam', 'B5 Đại Học Bách Khoa Hà Nội', 'test', 'test', 'sanglv', '123', 'activeCard'),
(2, 'Nguyễn Xuân Quang', 'test', 'Nam', 'test', 'test', 'test', 'quangnx', '123', 'noActive'),
(3, 'Nguyễn Huy Quang', 'test', 'Nam', 'test', 'test', 'test', 'quangnh', '123', 'disable');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `card`
--

CREATE TABLE `card` (
  `id_card` int(11) NOT NULL,
  `expire_date` varchar(45) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `card`
--

INSERT INTO `card` (`id_card`, `expire_date`, `id_user`) VALUES
(1000, '7/2019', 1),
(1001, '7/2019', 2),
(1002, '7/2019', 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `copy`
--

CREATE TABLE `copy` (
  `id` varchar(45) NOT NULL,
  `id_book` varchar(45) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `copy`
--

INSERT INTO `copy` (`id`, `id_book`, `category`, `price`, `status`) VALUES
('KN0001.1', 'KN0001', 'sách kĩ năng', 40000, 'not available'),
('KN0002.1', 'KN0002', 'sách kĩ năng', 50000, 'available'),
('TS0001.1', 'TS0001', 'sách tiểu sử', 70000, 'available'),
('VN0001.1', 'VN0001', 'sách việt nam đương đại', 56000, 'available'),
('VN0002.1', 'VN0002', 'sách việt nam đương đại', 85000, 'available');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `librarian`
--

CREATE TABLE `librarian` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `birthday` varchar(45) DEFAULT NULL,
  `sex` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `librarian`
--

INSERT INTO `librarian` (`id`, `name`, `birthday`, `sex`, `address`, `email`, `phone`, `username`, `password`) VALUES
(2000, 'Nguyễn Thị Hà', '20/04/1990', 'Nữ', 'Hai Bà Trưng, Hà Nội', 'test', 'test', 'librarian', '123'),
(2001, 'Nguyễn Văn Cường', '19/3/1988', 'Nam', 'Hà Đông, Hà Nội', 'test', 'test', 'cuongnv', '123'),
(2002, 'Lê Văn Anh', '20/01/1991', 'Nam', 'Từ Liêm, Hà Nội', 'test', 'test', 'anhlv', '123');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orderbook_item`
--

CREATE TABLE `orderbook_item` (
  `id` int(11) NOT NULL,
  `id_order` int(11) DEFAULT NULL,
  `id_book` varchar(45) DEFAULT NULL,
  `date_order` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `id_copy` varchar(45) DEFAULT NULL,
  `date_return` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `orderbook_item`
--

INSERT INTO `orderbook_item` (`id`, `id_order`, `id_book`, `date_order`, `status`, `id_copy`, `date_return`) VALUES
(1, 4, 'KN0001', '20/05/2018', 'returned', 'KN0001.1', '20/05/2018'),
(2, 5, 'TS0001', '20/05/2018', 'returned', 'TS0001.1', '20/05/2018'),
(3, 6, 'VN0001', '05/05/2018', 'ordered', NULL, NULL),
(15, 7, 'KN0001', '20-05-2018', 'borrowed', 'KN0001.1', NULL),
(17, 7, 'KN0003', '16/05/2018', 'ordered', NULL, NULL),
(22, 9, 'KN0001', '20/05/2018', 'returned', 'KN0001.1', '20/05/2018'),
(23, 9, 'KN0002', '20/05/2018', 'returned', 'KN0002.1', '20/05/2018'),
(25, 9, 'TS0001', '16/05/2018', 'cancel', NULL, NULL),
(26, 10, 'KN0001', '19/05/2018', 'ordered', NULL, NULL),
(27, 10, 'KN0002', '19/05/2018', 'ordered', NULL, NULL),
(28, 7, 'KN0001', '15-06-2018', 'ordered', NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `order_book`
--

CREATE TABLE `order_book` (
  `id` int(11) NOT NULL,
  `id_borrower` int(11) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `deposits` int(11) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `order_book`
--

INSERT INTO `order_book` (`id`, `id_borrower`, `date`, `deposits`, `status`) VALUES
(4, 1, '20/05/2018', 0, 'complete'),
(5, 2, '20/05/2018', 0, 'complete'),
(6, 3, '15/05/2018', 0, 'ordering'),
(7, 1, '', 0, 'ordering'),
(8, 2, '20/05/2018', 0, 'complete'),
(9, 1, '20/05/2018', 2000, 'complete'),
(10, 1, '20/05/2018', 0, 'ordering'),
(11, 1, '20/05/2018', 0, 'complete');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `borrower`
--
ALTER TABLE `borrower`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `card`
--
ALTER TABLE `card`
  ADD PRIMARY KEY (`id_card`),
  ADD KEY `fk_borrower_idx` (`id_user`);

--
-- Chỉ mục cho bảng `copy`
--
ALTER TABLE `copy`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_book_idx` (`id_book`);

--
-- Chỉ mục cho bảng `librarian`
--
ALTER TABLE `librarian`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `orderbook_item`
--
ALTER TABLE `orderbook_item`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_order_idx` (`id_order`),
  ADD KEY `fk_copy_idx` (`id_copy`);

--
-- Chỉ mục cho bảng `order_book`
--
ALTER TABLE `order_book`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_borrower_idx` (`id_borrower`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `borrower`
--
ALTER TABLE `borrower`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `librarian`
--
ALTER TABLE `librarian`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2003;

--
-- AUTO_INCREMENT cho bảng `orderbook_item`
--
ALTER TABLE `orderbook_item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT cho bảng `order_book`
--
ALTER TABLE `order_book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `card`
--
ALTER TABLE `card`
  ADD CONSTRAINT `fk_borrower` FOREIGN KEY (`id_user`) REFERENCES `borrower` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Các ràng buộc cho bảng `copy`
--
ALTER TABLE `copy`
  ADD CONSTRAINT `fk_book` FOREIGN KEY (`id_book`) REFERENCES `book` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Các ràng buộc cho bảng `orderbook_item`
--
ALTER TABLE `orderbook_item`
  ADD CONSTRAINT `fk_copy` FOREIGN KEY (`id_copy`) REFERENCES `copy` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_order` FOREIGN KEY (`id_order`) REFERENCES `order_book` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Các ràng buộc cho bảng `order_book`
--
ALTER TABLE `order_book`
  ADD CONSTRAINT `fk_borrower1` FOREIGN KEY (`id_borrower`) REFERENCES `borrower` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
