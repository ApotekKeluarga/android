<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class TipsController extends CI_Controller {

	function __construct(){
		parent::__construct();
		$this->load->model('Tips_kesehatan');
		$this -> model = $this -> Tips_kesehatan;
		$this -> load -> database();
		$this -> load -> helper('url');
	}

	public function index()
	{
		$data = array(
			'data_tips' => $this-> Tips_kesehatan ->get_tips(),
		);
		$this->load->view('Tips_kesehatan/Tips', $data);
	}

	function tambah_tips(){
		$this->load->view('Tips_kesehatan/Tambah_tips');
	}
   	public function create(){
        if(isset($_POST['btnSubmit'])){
        	$config = array('upload_path' => './assets/web/base/images/',
        					'allowed_types' => 'gif|jpg|png'
        					);
        	$this -> load -> library ('upload',$config);
        	if ($this->upload->do_upload('img'))
    		{
        		$upload_data = $this -> upload -> data ();
        		$judul = $this -> input -> post ('judul');
        		$isi = $this -> input -> post ('isi');
        		$foto = "assets/web/base/images/".$upload_data['file_name'];
				$data = array(
				'kd_user_admin' => $this->session->userdata('kd_user_admin'),
				'judul' => $judul,
				'isi' => $isi,
				'img' => $foto
				);
				$insert_data = $this->db->insert('tbl_tips',$data);
			}
			if ($insert_data) {
				redirect(base_url().'index.php/TipsController');
			 } else{
				echo "string";
			 }
		}else{
			echo "string1";
		}
    }
	public function edit($id){
		$row = $this -> Tips_kesehatan -> get_by_id($id);
		$this -> load -> library('encrypt');
		if($row){
			$data = array(
				'kd_tips' => $row -> kd_tips,
				'judul' => $row -> judul,
				'isi' => $row -> isi,
				'img' => $row -> img,
			);
			$this -> load -> view('Tips_kesehatan/Edit_tips',$data);
		}
		else{
			redirect(base_url().'TipsController');
		}
	}
	public function editaction(){
		$config = array('upload_path' => './assets/web/base/images/',
        					'allowed_types' => 'gif|jpg|png'
        					);
        $this -> load -> library ('upload',$config);
        $judul = $this -> input -> post('judul');
        $isi = $this -> input -> post('isi');
        if($_FILES['img']['tmp_name']!=NULL){
        	if($this -> upload -> do_upload('img')){
        		$upload_data = $this -> upload -> data();
        		$row = $this -> Tips_kesehatan -> get_by_id($this -> input -> post('id'));
        		unlink($row -> img);
        		$data = array(
        			'judul' => $judul,
        			'isi' => $isi,
        			'img' => "assets/web/base/images/".$upload_data['file_name'],
        		);
        		$res = $this -> Tips_kesehatan -> update ($this -> input -> post('id'),$data);
        		if ($res >= 0) {
        			header('location:'.base_url().'index.php/TipsController');
        		}
        	}
        }else{
        	$data = array(
        			'judul' => $judul,
        			'isi' => $isi,
        		);
        		$res = $this -> Tips_kesehatan -> update ($this -> input -> post('id'),$data);
        		if ($res >= 0 ) {
        			header('location:'.base_url('index.php/TipsController'));
        		}
        }
	}
	public function hapus($id){
		$res = $this -> Tips_kesehatan -> delete($id);
		if($res){
		header('location:'.base_url('index.php/TipsController'));
		}
		else{
			header('location:'.base_url('index.php/TipsController'));
		}
	}
}