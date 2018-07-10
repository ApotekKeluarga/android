<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Kategori extends CI_Controller {
	function __construct(){
		parent::__construct();
		$this->load->model('Kategori_model');
	}

	public function index()
	{
		$data = array(
			'kategori' => $this-> Kategori_model ->get_kategori(),
		);
		$this->load->view('Datamaster/Kategori', $data);
	}
	function tambah_kategori(){
		$this->load->view('Datamaster/Tambah_kategori');
	}
	public function create(){
        if(isset($_POST['btnSubmit'])){
        		$nm_kategori = $this -> input -> post ('nm_kategori');
				$data = array(
				'kd_kategori' => "",
				'kd_user_admin' => $this->session->userdata('kd_user_admin'),
				'nm_kategori' => $nm_kategori
				);
				$insert_data = $this->db->insert('kategori',$data);
			if ($insert_data) {
				redirect(base_url().'index.php/Kategori');
			 } else{
				echo "string";
			 }
		}else{
			echo "string1";
		}
    }
    public function edit($id){
		$row = $this -> Kategori_model -> get_by_id($id);
		if($row){
			$data = array(
				'kd_kategori' => $row -> kd_kategori,
				'nm_kategori' => $row -> nm_kategori,
			);
			$this -> load -> view('Datamaster/Edit_kategori',$data);
		}
		else{
			redirect(base_url().'Kategori');
		}
	}
	public function editaction(){
        $nm_kategori = $this -> input -> post('nm_kategori');
        	$data = array(
        			'nm_kategori' => $nm_kategori
        		);
        		$res = $this -> Kategori_model -> update ($this -> input -> post('id'),$data);
        		if ($res >= 0 ) {
        			header('location:'.base_url('index.php/Kategori'));
        		}
	}
	public function hapus($id){
		$res = $this -> Kategori_model -> delete($id);
		if($res){
		header('location:'.base_url('index.php/Kategori'));
		}
		else{
			echo "";
			header('location:'.base_url('index.php/Kategori'));
		}
	}

}
