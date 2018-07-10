<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Data_obat extends CI_Controller {
	function __construct(){
		parent::__construct();
		$this->load->model('Dataobat_model');
		$this->load->model('Kategori_model');
		$this -> model = $this -> Dataobat_model;
		$this -> load -> database();
		$this -> load -> helper('url');
	}

	public function index()
	{

		$data = array(
			'data_obat' => $this-> Dataobat_model ->get_dataobat(),
		);
		$this->load->view('Datamaster/Data_obat', $data);
	}
	function tambah_obat(){
		$data = array(
			'data_kategori' => $this-> Kategori_model ->get_kategori(),
		);
		$this->load->view('Datamaster/tambah_obat', $data);
	}
	public function create (){
		if(isset($_POST['btnSubmit'])){
        	$config = array('upload_path' => './assets/web/base/images/',
        					'allowed_types' => 'gif|jpg|png'
        					);
        	$this -> load -> library ('upload',$config);
        	if ($this->upload->do_upload('img'))
    		{
        		$upload_data = $this -> upload -> data ();
        		$nm_barang = $this -> input -> post ('nm_barang');
        		$kd_kategori = $this -> input -> post ('kd_kategori');
        		$this-> Kategori_model ->get_kategori();
        		$komposisi = $this -> input -> post ('komposisi');
        		$indikasi = $this -> input -> post ('indikasi');
        		$dosis = $this -> input -> post ('dosis');
        		$penyajian = $this -> input -> post ('penyajian');
        		$kemasan = $this -> input -> post ('kemasan');
        		$harga = $this -> input -> post ('harga');
        		$deskripsi = $this -> input -> post ('deskripsi');
        		$stok = $this -> input -> post ('stok');
        		$foto = "assets/web/base/images/".$upload_data['file_name'];
				$data = array(
				'kd_user_admin' => $this->session->userdata('kd_user_admin'),
				'nm_barang' => $nm_barang,
				'kd_kategori' => $kd_kategori,
				'komposisi' => $komposisi,
				'indikasi' => $indikasi,
				'dosis' => $dosis,
				'penyajian' => $penyajian,
				'kemasan' => $kemasan,
				'harga' => $harga,
				'deskripsi' => $deskripsi,
				'stok' => $stok,
				'img' => $foto
				);
				$insert_data = $this->db->insert('tbl_barang',$data);
			if ($insert_data) {
				redirect(base_url().'index.php/Data_obat');
			 } else{
				echo "string";
			 }
		}else{
			echo "string1";
		}
    }
	}
	public function edit($id){
		$row = $this -> Dataobat_model -> get_by_id($id);
		$this -> load -> library('encrypt');
		if($row){
			$data = array(
				'data_kategori' => $this-> Kategori_model ->get_kategori(),
				'kd_barang' => $row -> kd_barang,
				'nm_barang' => $row -> nm_barang,
				'kd_kategori' => $row -> kd_kategori,
				'komposisi' => $row -> komposisi,
				'indikasi' => $row -> indikasi,
				'dosis' => $row -> dosis,
				'penyajian' => $row -> penyajian,
				'kemasan' => $row -> kemasan,
				'harga' => $row -> harga,
				'deskripsi' => $row -> deskripsi,
				'stok' => $row -> stok,
				'img' => $row -> img,
			);
			$this -> load -> view('Datamaster/Edit_obat',$data);
		}
		else{
			redirect(base_url().'Data_obat');
		}
	}
	public function editaction(){
		$config = array('upload_path' => './assets/web/base/images/',
        					'allowed_types' => 'gif|jpg|png'
        					);
        $this -> load -> library ('upload',$config);
        $nm_barang = $this -> input -> post('nm_barang');
        $kd_kategori = $this -> input -> post('kd_kategori');
        $this-> Kategori_model ->get_kategori();
        $komposisi = $this -> input -> post('komposisi');
        $indikasi = $this -> input -> post('indikasi');
        $dosis = $this -> input -> post('dosis');
        $penyajian = $this -> input -> post('penyajian');
        $kemasan = $this -> input -> post('kemasan');
        $harga = $this -> input -> post('harga');
        $deskripsi = $this -> input -> post('deskripsi');
        $stok = $this -> input -> post('stok');
        if($_FILES['img']['tmp_name']!=NULL){
        	if($this -> upload -> do_upload('img')){
        		$upload_data = $this -> upload -> data();
        		$row = $this -> Dataobat_model -> get_by_id($this -> input -> post('id'));
        		unlink($row -> img);
        		$data = array(
        			'nm_barang' => $nm_barang,
        			'kd_kategori' => $kd_kategori,
        			'komposisi' => $komposisi,
        			'indikasi' => $indikasi,
        			'dosis' => $dosis,
        			'penyajian' => $penyajian,
        			'kemasan' => $kemasan,
        			'harga' => $harga,
        			'deskripsi' => $deskripsi,
        			'stok' => $stok,
        			'img' => "assets/web/base/images/".$upload_data['file_name'],
        		);
        		$res = $this -> Dataobat_model -> update ($this -> input -> post('id'),$data);
        		if ($res >= 0) {
        			header('location:'.base_url().'index.php/Data_obat');
        		}
        	}
        }else{
        	$data = array(
        			'nm_barang' => $nm_barang,
        			'kd_kategori' => $kd_kategori,
        			'komposisi' => $komposisi,
        			'indikasi' => $indikasi,
        			'dosis' => $dosis,
        			'penyajian' => $penyajian,
        			'kemasan' => $kemasan,
        			'harga' => $harga,
        			'deskripsi' => $deskripsi,
        			'stok' => $stok,
        			
        		);
        		$res = $this -> Dataobat_model -> update ($this -> input -> post('id'),$data);
        		if ($res >= 0 ) {
        			header('location:'.base_url().'index.php/Data_obat');
        		}
        }
	}
	public function hapus($id){
		$res = $this -> Dataobat_model -> delete($id);
		if($res){
		header('location:'.base_url('index.php/Data_obat'));
		}
		else{
			header('location:'.base_url('index.php/Data_obat'));
		}
	}
	public function search(){
			$data2['cari'] = $this->Dataobat_model->get_product_keyword();
			$this->load->view('Datamaster/result', $data2);
	}
}

