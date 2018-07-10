-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 10 Jul 2018 pada 05.28
-- Versi Server: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `apotek_keluarga`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `kategori`
--

CREATE TABLE `kategori` (
  `kd_kategori` int(10) NOT NULL,
  `kd_user_admin` int(10) NOT NULL,
  `nm_kategori` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `kategori`
--

INSERT INTO `kategori` (`kd_kategori`, `kd_user_admin`, `nm_kategori`) VALUES
(11, 1, 'Obat Herbal'),
(12, 1, 'Suplemen'),
(13, 1, 'Antibiotik'),
(14, 1, 'Obat Anak'),
(15, 1, 'Alat Kesehatan');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_barang`
--

CREATE TABLE `tbl_barang` (
  `kd_barang` int(10) NOT NULL,
  `kd_user_admin` int(10) NOT NULL,
  `nm_barang` text NOT NULL,
  `kd_kategori` int(10) NOT NULL,
  `komposisi` text NOT NULL,
  `indikasi` text NOT NULL,
  `dosis` text NOT NULL,
  `penyajian` text NOT NULL,
  `kemasan` text NOT NULL,
  `harga` decimal(25,0) NOT NULL,
  `deskripsi` text NOT NULL,
  `stok` int(10) NOT NULL,
  `img` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_barang`
--

INSERT INTO `tbl_barang` (`kd_barang`, `kd_user_admin`, `nm_barang`, `kd_kategori`, `komposisi`, `indikasi`, `dosis`, `penyajian`, `kemasan`, `harga`, `deskripsi`, `stok`, `img`) VALUES
(31, 1, 'CURCUMA PLUS SHARPY ORANGE 60ML', 12, 'Tiap sendok teh (5ml) mengandung : Prebiotik 500 mg DHA 32 mg KURKUMINOID 2 mg Vitamin B1 3 mg Vitamin B2 2 mg Vitamin B6 5 mg Vitamin B12 5 mcg Beta Karoten 10% 4 mg Dekspantenol 3 mg', 'Sebagai suplemen bermanfaat untuk menambah nafsu makan, membantu perkembangan sel otak dan meningkatkan daya tahan tubuh.', 'Dewasa : 3 kali sehari 1 sendok teh Anak-anak : 6 â€“ 12 tahun : 2 kali sehari 1 sendok teh. 1- 6 tahun : 1 kali sehari 1 sendok teh. 6 bulan â€“ 1 tahun : 1 kali sehari 1/2 sendok teh.', ' Sebaiknya diberikan setelah makan ', '1 Botol ', '14969', ' Suplemen sirup yang dapat membantu menambah nafsu makan dan merangsang perkembangan otak, dengan rasa jeruk yang disukai anak-anak. \r\nBeli Curcuma Plus Sharpy Orange 60ML di apotek keluarga jember dan dapatkan manfaatnya.\r\n ', 496, 'assets/web/base/images/CURCUMA PLUS SHARPY ORANGE 60ML.png'),
(32, 1, 'GOOD LIFE GROW VIT CAP 30S BTL', 12, 'vitamin A, ÃŸ-Carotene, vitamin B1, vitamin B2, Nicotinamide, vitamin B6, vitamin B12, vitamin C, vitamin D, vitamin E, Calcium Pantothenate, Folic Acid, zat besi, fosfor, kalsium, magnesium, mangan, selenium, zinc.', 'Suplemen untuk pertumbuhan', '1 tablet perhari', ' Diberikan bersama makan ', '30 Tablet / Botol ', '120582', ' Good Life Grow Vit merupakan suplemen kombinasi antara multivitamin dan mineral yang dibutuhkan untuk pertumbuhan dan perkembangan tubuh remaja ', 500, 'assets/web/base/images/GOOD LIFE GROW VIT CAP 30S BTL.png'),
(34, 1, 'KOMIX HERBAL TUBE 4S', 11, 'Lagundi 200mg, Jahe merah 30mg, Thymi herba 100mg, Licorice 167mg, Peppermint oil 11mg, Madu 3000mg', 'Membantu meredakan batuk berdahak', 'Dewasa : 3 x sehari 1 sachet, Anak-anak : 1/2 dosis dewasa', ' Berikan sesudah makan ', '1 Pcs ', '8978', ' Sirup obat batuk yang terbuat dari kombinasi bahan alami, dikemas dalam bentuk tube yang praktis.  ', 498, 'assets/web/base/images/KOMIX HERBAL TUBE 4S.png'),
(35, 1, 'OB HERBAL 60ML', 11, 'Zingiberis Rhizoma 4.5; Kaempferiae Rhizoma 1.5 ; Citrus Aurantii fructus 1.5; Thymi Herba 1.5; Mentahae Folium 0.75; Myristicae Semen 0.75; Licorice 0.25', 'Membantu meredakan batuk karena masuk angin, mengencerkan dahak, dan membantu mengeluarkan dahak sehingga melegakan pernafasan.', 'Dewasa : 3 x sehari 1 sendok makan (15ml), anak-anak : 3 x sehari 1/2 sendok makan (7.5ml)', ' Berikan setelah makan ', 'simpan pada tempat sejuk dan kering, terhindar dari panas dan sinar matahari langsung', '12217', ' Obat batuk dari bahan alami yang dapat membantu meredakan batuk karena masuk angin, mengencerkan dahak, membantu mengeluarkan dahak, serta melegakan pernafasan. ', 500, 'assets/web/base/images/OB HERBAL 60ML.png'),
(36, 1, 'VEGETA HERBAL ANGGUR SACH', 11, 'Platago ovata, Senna dan Rei Radix, Foeniculli dan Liquirittiae', 'Membantu melancarkan buang air besar yang terlanjur macet dan membantu membuang racun dari dalam tubuh', '1 x sehari 1 bungkus sebelum tidur, dosis dapat ditingkatkan menjadi 2 x sehari apabila diperlukan', ' Berikan setelah makan ', '1 Pcs ', '2983', ' Kombinasi serat, laksatif alami, dan anti kembung dari tumbuh-tumbuhan alam yang berkhasiat melancarkan buang air besar yang sudah macet.\r\nBeli Vegeta Herbal Anggur Sach di apotek keluarga dan dapatkan manfaatnya.\r\n ', 500, 'assets/web/base/images/VEGETA HERBAL ANGGUR SACH.png'),
(37, 1, 'WOODS HERBAL PLUS HONEY SYRUP 60ML', 11, 'Tiap 5 ml sirup mengandung : Ekstrak daun ivy (hedera helix folii extract 35 mg, Ekstrak daun meniran (Phyllanthus niruri folii extract 25 mg, Ekstrak daun mint (Menthae piperitae folii extract 25 mg, Madu 3 g', 'Meredakan batuk berdahak', 'Anak 2 â€“ 5 tahun: 3 x sehari 2.5 ml, 6 â€“ 12 tahun: 3 x sehari 5 ml, Anak > 12 tahun & Dewasa: 3 x sehari 10 ml', '  Berikan setelah makan, kocok dahulu sebelum diminum  ', '1 Botol ', '16500', '  Sirup obat batuk herbal dengan rasa madu, membantu meredakan batuk dan melegakan pernafasan. \r\nBeli Woods Herbal Plus Honey Syrup 60ml di apotek online apotek keluarga dan dapatkan manfaatnya.\r\n  ', 500, 'assets/web/base/images/WOODS HERBAL PLUS HONEY SYRUP 60ML.png'),
(38, 1, 'TRIAMINIC BATUK SYR', 14, 'pseudoephedrine  15 mg, dextromethorpan HBr 5 mg', 'batuk kering dan pilek', '>12 th: 2 sendok takar 3 kali/hari, 6-12 th: 1 sendok takar 3 kali/hari', '   sesudah makan, \r\nPerhatian : gangguan jantung, diabetes, digunakan bersama obat MAOI (antidepresan)\r\n   ', '1 Botol ', '58846', '   batuk kering dan pilek   ', 487, 'assets/web/base/images/TRIAMINIC BATUK SYR.png'),
(39, 1, 'TRIAMINIC EXP SYR', 14, 'pseudoephedrine  15 mg, guaifenesin 50 mg', 'batuk dan pilek', '>12 th: 2 sendok takar 3 kali/hari, 6-12 th: 1 sendok takar 3 kali/hari, 2-5 th: 1/2 sendok takar 3 kali/hari', ' sesudah makan ', '1 Botol ', '60316', ' obat batuk berdahak dan pilek ', 500, 'assets/web/base/images/TRIAMINIC EXP SYR.png'),
(40, 1, 'SAKATONIK ABC ANGGUR BTL', 14, 'vit A, B Komplek, C, D, E, Nikotinamid, Kalsium Pantotenat', 'Memenuhi Kebutuhan vitamin pada anak-anak', '1 x sehari 1 tablet', ' dihisap atau dikunyah ', '1 Pcs ', '13965', ' tablet hisap multivitamin untuk anak-anak ', 500, 'assets/web/base/images/SAKATONIK ABC ANGGUR BTL.png'),
(41, 1, 'ALAT UKUR TENSI GEA TENSIMETER ANEROID MI-1001', 15, '-', 'Alat tensi', 'Sesuai kebutuhan', ' Untuk tensi ', '1 Pcs ', '121800', ' Alat tensi jarum, untuk membantu mengukur tekanan darah ', 498, 'assets/web/base/images/ALAT UKUR TENSI GEA TENSIMETER ANEROID MI-1001.png'),
(42, 1, 'OMRON TENSIMETER HEM 7120', 15, '-', 'alat pengukur tekanan darah digital', '-', '  -  ', '1 Pcs ', '482418', '  Tensimeter Digital Omron tipe HEM 7120 merupakan tensimeter digital yang berfungsi untuk mengecek tekanan darah tanpa harus memompa secara manual  ', 500, 'assets/web/base/images/OMRON TENSIMETER HEM 7120.png'),
(43, 1, 'MASKER HIJAU ELASTIS', 15, '-', 'masker penutup mulut dan hidung', '-', ' - ', '50 Pcs / Dos ', '76871', ' masker penutup mulut dan hidung ', 500, 'assets/web/base/images/MASKER HIJAU ELASTIS.png'),
(45, 1, 'CEREBROVIT GB TAB STR 10S', 12, 'Gingko biloba extract 40 mg, L-Glutamic Acid 200 mg, Thiamine HCL 5 mg, Riboflavin 2 mg, Pyridoxine HCl 2 mg, Cyanocobalamine 1,5 mcg, Niacinamide 5 mg, Ca-Pantothenate 2 mg, Ascorbic Acid 25 mg, Iron sebagai Ferrous Sulfate 5 mg, Copper sebagai copper Sulfate 100 mcg, Zinc sebagai Zinc Oxyde 100 mcg, Magnesium sebagai Magnesium Sulfate 3,5 mg, Calcium sebagai Calcium Carbonate 15 mg, Phosphorus sebagai Sodium Phosphat 10 mg, Iodine as Potassium Iodine 100 mcg, Cobalt sebagai Cobalt Chloride 100 mcg Manganese sebagai Mangan Chloride 500 mcg, Molybdenum sebagai Sodium Molybdate 100 mcg.', 'Pencegahan defisiensi vitamin, nutrisi otak, meningkatkan daya ingat', '1 x sehari 1 tablet', ' Berikan bersama dengan makanan ', '1 Strip ', '18232', ' Suplemen oral yang dapat membantu meningkatkan daya ingat meningkatkan aliran nutrisi ke otak ', 499, 'assets/web/base/images/CEREBROVIT GB TAB STR 10S.png'),
(46, 1, 'CDR FORTOS EFF 10S', 12, 'kalsium karbonat 1500mg, vitamin D 400IU', 'suplemen kalsium dan vitamin d untuk membantu mencegah dan mengatasi gejala osteoporosis', '1 tab effervescent per hari', '  dilarutkan dalam 1 gelas air minum  ', '1 Pcs ', '43213', '  suplemen kalsium untuk mencegah dan mengatasi gejala osteoporosis, Perhatian : hipersensitif terhadap komponen obat, Efek Samping : gangguan lambung  ', 500, 'assets/web/base/images/CDR FORTOS EFF 10S.png'),
(47, 1, 'ASAM MEFENAMAT BERNO 500MG', 13, 'asam mefenamat 500 mg', 'Meredakan nyeri ringan hingga sedang pada sakit kepala, sakit gigi, dismenore primer, juga nyeri traumatik, otot, dan pasca operasi', 'dewasa : awal 500 mg, dilanjutkan 250 mg/6 jam', ' segera sesudah makan ', '10 Tablet / Blister ', '413', ' merupakan kelompok anti inflamasi nonsteroid yang mempunyai efek analgesik, anti inflamasi dan antipiretik. ', 498, 'assets/web/base/images/ASAM MEFENAMAT BERNO 500MG.png'),
(48, 1, 'AMOXICILLIN IF 500MG', 13, 'amoxicillin 500 mg', 'untuk terapi infeksi gram positif dan negatif, seperti pada saluran nafas atas dan bawah, saluran kemih dan kelamin. Kulit & jaringan lunak, infeksi tulang, GO, abses gigi (terapi tambahan thd penanganan bedah/operasi)', 'dewasa dan anak =20 kg 250-500 mg tiap 8 jam.  Typhoid & paratyphoid dewasa 4g perhari dalam dosis terbagi selama 14-21 hari. Anak-anak 100 mg/kg berat badan/dahari dalam dosis terbagi selama14-21 hari. . infeksi saluran kencing tanpa komplikasi diberika...', ' dapat diberikan bersama makanan agar diabsorpsi lebik baik dan untuk mengurangi rasa tidak nyaman pada GI atau sesudah makan. ', '10 Tablet / Strip ', '515', ' Antibiotik ', 497, 'assets/web/base/images/AMOXICILLIN IF 500MG.png'),
(49, 1, 'FITKOM ANGGUR BTL', 14, 'vitamin a 1000IU, vitamin b1 1.4mg, vitamin b2 1.6 mg, vitamin b6 2 mg, vitamin b12 3 mcg, vitamin c 60 mg,  vitamin d3 100IU, vitamin e 5 mg, nicotinamid 9 mg, ca pantotenate 5 mg', 'memenuhi kebutuhan vitamin dan mineral pada anak usia pertumbuhan, membantu memelihara kesehatan anak, membantu memulihkan kondisi tubuh sehabis sakit', '3x sehari 1 tablet hisap', ' setelah makan ', '1 Pcs ', '17027', ' memenuhi kebutuhan vitamin dan mineral pada anak anak usia pertumbuhan dengan rasa anggur ', 500, 'assets/web/base/images/FITKOM_ANGGUR_BTL.png'),
(54, 1, 'KOMIX HERBAL TUBE 4S', 11, 'Lagundi 200mg, Jahe merah 30mg, Thymi herba 100mg, Licorice 167mg, Peppermint oil 11mg, Madu 3000mg', 'Membantu meredakan batuk berdahak', 'Dewasa : 3 x sehari 1 sachet, Anak-anak : 1/2 dosis dewasa', 'Berikan sesudah makan', '1 Pcs', '8978', 'Sirup obat batuk yang terbuat dari kombinasi bahan alami, dikemas dalam bentuk tube yang praktis.', 498, 'assets/web/base/images/KOMIX_HERBAL_TUBE_4S1.png');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_daftar_akun`
--

CREATE TABLE `tbl_daftar_akun` (
  `kd_user` int(10) NOT NULL,
  `Nm_Depan` varchar(25) NOT NULL,
  `Nm_Belakang` varchar(25) NOT NULL,
  `No_Telp` varchar(13) NOT NULL,
  `Tgl_Lahir` varchar(25) NOT NULL,
  `JK` varchar(10) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Pass` varchar(30) NOT NULL,
  `Ulangi_Pass` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_daftar_akun`
--

INSERT INTO `tbl_daftar_akun` (`kd_user`, `Nm_Depan`, `Nm_Belakang`, `No_Telp`, `Tgl_Lahir`, `JK`, `Email`, `Pass`, `Ulangi_Pass`) VALUES
(31, 'Rangga ', 'Akhir Aprian', '0895337396656', '1997-10-03', 'Laki-Laki', 'aprianrangga@gmail.com', 'aprianrangga', 'aprianrangga'),
(32, 'angga', 'dwi', 'aaaa', '2018-01-20', 'Perempuan', 'bbb@eee.com', 'aaaa', 'aaaa'),
(33, 'vyan ary', 'pratama', '00000000000', '2018-01-18', 'Laki-Laki', 'vyanary@gmail.com', 'vyan123', 'vyan123'),
(34, 'rangga', 'rangga', '567890dsa', '1999-12-23', 'Perempuan', 'rangga.aprian03@gmail.com', '123', '123'),
(52, 'Rangga', 'Akhir Aprian', '0895337396656', '1997-10-03', 'Laki-Laki', 'aprianrangga@gmail.com', 'aprianrangga', 'aprianrangga'),
(57, 'Rangga', 'Akhir Aprian', '0895337396656', '1997-10-03', 'Laki-Laki', 'aprianrangga@gmail.com', 'aprianrangga', 'aprianrangga'),
(60, 'yusup', 'alkaf', '08573', '20-06-2018', 'Laki-laki', 'yusupalkaff@gmail.com', 'yusup123', 'yusup123'),
(61, 'jabab', 'bababa', '9494949', '20-06-2018', 'Laki-laki', 'haha', 'jaja', 'haha'),
(62, 'gahahab', 'hahaha', '848484', '25-06-2018', 'Perempuan', 'vavaba', 'hababa', 'bababa'),
(63, '', '', '', '', 'Laki-laki', '', '', ''),
(64, 'ggffff', '', '', '', 'Laki-laki', '', '', ''),
(65, 'bahrul', 'arif', '085753497854', '05-06-1997', 'Laki-laki', 'bahrularif@gmail.com', 'wibu123', 'wibu123'),
(66, 'kajana', 'hahaha', '94979', '13-06-2018', 'Perempuan', 'nsnsn@gmail.com', 'jajaja', 'jajaja'),
(67, 'hahah', 'vababa', '8404045', '04-06-2018', 'Laki-laki', 'babanan', 'bababa', 'bababa'),
(68, 'Sukma', 'Adi', '08727970', '06-06-1997', 'Laki-laki', 'sukmadi@gmail.com', 'adi123', 'adi123'),
(69, 'ardhan', 'firmansyah', '0787575424243', '26-06-2018', 'Laki-laki', 'ardhan@gmail.com', 'ardhan', 'ardhan'),
(70, 'ardhan', 'firmansyah', '0787575424243', '26-06-2018', 'Laki-laki', 'ardhan@gmail.com', 'ardhan', 'ardhan'),
(71, 'khaff', 'durrohman', '085', '', 'Laki-laki', 'aaa', '123', '123');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_dtlorder`
--

CREATE TABLE `tbl_dtlorder` (
  `kd_order` int(10) NOT NULL,
  `kd_barang` int(10) NOT NULL,
  `quantity` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_dtlorder`
--

INSERT INTO `tbl_dtlorder` (`kd_order`, `kd_barang`, `quantity`) VALUES
(29, 31, 1),
(31, 38, 5),
(32, 48, 1),
(35, 34, 1),
(43, 47, 1),
(44, 38, 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_kirim_resep`
--

CREATE TABLE `tbl_kirim_resep` (
  `kd_kirim_resep` int(10) NOT NULL,
  `kd_user` int(10) NOT NULL,
  `kd_order` int(10) NOT NULL,
  `harga_obat` decimal(25,0) NOT NULL,
  `status_obat` text NOT NULL,
  `status_pesanan` text NOT NULL,
  `keterangan` text NOT NULL,
  `img` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_kirim_resep`
--

INSERT INTO `tbl_kirim_resep` (`kd_kirim_resep`, `kd_user`, `kd_order`, `harga_obat`, `status_obat`, `status_pesanan`, `keterangan`, `img`) VALUES
(24, 31, 0, '100000', 'Tidak tersedia', 'Dipesan', '', 'TRIAMINIC BATUK SYR.png'),
(32, 31, 0, '0', 'Tidak tersedia', 'Dibatalkan', '', 'c7068b6c44.png'),
(33, 31, 30, '65800', 'Tersedia', 'Dipesan', '', 'IMG-20180111-WA0027.jpg'),
(34, 32, 0, '65000', 'Tersedia', 'Dibatalkan', '', 'TRIAMINIC BATUK SYR.png'),
(35, 31, 33, '90000', 'Tersedia', 'Dipesan', '', 'TRIAMINIC BATUK SYR.png'),
(36, 31, 34, '100000', 'Tersedia', 'Dipesan', '', 'TRIAMINIC BATUK SYR.png'),
(37, 31, 0, '80000', 'Tersedia', 'Dipesan', '', 'TRIAMINIC BATUK SYR.png'),
(38, 31, 35, '80000', 'Tersedia', 'Dipesan', '', 'TRIAMINIC BATUK SYR.png'),
(39, 34, 36, '70000', 'Tersedia', 'Dipesan', '', 'TRIAMINIC BATUK SYR.png'),
(40, 31, 0, '5000', 'Tersedia', 'Dibatalkan', '', 'obat-obatan.jpg'),
(41, 31, 39, '50000', 'Tersedia', 'Dipesan', '', 'obat.jpg'),
(42, 31, 40, '1000', 'Tersedia', 'Dipesan', 'amu', 'medical-28_icon-icons.com_73924.png'),
(43, 31, 41, '50000', 'Tersedia', 'Dipesan', 'digunakan sehari 3x setelah makan.', 'obat.jpg'),
(44, 33, 0, '0', 'Tidak tersedia', 'Dibatalkan', '', 'comingsoon1.png'),
(45, 31, 0, '10000', 'Tersedia', 'Dipesan', 'hghgh', '0f0c293f35c447337ef99732f40b037b_w.jpeg'),
(46, 31, 0, '45000', 'Tersedia', 'Dipesan', 'dd', '512-05-512.png'),
(47, 31, 0, '0', '', '', '', '5f783ba7c861b479a9ae74357d2b5ce6_w.jpeg');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_news`
--

CREATE TABLE `tbl_news` (
  `kd_news` int(10) NOT NULL,
  `kd_user_admin` int(10) NOT NULL,
  `judul` text NOT NULL,
  `img` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_news`
--

INSERT INTO `tbl_news` (`kd_news`, `kd_user_admin`, `judul`, `img`) VALUES
(11, 1, 'Gaya Hidup Sehat Mencegah Diabetes', 'news3.jpg'),
(14, 1, 'Perilaku Hidup Sehat', 'news1.jpg'),
(15, 1, 'Gaya Hidup Sehat', 'news2.jpg');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_order`
--

CREATE TABLE `tbl_order` (
  `kd_order` int(10) NOT NULL,
  `kd_user` int(10) NOT NULL,
  `nama` text NOT NULL,
  `No_telp` varchar(20) NOT NULL,
  `Tgl_order` date NOT NULL,
  `Detail_alamat` text NOT NULL,
  `mtd_pengirman` text NOT NULL,
  `mtd_pembayaran` text NOT NULL,
  `status` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_order`
--

INSERT INTO `tbl_order` (`kd_order`, `kd_user`, `nama`, `No_telp`, `Tgl_order`, `Detail_alamat`, `mtd_pengirman`, `mtd_pembayaran`, `status`) VALUES
(13, 31, 'kakakakaka', '97865218', '2018-01-05', 'dguadhu', 'Siap Layanan Antar', 'Bayar Di Tempat', 'Dikirim'),
(29, 31, 'vyan', '1110191', '2018-01-06', 'Banyuwangi', 'Siap Layanan Antar', 'Bayar Di Tempat', 'Dikirim'),
(30, 31, 'vyanary', '9090909', '2018-01-26', 'jember', 'Siap Layanan Antar', 'Bayar Di Tempat', 'Dikirim'),
(31, 31, 'Rangga Akhir Aprian', '2147483647', '2018-01-12', 'Perum. Puri Bunga Nirwana, Cluster Bintaro, Blok K11B, Kec. Sumbersari, Kab. Jember, Jawa Timur', 'Siap Layanan Antar', 'Bayar Di Tempat', 'Dikirim'),
(32, 31, '', '0', '2018-01-01', '', '', '', 'Dikirim'),
(33, 31, 'haris', '86531627', '2018-01-18', 'jember', 'Siap Layanan Antar', 'Bayar Di Tempat', 'Dikirim'),
(34, 31, 'pak khafid', '9261884', '2018-01-18', 'jember', 'Siap Layanan Antar', 'Bayar Di Tempat', 'Dikirim'),
(35, 31, 'nova', '8727351', '2018-01-18', 'jember', 'Siap Layanan Antar', 'Bayar Di Tempat', 'Dikirim'),
(36, 34, 'rais', '2147483647', '2018-01-18', 'jember', 'Siap Layanan Antar', 'Bayar Di Tempat', 'Dikirim'),
(37, 31, 'mbak fida', '1291281782', '2018-01-18', 'semeru', 'Siap Layanan Antar', 'Bayar Di Tempat', 'Dikirim'),
(38, 31, 'toni', '812345678', '2018-01-18', 'jl. ke hatimu', 'Siap Layanan Antar', 'Bayar Di Tempat', 'Dikirim'),
(39, 31, 'Apris', '2147483647', '2018-01-24', 'Tuban', 'Siap Layanan Antar', 'Bayar Di Tempat', 'Dikirim'),
(40, 31, 'c', '1', '2018-01-24', 'sdsa', 'Siap Layanan Antar', 'Bayar Di Tempat', 'Dikirim'),
(41, 31, 'Nurnani', '986523413', '2018-01-25', 'puri indah', 'Siap Layanan Antar', 'Bayar Di Tempat', 'Dikirim'),
(42, 31, 'jsadjasd', '08652116271', '2018-01-18', 'asdadadasda', 'Siap Layanan Antar', 'Bayar Di Tempat', 'Dikirim'),
(43, 31, '', '', '2018-04-20', '', 'Siap Layanan Antar', 'Bayar Di Tempat', 'Sedang Diproses'),
(44, 31, 'fffg', '08865', '2018-05-11', 'hkh', 'Siap Layanan Antar', 'Bayar Di Tempat', 'Sedang Diproses');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_slideshow`
--

CREATE TABLE `tbl_slideshow` (
  `kd_slideshow` int(10) NOT NULL,
  `kd_user_admin` int(10) NOT NULL,
  `img` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_slideshow`
--

INSERT INTO `tbl_slideshow` (`kd_slideshow`, `kd_user_admin`, `img`) VALUES
(16, 1, 'Banner1.jpeg'),
(17, 1, 'Banner2.jpeg'),
(18, 1, 'Banner3.jpeg'),
(19, 1, 'fix4.png');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_tips`
--

CREATE TABLE `tbl_tips` (
  `kd_tips` int(10) NOT NULL,
  `kd_user_admin` int(10) NOT NULL,
  `judul` text NOT NULL,
  `isi` text NOT NULL,
  `img` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_tips`
--

INSERT INTO `tbl_tips` (`kd_tips`, `kd_user_admin`, `judul`, `isi`, `img`) VALUES
(41, 1, ' <h2 class="text-uppercase">Benarkah Banyak Minum Saat Sakit Bisa Membuat Cepat Sembuh?</h2>', ' <p>\r\n                <strong>DokterSehat.Com</strong>â€“ Jika kita mencermati, cukup banyak orang yang menyarankan orang yang sedang dalam kondisi jatuh sakit untuk memperbanyak asupan air minum. Banyak minum air putih disebut-sebut bisa membuat tubuh lebih cepat sembuh. Sebenarnya, apakah memang banyak minum memang bisa mempercepat proses penyembuhan penyakit?\r\n                </p>  \r\n                <p> Jurnal kesehatan berjudul BMJ Case Reports melaporkan sebuah kasus yang berkaitan dengan anjuran banyak minum bagi orang yang sakit ini. Dalam laporan ini, terdapat seseorang yang akhirnya dilarikan ke Instalasi Gawat Darurat di Royal London Hospital gara-gara menuruti anjuran untuk banyak minum air saat sedang menderita infeksi saluran kemih. Pasien ini mengalami gejala seperti tubuh yang menggigil, mual-mual, muntah, dan sulit berbicara. Setelah diperiksa, ternyata pasien ini mengalami kondisi yang disebut sebagai hyponatremia atau penurunan kadar natrium dalam darah denga nsignifikan yang disebabkan oleh terlalu banyak minum air. </p>\r\n                <p> Sebenarnya, tujuan dari menyarankan penderita infeksi saluran kemih ini untuk banyak minum sangatlah baik, yakni membuat proses pembuangan racun dengan cara buang air kecil bisa lebih sering terjadi. Sayangnya, hal ini membuat kadar natrium dalam tubuhnya turun drastis hingga hanya 123 mmol/L, jauh lebih rendah dari kadar natrium yang normal yakni 135-145 mmol/L. Pasien ini pun akhirnya dibatasi asupan air minumnya dan kondisi kesehatannya kemudian semakin membaik.\r\n                <br>\r\n                Banyak minum memang baik untuk kesehatan. Namun, jika kita terlalu banyak minum, hal ini juga akan memberikan kerugian tersendiri karena akan membuat ginjal bekerja dengan lebih keras. Melihat adanya fakta ini, ada baiknya memang kita mengkonsumsi air minum dengan cukup saja agar tubuh tetap terhidrasi dengan baik sehingga semua sistem di dalamnya bisa bekerja dengan maksimal. Selain itu, rutinlah minum obat dan banyak beristirahat agar tubuh lebih cepat sembuh.\r\n                </p> ', 'sds.jpg'),
(42, 1, '<h2 class="text-uppercase">Ini Alasan Mengapa Wanita Lebih Rentan Terkena Diabetes Dibandingkan Pria</h2>', '<p><strong>DokterSehat.Com</strong>â€“ Di tahun 2017 ini, diperkirakan ada 10,3 juta orang di Indonesia yang mengidap diabetes. Angka ini bahkan disebut-sebut akan meningkat hingga 16,7 juta jiwa pada tahun 2045 mendatang. Melihat tingginya jumlah penderita diabetesdi Indonesia, ada baiknya memang kita mewaspadai kedatangan penyakit mematikan ini.</p> \r\n\r\n                    <p>Pakar kesehatan dr. Roy Panusunan Sibarani, SpPD-KEMD, Sp. Endokrin menyebutkan bahwa diabetes ternyata adalah penyebab kematian pada kaum wanita paling tinggi kesembilan di seluruh dunia. Bahkan, angka kematian wanita di seluruh dunia gara-gara penyakit ini mencapai 2,1 juta jiwa per tahun. Diabetes memang cenderung lebih rentan menyerang wanita daripada pria meskipun pria cenderung lebih malas dalam menerapkan gaya hidup sehat. Lantas, apa penyebab wanita lebih beresiko terkena penyakit ini?</p>\r\n                    <p>Dr. Roy menyebutkan bahwa wanita, khususnya yang sedang hamil, memang lebih rentan untuk terkena diabetes karena kecenderungan untuk tidak banyak bergerak jika dibandingkan dengan kaum pria. Pria sendiri memang dikenal sebagai orang yang cenderung suka melakukan kegiatan fisik. Yang menjadi masalah adalah, kecenderungan untuk tidak banyak bergerak ini membuat tubuh tidak banyak menghabiskan karbohidrat atau glukosa untuk aktifitas fisik. Hal ini bisa memicu datangnya penyakit metabolic seperti hipertensi, kolesterol tinggi, atau bahkan diabetes.<br>\r\n                    Saat wanita sedang hamil misalnya, ada sebuah zat di dalam tubuhnya yang disebut sebagai AMPK yang tidak bekerja dengan baik sehingga akan memicu resistensi insulin dan akhirnya menyebabkan diabetes gestasional, diabetes yang muncul hanya di fase kehamilan saja.\r\n                    Mengingat kaum pria tidak mengalami kehamilan, maka zat AMPK akan tetap mengontrol kinerja insulin dengan lebih baik sehingga asalkan mereka menerapkan gaya hidup yang sehat, maka resiko untuk terkena diabetes juga lebih kecil dari wanita.\r\n                    </p>', 'asss.jpg'),
(43, 1, '<h2 class="text-uppercase">Ciri-Ciri Kolesterol Tinggi dan Asam Urat</h2>', '<p><strong>DokterSehat.Com</strong>â€“ Ada banyak sekali ciri-ciri dari masalah kolesterol tinggi dan asam urat. Kedua masalah kesehatan tersebut cukup mudah ditemukan pada masyarakat tanah air. Penderita asam urat biasanya juga mengalami masalah kolesterol tinggi mengingat penyebab dari kedua masalah kesehatan ini sama, yakni pola makan yang tidak sehat. Sebenarnya, apa sajakah ciri-ciri dari masalah kolesteroltinggi dan asam urat?</p> \r\n\r\n                <p><strong>Merasakan pegal-pegal, kesemutan, dan sakit kepala</strong><br>\r\n                Gejala dari masalah kolesterol yang akan dirasakan adalah munculnya pegal-pegal atau sensasi yang berat pada tengkuk dan pundak. Mereka yang mengalami masalah kolesterol tinggi juga akan cenderung lebih mudah mengalami sakit kepala, mudah lelah, dan mudah mengantuk. Hal ini ternyata disebabkan oleh semakin menurunnya asupan oksigen menuju ke otak karena menumpuknya plak di dalam pembuluh darah yang menghambat aliran darah. Selain itu, mereka dengan masalah kolesterol tinggi juga akan cenderung mudah untuk terkena masalah kesemutan.\r\n                </p><br>\r\n                <p><strong>Mudah merasa lelah</strong><br>\r\n                Selain itu, orang dengan kadar kolesterol tinggi biasanya akan merasa mudah lelah walaupun tidak sedang melakukan aktifitas berat. Penghambatan aliran juga dapat terjadi pada aliran darah menuju otak sehingga membuat penderitanya pusing, susah berkonsentrasi, mudah mengantuk, dan terkadang merasa bingung.\r\n                </p><br>\r\n                <p><strong>Kerap mengalami masalah nyeri pada persendian</strong><br>\r\n                Gejala masalah asam urat dan kolesterol yang paling sering muncul adalah rasa nyeri atau ngilu pada persendian yang kemudian disertai dengan pembengkakan dan warna kemerahan. Selain itu, saat bangun tidur, penderita masalah asam urat dan kolesterol juga cenderung mudah terkena kesemutan berulang-ulang kali. Jika kadar asam urat di dalam tubuh semakin tinggi, maka rasa nyeri dan pembengkakan juga akan menjadi semakin parah sehingga penderitanya akan semakin kesulitan untuk bergerak</p><br>\r\n                <p><strong>Jantung berdebar-debar</strong><br>Banyaknya tumpukan kolesterol pada pembuluh darah oleh plak-plak yang menebal dan mengeras akan membuat jantung semakin bekerja keras dalam memompa aliran darah ke seluruh jaringan/ organ tubuh. Hal ini akan menimbulkan gejala jantung berdebar-debar lebih cepat dan keras yang menandakan organ ini bekerja ekstra dibandingkan normal. Jika berlangsung terus-menerus maka dapat berakibat kelelahan/ kepayahan pada jantung yang sering disebut sebagai gagal jantung.</p><br>\r\n                <p><strong>Kadar kolesterol tinggi yang sudah jauh melebihi batas normal</strong><br>\r\n                Pakar kesehatan menyebutkan bahwa kadar kolesterol yang normal pada tubuh orang dewasa adalah sekitar 160 hingga 200 miligram per desiliter darah. Bagi mereka yang memiliki kadar kolesterol lebih dari 240 miligram per desiliter darah, maka bisa dipastikan bahwa mereka sedang mengalami masalah kolesterol tinggi.\r\n                </p><br>', 'sddas.jpg'),
(44, 1, '<h2 class="text-uppercase">Ini Yang Akan Terjadi Pada Tubuh, Saat Kamu Berhenti Minum Kopi</h2>', '<p>Apotek Keluarga.com - Hy Guyss, siapa sih yang tak kenal dengan minuman yang satu ini. Kopi dikenal sebagai salah satu minuman yang bisa menambah energi kita. Ini karena kopi mengandung kafein. Kafein sendiri dipercaya memiliki beberapa pengaruh baik untuk tubuh jika dikonsumsi dengan takaran yang pas. Namun sebaliknya, kafein pada kopi juga bisa berubah menjadi sangat berbahaya jika ia dikonsumsi secara berlebihan.</p>      \r\n              <p>Nah, bagi yang sudah terbiasa minum kopi lalu ingin berhenti, tubuh jelas akan mengalami beberapa perubahan. Berikut ini adalah apa yang akan terjadi pada tubuh saat kamu memutuskan untuk lepas dari kebiasaan ini Guys.</p> \r\n              <h5>\r\n                <li>Jika seseorang memutuskan berhenti minum kopi, hal ini akan membuat orang tersebut merasa lelah, capek dan tidak bersemangat. Inilah hal pertama yang akan dirasakan.</li>\r\n                <li>Selanjutnya, kamu akan punya kualitas tidur yang lebih baik Ladies. Kamu memang akan jadi lebih lemas, namun kualitas tidur akan lebih meningkat.</li>\r\n                <li>Tahukah kamu bahwa penelitian mengungkapkan bahwa kafein adalah salah satu pemicu munculnya perasaan cemas dan stres dalam diri. Berhenti minum kopi akan membuatmu merasa jauh lebih tenang dan bebas dari stres.</li>\r\n                <li>Berhenti minum kopi juga akan membuatmu memiliki sistem pencernaan yang sehat dan jauh dari masalah mual. Beberapa study menyebutkan bahwa berhenti minum kopi akan membuat sistem pencernaan bekerja lebih baik dan lebih cepat.</li>\r\n              </h5>\r\n              <p>Sekali lagi kopi memang punya manfaat untuk tubuh, namun kamu sangat disarankan untuk tidak mengonsumsinya secara berlebihan apalagi sampai kecanduan Ladies. Semoga informasi ini bermanfaat ya.\r\n            </p>', 'aaa.jpg'),
(45, 1, '<h2 class="text-uppercase">Antara Tahu dan Tempe, Mana yang Lebih Bergizi?</h2>', '<p>Tahu dan tempe sudah menyatu dengan kuliner Indonesia. Tahu dan tempe juga dikonsumsi oleh berbagai golongan masyarakat karena merupakan sumber protein nabati yang baik dan juga harganya yang terjangkau.Kedua makanan olahan ini memiliki bahan baku yang sama, yakni kacang kedelai. Akan tetapi, proses produksinya menghasilkan produk akhir yang berbeda. Apakah ada perbedaan kandungan gizi antara tahu dan tempe? Simak ulasan di bawah ini.</p> \r\n                      <h3>Tahu</h3>\r\n                      <p>Produk pangan dari susu kedelai yang dipadatkan ini memiliki rasa yang lebih tawar, lembut, dan mampu menyerap cita rasa dari bumbu lain. Tahu memiliki tekstur yang berbeda-beda, tergantung proses pembuatan dan kandungan airnya. Ada yang sangat lunak dan cukup keras.</p>\r\n                      <h3>Tempe</h3>\r\n                      <p>Tempe memiliki bau dan rasa khas kedelai yang lebih kuat dibandingkan tahu. Selain itu, tekstur kedelai akan masih terlihat dengan jelas pada tempe.Tahu dan tempe berbeda karena proses pembuatannya. Tempe dibuat dengan cara fermentasi, bukan dipadatkan. Kacang kedelai yang sudah dimasak akan difermentasi dengan bantuan jamur Rhizopus oligosporus. Setelah difermentasikan, kedelai tersebut baru akan ditekan ke dalam cetakan tempe..</p>\r\n                      <h3>Tahu dan tempe, mana yang lebih sehat?</h3>\r\n                      <p>Tahu mengandung lebih banyak mineral yang berasal dari senyawa koagulan (yang bisa membuat sari kedelai jadi padat). Sementara itu, tempe memiliki lebih banyak kandungan vitamin yang berasal dari hasil fermentasi.<br>Secara kandungan gizi, tempe lebih padat nutrisi dibandingkan tahu. Tempe memiliki kalori yang lebih tinggi, dengan kandungan karbohidrat, protein, dan lemak yang lebih tinggi dibandingkan tahu. Tempe juga memiliki serat yang jauh lebih tinggi dibandingkan tahu.<br>Kacang kedelai, yaitu bahan baku tahu dan tempe memiliki senyawa antinutrien, salah satunya asam fitat. Antinutrien adalah senyawa yang dapat menghambat penyerapan zat gizi tertentu dalam tubuh. Nah, senyawa ini tidak dapat dihilangkan melalui proses koagulasi (pemadatan). Itulah mengapa tahu memiliki kandungan antinutrien yang lebih banyak dibandingkan tempe yang sudah difermentasi. Dengan kata lain, zat gizi yang terkandung dalam tempe akan lebih efektif diserap oleh tubuh dibandingkan tahu.<br>Selain itu, tempe dan tahu mengandung senyawa isoflavone. Isoflavone diperkirakan memiliki berbagai manfaat kesehatan, salah satunya untuk menangkal kanker. Tempe memiliki kandungan isoflavone yang lebih tinggi dibandingkan tahu.<br>\r\n\r\n                    Walaupun fermentasi dapat menurunkan kandungan isoflavone yang terkandung di dalam tempe, penyerapan isoflavone pada tempe umumnya masih lebih tinggi dibandingkan tahu. Senyawa isoflavone yang terkandung pada tahu sebesar 4-67 mg/100 gram. Sementara pada tempe sebesar 103 mg/100 gram. Diperkirakan sebesar 30 sampai 50 mg konsumsi senyawa isoflavone setiap hari cukup untuk memberikan manfaat kesehatan.</p>\r\n                    <h3>Tempe memang lebih bernutrisi, tapiâ€¦</h3>\r\n                    <p>Tempe lebih padat akan zat gizi dibandingkan tahu. Proses fermentasi tempe akan menambah kandungan gizi serta menghilangkan senyawa yang menghambat penyerapan gizi. Akan tetapi, lebih rendahnya nilai kalori dan zat gizi pada tahu berarti tahu dapat dikonsumsi dalam jumlah yang lebih banyak dibandingkan tempe untuk mencapai nilai nutrisi yang sama.<br>\r\n\r\n                    Penting dicatat, nilai gizi yang terkandung dalam tahu dan tempe masih bisa berbeda-beda juga, tergantung jenis, proses pembuatan, dan cara memasaknya. Bila Anda memasak tempe yang kaya nutrisi dengan cara digoreng dan ditambahkan banyak garam, tetap saja makanan sehat ini akan jadi berisiko buat kesehatan jantung dan pembuluh darah.<br>\r\n\r\n                    Karena itu, bukan berarti Anda hanya disarankan makan tempe saja. Bila Anda sedang mencoba menurunkan berat badan atau membatasi asupan kalori, tahu bisa jadi pilihan yang lebih baik dari tempe. Pastikan juga Anda mengolah tahu dan tempe dengan cara yang sehat. </p>', 'fff.jpg'),
(46, 1, '<h2 class="text-uppercase">Flu pada anak</h2>', '<p>Influenza adalah infeksi akut yang disebabkan oleh salah satu dari tiga jenis virus influenza (A, B, atau C). Strain tipe A merupakan bentuk penyakit influenza yang paling parah. Banyak orang bingung membedakan influenza dengan ISPA. Influenza dan ISPA berbeda. ISPA dapat disebabkan berbagai virus yang menginfeksi sistem pernapasan bagian atas (hidung, mulut, dan tenggorokan).<br> Flu disebabkan oleh virus influenza dan sering lebih parah dan lebih berbahaya dari ISPA, terutama untuk anak-anak di bawah usia 5 tahun. Beberapa anak meninggal akibat flu setiap tahun.\r\n                </p> \r\n                <p>Selain itu, virus yang menyebabkan flu berbeda dengan yang menyebabkan gastroenteritis (sering disebut sebagai â€œflu perutâ€), yang memiliki gejala seperti mual, muntah, dan diare.</p>\r\n                <p>Influenza biasanya menyebar secara lokal dari orang ke orang selama musim flu. Hal ini disebut sebagai <strong>epidemi flu</strong>. Karena ada sangat sedikit kekebalan yang sudah ada sebelumnya, kadang-kadang strain yang sangat berbeda muncul dan menyebar dengan cepat di seluruh dunia. <br>Hal ini dikenal sebagai pandemi flu. Misalnya, pada tahun 2009, Strain tipe baru yang disebut H1N1 muncul. Karena hanya ada sedikit kekebalan pada populasi manusia untuk strain H1N1, strain flu ini memiliki kemampuan untuk menyebar dengan mudah dari orang ke orang di seluruh dunia dan orang dapat dengan mudah jatuh sakit bahkan lebih banyak daripada flu musiman biasa. Pada bulan Juli 2009, pandemi H1N1 di seluruh dunia dinyatakan, namun pandemi ini selesai pada bualan Agustus 2010.\r\n                </p><br>', 'flu.jpg');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_troli`
--

CREATE TABLE `tbl_troli` (
  `kd_troli` int(10) NOT NULL,
  `kd_barang` int(25) NOT NULL,
  `kd_user` int(10) NOT NULL,
  `qty` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_user_admin`
--

CREATE TABLE `tbl_user_admin` (
  `kd_user_admin` int(10) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_user_admin`
--

INSERT INTO `tbl_user_admin` (`kd_user_admin`, `Email`, `Password`) VALUES
(1, 'adminapotekkeluarga@gmail.com', 'admin123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`kd_kategori`),
  ADD KEY `kd_user_admin` (`kd_user_admin`);

--
-- Indexes for table `tbl_barang`
--
ALTER TABLE `tbl_barang`
  ADD PRIMARY KEY (`kd_barang`),
  ADD KEY `kd_kategori` (`kd_kategori`),
  ADD KEY `kd_user_admin` (`kd_user_admin`);

--
-- Indexes for table `tbl_daftar_akun`
--
ALTER TABLE `tbl_daftar_akun`
  ADD PRIMARY KEY (`kd_user`);

--
-- Indexes for table `tbl_dtlorder`
--
ALTER TABLE `tbl_dtlorder`
  ADD KEY `kd_barang` (`kd_barang`),
  ADD KEY `kd_order` (`kd_order`);

--
-- Indexes for table `tbl_kirim_resep`
--
ALTER TABLE `tbl_kirim_resep`
  ADD PRIMARY KEY (`kd_kirim_resep`),
  ADD KEY `kd_user` (`kd_user`),
  ADD KEY `kd_kirim_resep` (`kd_kirim_resep`),
  ADD KEY `kd_order` (`kd_order`);

--
-- Indexes for table `tbl_news`
--
ALTER TABLE `tbl_news`
  ADD PRIMARY KEY (`kd_news`),
  ADD KEY `kd_user_admin` (`kd_user_admin`);

--
-- Indexes for table `tbl_order`
--
ALTER TABLE `tbl_order`
  ADD PRIMARY KEY (`kd_order`),
  ADD KEY `kd_user` (`kd_user`);

--
-- Indexes for table `tbl_slideshow`
--
ALTER TABLE `tbl_slideshow`
  ADD PRIMARY KEY (`kd_slideshow`),
  ADD KEY `kd_user_admin` (`kd_user_admin`);

--
-- Indexes for table `tbl_tips`
--
ALTER TABLE `tbl_tips`
  ADD PRIMARY KEY (`kd_tips`),
  ADD KEY `kd_user` (`kd_user_admin`);

--
-- Indexes for table `tbl_troli`
--
ALTER TABLE `tbl_troli`
  ADD PRIMARY KEY (`kd_troli`),
  ADD KEY `kd_barang` (`kd_barang`),
  ADD KEY `kd_user` (`kd_user`);

--
-- Indexes for table `tbl_user_admin`
--
ALTER TABLE `tbl_user_admin`
  ADD PRIMARY KEY (`kd_user_admin`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `kategori`
--
ALTER TABLE `kategori`
  MODIFY `kd_kategori` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `tbl_barang`
--
ALTER TABLE `tbl_barang`
  MODIFY `kd_barang` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;
--
-- AUTO_INCREMENT for table `tbl_daftar_akun`
--
ALTER TABLE `tbl_daftar_akun`
  MODIFY `kd_user` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=72;
--
-- AUTO_INCREMENT for table `tbl_kirim_resep`
--
ALTER TABLE `tbl_kirim_resep`
  MODIFY `kd_kirim_resep` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;
--
-- AUTO_INCREMENT for table `tbl_news`
--
ALTER TABLE `tbl_news`
  MODIFY `kd_news` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `tbl_order`
--
ALTER TABLE `tbl_order`
  MODIFY `kd_order` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;
--
-- AUTO_INCREMENT for table `tbl_slideshow`
--
ALTER TABLE `tbl_slideshow`
  MODIFY `kd_slideshow` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT for table `tbl_tips`
--
ALTER TABLE `tbl_tips`
  MODIFY `kd_tips` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;
--
-- AUTO_INCREMENT for table `tbl_troli`
--
ALTER TABLE `tbl_troli`
  MODIFY `kd_troli` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_user_admin`
--
ALTER TABLE `tbl_user_admin`
  MODIFY `kd_user_admin` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `kategori`
--
ALTER TABLE `kategori`
  ADD CONSTRAINT `kategori_ibfk_1` FOREIGN KEY (`kd_user_admin`) REFERENCES `tbl_user_admin` (`kd_user_admin`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `tbl_barang`
--
ALTER TABLE `tbl_barang`
  ADD CONSTRAINT `tbl_barang_ibfk_1` FOREIGN KEY (`kd_kategori`) REFERENCES `kategori` (`kd_kategori`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_barang_ibfk_2` FOREIGN KEY (`kd_user_admin`) REFERENCES `tbl_user_admin` (`kd_user_admin`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `tbl_dtlorder`
--
ALTER TABLE `tbl_dtlorder`
  ADD CONSTRAINT `tbl_dtlorder_ibfk_1` FOREIGN KEY (`kd_barang`) REFERENCES `tbl_barang` (`kd_barang`) ON DELETE CASCADE,
  ADD CONSTRAINT `tbl_dtlorder_ibfk_2` FOREIGN KEY (`kd_order`) REFERENCES `tbl_order` (`kd_order`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `tbl_kirim_resep`
--
ALTER TABLE `tbl_kirim_resep`
  ADD CONSTRAINT `tbl_kirim_resep_ibfk_1` FOREIGN KEY (`kd_user`) REFERENCES `tbl_daftar_akun` (`kd_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `tbl_news`
--
ALTER TABLE `tbl_news`
  ADD CONSTRAINT `tbl_news_ibfk_1` FOREIGN KEY (`kd_user_admin`) REFERENCES `tbl_user_admin` (`kd_user_admin`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `tbl_order`
--
ALTER TABLE `tbl_order`
  ADD CONSTRAINT `tbl_order_ibfk_1` FOREIGN KEY (`kd_user`) REFERENCES `tbl_daftar_akun` (`kd_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `tbl_slideshow`
--
ALTER TABLE `tbl_slideshow`
  ADD CONSTRAINT `tbl_slideshow_ibfk_1` FOREIGN KEY (`kd_user_admin`) REFERENCES `tbl_user_admin` (`kd_user_admin`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `tbl_tips`
--
ALTER TABLE `tbl_tips`
  ADD CONSTRAINT `tbl_tips_ibfk_1` FOREIGN KEY (`kd_user_admin`) REFERENCES `tbl_user_admin` (`kd_user_admin`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `tbl_troli`
--
ALTER TABLE `tbl_troli`
  ADD CONSTRAINT `tbl_troli_ibfk_1` FOREIGN KEY (`kd_barang`) REFERENCES `tbl_barang` (`kd_barang`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
