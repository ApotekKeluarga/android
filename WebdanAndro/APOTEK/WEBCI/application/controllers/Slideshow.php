<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Slideshow extends CI_Controller {


	function __construct(){
		parent::__construct();
		$this->load->model('Slideshow_model');
	}

	public function index()
	{
		$data = array(
			'data_slideshow' => $this-> Slideshow_model ->get_slideshow(),
		);
		$this->load->view('Slide/Slideshow', $data);
	}
	function tambah_slideshow(){
		$this->load->view('Slide/Tambah_slideshow');
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
        		$foto = "assets/web/base/images/".$upload_data['file_name'];
				$data = array(
				'kd_user_admin' => $this->session->userdata('kd_user_admin'),
				'img' => $foto
				);
				$insert_data = $this->db->insert('tbl_slideshow',$data);
			}
			if ($insert_data) {
				redirect(base_url().'index.php/Slideshow');
			 } else{
				echo "string";
			 }
		}else{
			echo "string1";
		}
    }
    public function edit($id){
		$row = $this -> Slideshow_model -> get_by_id($id);
		$this -> load -> library('encrypt');
		if($row){
			$data = array(
				'kd_slideshow' => $row -> kd_slideshow,
				'img' => $row -> img,
			);
			$this -> load -> view('Slide/Edit_slideshow',$data);
		}
		else{
			redirect(base_url().'Slideshow');
		}
	}
	public function editaction(){
		$config = array('upload_path' => './assets/web/base/images/',
        					'allowed_types' => 'gif|jpg|png'
        					);
        $this -> load -> library ('upload',$config);
        if($_FILES['img']['tmp_name']!=NULL){
        	if($this -> upload -> do_upload('img')){
        		$upload_data = $this -> upload -> data();
        		$row = $this -> Slideshow_model -> get_by_id($this -> input -> post('id'));
        		unlink($row -> img);
        		$data = array(
        			'img' => "assets/web/base/images/".$upload_data['file_name'],
        		);
        		$res = $this -> Slideshow_model -> update ($this -> input -> post('id'),$data);
        		if ($res >= 0) {
        			header('location:'.base_url().'index.php/Slideshow');
        		}
        	}
        }else{
        	$data = array(
        		'' => ''
        		);
        		$res = $this -> Slideshow_model -> update ($this -> input -> post('id'),$data);
        		if ($res >= 0 ) {
        			header('location:'.base_url('index.php/Slideshow'));
        		}
        }
	}
	public function hapus($id){
		$res = $this -> Slideshow_model -> delete($id);
		if($res){
		header('location:'.base_url('index.php/Slideshow'));
		}
		else{
			header('location:'.base_url('index.php/Slideshow'));
		}
	}
}
