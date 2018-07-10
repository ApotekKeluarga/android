<?php
defined('BASEPATH') OR exit('No direct script access allowed');
class Pesanan extends CI_Controller {
function __construct(){
		parent ::__construct();
		$this -> load -> model ('Pesanan_model');
	}
	public function index()
	{
		$data = array('data_pesanan'=> $this -> Pesanan_model -> get_pesan(),);
		$this->load->view('Pesan/Pesanan',$data);
	}

	function tambah_pesanan(){
		$this->load->view('Pesanan/Tambah_pesanan');
	}
	function detailPesanan($id){
	$row = $this -> Pesanan_model -> get_by_id($id);
	$this -> load -> library('encrypt');
		if($row){
			$data = array(
				'kd_order' => $row -> kd_order,
				'nama' => $row -> nama,
				'No_telp' => $row -> No_telp,
				'Tgl_order' => $row -> Tgl_order,
				'Detail_alamat' => $row -> Detail_alamat,
				'mtd_pengirman' => $row -> mtd_pengirman,
				'mtd_pembayaran' => $row -> mtd_pembayaran,
			);
			$this -> load -> view('Pesan/Detail',$data);
		}
		else{
			redirect(base_url().'Pesanan');
		}
	}
}
